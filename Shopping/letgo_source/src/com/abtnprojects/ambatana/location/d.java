// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.location;

import android.content.Context;
import android.location.Geocoder;
import com.abtnprojects.ambatana.datasource.entities.mapper.AddressMapper;

// Referenced classes of package com.abtnprojects.ambatana.location:
//            b, a, c

public class d
{

    public static c a(Context context, AddressMapper addressmapper, boolean flag)
    {
        if (flag)
        {
            return new b(new Geocoder(context), addressmapper);
        } else
        {
            return new a(addressmapper);
        }
    }
}
