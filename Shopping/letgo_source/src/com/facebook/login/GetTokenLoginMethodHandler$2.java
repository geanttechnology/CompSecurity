// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.os.Bundle;
import com.facebook.h;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.login:
//            GetTokenLoginMethodHandler, LoginClient

class b
    implements android.support.v7.b
{

    final Bundle a;
    final c b;
    final GetTokenLoginMethodHandler c;

    public void a(h h1)
    {
        c.b.b(c(c.b.c(), "Caught exception", h1.getMessage()));
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
            c.b.b(c(c.b.c(), "Caught exception", jsonobject.getMessage()));
        }
    }

    (GetTokenLoginMethodHandler gettokenloginmethodhandler, Bundle bundle,  )
    {
        c = gettokenloginmethodhandler;
        a = bundle;
        b = ;
        super();
    }
}
