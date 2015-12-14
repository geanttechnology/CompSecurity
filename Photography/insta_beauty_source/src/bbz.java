// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.instamag.activity.library.activity.MainDownloadActivity;

public class bbz
    implements android.view.View.OnClickListener
{

    final MainDownloadActivity a;

    public bbz(MainDownloadActivity maindownloadactivity)
    {
        a = maindownloadactivity;
        super();
    }

    public void onClick(View view)
    {
        if (MainDownloadActivity.a(a) != null)
        {
            MainDownloadActivity.a(a, MainDownloadActivity.a(a));
        }
    }
}
