package bsu.rfict.java.group7.lab3.Shirko;

import javax.swing.table.AbstractTableModel;
public class GornerTableModel extends AbstractTableModel {
    private  Double[] coefficients ;
    private Double to;
    private Double step;
    private Double from;
    private double result[] = new double[3];

    public GornerTableModel(Double from, Double to, Double step, Double[] coefficients)  //модели таблицы
    {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;

    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }
    public int getColumnCount() {
        // В данной модели 3 столбца
        return 4;
    }
    public int getRowCount() {
        // Вычислить количество точек между началом и концом отрезка
        // исходя из шага табулирования
        return new Double(Math.ceil((to-from)/step)).intValue()+1;
    }

    public Object getValueAt(int row, int col) {
        // Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
        double x = from + step * row;
        switch (col){
            case 0:
                return x;
            case 1:
            {
                result[0] = 0.0;
               // result[0] = Math.sin(x * coefficients.length);
               for(int i = 0; i < coefficients.length; i++){

                     result[0] += Math.pow(x, coefficients.length-1-i)*coefficients[i];
                }
                return result[0];
            }

            case 2: {

                if (result[0] > 0)
                {
                    return true;

                }else return false;

            }
            default:
            {
                if (result[0] == 0)
                    return "good";
                else return "pain";
            }

        }
    }
    public String getColumnName(int col)
    {
        switch(col)
        {
            case(0):
                return "Значение Х";
                case(1):
                    return "Значение многочлена";
                    case(2):
                        return "Значение больше нуля?";
                        default:
                            return "Life is ?";

        }
    }
    public Class<?> getColumnClass(int col) {
        // И в 1-ом и во 2-ом столбце находятся значения типа Double
        switch (col){
            case 0:
                return Double.class;
            case 1:
                return Double.class;
            case 2:
                return Boolean.class;
                default:
                    return String.class;

        }

    }

}

