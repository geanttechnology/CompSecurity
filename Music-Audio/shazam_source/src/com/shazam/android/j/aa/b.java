// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.aa;

import com.shazam.model.configuration.ShareTagConfiguration;

public final class b
    implements ShareTagConfiguration
{

    private final com.shazam.android.persistence.n.b a;

    public b(com.shazam.android.persistence.n.b b1)
    {
        a = b1;
    }

    public final boolean a()
    {
        return !a.b("pk_share_tag_dialog_shown");
    }

    public final void b()
    {
        a.b("pk_share_tag_dialog_shown", true);
    }
}
