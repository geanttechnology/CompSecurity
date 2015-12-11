// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import com.offerup.android.dto.IndexedItemPostPhoto;
import com.offerup.android.dto.ItemPostPhoto;
import com.offerup.android.dto.S3Photo;
import e.c.e;

// Referenced classes of package com.offerup.android.network:
//            n, f

final class l
    implements e
{

    l(f f)
    {
    }

    public final Object a(Object obj, Object obj1)
    {
        obj = (n)obj1;
        obj1 = new ItemPostPhoto(n.a(((n) (obj))).getUuid(), n.b(((n) (obj))).getItemPostPhoto().getImageUri());
        return new IndexedItemPostPhoto(n.b(((n) (obj))).getIndex(), ((ItemPostPhoto) (obj1)));
    }
}
