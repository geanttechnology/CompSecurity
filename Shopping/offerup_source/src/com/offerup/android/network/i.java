// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import com.offerup.android.dto.IndexedItemPostPhoto;
import com.offerup.android.dto.ItemPostPhoto;
import e.c.d;

// Referenced classes of package com.offerup.android.network:
//            f

final class i
    implements d
{

    i(f f)
    {
    }

    public final Object a(Object obj)
    {
        obj = (IndexedItemPostPhoto)obj;
        boolean flag;
        if (obj != null && ((IndexedItemPostPhoto) (obj)).getItemPostPhoto().requiresUpload())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }
}
