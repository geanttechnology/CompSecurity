// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.youtube;

import android.os.AsyncTask;
import android.widget.Toast;

// Referenced classes of package com.socialin.android.youtube:
//            YouTubeUploadActivity

final class a extends AsyncTask
{

    private String a;
    private YouTubeUploadActivity b;

    private a(YouTubeUploadActivity youtubeuploadactivity)
    {
        b = youtubeuploadactivity;
        super();
    }

    a(YouTubeUploadActivity youtubeuploadactivity, byte byte0)
    {
        this(youtubeuploadactivity);
    }

    protected final volatile Object doInBackground(Object aobj[])
    {
        a = ((String[])aobj)[0];
        return a;
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (String)obj;
        Toast.makeText(b.getApplicationContext(), ((CharSequence) (obj)), 1).show();
    }
}
