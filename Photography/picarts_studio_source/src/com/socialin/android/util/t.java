// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import com.socialin.android.d;
import java.io.RandomAccessFile;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.util:
//            v, u

public class t
{

    private static final String a = com/socialin/android/util/t.getSimpleName();
    private static HashMap b;
    private RandomAccessFile c;
    private v d[];
    private long e;

    public t()
    {
    }

    private void a(int i)
    {
        Object aobj[] = new byte[i];
        c.readFully(((byte []) (aobj)));
        e = c.getFilePointer();
        aobj = (new String(((byte []) (aobj)))).split(",");
        i = aobj.length;
        if (i % 3 != 0)
        {
            throw new RuntimeException("Meta info Array lenght must be divided by 3");
        }
        int j = i / 3;
        d = new v[j];
        for (i = 0; i < j; i++)
        {
            int k = i * 3;
            v v1 = new v();
            int l = k + 1;
            v1.a = Integer.parseInt(aobj[k]);
            v1.b = Integer.parseInt(aobj[l]);
            v1.c = aobj[l + 1];
            d[i] = v1;
        }

    }

    public static void a(t t1, String s)
    {
        if (b == null)
        {
            b = new HashMap(10);
        }
        b.remove(s);
        u u1 = new u();
        u1.a = t1.d;
        u1.b = t1.e;
        b.put(s, u1);
    }

    public static void b(String s)
    {
        if (b != null)
        {
            b.remove(s);
        }
    }

    public static boolean c(String s)
    {
        return b != null && b.containsKey(s);
    }

    private void d(String s)
    {
        JSONArray jsonarray = new JSONArray(s);
        int j = jsonarray.length();
        d = new v[j];
        for (int i = 0; i < j; i++)
        {
            v v1 = new v();
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            v1.a = jsonobject.getInt("start");
            v1.b = jsonobject.getInt("size");
            v1.c = jsonobject.getString("name");
            d[i] = v1;
        }

        e = s.getBytes().length + 2;
        if (d.b)
        {
            (new StringBuilder("initWithoutCacheOld filesStartPos ")).append(e);
        }
    }

    public final t a(RandomAccessFile randomaccessfile, String s)
    {
        c = randomaccessfile;
        if (s == null || b == null) goto _L2; else goto _L1
_L1:
        randomaccessfile = (u)b.get(s);
        if (randomaccessfile == null) goto _L2; else goto _L3
_L3:
        int i;
        d = ((u) (randomaccessfile)).a;
        e = ((u) (randomaccessfile)).b;
        i = 0;
_L6:
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        randomaccessfile = c.readLine();
        i = Integer.parseInt(randomaccessfile);
_L4:
        if (i != -1)
        {
            try
            {
                a(i);
            }
            // Misplaced declaration of an exception variable
            catch (RandomAccessFile randomaccessfile)
            {
                throw new IllegalArgumentException();
            }
            return this;
        }
        break MISSING_BLOCK_LABEL_116;
        s;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
        });
        i = -1;
          goto _L4
        d(randomaccessfile);
        return this;
_L2:
        i = 1;
        if (true) goto _L6; else goto _L5
_L5:
        return this;
    }

    public final byte[] a(String s)
    {
        int i = 0;
_L3:
        if (i >= d.length)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        if (!d[i].c.equals(s)) goto _L2; else goto _L1
_L1:
        Object obj;
        if (i == -1 || i >= d.length)
        {
            obj = null;
        } else
        {
            obj = d[i];
            long l = ((v) (obj)).a;
            long l1 = e;
            byte abyte0[] = new byte[((v) (obj)).b];
            obj = abyte0;
            if (c != null)
            {
                c.seek(l + l1);
                c.readFully(abyte0);
                obj = abyte0;
            }
        }
        if (obj == null)
        {
            com.socialin.android.d.b((new StringBuilder("Can't find file ")).append(s).toString());
        }
        return ((byte []) (obj));
_L2:
        i++;
          goto _L3
        i = -1;
          goto _L1
    }

}
