// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class bxn extends cre
{

    private final bxq j;
    private final Class k;
    private final mk l;
    private final cpi m;
    private final List n;
    private final List o;
    private final coe p;
    private final String q;
    private final String r;
    private final mg s;
    private byte t[];
    private Map u;
    private String v;

    bxn(bxq bxq1, Class class1, mj mj, cpi cpi1, List list, List list1, coe coe1, 
            String s1, String s2, mg mg)
    {
        super(1, "", new cnw(mj, coe1));
        j = (bxq)b.a(bxq1);
        k = (Class)b.a(class1);
        l = (mk)b.a(mj);
        m = (cpi)b.a(cpi1);
        n = (List)b.a(list);
        o = (List)b.a(list1);
        p = (coe)b.a(coe1);
        q = s1;
        r = s2;
        s = mg;
    }

    private eun a(byte abyte0[])
    {
        try
        {
            abyte0 = eun.a((eun)k.newInstance(), abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new RuntimeException("Programmer error using reflection.");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new RuntimeException("Programmer error using reflection.");
        }
        return abyte0;
    }

    public final String a()
    {
        if (v == null)
        {
            android.net.Uri.Builder builder = p.e().buildUpon().appendEncodedPath(p.c()).appendEncodedPath(j.b()).appendQueryParameter("key", q);
            if (!TextUtils.isEmpty(r))
            {
                builder.appendQueryParameter("asig", r);
            }
            java.util.Map.Entry entry;
            for (Iterator iterator = j.f().entrySet().iterator(); iterator.hasNext(); builder.appendQueryParameter((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

            v = builder.build().toString();
        }
        return v;
    }

    protected final mi a(mb mb1)
    {
        Object obj;
        Object obj1;
        eun eun1;
        obj1 = null;
        Iterator iterator;
        try
        {
            eun1 = a(mb1.b);
            obj = mb1.b;
        }
        // Misplaced declaration of an exception variable
        catch (mb mb1)
        {
            bmo.a("Failed while attemping to deserialize network response", mb1);
            return mi.a(new md(mb1));
        }
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        for (iterator = o.iterator(); iterator.hasNext(); ((cno)iterator.next()).a(((dwa) (obj)))) { }
        break; /* Loop/switch isn't completed */
_L2:
        ecd ecd1 = new ecd();
        eun.a(ecd1, ((byte []) (obj)));
        obj = ecd1.a;
        if (true) goto _L4; else goto _L3
_L3:
        ls ls1 = obj1;
        if (!j.e()) goto _L6; else goto _L5
_L5:
        byte abyte0[];
        abyte0 = mb1.b;
        mb1 = mb1.c;
        ls1 = obj1;
        if (abyte0 == null) goto _L6; else goto _L7
_L7:
        ls1 = obj1;
        if (obj == null) goto _L6; else goto _L8
_L8:
        if (((dwa) (obj)).b != 0) goto _L10; else goto _L9
_L9:
        ls1 = obj1;
_L6:
        mb1 = j;
        boolean flag;
        if (ls1 != null)
        {
            break MISSING_BLOCK_LABEL_255;
        }
        flag = false;
_L12:
        mb1.a(flag);
        return mi.a(eun1, ls1);
_L10:
        long l1 = System.currentTimeMillis();
        l1 = TimeUnit.SECONDS.toMillis(((dwa) (obj)).b) + l1;
        ls1 = new ls();
        ls1.a = abyte0;
        ls1.e = l1;
        ls1.d = l1;
        ls1.c = 0L;
        if (mb1 == null)
        {
            break MISSING_BLOCK_LABEL_248;
        }
_L11:
        ls1.f = mb1;
          goto _L6
        mb1 = Collections.emptyMap();
          goto _L11
        flag = TextUtils.equals((CharSequence)ls1.f.get("X-YouTube-cache-hit"), "true");
          goto _L12
    }

    protected final void a(Object obj)
    {
        obj = (eun)obj;
        t = null;
        l.a(obj);
    }

    public final String b()
    {
        String s2 = j.c();
        String s1 = s2;
        if ("NO_CACHE_KEY_VALUE".equals(s2))
        {
            s1 = super.b();
        }
        return s1;
    }

    public final List b(mb mb1)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        arraylist = new ArrayList();
        String s1 = String.valueOf(k.getName());
        arraylist.add((new StringBuilder(String.valueOf(s1).length() + 16)).append("Response type: ").append(s1).append("\n").toString());
        int i1 = mb1.a;
        arraylist.add((new StringBuilder(20)).append("Status: ").append(i1).append("\n").toString());
        boolean flag = j.k();
        arraylist.add((new StringBuilder(14)).append("Cached: ").append(flag).append("\n").toString());
        String s2;
        String s3;
        for (Iterator iterator = mb1.c.keySet().iterator(); iterator.hasNext(); arraylist.add((new StringBuilder(String.valueOf(s2).length() + 9 + String.valueOf(s3).length())).append("Header:").append(s2).append(":").append(s3).append("\n").toString()))
        {
            s2 = (String)iterator.next();
            s3 = (String)mb1.c.get(s2);
        }

        int j1 = mb1.a;
        if (j1 != 200) goto _L2; else goto _L1
_L1:
        try
        {
            int k1 = mb1.b.length;
            arraylist.add((new StringBuilder(46)).append("Actual response length (as proto): ").append(k1).toString());
            for (mb1 = a.a(a.a(a(mb1.b)).toString(), 2048).iterator(); mb1.hasNext(); arraylist.add((String)mb1.next())) { }
            break MISSING_BLOCK_LABEL_400;
        }
        // Misplaced declaration of an exception variable
        catch (mb mb1) { }
        finally
        {
            throw mb1;
        }
        arraylist.add("Could not parse response. See earlier logcat.");
        bmo.a("Could not parse response", mb1);
_L3:
        this;
        JVM INSTR monitorexit ;
        return arraylist;
_L2:
        mb1 = String.valueOf(new String(mb1.b));
        if (mb1.length() == 0)
        {
            break MISSING_BLOCK_LABEL_445;
        }
        mb1 = "Error response: ".concat(mb1);
_L4:
        arraylist.add(mb1);
          goto _L3
        mb1 = new String("Error response: ");
          goto _L4
    }

    public final Map c()
    {
        if (u == null)
        {
            u = new HashMap();
            u.put("Content-Type", "application/x-protobuf");
            m.a(u, a(), h());
            for (Iterator iterator = n.iterator(); iterator.hasNext(); ((cqs)iterator.next()).a(u, this)) { }
        }
        return u;
    }

    public final byte[] h()
    {
        if (t == null)
        {
            j.g();
            t = eun.a(j.d());
        }
        return t;
    }

    public final mg i()
    {
        return s;
    }

    public final cpl j()
    {
        return j.j();
    }

    public final String k()
    {
        StringBuilder stringbuilder = new StringBuilder();
        try
        {
            stringbuilder.append("curl ");
            Map map = c();
            Iterator iterator = map.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator.next();
                if (!s1.equals("Content-Type"))
                {
                    String s2 = (String)map.get(s1);
                    stringbuilder.append((new StringBuilder(String.valueOf(s1).length() + 7 + String.valueOf(s2).length())).append("-H \"").append(s1).append(":").append(s2).append("\" ").toString());
                }
            } while (true);
        }
        catch (lq lq1)
        {
            bmo.c("Curl command line not available", lq1);
        }
        stringbuilder.append("-H \"Content-Type:application/json\" ");
        stringbuilder.append("-d '");
        stringbuilder.append(a.a(j.d()).toString());
        stringbuilder.append("' ");
        stringbuilder.append(a());
        return stringbuilder.toString();
    }
}
