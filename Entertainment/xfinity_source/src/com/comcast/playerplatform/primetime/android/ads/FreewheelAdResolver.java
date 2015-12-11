// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads;

import android.util.Log;
import com.adobe.mediacore.metadata.Metadata;
import com.adobe.mediacore.timeline.PlacementOpportunity;
import com.adobe.mediacore.timeline.advertising.ContentResolver;
import com.adobe.mediacore.timeline.advertising.ContentTracker;
import com.comcast.playerplatform.primetime.android.ads.managers.FreewheelManager;
import com.comcast.playerplatform.primetime.android.util.ThreadManager;
import java.util.List;
import java.util.Vector;

public class FreewheelAdResolver extends ContentResolver
{

    FreewheelManager freewheelManager;

    public FreewheelAdResolver(FreewheelManager freewheelmanager)
    {
        freewheelManager = freewheelmanager;
    }

    protected boolean doCanResolve(PlacementOpportunity placementopportunity)
    {
        return freewheelManager != null;
    }

    protected ContentTracker doProvideAdTracker()
    {
        return null;
    }

    protected void doResolveAds(Metadata metadata, PlacementOpportunity placementopportunity)
    {
        Log.i("Pauk", "doResolveAds was called");
        ThreadManager.getInstance().executeRunnable(new Runnable() {

            final FreewheelAdResolver this$0;

            public void run()
            {
                Vector vector = freewheelManager.getAdProposals();
                ThreadManager.getInstance().executeOnUIThread(vector. new Runnable() {

                    final _cls1 this$1;
                    final Vector val$proposals;

                    public void run()
                    {
                        notifyResolveComplete(proposals);
                    }

            
            {
                this$1 = final__pcls1;
                proposals = Vector.this;
                super();
            }
                });
            }

            
            {
                this$0 = FreewheelAdResolver.this;
                super();
            }
        });
    }

}
