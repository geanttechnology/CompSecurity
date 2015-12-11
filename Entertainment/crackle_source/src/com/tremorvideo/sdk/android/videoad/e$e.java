// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.os.AsyncTask;
import com.tremorvideo.sdk.android.videoad.a.a;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            e, ad, bb

class b extends AsyncTask
{

    String a;
    final e b;

    protected transient String a(String as[])
    {
        String s;
        try
        {
            a = null;
            b.A = as[0];
            s = b.A.replace("|", "%7C");
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            ad.d((new StringBuilder()).append("Exception vast tag download:").append(as).toString());
            return null;
        }
        as = s;
        if (s.contains(" "))
        {
            as = s.replace(" ", "%20");
        }
        as = com.tremorvideo.sdk.android.videoad.bb.a(as, ad.x());
        as.a();
        as = as.b();
        return as;
    }

    protected void a(String s)
    {
        if (s == null || s.length() <= 0) goto _L2; else goto _L1
_L1:
        a a1;
        int j;
        a1 = new a(s);
        s = s.split("\n");
        j = s.length;
        int i = 0;
_L4:
        String s1;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s[i];
        com.tremorvideo.sdk.android.videoad.ad.a(.c, s1);
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        try
        {
            b.a(a1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ad.d((new StringBuilder()).append("Vast Tag Parsing failed ").append(s).toString());
            b.h();
        }
_L6:
        cancel(true);
        return;
_L2:
        ad.d("Vast Tag Download failed ");
        b.h();
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void b(String s)
    {
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onCancelled(Object obj)
    {
        b((String)obj);
    }

    protected void onPostExecute(Object obj)
    {
        a((String)obj);
    }

    (e e1)
    {
        b = e1;
        super();
    }
}
