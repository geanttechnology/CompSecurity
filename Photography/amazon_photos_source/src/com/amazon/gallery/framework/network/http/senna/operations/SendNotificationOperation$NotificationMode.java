// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.senna.operations;


// Referenced classes of package com.amazon.gallery.framework.network.http.senna.operations:
//            SendNotificationOperation

public static final class value extends Enum
{

    private static final SMS $VALUES[];
    public static final SMS EMAIL;
    public static final SMS SMS;
    private final String value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/amazon/gallery/framework/network/http/senna/operations/SendNotificationOperation$NotificationMode, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    public String toString()
    {
        return value;
    }

    static 
    {
        EMAIL = new <init>("EMAIL", 0, "email");
        SMS = new <init>("SMS", 1, "sms");
        $VALUES = (new .VALUES[] {
            EMAIL, SMS
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }
}
