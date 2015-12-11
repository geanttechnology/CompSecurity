// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import org.json.JSONArray;

// Referenced classes of package a.a:
//            aa, en, eb, ef, 
//            em, ao, ee, dm, 
//            ax, dx, dw, ae

public final class z
    implements Thread.UncaughtExceptionHandler
{

    private Thread.UncaughtExceptionHandler a;
    private final aa b;

    public z(aa aa1, Thread.UncaughtExceptionHandler uncaughtexceptionhandler)
    {
        b = aa1;
        a = uncaughtexceptionhandler;
    }

    public final void uncaughtException(Thread thread, Throwable throwable)
    {
        thread = b;
        if (((aa) (thread)).q != null) goto _L2; else goto _L1
_L1:
        en.b("Unable to handle application crash. Crittercism not yet initialized");
_L6:
        if (a != null && !(a instanceof z))
        {
            a.uncaughtException(Thread.currentThread(), throwable);
        }
_L4:
        return;
_L2:
        ((aa) (thread)).q.b();
        ef.a(((aa) (thread)).c, true);
        if (((aa) (thread)).f.b())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((aa) (thread)).t)
        {
            Object obj = new ao(throwable, Thread.currentThread().getId());
            obj = (new JSONArray()).put(((ao) (obj)).a());
            (new ee((new dm(thread)).a(ax.e.f(), ((JSONArray) (obj))), new dx((new dw(((aa) (thread)).u.k(), "/android_v2/handle_crashes")).a()), null)).run();
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_204;
        thread;
        throw thread;
        thread;
        if (a != null && !(a instanceof z))
        {
            a.uncaughtException(Thread.currentThread(), throwable);
        }
        throw thread;
        thread.a(throwable);
        continue; /* Loop/switch isn't completed */
        thread;
        en.a("Unable to send crash", thread);
        if (a == null || (a instanceof z)) goto _L4; else goto _L3
_L3:
        a.uncaughtException(Thread.currentThread(), throwable);
        return;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
