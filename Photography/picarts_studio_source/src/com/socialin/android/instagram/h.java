// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.instagram;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.AddConnectionController;
import com.socialin.android.apiv3.controllers.RemoveConnectionController;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.InstagramConnection;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.oauth2.OAuth2BaseActivity;
import com.socialin.android.util.Utils;
import com.socialin.android.util.s;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import myobfuscated.cy.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.socialin.android.instagram:
//            a, b, c

public class h
{

    private static final String a = com/socialin/android/instagram/h.getSimpleName();

    public h()
    {
    }

    public static com.socialin.android.instagram.a a(Context context)
    {
        context = context.getSharedPreferences("InstagramPrefs", 4).getString("InstagramPrefs", null);
        if (TextUtils.isEmpty(context))
        {
            break MISSING_BLOCK_LABEL_69;
        }
        context = new com.socialin.android.instagram.a(new JSONObject(context));
        return context;
        context;
        com.socialin.android.d.b(a, (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString(), context);
        return null;
    }

    public static void a(Fragment fragment)
    {
        Intent intent = new Intent(fragment.getActivity(), com/socialin/android/oauth2/OAuth2BaseActivity);
        intent.putExtra("oauth2AuthorizationEndpoint", "https://api.instagram.com/oauth/authorize/");
        intent.putExtra("oauth2AccessTokenEndpoint", "https://api.instagram.com/oauth/access_token");
        intent.putExtra("oauth2ClientSecret", "56e884c8c2c14146819ce990bf76b070");
        intent.putExtra("oauth2ClientId", "c73708fbbf72408eb6b5dd676da16dba");
        intent.putExtra("oauth2UsePostRequest", true);
        intent.putExtra("oauth2SocialKey", 4);
        intent.putExtra("socialType", "Instagram");
        fragment.startActivityForResult(intent, 12);
    }

    public static void a(Context context, com.socialin.android.instagram.a a1)
    {
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_239;
        }
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences("InstagramPrefs", 4).edit();
        editor.putString("InstagramPrefs", a1.a().toString());
        editor.commit();
        if (!SocialinV3.getInstance().isRegistered()) goto _L2; else goto _L1
_L1:
        InstagramConnection instagramconnection;
        instagramconnection = new InstagramConnection();
        instagramconnection.token = a1.a;
        instagramconnection.connectionId = String.valueOf(a1.b.a);
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("name", a1.b.c);
        jsonobject.put("id", String.valueOf(a1.b.a));
        jsonobject.put("screen_name", a1.b.b);
        jsonobject.put("profile_img_url", a1.b.f);
        jsonobject.put("token", a1.a);
        jsonobject.put("token_secret", "");
        instagramconnection.setData(jsonobject);
_L3:
        a1 = new AddConnectionController();
        a1.setRequestParams(instagramconnection);
        a1.doRequest("add_connection", instagramconnection);
_L2:
        a(context, true);
        return;
        a1;
        com.socialin.android.d.b(a, "addInstagramConnection", a1);
          goto _L3
        context;
        com.socialin.android.d.b(a, (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString(), context);
    }

    public static void a(Context context, boolean flag)
    {
label0:
        {
            com.socialin.android.apiv3.model.AppProps.Data data = SocialinV3.getInstance().getAppProps().getData();
            if (SocialinV3.getInstance().getSettings().isContactSyncEnabled())
            {
                Long long1 = Long.valueOf(myobfuscated.cy.a.a(context).getLong("instagram.anal.date", 0L));
                long l = (new Date()).getTime();
                if (long1.longValue() == 0L || Long.valueOf(l).longValue() - long1.longValue() > data.social.getIntervalInMillis())
                {
                    context = new Runnable(context) {

                        private Context a;

                        public final void run()
                        {
                            Object obj = com.socialin.android.instagram.h.d(a);
                            if (obj != null && !((List) (obj)).isEmpty())
                            {
                                JSONArray jsonarray = new JSONArray();
                                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
                                {
                                    String s1 = (String)((Iterator) (obj)).next();
                                    JSONObject jsonobject = new JSONObject();
                                    try
                                    {
                                        jsonobject.put("identifier", s1);
                                        jsonarray.put(jsonobject);
                                    }
                                    catch (JSONException jsonexception)
                                    {
                                        jsonexception.printStackTrace();
                                    }
                                }

                                if (s.a(a))
                                {
                                    myobfuscated.cy.a.a(a).edit().putLong("instagram.anal.date", (new Date()).getTime()).apply();
                                    AnalyticUtils.getInstance(a).trackDeviceContactInfo("instagram", jsonarray);
                                }
                            }
                        }

            
            {
                a = context;
                super();
            }
                    };
                    if (!flag)
                    {
                        break label0;
                    }
                    (new Thread(context)).start();
                }
            }
            return;
        }
        context.run();
    }

    public static boolean a(String s, List list)
    {
        if (list != null && !list.isEmpty()) goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
_L4:
        return flag1;
_L2:
        int i = 0;
        boolean flag = false;
        do
        {
            flag1 = flag;
            if (i >= list.size())
            {
                continue;
            }
            if (((c)list.get(i)).a.equals(s))
            {
                flag = true;
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void b(Context context, com.socialin.android.instagram.a a1)
    {
        try
        {
            context.getSharedPreferences("InstagramPrefs", 4).edit().putString("InstagramPrefs", a1.a().toString()).commit();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.socialin.android.d.b(a, (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString(), context);
        }
    }

    public static boolean b(Context context)
    {
        return context.getSharedPreferences("InstagramPrefs", 4).getString("InstagramPrefs", null) != null;
    }

    public static void c(Context context)
    {
        try
        {
            Object obj = context.getSharedPreferences("InstagramPrefs", 4);
            context = ((SharedPreferences) (obj)).getString("instagram_tab_activity", null);
            obj = ((SharedPreferences) (obj)).edit();
            ((android.content.SharedPreferences.Editor) (obj)).clear();
            ((android.content.SharedPreferences.Editor) (obj)).putString("instagram_tab_activity", context);
            ((android.content.SharedPreferences.Editor) (obj)).commit();
            if (SocialinV3.getInstance().isRegistered())
            {
                context = SocialinV3.getInstance().getUser();
                (new RemoveConnectionController()).doRequest(null, ((User) (context)).connections.getInstagramConnection());
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.socialin.android.d.b(a, "clearData", context);
        }
    }

    public static List d(Context context)
    {
        JSONArray jsonarray;
        Object obj;
        jsonarray = null;
        obj = null;
        com.socialin.android.instagram.a a1 = a(context.getApplicationContext());
        context = jsonarray;
        if (a1 == null) goto _L2; else goto _L1
_L1:
        context = jsonarray;
        if (a1.b == null) goto _L2; else goto _L3
_L3:
        context = jsonarray;
        if (TextUtils.isEmpty(a1.b.a)) goto _L2; else goto _L4
_L4:
        context = new ArrayList();
        jsonarray = ((JSONObject)(new JSONTokener(Utils.a((new URL((new StringBuilder("https://api.instagram.com/v1/users/")).append(a1.b.a).append("/follows?access_token=").append(a1.a).toString())).openConnection().getInputStream()))).nextValue()).getJSONArray("data");
        int i = 0;
_L6:
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        context.add(jsonarray.getJSONObject(i).get("id").toString());
        i++;
        if (true) goto _L6; else goto _L5
        Exception exception;
        exception;
        context = obj;
_L7:
        com.socialin.android.d.b(a, "getFollowsIds", exception);
_L2:
        return context;
        exception;
        if (true) goto _L7; else goto _L5
_L5:
        return context;
    }

}
