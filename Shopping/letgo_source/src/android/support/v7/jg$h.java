// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            jg, kb

static class b
{

    private static Object a = new Object();
    private Context b;
    private HashMap c;

    public static b a(Context context)
    {
        synchronized (a)
        {
            context = new <init>(context);
            context.c();
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static void a(Context context, c c1, c c2)
    {
        HashMap hashmap = new HashMap();
        hashmap.put(c1, c2);
        a(context, ((Map) (hashmap)));
    }

    public static void a(Context context, Map map)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        context = a(context);
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            java.util.ntry ntry = (java.util.ntry)map.next();
            List list = ((xt)ntry.getValue()).b();
            if (list.size() != 0)
            {
                context.a((a)ntry.getKey(), list);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_89;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        context.b();
        obj;
        JVM INSTR monitorexit ;
    }

    private void b()
    {
        ObjectOutputStream objectoutputstream1 = new ObjectOutputStream(new BufferedOutputStream(b.openFileOutput("AppEventsLogger.persistedevents", 0)));
        ObjectOutputStream objectoutputstream = objectoutputstream1;
        objectoutputstream1.writeObject(c);
        kb.a(objectoutputstream1);
        return;
        Exception exception1;
        exception1;
        objectoutputstream1 = null;
_L4:
        objectoutputstream = objectoutputstream1;
        Log.d(jg.h(), (new StringBuilder()).append("Got unexpected exception: ").append(exception1.toString()).toString());
        kb.a(objectoutputstream1);
        return;
        Exception exception;
        exception;
        objectoutputstream = null;
_L2:
        kb.a(objectoutputstream);
        throw exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
        exception1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void c()
    {
        Object obj1 = null;
        Object obj = new ObjectInputStream(new BufferedInputStream(b.openFileInput("AppEventsLogger.persistedevents")));
        obj1 = obj;
        HashMap hashmap = (HashMap)((ObjectInputStream) (obj)).readObject();
        obj1 = obj;
        b.getFileStreamPath("AppEventsLogger.persistedevents").delete();
        obj1 = obj;
        c = hashmap;
        kb.a(((java.io.Closeable) (obj)));
        return;
        obj;
        obj = obj1;
_L6:
        kb.a(((java.io.Closeable) (obj)));
        return;
        Exception exception1;
        exception1;
        obj = null;
_L4:
        obj1 = obj;
        Log.d(jg.h(), (new StringBuilder()).append("Got unexpected exception: ").append(exception1.toString()).toString());
        kb.a(((java.io.Closeable) (obj)));
        return;
        Exception exception;
        exception;
        obj1 = null;
_L2:
        kb.a(((java.io.Closeable) (obj1)));
        throw exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
        exception1;
        if (true) goto _L4; else goto _L3
_L3:
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public List a(toString tostring)
    {
        return (List)c.get(tostring);
    }

    public Set a()
    {
        return c.keySet();
    }

    public void a( , List list)
    {
        if (!c.containsKey())
        {
            c.put(, new ArrayList());
        }
        ((List)c.get()).addAll(list);
    }


    private ption(Context context)
    {
        c = new HashMap();
        b = context;
    }
}
