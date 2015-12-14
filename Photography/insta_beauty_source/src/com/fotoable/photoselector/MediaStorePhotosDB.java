// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector;

import android.util.Log;
import aqz;
import ara;
import arb;
import arc;
import ard;
import asq;
import asx;
import asy;
import asz;
import ata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class MediaStorePhotosDB extends asq
{

    private static MediaStorePhotosDB k;
    Comparator a;
    Comparator b;
    Comparator c;
    Comparator d;
    private ArrayList e;
    private ArrayList f;
    private ArrayList g;
    private HashMap h;
    private ArrayList i;
    private HashMap j;

    private MediaStorePhotosDB()
    {
        e = new ArrayList(50);
        f = new ArrayList(50);
        a = new ara(this);
        b = new arb(this);
        c = new arc(this);
        d = new ard(this);
        g = new ArrayList(5);
        h = new HashMap(5);
        i = new ArrayList(5);
        j = new HashMap(5);
    }

    public static MediaStorePhotosDB a()
    {
        com/fotoable/photoselector/MediaStorePhotosDB;
        JVM INSTR monitorenter ;
        if (k == null && k == null)
        {
            k = new MediaStorePhotosDB();
        }
        com/fotoable/photoselector/MediaStorePhotosDB;
        JVM INSTR monitorexit ;
        Exception exception;
        try
        {
            System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        }
        catch (Exception exception1) { }
        return k;
        exception;
        com/fotoable/photoselector/MediaStorePhotosDB;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void a(String s, asy asy1)
    {
        this;
        JVM INSTR monitorenter ;
        h.put(s, asy1);
        g.add(asy1);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    private void a(String s, ata ata1)
    {
        this;
        JVM INSTR monitorenter ;
        j.put(s, ata1);
        i.add(ata1);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public ArrayList a(MediaSortMode mediasortmode)
    {
        ArrayList arraylist = new ArrayList(50);
        for (int l = 0; l < i.size(); l++)
        {
            ArrayList arraylist1 = ((asz)i.get(l)).i();
            for (int i1 = 0; i1 < arraylist1.size(); i1++)
            {
                arraylist.add(arraylist1.get(i1));
            }

        }

        if (mediasortmode == MediaSortMode.MediaSortMode_Date)
        {
            return arraylist;
        }
        try
        {
            Collections.sort(arraylist, a);
        }
        // Misplaced declaration of an exception variable
        catch (MediaSortMode mediasortmode) { }
        return arraylist;
    }

    public void a(aqz aqz1)
    {
        if (aqz1.a() == null)
        {
            Log.e("MediaStorePhotosDB_zy", "addFile receive null collection id");
        }
        Object obj = (asy)h.get(aqz1.a());
        if (obj == null)
        {
            obj = new asy();
            ((asy) (obj)).a(aqz1.b());
            a(aqz1.a(), ((asy) (obj)));
        }
        ((asy) (obj)).a(aqz1);
        ata ata2 = (ata)j.get(aqz1.a());
        ata ata1 = ata2;
        if (ata2 == null)
        {
            ata1 = new ata(((asy) (obj)));
            a(aqz1.a(), ata1);
        }
        obj = new asx(aqz1);
        ata1.a(((aso) (obj)));
        e.add(aqz1);
        f.add(obj);
    }

    public final ArrayList b()
    {
        try
        {
            Collections.sort(i, b);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return i;
    }

    public void c()
    {
        g.clear();
        h.clear();
        i.clear();
        j.clear();
        f.clear();
        e.clear();
    }

    private class MediaSortMode extends Enum
    {

        private static final MediaSortMode $VALUES[];
        public static final MediaSortMode MediaSortMode_Date;
        public static final MediaSortMode MediaSortMode_DefaultFolder;

        public static MediaSortMode valueOf(String s)
        {
            return (MediaSortMode)Enum.valueOf(com/fotoable/photoselector/MediaStorePhotosDB$MediaSortMode, s);
        }

        public static MediaSortMode[] values()
        {
            return (MediaSortMode[])$VALUES.clone();
        }

        static 
        {
            MediaSortMode_DefaultFolder = new MediaSortMode("MediaSortMode_DefaultFolder", 0);
            MediaSortMode_Date = new MediaSortMode("MediaSortMode_Date", 1);
            $VALUES = (new MediaSortMode[] {
                MediaSortMode_DefaultFolder, MediaSortMode_Date
            });
        }

        private MediaSortMode(String s, int l)
        {
            super(s, l);
        }
    }

}
