// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.a;

import android.content.Context;
import android.util.Log;
import com.facebook.internal.o;
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

// Referenced classes of package com.facebook.a:
//            a

static class b
{

    private static Object a = new Object();
    private Context b;
    private HashMap c;

    public static text a(Context context)
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

    public static void a(Context context, text text, text text1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put(text, text1);
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
            java.util.Entry entry = (java.util.Entry)map.next();
            List list = ((next)entry.getValue()).b();
            if (list.size() != 0)
            {
                context.a((a)entry.getKey(), list);
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
        o.a(objectoutputstream1);
        return;
        Exception exception1;
        exception1;
        objectoutputstream1 = null;
_L4:
        objectoutputstream = objectoutputstream1;
        Log.d(com.facebook.a.a.i(), (new StringBuilder()).append("Got unexpected exception: ").append(exception1.toString()).toString());
        o.a(objectoutputstream1);
        return;
        Exception exception;
        exception;
        objectoutputstream = null;
_L2:
        o.a(objectoutputstream);
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
        o.a(((java.io.Closeable) (obj)));
        return;
        obj;
        obj = obj1;
_L6:
        o.a(((java.io.Closeable) (obj)));
        return;
        Exception exception1;
        exception1;
        obj = null;
_L4:
        obj1 = obj;
        Log.d(com.facebook.a.a.i(), (new StringBuilder()).append("Got unexpected exception: ").append(exception1.toString()).toString());
        o.a(((java.io.Closeable) (obj)));
        return;
        Exception exception;
        exception;
        obj1 = null;
_L2:
        o.a(((java.io.Closeable) (obj1)));
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

    public List a(al.o.a a1)
    {
        return (List)c.get(a1);
    }

    public Set a()
    {
        return c.keySet();
    }

    public void a(eySet eyset, List list)
    {
        if (!c.containsKey(eyset))
        {
            c.put(eyset, new ArrayList());
        }
        ((List)c.get(eyset)).addAll(list);
    }


    private text(Context context)
    {
        c = new HashMap();
        b = context;
    }
}
