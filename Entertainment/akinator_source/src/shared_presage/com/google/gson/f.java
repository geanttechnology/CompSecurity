// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson;

import java.lang.reflect.Field;

// Referenced classes of package shared_presage.com.google.gson:
//            FieldNamingPolicy

final class f extends FieldNamingPolicy
{

    f(String s)
    {
        super(s, 4, null);
    }

    public final String translateName(Field field)
    {
        return FieldNamingPolicy.access$200(field.getName(), "-").toLowerCase();
    }
}
