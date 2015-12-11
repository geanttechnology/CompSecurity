// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            y, n, t, ad

private class e
{

    public String a;
    public String b;
    public int c;
    public String d[];
    public long e;
    public int f;
    final y g;

    public void a(n n1)
    {
        boolean flag = false;
        b = n1.h();
        f = 0;
        String as[] = n1.k();
        d = new String[as.length];
        for (int i = 0; i < d.length; i++)
        {
            d[i] = as[i];
        }

        e = 0L;
        for (int j = 0; j < as.length; j++)
        {
            e = e + (long)n1.d(j);
        }

        if (n1 instanceof t)
        {
            n1 = d;
            int l = n1.length;
            for (int k = ((flag) ? 1 : 0); k < l; k++)
            {
                Object obj = n1[k];
                obj = y.a(g, ((String) (obj)));
                if (((File) (obj)).exists())
                {
                    e = e + (long)(int)((File) (obj)).length();
                }
            }

        }
    }

    public void a(File file)
        throws Exception
    {
        int i = 0;
        file = new JSONObject(ad.a(file));
        c = file.getInt("views");
        a = file.getString("base-file");
        b = file.getString("expiration-date");
        e = file.getLong("total-size");
        f = file.getInt("priority");
        if (!file.has("files"))
        {
            d = new String[0];
        } else
        {
            file = file.getJSONArray("files");
            d = new String[file.length()];
            while (i < file.length()) 
            {
                d[i] = file.getString(i);
                i++;
            }
        }
    }

    public void a(String s)
    {
        JSONObject jsonobject;
        JSONArray jsonarray;
        jsonobject = new JSONObject();
        jsonarray = new JSONArray();
        int i = 0;
_L2:
        if (i >= d.length)
        {
            break; /* Loop/switch isn't completed */
        }
        jsonarray.put(d[i]);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            jsonobject.put("files", jsonarray);
            jsonobject.put("views", c);
            jsonobject.put("expiration-date", b);
            jsonobject.put("base-file", a);
            jsonobject.put("total-size", e);
            jsonobject.put("priority", f);
            s = new FileOutputStream(new File(s));
            s.write(jsonobject.toString().getBytes());
            s.flush();
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ad.a(s);
        }
        return;
    }

    public (y y1)
    {
        g = y1;
        super();
    }

    public g(y y1, n n1, File file)
    {
        boolean flag = false;
        g = y1;
        super();
        a = n1.i();
        c = 0;
        b = n1.h();
        f = 0;
        file = n1.k();
        d = new String[file.length];
        for (int i = 0; i < d.length; i++)
        {
            d[i] = file[i];
        }

        for (int j = 0; j < file.length; j++)
        {
            e = e + (long)n1.d(j);
        }

        if (n1 instanceof t)
        {
            n1 = d;
            int l = n1.length;
            for (int k = ((flag) ? 1 : 0); k < l; k++)
            {
                file = y.a(y1, n1[k]);
                if (file.exists())
                {
                    e = e + (long)(int)file.length();
                }
            }

        }
    }
}
