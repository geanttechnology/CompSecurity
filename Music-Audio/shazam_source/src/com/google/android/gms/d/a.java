// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Intent;

// Referenced classes of package com.google.android.gms.d:
//            kq, gs

public final class a extends kq
{

    private Intent c;

    public a()
    {
    }

    public a(gs gs)
    {
        super(gs);
    }

    public final String getMessage()
    {
        if (c != null)
        {
            return "User needs to (re)enter credentials.";
        } else
        {
            return super.getMessage();
        }
    }
}
