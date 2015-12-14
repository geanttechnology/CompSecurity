// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.vo;


public class ToolActionVO
{

    String contentIdentifier;
    String packIdentifier;
    Object value;

    public ToolActionVO()
    {
    }

    public ToolActionVO(Object obj)
    {
        value = obj;
    }

    public String getContentIdentifier()
    {
        return contentIdentifier;
    }

    public String getPackIdentifier()
    {
        return packIdentifier;
    }

    public Object getValue()
    {
        return value;
    }

    public void setContentIdentifier(String s)
    {
        contentIdentifier = s;
    }

    public void setPackIdentifier(String s)
    {
        packIdentifier = s;
    }

    public void setValue(Object obj)
    {
        value = obj;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("ToolActionVO{");
        if (value != null)
        {
            stringbuilder.append((new StringBuilder()).append("value:").append(value).toString());
        }
        if (packIdentifier != null)
        {
            if (value != null)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append((new StringBuilder()).append("pack:").append(packIdentifier).toString());
            stringbuilder.append((new StringBuilder()).append(", content:").append(contentIdentifier).toString());
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }
}
