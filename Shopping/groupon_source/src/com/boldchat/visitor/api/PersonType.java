// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;


public final class PersonType extends Enum
{

    private static final PersonType $VALUES[];
    public static final PersonType Operator;
    public static final PersonType System;
    public static final PersonType Visitor;

    private PersonType(String s, int i)
    {
        super(s, i);
    }

    public static PersonType getPersonType(String s)
    {
        PersonType apersontype[] = values();
        int j = apersontype.length;
        for (int i = 0; i < j; i++)
        {
            PersonType persontype = apersontype[i];
            if (s.equals(persontype.name().toLowerCase()))
            {
                return persontype;
            }
        }

        return Operator;
    }

    public static PersonType valueOf(String s)
    {
        return (PersonType)Enum.valueOf(com/boldchat/visitor/api/PersonType, s);
    }

    public static PersonType[] values()
    {
        return (PersonType[])$VALUES.clone();
    }

    static 
    {
        Operator = new PersonType("Operator", 0);
        Visitor = new PersonType("Visitor", 1);
        System = new PersonType("System", 2);
        $VALUES = (new PersonType[] {
            Operator, Visitor, System
        });
    }
}
