// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

// Referenced classes of package com.j256.ormlite.field.types:
//            DoubleObjectType

public class DoubleType extends DoubleObjectType
{

    private static final DoubleType singleTon = new DoubleType();

    private DoubleType()
    {
        super(SqlType.DOUBLE, new Class[] {
            Double.TYPE
        });
    }

    public static DoubleType getSingleton()
    {
        return singleTon;
    }

    public boolean isPrimitive()
    {
        return true;
    }

}
