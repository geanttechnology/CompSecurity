// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.view.View;
import com.ebay.common.EbayTimer;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.model.RemindersList;
import com.ebay.common.net.api.aps.ApplicationProcessServiceApi;
import com.ebay.common.util.EbayAsyncTask;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.myebay:
//            ReminderItemsActivity

private final class setHandler extends EbayAsyncTask
    implements com.ebay.common.util.k
{

    private final ApplicationProcessServiceApi api;
    private final String iafToken;
    private final int myType;
    private final String pageLocator;
    final ReminderItemsActivity this$0;
    private final String userId;

    protected RemindersList doInBackgroundInternal(Object obj)
        throws com.ebay.nautilus.kernel.net.dler, com.ebay.nautilus.kernel.net.dler, com.ebay.common.net., com.ebay.nautilus.kernel.net.dler, IOException, InterruptedException
    {
        if (!Util.hasNetwork())
        {
            throw new IOException();
        } else
        {
            return api.getReminderItems(iafToken, userId, myType, 25, pageLocator);
        }
    }

    protected volatile Object doInBackgroundInternal(Object obj)
        throws com.ebay.nautilus.kernel.net.cator, com.ebay.nautilus.kernel.net.cator, com.ebay.common.net., com.ebay.nautilus.kernel.net.cator, IOException, InterruptedException
    {
        return doInBackgroundInternal(obj);
    }

    public void onError(int i, List list)
    {
        ReminderItemsActivity.access$600(ReminderItemsActivity.this).clearSavedSearchList();
        if (!isFinishing() && i == -1 && EbayErrorUtil.userNotLoggedIn(list) && MyApp.getPrefs().isSignedIn())
        {
            ReminderItemsActivity.access$700(ReminderItemsActivity.this).cancelAll(true);
            MyApp.signOutForIafTokenFailure(ReminderItemsActivity.this);
        } else
        {
            (new EbayErrorHandler(ReminderItemsActivity.this, true)).handleEbayError(i, list);
            if (i == -2 && !isFinishing())
            {
                finish();
                return;
            }
        }
    }

    protected void onPostExecute(RemindersList reminderslist)
    {
        super.onPostExecute(reminderslist);
        if (reminderslist == null)
        {
            ReminderItemsActivity.access$200(ReminderItemsActivity.this);
        } else
        {
            ReminderItemsActivity.access$302(ReminderItemsActivity.this, reminderslist.hasMore);
            ReminderItemsActivity.access$402(ReminderItemsActivity.this, reminderslist.nextPageLocator);
            reminderslist = reminderslist.list;
            if (myType == 1 && reminderslist != null)
            {
                for (int i = 0; i < reminderslist.size(); i++)
                {
                    MyEbayListItem myebaylistitem = (MyEbayListItem)reminderslist.get(i);
                    if (myebaylistitem != null && myebaylistitem.transaction != null && myebaylistitem.transaction.kgroundInternal != null && myebaylistitem.transaction.kgroundInternal.equalsIgnoreCase("Refunded"))
                    {
                        reminderslist.remove(i);
                    }
                }

            }
            if (myType == 14 && reminderslist != null)
            {
                for (Iterator iterator = reminderslist.iterator(); iterator.hasNext();)
                {
                    ((MyEbayListItem)iterator.next()).bestOfferPendingCount = 1;
                }

            }
            if (myType == 5 && reminderslist != null)
            {
                for (Iterator iterator1 = reminderslist.iterator(); iterator1.hasNext();)
                {
                    ((MyEbayListItem)iterator1.next()).bestOfferStatus = "Pending";
                }

            }
            itemList.addAll(reminderslist);
            ReminderItemsActivity.access$500(ReminderItemsActivity.this).notifyDataSetChanged();
            ReminderItemsActivity.access$500(ReminderItemsActivity.this).refresh(getListView());
            ReminderItemsActivity.access$200(ReminderItemsActivity.this);
            if (ReminderItemsActivity.access$000(ReminderItemsActivity.this))
            {
                ReminderItemsActivity.access$100(ReminderItemsActivity.this).start();
                return;
            }
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((RemindersList)obj);
    }

    protected void onPreExecute()
    {
        if (ReminderItemsActivity.access$000(ReminderItemsActivity.this))
        {
            ReminderItemsActivity.access$100(ReminderItemsActivity.this).stop();
        }
        super.onPreExecute();
    }

    public void onTaskComplete(RemindersList reminderslist)
    {
        findViewById(0x102000a).setEnabled(true);
    }

    public volatile void onTaskComplete(Object obj)
    {
        onTaskComplete((RemindersList)obj);
    }

    protected (EbayContext ebaycontext, String s, String s1, int i, String s2)
    {
        this$0 = ReminderItemsActivity.this;
        super();
        api = EbayApiUtil.getApsApi(ebaycontext);
        iafToken = s;
        userId = s1;
        myType = i;
        pageLocator = s2;
        setHandler(this);
    }
}
