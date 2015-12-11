// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stericson.RootTools;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Mount
{

    protected final File mDevice;
    protected final Set mFlags;
    protected final File mMountPoint;
    protected final String mType;

    Mount(File file, File file1, String s, String s1)
    {
        mDevice = file;
        mMountPoint = file1;
        mType = s;
        mFlags = new HashSet(Arrays.asList(s1.split(",")));
    }

    public File getDevice()
    {
        return mDevice;
    }

    public Set getFlags()
    {
        return mFlags;
    }

    public File getMountPoint()
    {
        return mMountPoint;
    }

    public String getType()
    {
        return mType;
    }

    public String toString()
    {
        return String.format("%s on %s type %s %s", new Object[] {
            mDevice, mMountPoint, mType, mFlags
        });
    }
}
