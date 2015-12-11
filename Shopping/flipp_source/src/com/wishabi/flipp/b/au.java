// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.os.AsyncTask;
import com.wishabi.flipp.util.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.wishabi.flipp.b:
//            ak

public class au extends AsyncTask
{

    private static final String a = com/wishabi/flipp/b/au.getSimpleName();
    private final String b;
    private final String c;
    private final String d;
    private final boolean e;
    private final boolean f;

    public au(String s)
    {
        this(s, "", "", false, false);
    }

    public au(String s, String s1, String s2, boolean flag, boolean flag1)
    {
        b = s;
        c = s1;
        d = s2;
        e = flag;
        f = flag1;
    }

    protected Object doInBackground(Object aobj[])
    {
        ArrayList arraylist = new ArrayList(2);
        arraylist.add(new BasicNameValuePair("store_name", b));
        arraylist.add(new BasicNameValuePair("postal_code", k.a(null)));
        arraylist.add(new BasicNameValuePair("locale", Locale.getDefault().toString()));
        arraylist.add(new BasicNameValuePair("email", c));
        arraylist.add(new BasicNameValuePair("twitter", d));
        if (e)
        {
            aobj = "1";
        } else
        {
            aobj = "0";
        }
        arraylist.add(new BasicNameValuePair("opt_in_notify", ((String) (aobj))));
        if (f)
        {
            aobj = "1";
        } else
        {
            aobj = "0";
        }
        arraylist.add(new BasicNameValuePair("opt_in_more", ((String) (aobj))));
        ak.a("https://backflipp.wishabi.com/flipp/store_requests", arraylist);
        return null;
    }

}
