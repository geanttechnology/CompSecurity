// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import android.net.Uri;
import com.shazam.android.advert.c;
import com.shazam.b.a.a;
import com.shazam.model.configuration.InstallationIdRepository;

public final class m
    implements a
{

    private final c a;
    private final InstallationIdRepository b;

    public m(c c1, InstallationIdRepository installationidrepository)
    {
        a = c1;
        b = installationidrepository;
    }

    public final Object a(Object obj)
    {
        obj = (Uri)obj;
        String s = a.c();
        String s1 = b.b();
        return Uri.parse(((Uri) (obj)).toString().replace("D3B5DFB8-E165-387A-A4F6-F2CE1DB1754C", s).replace("641C3824-EA77-3F13-9E1D-7792B6685326", s1));
    }
}
