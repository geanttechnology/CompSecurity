// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.fotoable.fotobeauty.NewPhotoShareActivity;
import com.instamag.activity.compose.MagComposeActivity;
import com.instamag.activity.compose.MagComposeLinkFragement;
import com.wantu.activity.link.model.TPhotoLinkComposeInfo;

public class baw extends Handler
{

    final Bitmap a;
    final MagComposeLinkFragement b;

    public baw(MagComposeLinkFragement magcomposelinkfragement, Bitmap bitmap)
    {
        b = magcomposelinkfragement;
        a = bitmap;
        super();
    }

    public void handleMessage(Message message)
    {
        b.a.b();
        Log.v(MagComposeLinkFragement.g(b), (new StringBuilder()).append(MagComposeLinkFragement.g(b)).append("write ResultImage end").toString());
        if (a != null && !a.isRecycled())
        {
            a.recycle();
        }
        if (message != null)
        {
            message = new Intent(b.getActivity(), com/fotoable/fotobeauty/NewPhotoShareActivity);
            message.putExtra("imageUrlString", bnr.k);
            message.putExtra("ImageUriToShare_IsLink", true);
            if (MagComposeLinkFragement.h(b).isShouldFirst())
            {
                String s = MagComposeLinkFragement.h(b).getShareTag();
                if (s != null && s.length() > 0)
                {
                    message.putExtra("share_tag", s);
                }
            }
            b.startActivity(message);
            b.getActivity().overridePendingTransition(0x7f040009, 0);
        }
    }
}
