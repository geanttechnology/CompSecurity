// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.recommendations;

import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.RateRecsRequest;
import com.amazon.rio.j2me.client.services.mShop.RateRecsResponse;
import com.amazon.rio.j2me.client.services.mShop.RateRecsResponseListener;
import com.amazon.rio.j2me.client.services.mShop.RecsRating;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

// Referenced classes of package com.amazon.mShop.control.recommendations:
//            RecommendationsRatingSubscriber

public class RecommendationsController
    implements RateRecsResponseListener
{

    private static RecommendationsController sInstance;
    private boolean mHasPendingCall;
    private List mPendingRating;
    private List mSubscribers;
    private String mUserKey;

    public RecommendationsController()
    {
        mHasPendingCall = false;
        mPendingRating = new ArrayList();
        mUserKey = "";
        mSubscribers = new ArrayList();
    }

    public static RecommendationsController getInstance()
    {
        com/amazon/mShop/control/recommendations/RecommendationsController;
        JVM INSTR monitorenter ;
        RecommendationsController recommendationscontroller;
        if (sInstance == null)
        {
            sInstance = new RecommendationsController();
        }
        recommendationscontroller = sInstance;
        com/amazon/mShop/control/recommendations/RecommendationsController;
        JVM INSTR monitorexit ;
        return recommendationscontroller;
        Exception exception;
        exception;
        throw exception;
    }

    public void addRatingToPendingList(RecsRating recsrating)
    {
        mPendingRating.add(recsrating);
    }

    public void addSubscriber(RecommendationsRatingSubscriber recommendationsratingsubscriber)
    {
        if (recommendationsratingsubscriber != null && !mSubscribers.contains(recommendationsratingsubscriber))
        {
            mSubscribers.add(recommendationsratingsubscriber);
        }
    }

    public void cancelled(ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final RecommendationsController this$0;

            public void run()
            {
                mHasPendingCall = false;
                for (Iterator iterator = (new ArrayList(mSubscribers)).iterator(); iterator.hasNext(); ((RecommendationsRatingSubscriber)iterator.next()).onRecsRatingCallCancelled()) { }
            }

            
            {
                this$0 = RecommendationsController.this;
                super();
            }
        });
    }

    public void clearPendingList()
    {
        mPendingRating.clear();
    }

    public void completed(RateRecsResponse raterecsresponse, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final RecommendationsController this$0;

            public void run()
            {
                mHasPendingCall = false;
                for (Iterator iterator = (new ArrayList(mSubscribers)).iterator(); iterator.hasNext(); ((RecommendationsRatingSubscriber)iterator.next()).onRecsRatingCallCompleted()) { }
            }

            
            {
                this$0 = RecommendationsController.this;
                super();
            }
        });
    }

    public void eraseRatingRequestErrorInfo(String s)
    {
        String s2 = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("userRatingRequestErrorSet");
        String s1 = s2;
        if (!Util.isEmpty(s2))
        {
            s1 = s2.replace(s, "");
        }
        if (!Util.isEmpty(s1))
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putString("userRatingRequestErrorSet", s1);
            return;
        } else
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().remove("userRatingRequestErrorSet");
            return;
        }
    }

    public void error(Exception exception, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final RecommendationsController this$0;

            public void run()
            {
                mHasPendingCall = false;
                Object obj = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("userRatingRequestErrorSet");
                if (obj == null)
                {
                    obj = mUserKey;
                } else
                {
                    obj = (new StringBuilder()).append(((String) (obj))).append(mUserKey).toString();
                }
                com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putString("userRatingRequestErrorSet", ((String) (obj)));
                for (obj = (new ArrayList(mSubscribers)).iterator(); ((Iterator) (obj)).hasNext(); ((RecommendationsRatingSubscriber)((Iterator) (obj)).next()).onRecsRatingCallError()) { }
            }

            
            {
                this$0 = RecommendationsController.this;
                super();
            }
        });
    }

    public boolean isLastRatingRequestError(String s)
    {
        boolean flag1 = false;
        String s1 = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("userRatingRequestErrorSet");
        boolean flag = flag1;
        if (s1 != null)
        {
            flag = flag1;
            if (s1.indexOf(s) != -1)
            {
                flag = true;
            }
        }
        return flag;
    }

    public boolean recsItemsRequestShouldWait()
    {
        return mHasPendingCall;
    }

    public void removeSubscriber(RecommendationsRatingSubscriber recommendationsratingsubscriber)
    {
        if (recommendationsratingsubscriber != null)
        {
            mSubscribers.remove(recommendationsratingsubscriber);
        }
    }

    public void sendRecsRatingsForUser(String s)
    {
        if (!mHasPendingCall && mPendingRating.size() > 0)
        {
            mHasPendingCall = true;
            mUserKey = s;
            s = new RateRecsRequest();
            s.setAdditions(new Vector(mPendingRating));
            ServiceController.getMShopService().rateRecs(s, this);
            clearPendingList();
            for (s = (new ArrayList(mSubscribers)).iterator(); s.hasNext(); ((RecommendationsRatingSubscriber)s.next()).onRecsRatingCallStarted()) { }
        }
    }


/*
    static boolean access$002(RecommendationsController recommendationscontroller, boolean flag)
    {
        recommendationscontroller.mHasPendingCall = flag;
        return flag;
    }

*/


}
