package utilz;

import main.Game;

public class Constants {

	public static final float GRAVITY = 0.04f * Game.SCALE;
	public static final int ANI_SPEED = 25;

	public static class ObjectConstants {

		public static final int BARREL = 2;
		public static final int BOX = 3;
		public static final int SPIKE = 4;

		public static final int SPIKE_WIDTH_DEFAULT = 32;
		public static final int SPIKE_HEIGHT_DEFAULT = 32;
		public static final int SPIKE_WIDTH = (int) (Game.SCALE * SPIKE_WIDTH_DEFAULT);
		public static final int SPIKE_HEIGHT = (int) (Game.SCALE * SPIKE_HEIGHT_DEFAULT);

		public static int GetSpriteAmount(int object_type) {
			switch (object_type) {
			case BARREL, BOX:
				return 8;
			}
			return 1;
		}
	}

	public static class EnemyConstants {
		public static final int SKELETON = 0;
		public static final int MONSTER = 2;

		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int ATTACK = 2;
		public static final int HIT = 3;
		public static final int DEAD = 4;

		public static final int SKELETON_WIDTH_DEFAULT = 72;
		public static final int SKELETON_HEIGHT_DEFAULT = 32;
		public static final int SKELETON_WIDTH = (int) (SKELETON_WIDTH_DEFAULT * Game.SCALE);
		public static final int SKELETON_HEIGHT = (int) (SKELETON_HEIGHT_DEFAULT * Game.SCALE);
		public static final int SKELETON_DRAWOFFSET_X = (int) (26 * Game.SCALE);
		public static final int SKELETON_DRAWOFFSET_Y = (int) (9 * Game.SCALE);

		public static final int MONSTER_WIDTH_DEFAULT = 34;
		public static final int MONSTER_HEIGHT_DEFAULT = 30;
		public static final int MONSTER_WIDTH = (int) (MONSTER_WIDTH_DEFAULT * Game.SCALE);
		public static final int MONSTER_HEIGHT = (int) (MONSTER_HEIGHT_DEFAULT * Game.SCALE);
		public static final int MONSTER_DRAWOFFSET_X = (int) (8 * Game.SCALE);
		public static final int MONSTER_DRAWOFFSET_Y = (int) (6 * Game.SCALE);

		public static int GetSpriteAmount(int enemy_type, int enemy_state) {
			switch (enemy_state) {

			case IDLE: {
				if (enemy_type == SKELETON)
					return 9;
				else if (enemy_type == MONSTER)
					return 8;
			}
			case RUNNING:
				return 6;
			case ATTACK:
				if (enemy_type == MONSTER)
					return 8;
				return 7;
			case HIT:
				return 4;
			case DEAD:
				return 5;
			}

			return 0;

		}

		public static int GetMaxHealth(int enemy_type) {
			switch (enemy_type) {
			case SKELETON:
				return 50;
			case MONSTER:
				return 25;
			default:
				return 1;
			}
		}

		public static int GetEnemyDmg(int enemy_type) {
			switch (enemy_type) {
			case SKELETON:
				return 15;
			case MONSTER:
				return 25;
			default:
				return 0;
			}
		}
	}

	public static class Environment {
		public static final int BG_2_WIDTH_DEFAULT = 448;
		public static final int BG_2_HEIGHT_DEFAULT = 303;
		public static final int BG_3_WIDTH_DEFAULT = 2000;
		public static final int BG_3_HEIGHT_DEFAULT = 350;

		public static final int BG_2_WIDTH = (int) (BG_2_WIDTH_DEFAULT * Game.SCALE);
		public static final int BG_2_HEIGHT = (int) (BG_2_HEIGHT_DEFAULT * Game.SCALE);
		public static final int BG_3_WIDTH = (int) (BG_3_WIDTH_DEFAULT * Game.SCALE);
		public static final int BG_3_HEIGHT = (int) (BG_3_HEIGHT_DEFAULT * Game.SCALE);
	}

	public static class UI {
		public static class Buttons {
			public static final int B_WIDTH_DEFAULT = 140;
			public static final int B_HEIGHT_DEFAULT = 56;
			public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
			public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
		}

		public static class PauseButtons {
			public static final int SOUND_SIZE_DEFAULT = 42;
			public static final int SOUND_SIZE = (int) (SOUND_SIZE_DEFAULT * Game.SCALE);
		}

		public static class URMButtons {
			public static final int URM_DEFAULT_SIZE = 56;
			public static final int URM_SIZE = (int) (URM_DEFAULT_SIZE * Game.SCALE);

		}

		public static class VolumeButtons {
			public static final int VOLUME_DEFAULT_WIDTH = 28;
			public static final int VOLUME_DEFAULT_HEIGHT = 44;
			public static final int SLIDER_DEFAULT_WIDTH = 215;

			public static final int VOLUME_WIDTH = (int) (VOLUME_DEFAULT_WIDTH * Game.SCALE);
			public static final int VOLUME_HEIGHT = (int) (VOLUME_DEFAULT_HEIGHT * Game.SCALE);
			public static final int SLIDER_WIDTH = (int) (SLIDER_DEFAULT_WIDTH * Game.SCALE);
		}
	}

	public static class Directions {
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}

	public static class PlayerConstants {
		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int JUMP = 2;
		public static final int FALLING = 3;
		public static final int ATTACK = 4;
		public static final int HIT = 5;
		public static final int DEAD = 6;

		public static int GetSpriteAmount(int player_action) {
			switch (player_action) {
			case DEAD:
				return 8;
			case RUNNING:
				return 6;
			case IDLE:
				return 5;
			case HIT:
				return 4;
			case JUMP:
			case ATTACK:
				return 3;
			case FALLING:
			default:
				return 1;
			}
		}
	}

}