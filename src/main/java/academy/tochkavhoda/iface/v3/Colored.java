package academy.tochkavhoda.iface.v3;

import academy.tochkavhoda.colors.Color;
import academy.tochkavhoda.colors.ColorException;

public interface Colored {
    Color getColor();
    void setColor(Color color) throws ColorException;

    /**
     * Устанавливает цвет по текстовой строке
     * @param colorString строковое представление цвета
     * @throws ColorException если передана недопустимая строка (null или несоответствие цвету)
     */
    void setColor(String colorString) throws ColorException;
}
