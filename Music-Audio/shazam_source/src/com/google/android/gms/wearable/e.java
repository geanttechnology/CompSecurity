// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.wearable.internal.bi;

public final class e extends g
    implements com.google.android.gms.common.api.g
{

    private final Status b;

    public e(DataHolder dataholder)
    {
        super(dataholder);
        b = new Status(dataholder.e);
    }

    public final Status a()
    {
        return b;
    }

    protected final Object a(int i, int j)
    {
        return new bi(a, i, j);
    }

    protected final String d()
    {
        return "path";
    }
}
