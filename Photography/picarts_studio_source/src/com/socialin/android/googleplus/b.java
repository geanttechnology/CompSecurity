// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googleplus;

import android.text.TextUtils;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import com.socialin.android.d;
import com.socialin.android.util.an;

// Referenced classes of package com.socialin.android.googleplus:
//            GooglePlusSignInActivity

public final class b extends an
{

    private Person a;
    private GooglePlusSignInActivity b;

    public b(GooglePlusSignInActivity googleplussigninactivity, Person person)
    {
        b = googleplussigninactivity;
        super();
        a = person;
    }

    private String a()
    {
        String s;
        try
        {
            s = GoogleAuthUtil.getToken(b, Plus.AccountApi.getAccountName(GooglePlusSignInActivity.b(b)), (new StringBuilder("oauth2:")).append(TextUtils.join(" ", GooglePlusSignInActivity.b)).toString());
        }
        catch (GoogleAuthException googleauthexception)
        {
            d.b(GooglePlusSignInActivity.a, "getGoogleToken", googleauthexception);
            return "";
        }
        catch (Exception exception)
        {
            d.b(GooglePlusSignInActivity.a, "getGoogleToken", exception);
            return "";
        }
        return s;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (String)obj;
        GooglePlusSignInActivity.a(b, a, ((String) (obj)));
    }
}
