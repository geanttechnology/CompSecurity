// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import com.tremorvideo.sdk.android.e.a;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            n, ad, ae, az, 
//            br

public class r extends n
{

    private a A;
    public String r;
    public String s;
    public int t;
    public int u;
    private String v;
    private long w;
    private long x;
    private String y;
    private String z;

    public r(br br, JSONObject jsonobject, boolean flag)
        throws Exception
    {
        super(br, jsonobject, flag);
        w = 0L;
        x = 0L;
        t = -1;
        u = 0;
        r = jsonobject.getString("url");
        if (r.endsWith(".zip"))
        {
            if (jsonobject.has("mraid-ad-crc32"))
            {
                w = jsonobject.getLong("mraid-ad-crc32");
            }
            if (jsonobject.has("ad-size"))
            {
                u = jsonobject.getInt("ad-size");
            } else
            {
                br = (new URL(r)).openConnection();
                br.connect();
                u = br.getContentLength();
            }
        }
        v = jsonobject.getString("asset-url");
        if (jsonobject.has("asset-crc32"))
        {
            x = jsonobject.getLong("asset-crc32");
        }
        if (jsonobject.has("preferred-orientation"))
        {
            t = jsonobject.getInt("preferred-orientation");
        } else
        {
            t = -1;
        }
        a(jsonobject);
    }

    public void E()
    {
        A.a();
    }

    public String F()
    {
        return A.a;
    }

    public a G()
    {
        return A;
    }

    public boolean H()
    {
        return A.b();
    }

    public List a()
    {
        ArrayList arraylist = new ArrayList();
        HashMap hashmap = new HashMap(2);
        hashmap.put("url", r);
        if (w > 0L)
        {
            hashmap.put("crc", Long.valueOf(w));
        }
        hashmap.put("mraid", Boolean.valueOf(true));
        arraylist.add(new n.a(this, com.tremorvideo.sdk.android.videoad.bf.d.a, "adZipAsset", hashmap));
        hashmap = new HashMap(1);
        hashmap.put("url", v);
        if (x > 0L)
        {
            hashmap.put("crc", Long.valueOf(x));
        }
        arraylist.add(new n.a(this, com.tremorvideo.sdk.android.videoad.bf.d.a, "JSZipAsset", hashmap));
        return arraylist;
    }

    public void a(Context context)
    {
        super.a(context);
        A = new a(context);
        if (!r.endsWith(".zip"))
        {
            break MISSING_BLOCK_LABEL_56;
        }
        s = A.a(y);
_L1:
        A.c(z);
        return;
        try
        {
            s = A.b(r);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.tremorvideo.sdk.android.videoad.ad.a(context);
            return;
        }
          goto _L1
    }

    public void a(String s1, Object obj)
        throws Exception
    {
        if (s1.compareTo("adZipAsset") == 0)
        {
            y = (String)obj;
            return;
        }
        if (s1.compareTo("JSZipAsset") == 0)
        {
            z = (String)obj;
            return;
        } else
        {
            super.a(s1, obj);
            return;
        }
    }

    public void c()
    {
        super.c();
        A.c();
    }

    public int d(int l)
    {
        if (u > 0)
        {
            return u;
        } else
        {
            return 0;
        }
    }

    public String i()
    {
        return b(r);
    }

    public int j()
    {
        return !r.endsWith(".zip") ? 0 : 1;
    }

    public String[] k()
    {
        ArrayList arraylist = new ArrayList();
        if (r.endsWith(".zip"))
        {
            arraylist.add(b(r));
        }
        if (v != null && v.endsWith(".zip"))
        {
            arraylist.add(b(v));
        }
        if (c != null)
        {
            arraylist.add(b(c.c()));
        }
        if (e != null)
        {
            arraylist.add(b(e.c()));
        }
        if (arraylist.size() > 0)
        {
            return (String[])arraylist.toArray(new String[arraylist.size()]);
        } else
        {
            return super.k();
        }
    }

    protected boolean o()
    {
        return true;
    }
}
