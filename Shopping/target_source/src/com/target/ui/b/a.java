// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.target.mothership.services.w;
import com.target.mothership.services.x;
import com.target.ui.util.j;
import com.target.ui.util.q;

public class a
{

    private final String TAG = com/target/ui/b/a.getSimpleName();
    private com.target.mothership.a.a mAppConfigProvider;
    private Context mContext;
    w mResponseHandler;
    private SharedPreferences mSharedPreferences;

    public a(Context context, com.target.mothership.a.a a1)
    {
        mResponseHandler = new w() {

            final a this$0;

            public void a(com.target.mothership.services.e.a.b.a a2)
            {
                if (a2 == null)
                {
                    q.a(a.a(a.this), "AppConfigResponse was null.");
                    return;
                } else
                {
                    a.b(a.this).b(a2.a());
                    a.b(a.this).a(j.a(a.c(a.this)));
                    a.b(a.this).a(a2.b());
                    a.b(a.this).b(a2.c());
                    a.b(a.this).a(a2.d());
                    a.b(a.this).b(a2.e());
                    a.a(a.this, true);
                    return;
                }
            }

            public void onError(x x1)
            {
                q.a(a.a(a.this), (new StringBuilder()).append("Unable to update AppConfig.").append(x1.getMessage()).toString());
                a.a(a.this, false);
            }

            public void onResult(Object obj)
            {
                a((com.target.mothership.services.e.a.b.a)obj);
            }

            
            {
                this$0 = a.this;
                super();
            }
        };
        mAppConfigProvider = a1;
        mContext = context;
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    static String a(a a1)
    {
        return a1.TAG;
    }

    static void a(a a1, boolean flag)
    {
        a1.b(flag);
    }

    private void a(String s, boolean flag)
    {
        mSharedPreferences.edit().putBoolean(s, flag).apply();
    }

    static com.target.mothership.a.a b(a a1)
    {
        return a1.mAppConfigProvider;
    }

    private void b(boolean flag)
    {
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a("key_update_required", flag);
    }

    static Context c(a a1)
    {
        return a1.mContext;
    }

    public void a(boolean flag)
    {
        a("key_update_required", flag);
    }

    public boolean a()
    {
        if (mAppConfigProvider.b() != j.a(mContext))
        {
            return true;
        } else
        {
            return mSharedPreferences.getBoolean("key_update_required", false);
        }
    }

    public void b()
    {
        (new com.target.mothership.services.e.a.c.a()).a(mResponseHandler);
    }
}
