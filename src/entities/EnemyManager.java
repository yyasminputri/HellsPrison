package entities;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import gamestates.Playing;
import levels.Level;
import utilz.LoadSave;
import static utilz.Constants.EnemyConstants.*;

public class EnemyManager {

	private Playing playing;
	private BufferedImage[][] skeletonArr, monsterArr;
	private Level currentLevel;

	public EnemyManager(Playing playing) {
		this.playing = playing;
		loadEnemyImgs();
	}

	public void loadEnemies(Level level) {
		this.currentLevel = level;
	}

	public void update(int[][] lvlData) {
		boolean isAnyActive = false;
		for (Skeleton c : currentLevel.getSkels())
			if (c.isActive()) {
				c.update(lvlData, playing);
				isAnyActive = true;
			}

		for (Monster s : currentLevel.getMonsters())
			if (s.isActive()) {
				s.update(lvlData, playing);
				isAnyActive = true;
			}

		if (!isAnyActive)
			playing.setLevelCompleted(true);
	}

	public void draw(Graphics g, int xLvlOffset) {
		drawSkels(g, xLvlOffset);
		drawMonsters(g, xLvlOffset);
	}

	private void drawMonsters(Graphics g, int xLvlOffset) {
		for (Monster s : currentLevel.getMonsters())
			if (s.isActive()) {
				g.drawImage(monsterArr[s.getState()][s.getAniIndex()], (int) s.getHitbox().x - xLvlOffset - MONSTER_DRAWOFFSET_X + s.flipX(),
						(int) s.getHitbox().y - MONSTER_DRAWOFFSET_Y + (int) s.getPushDrawOffset(), MONSTER_WIDTH * s.flipW(), MONSTER_HEIGHT, null);
			}
	}


	private void drawSkels(Graphics g, int xLvlOffset) {
		for (Skeleton c : currentLevel.getSkels())
			if (c.isActive()) {

				g.drawImage(skeletonArr[c.getState()][c.getAniIndex()], (int) c.getHitbox().x - xLvlOffset - SKELETON_DRAWOFFSET_X + c.flipX(),
						(int) c.getHitbox().y - SKELETON_DRAWOFFSET_Y + (int) c.getPushDrawOffset(), SKELETON_WIDTH * c.flipW(), SKELETON_HEIGHT, null);
			}

	}

	public void checkEnemyHit(Rectangle2D.Float attackBox) {
		for (Skeleton c : currentLevel.getSkels())
			if (c.isActive())
				if (c.getState() != DEAD && c.getState() != HIT)
					if (attackBox.intersects(c.getHitbox())) {
						c.hurt(20);
						return;
					}

		for (Monster s : currentLevel.getMonsters())
			if (s.isActive()) {
				if (s.getState() != DEAD && s.getState() != HIT)
					if (attackBox.intersects(s.getHitbox())) {
						s.hurt(20);
						return;
					}
			}
	}

	private void loadEnemyImgs() {
		skeletonArr = getImgArr(LoadSave.GetSpriteAtlas(LoadSave.SKELETON_SPRITE), 9, 5, SKELETON_WIDTH_DEFAULT, SKELETON_HEIGHT_DEFAULT);
		monsterArr = getImgArr(LoadSave.GetSpriteAtlas(LoadSave.MONSTER_ATLAS), 8, 5, MONSTER_WIDTH_DEFAULT, MONSTER_HEIGHT_DEFAULT);
	}

	private BufferedImage[][] getImgArr(BufferedImage atlas, int xSize, int ySize, int spriteW, int spriteH) {
		BufferedImage[][] tempArr = new BufferedImage[ySize][xSize];
		for (int j = 0; j < tempArr.length; j++)
			for (int i = 0; i < tempArr[j].length; i++)
				tempArr[j][i] = atlas.getSubimage(i * spriteW, j * spriteH, spriteW, spriteH);
		return tempArr;
	}

	public void resetAllEnemies() {
		for (Skeleton c : currentLevel.getSkels())
			c.resetEnemy();
		for (Monster s : currentLevel.getMonsters())
			s.resetEnemy();
	}

}
