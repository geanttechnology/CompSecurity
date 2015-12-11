// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.aiv;

import android.app.Activity;
import com.amazon.avod.MShopAmazonInstantVideo;
import com.amazon.avod.sdk.AmazonInstantVideo;
import com.amazon.avod.sdk.VideoPlaybackStarter;

// Referenced classes of package com.amazon.mShop.aiv:
//            AmazonInstantVideoProxy

final class val.timecode
    implements Runnable
{

    final AmazonInstantVideoProxy this$0;
    final Activity val$activity;
    final String val$asin;
    final long val$timecode;
    final com.amazon.avod.sdk..val.timecode val$urlType;

    public void run()
    {
        AmazonInstantVideoProxy.access$200(AmazonInstantVideoProxy.this).refreshUserData();
        AmazonInstantVideo amazoninstantvideo = new AmazonInstantVideo(val$activity);
        amazoninstantvideo.play(val$asin, val$urlType).withRefMarker("sdk_3p").withResumeTimecode(val$timecode).start();
        amazoninstantvideo.cleanup();
    }

    ()
    {
        this$0 = final_amazoninstantvideoproxy;
        val$activity = activity1;
        val$asin = s;
        val$urlType = ;
        val$timecode = J.this;
        super();
    }
}
