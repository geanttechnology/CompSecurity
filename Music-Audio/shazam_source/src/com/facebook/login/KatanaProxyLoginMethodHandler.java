// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.Fragment;
import com.facebook.b.p;
import com.facebook.b.s;
import com.facebook.b.t;
import com.facebook.c;
import com.facebook.h;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.facebook.login:
//            LoginMethodHandler, LoginClient, f

class KatanaProxyLoginMethodHandler extends LoginMethodHandler
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new KatanaProxyLoginMethodHandler(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new KatanaProxyLoginMethodHandler[i];
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
        String s1 = a(((Bundle) (intent)));
        String s2 = intent.getString("error_code");
        String s3 = b(intent);
        String s4 = intent.getString("e2e");
        if (!t.a(s4))
        {
            a(s4);
        }
        if (s1 == null && s2 == null && s3 == null)
        {
            try
            {
                intent = LoginClient.Result.a(request, a(((Collection) (request.b)), ((Bundle) (intent)), c.b, request.d));
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                return LoginClient.Result.a(request, null, intent.getMessage());
            }
        } else
        {
            intent = obj;
            if (!s.a.contains(s1))
            {
                if (s.b.contains(s1))
                {
                    return LoginClient.Result.a(request, null);
                } else
                {
                    return LoginClient.Result.a(request, s1, s3, s2);
                }
            }
        }
        return intent;
    }

    private static String a(Bundle bundle)
    {
        String s2 = bundle.getString("error");
        String s1 = s2;
        if (s2 == null)
        {
            s1 = bundle.getString("error_type");
        }
        return s1;
    }

    private boolean a(Intent intent, int i)
    {
        if (intent == null)
        {
            return false;
        }
        try
        {
            b.c.startActivityForResult(intent, i);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return false;
        }
        return true;
    }

    private static String b(Bundle bundle)
    {
        String s2 = bundle.getString("error_message");
        String s1 = s2;
        if (s2 == null)
        {
            s1 = bundle.getString("error_description");
        }
        return s1;
    }

    final String a()
    {
        return "katana_proxy_auth";
    }

    final boolean a(int i, Intent intent)
    {
        LoginClient.Request request = b.g;
        if (intent == null)
        {
            intent = LoginClient.Result.a(request, "Operation canceled");
        } else
        if (i == 0)
        {
            intent = intent.getExtras();
            String s1 = a(((Bundle) (intent)));
            String s2 = intent.getString("error_code");
            if ("CONNECTION_FAILURE".equals(s2))
            {
                intent = LoginClient.Result.a(request, s1, b(intent), s2);
            } else
            {
                intent = LoginClient.Result.a(request, s1);
            }
        } else
        if (i != -1)
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
            b.d();
        }
        return true;
    }

    final boolean a(LoginClient.Request request)
    {
        String s1;
        android.support.v4.app.i i;
        String s2;
        Set set;
        Iterator iterator;
        boolean flag1;
        s1 = LoginClient.f();
        i = b.c.getActivity();
        s2 = request.d;
        set = request.b;
        flag1 = request.f;
        iterator = request.b.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if (!f.a((String)iterator.next())) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        request = p.a(i, s2, set, s1, flag1, flag, request.c);
        a("e2e", s1);
        return a(((Intent) (request)), LoginClient.a());
_L2:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
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
