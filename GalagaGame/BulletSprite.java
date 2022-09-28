import java.awt.Image;

public class BulletSprite extends Sprite { // 불꽃 발사를 다루기 위한 클래스
    private GalagaGame game;

    public BulletSprite(GalagaGame game, Image image, int x, int y) {
        super(image, x, y);
        this.game = game;
        dy = -3;

    }

    @Override
    public void move() { // 불꽃의 움직임을 처리
        super.move();
        if (y < -5) {
            game.removeSprite(this);
        }
    }

    @Override
    public void handleCollision(Sprite other) { // 충돌이 발생하면 호출
        if (other instanceof StarShipSprite) { // 이 객체와 충돌한 것이 꿀벌객체면
            game.removeSprite(other); // 꿀벌 객체를 지우고
            game.removeSprite(this); // 미사일 이미지도 지움

        }
    }
}