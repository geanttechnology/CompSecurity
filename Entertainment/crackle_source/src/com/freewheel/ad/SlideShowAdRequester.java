// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.freewheel.ad;

import android.app.Activity;
import com.gotv.crackle.ApplicationConstants;
import com.gotv.crackle.data.DataRequest;
import com.gotv.crackle.model.SlideShowItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.ISlot;

// Referenced classes of package com.freewheel.ad:
//            IAdHolder, AdFetcher

public class SlideShowAdRequester extends DataRequest
    implements IAdHolder
{

    public static final String TAG = "SLIDESHOW_AD_REQUESTER";
    private IAdContext adContext;
    private AdFetcher adFetcher;
    private Map mAdViewMap;
    private Activity mCtx;
    private int mCurrentAdIndexLoading;
    private List mItems;

    public SlideShowAdRequester(Activity activity, com.gotv.crackle.data.DataRequest.DataRequestListener datarequestlistener)
    {
        mCurrentAdIndexLoading = 0;
        mAdViewMap = new HashMap();
        mDataRequestListener = datarequestlistener;
        mCtx = activity;
        mState = com.gotv.crackle.data.DataRequest.RequestState.RUNNING;
    }

    private void getNextAd()
    {
        if (mCurrentAdIndexLoading < mItems.size())
        {
            mCtx.runOnUiThread(new Runnable() {

                final SlideShowAdRequester this$0;

                public void run()
                {
                    if (adFetcher == null)
                    {
                        adFetcher = new AdFetcher(SlideShowAdRequester.this);
                    }
                    adFetcher.loadAd(getSectionName());
                }

            
            {
                this$0 = SlideShowAdRequester.this;
                super();
            }
            });
            return;
        } else
        {
            mState = com.gotv.crackle.data.DataRequest.RequestState.COMPLETE;
            mDataRequestListener.onDataSuccess("SLIDESHOW_AD_REQUESTER");
            return;
        }
    }

    public void beforeSubmitRequest(String s)
    {
        String s1 = ((SlideShowItem)mItems.get(mCurrentAdIndexLoading)).getSlideID();
        adContext.setSiteSection(s, 0, 0, 0, 0);
        adContext.addKeyValue("slide", s1);
        adContext.addSiteSectionNonTemporalSlot(s1, null, 120, 60, null, false, null, null);
    }

    public Activity getBaseActivity()
    {
        return mCtx;
    }

    public String getSectionName()
    {
        return ApplicationConstants.getFreeWheelHomeSiteSection();
    }

    public Map getSlideShowAdSlotMap()
    {
        return mAdViewMap;
    }

    public String getVideoAssetId()
    {
        return null;
    }

    public int getVideoDurationInSec()
    {
        return 0;
    }

    public String getVideoTitle()
    {
        return null;
    }

    public void onAdContextCreated(IAdContext iadcontext)
    {
        adContext = iadcontext;
    }

    public void onAdManagerLoadFailed()
    {
        mState = com.gotv.crackle.data.DataRequest.RequestState.COMPLETE;
        mDataRequestListener.onDataSuccess("SLIDESHOW_AD_REQUESTER");
    }

    public void onRequestComplete(IEvent ievent)
    {
        ievent = ((SlideShowItem)mItems.get(mCurrentAdIndexLoading)).getSlideID();
        Iterator iterator = adContext.getSlotsByTimePositionClass(adContext.getConstants().TIME_POSITION_CLASS_DISPLAY()).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ISlot islot = (ISlot)iterator.next();
            if (islot.getCustomId().compareTo(ievent) == 0)
            {
                islot.setParameter("renderer.html.shouldUseDip", "true");
                mAdViewMap.put(ievent, islot);
            }
        } while (true);
        mCurrentAdIndexLoading = mCurrentAdIndexLoading + 1;
        getNextAd();
    }

    public void run(List list)
    {
        mItems = list;
        if (mItems != null)
        {
            if (mItems.size() > 0)
            {
                getNextAd();
                return;
            } else
            {
                mDataRequestListener.onDataSuccess("SLIDESHOW_AD_REQUESTER");
                return;
            }
        } else
        {
            mDataRequestListener.onDataSuccess("SLIDESHOW_AD_REQUESTER");
            return;
        }
    }



/*
    static AdFetcher access$002(SlideShowAdRequester slideshowadrequester, AdFetcher adfetcher)
    {
        slideshowadrequester.adFetcher = adfetcher;
        return adfetcher;
    }

*/
}
