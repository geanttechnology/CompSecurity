// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Handler;

class byd
    implements android.media.MediaScannerConnection.OnScanCompletedListener
{

    final byc a;

    byd(byc byc1)
    {
        a = byc1;
        super();
    }

    public void onScanCompleted(String s, Uri uri)
    {
        if (byc.a(a) != null)
        {
            byc.b(a).post(new bye(this, uri));
        }
    }
}
