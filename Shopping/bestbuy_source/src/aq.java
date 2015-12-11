// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class aq
{

    private final m a;
    private final b._cls1 b;
    private final List c;

    aq(m m1, b._cls1 _pcls1, List list)
    {
        b = _pcls1;
        a = m1;
        c = list;
    }

    private void a(e e1)
    {
        for (Iterator iterator = c.iterator(); iterator.hasNext(); iterator.next()) { }
        e1.a("mat", (new StringBuilder()).append(b.a()).toString());
        String s = b.b();
        if (s != null)
        {
            e1.a("di", s);
        }
    }

    private void a(JSONObject jsonobject)
    {
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((as)iterator.next()).a()) { }
        if (!jsonobject.has("command"))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!"disable-agent".equals(jsonobject.getString("command"))) goto _L1; else goto _L3
_L3:
        if (jsonobject.has("until"))
        {
            jsonobject = new ar(jsonobject.getLong("until"));
        } else
        {
            jsonobject = new ar();
        }
        bc.a("Agent Registration was denied by the collector. Throwing exception");
        throw jsonobject;
        if (!jsonobject.has("mat")) goto _L1; else goto _L4
_L4:
        InputStream inputstream;
        InputStream inputstream1;
        Object obj;
        jsonobject = jsonobject.getString("mat");
        b.a(jsonobject);
        if (bc.a())
        {
            bc.a((new StringBuilder("Calling url: ")).append(a.c).append(" to register agent.").toString());
        }
        obj = null;
        inputstream1 = null;
        inputstream = inputstream1;
        jsonobject = obj;
        e e1 = a.a();
        inputstream = inputstream1;
        jsonobject = obj;
        e1.a("POST");
        inputstream = inputstream1;
        jsonobject = obj;
        e1.a("sr", "true");
        inputstream = inputstream1;
        jsonobject = obj;
        inputstream1 = e1.g();
        inputstream = inputstream1;
        jsonobject = inputstream1;
        bc.a(e1.g());
        bc.a(inputstream1);
        return;
        IOException ioexception;
        ioexception;
        jsonobject = inputstream;
        bc.b("Exception while trying to register with collector", ioexception);
        bc.a(inputstream);
        return;
        Exception exception;
        exception;
        bc.a(jsonobject);
        throw exception;
    }

    private boolean a(String s)
    {
        long l;
        boolean flag;
        flag = false;
        l = System.currentTimeMillis();
        if (bc.a())
        {
            bc.a((new StringBuilder("[")).append(bc.b()).append("] Agent sending message to collector (").append(a.b).append(") [").append(a.a.b()).append("]:").toString());
            bc.a(s);
            bc.a("-----------------------------------");
        }
        e e1 = a.b();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        e1.a("gzip", "true");
        a(e1);
        GZIPOutputStream gzipoutputstream = new GZIPOutputStream(e1.f());
        gzipoutputstream.write(s.getBytes());
        gzipoutputstream.close();
        s = e1.g();
        int i;
        i = e1.h();
        if (bc.a())
        {
            bc.a((new StringBuilder("Agent received response code: ")).append(i).toString());
        }
        if (i != 200) goto _L2; else goto _L1
_L1:
        a(bb.a(s));
        s.close();
        if (bc.a())
        {
            bc.a((new StringBuilder("[")).append(bc.b()).append("] Total time taken to complete request is ").append(System.currentTimeMillis() - l).append(" ms.").toString());
        }
        flag = true;
_L4:
        return flag;
_L2:
        s.close();
        if (!bc.a()) goto _L4; else goto _L3
_L3:
        bc.a((new StringBuilder("[")).append(bc.b()).append("] Total time taken to complete request is ").append(System.currentTimeMillis() - l).append(" ms.").toString());
        return false;
        Object obj;
        obj;
        bc.a("Error processing JSON", ((Throwable) (obj)));
        s.close();
        if (!bc.a()) goto _L4; else goto _L5
_L5:
        bc.a((new StringBuilder("[")).append(bc.b()).append("] Total time taken to complete request is ").append(System.currentTimeMillis() - l).append(" ms.").toString());
        return false;
        obj;
        try
        {
            s.close();
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        finally
        {
            if (!bc.a()) goto _L0; else goto _L0
        }
        bc.a("Error sending message to collector", s);
        if (!bc.a()) goto _L4; else goto _L6
_L6:
        bc.a((new StringBuilder("[")).append(bc.b()).append("] Total time taken to complete request is ").append(System.currentTimeMillis() - l).append(" ms.").toString());
        return false;
        bc.a((new StringBuilder("[")).append(bc.b()).append("] Total time taken to complete request is ").append(System.currentTimeMillis() - l).append(" ms.").toString());
        throw s;
    }

    final m a()
    {
        return a;
    }

    final boolean a(JSONArray jsonarray)
    {
        return a(jsonarray.toString());
    }
}
