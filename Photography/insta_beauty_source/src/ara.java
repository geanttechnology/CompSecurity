// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.photoselector.MediaStorePhotosDB;
import java.util.Comparator;
import java.util.Date;

public class ara
    implements Comparator
{

    final MediaStorePhotosDB a;

    public ara(MediaStorePhotosDB mediastorephotosdb)
    {
        a = mediastorephotosdb;
        super();
    }

    public int a(asx asx1, asx asx2)
    {
        return asx1.k().compareTo(asx2.k());
    }

    public int compare(Object obj, Object obj1)
    {
        return a((asx)obj, (asx)obj1);
    }
}
