// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.view;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMaskInfo;

// Referenced classes of package com.instamag.activity.view:
//            TMaskScrollImageView

class a extends Handler
{

    final boolean a;
    final TMaskScrollImageView b;

    public void handleMessage(Message message)
    {
label0:
        {
            if (message != null)
            {
                message = (Bitmap)message.obj;
                if (message != null)
                {
                    if (!TMaskScrollImageView.access$300(b).is3DTransform())
                    {
                        break label0;
                    }
                    b.updateCenter3dTransformImage(message, a);
                }
            }
            return;
        }
        if (a)
        {
            b.updateCenterViewImageWithSameScale(message);
            return;
        } else
        {
            b.updateCenterViewImage(message);
            return;
        }
    }

    Info(TMaskScrollImageView tmaskscrollimageview, boolean flag)
    {
        b = tmaskscrollimageview;
        a = flag;
        super();
    }
}
