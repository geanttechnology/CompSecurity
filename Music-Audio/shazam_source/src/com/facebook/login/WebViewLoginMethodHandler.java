// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.b.t;
import com.facebook.b.v;
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
    static final class a extends com.facebook.b.v.a
    {

        String f;
        boolean g;

        public final v a()
        {
            Bundle bundle = super.e;
            bundle.putString("redirect_uri", "fbconnect://success");
            bundle.putString("client_id", super.b);
            bundle.putString("e2e", f);
            bundle.putString("response_type", "token,signed_request");
            bundle.putString("return_scopes", "true");
            if (g)
            {
                bundle.putString("auth_type", "rerequest");
            }
            return new v(super.a, "oauth", bundle, super.c, super.d);
        }

        public a(Context context, String s, Bundle bundle)
        {
            super(context, s, "oauth", bundle);
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new WebViewLoginMethodHandler(parcel);
        }

        public final volatile Object[] newArray(int l)
        {
            return new WebViewLoginMethodHandler[l];
        }

    };
    private v c;
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

    final String a()
    {
        return "web_view";
    }

    final void a(LoginClient.Request request, Bundle bundle, h h1)
    {
        if (bundle != null)
        {
            if (bundle.containsKey("e2e"))
            {
                d = bundle.getString("e2e");
            }
            try
            {
                bundle = a(((java.util.Collection) (request.b)), bundle, c.e, request.d);
                request = LoginClient.Result.a(b.g, bundle);
                CookieSyncManager.createInstance(b.c.getActivity()).sync();
                bundle = ((AccessToken) (bundle)).d;
                b.c.getActivity().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", bundle).apply();
            }
            // Misplaced declaration of an exception variable
            catch (LoginClient.Request request)
            {
                request = LoginClient.Result.a(b.g, null, request.getMessage());
            }
        } else
        if (h1 instanceof i)
        {
            request = LoginClient.Result.a(b.g, "User canceled log in.");
        } else
        {
            d = null;
            bundle = h1.getMessage();
            if (h1 instanceof m)
            {
                bundle = ((m)h1).a;
                request = String.format(Locale.ROOT, "%d", new Object[] {
                    Integer.valueOf(((j) (bundle)).c)
                });
                bundle = bundle.toString();
            } else
            {
                request = null;
            }
            request = LoginClient.Result.a(b.g, null, bundle, request);
        }
        if (!t.a(d))
        {
            a(d);
        }
        b.a(request);
    }

    final boolean a(LoginClient.Request request)
    {
        Object obj1 = new Bundle();
        if (!t.a(request.b))
        {
            String s = TextUtils.join(",", request.b);
            ((Bundle) (obj1)).putString("scope", s);
            a("scope", s);
        }
        ((Bundle) (obj1)).putString("default_audience", request.c.e);
        Object obj = AccessToken.a();
        com.facebook.b.v.c c1;
        if (obj != null)
        {
            obj = ((AccessToken) (obj)).d;
        } else
        {
            obj = null;
        }
        if (obj != null && ((String) (obj)).equals(b.c.getActivity().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", "")))
        {
            ((Bundle) (obj1)).putString("access_token", ((String) (obj)));
            a("access_token", "1");
        } else
        {
            t.b(b.c.getActivity());
            a("access_token", "0");
        }
        c1 = new com.facebook.b.v.c(request) {

            final LoginClient.Request a;
            final WebViewLoginMethodHandler b;

            public final void a(Bundle bundle, h h1)
            {
                b.a(a, bundle, h1);
            }

            
            {
                b = WebViewLoginMethodHandler.this;
                a = request;
                super();
            }
        };
        d = LoginClient.f();
        a("e2e", d);
        obj = b.c.getActivity();
        obj1 = new a(((Context) (obj)), request.d, ((Bundle) (obj1)));
        obj1.f = d;
        obj1.g = request.f;
        obj1.d = c1;
        obj1.c = k.m();
        c = ((com.facebook.b.v.a) (obj1)).a();
        request = new com.facebook.b.j();
        request.setRetainInstance(true);
        request.aj = c;
        request.a(((android.support.v4.app.i) (obj)).getSupportFragmentManager(), "FacebookDialogFragment");
        return true;
    }

    final void b()
    {
        if (c != null)
        {
            c.cancel();
            c = null;
        }
    }

    final boolean c()
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
