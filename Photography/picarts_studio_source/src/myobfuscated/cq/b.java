// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cq;

import android.app.Activity;
import android.os.Bundle;
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
import myobfuscated.cx.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends d
{

    private static String f = myobfuscated/cq/b.getSimpleName();

    public b()
    {
    }

    private static List a(JSONArray jsonarray, int i)
    {
        ArrayList arraylist = new ArrayList();
        for (int j = 0; j < i; j++)
        {
            myobfuscated.cv.b b1 = new myobfuscated.cv.b();
            b1.a = jsonarray.getJSONObject(j).getJSONObject("gphoto$id").getString("$t");
            String s = jsonarray.getJSONObject(j).getJSONObject("media$group").getJSONArray("media$thumbnail").getJSONObject(1).getString("url").replaceAll("s144", "s288");
            b1.d = s;
            b1.c = s.replaceAll("s288", "s640");
            arraylist.add(b1);
        }

        return arraylist;
    }

    private List b(String s)
    {
        Object obj;
        s = (new StringBuilder("http://picasaweb.google.com/data/feed/base/all?alt=json&kind=photo&access=public&hl=en_US&filter=1&q=")).append(URLEncoder.encode(s, e.a.name())).append("&visibility=visible&start-index=").append(super.c).append("&max-results=").append(super.b).toString();
        com.socialin.android.d.b(f, new Object[] {
            s
        });
        obj = (new URL(s)).openConnection();
        s = new StringBuilder();
        obj = new BufferedReader(new InputStreamReader(((URLConnection) (obj)).getInputStream()));
_L1:
        String s1 = ((BufferedReader) (obj)).readLine();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        s.append(s1);
          goto _L1
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        com.socialin.android.d.a(f, outofmemoryerror);
        s = s.toString();
        com.socialin.android.d.b(f, new Object[] {
            (new StringBuilder("response:    ")).append(s).toString()
        });
        s = new JSONObject(s);
        JSONArray jsonarray;
        int i;
        if (s.has("feed"))
        {
            s = s.getJSONObject("feed");
        } else
        {
            s = new JSONObject();
        }
        if (s.has("entry"))
        {
            jsonarray = s.getJSONArray("entry");
        } else
        {
            jsonarray = new JSONArray();
        }
        i = jsonarray.length();
        if (s.has("openSearch$totalResults"))
        {
            s = s.optJSONObject("openSearch$totalResults");
            if (s != null && s.has("$t"))
            {
                b(s.optInt("$t", super.d));
            }
        }
        if (i > 0)
        {
            return b(jsonarray, i);
        } else
        {
            return new ArrayList();
        }
    }

    private static List b(JSONArray jsonarray, int i)
    {
        ArrayList arraylist;
        int j;
        arraylist = new ArrayList();
        j = 0;
_L7:
        if (j >= i) goto _L2; else goto _L1
_L1:
        Object obj;
        myobfuscated.cv.b b1;
        b1 = new myobfuscated.cv.b();
        obj = "";
        Object obj1;
        b1.a = jsonarray.getJSONObject(j).getJSONObject("gphoto$id").getString("$t");
        obj1 = jsonarray.getJSONObject(j).getJSONObject("media$group");
        if (!((JSONObject) (obj1)).has("media$thumbnail")) goto _L4; else goto _L3
_L3:
        obj = ((JSONObject) (obj1)).getJSONArray("media$thumbnail").getJSONObject(1).getString("url");
_L5:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        obj1 = obj;
        try
        {
            if (((String) (obj)).contains("s144"))
            {
                obj1 = ((String) (obj)).replaceAll("s144", "s288");
            }
            b1.d = ((String) (obj1));
        }
        catch (Exception exception)
        {
            com.socialin.android.d.b(f, "Picasa search photo", exception);
            break MISSING_BLOCK_LABEL_202;
        }
        obj = obj1;
        if (((String) (obj1)).contains("s288"))
        {
            obj = ((String) (obj1)).replaceAll("s288", "s640");
        }
        b1.c = ((String) (obj));
        arraylist.add(b1);
        break MISSING_BLOCK_LABEL_202;
_L4:
        if (((JSONObject) (obj1)).has("media$content"))
        {
            obj = ((JSONObject) (obj1)).getJSONArray("media$content").getJSONObject(0).getString("url");
        }
        if (true) goto _L5; else goto _L2
_L2:
        return arraylist;
        j++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void c()
    {
        super.b = 60;
        b(1);
        a(1);
    }

    private List d()
    {
        Object obj;
        Object obj1;
        obj = (new StringBuilder("http://picasaweb.google.com/data/feed/base/featured?alt=json&kind=photo&access=public&hl=en_US&slabel=featured&start-index=")).append(super.c).append("&max-results=").append(super.b).toString();
        com.socialin.android.d.b(f, new Object[] {
            obj
        });
        obj1 = (new URL(((String) (obj)))).openConnection();
        obj = new StringBuilder();
        obj1 = new BufferedReader(new InputStreamReader(((URLConnection) (obj1)).getInputStream()));
_L2:
        String s = ((BufferedReader) (obj1)).readLine();
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        int i;
        boolean flag;
        try
        {
            ((StringBuilder) (obj)).append(s);
            flag = ((BufferedReader) (obj1)).ready();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(f, "picasaFeaturedPhotos", ((Throwable) (obj)));
            return new ArrayList();
        }
        if (flag) goto _L2; else goto _L1
_L1:
        obj1 = ((StringBuilder) (obj)).toString();
        ((StringBuilder) (obj)).replace(0, ((StringBuilder) (obj)).length(), "");
        com.socialin.android.d.b(f, new Object[] {
            (new StringBuilder("  response:    ")).append(((String) (obj1))).toString()
        });
        obj = new JSONObject(((String) (obj1)));
        if (((JSONObject) (obj)).has("feed"))
        {
            obj = ((JSONObject) (obj)).getJSONObject("feed");
        } else
        {
            obj = new JSONObject();
        }
        if (((JSONObject) (obj)).has("entry"))
        {
            obj1 = ((JSONObject) (obj)).getJSONArray("entry");
        } else
        {
            obj1 = new JSONArray();
        }
        i = ((JSONArray) (obj1)).length();
        if (((JSONObject) (obj)).has("openSearch$totalResults"))
        {
            obj = ((JSONObject) (obj)).optJSONObject("openSearch$totalResults");
            if (obj != null && ((JSONObject) (obj)).has("$t"))
            {
                b(((JSONObject) (obj)).optInt("$t", super.d));
            }
        }
        if (i > 0)
        {
            return a(((JSONArray) (obj1)), i);
        } else
        {
            return new ArrayList();
        }
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
        com.socialin.android.d.b(f, "searchPhotos", s);
        return null;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        com.socialin.android.d.b(f, new Object[] {
            "onAttach"
        });
        c();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        c();
        com.socialin.android.d.b(f, new Object[] {
            "onCreateView"
        });
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public void onDetach()
    {
        super.onDetach();
        c();
    }

}
