// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity;

import org.springframework.http.HttpStatus;

public final class f extends Enum
{

    public static final f a;
    private static f c;
    private static f d;
    private static f e;
    private static f f;
    private static f g;
    private static f h;
    private static final f i[];
    public final int b;

    private f(String s, int j, int k)
    {
        super(s, j);
        b = k;
    }

    public static f valueOf(String s)
    {
        return (f)Enum.valueOf(com/gimbal/internal/proximity/f, s);
    }

    public static f[] values()
    {
        return (f[])i.clone();
    }

    static 
    {
        a = new f("PROXIMITY_UNKNOWN_TYPE", 0, 0);
        HttpStatus httpstatus = HttpStatus.NOT_FOUND;
        c = new f("PROXIMITY_TOKEN_DOESNOT_EXIST", 1, 4000);
        httpstatus = HttpStatus.UNPROCESSABLE_ENTITY;
        d = new f("PROXIMITY_UNPROCESSABLE_ENTITY", 2, 4002);
        httpstatus = HttpStatus.UNAUTHORIZED;
        e = new f("PROXIMITY_UNAUTHORIZED", 3, 4003);
        httpstatus = HttpStatus.BAD_REQUEST;
        f = new f("PROXIMITY_BAD_PARAMS", 4, 6001);
        httpstatus = HttpStatus.UNAUTHORIZED;
        g = new f("PROXIMITY_UNKNOWN_AUTH_FAILURE", 5, 2000);
        httpstatus = HttpStatus.UNAUTHORIZED;
        h = new f("PROXIMITY_INVALID_GRANT_AUTH_FAILURE", 6, 2004);
        i = (new f[] {
            a, c, d, e, f, g, h
        });
    }
}
