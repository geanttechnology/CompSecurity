// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.notification;

import android.graphics.BitmapFactory;
import android.net.Uri;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.sample.castcompanionlibrary.cast.exceptions.CastException;
import com.google.sample.castcompanionlibrary.cast.exceptions.NoConnectionException;
import com.google.sample.castcompanionlibrary.cast.exceptions.TransientNetworkDisconnectionException;
import com.google.sample.castcompanionlibrary.utils.LogUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

// Referenced classes of package com.google.sample.castcompanionlibrary.notification:
//            VideoCastNotificationService

class val.visible
    implements Runnable
{

    final VideoCastNotificationService this$0;
    final MediaInfo val$info;
    final boolean val$visible;

    public void run()
    {
        Object obj1;
        Object obj2;
        Object obj4;
        Object obj5;
        Object obj6;
        obj2 = null;
        obj4 = null;
        obj5 = null;
        obj6 = null;
        obj1 = null;
        Object obj;
        obj = val$info.getMetadata();
        VideoCastNotificationService.access$302(VideoCastNotificationService.this, ((WebImage)((MediaMetadata) (obj)).getImages().get(0)).getUrl());
        obj = new URL(VideoCastNotificationService.access$300(VideoCastNotificationService.this).toString());
        VideoCastNotificationService.access$402(VideoCastNotificationService.this, BitmapFactory.decodeStream(((URL) (obj)).openStream()));
        VideoCastNotificationService.access$700(VideoCastNotificationService.this, val$info, VideoCastNotificationService.access$400(VideoCastNotificationService.this), VideoCastNotificationService.access$500(VideoCastNotificationService.this), VideoCastNotificationService.access$600(VideoCastNotificationService.this));
        if (val$visible)
        {
            startForeground(VideoCastNotificationService.access$800(), VideoCastNotificationService.access$900(VideoCastNotificationService.this));
        }
        return;
        obj;
_L10:
        LogUtils.LOGE(VideoCastNotificationService.access$000(), (new StringBuilder()).append("setIcon(): Failed to load the image with url: ").append(obj1).append(", using the default one").toString(), ((Throwable) (obj)));
        return;
        obj;
        obj1 = obj2;
_L8:
        LogUtils.LOGE(VideoCastNotificationService.access$000(), (new StringBuilder()).append("setIcon(): Failed to load the image with url: ").append(obj1).append(", using the default one").toString(), ((Throwable) (obj)));
        return;
        obj;
        obj1 = obj4;
_L6:
        LogUtils.LOGE(VideoCastNotificationService.access$000(), (new StringBuilder()).append("setIcon(): Failed to load the image with url: ").append(obj1).append(", using the default one").toString(), ((Throwable) (obj)));
        return;
        obj;
        obj1 = obj5;
_L4:
        LogUtils.LOGE(VideoCastNotificationService.access$000(), (new StringBuilder()).append("setIcon(): Failed to load the image with url: ").append(obj1).append(" due to network issues, using the default one").toString(), ((Throwable) (obj)));
        return;
        obj;
        obj1 = obj6;
_L2:
        LogUtils.LOGE(VideoCastNotificationService.access$000(), (new StringBuilder()).append("setIcon(): Failed to load the image with url: ").append(obj1).append(" due to network issues, using the default one").toString(), ((Throwable) (obj)));
        return;
        Object obj3;
        obj3;
        obj1 = obj;
        obj = obj3;
        if (true) goto _L2; else goto _L1
_L1:
        obj3;
        obj1 = obj;
        obj = obj3;
        if (true) goto _L4; else goto _L3
_L3:
        obj3;
        obj1 = obj;
        obj = obj3;
        if (true) goto _L6; else goto _L5
_L5:
        obj3;
        obj1 = obj;
        obj = obj3;
        if (true) goto _L8; else goto _L7
_L7:
        obj3;
        obj1 = obj;
        obj = obj3;
        if (true) goto _L10; else goto _L9
_L9:
    }

    nException()
    {
        this$0 = final_videocastnotificationservice;
        val$info = mediainfo;
        val$visible = Z.this;
        super();
    }
}
