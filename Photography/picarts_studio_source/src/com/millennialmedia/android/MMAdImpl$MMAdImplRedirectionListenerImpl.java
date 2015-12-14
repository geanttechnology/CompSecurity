// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.net.Uri;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            MMAdImpl, HandShake

class e extends e
{

    WeakReference f;

    public boolean isActivityStartable(Uri uri)
    {
        uri = (MMAdImpl)f.get();
        if (uri != null)
        {
            uri = uri.i();
            if (uri != null && (uri instanceof Activity) && ((Activity)uri).isFinishing())
            {
                return false;
            }
        }
        return true;
    }

    public void startingActivity(Uri uri)
    {
        super.tartingActivity(uri);
        if (uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https"))
        {
            uri = (MMAdImpl)f.get();
            if (uri != null)
            {
                f(uri);
            }
        }
    }

    public void updateLastVideoViewedTime()
    {
        MMAdImpl mmadimpl = (MMAdImpl)f.get();
        if (mmadimpl != null && mmadimpl.e != null)
        {
            HandShake.a(mmadimpl.i()).a(mmadimpl.i(), mmadimpl.e);
        }
    }

    public (MMAdImpl mmadimpl)
    {
        if (mmadimpl != null)
        {
            f = new WeakReference(mmadimpl);
            e = mmadimpl.f;
        }
    }
}
