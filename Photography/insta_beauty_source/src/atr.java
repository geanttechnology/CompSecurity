// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.flurry.android.FlurryAgent;

final class atr
    implements Runnable
{

    final atz a;
    final Bitmap b;
    final atx c;

    atr(atz atz1, Bitmap bitmap, atx atx1)
    {
        a = atz1;
        b = bitmap;
        c = atx1;
        super();
    }

    public void run()
    {
        a.a(b);
        FlurryAgent.logEvent("ShareWechat");
        if (c != null)
        {
            c.a(true, true);
        }
    }
}
