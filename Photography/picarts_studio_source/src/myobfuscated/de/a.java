// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.de;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

// Referenced classes of package myobfuscated.de:
//            b

public final class a
{

    private static Method a = null;

    public static void a(android.hardware.Camera.Parameters parameters)
    {
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        List list;
        int i;
        try
        {
            list = (List)a.invoke(parameters, null);
        }
        // Misplaced declaration of an exception variable
        catch (android.hardware.Camera.Parameters parameters)
        {
            parameters.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (android.hardware.Camera.Parameters parameters)
        {
            parameters.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (android.hardware.Camera.Parameters parameters)
        {
            parameters.printStackTrace();
            return;
        }
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        i = b.a(list);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        parameters.setPreviewFormat(i);
_L1:
        return;
        if (parameters.getPreviewFormat() != 17)
        {
            parameters.setPreviewFormat(17);
            return;
        }
          goto _L1
    }

    static 
    {
        try
        {
            android/hardware/Camera$Parameters.getMethod("getSupportedPreviewSizes", null);
        }
        catch (NoSuchMethodException nosuchmethodexception1) { }
        try
        {
            a = android/hardware/Camera$Parameters.getMethod("getSupportedPreviewFormats", null);
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            return;
        }
    }
}
