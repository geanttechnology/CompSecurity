// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.d;

import android.content.Intent;

// Referenced classes of package com.mopub.d:
//            s, i

public final class a extends s
{

    private Intent a;

    public a()
    {
    }

    public a(i i)
    {
        super(i);
    }

    public final String getMessage()
    {
        if (a != null)
        {
            return "User needs to (re)enter credentials.";
        } else
        {
            return super.getMessage();
        }
    }
}
