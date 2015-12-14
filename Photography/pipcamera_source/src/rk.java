// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

public class rk extends rl
{

    protected BitmapDrawable a;
    protected Rect b;
    protected TextPaint c;
    protected String d;
    protected StaticLayout e;
    private String k;

    public rk(rj rj1)
    {
        super(rj1);
        k = "TDecorateLocationRender";
        d = "";
        g();
    }

    private void g()
    {
        Context context = PIPCameraApplication.a;
        b = new Rect(0, 0, (int)(10F * TPhotoComposeInfo.scale), (int)(15F * TPhotoComposeInfo.scale));
        android.graphics.Typeface typeface = rc.a("PTSans-Narrow", 1);
        c = new TextPaint(384);
        c.setAntiAlias(true);
        c.setTypeface(typeface);
        c.setColor(-1);
        c.setTextSize((float)pb.a(context, 14F) * TPhotoComposeInfo.scale * rl.f());
        c.setShadowLayer(2.0F, 0.0F, 1.0F, Color.argb(128, 0, 0, 0));
        c.setTextAlign(android.graphics.Paint.Align.LEFT);
    }

    void a(Canvas canvas)
    {
        canvas.save();
        canvas.translate(TPhotoComposeInfo.scale * a().h.left, TPhotoComposeInfo.scale * a().h.top);
        canvas.concat(b());
        b(canvas);
        canvas.restore();
    }

    public void a(jl jl1)
    {
        if (jl1 == null)
        {
            return;
        }
        android.graphics.drawable.Drawable drawable = PIPCameraApplication.a.getResources().getDrawable(0x7f02020c);
        if (drawable instanceof BitmapDrawable)
        {
            a = (BitmapDrawable)drawable;
            a.setDither(true);
            a.setFilterBitmap(true);
            a.setBounds(b);
        }
        jl1 = (new StringBuilder()).append(String.format("%.2f", new Object[] {
            Double.valueOf(jl1.c().b())
        })).append(",").append(String.format("%.2f", new Object[] {
            Double.valueOf(jl1.c().a())
        })).toString();
        Log.v(k, (new StringBuilder()).append(k).append("DECORATE_TYPE_LATITUDE:").append(jl1).toString());
        d = jl1;
    }

    protected void b(Canvas canvas)
    {
        if (a != null)
        {
            int i = b.width();
            i = (int)((c().height() - (float)i) / 2.0F) - 2;
            canvas.translate(0.0F, i);
            a.draw(canvas);
            canvas.translate(0.0F, -i);
        }
        if (d != null && d.length() > 0)
        {
            e = new StaticLayout(d, c, (int)(c().width() - 10F * TPhotoComposeInfo.scale), android.text.Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
            int j = e.getHeight();
            j = (int)((c().height() - (float)j) / 2.0F);
            canvas.translate(12F * TPhotoComposeInfo.scale, j);
            e.draw(canvas);
        }
    }
}
