// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.media.MediaScannerConnection;
import android.net.Uri;

// Referenced classes of package com.millennialmedia.android:
//            BridgeMMMedia, MMLog

class a
    implements android.media.ection.MediaScannerConnectionClient
{

    private String a;
    private BridgeMMMedia b;

    public void onMediaScannerConnected()
    {
        if (b.a != null)
        {
            b.a.scanFile(a, null);
        }
    }

    public void onScanCompleted(String s, Uri uri)
    {
        if (uri == null)
        {
            MMLog.b("BridgeMMMedia", (new StringBuilder("Failed to scan ")).append(s).toString());
        }
    }

    annerConnectionClient(BridgeMMMedia bridgemmmedia, String s)
    {
        b = bridgemmmedia;
        a = s;
        super();
    }
}
