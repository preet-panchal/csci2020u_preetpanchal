package csci2020u.lab09;

import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class Controller {

    @FXML private Canvas canvas;
    private float[] AAPL;
    private float[] GOOG;

    private int x = 800;
    private int y = 700;

    private float maxValue = 0.0000f;
    private double width;
    private double height;

    @FXML
    public void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        GetStock apple = new GetStock("AAPL");
        GetStock.downloadStockPrices();
        AAPL = GetStock.getClosingVal();

        GetStock google = new GetStock("GOOG");
        GetStock.downloadStockPrices();
        GOOG = GetStock.getClosingVal();

        plotLine(gc);
        drawLinePlot(gc);
    }

    public void plotLine(GraphicsContext gc) {
        for (float v : AAPL) {
            if (v > maxValue) {
                maxValue = v;
            }
        }

        for (float v : GOOG) {
            if (v > maxValue) {
                maxValue = v;
            }
        }

        width = (x - 100) / (GOOG.length + 1);
        height = (y - 100) / maxValue;

        gc.strokeLine(50, 50, 50, y - 50);
        gc.strokeLine(50, y - 50, x - 50, y - 50);
    }

    private void drawLinePlot(GraphicsContext gc) {
        double start = 50;
        gc.setStroke(Color.BLUE);

        for (int x = 0; x < AAPL.length - 1; x++) {
            gc.strokeLine(start, (y - 50) - (AAPL[x] * height), (start + width), (y - 50) - (AAPL [x+1] * height));
            start = start + width;
        }
        start = 50;

        gc.setStroke(Color.RED);

        for (int x = 0; x < GOOG.length - 1; x++) {
            gc.strokeLine(start, (y - 50) - (GOOG[x] * height), (start + width), (y - 50) - (GOOG [x+1] * height));
            start = start + width;
        }
    }
}
