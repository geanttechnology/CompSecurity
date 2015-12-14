// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cn;

import com.socialin.android.d;

// Referenced classes of package myobfuscated.cn:
//            c

public class b extends Thread
{

    private static final String c = myobfuscated/cn/b.getSimpleName();
    public float a;
    public boolean b;
    private c d;

    public b(c c1)
    {
        b = true;
        a = 0.0F;
        d = c1;
    }

    public void run()
    {
        while (b) 
        {
            a = a + 2.0F;
            if (d != null)
            {
                d.h();
            }
            try
            {
                Thread.sleep(50L);
            }
            catch (InterruptedException interruptedexception)
            {
                com.socialin.android.d.b(c, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(interruptedexception.getMessage()).toString()
                });
            }
        }
    }

}
