// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

// Referenced classes of package com.google.android.gms.location.places:
//            PlaceFilter

public static final class <init>
{

    private boolean zzaGl;
    private Collection zzaGm;
    private Collection zzaGn;
    private String zzaGo[];

    public PlaceFilter zzwU()
    {
        java.util.List list = null;
        ArrayList arraylist;
        ArrayList arraylist1;
        if (zzaGm != null)
        {
            arraylist = new ArrayList(zzaGm);
        } else
        {
            arraylist = null;
        }
        if (zzaGn != null)
        {
            arraylist1 = new ArrayList(zzaGn);
        } else
        {
            arraylist1 = null;
        }
        if (zzaGo != null)
        {
            list = Arrays.asList(zzaGo);
        }
        return new PlaceFilter(arraylist, zzaGl, list, arraylist1);
    }

    private ()
    {
        zzaGm = null;
        zzaGl = false;
        zzaGn = null;
        zzaGo = null;
    }

    zzaGo(zzaGo zzago)
    {
        this();
    }
}
