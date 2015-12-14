// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.model;


public class UnzipParameters
{

    private boolean ignoreAllFileAttributes;
    private boolean ignoreArchiveFileAttribute;
    private boolean ignoreDateTimeAttributes;
    private boolean ignoreHiddenFileAttribute;
    private boolean ignoreReadOnlyFileAttribute;
    private boolean ignoreSystemFileAttribute;

    public UnzipParameters()
    {
    }

    public boolean isIgnoreAllFileAttributes()
    {
        return ignoreAllFileAttributes;
    }

    public boolean isIgnoreArchiveFileAttribute()
    {
        return ignoreArchiveFileAttribute;
    }

    public boolean isIgnoreDateTimeAttributes()
    {
        return ignoreDateTimeAttributes;
    }

    public boolean isIgnoreHiddenFileAttribute()
    {
        return ignoreHiddenFileAttribute;
    }

    public boolean isIgnoreReadOnlyFileAttribute()
    {
        return ignoreReadOnlyFileAttribute;
    }

    public boolean isIgnoreSystemFileAttribute()
    {
        return ignoreSystemFileAttribute;
    }

    public void setIgnoreAllFileAttributes(boolean flag)
    {
        ignoreAllFileAttributes = flag;
    }

    public void setIgnoreArchiveFileAttribute(boolean flag)
    {
        ignoreArchiveFileAttribute = flag;
    }

    public void setIgnoreDateTimeAttributes(boolean flag)
    {
        ignoreDateTimeAttributes = flag;
    }

    public void setIgnoreHiddenFileAttribute(boolean flag)
    {
        ignoreHiddenFileAttribute = flag;
    }

    public void setIgnoreReadOnlyFileAttribute(boolean flag)
    {
        ignoreReadOnlyFileAttribute = flag;
    }

    public void setIgnoreSystemFileAttribute(boolean flag)
    {
        ignoreSystemFileAttribute = flag;
    }
}
