// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.c;

import com.sessionm.net.Request;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.sessionm.c:
//            c

public class a
    implements c
{

    private static final int gL = 20;
    private int gM;
    private final List gN = new ArrayList();

    public a()
    {
        gM = 20;
    }

    public long bC()
    {
        return -1L;
    }

    public void close()
    {
    }

    public long getSize()
    {
        this;
        JVM INSTR monitorenter ;
        int i = gN.size();
        long l1 = i;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean k(Request request)
    {
        if (gN.size() > gM)
        {
            return false;
        } else
        {
            request.c(this);
            gN.add(request);
            return true;
        }
    }

    public boolean l(Request request)
    {
        boolean flag1;
        if (request.aZ() > 1)
        {
            request = request.aY().iterator();
            boolean flag = true;
            do
            {
                flag1 = flag;
                if (!request.hasNext())
                {
                    break;
                }
                Request request1 = (Request)request.next();
                flag1 = gN.remove(request1);
                if (!flag1 && flag)
                {
                    flag = flag1;
                }
            } while (true);
        } else
        {
            flag1 = gN.remove(request);
        }
        return flag1;
    }

    public boolean removeAll()
    {
        this;
        JVM INSTR monitorenter ;
        gN.clear();
        this;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        throw exception;
    }

    public List s(int i)
    {
        this;
        JVM INSTR monitorenter ;
        int j = i;
        Object obj;
        if (i > gN.size())
        {
            j = gN.size();
        }
        obj = gN.subList(0, j);
        Iterator iterator = ((List) (obj)).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Request request = (Request)iterator.next();
            if (request.ba() == com.sessionm.net.Request.State.fh)
            {
                request.reset();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_93;
        obj;
        throw obj;
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj));
    }

    public void t(int i)
    {
        gM = i;
    }
}
