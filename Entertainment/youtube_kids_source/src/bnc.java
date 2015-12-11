// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public final class bnc
{

    private static final int a;
    private static Random b = new Random();

    static int a()
    {
        return a;
    }

    public static bne a(String s)
    {
label0:
        {
            bne bne1 = null;
            if (a < 18)
            {
                break label0;
            }
            bne bne2 = new bne();
            bne2.a = s;
            bne2.b = b.nextInt();
            s = bne2.a;
            int i = bne2.b;
            bne1 = bne2;
            try
            {
                if (bnd.a == null)
                {
                    break label0;
                }
                bnd.a.invoke(null, new Object[] {
                    Long.valueOf(4096L), s, Integer.valueOf(i)
                });
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return bne2;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return bne2;
            }
            bne1 = bne2;
        }
        return bne1;
    }

    public static void a(bne bne1)
    {
        String s;
        int i;
        if (a < 18)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        s = bne1.a;
        i = bne1.b;
        if (bnd.b != null)
        {
            bnd.b.invoke(null, new Object[] {
                Long.valueOf(4096L), s, Integer.valueOf(i)
            });
        }
        return;
        bne1;
        return;
        bne1;
    }

    static 
    {
        a = android.os.Build.VERSION.SDK_INT;
    }
}
