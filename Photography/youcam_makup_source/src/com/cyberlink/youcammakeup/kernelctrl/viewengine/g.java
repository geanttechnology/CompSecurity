// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.viewengine;

import com.cyberlink.youcammakeup.utility.bx;
import com.cyberlink.youcammakeup.utility.by;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.viewengine:
//            n, f, a

class g
    implements bx
{

    final f a;
    private n b;

    private g(f f1, n n1)
    {
        a = f1;
        super();
        b = n1;
    }

    g(f f1, n n1, ViewEngine._cls1 _pcls1)
    {
        this(f1, n1);
    }

    public Void a(by by)
    {
        by = b.a();
        if (f.a(a).containsKey(Long.valueOf(b.a)))
        {
            f.a(a).remove(Long.valueOf(b.a));
        }
        if (b.e != null)
        {
            b.e.a(by, n.a(b));
        }
_L2:
        return null;
        Object obj;
        obj;
        boolean flag = false;
        by = ((by) (f.b(a)));
        by;
        JVM INSTR monitorenter ;
        if (!f.a(a).containsKey(Long.valueOf(b.a)))
        {
            break MISSING_BLOCK_LABEL_143;
        }
        flag = true;
        f.a(a).remove(Long.valueOf(b.a));
        by;
        JVM INSTR monitorexit ;
        f.a(a, (new StringBuilder()).append("[ViewEngine.NewTaskMgr][WorkForOriginalBufferTask] Task Error guid:").append(b.a).append(" err Result:").append(((ViewEngine.TaskMgrException) (obj)).getMessage()).toString());
        by = (new StringBuilder("[")).append(obj.getClass().getName()).append("] ").append(((ViewEngine.TaskMgrException) (obj)).getMessage()).toString();
        if (b.e != null)
        {
            if (flag)
            {
                b.e.a(ViewEngine.TaskCancelType.d, by, n.a(b));
            } else
            {
                b.e.a(by, n.a(b));
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        by;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public Object b(by by)
    {
        return a(by);
    }
}
