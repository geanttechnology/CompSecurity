// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            gi, cl, he, gm

public static final class d extends gi
{

    private final String a = "play.google.com";
    private final String b = "market";
    private final int c = 10;
    private final String d;
    private final he e;

    public final void a()
    {
        Object obj;
        int i;
        i = 0;
        obj = d;
_L11:
        if (i >= 10) goto _L2; else goto _L1
_L1:
        Object obj1;
        boolean flag;
        obj1 = new URL(((String) (obj)));
        flag = "play.google.com".equalsIgnoreCase(((URL) (obj1)).getHost());
        if (!flag) goto _L3; else goto _L2
_L2:
        obj = Uri.parse(((String) (obj)));
        obj1 = new Intent("android.intent.action.VIEW");
        ((Intent) (obj1)).addFlags(0x10000000);
        ((Intent) (obj1)).setData(((Uri) (obj)));
        e.getContext().startActivity(((Intent) (obj1)));
        return;
_L3:
        if (!"market".equalsIgnoreCase(((URL) (obj1)).getProtocol())) goto _L4; else goto _L2
_L4:
        HttpURLConnection httpurlconnection = (HttpURLConnection)((URL) (obj1)).openConnection();
        Map map;
        int j;
        p.e().a(e.getContext(), e.l().b, false, httpurlconnection);
        j = httpurlconnection.getResponseCode();
        map = httpurlconnection.getHeaderFields();
        if (j < 300 || j > 399)
        {
            break MISSING_BLOCK_LABEL_327;
        }
        obj1 = null;
        if (!map.containsKey("Location")) goto _L6; else goto _L5
_L5:
        obj1 = (List)map.get("Location");
_L10:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_327;
        }
        if (((List) (obj1)).size() <= 0)
        {
            break MISSING_BLOCK_LABEL_327;
        }
        obj1 = (String)((List) (obj1)).get(0);
_L15:
        if (!TextUtils.isEmpty(((CharSequence) (obj1)))) goto _L8; else goto _L7
_L7:
        com.google.android.gms.ads.internal.util.client.b.a(5);
        httpurlconnection.disconnect();
          goto _L2
_L6:
        if (!map.containsKey("location")) goto _L10; else goto _L9
_L9:
        obj1 = (List)map.get("location");
          goto _L10
_L8:
        httpurlconnection.disconnect();
        i++;
        obj = obj1;
          goto _L11
        obj1;
        httpurlconnection.disconnect();
        throw obj1;
        obj1;
_L14:
        com.google.android.gms.ads.internal.util.client.b.a(5);
          goto _L2
        obj1;
_L13:
        com.google.android.gms.ads.internal.util.client.b.a(5);
          goto _L2
        obj1;
_L12:
        com.google.android.gms.ads.internal.util.client.b.a(5);
          goto _L2
        obj;
        obj = obj1;
          goto _L12
        obj;
        obj = obj1;
          goto _L13
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        indexoutofboundsexception = ((IndexOutOfBoundsException) (obj1));
          goto _L14
        obj1 = "";
          goto _L15
    }

    public final void b()
    {
    }

    public ption(he he1, String s)
    {
        e = he1;
        d = s;
    }
}
