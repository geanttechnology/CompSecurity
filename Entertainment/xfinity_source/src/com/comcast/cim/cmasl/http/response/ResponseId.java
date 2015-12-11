// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.response;


public class ResponseId
{

    private final String lastModified;

    public ResponseId(String s)
    {
        lastModified = s;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        } else
        {
            obj = (ResponseId)obj;
            return lastModified.equals(((ResponseId) (obj)).lastModified);
        }
    }

    public int hashCode()
    {
        return lastModified.hashCode();
    }

    public String toString()
    {
        return (new StringBuilder()).append("lastModified:").append(lastModified).toString();
    }
}
