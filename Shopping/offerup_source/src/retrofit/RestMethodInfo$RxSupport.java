// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package retrofit;

import e.a;
import java.lang.reflect.Type;

// Referenced classes of package retrofit:
//            Types

final class 
{

    public static Type getObservableType(Type type, Class class1)
    {
        return Types.getSupertype(type, class1, e/a);
    }

    public static boolean isObservable(Class class1)
    {
        return class1 == e/a;
    }

    private ()
    {
    }
}
