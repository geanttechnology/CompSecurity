// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.request;


public class TokenRequestData
{

    private String accountToken;
    private String messageId;
    private String messageNonce;
    private String messageType;
    private String product;

    public TokenRequestData(String s, String s1, String s2, String s3, String s4)
    {
        messageId = s;
        messageType = s1;
        messageNonce = s2;
        product = s3;
        accountToken = s4;
    }
}
