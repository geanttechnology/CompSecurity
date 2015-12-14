// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.socialin.android.picsart.upload.UploadItem;
import com.socialin.android.util.w;
import java.io.File;

public final class a extends Drawable
{

    private UploadItem a;
    private int b;
    private float c;
    private float d;
    private Paint e;
    private Bitmap f;
    private Context g;

    public a(Context context, UploadItem uploaditem, int i, float f1, float f2)
    {
        g = context;
        a = uploaditem;
        b = i;
        c = f1;
        d = f2;
        e = new Paint(3);
    }

    public final void draw(Canvas canvas)
    {
        Object obj;
        Object obj1;
        if (f != null && !f.isRecycled())
        {
            break MISSING_BLOCK_LABEL_303;
        }
        obj = a;
        obj1 = g.getExternalFilesDir(null);
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        obj1 = new File(((File) (obj1)), "upload");
        if (!((File) (obj1)).exists()) goto _L2; else goto _L3
_L3:
        obj = new File(((File) (obj1)), (new StringBuilder()).append(((UploadItem) (obj)).j).append("_image").toString());
_L5:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_303;
        }
        f = w.b(((File) (obj)).getPath(), getBounds().width());
        if (f == null)
        {
            break MISSING_BLOCK_LABEL_303;
        }
        obj = new Paint(1);
        ((Paint) (obj)).setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        ((Paint) (obj)).setStyle(android.graphics.Paint.Style.FILL);
        obj1 = new Canvas(f);
        ((Canvas) (obj1)).saveLayer(0.0F, 0.0F, f.getWidth(), f.getHeight(), null, 31);
        ((Canvas) (obj1)).drawColor(0xccffffff);
        float f1 = ((float)getBounds().width() - (float)b * c * 2.0F) / (float)(b + 1);
        for (int i = 0; i < b; i++)
        {
            ((Canvas) (obj1)).drawCircle((float)(i + 1) * f1 + (float)(i * 2 + 1) * c, (float)getBounds().width() / 2.0F, c + d, ((Paint) (obj)));
        }

        break; /* Loop/switch isn't completed */
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
        ((Canvas) (obj1)).restore();
        if (f != null && !f.isRecycled())
        {
            canvas.drawBitmap(f, 0.0F, 0.0F, e);
        }
        return;
    }

    public final int getOpacity()
    {
        return 255;
    }

    public final void setAlpha(int i)
    {
    }

    public final void setColorFilter(ColorFilter colorfilter)
    {
    }
}
