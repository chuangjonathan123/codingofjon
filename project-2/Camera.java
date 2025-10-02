public class Camera 
{
    private String filmFormat;
    private int megaPixels;
    private int maxZoom;

    public Camera(String format, int zoom) 
    {
        filmFormat = format;
        maxZoom = zoom;
        megaPixels = 0; 
    }

    public Camera(int pixels, int zoom) 
    {
        megaPixels = pixels;
        maxZoom = zoom;
        filmFormat = null;
    }

    public String toString() 
    {
        return "This is a camera with a maxiumum zoom of : " + maxZoom;
    }
}
