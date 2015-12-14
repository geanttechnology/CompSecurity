// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.redeyeremover;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.widget.Button;
import com.socialin.android.photo.imgop.ImageOpCommon;
import java.nio.ByteBuffer;
import java.util.ArrayList;

// Referenced classes of package com.picsart.effects.redeyeremover:
//            RedEyeRemoverActivity, RedEyeRemoverImageView, a, b

final class a
    implements android.view.EyeRemoverActivity._cls1
{

    private RedEyeRemoverActivity a;

    public final void onClick(View view)
    {
        view = RedEyeRemoverActivity.a(a);
        float af[] = new float[9];
        view.getImageMatrix().getValues(af);
        float f = ((RedEyeRemoverImageView) (view)).b.width() / ((RedEyeRemoverImageView) (view)).a.width();
        a a1 = ((RedEyeRemoverImageView) (view)).c;
        Object obj = ((RedEyeRemoverImageView) (view)).d;
        ByteBuffer bytebuffer = ((RedEyeRemoverImageView) (view)).e;
        ByteBuffer bytebuffer1 = ((RedEyeRemoverImageView) (view)).f;
        int i1 = ((Bitmap) (obj)).getWidth();
        int j1 = ((Bitmap) (obj)).getHeight();
        int l1 = Math.round((a1.b.a.x - af[2]) / af[0]);
        int i2 = Math.round((a1.b.a.y - af[5]) / af[4]);
        f = a1.b.b * f;
        boolean flag;
        if ((float)l1 + f > 0.0F && (float)l1 - f < (float)i1 && (float)i2 + f > 0.0F && (float)i2 - f < (float)j1)
        {
            int i = (int)((float)l1 - f);
            int k = (int)((float)i2 - f);
            if (i < 0)
            {
                i = 0;
            }
            int j = k;
            if (k < 0)
            {
                j = 0;
            }
            int l = Math.round((float)l1 + f);
            int k1 = Math.round((float)i2 + f);
            k = l;
            if (l > i1)
            {
                k = i1;
            }
            l = k1;
            if (k1 > j1)
            {
                l = j1;
            }
            Rect rect = new Rect(i, j, k, l);
            if (rect.width() != 0 || rect.height() != 0)
            {
                bytebuffer.position(0);
                bytebuffer1.position(0);
                ImageOpCommon.changeRedEyeRegions(bytebuffer, bytebuffer1, l1, i2, (int)f, rect.left, rect.top, rect.width(), rect.height(), i1, j1);
                bytebuffer1.position(0);
                ((Bitmap) (obj)).copyPixelsFromBuffer(bytebuffer1);
                obj = new b(new PointF(l1, i2), f);
                a1.k.add(obj);
                a1.l.add(rect);
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = false;
        }
        view.invalidate();
        if (Boolean.valueOf(flag).booleanValue())
        {
            view = (Button)a.findViewById(0x7f10079a);
            if (!view.isEnabled())
            {
                view.setEnabled(true);
            }
            view = (Button)a.findViewById(0x7f10079b);
            if (!view.isEnabled())
            {
                view.setEnabled(true);
            }
        }
    }

    (RedEyeRemoverActivity redeyeremoveractivity)
    {
        a = redeyeremoveractivity;
        super();
    }
}
