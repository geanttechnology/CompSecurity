// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector;

import android.net.Uri;
import java.util.Comparator;
import mu;

// Referenced classes of package com.fotoable.photoselector:
//            MediaStorePhotosDB

class a
    implements Comparator
{

    final MediaStorePhotosDB a;

    public int a(mu mu1, mu mu2)
    {
        return mu1.d().toString().compareTo(mu2.d().toString());
    }

    public int compare(Object obj, Object obj1)
    {
        return a((mu)obj, (mu)obj1);
    }

    (MediaStorePhotosDB mediastorephotosdb)
    {
        a = mediastorephotosdb;
        super();
    }
}
