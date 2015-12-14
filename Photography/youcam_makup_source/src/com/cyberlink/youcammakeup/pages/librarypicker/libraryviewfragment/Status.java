// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.libraryviewfragment;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Status
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private Long mAlbumId;
    private com.cyberlink.youcammakeup.pages.librarypicker.LibraryViewFragment.ViewType mViewType;

    public Status()
    {
        mViewType = com.cyberlink.youcammakeup.pages.librarypicker.LibraryViewFragment.ViewType.b;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        try
        {
            objectinputstream.defaultReadObject();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream)
        {
            return;
        }
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        try
        {
            objectoutputstream.defaultWriteObject();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOutputStream objectoutputstream)
        {
            return;
        }
    }

    public com.cyberlink.youcammakeup.pages.librarypicker.LibraryViewFragment.ViewType a()
    {
        return mViewType;
    }

    public void a(com.cyberlink.youcammakeup.pages.librarypicker.LibraryViewFragment.ViewType viewtype)
    {
        mViewType = viewtype;
    }

    public void a(Long long1)
    {
        mAlbumId = long1;
    }

    public Long b()
    {
        return mAlbumId;
    }

    public String toString()
    {
        return (new StringBuilder()).toString();
    }
}
