// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

// Referenced classes of package com.j256.ormlite.field.types:
//            IntegerObjectType

public class IntType extends IntegerObjectType
{

    private static final IntType singleTon = new IntType();

    private IntType()
    {
        super(SqlType.INTEGER, new Class[] {
            Integer.TYPE
        });
    }

    public static IntType getSingleton()
    {
        return singleTon;
    }

    public boolean isPrimitive()
    {
        return true;
    }

}
