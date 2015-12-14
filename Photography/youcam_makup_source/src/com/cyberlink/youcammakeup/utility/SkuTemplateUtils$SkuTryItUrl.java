// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import java.io.Serializable;

public class patternGuid
    implements Serializable
{

    public static final patternGuid a = new <init>(null, null, null, null);
    private static final long serialVersionUID = 0x5ab3206d8b562639L;
    public final String itemGuid;
    public final String patternGuid;
    public final String skuGuid;
    public final String type;


    public (String s, String s1, String s2, String s3)
    {
        type = s;
        skuGuid = s1;
        itemGuid = s2;
        patternGuid = s3;
    }
}
