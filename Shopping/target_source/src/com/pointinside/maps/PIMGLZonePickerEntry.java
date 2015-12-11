// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.g.a.a.a.d;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import java.util.Arrays;
import java.util.List;

public class PIMGLZonePickerEntry extends d
{
    public static class ByReference extends PIMGLZonePickerEntry
        implements com.g.a.a.a.d.a
    {

        protected volatile d newByReference()
        {
            return newByReference();
        }

        protected volatile d newByValue()
        {
            return newByValue();
        }

        protected volatile d newInstance()
        {
            return newInstance();
        }

        public ByReference()
        {
        }
    }

    public static class ByValue extends PIMGLZonePickerEntry
        implements com.g.a.a.a.d.b
    {

        protected volatile d newByReference()
        {
            return newByReference();
        }

        protected volatile d newByValue()
        {
            return newByValue();
        }

        protected volatile d newInstance()
        {
            return newInstance();
        }

        public ByValue()
        {
        }
    }


    public String mName;
    public Pointer mUserdata;
    public IntByReference mZoneRef;

    public PIMGLZonePickerEntry()
    {
    }

    public PIMGLZonePickerEntry(Pointer pointer)
    {
        super(pointer);
    }

    public PIMGLZonePickerEntry(IntByReference intbyreference, String s, Pointer pointer)
    {
        mZoneRef = intbyreference;
        mName = s;
        mUserdata = pointer;
    }

    public static PIMGLZonePickerEntry[] newArray(int i)
    {
        return (PIMGLZonePickerEntry[])d.newArray(com/pointinside/maps/PIMGLZonePickerEntry, i);
    }

    protected List getFieldOrder()
    {
        return Arrays.asList(new String[] {
            "mZoneRef", "mName", "mUserdata"
        });
    }

    protected volatile d newByReference()
    {
        return newByReference();
    }

    protected ByReference newByReference()
    {
        return new ByReference();
    }

    protected volatile d newByValue()
    {
        return newByValue();
    }

    protected ByValue newByValue()
    {
        return new ByValue();
    }

    protected volatile d newInstance()
    {
        return newInstance();
    }

    protected PIMGLZonePickerEntry newInstance()
    {
        return new PIMGLZonePickerEntry();
    }
}
