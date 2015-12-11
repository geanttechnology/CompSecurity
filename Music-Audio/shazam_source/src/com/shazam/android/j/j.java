// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j;

import com.shazam.model.configuration.InstallationIdRepository;

// Referenced classes of package com.shazam.android.j:
//            o

public final class j
    implements o
{

    private final InstallationIdRepository a;

    public j(InstallationIdRepository installationidrepository)
    {
        a = installationidrepository;
    }

    public final String a(String s)
    {
        boolean flag;
        if (s == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return null;
        }
        String s1;
        if (a.a())
        {
            s1 = a.b();
        } else
        {
            s1 = "00000000-0000-0000-0000-000000000000";
        }
        return s.replace("{inid}", s1);
    }
}
