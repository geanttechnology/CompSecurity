// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator.actions;

import java.io.ObjectOutputStream;
import java.io.OutputStream;

public final class b extends ObjectOutputStream
{

    public b(OutputStream outputstream)
    {
        super(outputstream);
    }

    protected final void writeStreamHeader()
    {
        reset();
    }
}
