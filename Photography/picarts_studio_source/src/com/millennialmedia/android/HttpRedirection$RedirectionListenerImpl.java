// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.net.Uri;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            MMLog, OverlaySettings

class I
    implements I
{

    String a;
    WeakReference b;
    Uri c;
    String d;
    long e;

    public boolean canOpenOverlay()
    {
        return false;
    }

    public OverlaySettings getOverlaySettings()
    {
        return null;
    }

    public boolean isActivityStartable(Uri uri)
    {
        return true;
    }

    public boolean isExpandingToUrl()
    {
        return false;
    }

    public boolean isHandlingMMVideo(Uri uri)
    {
        return false;
    }

    public void startingActivity(Uri uri)
    {
        MMLog.b("HttpRedirection", String.format("Starting activity for %s", new Object[] {
            uri
        }));
    }

    public void startingVideo()
    {
    }

    public void updateLastVideoViewedTime()
    {
    }

    public I()
    {
    }
}
