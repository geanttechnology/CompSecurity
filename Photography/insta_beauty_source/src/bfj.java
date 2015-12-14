// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class bfj extends bfi
{

    private String a;
    private Paint b;
    private TextPaint c;
    private StaticLayout d;
    private String e;
    private float k;
    private float l;

    public bfj(bfg bfg1)
    {
        super(bfg1);
        a = "TDecorateTextRender";
        l = 0.0F;
        b = new Paint();
        b.setAntiAlias(true);
        Object obj;
        int i1;
        int j1;
        if (bfg1.t)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        j1 = i1;
        if (bfg1.E)
        {
            j1 = i1 | 2;
        }
        c = new TextPaint();
        c.setAntiAlias(true);
        c.setFlags(c.getFlags() | 0x100 | 0x80);
        obj = bfg1.v;
        if (bfg1.v == null || bfg1.v.length() == 0)
        {
            obj = "PTSans-Narrow";
            if (bfg1.E)
            {
                obj = "PTSans-Italic";
            }
        }
        obj = bew.a(((String) (obj)), j1);
        c.setTypeface(((android.graphics.Typeface) (obj)));
        l = a(bfg1.u) * TPhotoComposeInfo.scale * bfi.f();
        c.setTextSize(l);
        if (bfg1.B)
        {
            c.setShadowLayer(2.0F, 1.0F, 1.0F, Color.argb(126, 0, 0, 0));
        }
        k = c().width();
        a(a(bfg1));
    }

    private float a(float f)
    {
        return ((float)InstaBeautyApplication.a().b().getResources().getDisplayMetrics().densityDpi / 160F) * f;
    }

    private String a(bfg bfg1)
    {
        return a(bfg1, new Date());
    }

    public static String a(bfg bfg1, Date date)
    {
        String s = bfg1.x;
        if (bfg1.q == 2)
        {
            s = bfg1.x;
        } else
        {
            if (bfg1.q == 4)
            {
                return (new SimpleDateFormat("h:mm a", Locale.US)).format(date);
            }
            if (bfg1.q == 6)
            {
                return (new SimpleDateFormat("EEE, MMM d", Locale.US)).format(date);
            }
            if (bfg1.q == 8)
            {
                return (new SimpleDateFormat("MMM d, yyyy", Locale.US)).format(date);
            }
            if (bfg1.q == 11)
            {
                return (new SimpleDateFormat("MMM", Locale.US)).format(date);
            }
            if (bfg1.q == 13)
            {
                return (new SimpleDateFormat("yyyy", Locale.US)).format(date);
            }
            if (bfg1.q == 12)
            {
                return (new SimpleDateFormat("dd", Locale.US)).format(date);
            }
        }
        return s;
    }

    void a(Canvas canvas)
    {
        canvas.save();
        canvas.translate(TPhotoComposeInfo.scale * a().h.left, TPhotoComposeInfo.scale * a().h.top);
        canvas.concat(b());
        int i1 = a().c;
        b.setColor(Color.argb((int)((float)Color.alpha(i1) * 0.6F), Color.red(i1), Color.green(i1), Color.blue(i1)));
        b.setStyle(android.graphics.Paint.Style.FILL);
        canvas.drawRect(new RectF(0.0F, 0.0F, c().width(), c().height()), b);
        i1 = d.getHeight();
        canvas.translate(0.0F, (int)((c().height() - (float)i1) / 2.0F));
        c.setColor(a().y);
        d.draw(canvas);
        if (e())
        {
            b.setColor(-256);
            b.setStyle(android.graphics.Paint.Style.STROKE);
            canvas.drawRect(0.0F, 0.0F, k, d.getHeight(), b);
        }
        canvas.restore();
    }

    public void a(StaticLayout staticlayout)
    {
        d = staticlayout;
    }

    public void a(String s)
    {
        if (s == null)
        {
            e = "";
        } else
        {
            e = s;
        }
        s = android.text.Layout.Alignment.ALIGN_NORMAL;
        if (a().F != TPhotoMagComposeManager.UITextAlignmentLeft) goto _L2; else goto _L1
_L1:
        s = android.text.Layout.Alignment.ALIGN_NORMAL;
_L4:
        d = new StaticLayout(e, c, (int)k, s, 1.0F, 0.0F, false);
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

    public String g()
    {
        return e;
    }

    public float h()
    {
        return l;
    }

    protected TextPaint i()
    {
        return c;
    }

    public Paint j()
    {
        return b;
    }

    public StaticLayout k()
    {
        return d;
    }
}
