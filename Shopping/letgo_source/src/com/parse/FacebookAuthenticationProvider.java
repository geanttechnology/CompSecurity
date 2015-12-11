// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.cu;
import com.facebook.AccessToken;
import com.facebook.d;
import com.facebook.h;
import com.facebook.k;
import com.facebook.login.f;
import com.facebook.login.g;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.SimpleTimeZone;

// Referenced classes of package com.parse:
//            ParseAuthenticationProvider

class FacebookAuthenticationProvider extends ParseAuthenticationProvider
{
    public static final class LoginAuthorizationType extends Enum
    {

        private static final LoginAuthorizationType $VALUES[];
        public static final LoginAuthorizationType PUBLISH;
        public static final LoginAuthorizationType READ;

        public static LoginAuthorizationType valueOf(String s)
        {
            return (LoginAuthorizationType)Enum.valueOf(com/parse/FacebookAuthenticationProvider$LoginAuthorizationType, s);
        }

        public static LoginAuthorizationType[] values()
        {
            return (LoginAuthorizationType[])$VALUES.clone();
        }

        static 
        {
            READ = new LoginAuthorizationType("READ", 0);
            PUBLISH = new LoginAuthorizationType("PUBLISH", 1);
            $VALUES = (new LoginAuthorizationType[] {
                READ, PUBLISH
            });
        }

        private LoginAuthorizationType(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String AUTH_TYPE = "facebook";
    public static final int DEFAULT_AUTH_ACTIVITY_CODE = 64206;
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_EXPIRATION_DATE = "expiration_date";
    private static final String KEY_USER_ID = "id";
    private static final DateFormat preciseDateFormat;
    private LoginAuthorizationType authorizationType;
    private WeakReference baseActivity;
    private WeakReference baseFragment;
    private d callbackManager;
    private Collection permissions;

    public FacebookAuthenticationProvider()
    {
        authorizationType = LoginAuthorizationType.READ;
    }

    public FacebookAuthenticationProvider(Context context, int i)
    {
        authorizationType = LoginAuthorizationType.READ;
        k.a(context, i);
    }

    public cu authenticateAsync()
    {
        if (callbackManager != null)
        {
            return cu.a(new RuntimeException("Unable to authenticate when another authentication is in process"));
        }
        final android.support.v7.cu.a tcs = cu.a();
        Activity activity;
        Fragment fragment;
        f f1;
        if (baseActivity != null)
        {
            activity = (Activity)baseActivity.get();
        } else
        {
            activity = null;
        }
        if (baseFragment != null)
        {
            fragment = (Fragment)baseFragment.get();
        } else
        {
            fragment = null;
        }
        f1 = f.a();
        callbackManager = com.facebook.d.a.a();
        f1.a(callbackManager, new com.facebook.f() {

            final FacebookAuthenticationProvider this$0;
            final android.support.v7.cu.a val$tcs;

            public void onCancel()
            {
                tcs.b();
            }

            public void onError(h h)
            {
                tcs.a(h);
            }

            public void onSuccess(g g1)
            {
                g1 = g1.a();
                g1 = getAuthData(g1);
                tcs.a(g1);
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((g)obj);
            }

            
            {
                this$0 = FacebookAuthenticationProvider.this;
                tcs = a;
                super();
            }
        });
        if (LoginAuthorizationType.PUBLISH.equals(authorizationType))
        {
            if (fragment != null)
            {
                f1.b(fragment, permissions);
            } else
            {
                f1.b(activity, permissions);
            }
        } else
        if (fragment != null)
        {
            f1.a(fragment, permissions);
        } else
        {
            f1.a(activity, permissions);
        }
        baseActivity = null;
        baseFragment = null;
        authorizationType = LoginAuthorizationType.READ;
        permissions = null;
        return tcs.a();
    }

    public void cancel()
    {
        this;
        JVM INSTR monitorenter ;
    }

    public void deauthenticate()
    {
        restoreAuthentication(null);
    }

    public Map getAuthData(AccessToken accesstoken)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("id", accesstoken.i());
        hashmap.put("access_token", accesstoken.b());
        hashmap.put("expiration_date", preciseDateFormat.format(accesstoken.c()));
        return hashmap;
    }

    public String getAuthType()
    {
        return "facebook";
    }

    public boolean onActivityResult(int i, int j, Intent intent)
    {
        boolean flag = false;
        if (callbackManager != null)
        {
            flag = callbackManager.a(i, j, intent);
            callbackManager = null;
        }
        return flag;
    }

    public boolean restoreAuthentication(Map map)
    {
        if (map == null)
        {
            f.a().b();
            return true;
        }
        try
        {
            AccessToken.a(new AccessToken((String)map.get("access_token"), k.i(), (String)map.get("id"), null, null, null, preciseDateFormat.parse((String)map.get("expiration_date")), null));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return false;
        }
        return true;
    }

    public FacebookAuthenticationProvider setActivity(Activity activity)
    {
        this;
        JVM INSTR monitorenter ;
        baseActivity = new WeakReference(activity);
        this;
        JVM INSTR monitorexit ;
        return this;
        activity;
        throw activity;
    }

    public FacebookAuthenticationProvider setFragment(Fragment fragment)
    {
        this;
        JVM INSTR monitorenter ;
        baseFragment = new WeakReference(fragment);
        this;
        JVM INSTR monitorexit ;
        return this;
        fragment;
        throw fragment;
    }

    public FacebookAuthenticationProvider setLoginAuthorizationType(LoginAuthorizationType loginauthorizationtype)
    {
        this;
        JVM INSTR monitorenter ;
        authorizationType = loginauthorizationtype;
        this;
        JVM INSTR monitorexit ;
        return this;
        loginauthorizationtype;
        throw loginauthorizationtype;
    }

    public FacebookAuthenticationProvider setPermissions(Collection collection)
    {
        this;
        JVM INSTR monitorenter ;
        permissions = collection;
        this;
        JVM INSTR monitorexit ;
        return this;
        collection;
        throw collection;
    }

    static 
    {
        preciseDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        preciseDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
    }
}
