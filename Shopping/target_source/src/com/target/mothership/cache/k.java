// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache;

import com.google.b.f;
import com.target.mothership.services.x;
import java.sql.SQLException;

public class k
{
    private static class a
    {

        int errorCode;
        String reason;
        String state;

        private a()
        {
        }

    }


    public k()
    {
    }

    public static x toNetworkError(SQLException sqlexception)
    {
        a a1 = new a();
        a1.errorCode = sqlexception.getErrorCode();
        a1.state = sqlexception.getSQLState();
        a1.reason = sqlexception.getMessage();
        return x.a((new f()).b(a1)).a(sqlexception).a();
    }
}
