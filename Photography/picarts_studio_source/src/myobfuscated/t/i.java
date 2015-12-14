// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.t;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import myobfuscated.o.a;
import myobfuscated.o.b;
import myobfuscated.o.d;

// Referenced classes of package myobfuscated.t:
//            a, e, q, f, 
//            g, c

public final class i
    implements myobfuscated.t.a
{

    private static i a = null;
    private final q b = new q();
    private final File c;
    private final int d;
    private final e e = new e();
    private a f;

    private i(File file, int j)
    {
        c = file;
        d = j;
    }

    private a a()
    {
        this;
        JVM INSTR monitorenter ;
        a a1;
        if (f == null)
        {
            f = myobfuscated.o.a.a(c, d);
        }
        a1 = f;
        this;
        JVM INSTR monitorexit ;
        return a1;
        Exception exception;
        exception;
        throw exception;
    }

    public static myobfuscated.t.a a(File file, int j)
    {
        myobfuscated/t/i;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new i(file, j);
        }
        file = a;
        myobfuscated/t/i;
        JVM INSTR monitorexit ;
        return file;
        file;
        throw file;
    }

    public final File a(com.bumptech.glide.load.b b1)
    {
        Object obj;
        Object obj1;
        obj1 = b.a(b1);
        if (Log.isLoggable("DiskLruCacheWrapper", 2))
        {
            (new StringBuilder("Get: Obtained: ")).append(((String) (obj1))).append(" for for Key: ").append(b1);
        }
        obj = null;
        obj1 = a().a(((String) (obj1)));
        b1 = obj;
        if (obj1 != null)
        {
            try
            {
                b1 = ((d) (obj1)).a[0];
            }
            catch (IOException ioexception)
            {
                b1 = obj;
                if (Log.isLoggable("DiskLruCacheWrapper", 5))
                {
                    Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", ioexception);
                    return null;
                }
            }
        }
        return b1;
    }

    public final void a(com.bumptech.glide.load.b b1, c c1)
    {
        Object obj2 = e;
        obj2;
        JVM INSTR monitorenter ;
        Object obj1 = (f)((e) (obj2)).a.get(b1);
        Object obj;
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        obj = ((e) (obj2)).b.a();
        ((e) (obj2)).a.put(b1, obj);
        obj.b = ((f) (obj)).b + 1;
        obj2;
        JVM INSTR monitorexit ;
        ((f) (obj)).a.lock();
        obj = b.a(b1);
        if (Log.isLoggable("DiskLruCacheWrapper", 2))
        {
            (new StringBuilder("Put: Obtained: ")).append(((String) (obj))).append(" for for Key: ").append(b1);
        }
        obj1 = a();
        obj2 = ((a) (obj1)).a(((String) (obj)));
        if (obj2 != null)
        {
            e.a(b1);
            return;
        }
        break MISSING_BLOCK_LABEL_152;
        b1;
        obj2;
        JVM INSTR monitorexit ;
        throw b1;
        obj1 = ((a) (obj1)).b(((String) (obj)));
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        try
        {
            throw new IllegalStateException((new StringBuilder("Had two simultaneous puts for: ")).append(((String) (obj))).toString());
        }
        // Misplaced declaration of an exception variable
        catch (c c1) { }
        finally
        {
            e.a(b1);
        }
        if (Log.isLoggable("DiskLruCacheWrapper", 5))
        {
            Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", c1);
        }
_L4:
        e.a(b1);
        return;
_L2:
        File file = ((b) (obj1)).a();
        if (c1.a.a(c1.b, file, c1.c))
        {
            myobfuscated.o.a.a(((b) (obj1)).d, ((b) (obj1)), true);
            obj1.c = true;
        }
        ((b) (obj1)).c();
        if (true) goto _L4; else goto _L3
_L3:
        throw c1;
        c1;
        ((b) (obj1)).c();
        throw c1;
    }

}
