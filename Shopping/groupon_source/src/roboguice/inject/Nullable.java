// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.inject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import roboguice.util.Strings;

public final class Nullable
{

    private Nullable()
    {
    }

    public static boolean isNullable(Field field)
    {
        boolean flag1 = false;
        field = field.getAnnotations();
        int j = field.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (!Strings.equals("Nullable", field[i].annotationType().getSimpleName()))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    public static boolean notNullable(Field field)
    {
        return !isNullable(field);
    }
}
