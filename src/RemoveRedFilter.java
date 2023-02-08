import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

// ZADANIE 2: zrób kopię tego pliku, nadaj mu własną nazwę
// i zaimplementuj swoje przekształcenie obrazka w metodzie "actionPerformed"
public class RemoveRedFilter implements ActionListener {

    private View view;

    RemoveRedFilter(View view) {
        super();
        this.view = view;
    }

    public void actionPerformed(ActionEvent e)
    {
        BufferedImage oldImage = this.view.getInputFile();
        int width = oldImage.getWidth();
        int height = oldImage.getHeight();
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = oldImage.getRGB(x, y);
                Color original = new Color(rgb);
                int r = original.getRed();
                int g = original.getGreen();
                int b = original.getBlue();
                Color target = new Color(0, g, b);
                newImage.setRGB(x, y, target.getRGB());
            }
        }

        this.view.displayImage(newImage);
    }

}