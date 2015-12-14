// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.instamag.activity.view.TMaskScrollImageView;

// Referenced classes of package com.instamag.activity.lib:
//            MagComposeFragement

class a extends Handler
{

    final TMaskScrollImageView a;
    final MagComposeFragement b;

    public void handleMessage(Message message)
    {
        if (message != null)
        {
            message = (Bitmap)message.obj;
            if (message != null)
            {
                a.updateCenterViewImage(message);
            }
        }
    }

    (MagComposeFragement magcomposefragement, TMaskScrollImageView tmaskscrollimageview)
    {
        b = magcomposefragement;
        a = tmaskscrollimageview;
        super();
    }
}
