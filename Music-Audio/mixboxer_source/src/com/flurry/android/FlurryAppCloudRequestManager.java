// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Base64;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            ek, AppCloudResponse, AppCloudResponseHandler, fb, 
//            ej, ec, fw, eh, 
//            ap, ei, bt, et, 
//            AppCloudUser, ed, gq

public class FlurryAppCloudRequestManager
{

    public static String UserSession = "";
    private static String dR = "";
    private static String dS = "{code: \"400\", note: \"Please use FlurryAppCloud.saveOrCreateUser() for updating users.\"}";
    private static String dT = "{code: \"400\", note: \"Please use FlurryAppCloud.saveOrCreateUser() for creating users.\"}";
    private static String dU = "{code: \"400\", note: \"Please use FlurryAppCloud.deleteUser() for deleting users.\"}";
    private static String dV = "del_internal";
    public static boolean fInternalApi = false;

    public FlurryAppCloudRequestManager()
    {
    }

    public static void Delete(String s, AppCloudResponseHandler appcloudresponsehandler)
        throws Exception
    {
        HashMap hashmap = new HashMap();
        a(hashmap);
        ek ek1 = new ek();
        hashmap.put(dV, ek1);
        hashmap.put("del", appcloudresponsehandler);
        hashmap.put("url", s);
        if (s.startsWith("v1/user") && !fInternalApi)
        {
            appcloudresponsehandler.handleResponse(new AppCloudResponse(new JSONObject(dU)));
            return;
        } else
        {
            (new fb()).execute(new HashMap[] {
                hashmap
            });
            fInternalApi = false;
            return;
        }
    }

    public static void Get(String s, List list, AppCloudResponseHandler appcloudresponsehandler)
        throws Exception
    {
        HashMap hashmap = new HashMap();
        a(hashmap);
        ej ej1 = new ej();
        hashmap.put(dV, ej1);
        hashmap.put("del", appcloudresponsehandler);
        if (list != null)
        {
            hashmap.put("url", (new StringBuilder()).append(s).append("/").append(ec.g(list)).toString());
        } else
        {
            hashmap.put("url", (new StringBuilder()).append(s).append("/").toString());
        }
        (new fw()).execute(new HashMap[] {
            hashmap
        });
    }

    public static void Post(String s, List list, AppCloudResponseHandler appcloudresponsehandler)
        throws Exception
    {
        HashMap hashmap = new HashMap();
        a(hashmap);
        eh eh1 = new eh();
        hashmap.put(dV, eh1);
        hashmap.put("del", appcloudresponsehandler);
        hashmap.put("url", s);
        hashmap.put("data", list);
        if (s.startsWith("v1/user") && !fInternalApi)
        {
            appcloudresponsehandler.handleResponse(new AppCloudResponse(new JSONObject(dT)));
            return;
        } else
        {
            (new ap()).execute(new HashMap[] {
                hashmap
            });
            fInternalApi = false;
            return;
        }
    }

    public static void Put(String s, List list, AppCloudResponseHandler appcloudresponsehandler)
        throws Exception
    {
        HashMap hashmap = new HashMap();
        a(hashmap);
        ei ei1 = new ei();
        hashmap.put(dV, ei1);
        hashmap.put("del", appcloudresponsehandler);
        hashmap.put("url", s);
        if (list == null)
        {
            hashmap.put("data", new ArrayList());
        } else
        {
            hashmap.put("data", list);
        }
        if (s.startsWith("v1/user") && !fInternalApi)
        {
            appcloudresponsehandler.handleResponse(new AppCloudResponse(new JSONObject(dS)));
            return;
        } else
        {
            (new bt()).execute(new HashMap[] {
                hashmap
            });
            fInternalApi = false;
            return;
        }
    }

    static void a(AppCloudResponse appcloudresponse, AppCloudResponseHandler appcloudresponsehandler, gq gq, HashMap hashmap)
    {
        try
        {
            if (appcloudresponse.isSuccessful())
            {
                appcloudresponsehandler.handleResponse(appcloudresponse);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (AppCloudResponse appcloudresponse)
        {
            appcloudresponse.printStackTrace();
            return;
        }
        if (appcloudresponse.getHTTPResponseCode() != 400 || !appcloudresponse.getResponseMessage().equals("invalid user session"))
        {
            break MISSING_BLOCK_LABEL_134;
        }
        Log.w("FlurryAppCloudRequestManager", (new StringBuilder()).append("CURRENT USER SESSION = ").append(UserSession).append(" IS NOT VALID!").toString());
        UserSession = "";
        et.aX();
        if (et.aY() == null)
        {
            et.be();
            appcloudresponsehandler.handleResponse(appcloudresponse);
            return;
        }
        AppCloudUser.setCurrentUser(et.aY());
        Log.w("FlurryAppCloudRequestManager", "TRYING TO RELOGIN WITH LAST USER!");
        AppCloudUser.loginWithEmail(et.bb(), et.bc(), new ed(hashmap, gq, appcloudresponsehandler));
        return;
        appcloudresponsehandler.handleResponse(appcloudresponse);
        return;
    }

    private static void a(HashMap hashmap)
    {
        hashmap.put("session", UserSession);
        hashmap.put("auth", dR);
    }

    static String ap()
    {
        return dV;
    }

    static void b(HashMap hashmap)
    {
        a(hashmap);
    }

    static void g(String s)
    {
        s = (new StringBuilder()).append(s).append(":").append(s).toString();
        dR = (new StringBuilder()).append("Basic ").append(Base64.encodeToString(s.getBytes(), 10)).toString();
    }

}
