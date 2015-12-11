// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.os.AsyncTask;
import com.wishabi.flipp.util.k;
import com.wishabi.flipp.util.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.wishabi.flipp.b:
//            a, ak, ap

public class ao extends AsyncTask
{

    private final String a;
    public final int c[];

    public transient ao(String s, int ai[])
    {
        a = s;
        c = ai;
    }

    protected Object doInBackground(Object aobj[])
    {
        aobj = new ArrayList();
        ((List) (aobj)).add(new BasicNameValuePair("to_email", a));
        ((List) (aobj)).add(new BasicNameValuePair("coupon_ids", q.a(c, ",")));
        ((List) (aobj)).add(new BasicNameValuePair("sid", a.a.d()));
        ((List) (aobj)).add(new BasicNameValuePair("locale", Locale.getDefault().toString()));
        ((List) (aobj)).add(new BasicNameValuePair("postal_code", k.a(null)));
        return ap.a(ak.a("https://backflipp.wishabi.com/flipp/coupons/email", ((List) (aobj))));
    }
}
