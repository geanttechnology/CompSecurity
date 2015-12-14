// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.widget.ImageView;
import com.instabeauty.application.InstaBeautyApplication;
import com.instamag.activity.library.view.MaglibItemView;
import com.instamag.activity.library.view.NumberProgressBar;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;

public class bdu
    implements bcx
{

    final MaglibItemView a;

    public bdu(MaglibItemView maglibitemview)
    {
        a = maglibitemview;
        super();
    }

    public void a(TPhotoComposeInfo tphotocomposeinfo, float f)
    {
        Log.v("MaglibItemView", (new StringBuilder()).append("MaglibItemViewdownloadProgress progress:").append(f).toString());
        a.getProgressBar().setProgress((int)(100F * f));
        if ((double)f == 1.0D)
        {
            a.getProgressBar().setVisibility(4);
        }
        if (MaglibItemView.access$400(a) != null)
        {
            MaglibItemView.access$400(a).a(tphotocomposeinfo, f);
        }
    }

    public void c(TPhotoComposeInfo tphotocomposeinfo)
    {
        a.getProgressBar().setVisibility(0);
        a.getProgressBar().setProgress(0);
        if (MaglibItemView.access$400(a) != null)
        {
            MaglibItemView.access$400(a).b(tphotocomposeinfo);
        }
    }

    public void d(TPhotoComposeInfo tphotocomposeinfo)
    {
        Log.v("MaglibItemView", "MaglibItemViewdownloadFinished");
        if (tphotocomposeinfo != null)
        {
            apq.c().d().MagInfoDownloadFinished(tphotocomposeinfo);
            aqx.b(InstaBeautyApplication.a, "TRESINFOUSED", (new StringBuilder()).append("resInfoUesd_").append(tphotocomposeinfo.resId).toString(), false);
        }
        a.getProgressBar().setVisibility(4);
        MaglibItemView.access$500(a).setVisibility(4);
        a.showFlipAnimation();
        if (MaglibItemView.access$400(a) != null)
        {
            MaglibItemView.access$400(a).c(tphotocomposeinfo);
        }
    }

    public void e(TPhotoComposeInfo tphotocomposeinfo)
    {
        Log.v("MaglibItemView", "MaglibItemViewdownloadFailed");
        a.getProgressBar().setVisibility(4);
        if (MaglibItemView.access$400(a) != null)
        {
            MaglibItemView.access$400(a).d(tphotocomposeinfo);
        }
    }
}
