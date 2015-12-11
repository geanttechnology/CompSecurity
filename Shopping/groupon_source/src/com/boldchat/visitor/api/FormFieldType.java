// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;


public final class FormFieldType extends Enum
{

    private static final FormFieldType $VALUES[];
    public static final FormFieldType Email;
    public static final FormFieldType Phone;
    public static final FormFieldType Radio;
    public static final FormFieldType Rating;
    public static final FormFieldType Select;
    public static final FormFieldType Text;

    private FormFieldType(String s, int i)
    {
        super(s, i);
    }

    public static FormFieldType getFormFieldType(String s)
    {
        FormFieldType aformfieldtype[] = values();
        int j = aformfieldtype.length;
        for (int i = 0; i < j; i++)
        {
            FormFieldType formfieldtype = aformfieldtype[i];
            if (s.equals(formfieldtype.name().toLowerCase()))
            {
                return formfieldtype;
            }
        }

        return Text;
    }

    public static FormFieldType valueOf(String s)
    {
        return (FormFieldType)Enum.valueOf(com/boldchat/visitor/api/FormFieldType, s);
    }

    public static FormFieldType[] values()
    {
        return (FormFieldType[])$VALUES.clone();
    }

    static 
    {
        Text = new FormFieldType("Text", 0);
        Select = new FormFieldType("Select", 1);
        Radio = new FormFieldType("Radio", 2);
        Rating = new FormFieldType("Rating", 3);
        Phone = new FormFieldType("Phone", 4);
        Email = new FormFieldType("Email", 5);
        $VALUES = (new FormFieldType[] {
            Text, Select, Radio, Rating, Phone, Email
        });
    }
}
