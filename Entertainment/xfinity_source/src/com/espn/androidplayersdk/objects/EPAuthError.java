// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.objects;

import java.io.Serializable;

public class EPAuthError
    implements Serializable
{

    private static final long serialVersionUID = 0xdda6ad68925ad01aL;
    String abbrevation;
    int code;
    String message;
    String timeStamp;
    String type;

    public EPAuthError(String s, String s1, String s2, String s3, int i)
    {
        timeStamp = s;
        message = s1;
        abbrevation = s2;
        type = s3;
        code = i;
    }

    public String getAbbrevation()
    {
        return abbrevation;
    }

    public String getMessage()
    {
        return message;
    }

    public String getTimeStamp()
    {
        return timeStamp;
    }

    public String getType()
    {
        return type;
    }

    public int geterrorCode()
    {
        return code;
    }
}
