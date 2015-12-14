// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.receipt;


// Referenced classes of package com.aviary.android.feather.receipt:
//            ReceiptManager

static class count
{

    int count;
    long id;
    int status;

    (long l, int i)
    {
        this(l, i, 1);
    }

    public <init>(long l, int i, int j)
    {
        id = l;
        status = i;
        count = j;
    }
}
