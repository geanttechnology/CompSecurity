// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

// Referenced classes of package com.google.common.reflect:
//            TypeVisitor, TypeToken, Types

class <init> extends TypeVisitor
{

    final TypeToken this$0;
    final com.google.common.collect..Builder val$builder;

    void visitClass(Class class1)
    {
        val$builder.add(class1);
    }

    void visitGenericArrayType(GenericArrayType genericarraytype)
    {
        val$builder.add(Types.getArrayClass(TypeToken.of(genericarraytype.getGenericComponentType()).getRawType()));
    }

    void visitParameterizedType(ParameterizedType parameterizedtype)
    {
        val$builder.add((Class)parameterizedtype.getRawType());
    }

    void visitTypeVariable(TypeVariable typevariable)
    {
        visit(typevariable.getBounds());
    }

    void visitWildcardType(WildcardType wildcardtype)
    {
        visit(wildcardtype.getUpperBounds());
    }

    .Builder()
    {
        this$0 = final_typetoken;
        val$builder = com.google.common.collect..Builder.this;
        super();
    }
}
