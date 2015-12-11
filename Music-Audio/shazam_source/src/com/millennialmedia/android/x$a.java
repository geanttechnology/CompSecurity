// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.net.Uri;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            x, al, OverlaySettings

static class laySettings
{

    String a;
    WeakReference b;
    Uri c;
    String d;
    long e;

    public boolean a()
    {
        return false;
    }

    public boolean a(Uri uri)
    {
        return false;
    }

    public OverlaySettings b()
    {
        return null;
    }

    public void b(Uri uri)
    {
        String.format("Starting activity for %s", new Object[] {
            uri
        });
        al.b();
    }

    public void c()
    {
    }

    public boolean d()
    {
        return true;
    }

    public laySettings()
    {
    }
}
