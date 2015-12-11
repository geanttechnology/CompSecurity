// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.android.responses.AppCloudError;
import com.flurry.android.responses.AppCloudSearchResultCompletionHandler;
import java.util.ArrayList;

// Referenced classes of package com.flurry.android:
//            AppCloudResponseHandler, dn, AppCloudUser, AppCloudObject, 
//            AppCloudSearch, CacheSearchData, CacheSearchItemsData, AppCloudResponse

final class fa
    implements AppCloudResponseHandler
{

    private boolean gJ;
    private String gK;
    private AppCloudSearchResultCompletionHandler gL;
    private AppCloudSearch gq;

    fa(AppCloudSearch appcloudsearch, boolean flag, String s, AppCloudSearchResultCompletionHandler appcloudsearchresultcompletionhandler)
    {
        gq = appcloudsearch;
        gJ = flag;
        gK = s;
        gL = appcloudsearchresultcompletionhandler;
        super();
    }

    public final void handleResponse(AppCloudResponse appcloudresponse)
        throws Exception
    {
        boolean flag1 = false;
        boolean flag = false;
        dn dn1 = new dn(appcloudresponse, Boolean.valueOf(gJ));
        ArrayList arraylist = new ArrayList();
        if (dn1.isSuccessful())
        {
            long l = System.currentTimeMillis();
            if (gJ)
            {
                for (int i = 0; i < dn1.getUsers().size(); i++)
                {
                    appcloudresponse = (AppCloudUser)dn1.getUsers().get(i);
                    appcloudresponse.saveToCache();
                    arraylist.add(appcloudresponse);
                }

            } else
            {
                for (int j = 0; j < dn1.getObjects().size(); j++)
                {
                    appcloudresponse = (AppCloudObject)dn1.getObjects().get(j);
                    appcloudresponse.p(AppCloudSearch.a(gq));
                    arraylist.add(appcloudresponse);
                }

            }
            appcloudresponse = AppCloudSearch.c(gq).addItem(gK, AppCloudSearch.a(gq), l);
            int k = ((flag1) ? 1 : 0);
            if (gJ)
            {
                for (k = ((flag) ? 1 : 0); k < dn1.getUsers().size(); k++)
                {
                    String s = ((AppCloudUser)dn1.getUsers().get(k)).getId();
                    AppCloudSearch.d(gq).addItem(appcloudresponse, s, l);
                }

            } else
            {
                for (; k < dn1.getObjects().size(); k++)
                {
                    String s1 = ((AppCloudObject)dn1.getObjects().get(k)).getId();
                    AppCloudSearch.d(gq).addItem(appcloudresponse, s1, l);
                }

            }
            gL.onOperationSucceed(arraylist.toArray());
            return;
        } else
        {
            gL.onError(new AppCloudError(appcloudresponse.getHTTPResponseCode(), appcloudresponse.getResponseMessage()));
            return;
        }
    }
}
