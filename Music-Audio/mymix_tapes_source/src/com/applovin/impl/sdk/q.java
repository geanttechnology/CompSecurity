// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.applovin.sdk.AppLovinLogger;
import java.io.InputStream;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.applovin.impl.sdk:
//            r, AppLovinSdkImpl, bw, bz

class q
{

    private static final int a[] = {
        7, 4, 2, 1, 11
    };
    private static final int b[] = {
        5, 6, 10, 3, 9, 8, 14
    };
    private static final int c[] = {
        15, 12, 13
    };
    private static final String d = com/applovin/impl/sdk/q.getSimpleName();

    q()
    {
    }

    private static NetworkInfo a(Context context)
    {
        if (r.a("android.permission.ACCESS_NETWORK_STATE", context))
        {
            context = (ConnectivityManager)context.getSystemService("connectivity");
            if (context != null)
            {
                return context.getActiveNetworkInfo();
            }
        }
        return null;
    }

    static String a(AppLovinSdkImpl applovinsdkimpl)
    {
        Object obj = a(applovinsdkimpl.getApplicationContext());
        if (obj != null)
        {
            int i = ((NetworkInfo) (obj)).getType();
            int j = ((NetworkInfo) (obj)).getSubtype();
            if (i == 1)
            {
                obj = "wifi";
            } else
            if (i == 0)
            {
                if (a(j, a))
                {
                    obj = "2g";
                } else
                if (a(j, b))
                {
                    obj = "3g";
                } else
                if (a(j, c))
                {
                    obj = "4g";
                } else
                {
                    obj = "mobile";
                }
            } else
            {
                obj = "unknown";
            }
            applovinsdkimpl.getLogger().d(d, (new StringBuilder()).append("Network ").append(i).append("/").append(j).append(" resolved to ").append(((String) (obj))).toString());
            return ((String) (obj));
        } else
        {
            return "unknown";
        }
    }

    static String a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return null;
        }
        inputstream = new Scanner(inputstream, "UTF-8");
        StringBuilder stringbuilder = new StringBuilder();
        for (; inputstream.hasNextLine(); stringbuilder.append(inputstream.nextLine())) { }
        return stringbuilder.toString();
    }

    static String a(String s)
    {
        if (s.startsWith("https://"))
        {
            return s;
        } else
        {
            return s.replace("http://", "https://");
        }
    }

    static String a(String s, AppLovinSdkImpl applovinsdkimpl)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("No endpoint specified");
        }
        if (applovinsdkimpl == null)
        {
            throw new IllegalArgumentException("No sdk specified");
        }
        String s1 = (String)applovinsdkimpl.a(bw.e);
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append((String)applovinsdkimpl.a(bw.k));
        stringbuilder.append(s);
        if (s1 != null && s1.length() > 0)
        {
            stringbuilder.append("?device_token=");
            stringbuilder.append(s1);
        } else
        {
            stringbuilder.append("?api_key=");
            stringbuilder.append(applovinsdkimpl.getSdkKey());
        }
        return stringbuilder.toString();
    }

    static JSONObject a(JSONObject jsonobject)
    {
        return (JSONObject)jsonobject.getJSONArray("results").get(0);
    }

    static void a(int i, AppLovinSdkImpl applovinsdkimpl)
    {
        bz bz1 = applovinsdkimpl.getSettingsManager();
        if (i == 401)
        {
            bz1.a(bw.c, "");
            bz1.a(bw.e, "");
            bz1.a(bw.m, Long.valueOf(0L));
            bz1.b();
        } else
        {
            if (i == 418)
            {
                bz1.a(bw.a, Boolean.valueOf(true));
                bz1.b();
                return;
            }
            if (i >= 400 && i < 500)
            {
                applovinsdkimpl.g();
                return;
            }
            if (i == -1)
            {
                applovinsdkimpl.g();
                return;
            }
        }
    }

    static void a(JSONObject jsonobject, AppLovinSdkImpl applovinsdkimpl)
    {
        if (jsonobject == null)
        {
            throw new IllegalArgumentException("No response specified");
        }
        if (applovinsdkimpl == null)
        {
            throw new IllegalArgumentException("No sdk specified");
        }
        try
        {
            if (jsonobject.has("settings"))
            {
                bz bz1 = applovinsdkimpl.getSettingsManager();
                if (!jsonobject.isNull("settings"))
                {
                    bz1.a(jsonobject.getJSONObject("settings"));
                    bz1.b();
                    applovinsdkimpl.getLogger().d(d, "New settings processed");
                }
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            applovinsdkimpl.getLogger().e(d, "Unable to parse settings out of API response", jsonobject);
        }
    }

    private static boolean a(int i, int ai[])
    {
        boolean flag1 = false;
        int k = ai.length;
        int j = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (j < k)
                {
                    if (ai[j] != i)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            j++;
        } while (true);
    }

    static String b(String s, AppLovinSdkImpl applovinsdkimpl)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("No endpoint specified");
        }
        if (applovinsdkimpl == null)
        {
            throw new IllegalArgumentException("No sdk specified");
        } else
        {
            return (new StringBuilder()).append((String)applovinsdkimpl.a(bw.l)).append(s).toString();
        }
    }

    static void b(int i, AppLovinSdkImpl applovinsdkimpl)
    {
        if (i == 418)
        {
            applovinsdkimpl = applovinsdkimpl.getSettingsManager();
            applovinsdkimpl.a(bw.a, Boolean.valueOf(true));
            applovinsdkimpl.b();
        }
    }

}
