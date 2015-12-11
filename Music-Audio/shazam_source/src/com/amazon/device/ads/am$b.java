// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.device.ads:
//            am, co, cn, dz, 
//            ar, ea

static final class d
    implements d
{

    private final Context a;
    private final ar b;
    private final cn c = co.a(am.a());
    private final ea d;

    private void b(String s)
    {
        c.a("Special url clicked, but was not handled by SDK. Url: %s", new Object[] {
            s
        });
    }

    public final boolean a(String s)
    {
        Object obj;
        Uri uri;
        obj = null;
        c.b("Executing AmazonMobile Intent", null);
        uri = Uri.parse(s);
        List list = uri.getQueryParameters("intent");
        obj = list;
_L11:
        if (obj == null || ((List) (obj)).size() <= 0) goto _L2; else goto _L1
_L1:
        obj = ((List) (obj)).iterator();
_L6:
        if (!((Iterator) (obj)).hasNext()) goto _L4; else goto _L3
_L3:
        if (!dz.a((String)((Iterator) (obj)).next(), a)) goto _L6; else goto _L5
_L5:
        return true;
_L4:
        b(s);
        return true;
_L2:
        boolean flag;
        if (a.getPackageManager().getLaunchIntentForPackage("com.amazon.windowshop") == null)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_301;
        }
        if (!uri.getHost().equals("shopping"))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = uri.getQueryParameter("app-action");
        if (obj == null || ((String) (obj)).length() == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!((String) (obj)).equals("detail"))
        {
            break; /* Loop/switch isn't completed */
        }
        s = uri.getQueryParameter("asin");
        if (s != null && s.length() != 0)
        {
            obj = a;
            Intent intent = ((Context) (obj)).getPackageManager().getLaunchIntentForPackage("com.amazon.windowshop");
            if (intent != null)
            {
                intent.putExtra("com.amazon.windowshop.refinement.asin", s);
                ((Context) (obj)).startActivity(intent);
                return true;
            }
        }
        if (true) goto _L5; else goto _L7
_L7:
        if (!((String) (obj)).equals("search"))
        {
            continue; /* Loop/switch isn't completed */
        }
        s = uri.getQueryParameter("keyword");
        if (s == null || s.length() == 0) goto _L5; else goto _L8
_L8:
        obj = a;
        Intent intent1 = new Intent("android.intent.action.SEARCH");
        intent1.setComponent(new ComponentName("com.amazon.windowshop", "com.amazon.windowshop.search.SearchResultsGridActivity"));
        intent1.putExtra("query", s);
        try
        {
            ((Context) (obj)).startActivity(intent1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return true;
        }
        return true;
        if (!((String) (obj)).equals("webview")) goto _L5; else goto _L9
_L9:
        b(s);
        return true;
        b(s);
        return true;
        UnsupportedOperationException unsupportedoperationexception;
        unsupportedoperationexception;
        if (true) goto _L11; else goto _L10
_L10:
    }

    ionException(Context context, ar ar, ea ea)
    {
        a = context;
        b = ar;
        d = ea;
    }
}
