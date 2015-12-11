// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;

// Referenced classes of package com.j256.ormlite.field.types:
//            CharacterObjectType

public class CharType extends CharacterObjectType
{

    private static final CharType singleTon = new CharType();

    private CharType()
    {
        super(SqlType.CHAR, new Class[] {
            Character.TYPE
        });
    }

    public static CharType getSingleton()
    {
        return singleTon;
    }

    public boolean isPrimitive()
    {
        return true;
    }

    public Object javaToSqlArg(FieldType fieldtype, Object obj)
    {
label0:
        {
            obj = (Character)obj;
            if (obj != null)
            {
                fieldtype = ((FieldType) (obj));
                if (((Character) (obj)).charValue() != 0)
                {
                    break label0;
                }
            }
            fieldtype = null;
        }
        return fieldtype;
    }

}
