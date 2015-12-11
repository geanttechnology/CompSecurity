// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.graphics.Bitmap;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.video.VideoKey;
import com.edisonwang.android.slog.SLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package co.vine.android.service:
//            GCMNotificationService

public static class notificationId
{

    public ImageKey avatarKey;
    public Bitmap bm;
    public android.support.v4.app..bm builder;
    public final int notificationId;
    public long notificationObjectId;
    public ArrayList notifications;
    public final HashMap thumbnailKeys = new HashMap();
    public final HashMap videoKeys = new HashMap();

    public boolean isReady()
    {
        if (builder == null)
        {
            SLog.d("Builder is not ready, this event has been reset by notification merge.");
            return false;
        }
        if (avatarKey != null)
        {
            SLog.d("Notification not ready because avatar is pending.");
            return false;
        }
        for (Iterator iterator = thumbnailKeys.keySet().iterator(); iterator.hasNext();)
        {
            ImageKey imagekey = (ImageKey)iterator.next();
            if (!((Boolean)thumbnailKeys.get(imagekey)).booleanValue())
            {
                SLog.d("Notification not ready because thumbnails are pending.");
                return false;
            }
        }

        for (Iterator iterator1 = videoKeys.keySet().iterator(); iterator1.hasNext();)
        {
            VideoKey videokey = (VideoKey)iterator1.next();
            if (!((Boolean)videoKeys.get(videokey)).booleanValue())
            {
                SLog.d("Notification not ready because videos are pending.");
                return false;
            }
        }

        return true;
    }

    public void reset()
    {
        builder = null;
        notifications = null;
        avatarKey = null;
        thumbnailKeys.clear();
        videoKeys.clear();
        bm = null;
    }

    public (int i)
    {
        notificationId = i;
    }
}
