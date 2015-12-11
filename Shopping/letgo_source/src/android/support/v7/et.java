// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Patterns;
import com.abtnprojects.ambatana.models.LetgoAddress;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.p;
import com.parse.ParseUser;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            es, er, eu, aqo, 
//            dz, ec, ajx, en

public class et extends AsyncTask
{

    private final er a;
    private final AccessToken b;
    private final es c = new es();
    private final List d;

    public et(ParseUser parseuser, Context context, LetgoAddress letgoaddress, AccessToken accesstoken)
    {
        d = a(context);
        b = accesstoken;
        a = new er(parseuser, letgoaddress, c);
    }

    eu a()
    {
        Object obj = GraphRequest.a(b, new com.facebook.GraphRequest.c() {

            final et a;

            public void a(JSONObject jsonobject, p p1)
            {
            }

            
            {
                a = et.this;
                super();
            }
        });
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,email,first_name,last_name,verified");
        ((GraphRequest) (obj)).a(bundle);
        obj = ((GraphRequest) (obj)).i();
        if (((p) (obj)).a() == null)
        {
            obj = eu.a(((p) (obj)).b(), d);
            if (obj == null)
            {
                return null;
            } else
            {
                return ((eu) (obj));
            }
        } else
        {
            aqo.d("GraphRequest error %s", new Object[] {
                ((p) (obj)).a()
            });
            return null;
        }
    }

    protected transient Boolean a(Void avoid[])
    {
        avoid = a();
        if (avoid == null)
        {
            return Boolean.valueOf(false);
        } else
        {
            return Boolean.valueOf(a.a(avoid));
        }
    }

    protected List a(Context context)
    {
        context = AccountManager.get(context).getAccounts();
        HashSet hashset = new HashSet();
        int j = context.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = context[i];
            if (Patterns.EMAIL_ADDRESS.matcher(((Account) (obj)).name).matches())
            {
                hashset.add(((Account) (obj)).name);
            }
        }

        return new ArrayList(hashset);
    }

    protected void a(Boolean boolean1)
    {
        dz.a().a(new ec(boolean1));
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }

    protected void onPreExecute()
    {
        dz.a().a(new en(2));
    }
}
