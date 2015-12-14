// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

public class rh extends rl
{

    private BitmapDrawable a;

    public rh(rj rj1)
    {
        super(rj1);
        if (rj1.a != null)
        {
            a = new BitmapDrawable(PIPCameraApplication.a.getResources(), rj1.a);
            a.setDither(true);
            a.setFilterBitmap(true);
            Rect rect = new Rect();
            TPhotoComposeInfo.getScaledRect(rj1.h).round(rect);
            rect.set(0, 0, rect.width(), rect.height());
            a.setBounds(rect);
            Log.v("Render content rect", rj1.h.toString());
            Log.v("Render bound rect", rj1.g.toString());
            Log.v("Render transferm", b().toString());
        }
    }

    void a(Canvas canvas)
    {
        canvas.save();
        canvas.translate(TPhotoComposeInfo.scale * a().h.left, TPhotoComposeInfo.scale * a().h.top);
        canvas.concat(b());
        a.draw(canvas);
        canvas.restore();
    }
}
