// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;


public class AlbumPageTracker
{

    private static AlbumPageTracker instance;
    private int currentItems;
    private boolean loading;
    private int totalItems;

    private AlbumPageTracker()
    {
        loading = false;
        loading = false;
        currentItems = 0;
        totalItems = 0;
    }

    public static AlbumPageTracker getInstance()
    {
        com/amazon/gallery/thor/albums/AlbumPageTracker;
        JVM INSTR monitorenter ;
        AlbumPageTracker albumpagetracker;
        if (instance == null)
        {
            instance = new AlbumPageTracker();
        }
        albumpagetracker = instance;
        com/amazon/gallery/thor/albums/AlbumPageTracker;
        JVM INSTR monitorexit ;
        return albumpagetracker;
        Exception exception;
        exception;
        throw exception;
    }

    public int getCurrentItems()
    {
        this;
        JVM INSTR monitorenter ;
        int i = currentItems;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public int getTotalItems()
    {
        this;
        JVM INSTR monitorenter ;
        int i = totalItems;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isLoading()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = loading;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void reset()
    {
        this;
        JVM INSTR monitorenter ;
        currentItems = 0;
        totalItems = 0;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setCurrentItems(int i)
    {
        this;
        JVM INSTR monitorenter ;
        currentItems = i;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setLoading(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        loading = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setTotalItems(int i)
    {
        this;
        JVM INSTR monitorenter ;
        totalItems = i;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
