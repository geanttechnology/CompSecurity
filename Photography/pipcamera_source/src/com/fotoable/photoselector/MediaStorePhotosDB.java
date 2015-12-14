// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector;

import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import mu;
import nn;
import nr;
import ns;
import nt;
import nu;

public class MediaStorePhotosDB extends nn
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
        a = new Comparator() {

            final MediaStorePhotosDB a;

            public int a(nr nr1, nr nr2)
            {
                return nr1.k().compareTo(nr2.k());
            }

            public int compare(Object obj, Object obj1)
            {
                return a((nr)obj, (nr)obj1);
            }

            
            {
                a = MediaStorePhotosDB.this;
                super();
            }
        };
        b = new Comparator() {

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

            
            {
                a = MediaStorePhotosDB.this;
                super();
            }
        };
        c = new Comparator() {

            final MediaStorePhotosDB a;

            public int a(nr nr1, nr nr2)
            {
                int l = nr1.j().compareTo(nr2.j());
                if (l != 0);
                return l;
            }

            public int compare(Object obj, Object obj1)
            {
                return a((nr)obj, (nr)obj1);
            }

            
            {
                a = MediaStorePhotosDB.this;
                super();
            }
        };
        d = new Comparator() {

            final MediaStorePhotosDB a;

            public int a(mu mu1, mu mu2)
            {
                return mu1.d().toString().compareTo(mu2.d().toString());
            }

            public int compare(Object obj, Object obj1)
            {
                return a((mu)obj, (mu)obj1);
            }

            
            {
                a = MediaStorePhotosDB.this;
                super();
            }
        };
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

    private void a(String s, ns ns1)
    {
        this;
        JVM INSTR monitorenter ;
        h.put(s, ns1);
        g.add(ns1);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    private void a(String s, nu nu1)
    {
        this;
        JVM INSTR monitorenter ;
        j.put(s, nu1);
        i.add(nu1);
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
            ArrayList arraylist1 = ((nt)i.get(l)).i();
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

    public void a(mu mu1)
    {
        if (mu1.a() == null)
        {
            Log.e("MediaStorePhotosDB_zy", "addFile receive null collection id");
        }
        Object obj = (ns)h.get(mu1.a());
        if (obj == null)
        {
            obj = new ns();
            ((ns) (obj)).a(mu1.b());
            a(mu1.a(), ((ns) (obj)));
        }
        ((ns) (obj)).a(mu1);
        nu nu2 = (nu)j.get(mu1.a());
        nu nu1 = nu2;
        if (nu2 == null)
        {
            nu1 = new nu(((ns) (obj)));
            a(mu1.a(), nu1);
        }
        obj = new nr(mu1);
        nu1.a(((nl) (obj)));
        e.add(mu1);
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
