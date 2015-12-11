// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.client;


public final class SecurityTokenType extends Enum
{

    private static final SecurityTokenType $VALUES[];
    public static final SecurityTokenType ACCT;
    public static final SecurityTokenType META;
    public static final SecurityTokenType XACT;
    public static final SecurityTokenType XSCT;

    private SecurityTokenType(String s, int i)
    {
        super(s, i);
    }

    public static SecurityTokenType valueOf(String s)
    {
        return (SecurityTokenType)Enum.valueOf(com/comcast/playerplatform/drm/java/client/SecurityTokenType, s);
    }

    public static SecurityTokenType[] values()
    {
        return (SecurityTokenType[])$VALUES.clone();
    }

    static 
    {
        ACCT = new SecurityTokenType("ACCT", 0);
        XSCT = new SecurityTokenType("XSCT", 1);
        XACT = new SecurityTokenType("XACT", 2);
        META = new SecurityTokenType("META", 3);
        $VALUES = (new SecurityTokenType[] {
            ACCT, XSCT, XACT, META
        });
    }
}
