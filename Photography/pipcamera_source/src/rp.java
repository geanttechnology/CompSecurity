// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

public class rp extends rn
{

    public rp(rj rj)
    {
        super(rj);
    }

    protected void b(Canvas canvas)
    {
        super.b(canvas);
        if (a != null)
        {
            int i = b.width();
            i = (int)((c().width() - (float)i) / 2.0F);
            canvas.translate(i, 0.0F);
            a.draw(canvas);
            canvas.translate(-i, 0.0F);
        }
        if (e != null && e.length() > 0)
        {
            m = new StaticLayout(e, d, (int)c().width(), android.text.Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
            canvas.translate(0.0F, 38F * TPhotoComposeInfo.scale);
            m.draw(canvas);
        }
    }

    void g()
    {
        android.content.Context context = PIPCameraApplication.a;
        b = new Rect(0, 0, (int)(TPhotoComposeInfo.scale * 40F), (int)(TPhotoComposeInfo.scale * 40F));
        android.graphics.Typeface typeface = rc.a("PTSans-NarrowBold", 1);
        d = new TextPaint(384);
        d.setAntiAlias(true);
        d.setTypeface(typeface);
        d.setColor(-1);
        d.setTextSize((float)pb.a(context, 20F) * TPhotoComposeInfo.scale * rl.f());
        d.setShadowLayer(2.0F, 0.0F, 1.0F, Color.argb(128, 0, 0, 0));
        d.setTextAlign(android.graphics.Paint.Align.LEFT);
        h();
        i();
        j();
    }
}
