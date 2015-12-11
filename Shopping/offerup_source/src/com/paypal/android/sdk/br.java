// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.util.Log;
import org.json.JSONException;

// Referenced classes of package com.paypal.android.sdk:
//            cg, cj, bl, bk

public abstract class br
    implements cg
{

    public br()
    {
    }

    protected static void a(cj cj1)
    {
        try
        {
            (new StringBuilder("parsing success response\n:")).append(cj1.g());
            cj1.c();
            return;
        }
        catch (Exception exception)
        {
            Log.e("paypal.sdk", "Exception parsing server response", exception);
            cj1.a(new bl(bk.c, exception));
            return;
        }
    }

    protected static void a(cj cj1, int i)
    {
        cj1.a(Integer.valueOf(i));
        try
        {
            (new StringBuilder("parsing error response:\n")).append(cj1.g());
            cj1.d();
            return;
        }
        catch (JSONException jsonexception)
        {
            Log.e("paypal.sdk", "Exception parsing server response", jsonexception);
            cj1.a(bk.a.toString(), (new StringBuilder()).append(i).append(" http response received.  Response not parsable: ").append(jsonexception.getMessage()).toString(), null);
            return;
        }
    }

    static 
    {
        com/paypal/android/sdk/br.getSimpleName();
    }
}
