// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.content;


public final class ToolEntry
{

    public int iconResourceId;
    public int labelResourceId;
    public com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools name;

    public ToolEntry(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools, int i, int j)
    {
        name = tools;
        iconResourceId = i;
        labelResourceId = j;
    }

    public String toString()
    {
        return (new StringBuilder()).append("{name: ").append(name).append("}").toString();
    }
}
