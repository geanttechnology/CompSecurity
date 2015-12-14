// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.asyncnet.cache;

import com.socialin.android.apiv3.model.parsers.IStreamParser;
import com.socialin.android.c;
import com.socialin.android.d;
import com.socialin.gson.Gson;
import com.socialin.gson.stream.JsonReader;
import com.socialin.gson.stream.JsonWriter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import myobfuscated.am.b;
import myobfuscated.am.e;
import myobfuscated.am.f;

// Referenced classes of package com.socialin.asyncnet.cache:
//            a, b

public class CacheManager
{

    public static final Object a = com/socialin/asyncnet/cache/CacheManager.getSimpleName();
    public static String b;
    private static CacheManager e;
    public final Object c = new Object();
    public int d;
    private b f;

    private CacheManager()
    {
    }

    public static CacheManager a()
    {
        if (e == null)
        {
            e = new CacheManager();
        }
        return e;
    }

    private static JsonWriter a(a a1, OutputStream outputstream, int i)
    {
        outputstream = new JsonWriter(new OutputStreamWriter(new BufferedOutputStream(outputstream)));
        a1.a(System.currentTimeMillis());
        if (i != 0) goto _L2; else goto _L1
_L1:
        com.socialin.android.c.a().toJson(a1.f, a1.f.getClass(), outputstream);
_L4:
        try
        {
            outputstream.flush();
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            com.socialin.android.d.a(new Object[] {
                a, (new StringBuilder("Got unexpected exception: ")).append(a1.getMessage()).toString()
            });
            return outputstream;
        }
        return outputstream;
_L2:
        if (i == 1)
        {
            com.socialin.android.c.a().toJson(a1.d, a1.d.getClass(), outputstream);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(a a1)
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        if (f == null || f.a())
        {
            b();
        }
        obj1 = f;
        if (obj1 == null || a1 == null) goto _L2; else goto _L1
_L1:
        obj1 = f.b(a1.b);
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        a(a1, ((myobfuscated.am.c) (obj1)).a(0), 0);
        a(a1, ((myobfuscated.am.c) (obj1)).a(1), 1);
        if (!((myobfuscated.am.c) (obj1)).c) goto _L4; else goto _L3
_L3:
        myobfuscated.am.b.a(((myobfuscated.am.c) (obj1)).d, ((myobfuscated.am.c) (obj1)), false);
        ((myobfuscated.am.c) (obj1)).d.c(((myobfuscated.am.c) (obj1)).a.a);
_L5:
        f.b();
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        a1;
        obj;
        JVM INSTR monitorexit ;
        throw a1;
_L4:
        myobfuscated.am.b.a(((myobfuscated.am.c) (obj1)).d, ((myobfuscated.am.c) (obj1)), true);
          goto _L5
        a1;
        com.socialin.android.d.a(new Object[] {
            a, (new StringBuilder("Got unexpected exception: ")).append(a1.getMessage()).toString()
        });
          goto _L2
    }

    public final Object b(a a1)
    {
        Object obj1 = c;
        obj1;
        JVM INSTR monitorenter ;
        if (f == null || f.a())
        {
            b();
        }
        f f1 = f.a(a1.b);
        Object obj;
        if (f1 == null)
        {
            break MISSING_BLOCK_LABEL_310;
        }
        obj = f1;
        Object obj2 = new JsonReader(new InputStreamReader(new BufferedInputStream(f1.a[0])));
        obj = f1;
        obj2 = (com.socialin.asyncnet.cache.b)com.socialin.android.c.a().fromJson(((JsonReader) (obj2)), com/socialin/asyncnet/cache/b);
        obj = f1;
        a1.a(((com.socialin.asyncnet.cache.b) (obj2)).a);
        obj = f1;
        if (((com.socialin.asyncnet.cache.b) (obj2)).b == 0L)
        {
            break MISSING_BLOCK_LABEL_217;
        }
        obj = f1;
        if (((com.socialin.asyncnet.cache.b) (obj2)).b + ((com.socialin.asyncnet.cache.b) (obj2)).a >= System.currentTimeMillis())
        {
            break MISSING_BLOCK_LABEL_217;
        }
        obj = f1;
        a1.e = false;
        obj = f1;
        int i = a1.a;
        if (i == 2)
        {
            break MISSING_BLOCK_LABEL_217;
        }
        if (f1 == null)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        f1.close();
_L1:
        obj1;
        JVM INSTR monitorexit ;
        return null;
        a1;
        com.socialin.android.d.a(new Object[] {
            a, (new StringBuilder("Got unexpected exception: ")).append(a1.getMessage()).toString()
        });
          goto _L1
        a1;
        obj1;
        JVM INSTR monitorexit ;
        throw a1;
        obj = f1;
        obj2 = new BufferedInputStream(f1.a[1]);
        obj = f1;
        a1 = ((a) (a1.c.parse(((java.io.InputStream) (obj2)))));
        obj = f1;
        f.b();
        if (f1 == null)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        f1.close();
_L2:
        obj1;
        JVM INSTR monitorexit ;
        return a1;
        obj;
        com.socialin.android.d.a(new Object[] {
            a, (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
        });
          goto _L2
        if (f1 == null)
        {
            break MISSING_BLOCK_LABEL_318;
        }
        f1.close();
_L3:
        obj1;
        JVM INSTR monitorexit ;
        return null;
        a1;
        com.socialin.android.d.a(new Object[] {
            a, (new StringBuilder("Got unexpected exception: ")).append(a1.getMessage()).toString()
        });
          goto _L3
        a1;
        f1 = null;
_L8:
        obj = f1;
        com.socialin.android.d.a(new Object[] {
            a, (new StringBuilder("Got unexpected exception: ")).append(a1.getMessage()).toString()
        });
        if (f1 == null) goto _L3; else goto _L4
_L4:
        f1.close();
          goto _L3
        a1;
        com.socialin.android.d.a(new Object[] {
            a, (new StringBuilder("Got unexpected exception: ")).append(a1.getMessage()).toString()
        });
          goto _L3
        a1;
        obj = null;
_L7:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_466;
        }
        ((f) (obj)).close();
_L5:
        throw a1;
        Exception exception;
        exception;
        com.socialin.android.d.a(new Object[] {
            a, (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
        });
          goto _L5
        a1;
        if (true) goto _L7; else goto _L6
_L6:
        a1;
          goto _L8
    }

    public final void b()
    {
        try
        {
            f = myobfuscated.am.b.a(new File(b), d);
            return;
        }
        catch (IOException ioexception)
        {
            com.socialin.android.d.a(new Object[] {
                a, (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
            });
        }
    }

    public final void c()
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        if (f != null)
        {
            f.c();
        }
        e = new CacheManager();
_L1:
        return;
        Object obj1;
        obj1;
        com.socialin.android.d.a(new Object[] {
            a, (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj1)).getMessage()).toString()
        });
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

}
