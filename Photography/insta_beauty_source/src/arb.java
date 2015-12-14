// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.photoselector.MediaStorePhotosDB;
import java.util.ArrayList;
import java.util.Comparator;

public class arb
    implements Comparator
{

    final MediaStorePhotosDB a;

    public arb(MediaStorePhotosDB mediastorephotosdb)
    {
        a = mediastorephotosdb;
        super();
    }

    public int a(ata ata1, ata ata2)
    {
        if (ata1.i().size() < ata2.i().size())
        {
            return 1;
        }
        return ata1.i().size() <= ata2.i().size() ? 0 : -1;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((ata)obj, (ata)obj1);
    }
}
