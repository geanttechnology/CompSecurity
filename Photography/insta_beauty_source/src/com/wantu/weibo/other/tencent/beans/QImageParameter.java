// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.weibo.other.tencent.beans;

import java.io.Serializable;

public class QImageParameter
    implements Serializable, Comparable
{

    private static final long serialVersionUID = 0x8285588f3b7c20d3L;
    private String name;
    private byte value[];

    public QImageParameter(String s, byte abyte0[])
    {
        name = s;
        value = abyte0;
    }

    public int compareTo(QImageParameter qimageparameter)
    {
        return name.compareTo(qimageparameter.getName());
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((QImageParameter)obj);
    }

    public String getName()
    {
        return name;
    }

    public byte[] getValue()
    {
        return value;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setValue(byte abyte0[])
    {
        value = abyte0;
    }
}
