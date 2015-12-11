// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import android.app.Activity;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.mobile.Item;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager;
import com.ebay.nautilus.domain.data.EbayItemIdAndVariationSpecifics;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.FwContext;
import java.util.List;

public class UserCacheChangeWatchNetLoader
    implements com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager.Observer
{
    public static interface OnChangeWatchCompleteListener
    {

        public abstract void onChangeWatchComplete(int i, UserCacheChangeWatchNetLoader usercachechangewatchnetloader);
    }


    private final Activity activity;
    private final MyEbayWatchingDataManager dm;
    private final EbayContext ebayContext;
    private final long ebayItemId;
    public String errorToDisplay;
    private boolean iafTokenInvalid;
    private final int id;
    private final Item item;
    private final OnChangeWatchCompleteListener l;
    private final List nameValueList;
    private ResultStatus resultStatus;
    private final boolean watch;

    public UserCacheChangeWatchNetLoader(int i, String s, Activity activity1, long l1, boolean flag, List list)
    {
        iafTokenInvalid = false;
        resultStatus = ResultStatus.SUCCESS;
        id = i;
        ebayContext = ((FwContext)activity1).getEbayContext();
        dm = (MyEbayWatchingDataManager)DataManager.get(ebayContext, new com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager.KeyParams(s));
        activity = activity1;
        if (activity1 instanceof OnChangeWatchCompleteListener)
        {
            s = (OnChangeWatchCompleteListener)activity1;
        } else
        {
            s = null;
        }
        l = s;
        item = null;
        watch = flag;
        nameValueList = list;
        ebayItemId = l1;
    }

    public UserCacheChangeWatchNetLoader(int i, String s, Activity activity1, Item item1, boolean flag, List list)
    {
        iafTokenInvalid = false;
        resultStatus = ResultStatus.SUCCESS;
        id = i;
        ebayContext = ((FwContext)activity1).getEbayContext();
        dm = (MyEbayWatchingDataManager)DataManager.get(ebayContext, new com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager.KeyParams(s));
        activity = activity1;
        if (activity1 instanceof OnChangeWatchCompleteListener)
        {
            s = (OnChangeWatchCompleteListener)activity1;
        } else
        {
            s = null;
        }
        l = s;
        item = item1;
        watch = flag;
        nameValueList = list;
        ebayItemId = 0L;
    }

    private void handleResult(Content content)
    {
        int i;
        i = 1;
        dm.unregisterObserver(this);
        resultStatus = content.getStatus();
        if (!resultStatus.hasError()) goto _L2; else goto _L1
_L1:
        if (!EbayErrorUtil.userNotLoggedIn(resultStatus.getMessages())) goto _L4; else goto _L3
_L3:
        iafTokenInvalid = true;
_L9:
        return;
_L4:
        errorToDisplay = ResultStatus.getSafeLongMessage(ebayContext, resultStatus.getFirstMessage());
_L7:
        if (l != null)
        {
            l.onChangeWatchComplete(id, this);
            return;
        }
          goto _L5
_L2:
        if (item != null && (activity instanceof ItemViewActivity))
        {
            content = item;
            int j = ((Item) (content)).watchCount;
            if (!watch)
            {
                if (item.watchCount == 0)
                {
                    i = 0;
                } else
                {
                    i = -1;
                }
            }
            content.watchCount = i + j;
            ItemViewActivity.refreshOtherActivities(activity, item);
        }
        if (true) goto _L7; else goto _L6
_L6:
_L5:
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void execute()
    {
        dm.registerObserver(this);
        dm.loadWatchList();
        if (watch)
        {
            MyEbayWatchingDataManager myebaywatchingdatamanager = dm;
            long l1;
            if (item != null)
            {
                l1 = item.id;
            } else
            {
                l1 = ebayItemId;
            }
            myebaywatchingdatamanager.addToWatchList(this, new EbayItemIdAndVariationSpecifics[] {
                new EbayItemIdAndVariationSpecifics(l1, nameValueList)
            });
            return;
        }
        MyEbayWatchingDataManager myebaywatchingdatamanager1 = dm;
        long l2;
        if (item != null)
        {
            l2 = item.id;
        } else
        {
            l2 = ebayItemId;
        }
        myebaywatchingdatamanager1.removeFromWatchList(this, new EbayItemIdAndVariationSpecifics[] {
            new EbayItemIdAndVariationSpecifics(l2, nameValueList)
        });
    }

    public boolean isError()
    {
        return resultStatus.hasError();
    }

    public boolean isIafTokenInvalid()
    {
        return iafTokenInvalid;
    }

    public void onAddToWatchListComplete(MyEbayWatchingDataManager myebaywatchingdatamanager, Content content)
    {
        handleResult(content);
    }

    public void onRemoveAllFromWatchListComplete(MyEbayWatchingDataManager myebaywatchingdatamanager, ResultStatus resultstatus)
    {
    }

    public void onRemoveFromWatchListComplete(MyEbayWatchingDataManager myebaywatchingdatamanager, Content content)
    {
        handleResult(content);
    }

    public void onWatchingListChanged(MyEbayWatchingDataManager myebaywatchingdatamanager, String s, DatedContent datedcontent)
    {
    }
}
