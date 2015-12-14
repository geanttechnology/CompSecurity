// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.sender;


// Referenced classes of package org.acra.sender:
//            HttpSender

public static abstract class <init> extends Enum
{

    private static final JSON $VALUES[];
    public static final JSON FORM;
    public static final JSON JSON;

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(org/acra/sender/HttpSender$Type, s);
    }

    public static <init>[] values()
    {
        return (<init>[])$VALUES.clone();
    }

    public abstract String getContentType();

    static 
    {
        FORM = new HttpSender.Type("FORM", 0) {

            public String getContentType()
            {
                return "application/x-www-form-urlencoded";
            }

        };
        JSON = new HttpSender.Type("JSON", 1) {

            public String getContentType()
            {
                return "application/json";
            }

        };
        $VALUES = (new .VALUES[] {
            FORM, JSON
        });
    }

    private _cls2(String s, int i)
    {
        super(s, i);
    }

    _cls2(String s, int i, _cls2 _pcls2)
    {
        this(s, i);
    }
}
