// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector;

import java.util.Comparator;
import java.util.Date;
import nr;

// Referenced classes of package com.fotoable.photoselector:
//            MediaStorePhotosDB

class a
    implements Comparator
{

    final MediaStorePhotosDB a;

    public int a(nr nr1, nr nr2)
    {
        return nr1.k().compareTo(nr2.k());
    }

    public int compare(Object obj, Object obj1)
    {
        return a((nr)obj, (nr)obj1);
    }

    (MediaStorePhotosDB mediastorephotosdb)
    {
        a = mediastorephotosdb;
        super();
    }
}
