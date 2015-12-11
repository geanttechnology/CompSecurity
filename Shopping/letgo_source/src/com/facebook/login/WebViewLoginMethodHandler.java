// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.g;
import android.support.v7.jr;
import android.support.v7.kb;
import android.support.v7.kd;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.c;
import com.facebook.h;
import com.facebook.i;
import com.facebook.j;
import com.facebook.k;
import com.facebook.m;
import java.util.Locale;

// Referenced classes of package com.facebook.login:
//            LoginMethodHandler, LoginClient, a

class WebViewLoginMethodHandler extends LoginMethodHandler
{
    static class a extends android.support.v7.kd.a
    {

        private String a;
        private boolean b;

        public kd a()
        {
            Bundle bundle = e();
            bundle.putString("redirect_uri", "fbconnect://success");
            bundle.putString("client_id", b());
            bundle.putString("e2e", a);
            bundle.putString("response_type", "token,signed_request");
            bundle.putString("return_scopes", "true");
            if (b)
            {
                bundle.putString("auth_type", "rerequest");
            }
            return new kd(c(), "oauth", bundle, d(), f());
        }

        public a a(String s)
        {
            a = s;
            return this;
        }

        public a a(boolean flag)
        {
            b = flag;
            return this;
        }

        public a(Context context, String s, Bundle bundle)
        {
            super(context, s, "oauth", bundle);
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public WebViewLoginMethodHandler a(Parcel parcel)
        {
            return new WebViewLoginMethodHandler(parcel);
        }

        public WebViewLoginMethodHandler[] a(int l)
        {
            return new WebViewLoginMethodHandler[l];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int l)
        {
            return a(l);
        }

    };
    private kd c;
    private String d;

    WebViewLoginMethodHandler(Parcel parcel)
    {
        super(parcel);
        d = parcel.readString();
    }

    WebViewLoginMethodHandler(LoginClient loginclient)
    {
        super(loginclient);
    }

    private void b(String s)
    {
        b.b().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", s).apply();
    }

    private String d()
    {
        return b.b().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", "");
    }

    String a()
    {
        return "web_view";
    }

    void a(LoginClient.Request request, Bundle bundle, h h1)
    {
        if (bundle != null)
        {
            if (bundle.containsKey("e2e"))
            {
                d = bundle.getString("e2e");
            }
            try
            {
                bundle = a(((java.util.Collection) (request.a())), bundle, c.e, request.d());
                request = LoginClient.Result.a(b.c(), bundle);
                CookieSyncManager.createInstance(b.b()).sync();
                b(bundle.b());
            }
            // Misplaced declaration of an exception variable
            catch (LoginClient.Request request)
            {
                request = LoginClient.Result.a(b.c(), null, request.getMessage());
            }
        } else
        if (h1 instanceof i)
        {
            request = LoginClient.Result.a(b.c(), "User canceled log in.");
        } else
        {
            d = null;
            request = h1.getMessage();
            if (h1 instanceof m)
            {
                request = ((m)h1).a();
                bundle = String.format(Locale.ROOT, "%d", new Object[] {
                    Integer.valueOf(request.b())
                });
                request = request.toString();
            } else
            {
                bundle = null;
            }
            request = LoginClient.Result.a(b.c(), null, request, bundle);
        }
        if (!kb.a(d))
        {
            a(d);
        }
        b.a(request);
    }

    boolean a(LoginClient.Request request)
    {
        Bundle bundle = new Bundle();
        if (!kb.a(request.a()))
        {
            String s = TextUtils.join(",", request.a());
            bundle.putString("scope", s);
            a("scope", s);
        }
        bundle.putString("default_audience", request.c().a());
        Object obj = AccessToken.a();
        android.support.v7.kd.c c1;
        if (obj != null)
        {
            obj = ((AccessToken) (obj)).b();
        } else
        {
            obj = null;
        }
        if (obj != null && ((String) (obj)).equals(d()))
        {
            bundle.putString("access_token", ((String) (obj)));
            a("access_token", "1");
        } else
        {
            kb.b(b.b());
            a("access_token", "0");
        }
        c1 = new android.support.v7.kd.c(request) {

            final LoginClient.Request a;
            final WebViewLoginMethodHandler b;

            public void a(Bundle bundle1, h h1)
            {
                b.a(a, bundle1, h1);
            }

            
            {
                b = WebViewLoginMethodHandler.this;
                a = request;
                super();
            }
        };
        d = LoginClient.l();
        a("e2e", d);
        obj = b.b();
        c = (new a(((Context) (obj)), request.d(), bundle)).a(d).a(request.f()).a(c1).a(k.l()).a();
        request = new jr();
        request.d(true);
        request.a(c);
        request.a(((g) (obj)).f(), "FacebookDialogFragment");
        return true;
    }

    void b()
    {
        if (c != null)
        {
            c.cancel();
            c = null;
        }
    }

    boolean c()
    {
        return true;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int l)
    {
        super.writeToParcel(parcel, l);
        parcel.writeString(d);
    }

}
