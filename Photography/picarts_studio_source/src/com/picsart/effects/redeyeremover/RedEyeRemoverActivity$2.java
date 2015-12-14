// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.redeyeremover;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import com.socialin.android.photo.imgop.ImageOpCommon;
import java.nio.ByteBuffer;
import java.util.ArrayList;

// Referenced classes of package com.picsart.effects.redeyeremover:
//            RedEyeRemoverActivity, RedEyeRemoverImageView, a, b

final class a
    implements android.view.EyeRemoverActivity._cls2
{

    private RedEyeRemoverActivity a;

    public final void onClick(View view)
    {
        RedEyeRemoverImageView redeyeremoverimageview = RedEyeRemoverActivity.a(a);
        a a1 = redeyeremoverimageview.c;
        Bitmap bitmap = redeyeremoverimageview.d;
        ByteBuffer bytebuffer = redeyeremoverimageview.e;
        ByteBuffer bytebuffer1 = redeyeremoverimageview.f;
        boolean flag;
        if (a1.k.size() > 0)
        {
            b b1 = (b)a1.k.get(a1.k.size() - 1);
            Rect rect = (Rect)a1.l.get(a1.l.size() - 1);
            bytebuffer.position(0);
            bytebuffer1.position(0);
            ImageOpCommon.copyCirclePixels(bytebuffer, bytebuffer1, (int)b1.a.x, (int)b1.a.y, (int)b1.b, rect.left, rect.top, rect.width(), rect.height(), bitmap.getWidth(), bitmap.getHeight());
            bytebuffer1.position(0);
            bitmap.copyPixelsFromBuffer(bytebuffer1);
            a1.k.remove(a1.k.size() - 1);
            a1.l.remove(a1.l.size() - 1);
            if (a1.k.size() > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = false;
        }
        redeyeremoverimageview.invalidate();
        if (!flag)
        {
            view.setEnabled(false);
            a.findViewById(0x7f10079b).setEnabled(false);
        }
    }

    (RedEyeRemoverActivity redeyeremoveractivity)
    {
        a = redeyeremoveractivity;
        super();
    }
}
