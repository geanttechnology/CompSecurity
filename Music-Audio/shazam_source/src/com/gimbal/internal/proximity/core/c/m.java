// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.c;

import com.gimbal.internal.c.c;

public final class m
{

    byte a[];
    public byte b[];
    public byte c[];

    public m()
    {
    }

    public final String toString()
    {
        return String.format("ManufacturerSpecificData: [id:%s], [data:%s]", new Object[] {
            com.gimbal.internal.c.c.a(a), com.gimbal.internal.c.c.a(b)
        });
    }
}
