// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.instamag.activity.compose.NetMaterialDownloadFragment;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

public class bbj
    implements android.view.View.OnClickListener
{

    final NetMaterialDownloadFragment a;

    public bbj(NetMaterialDownloadFragment netmaterialdownloadfragment)
    {
        a = netmaterialdownloadfragment;
        super();
    }

    public void onClick(View view)
    {
        if (NetMaterialDownloadFragment.a(a) != null)
        {
            NetMaterialDownloadFragment.a(a, NetMaterialDownloadFragment.a(a).resId, NetMaterialDownloadFragment.a(a).imageCount);
        }
    }
}
