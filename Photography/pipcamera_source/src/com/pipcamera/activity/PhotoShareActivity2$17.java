// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.net.Uri;
import android.util.Log;

// Referenced classes of package com.pipcamera.activity:
//            PhotoShareActivity2

class a
    implements android.media.OnScanCompletedListener
{

    final PhotoShareActivity2 a;

    public void onScanCompleted(String s, Uri uri)
    {
        Log.d("PhotoShare", uri.toString());
        PhotoShareActivity2.a(a, uri);
    }

    pletedListener(PhotoShareActivity2 photoshareactivity2)
    {
        a = photoshareactivity2;
        super();
    }
}
