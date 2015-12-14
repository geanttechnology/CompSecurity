// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.deviantart;

import com.socialin.android.d;

// Referenced classes of package com.socialin.android.deviantart:
//            DeviantArtOAuthMainActivity

final class a extends Thread
{

    private DeviantArtOAuthMainActivity a;

    public final void run()
    {
        try
        {
            DeviantArtOAuthMainActivity.h(a);
            return;
        }
        catch (Exception exception)
        {
            d.a(DeviantArtOAuthMainActivity.a(), exception);
        }
    }

    (DeviantArtOAuthMainActivity deviantartoauthmainactivity)
    {
        a = deviantartoauthmainactivity;
        super();
    }
}
