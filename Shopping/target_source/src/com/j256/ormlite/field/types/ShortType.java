// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

// Referenced classes of package com.j256.ormlite.field.types:
//            ShortObjectType

public class ShortType extends ShortObjectType
{

    private static final ShortType singleTon = new ShortType();

    private ShortType()
    {
        super(SqlType.SHORT, new Class[] {
            Short.TYPE
        });
    }

    protected ShortType(SqlType sqltype, Class aclass[])
    {
        super(sqltype, aclass);
    }

    public static ShortType getSingleton()
    {
        return singleTon;
    }

    public boolean isPrimitive()
    {
        return true;
    }

}
