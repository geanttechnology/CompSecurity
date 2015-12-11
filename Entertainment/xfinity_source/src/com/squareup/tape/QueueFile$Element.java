// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.tape;


// Referenced classes of package com.squareup.tape:
//            QueueFile

static class length
{

    static final length NULL = new <init>(0, 0);
    final int length;
    final int position;

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("[").append("position = ").append(position).append(", length = ").append(length).append("]").toString();
    }


    (int i, int j)
    {
        position = i;
        length = j;
    }
}
