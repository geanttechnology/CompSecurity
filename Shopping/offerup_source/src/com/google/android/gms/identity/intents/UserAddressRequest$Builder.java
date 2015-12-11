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

    final UserAddressRequest zzaDi;

    public final <init> addAllowedCountrySpecification(CountrySpecification countryspecification)
    {
        if (zzaDi.zzaDh == null)
        {
            zzaDi.zzaDh = new ArrayList();
        }
        zzaDi.zzaDh.add(countryspecification);
        return this;
    }

    public final zzaDi addAllowedCountrySpecifications(Collection collection)
    {
        if (zzaDi.zzaDh == null)
        {
            zzaDi.zzaDh = new ArrayList();
        }
        zzaDi.zzaDh.addAll(collection);
        return this;
    }

    public final UserAddressRequest build()
    {
        if (zzaDi.zzaDh != null)
        {
            zzaDi.zzaDh = Collections.unmodifiableList(zzaDi.zzaDh);
        }
        return zzaDi;
    }

    private (UserAddressRequest useraddressrequest)
    {
        zzaDi = useraddressrequest;
        super();
    }

    zzaDi(UserAddressRequest useraddressrequest, zzaDi zzadi)
    {
        this(useraddressrequest);
    }
}
