// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class mMax
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private final String mDestView;
    private final int mMax;
    private final int mMin;
    private final boolean mMultiSelect;

    static String a(mMax mmax)
    {
        return mmax.mDestView;
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

    public int a()
    {
        return mMin;
    }

    public int b()
    {
        return mMax;
    }

    public String c()
    {
        return mDestView;
    }

    public boolean d()
    {
        return mMultiSelect;
    }

    private ()
    {
        mMultiSelect = true;
        mDestView = null;
        mMin = -1;
        mMax = -1;
    }

    mMax(mMax mmax)
    {
        this();
    }

    public <init>(String s)
    {
        mMultiSelect = false;
        mDestView = s;
        mMin = -1;
        mMax = -1;
    }
}
