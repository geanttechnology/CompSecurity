// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.photoselector.MediaStorePhotosDB;
import java.util.Comparator;

public class arc
    implements Comparator
{

    final MediaStorePhotosDB a;

    public arc(MediaStorePhotosDB mediastorephotosdb)
    {
        a = mediastorephotosdb;
        super();
    }

    public int a(asx asx1, asx asx2)
    {
        int i = asx1.j().compareTo(asx2.j());
        if (i != 0);
        return i;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((asx)obj, (asx)obj1);
    }
}
