// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

// Referenced classes of package com.j256.ormlite.field.types:
//            StringType

public class LongStringType extends StringType
{

    private static final LongStringType singleTon = new LongStringType();

    private LongStringType()
    {
        super(SqlType.LONG_STRING, new Class[0]);
    }

    public static LongStringType getSingleton()
    {
        return singleTon;
    }

    public int getDefaultWidth()
    {
        return 0;
    }

    public boolean isAppropriateId()
    {
        return false;
    }

}
