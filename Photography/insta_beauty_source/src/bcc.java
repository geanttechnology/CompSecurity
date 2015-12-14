// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.widget.Button;
import com.instabeauty.application.InstaBeautyApplication;
import com.instamag.activity.library.activity.MainDownloadActivity;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;

public class bcc
    implements bcx
{

    final MainDownloadActivity a;

    public bcc(MainDownloadActivity maindownloadactivity)
    {
        a = maindownloadactivity;
        super();
    }

    public void a(TPhotoComposeInfo tphotocomposeinfo, float f)
    {
    }

    public void c(TPhotoComposeInfo tphotocomposeinfo)
    {
        a.a(InstaBeautyApplication.a.getResources().getString(0x7f0600e9));
    }

    public void d(TPhotoComposeInfo tphotocomposeinfo)
    {
        if (tphotocomposeinfo != null)
        {
            a.b().MagInfoDownloadFinished(tphotocomposeinfo);
            MainDownloadActivity.a(a, true);
        }
        a.e();
        MainDownloadActivity.c(a).setVisibility(4);
        MainDownloadActivity.e(a).setVisibility(0);
        a.d();
    }

    public void e(TPhotoComposeInfo tphotocomposeinfo)
    {
        a.e();
        MainDownloadActivity.c(a).setEnabled(true);
        MainDownloadActivity.e(a).setVisibility(4);
        MainDownloadActivity.c(a).setVisibility(0);
    }
}
