// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.type;

import com.flurry.org.codehaus.jackson.type.JavaType;
import java.lang.reflect.Type;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.type:
//            TypeBindings, TypeFactory

public abstract class TypeModifier
{

    public TypeModifier()
    {
    }

    public abstract JavaType modifyType(JavaType javatype, Type type, TypeBindings typebindings, TypeFactory typefactory);
}
