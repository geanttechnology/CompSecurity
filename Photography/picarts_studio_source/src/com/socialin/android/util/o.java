// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import com.socialin.android.d;

public final class o
    implements android.media.MediaScannerConnection.MediaScannerConnectionClient
{

    private MediaScannerConnection a;
    private String b;
    private String c;

    public o(Context context, String s, String s1)
    {
        b = s;
        c = s1;
        if (c != null)
        {
            c.contains("image/*");
        }
        c = null;
        a = new MediaScannerConnection(context, this);
        a.connect();
    }

    public final void onMediaScannerConnected()
    {
        a.scanFile(b, c);
    }

    public final void onScanCompleted(String s, Uri uri)
    {
        if (uri != null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        uri = "NULL";
_L1:
        d.b("MediaScannerNotifier", new Object[] {
            "MediaScanner.onComplete() - Scan complete on ", s, " ", uri
        });
        a.disconnect();
        return;
        uri = uri.toString();
          goto _L1
        s;
        a.disconnect();
        throw s;
    }
}
