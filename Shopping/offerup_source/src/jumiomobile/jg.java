// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.Rect;
import com.jumio.netverify.sdk.environment.RecognizerWrapper;
import java.util.Arrays;

// Referenced classes of package jumiomobile:
//            je, ao, l, n, 
//            hw, q, oo, ab

class jg extends Thread
{

    final je a;
    private byte b[];

    public jg(je je1, byte abyte0[])
    {
        a = je1;
        super();
        b = Arrays.copyOf(abyte0, abyte0.length);
    }

    public void run()
    {
        String s;
        int i;
        int j;
        boolean flag1 = false;
        boolean flag2 = a.c.f();
        boolean flag;
        if (flag2)
        {
            i = a.b.c.b;
            j = a.b.c.a;
        } else
        {
            i = a.b.c.a;
            j = a.b.c.b;
        }
        a.b(b, i, j, false);
        je.a(a, null);
        s = je.a(a).recognize(b, i, j, i);
        flag = flag1;
        if (s != null)
        {
            flag = flag1;
            if (s.length() != 0)
            {
                flag = flag1;
                if (!s.startsWith("Result error:"))
                {
                    flag = true;
                }
            }
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        if (je.b(a) != null && je.c(a) != 0 && je.d(a) != 0)
        {
            hw hw1 = new hw(je.b(a), je.c(a), je.d(a));
            obj = je.a(a, b, hw1.a(), 5);
            if (flag2)
            {
                i = hw1.a().width();
            } else
            {
                i = hw1.a().height();
            }
            if (flag2)
            {
                j = hw1.a().height();
            } else
            {
                j = hw1.a().width();
            }
        } else
        {
            obj = q.a(b, a.c.f(), a.b);
        }
        flag = a.a(s, b, ((android.graphics.Bitmap) (obj)), i, j);
_L4:
        synchronized (a)
        {
            b = null;
            je.a(a, flag);
        }
        return;
_L2:
        if (oo.a())
        {
            ab.c("Photopay", s);
        }
        if (true) goto _L4; else goto _L3
_L3:
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
