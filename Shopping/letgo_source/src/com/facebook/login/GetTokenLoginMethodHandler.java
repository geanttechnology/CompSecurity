// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.support.v7.kb;
import android.text.TextUtils;
import com.facebook.c;
import com.facebook.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.login:
//            LoginMethodHandler, b, LoginClient

class GetTokenLoginMethodHandler extends LoginMethodHandler
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public GetTokenLoginMethodHandler a(Parcel parcel)
        {
            return new GetTokenLoginMethodHandler(parcel);
        }

        public GetTokenLoginMethodHandler[] a(int i)
        {
            return new GetTokenLoginMethodHandler[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private b c;

    GetTokenLoginMethodHandler(Parcel parcel)
    {
        super(parcel);
    }

    GetTokenLoginMethodHandler(LoginClient loginclient)
    {
        super(loginclient);
    }

    String a()
    {
        return "get_token";
    }

    void a(LoginClient.Request request, Bundle bundle)
    {
        if (c != null)
        {
            c.a(null);
        }
        c = null;
        b.k();
        if (bundle != null)
        {
            ArrayList arraylist = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            Object obj = request.a();
            if (arraylist != null && (obj == null || arraylist.containsAll(((java.util.Collection) (obj)))))
            {
                c(request, bundle);
                return;
            }
            bundle = new HashSet();
            obj = ((Set) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                String s = (String)((Iterator) (obj)).next();
                if (!arraylist.contains(s))
                {
                    bundle.add(s);
                }
            } while (true);
            if (!bundle.isEmpty())
            {
                a("new_permissions", TextUtils.join(",", bundle));
            }
            request.a(bundle);
        }
        b.h();
    }

    boolean a(LoginClient.Request request)
    {
        c = new b(b.b(), request.d());
        if (!c.a())
        {
            return false;
        } else
        {
            b.j();
            request = new android.support.v7.jy.a(request) {

                final LoginClient.Request a;
                final GetTokenLoginMethodHandler b;

                public void a(Bundle bundle)
                {
                    b.a(a, bundle);
                }

            
            {
                b = GetTokenLoginMethodHandler.this;
                a = request;
                super();
            }
            };
            c.a(request);
            return true;
        }
    }

    void b()
    {
        if (c != null)
        {
            c.b();
            c.a(null);
            c = null;
        }
    }

    void b(LoginClient.Request request, Bundle bundle)
    {
        request = a(bundle, c.d, request.d());
        request = LoginClient.Result.a(b.c(), request);
        b.a(request);
    }

    void c(LoginClient.Request request, Bundle bundle)
    {
        String s = bundle.getString("com.facebook.platform.extra.USER_ID");
        if (s == null || s.isEmpty())
        {
            b.j();
            kb.a(bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN"), new android.support.v7.kb.c(bundle, request) {

                final Bundle a;
                final LoginClient.Request b;
                final GetTokenLoginMethodHandler c;

                public void a(h h1)
                {
                    c.b.b(LoginClient.Result.a(c.b.c(), "Caught exception", h1.getMessage()));
                }

                public void a(JSONObject jsonobject)
                {
                    try
                    {
                        jsonobject = jsonobject.getString("id");
                        a.putString("com.facebook.platform.extra.USER_ID", jsonobject);
                        c.b(b, a);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (JSONObject jsonobject)
                    {
                        c.b.b(LoginClient.Result.a(c.b.c(), "Caught exception", jsonobject.getMessage()));
                    }
                }

            
            {
                c = GetTokenLoginMethodHandler.this;
                a = bundle;
                b = request;
                super();
            }
            });
            return;
        } else
        {
            b(request, bundle);
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
    }

}
