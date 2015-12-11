// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ab;

import android.content.Context;
import android.content.res.Resources;
import com.shazam.android.j.g.d;
import com.shazam.android.j.g.f;
import com.shazam.android.j.o.a;
import com.shazam.model.configuration.InstallationIdRepository;

public final class b
{

    public final a a;
    public final d b;
    public final f c;
    public final InstallationIdRepository d;
    public final com.shazam.android.persistence.n.b e;
    public final Resources f;

    public b(Context context, a a1, d d1, f f1, InstallationIdRepository installationidrepository, com.shazam.android.persistence.n.b b1)
    {
        a = a1;
        b = d1;
        c = f1;
        d = installationidrepository;
        e = b1;
        f = context.getResources();
    }
}
