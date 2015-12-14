// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;


// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            CursorRowDataProvider

private static class <init>
{

    private final int length;
    private final int pos;

    public int getLength()
    {
        return length;
    }

    public String toString()
    {
        return (new StringBuilder()).append(pos).append(",").append(length).toString();
    }

    private (int i, int j)
    {
        pos = i;
        length = j;
    }

    length(int i, int j, length length1)
    {
        this(i, j);
    }
}
