// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import java.util.Date;

public class rg extends rm
{

    private String a;
    private PorterDuffXfermode b;
    private Bitmap c;

    public rg(rj rj1)
    {
        super(rj1);
        a = "TDecorateHollowTextRender";
        b = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT);
        c = null;
        if (rj1.b())
        {
            a(new Date());
        }
    }

    private float a(Resources resources, String s, float f, float f1, float f2)
    {
        float f3 = (f1 + f2) / 2.0F;
        i().setTextSize(TypedValue.applyDimension(0, f3, resources.getDisplayMetrics()));
        float f4 = i().measureText(s);
        Log.v(a, (new StringBuilder()).append(a).append("low=").append(f1).append(" high=").append(f2).append(" mid=").append(f3).append(" target=").append(f).append(" width=").append(f4).toString());
        if (f2 - f1 < 0.5F)
        {
            return f1;
        }
        if (f4 > f)
        {
            return a(resources, s, f, f1, f3);
        }
        if (f4 < f)
        {
            return a(resources, s, f, f3, f2);
        } else
        {
            return f3;
        }
    }

    void a(Canvas canvas)
    {
        canvas.save();
        canvas.translate(TPhotoComposeInfo.scale * a().h.left, TPhotoComposeInfo.scale * a().h.top);
        canvas.concat(b());
        int i = a().c;
        j().setColor(Color.argb((int)((float)Color.alpha(i) * 0.6F), Color.red(i), Color.green(i), Color.blue(i)));
        j().setStyle(android.graphics.Paint.Style.FILL);
        canvas.drawRect(new RectF(0.0F, 0.0F, c().width(), c().height()), j());
        if (c != null && !c.isRecycled())
        {
            canvas.drawBitmap(c, 0.0F, 0.0F, null);
        }
        i = k().getHeight();
        canvas.translate(0.0F, (int)((c().height() - (float)i) / 2.0F));
        i().setColor(a().y);
        k().draw(canvas);
        i().setXfermode(null);
        canvas.restore();
    }

    public void a(String s)
    {
        super.a(s);
        i().setTextSize(h());
        float f1 = i().measureText(s);
        float f = c().width();
        Log.v(a, (new StringBuilder()).append(a).append(" getTextPaint width: ").append(f1).toString());
        Log.v(a, (new StringBuilder()).append(a).append(" getTextPaint drawWidth: ").append(f).toString());
        Log.v(a, (new StringBuilder()).append(a).append(" getTextPaint lines: ").append(a().G).toString());
        Resources resources = PIPCameraApplication.a.getResources();
        int i;
        int j;
        int k;
        if (a().G < 2)
        {
            if (f1 >= f)
            {
                float f2 = h();
                Log.v(a, (new StringBuilder()).append(a).append(" getTextPaint high: ").append(f2).toString());
                f2 = a(resources, s, f, 0.0F, f2);
                i().setTextSize(f2);
            } else
            {
                i().setTextSize(h());
            }
        }
        i = (int)f;
        k = (int)c().height();
        if (f < 1.0F)
        {
            i = 1;
        }
        j = k;
        if (k < 1)
        {
            j = 1;
        }
        c = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        s = new Canvas(c);
        i = a().c;
        j().setColor(Color.argb(Color.alpha(i), Color.red(i), Color.green(i), Color.blue(i)));
        j().setStyle(android.graphics.Paint.Style.FILL);
        s.drawRect(new RectF(0.0F, 0.0F, f, c().height()), j());
        j().setXfermode(null);
        s = android.text.Layout.Alignment.ALIGN_NORMAL;
        if (a().F != TPhotoMagComposeManager.UITextAlignmentLeft) goto _L2; else goto _L1
_L1:
        s = android.text.Layout.Alignment.ALIGN_NORMAL;
_L4:
        a(new StaticLayout(g(), i(), (int)f, s, 1.0F, 0.0F, false));
        return;
_L2:
        if (a().F == TPhotoMagComposeManager.UITextAlignmentCenter)
        {
            s = android.text.Layout.Alignment.ALIGN_CENTER;
        } else
        if (a().F == TPhotoMagComposeManager.UITextAlignmentRight)
        {
            s = android.text.Layout.Alignment.ALIGN_OPPOSITE;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(Date date)
    {
        a(a(a(), date));
    }
}
