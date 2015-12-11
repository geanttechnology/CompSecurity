// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

// Referenced classes of package netswipe:
//            bj, bk

public class bi
{

    private static int a = 10;
    private int b;
    private int c;
    private int d;
    private int e;
    private Bitmap f;
    private Paint g;
    private ImageView h;
    private ImageView i;
    private AlphaAnimation j;
    private AlphaAnimation k;

    public bi(Bitmap bitmap, ImageView imageview, ImageView imageview1, float f1)
    {
        b = 0;
        c = b / 2;
        d = 24;
        e = 0;
        f = bitmap;
        h = imageview;
        i = imageview1;
        g = new Paint();
        g.setMaskFilter(new BlurMaskFilter((float)d * f1 + 0.5F, android.graphics.BlurMaskFilter.Blur.SOLID));
        bitmap = Bitmap.createBitmap(f.getWidth() + b, f.getHeight() + b, android.graphics.Bitmap.Config.ARGB_8888);
        (new Canvas(bitmap)).drawBitmap(f, c, c, null);
        h.setImageBitmap(bitmap);
        j = new AlphaAnimation(0.0F, 1.0F);
        k = new AlphaAnimation(1.0F, 0.0F);
        j.setDuration(350L);
        k.setDuration(350L);
        j.setAnimationListener(new bj(this));
        k.setAnimationListener(new bk(this));
    }

    static int a(bi bi1)
    {
        int l = bi1.e;
        bi1.e = l + 1;
        return l;
    }

    static int b(bi bi1)
    {
        return bi1.e;
    }

    static int c()
    {
        return a;
    }

    static AlphaAnimation c(bi bi1)
    {
        return bi1.k;
    }

    static ImageView d(bi bi1)
    {
        return bi1.i;
    }

    static AlphaAnimation e(bi bi1)
    {
        return bi1.j;
    }

    public void a()
    {
        e = a;
    }

    public void a(int l)
    {
        g.setColor(l);
        Bitmap bitmap = Bitmap.createBitmap(f.getWidth() + b, f.getHeight() + b, android.graphics.Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(0);
        (new Canvas(bitmap)).drawBitmap(f.extractAlpha(), c, c, g);
        i.setImageBitmap(bitmap);
        i.setVisibility(4);
    }

    public void b()
    {
        e = 0;
        i.startAnimation(j);
    }

}
