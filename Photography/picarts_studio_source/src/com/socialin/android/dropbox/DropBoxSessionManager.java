// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.dropbox;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AuthActivity;
import com.dropbox.client2.android.a;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session;
import com.socialin.android.d;
import com.socialin.android.util.Utils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DropBoxSessionManager
{

    private static final String ACCESS_KEY_NAME = "ACCESS_KEY";
    private static DropBoxSessionManager instance;
    private Context context;
    private DropboxAPI mApi;
    private SharedPreferences settings;

    public DropBoxSessionManager(Context context1)
    {
        context = null;
        context = context1;
        settings = context1.getSharedPreferences("DropboxPrefs", 0);
    }

    private a buildSession()
    {
        a a1 = new a(new AppKeyPair("qz0ubwmycfmwyj3", "jfjgbiwc8npdzrr"));
        loadAuth(a1);
        return a1;
    }

    public static DropBoxSessionManager getInstance(Context context1)
    {
        if (instance == null)
        {
            instance = new DropBoxSessionManager(context1);
        }
        return instance;
    }

    private void loadAuth(a a1)
    {
        String s = settings.getString("ACCESS_KEY", null);
        String s1 = settings.getString("oauth2AccessToken", null);
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1) && "oauth2:".equals(s))
        {
            a1.a(s1);
        }
    }

    public boolean checkDropBoxSession()
    {
        return com.socialin.android.oauth2.a.b(settings);
    }

    public void clearDropBoxSession()
    {
        Utils.c(context);
        com.socialin.android.oauth2.a.a(settings);
        instance = null;
    }

    public DropboxAPI getApi()
    {
        return mApi;
    }

    public List getTokensFromSyncAPI()
    {
        ArrayList arraylist;
        int i;
        i = 0;
        arraylist = new ArrayList();
        JSONArray jsonarray = new JSONArray(settings.getString("accounts", null));
_L2:
        if (i < jsonarray.length())
        {
            String s = jsonarray.getJSONObject(i).getString("userToken");
            if (s.startsWith("|oa2|"))
            {
                arraylist.add(s.substring(6));
                break MISSING_BLOCK_LABEL_117;
            }
            try
            {
                String as[] = s.split("\\|");
                arraylist.add(new AccessTokenPair(as[0], as[1]));
                break MISSING_BLOCK_LABEL_117;
            }
            catch (JSONException jsonexception)
            {
                d.a("dropbox", jsonexception);
            }
        }
        return arraylist;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean handleAuthCallback()
    {
        if (mApi != null && a.a())
        {
            try
            {
                ((a)mApi.a).b();
                storeAuth((a)mApi.a);
            }
            catch (IllegalStateException illegalstateexception)
            {
                d.a("DbAuthLog", new Object[] {
                    "Error authenticating", illegalstateexception
                });
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void startDropBoxNewSession()
    {
        mApi = new DropboxAPI(buildSession());
        Object obj = (a)mApi.a;
        Context context1 = context;
        obj = ((Session) (obj)).a;
        if (AuthActivity.a(context1, ((AppKeyPair) (obj)).key))
        {
            AuthActivity.a(((AppKeyPair) (obj)).key, null, null);
            obj = new Intent(context1, com/dropbox/client2/android/AuthActivity);
            if (!(context1 instanceof Activity))
            {
                ((Intent) (obj)).addFlags(0x10000000);
            }
            context1.startActivity(((Intent) (obj)));
        }
    }

    public void storeAuth(a a1)
    {
        a1 = ((Session) (a1)).b;
        if (a1 != null)
        {
            android.content.SharedPreferences.Editor editor = settings.edit();
            editor.putString("ACCESS_KEY", "oauth2:");
            editor.putString("oauth2AccessToken", a1);
            editor.commit();
        }
    }
}
