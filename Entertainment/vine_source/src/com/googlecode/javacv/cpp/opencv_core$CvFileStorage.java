// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class <init> extends Pointer
{
    protected static class ReleaseDeallocator extends opencv_core.CvFileStorage
        implements com.googlecode.javacpp.Pointer.Deallocator
    {

        public void deallocate()
        {
            opencv_core.cvReleaseFileStorage(this);
        }

        ReleaseDeallocator(opencv_core.CvFileStorage cvfilestorage)
        {
            super(cvfilestorage);
        }
    }


    public static torage open(String s, torage torage, int i)
    {
        return open(s, torage, i, null);
    }

    public static open open(String s, open open1, int i, String s1)
    {
        s = opencv_core.cvOpenFileStorage(s, open1, i, s1);
        if (s != null)
        {
            s.deallocator(new ReleaseDeallocator(s));
        }
        return s;
    }

    public void release()
    {
        deallocate();
    }

    static 
    {
        Loader.load();
    }

    public <init>()
    {
    }

    public <init>(Pointer pointer)
    {
        super(pointer);
    }
}
