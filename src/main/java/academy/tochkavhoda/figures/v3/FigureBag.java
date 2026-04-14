package academy.tochkavhoda.figures.v3;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

public class FigureBag {
    private Bag<Figure> bag;

    public FigureBag() {
        this.bag = new HashBag<>();
    }

    public void addFigure(Figure figure) {
        if (figure != null) {
            bag.add(figure);
        }
    }

    public void addFigure(Figure figure, int copies) {
        if (figure != null && copies > 0) {
            bag.add(figure, copies);
        }
    }

    public boolean removeFigure(Figure figure) {
        if (figure == null) {
            return false;
        }
        int count = bag.getCount(figure);
        if (count > 0) {
            bag.remove(figure, count);
            return true;
        }
        return false;
    }

    public boolean removeFigure(Figure figure, int copies) {
        if (figure == null || copies <= 0) {
            return false;
        }
        int currentCount = bag.getCount(figure);
        if (currentCount > 0) {
            int toRemove = Math.min(copies, currentCount);
            bag.remove(figure, toRemove);
            return true;
        }
        return false;
    }

    public int getFigureCopies(Figure figure) {
        if (figure == null) {
            return 0;
        }
        return bag.getCount(figure);
    }


    // Возвращает общее количество фигур (с учетом копий)
    public int getTotalFiguresCount() {
        return bag.size();
    }

    // Возвращает количество уникальных фигур
    public int getUniqueFiguresCount() {
        return bag.uniqueSet().size();
    }

    // Возвращает множество уникальных фигур
    public java.util.Set<Figure> getUniqueFigures() {
        return bag.uniqueSet();
    }

    // Очищает все фигуры
    public void clear() {
        bag.clear();
    }

    // Проверяет, пуст ли Bag
    public boolean isEmpty() {
        return bag.isEmpty();
    }

    // Удаляет одну копию фигуры
    public boolean removeOneCopy(Figure figure) {
        if (figure == null) {
            return false;
        }
        int currentCount = bag.getCount(figure);
        if (currentCount > 0) {
            bag.remove(figure, 1);
            return true;
        }
        return false;
    }
}