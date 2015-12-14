// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import com.fotoable.photoselector.MediaStorePhotosDB;
import java.util.Comparator;

public class ard
    implements Comparator
{

    final MediaStorePhotosDB a;

    public ard(MediaStorePhotosDB mediastorephotosdb)
    {
        a = mediastorephotosdb;
        super();
    }

    public int a(aqz aqz1, aqz aqz2)
    {
        return aqz1.d().toString().compareTo(aqz2.d().toString());
    }

    public int compare(Object obj, Object obj1)
    {
        return a((aqz)obj, (aqz)obj1);
    }
}
