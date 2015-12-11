// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.Fragment;
import android.support.v7.jx;
import android.support.v7.ka;
import android.support.v7.kb;
import com.facebook.c;
import com.facebook.h;
import java.util.Collection;

// Referenced classes of package com.facebook.login:
//            LoginMethodHandler, LoginClient

class KatanaProxyLoginMethodHandler extends LoginMethodHandler
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public KatanaProxyLoginMethodHandler a(Parcel parcel)
        {
            return new KatanaProxyLoginMethodHandler(parcel);
        }

        public KatanaProxyLoginMethodHandler[] a(int i)
        {
            return new KatanaProxyLoginMethodHandler[i];
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

    KatanaProxyLoginMethodHandler(Parcel parcel)
    {
        super(parcel);
    }

    KatanaProxyLoginMethodHandler(LoginClient loginclient)
    {
        super(loginclient);
    }

    private LoginClient.Result a(LoginClient.Request request, Intent intent)
    {
        Object obj = null;
        intent = intent.getExtras();
        String s = a(((Bundle) (intent)));
        String s1 = intent.getString("error_code");
        String s2 = b(intent);
        String s3 = intent.getString("e2e");
        if (!kb.a(s3))
        {
            a(s3);
        }
        if (s == null && s1 == null && s2 == null)
        {
            try
            {
                intent = LoginClient.Result.a(request, a(((Collection) (request.a())), ((Bundle) (intent)), c.b, request.d()));
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                return LoginClient.Result.a(request, null, intent.getMessage());
            }
        } else
        {
            intent = obj;
            if (!ka.a.contains(s))
            {
                if (ka.b.contains(s))
                {
                    return LoginClient.Result.a(request, null);
                } else
                {
                    return LoginClient.Result.a(request, s, s2, s1);
                }
            }
        }
        return intent;
    }

    private String a(Bundle bundle)
    {
        String s1 = bundle.getString("error");
        String s = s1;
        if (s1 == null)
        {
            s = bundle.getString("error_type");
        }
        return s;
    }

    private LoginClient.Result b(LoginClient.Request request, Intent intent)
    {
        intent = intent.getExtras();
        String s = a(intent);
        String s1 = intent.getString("error_code");
        if ("CONNECTION_FAILURE".equals(s1))
        {
            return LoginClient.Result.a(request, s, b(((Bundle) (intent))), s1);
        } else
        {
            return LoginClient.Result.a(request, s);
        }
    }

    private String b(Bundle bundle)
    {
        String s1 = bundle.getString("error_message");
        String s = s1;
        if (s1 == null)
        {
            s = bundle.getString("error_description");
        }
        return s;
    }

    String a()
    {
        return "katana_proxy_auth";
    }

    boolean a(int i, int j, Intent intent)
    {
        LoginClient.Request request = b.c();
        if (intent == null)
        {
            intent = LoginClient.Result.a(request, "Operation canceled");
        } else
        if (j == 0)
        {
            intent = b(request, intent);
        } else
        if (j != -1)
        {
            intent = LoginClient.Result.a(request, "Unexpected resultCode from authorization.", null);
        } else
        {
            intent = a(request, intent);
        }
        if (intent != null)
        {
            b.a(intent);
        } else
        {
            b.h();
        }
        return true;
    }

    protected boolean a(Intent intent, int i)
    {
        if (intent == null)
        {
            return false;
        }
        try
        {
            b.a().a(intent, i);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return false;
        }
        return true;
    }

    boolean a(LoginClient.Request request)
    {
        String s = LoginClient.l();
        request = jx.a(b.b(), request.d(), request.a(), s, request.f(), request.g(), request.c());
        a("e2e", s);
        return a(((Intent) (request)), LoginClient.d());
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
