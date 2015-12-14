// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.weibo.other.tencent.beans;

import java.io.Serializable;

public class QParameter
    implements Serializable, Comparable
{

    private static final long serialVersionUID = 0x8285588f3b7c20d3L;
    private String name;
    private String value;

    public QParameter(String s, String s1)
    {
        name = s;
        value = s1;
    }

    public int compareTo(QParameter qparameter)
    {
        int j = name.compareTo(qparameter.getName());
        int i = j;
        if (j == 0)
        {
            i = value.compareTo(qparameter.getValue());
        }
        return i;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((QParameter)obj);
    }

    public String getName()
    {
        return name;
    }

    public String getValue()
    {
        return value;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setValue(String s)
    {
        value = s;
    }
}
