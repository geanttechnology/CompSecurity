// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import com.tremorvideo.sdk.android.videoad.ad;
import java.util.TimerTask;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            n

class a extends TimerTask
{

    final n a;

    public void run()
    {
        try
        {
            a.k();
            return;
        }
        catch (Exception exception)
        {
            ad.a(exception);
        }
    }

    (n n1)
    {
        a = n1;
        super();
    }
}
