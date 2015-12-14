// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.io.IOException;
import java.io.InputStream;

public abstract class rn extends rl
{

    protected BitmapDrawable a;
    protected Rect b;
    protected String c;
    protected TextPaint d;
    protected String e;
    protected TextPaint k;
    protected String l;
    protected StaticLayout m;
    protected StaticLayout n;
    private String o;

    public rn(rj rj1)
    {
        super(rj1);
        o = "TDecorateWeatherRender";
        c = "";
        e = "";
        l = "";
        g();
    }

    public Bitmap a(String s)
    {
        Object obj;
        Bitmap bitmap;
        Object obj1;
        obj1 = null;
        obj = null;
        bitmap = ((Bitmap) (obj));
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.length() != 0) goto _L4; else goto _L3
_L3:
        bitmap = ((Bitmap) (obj));
_L2:
        return bitmap;
_L4:
        obj = PIPCameraApplication.a.getAssets();
        s = ((AssetManager) (obj)).open((new StringBuilder()).append("weather/").append(s).append(".png").toString());
        String s1;
        obj = obj1;
        s1 = s;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        obj = BitmapFactory.decodeStream(s);
        s1 = s;
_L6:
        bitmap = ((Bitmap) (obj));
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                Crashlytics.logException(s);
                return ((Bitmap) (obj));
            }
            return ((Bitmap) (obj));
        }
        if (true) goto _L2; else goto _L5
_L5:
        IOException ioexception;
        ioexception;
        s = null;
_L7:
        ioexception.printStackTrace();
        Crashlytics.logException(ioexception);
        ioexception = obj1;
        s1 = s;
          goto _L6
        ioexception;
          goto _L7
    }

    void a(Canvas canvas)
    {
        canvas.save();
        canvas.translate(TPhotoComposeInfo.scale * a().h.left, TPhotoComposeInfo.scale * a().h.top);
        canvas.concat(b());
        b(canvas);
        canvas.restore();
    }

    public void a(pp pp1)
    {
        if (pp1 == null)
        {
            return;
        }
        Context context = PIPCameraApplication.a;
        if (pp1.c != null)
        {
            Log.v(o, (new StringBuilder()).append(o).append(" icon :").append(pp1.c).toString());
            a = new BitmapDrawable(context.getResources(), a(pp1.c));
            a.setDither(true);
            a.setFilterBitmap(true);
            a.setBounds(b);
        }
        c = pp1.d;
        e = String.format("%d\u2103", new Object[] {
            Integer.valueOf((int)pp1.g)
        });
        l = String.format("%.1fkm/h", new Object[] {
            Float.valueOf(pp1.j)
        });
    }

    protected void b(Canvas canvas)
    {
    }

    abstract void g();

    public void h()
    {
        Bitmap bitmap = a("clear");
        if (bitmap != null)
        {
            a = new BitmapDrawable(PIPCameraApplication.a.getResources(), bitmap);
            a.setDither(true);
            a.setFilterBitmap(true);
            a.setBounds(b);
        }
    }

    public void i()
    {
        e = "18\u2103";
    }

    public void j()
    {
        l = "2.0fkm/h";
    }
}
