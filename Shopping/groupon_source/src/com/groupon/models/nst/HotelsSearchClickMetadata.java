// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


public class HotelsSearchClickMetadata
{

    private String checkin;
    private String checkout;
    private String dealtype;
    private String location;
    private String search_type;

    public HotelsSearchClickMetadata(String s, String s1, String s2, String s3, String s4)
    {
        checkin = s;
        checkout = s1;
        location = s2;
        dealtype = s3;
        search_type = s4;
    }
}
