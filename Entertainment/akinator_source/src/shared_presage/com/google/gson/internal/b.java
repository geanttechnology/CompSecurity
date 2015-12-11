// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal;

import java.util.LinkedHashMap;

// Referenced classes of package shared_presage.com.google.gson.internal:
//            ObjectConstructor, ConstructorConstructor

final class b
    implements ObjectConstructor
{

    final ConstructorConstructor a;

    b(ConstructorConstructor constructorconstructor)
    {
        a = constructorconstructor;
        super();
    }

    public final Object construct()
    {
        return new LinkedHashMap();
    }
}
