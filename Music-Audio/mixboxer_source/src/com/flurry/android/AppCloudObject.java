// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.text.TextUtils;
import com.flurry.android.responses.AppCloudApplyOperationResonseHandler;
import com.flurry.android.responses.AppCloudCommonOperationResponseHandler;
import com.flurry.android.responses.AppCloudError;
import com.flurry.android.responses.AppCloudGetObjectByIDResponseHandler;
import java.util.Vector;
import org.apache.http.NameValuePair;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            cx, AppCloudUser, AppCloudSearch, bn, 
//            AppCloudValueUpdateHandler, r, AppCloudResponse, bq, 
//            br, FlurryAppCloud, CacheSyncManager, az

public class AppCloudObject extends cx
{

    AppCloudObject(String s)
    {
        mCollectionName = s;
    }

    public AppCloudObject(JSONObject jsonobject)
    {
        createObject(jsonobject);
    }

    public static AppCloudSearch SearchWithCollectionName(String s)
    {
        while (AppCloudUser.getCurrentUser() == null || TextUtils.isEmpty(s)) 
        {
            return null;
        }
        return new AppCloudSearch(s);
    }

    public static AppCloudObject create(String s)
    {
        return new AppCloudObject(s);
    }

    public static void getObjectById(String s, String s1, AppCloudGetObjectByIDResponseHandler appcloudgetobjectbyidresponsehandler)
        throws Exception
    {
        s1 = new AppCloudObject(s1);
        s1.setId(s);
        s1.getObjectOrUser(new bn(appcloudgetobjectbyidresponsehandler));
    }

    public void addObserverForKey(String s, AppCloudValueUpdateHandler appcloudvalueupdatehandler)
    {
        if (TextUtils.isEmpty(mId))
        {
            appcloudvalueupdatehandler.onError(new AppCloudError(400, "Please assign an object id."));
            return;
        }
        if (TextUtils.isEmpty(mCollectionName))
        {
            appcloudvalueupdatehandler.onError(new AppCloudError(400, "Please assign a collection name."));
            return;
        } else
        {
            r.a(mId, mCollectionName, s, appcloudvalueupdatehandler);
            return;
        }
    }

    public volatile boolean containsObserver()
    {
        return super.containsObserver();
    }

    public void decrement(String s, float f, AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
        throws Exception
    {
        if (TextUtils.isEmpty(mId))
        {
            s = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Please assign an object id.\"}"));
            appcloudcommonoperationresponsehandler.onError(new AppCloudError(s.getHTTPResponseCode(), s.getResponseMessage()));
            return;
        }
        if (TextUtils.isEmpty(mCollectionName))
        {
            s = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Please assign a collection name.\"}"));
            appcloudcommonoperationresponsehandler.onError(new AppCloudError(s.getHTTPResponseCode(), s.getResponseMessage()));
            return;
        } else
        {
            super.decrement(s, String.valueOf(f), appcloudcommonoperationresponsehandler);
            return;
        }
    }

    public void decrement(String s, int i, AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
        throws Exception
    {
        if (TextUtils.isEmpty(mId))
        {
            s = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Please assign an object id.\"}"));
            appcloudcommonoperationresponsehandler.onError(new AppCloudError(s.getHTTPResponseCode(), s.getResponseMessage()));
            return;
        }
        if (TextUtils.isEmpty(mCollectionName))
        {
            s = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Please assign a collection name.\"}"));
            appcloudcommonoperationresponsehandler.onError(new AppCloudError(s.getHTTPResponseCode(), s.getResponseMessage()));
            return;
        } else
        {
            super.decrement(s, String.valueOf(i), appcloudcommonoperationresponsehandler);
            return;
        }
    }

    public void deleteWithCompletionHandler(AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
        throws Exception
    {
        if (TextUtils.isEmpty(mId))
        {
            AppCloudResponse appcloudresponse = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Please assign an object id.\"}"));
            appcloudcommonoperationresponsehandler.onError(new AppCloudError(appcloudresponse.getHTTPResponseCode(), appcloudresponse.getResponseMessage()));
            return;
        }
        if (TextUtils.isEmpty(mCollectionName))
        {
            AppCloudResponse appcloudresponse1 = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Please assign a collection name.\"}"));
            appcloudcommonoperationresponsehandler.onError(new AppCloudError(appcloudresponse1.getHTTPResponseCode(), appcloudresponse1.getResponseMessage()));
            return;
        } else
        {
            delete(new bq(appcloudcommonoperationresponsehandler));
            return;
        }
    }

    public volatile String get(String s)
    {
        return super.get(s);
    }

    public String getCollectionName()
    {
        return mCollectionName;
    }

    public volatile float getFloat(String s)
    {
        return super.getFloat(s);
    }

    public volatile String getId()
    {
        return super.getId();
    }

    public volatile int getInt(String s)
    {
        return super.getInt(s);
    }

    public volatile Vector getKeyValues()
    {
        return super.getKeyValues();
    }

    public void getWithCompletionHandler(AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
        throws Exception
    {
        if (TextUtils.isEmpty(mId))
        {
            AppCloudResponse appcloudresponse = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Please assign an object id.\"}"));
            appcloudcommonoperationresponsehandler.onError(new AppCloudError(appcloudresponse.getHTTPResponseCode(), appcloudresponse.getResponseMessage()));
            return;
        }
        if (TextUtils.isEmpty(mCollectionName))
        {
            AppCloudResponse appcloudresponse1 = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Please assign a collection name.\"}"));
            appcloudcommonoperationresponsehandler.onError(new AppCloudError(appcloudresponse1.getHTTPResponseCode(), appcloudresponse1.getResponseMessage()));
            return;
        } else
        {
            getObjectOrUser(new br(appcloudcommonoperationresponsehandler));
            return;
        }
    }

    public void increment(String s, float f, AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
        throws Exception
    {
        if (TextUtils.isEmpty(mId))
        {
            s = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Please assign an object id.\"}"));
            appcloudcommonoperationresponsehandler.onError(new AppCloudError(s.getHTTPResponseCode(), s.getResponseMessage()));
            return;
        }
        if (TextUtils.isEmpty(mCollectionName))
        {
            s = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Please assign a collection name.\"}"));
            appcloudcommonoperationresponsehandler.onError(new AppCloudError(s.getHTTPResponseCode(), s.getResponseMessage()));
            return;
        } else
        {
            super.increment(s, String.valueOf(f), appcloudcommonoperationresponsehandler);
            return;
        }
    }

    public void increment(String s, int i, AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
        throws Exception
    {
        if (TextUtils.isEmpty(mId))
        {
            s = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Please assign an object id.\"}"));
            appcloudcommonoperationresponsehandler.onError(new AppCloudError(s.getHTTPResponseCode(), s.getResponseMessage()));
            return;
        }
        if (TextUtils.isEmpty(mCollectionName))
        {
            s = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Please assign a collection name.\"}"));
            appcloudcommonoperationresponsehandler.onError(new AppCloudError(s.getHTTPResponseCode(), s.getResponseMessage()));
            return;
        } else
        {
            super.increment(s, String.valueOf(i), appcloudcommonoperationresponsehandler);
            return;
        }
    }

    public volatile boolean isAutoSyncEnabled()
    {
        return super.isAutoSyncEnabled();
    }

    final void p(String s)
    {
        mCollectionName = s;
        for (int i = 0; i < getKeyValues().size(); i++)
        {
            s = ((NameValuePair)getKeyValues().get(i)).getName();
            String s1 = ((NameValuePair)getKeyValues().get(i)).getValue();
            FlurryAppCloud.D().getServerData().b(s, s1, mId, mCollectionName);
        }

    }

    public volatile boolean removeAllObservers()
    {
        return super.removeAllObservers();
    }

    public volatile boolean removeObserver(AppCloudValueUpdateHandler appcloudvalueupdatehandler)
    {
        return super.removeObserver(appcloudvalueupdatehandler);
    }

    public volatile boolean removeObserverForKey(String s)
    {
        return super.removeObserverForKey(s);
    }

    public void saveOrCreateWithCompletionHandler(AppCloudApplyOperationResonseHandler appcloudapplyoperationresonsehandler)
        throws Exception
    {
        if (TextUtils.isEmpty(mCollectionName))
        {
            AppCloudResponse appcloudresponse = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Please assign a collection name.\"}"));
            appcloudapplyoperationresonsehandler.onError(new AppCloudError(appcloudresponse.getHTTPResponseCode(), appcloudresponse.getResponseMessage()));
            return;
        } else
        {
            super.saveOrCreateWithCompletionHandler(appcloudapplyoperationresonsehandler);
            return;
        }
    }

    public volatile void saveToCache()
    {
        super.saveToCache();
    }

    public volatile void set(String s, Object obj)
    {
        super.set(s, obj);
    }

    public volatile boolean setAutoSyncEnabled(boolean flag)
    {
        return super.setAutoSyncEnabled(flag);
    }

    public String toString()
    {
        String s = (new StringBuilder()).append("").append("Collection name = ").append(mCollectionName).append(" ; ").toString();
        return (new StringBuilder()).append(s).append(super.toString()).toString();
    }
}
