// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package u.aly:
//            cd

public class ce
{

    public ce()
    {
    }

    public static cd a(Class class1, int i)
    {
        try
        {
            class1 = (cd)class1.getMethod("findByValue", new Class[] {
                Integer.TYPE
            }).invoke(null, new Object[] {
                Integer.valueOf(i)
            });
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
    }
}
