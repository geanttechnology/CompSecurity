// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.os.SystemClock;
import android.widget.ImageView;
import com.groupon.GrouponApplication;
import com.groupon.models.StartupContext;
import com.groupon.models.nst.Grp24ExtraInfo;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.view.dealcards.PicassoCallback;
import com.squareup.picasso.Callback;
import java.util.HashSet;
import roboguice.inject.Lazy;

public class AppStartupImageLoadListener
    implements Callback
{

    private Logger directLogger;
    private long featuredCreatedTime;
    private int imageCount;
    private long imageStartTime;
    private int maxNumOfImages;
    private HashSet viewSet;

    public AppStartupImageLoadListener()
    {
        viewSet = new HashSet();
        featuredCreatedTime = SystemClock.elapsedRealtime();
    }

    private void logAppStartUp(ImageView imageview)
    {
        int i = System.identityHashCode(imageview);
        imageview = GrouponApplication.startupContext;
        if (((StartupContext) (imageview)).shouldLogGrp24 && !viewSet.contains(Integer.valueOf(i)))
        {
            viewSet.add(Integer.valueOf(i));
            i = imageCount - 1;
            imageCount = i;
            if (i == 0)
            {
                imageview.shouldLogGrp24 = false;
                directLogger.logGeneralEvent("startup", "featured", (new StringBuilder()).append("images:").append(maxNumOfImages).toString(), (int)(SystemClock.elapsedRealtime() - imageStartTime), Logger.NULL_NST_FIELD);
                directLogger.logGeneralEvent("startup", "featured", "viewDisplayed", (int)(SystemClock.elapsedRealtime() - featuredCreatedTime), Logger.NULL_NST_FIELD);
                long l = SystemClock.elapsedRealtime();
                long l1 = ((StartupContext) (imageview)).startupTime;
                long l2 = ((StartupContext) (imageview)).applicationStartDuration;
                Grp24ExtraInfo grp24extrainfo = new Grp24ExtraInfo(((StartupContext) (imageview)).shouldLogUpgrade);
                directLogger.logAppStartup("", ((StartupContext) (imageview)).startupTime, (int)((l - l1) + l2), grp24extrainfo);
                Lazy.setVerboseLoggingEnabled(false);
                return;
            }
        }
    }

    public void assignToViews(PicassoCallback picassocallback)
    {
        if (GrouponApplication.startupContext.shouldLogGrp24)
        {
            incrementImage();
            picassocallback.setCallback(this);
        }
    }

    public void incrementImage()
    {
        if (imageCount == 0)
        {
            imageStartTime = SystemClock.elapsedRealtime();
        }
        int i = imageCount + 1;
        imageCount = i;
        if (i > maxNumOfImages)
        {
            maxNumOfImages = i;
        }
    }

    public void onError(ImageView imageview)
    {
        logAppStartUp(imageview);
    }

    public void onSuccess(ImageView imageview)
    {
        logAppStartUp(imageview);
    }
}
