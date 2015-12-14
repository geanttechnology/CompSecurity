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
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.io.IOException;
import java.io.InputStream;

public abstract class bfk extends bfi
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

    public bfk(bfg bfg1)
    {
        super(bfg1);
        o = "TDecorateWeatherRender";
        c = "";
        e = "";
        l = "";
        g();
    }

    public Bitmap a(String s)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = obj1;
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.length() != 0) goto _L4; else goto _L3
_L3:
        obj = obj1;
_L2:
        return ((Bitmap) (obj));
_L4:
        obj = InstaBeautyApplication.a().b().getAssets();
        obj = ((AssetManager) (obj)).open((new StringBuilder()).append("weather/").append(s).append(".png").toString());
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        obj1 = BitmapFactory.decodeStream(((InputStream) (obj)));
_L7:
        Log.v("TESTTTTTTT", (new StringBuilder()).append("MARK:weather/").append(s).append(".png").toString());
        s = ((String) (obj1));
        obj1 = obj;
_L5:
        obj = s;
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
                Crashlytics.logException(((Throwable) (obj)));
                return s;
            }
            return s;
        }
          goto _L2
        obj1;
        obj = null;
        s = null;
_L6:
        Crashlytics.logException(((Throwable) (obj1)));
        ((IOException) (obj1)).printStackTrace();
        obj1 = s;
        s = ((String) (obj));
          goto _L5
        obj1;
        s = ((String) (obj));
        obj = null;
          goto _L6
        IOException ioexception;
        ioexception;
        Object obj2 = obj1;
        s = ((String) (obj));
        obj1 = ioexception;
        obj = obj2;
          goto _L6
        obj1 = null;
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

    public void a(ayu ayu1)
    {
        if (ayu1 == null)
        {
            return;
        }
        Context context = InstaBeautyApplication.a().b();
        if (ayu1.c != null)
        {
            Log.v(o, (new StringBuilder()).append(o).append(" icon :").append(ayu1.c).toString());
            a = new BitmapDrawable(context.getResources(), a(ayu1.c));
            a.setDither(true);
            a.setFilterBitmap(true);
            a.setBounds(b);
        }
        c = ayu1.d;
        e = String.format("%d\u2103", new Object[] {
            Integer.valueOf((int)ayu1.g)
        });
        l = String.format("%.1fkm/h", new Object[] {
            Float.valueOf(ayu1.j)
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
            a = new BitmapDrawable(InstaBeautyApplication.a().b().getResources(), bitmap);
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
