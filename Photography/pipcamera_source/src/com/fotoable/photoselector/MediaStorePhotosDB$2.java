// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector;

import java.util.ArrayList;
import java.util.Comparator;
import nu;

// Referenced classes of package com.fotoable.photoselector:
//            MediaStorePhotosDB

class a
    implements Comparator
{

    final MediaStorePhotosDB a;

    public int a(nu nu1, nu nu2)
    {
        if (nu1.i().size() < nu2.i().size())
        {
            return 1;
        }
        return nu1.i().size() <= nu2.i().size() ? 0 : -1;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((nu)obj, (nu)obj1);
    }

    (MediaStorePhotosDB mediastorephotosdb)
    {
        a = mediastorephotosdb;
        super();
    }
}
