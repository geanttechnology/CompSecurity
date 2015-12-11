// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.controllers;

import android.content.Intent;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.Showroom;
import com.poshmark.data_model.models.ShowroomGroup;
import com.poshmark.data_model.models.ShowroomGroupList;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

public class ShowroomsController
    implements PMNotificationListener
{

    static ShowroomsController globalShowroomsController = null;
    Date lastFetchTime;
    ShowroomGroupList showroomGroupList;

    private ShowroomsController()
    {
        showroomGroupList = null;
        lastFetchTime = null;
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.NEW_SHOWROOMS_ON_SERVER", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGOUT_COMPLETE", this);
    }

    public static ShowroomsController getGlobalShowroomsController()
    {
        if (globalShowroomsController == null)
        {
            globalShowroomsController = new ShowroomsController();
        }
        return globalShowroomsController;
    }

    public void fillCursor(CustomMatrixCursor custommatrixcursor)
    {
        List list = showroomGroupList.getList();
        for (int i = 0; i < list.size(); i++)
        {
            for (ListIterator listiterator = ((ShowroomGroup)list.get(i)).getCollections().listIterator(); listiterator.hasNext(); custommatrixcursor.addRow(new Object[] {
    Integer.valueOf(0), (Showroom)listiterator.next()
})) { }
        }

    }

    public List getAllShowrooms()
    {
        if (showroomGroupList != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((List) (obj));
_L2:
        List list = showroomGroupList.getList();
        ArrayList arraylist = new ArrayList();
        int i = 0;
        do
        {
            obj = arraylist;
            if (i >= list.size())
            {
                continue;
            }
            arraylist.addAll(((ShowroomGroup)list.get(i)).getCollections());
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Showroom getShowroomWithId(String s)
    {
        Showroom showroom;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        showroom = null;
        return showroom;
        Showroom showroom1;
        List list;
        List list1;
        int i;
        int j;
        if (showroomGroupList == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        list = showroomGroupList.getList();
        i = 0;
          goto _L1
        continue; /* Loop/switch isn't completed */
        i++;
    }

    void getShowroomsData()
    {
        PMApi.getShowrooms(new PMApiResponseHandler() {

            final ShowroomsController this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (!pmapiresponse.hasError())
                {
                    showroomGroupList = (ShowroomGroupList)pmapiresponse.data;
                    lastFetchTime = new Date();
                    if (showroomGroupList != null)
                    {
                        PMNotificationManager.fireNotification("com.poshmark.intents.SHOWROOMS_FETCH_COMPLETE");
                    }
                }
            }

            
            {
                this$0 = ShowroomsController.this;
                super();
            }
        });
    }

    public ShowroomGroup getTrendingShowroomGroup()
    {
        if (showroomGroupList != null) goto _L2; else goto _L1
_L1:
        ShowroomGroup showroomgroup = null;
_L4:
        return showroomgroup;
_L2:
        List list = showroomGroupList.getList();
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= list.size())
                {
                    break label1;
                }
                ShowroomGroup showroomgroup1 = (ShowroomGroup)list.get(i);
                showroomgroup = showroomgroup1;
                if (showroomgroup1.getTag().toLowerCase().endsWith("trending"))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return null;
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.LOGOUT_COMPLETE"))
        {
            showroomGroupList = null;
            lastFetchTime = null;
        } else
        if (intent.getAction().equals("com.poshmark.intents.NEW_SHOWROOMS_ON_SERVER"))
        {
            getShowroomsData();
            return;
        }
    }

    public boolean isModelPopulated()
    {
        return showroomGroupList != null;
    }

    public boolean lastUpdatedBefore(Date date)
    {
        return lastFetchTime == null || lastFetchTime.before(date);
    }

}
