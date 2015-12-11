// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;


public class DataServiceConnectivityException extends Exception
{

    private static final long serialVersionUID = 1L;
    public String m_message;

    public DataServiceConnectivityException(String s)
    {
        m_message = s;
    }
}
