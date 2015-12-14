// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.fotoproedit.activity.ProEditFilterActivity;

class agh
    implements Runnable
{

    final ProEditFilterActivity a;
    final Bitmap b;
    final agg c;

    agh(agg agg, ProEditFilterActivity proeditfilteractivity, Bitmap bitmap)
    {
        c = agg;
        a = proeditfilteractivity;
        b = bitmap;
        super();
    }

    public void run()
    {
        ProEditFilterActivity.b(a, b);
        ProEditFilterActivity.s(a);
    }
}
