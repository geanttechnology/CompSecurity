// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import com.offerup.android.dto.IndexedItemPostPhoto;
import com.offerup.android.dto.ItemPostPhoto;
import e.c.e;

// Referenced classes of package com.offerup.android.network:
//            f

final class j
    implements e
{

    j(f f)
    {
    }

    public final Object a(Object obj, Object obj1)
    {
        obj = (Integer)obj;
        obj1 = (ItemPostPhoto)obj1;
        return new IndexedItemPostPhoto(((Integer) (obj)).intValue(), ((ItemPostPhoto) (obj1)));
    }
}
