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
import android.util.Log;
import com.facebook.ads.a.ah;
import com.facebook.ads.a.aw;
import com.facebook.ads.a.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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

    private Intent a(ah ah1)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(0x10000000);
        if (!aw.a(ah1.a()) && !aw.a(ah1.b()))
        {
            intent.setComponent(new ComponentName(ah1.a(), ah1.b()));
        }
        if (!aw.a(ah1.c()))
        {
            intent.setData(Uri.parse(ah1.c()));
        }
        return intent;
    }

    private Intent b(ah ah1)
    {
        Object obj;
        Object obj1;
label0:
        {
            if (aw.a(ah1.a()))
            {
                return null;
            }
            if (!i.a(b, ah1.a()))
            {
                return null;
            }
            obj = ah1.c();
            if (!aw.a(((String) (obj))) && (((String) (obj)).startsWith("tel:") || ((String) (obj)).startsWith("telprompt:")))
            {
                return new Intent("android.intent.action.CALL", Uri.parse(((String) (obj))));
            }
            obj1 = b.getPackageManager();
            if (aw.a(ah1.b()) && aw.a(((String) (obj))))
            {
                return ((PackageManager) (obj1)).getLaunchIntentForPackage(ah1.a());
            }
            obj = a(ah1);
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
            } while (!resolveinfo.activityInfo.packageName.equals(ah1.a()));
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

    private List e()
    {
        Object obj = c.getQueryParameter("appsite_data");
        if (!aw.a(((String) (obj))) && !"[]".equals(obj)) goto _L2; else goto _L1
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
            Log.w(a, "Error parsing appsite_data", jsonexception);
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
        obj = ah.a(jsonarray.optJSONObject(j));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        arraylist.add(obj);
        j++;
          goto _L6
    }

    public com.facebook.ads.a.b.a a()
    {
        return com.facebook.ads.a.b.a.a;
    }

    public void a(Map map)
    {
        a(b, c);
        map = c();
        if (map != null)
        {
            for (map = map.iterator(); map.hasNext();)
            {
                Intent intent = (Intent)map.next();
                try
                {
                    b.startActivity(intent);
                    return;
                }
                catch (Exception exception) { }
            }

        }
        d();
    }

    protected Uri b()
    {
        return Uri.parse(String.format("market://details?id=%s", new Object[] {
            c.getQueryParameter("store_id")
        }));
    }

    protected List c()
    {
        Object obj = e();
        ArrayList arraylist = new ArrayList();
        if (obj != null)
        {
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Intent intent = b((ah)((Iterator) (obj)).next());
                if (intent != null)
                {
                    arraylist.add(intent);
                }
            } while (true);
        }
        return arraylist;
    }

    public void d()
    {
        Intent intent;
        intent = new Intent("android.intent.action.VIEW", b());
        intent.addFlags(0x10000000);
        b.startActivity(intent);
_L1:
        return;
        Exception exception;
        exception;
        (new StringBuilder("Failed to open market url: ")).append(c.toString());
        Object obj = c.getQueryParameter("store_url_web_fallback");
        if (obj != null && ((String) (obj)).length() > 0)
        {
            obj = new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj))));
            ((Intent) (obj)).addFlags(0x10000000);
            try
            {
                b.startActivity(((Intent) (obj)));
                return;
            }
            catch (Exception exception1)
            {
                return;
            }
        }
          goto _L1
    }

}
