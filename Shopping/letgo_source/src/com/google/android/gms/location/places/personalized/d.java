// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.personalized;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.location.places.m;

// Referenced classes of package com.google.android.gms.location.places.personalized:
//            PlaceUserData

public final class d extends f
    implements g
{

    private final Status b;

    public d(DataHolder dataholder)
    {
        this(dataholder, m.c(dataholder.e()));
    }

    private d(DataHolder dataholder, Status status)
    {
        super(dataholder, PlaceUserData.CREATOR);
        boolean flag;
        if (dataholder == null || dataholder.e() == status.g())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        x.b(flag);
        b = status;
    }

    public Status a()
    {
        return b;
    }
}
