// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.sketch.activity.TTieZhiActivity;

class avp
    implements Runnable
{

    final Bitmap a;
    final avo b;

    avp(avo avo1, Bitmap bitmap)
    {
        b = avo1;
        a = bitmap;
        super();
    }

    public void run()
    {
        if (a != null)
        {
            uv.c().a(a, new avq(this));
            return;
        } else
        {
            TTieZhiActivity.a(b.a.a, false, "");
            return;
        }
    }
}
