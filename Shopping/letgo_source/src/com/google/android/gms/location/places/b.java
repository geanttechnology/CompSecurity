// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.a;
import com.google.android.gms.common.internal.w;

// Referenced classes of package com.google.android.gms.location.places:
//            m, a

public class b extends a
    implements g
{

    public b(DataHolder dataholder)
    {
        super(dataholder);
    }

    public Status a()
    {
        return m.c(a.e());
    }

    public Object a(int i)
    {
        return b(i);
    }

    public com.google.android.gms.location.places.a b(int i)
    {
        return new com.google.android.gms.location.places.internal.a(a, i);
    }

    public String toString()
    {
        return w.a(this).a("status", a()).toString();
    }
}
