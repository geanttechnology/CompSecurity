// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.widget.Toast;
import com.instamag.activity.compose.MagComposeActivity;
import com.instamag.activity.compose.MagComposeFragement;

class bam
    implements Runnable
{

    final bal a;

    bam(bal bal1)
    {
        a = bal1;
        super();
    }

    public void run()
    {
        Toast.makeText(a.c.mActivity, a.c.mActivity.getResources().getString(0x7f0601b8), 0).show();
    }
}
