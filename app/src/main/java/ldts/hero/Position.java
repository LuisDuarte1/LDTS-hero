package ldts.hero;

public class Position {
    private int x;
    private int y;

    Position(int _x, int _y){x = _x; y = _y;}


    public int getX(){return x;}

    public int getY(){return y;}

    public Position moveLeft(){return new Position(x-1, y);}

    public Position moveRight(){return new Position(x+1, y);}

    public Position moveDown(){return new Position(x, y+1);}

    public Position moveUp(){return new Position(x, y-1);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Position p = (Position) o;
        return x == p.getX() && y == p.getY();
    }


}
