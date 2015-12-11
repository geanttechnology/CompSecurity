// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import com.groupon.cookies.CookieFactory;
import com.groupon.http.Http;
import com.groupon.http.synchronous.SyncHttp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            ArraySharedPreferences

public abstract class CategoriesRequester extends Http
{

    private CookieFactory cookieFactory;
    private ArraySharedPreferences loginPrefs;
    protected String referrer;

    public CategoriesRequester(Context context, Class class1, String s)
    {
        super(context, class1, s);
    }

    private List getDefaultParams()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new String[] {
            "context", "mobile"
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "visitor_id", cookieFactory.getBrowserCookie()
        }));
        String s = loginPrefs.getString("referralCode", null);
        if (Strings.notEmpty(s))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "referral_id", s
            }));
        }
        return arraylist;
    }

    public Object call()
        throws Exception
    {
        syncHttp.nvps(getParams().toArray());
        return super.call();
    }

    public String getCriteria()
    {
        return "category";
    }

    protected List getParams()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(getDefaultParams());
        arraylist.addAll(getSpecificParams());
        return arraylist;
    }

    protected abstract Collection getSpecificParams();
}
