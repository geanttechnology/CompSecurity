// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

public class bfl extends bfk
{

    public bfl(bfg bfg)
    {
        super(bfg);
    }

    protected void b(Canvas canvas)
    {
        super.b(canvas);
        if (a != null)
        {
            a.draw(canvas);
        }
        android.content.Context context = InstaBeautyApplication.a().b();
        if (e != null && e.length() > 0)
        {
            m = new StaticLayout(e, d, (int)((float)axw.a(context, 32F) * TPhotoComposeInfo.scale), android.text.Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
            canvas.translate(TPhotoComposeInfo.scale * 47F, 0.0F);
            m.draw(canvas);
            canvas.translate(-47F * TPhotoComposeInfo.scale, 0.0F);
        }
        if (l != null && l.length() > 0)
        {
            n = new StaticLayout(l, k, (int)((float)axw.a(context, 32F) * TPhotoComposeInfo.scale), android.text.Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
            canvas.translate(TPhotoComposeInfo.scale * 47F, 21F * TPhotoComposeInfo.scale);
            n.draw(canvas);
        }
    }

    void g()
    {
        android.content.Context context = InstaBeautyApplication.a().b();
        b = new Rect(0, 0, (int)(40F * TPhotoComposeInfo.scale), (int)(40F * TPhotoComposeInfo.scale));
        android.graphics.Typeface typeface = bew.a("PTSans-NarrowBold", 1);
        d = new TextPaint();
        d.setAntiAlias(true);
        d.setFlags(d.getFlags() | 0x100 | 0x80);
        d.setTypeface(typeface);
        d.setColor(-1);
        d.setTextSize((float)axw.a(context, 20F) * TPhotoComposeInfo.scale * bfi.f());
        d.setShadowLayer(2.0F, 0.0F, 1.0F, Color.argb(128, 0, 0, 0));
        d.setTextAlign(android.graphics.Paint.Align.LEFT);
        k = new TextPaint();
        k.setAntiAlias(true);
        k.setFlags(k.getFlags() | 0x100 | 0x80);
        typeface = bew.a("PTSans-Narrow", 0);
        k.setTypeface(typeface);
        k.setColor(-1);
        k.setTextSize((float)axw.a(context, 14F) * TPhotoComposeInfo.scale * bfi.f());
        k.setShadowLayer(2.0F, 0.0F, 1.0F, Color.argb(128, 0, 0, 0));
        k.setTextAlign(android.graphics.Paint.Align.LEFT);
        h();
        i();
        j();
    }
}
