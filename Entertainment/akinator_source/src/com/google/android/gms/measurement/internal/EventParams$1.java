// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            EventParams

class zzaMj
    implements Iterator
{

    Iterator zzaMi;
    final EventParams zzaMj;

    public boolean hasNext()
    {
        return zzaMi.hasNext();
    }

    public volatile Object next()
    {
        return next();
    }

    public String next()
    {
        return (String)zzaMi.next();
    }

    public void remove()
    {
        throw new UnsupportedOperationException("Remove not supported");
    }

    (EventParams eventparams)
    {
        zzaMj = eventparams;
        super();
        zzaMi = EventParams.zza(zzaMj).keySet().iterator();
    }
}
