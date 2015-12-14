// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class mPickedImageIds
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private final long mPickedImageIds[];

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

    public long[] a()
    {
        return mPickedImageIds;
    }

    public I(Long along[])
    {
        mPickedImageIds = new long[along.length];
        for (int i = 0; i < along.length; i++)
        {
            mPickedImageIds[i] = along[i].longValue();
        }

    }
}
