// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.identity.intents;

import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.identity.intents:
//            UserAddressRequest

public final class <init>
{

    final UserAddressRequest zzaAA;

    public <init> addAllowedCountrySpecification(CountrySpecification countryspecification)
    {
        if (zzaAA.zzaAz == null)
        {
            zzaAA.zzaAz = new ArrayList();
        }
        zzaAA.zzaAz.add(countryspecification);
        return this;
    }

    public zzaAA addAllowedCountrySpecifications(Collection collection)
    {
        if (zzaAA.zzaAz == null)
        {
            zzaAA.zzaAz = new ArrayList();
        }
        zzaAA.zzaAz.addAll(collection);
        return this;
    }

    public UserAddressRequest build()
    {
        if (zzaAA.zzaAz != null)
        {
            zzaAA.zzaAz = Collections.unmodifiableList(zzaAA.zzaAz);
        }
        return zzaAA;
    }

    private (UserAddressRequest useraddressrequest)
    {
        zzaAA = useraddressrequest;
        super();
    }

    zzaAA(UserAddressRequest useraddressrequest, zzaAA zzaaa)
    {
        this(useraddressrequest);
    }
}
