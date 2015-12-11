// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api.common.io.protocol;


class data
{

    private Object data;
    private int type;

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || !(obj instanceof data))
            {
                return false;
            }
            obj = (data)obj;
            if (type != ((type) (obj)).type || data != ((data) (obj)).data && (data == null || !data.equals(((data) (obj)).data)))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return type;
    }

    public String toString()
    {
        int i = type;
        String s = String.valueOf(data);
        return (new StringBuilder(String.valueOf(s).length() + 33)).append("TypeInfo{type=").append(i).append(", data=").append(s).append("}").toString();
    }



    (int i, Object obj)
    {
        type = i;
        data = obj;
    }
}
