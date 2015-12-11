// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.data.DataHolder;

// Referenced classes of package com.google.android.gms.location.places:
//            x, b

public static abstract class <init> extends <init>
{

    protected b a(Status status)
    {
        return new b(DataHolder.b(status.g()));
    }

    protected g b(Status status)
    {
        return a(status);
    }

    public er(com.google.android.gms.common.api. , c c)
    {
        super(, c);
    }
}
