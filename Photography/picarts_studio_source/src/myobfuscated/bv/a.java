// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.socialin.android.util.e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.cv.b;
import myobfuscated.cx.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends d
{

    private static final String f = myobfuscated/bv/a.getSimpleName();
    private String g;

    public a()
    {
    }

    private static String a(JSONObject jsonobject)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("http://farm");
        stringbuilder.append(jsonobject.getString("farm"));
        stringbuilder.append(".static.flickr.com/");
        stringbuilder.append(jsonobject.getString("server"));
        stringbuilder.append("/");
        stringbuilder.append(jsonobject.getString("id"));
        stringbuilder.append("_");
        stringbuilder.append(jsonobject.getString("secret"));
        return stringbuilder.toString();
    }

    private List a(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
        while (i < jsonarray.length()) 
        {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            String s;
            b b1;
            if (jsonobject.has("id"))
            {
                s = jsonobject.getString("id");
            } else
            {
                s = (new StringBuilder("flickr_")).append(super.c + i).toString();
            }
            b1 = new b();
            b1.a = s;
            b1.c = (new StringBuilder()).append(a(jsonobject)).append("_b.jpg").toString();
            b1.b = (new StringBuilder()).append(a(jsonobject)).append("_s.jpg").toString();
            b1.d = (new StringBuilder()).append(a(jsonobject)).append("_t.jpg").toString();
            b1.f = (new StringBuilder()).append(a(jsonobject)).append("_m.jpg").toString();
            arraylist.add(b1);
            i++;
        }
        return arraylist;
    }

    private List b(String s)
    {
        s = (new StringBuilder("https://api.flickr.com/services/rest/?method=flickr.photos.search&text=")).append(URLEncoder.encode(s, e.a.name())).append("&api_key=").append(g).append("&per_page=").append(super.b).append("&page=").append(super.c).append("&format=json").toString();
        com.socialin.android.d.b(f, new Object[] {
            s
        });
        Object obj = (new URL(s)).openConnection();
        s = new StringBuilder();
        obj = new BufferedReader(new InputStreamReader(((URLConnection) (obj)).getInputStream()));
        do
        {
            String s1 = ((BufferedReader) (obj)).readLine();
            if (s1 == null)
            {
                break;
            }
            s.append(s1);
        } while (true);
        com.socialin.android.d.b(f, new Object[] {
            s.toString()
        });
        int i = s.toString().indexOf("(");
        int j = s.toString().length();
        try
        {
            s = s.toString().substring(i + 1, j - 1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.b(f, "searchPhoto", s);
            s = "";
        }
        com.socialin.android.d.b(f, new Object[] {
            (new StringBuilder("SEARCH___")).append(s).toString()
        });
        s = new JSONObject(s);
        if (s.has("photos"))
        {
            s = s.getJSONObject("photos");
        } else
        {
            s = new JSONObject();
        }
        if (s.has("photo"))
        {
            obj = s.getJSONArray("photo");
        } else
        {
            obj = new JSONArray();
        }
        b(s.optInt("pages", super.d));
        return a(((JSONArray) (obj)));
    }

    private void c()
    {
        super.b = 60;
        b(0);
        a(0);
    }

    private List d()
    {
        Object obj = (new StringBuilder("https://api.flickr.com/services/rest/?method=flickr.interestingness.getList&api_key=")).append(g).append("&per_page=").append(super.b).append("&page=").append(super.c).append("&format=json").toString();
        Object obj1 = new URL(((String) (obj)));
        com.socialin.android.d.b(f, new Object[] {
            obj
        });
        obj1 = ((URL) (obj1)).openConnection();
        obj = new StringBuilder();
        obj1 = new BufferedReader(new InputStreamReader(((URLConnection) (obj1)).getInputStream()));
        do
        {
            String s = ((BufferedReader) (obj1)).readLine();
            if (s == null)
            {
                break;
            }
            ((StringBuilder) (obj)).append(s);
        } while (true);
        com.socialin.android.d.b(f, new Object[] {
            "not good", ((StringBuilder) (obj)).toString()
        });
        int i = ((StringBuilder) (obj)).toString().indexOf("(");
        int j = ((StringBuilder) (obj)).toString().length();
        try
        {
            obj = ((StringBuilder) (obj)).toString().substring(i + 1, j - 1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(f, "flickrGetInterestingPhotos", ((Throwable) (obj)));
            obj = "";
        }
        com.socialin.android.d.b(f, new Object[] {
            (new StringBuilder("INTERESTING___")).append(((String) (obj)).toString()).toString()
        });
        obj = new JSONObject(((String) (obj)));
        if (((JSONObject) (obj)).has("photos"))
        {
            obj = ((JSONObject) (obj)).getJSONObject("photos");
        } else
        {
            obj = new JSONObject();
        }
        if (((JSONObject) (obj)).has("photo"))
        {
            obj1 = ((JSONObject) (obj)).getJSONArray("photo");
        } else
        {
            obj1 = new JSONArray();
        }
        b(((JSONObject) (obj)).optInt("pages", super.d));
        return a(((JSONArray) (obj1)));
    }

    public final List a(String s)
    {
        if (b())
        {
            return d();
        }
        s = b(s);
        return s;
        s;
_L2:
        com.socialin.android.d.a(f, s);
        return null;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void a()
    {
        a(super.c + 1);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        c();
        activity = getActivity().getIntent();
        if (activity.hasExtra("fApiKey"))
        {
            g = activity.getStringExtra("fApiKey");
        } else
        {
            g = getActivity().getString(0x7f0808ea);
        }
        if (TextUtils.isEmpty(g))
        {
            throw new IllegalStateException();
        } else
        {
            return;
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
