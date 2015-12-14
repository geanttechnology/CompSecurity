// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.s;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.facebook.util:
//            FacebookUtils

final class a
    implements com.facebook.SONArrayCallback
{

    private iceContactInfo a;

    public final void onCompleted(JSONArray jsonarray, GraphResponse graphresponse)
    {
        if (jsonarray != null && jsonarray.length() > 0)
        {
            graphresponse = new JSONArray();
            int i = 0;
            while (i < jsonarray.length()) 
            {
                try
                {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    JSONObject jsonobject1 = new JSONObject();
                    jsonobject1.put("identifier", jsonobject.optString("id", "0"));
                    graphresponse.put(jsonobject1);
                }
                catch (JSONException jsonexception)
                {
                    jsonexception.printStackTrace();
                }
                i++;
            }
            if (s.a(a.a))
            {
                a.a.edit().putLong("facebook.anal.date", a.a.longValue()).apply();
                AnalyticUtils.getInstance(a.a).trackDeviceContactInfo("facebook", graphresponse);
            }
        }
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/socialin/android/facebook/util/FacebookUtils$16

/* anonymous class */
    final class FacebookUtils._cls16
        implements com.facebook.FacebookSdk.InitializeCallback
    {

        final Context a;
        final SharedPreferences b;
        final Long c;
        private boolean d;

        public final void onInitialized()
        {
            GraphRequest graphrequest = GraphRequest.newMyFriendsRequest(AccessToken.getCurrentAccessToken(), new FacebookUtils._cls16._cls1(this));
            if (d)
            {
                graphrequest.executeAsync();
                return;
            } else
            {
                graphrequest.executeAndWait();
                return;
            }
        }

            
            {
                a = context;
                b = sharedpreferences;
                c = long1;
                d = flag;
                super();
            }
    }

}
