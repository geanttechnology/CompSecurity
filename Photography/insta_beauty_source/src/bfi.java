// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.compose.FlipViewType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

public abstract class bfi
{

    private bfg a;
    private Matrix b;
    private RectF c;
    private int d;
    private boolean e;
    public FlipViewType f;
    public float g;
    public float h;
    public float i;
    public float j;

    public bfi(bfg bfg1)
    {
        b = new Matrix();
        c = new RectF();
        d = 0;
        e = false;
        f = FlipViewType.FLIP_NORMAL;
        g = 0.0F;
        h = 0.0F;
        a = bfg1;
        i = TPhotoComposeInfo.scale * a().h.left;
        j = TPhotoComposeInfo.scale * a().h.top;
        b = bfg1.d();
        a(bfg1.g);
    }

    public static float f()
    {
        float f1;
        float f2;
        float f3;
        float f4;
        float f5;
        f2 = 0.65F;
        DisplayMetrics displaymetrics = InstaBeautyApplication.a().b().getResources().getDisplayMetrics();
        f3 = displaymetrics.density;
        int k = displaymetrics.densityDpi;
        f1 = displaymetrics.xdpi;
        float f6 = displaymetrics.ydpi;
        f4 = displaymetrics.widthPixels;
        f5 = displaymetrics.heightPixels;
        Log.v((new StringBuilder()).append("TDecorateRender getFontScaleByScreen").append("  DisplayMetrics").toString(), (new StringBuilder()).append("xdpi=").append(f1).append("; ydpi=").append(f6).toString());
        Log.v((new StringBuilder()).append("TDecorateRender getFontScaleByScreen").append("  DisplayMetrics").toString(), (new StringBuilder()).append("density=").append(f3).append("; densityDPI=").append(k).toString());
        Log.v((new StringBuilder()).append("TDecorateRender getFontScaleByScreen").append("  screenWidth ").toString(), String.format("%f", new Object[] {
            Float.valueOf(f4)
        }));
        Log.v((new StringBuilder()).append("TDecorateRender getFontScaleByScreen").append("  screenHeight ").toString(), String.format("%f", new Object[] {
            Float.valueOf(f5)
        }));
        Log.v("TDecorateRender getFontScaleByScreen", (new StringBuilder()).append("TDecorateRender getFontScaleByScreen").append(" model :").append(Build.MODEL).append(" ").append(Build.MANUFACTURER).toString());
        f1 = displaymetrics.density;
        if ((double)f1 > 2.1000000000000001D) goto _L2; else goto _L1
_L1:
label0:
        {
            if ((double)(f4 / f5) > 0.66000000000000003D)
            {
                f2 = 0.5F;
            }
            if (f4 != 720F)
            {
                f1 = f2;
                if (f4 != 800F)
                {
                    break label0;
                }
            }
            f1 = f2;
            if (f5 == 1280F)
            {
                f1 = 0.45F;
            }
        }
        f2 = f1;
        if (f4 == 320F)
        {
            f2 = f1;
            if (f5 == 480F)
            {
                f2 = f1;
                if ((double)f3 == 1.0D)
                {
                    f2 = 1.0F;
                }
            }
        }
        InstaBeautyApplication.a();
        if (InstaBeautyApplication.d())
        {
            f2 = 1.3F;
        }
_L4:
        return f2;
_L2:
        if ((double)f1 > 2.1000000000000001D)
        {
            return 0.3F;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public bfg a()
    {
        return a;
    }

    public void a(int k)
    {
        d = k;
    }

    public abstract void a(Canvas canvas);

    public void a(RectF rectf)
    {
        c = rectf;
    }

    public void a(boolean flag)
    {
        e = flag;
    }

    public boolean a(float f1, float f2)
    {
        Matrix matrix = new Matrix();
        float af[] = new float[2];
        af[0] = f1 - d().left;
        af[1] = f2 - d().top;
        b.invert(matrix);
        matrix.mapPoints(af);
        return c().contains(af[0], af[1]);
    }

    public Matrix b()
    {
        return b;
    }

    public RectF c()
    {
        return TPhotoComposeInfo.getScaledRect(c);
    }

    public RectF d()
    {
        return TPhotoComposeInfo.getScaledRect(a.h);
    }

    public boolean e()
    {
        return e;
    }
}
