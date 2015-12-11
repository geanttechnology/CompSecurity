// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.facebook.ads.a.f.f;
import com.facebook.ads.a.f.i;
import com.facebook.ads.a.f.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.a.a:
//            a

public class c extends a
{

    private static final String a = com/facebook/ads/a/a/c.getSimpleName();
    private final Context b;
    private final Uri c;

    public c(Context context, Uri uri)
    {
        b = context;
        c = uri;
    }

    private Intent a(i j)
    {
        Object obj;
        Object obj1;
label0:
        {
            if (s.a(j.a))
            {
                return null;
            }
            if (!f.a(b, j.a))
            {
                return null;
            }
            obj = j.c;
            if (!s.a(((String) (obj))) && (((String) (obj)).startsWith("tel:") || ((String) (obj)).startsWith("telprompt:")))
            {
                return new Intent("android.intent.action.CALL", Uri.parse(((String) (obj))));
            }
            obj1 = b.getPackageManager();
            if (s.a(j.b) && s.a(((String) (obj))))
            {
                return ((PackageManager) (obj1)).getLaunchIntentForPackage(j.a);
            }
            obj = new Intent("android.intent.action.VIEW");
            ((Intent) (obj)).addFlags(0x10000000);
            if (!s.a(j.a) && !s.a(j.b))
            {
                ((Intent) (obj)).setComponent(new ComponentName(j.a, j.b));
            }
            if (!s.a(j.c))
            {
                ((Intent) (obj)).setData(Uri.parse(j.c));
            }
            obj1 = ((PackageManager) (obj1)).queryIntentActivities(((Intent) (obj)), 0x10000);
            if (((Intent) (obj)).getComponent() != null)
            {
                break label0;
            }
            Iterator iterator = ((List) (obj1)).iterator();
            ResolveInfo resolveinfo;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                resolveinfo = (ResolveInfo)iterator.next();
            } while (!resolveinfo.activityInfo.packageName.equals(j.a));
            ((Intent) (obj)).setComponent(new ComponentName(resolveinfo.activityInfo.packageName, resolveinfo.activityInfo.name));
        }
        if (((List) (obj1)).isEmpty() || ((Intent) (obj)).getComponent() == null)
        {
            return null;
        } else
        {
            return ((Intent) (obj));
        }
    }

    private List c()
    {
        Object obj = c.getQueryParameter("appsite_data");
        if (!s.a(((String) (obj))) && !"[]".equals(obj)) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((List) (obj));
_L2:
        ArrayList arraylist = new ArrayList();
        JSONArray jsonarray;
        int j;
        try
        {
            jsonarray = (new JSONObject(((String) (obj)))).optJSONArray("android");
        }
        catch (JSONException jsonexception)
        {
            return arraylist;
        }
        obj = arraylist;
        if (jsonarray == null) goto _L4; else goto _L3
_L3:
        j = 0;
_L6:
        obj = arraylist;
        if (j >= jsonarray.length()) goto _L4; else goto _L5
_L5:
        obj = i.a(jsonarray.optJSONObject(j));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        arraylist.add(obj);
        j++;
          goto _L6
    }

    public final com.facebook.ads.a.f.b.a a()
    {
        return com.facebook.ads.a.f.b.a.a;
    }

    public final void b()
    {
        Object obj;
        a(b, c);
        Object obj2 = c();
        obj = new ArrayList();
        if (obj2 != null)
        {
            obj2 = ((List) (obj2)).iterator();
            do
            {
                if (!((Iterator) (obj2)).hasNext())
                {
                    break;
                }
                Intent intent1 = a((i)((Iterator) (obj2)).next());
                if (intent1 != null)
                {
                    ((List) (obj)).add(intent1);
                }
            } while (true);
        }
        obj = ((List) (obj)).iterator();
_L6:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        Intent intent = (Intent)((Iterator) (obj)).next();
        b.startActivity(intent);
_L4:
        return;
_L2:
        Object obj1 = c.getQueryParameter("store_url");
        if (!s.a(((String) (obj1))))
        {
            obj1 = Uri.parse(((String) (obj1)));
        } else
        {
            obj1 = Uri.parse(String.format("market://details?id=%s", new Object[] {
                c.getQueryParameter("store_id")
            }));
        }
        obj1 = new Intent("android.intent.action.VIEW", ((Uri) (obj1)));
        ((Intent) (obj1)).addFlags(0x10000000);
        try
        {
            b.startActivity(((Intent) (obj1)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            (new StringBuilder("Failed to open market url: ")).append(c.toString());
        }
        obj1 = c.getQueryParameter("store_url_web_fallback");
        if (obj1 == null || ((String) (obj1)).length() <= 0) goto _L4; else goto _L3
_L3:
        obj1 = new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj1))));
        ((Intent) (obj1)).addFlags(0x10000000);
        try
        {
            b.startActivity(((Intent) (obj1)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            return;
        }
        Exception exception;
        exception;
        if (true) goto _L6; else goto _L5
_L5:
    }

}
