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

final class d
    implements com.facebook.alizeCallback
{

    final Context a;
    final SharedPreferences b;
    final Long c;
    private boolean d;

    public final void onInitialized()
    {
        GraphRequest graphrequest = GraphRequest.newMyFriendsRequest(AccessToken.getCurrentAccessToken(), new com.facebook.GraphRequest.GraphJSONArrayCallback() {

            private FacebookUtils._cls16 a;

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
                        a.b.edit().putLong("facebook.anal.date", a.c.longValue()).apply();
                        AnalyticUtils.getInstance(a.a).trackDeviceContactInfo("facebook", graphresponse);
                    }
                }
            }

            
            {
                a = FacebookUtils._cls16.this;
                super();
            }
        });
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

    _cls1.a(Context context, SharedPreferences sharedpreferences, Long long1, boolean flag)
    {
        a = context;
        b = sharedpreferences;
        c = long1;
        d = flag;
        super();
    }
}
