// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.fotoproedit.activity.ProEditSlimBodyActivity;

class aiw
    implements Runnable
{

    final Bitmap a;
    final aiv b;

    aiw(aiv aiv1, Bitmap bitmap)
    {
        b = aiv1;
        a = bitmap;
        super();
    }

    public void run()
    {
        if (a == null || a.isRecycled())
        {
            b.a.finish();
            return;
        } else
        {
            ProEditSlimBodyActivity.a(b.a, a);
            ProEditSlimBodyActivity.b(b.a, a);
            ProEditSlimBodyActivity.f(b.a);
            return;
        }
    }
}
