// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.net.Uri;
import android.util.Log;

// Referenced classes of package com.pipcamera.activity:
//            NewPhotoShareActivity

class a
    implements android.media.ScanCompletedListener
{

    final NewPhotoShareActivity a;

    public void onScanCompleted(String s, Uri uri)
    {
        Log.d("PhotoShare", uri.toString());
        NewPhotoShareActivity.a(a, uri);
    }

    etedListener(NewPhotoShareActivity newphotoshareactivity)
    {
        a = newphotoshareactivity;
        super();
    }
}
