// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import android.content.Intent;

// Referenced classes of package com.a.a:
//            t, j

public class a extends t
{

    private Intent b;

    public a()
    {
    }

    public a(j j)
    {
        super(j);
    }

    public String getMessage()
    {
        if (b != null)
        {
            return "User needs to (re)enter credentials.";
        } else
        {
            return super.getMessage();
        }
    }
}
