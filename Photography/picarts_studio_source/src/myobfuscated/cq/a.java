// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.socialin.android.util.e;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myobfuscated.cv.b;
import myobfuscated.cx.d;
import org.json.JSONArray;
import org.json.JSONObject;

public class a extends d
{

    private static String f = myobfuscated/cq/a.getSimpleName();
    private String g;

    public a()
    {
        g = "";
    }

    private static List a(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        if (jsonarray != null && jsonarray.length() > 0)
        {
            for (int i = 0; i < jsonarray.length(); i++)
            {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                b b1 = new b();
                b1.a = jsonobject.getString("imageId");
                b1.c = jsonobject.getString("url");
                b1.b = jsonobject.getString("tbUrl");
                b1.d = jsonobject.getString("tbUrl");
                b1.e = jsonobject.getString("titleNoFormatting");
                arraylist.add(b1);
            }

        }
        return arraylist;
    }

    private List b(String s)
    {
        Object obj1;
        Object obj = null;
        s = s.trim().replace(" ", "+");
        obj1 = (new StringBuilder("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=")).append(URLEncoder.encode(s, e.a.name())).append("&rsz=").append(super.b).append("&start=").append(super.c).append("&safe=active").toString();
        s = ((String) (obj1));
        if (!"".equals(g))
        {
            s = (new StringBuilder()).append(((String) (obj1))).append("&key=").append(g).toString();
        }
        com.socialin.android.d.b(f, new Object[] {
            (new StringBuilder("Google:::   ")).append(s).toString()
        });
        obj1 = (new URL(s)).openConnection();
        s = new StringBuilder();
        obj1 = new BufferedReader(new InputStreamReader(((URLConnection) (obj1)).getInputStream()));
        do
        {
            String s1 = ((BufferedReader) (obj1)).readLine();
            if (s1 == null)
            {
                break;
            }
            s.append(s1);
        } while (true);
        s = new JSONObject(s.toString());
        com.socialin.android.d.b(f, new Object[] {
            (new StringBuilder("  Google_response::  ")).append(s).toString()
        });
        obj1 = s.optJSONObject("responseData");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_342;
        }
        s = obj;
        if (((JSONObject) (obj1)).has("cursor"))
        {
            s = ((JSONObject) (obj1)).getJSONObject("cursor").getString("estimatedResultCount");
        }
        if (s != null)
        {
            try
            {
                b(Integer.parseInt(s));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                b(0x7fffffff);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                com.socialin.android.d.a(f, s);
            }
        }
        if (((JSONObject) (obj1)).has("results"))
        {
            s = ((JSONObject) (obj1)).optJSONArray("results");
        } else
        {
            s = new JSONArray();
        }
        return a(s);
        if ("out of range start".equals(s.optString("responseDetails", "")))
        {
            super.e = true;
        }
        return null;
    }

    private void c()
    {
        super.b = 8;
        b(0);
        a(0);
    }

    public final List a(String s)
    {
        List list;
        try
        {
            list = b(s);
            a(super.c + super.b);
            s = b(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.a(f, s);
            return new ArrayList();
        }
        if (list == null || s == null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        for (s = s.iterator(); s.hasNext(); list.add((b)s.next())) { }
        return list;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        c();
        activity = getActivity().getIntent();
        if (activity.hasExtra("googleApiKey"))
        {
            g = activity.getStringExtra("googleApiKey");
            Log.i(f, (new StringBuilder("onCreate() - googleApiKey: ")).append(g).toString());
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        c();
        com.socialin.android.d.b(f, new Object[] {
            "onCreateView"
        });
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }

}
