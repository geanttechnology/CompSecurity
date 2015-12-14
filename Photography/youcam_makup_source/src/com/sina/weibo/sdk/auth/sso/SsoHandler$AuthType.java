// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.auth.sso;


final class  extends Enum
{

    public static final WebOnly ALL;
    private static final WebOnly ENUM$VALUES[];
    public static final WebOnly SsoOnly;
    public static final WebOnly WebOnly;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/sina/weibo/sdk/auth/sso/SsoHandler$AuthType, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        ALL = new <init>("ALL", 0);
        SsoOnly = new <init>("SsoOnly", 1);
        WebOnly = new <init>("WebOnly", 2);
        ENUM$VALUES = (new ENUM.VALUES[] {
            ALL, SsoOnly, WebOnly
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
