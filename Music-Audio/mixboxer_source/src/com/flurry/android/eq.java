// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.text.TextUtils;
import android.util.Log;
import com.flurry.android.caching.CachingManager;
import com.flurry.android.caching.ObjectOperationData;
import com.flurry.android.responses.AppCloudSearchResultCompletionHandler;
import java.util.ArrayList;

// Referenced classes of package com.flurry.android:
//            AppCloudSearch, CacheSearchData, CacheSearchItemsData, AppCloudUser, 
//            AppCloudObject, FlurryAppCloud, fa

final class eq
    implements Runnable
{

    private AppCloudSearchResultCompletionHandler gp;
    private AppCloudSearch gq;

    eq(AppCloudSearch appcloudsearch, AppCloudSearchResultCompletionHandler appcloudsearchresultcompletionhandler)
    {
        gq = appcloudsearch;
        super();
        gp = null;
        gp = appcloudsearchresultcompletionhandler;
    }

    public final void run()
    {
        int i = 0;
        Object obj;
        Object obj1;
        Object obj2;
        boolean flag;
        if (TextUtils.isEmpty(AppCloudSearch.a(gq)))
        {
            obj = (new StringBuilder()).append("v1/").append("user").toString();
            flag = true;
        } else
        {
            obj = (new StringBuilder()).append("v1/").append("object/").append(AppCloudSearch.a(gq)).toString();
            flag = false;
        }
        obj1 = AppCloudSearch.b(gq);
        obj2 = (new StringBuilder()).append(((String) (obj))).append(((String) (obj1))).toString();
        Log.w("SearchCache", (new StringBuilder()).append("url = ").append(((String) (obj2))).toString());
        obj = AppCloudSearch.c(gq).contains(((String) (obj1)), AppCloudSearch.a(gq));
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            obj = AppCloudSearch.d(gq).getItemsById(((String) (obj)));
            obj1 = new ArrayList();
            while (i < ((ArrayList) (obj)).size()) 
            {
                if (flag)
                {
                    obj2 = new AppCloudUser();
                    ((AppCloudUser) (obj2)).q((String)((ArrayList) (obj)).get(i));
                    ((ArrayList) (obj1)).add(obj2);
                } else
                {
                    obj2 = new AppCloudObject(AppCloudSearch.a(gq));
                    ((AppCloudObject) (obj2)).q((String)((ArrayList) (obj)).get(i));
                    ((ArrayList) (obj1)).add(obj2);
                }
                i++;
            }
            gp.onOperationSucceed(((ArrayList) (obj1)).toArray());
            return;
        } else
        {
            ObjectOperationData objectoperationdata = new ObjectOperationData("");
            objectoperationdata.setSearchURL(((String) (obj2)));
            obj2 = gq;
            AppCloudSearchResultCompletionHandler appcloudsearchresultcompletionhandler = gp;
            FlurryAppCloud.C().searchOperation(objectoperationdata, new fa(((AppCloudSearch) (obj2)), flag, ((String) (obj1)), appcloudsearchresultcompletionhandler));
            return;
        }
    }
}
