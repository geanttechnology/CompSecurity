// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import com.digimarc.dms.imagereader.Payload;

class ResolveItem
{

    private Payload mPayload;

    public ResolveItem(Payload payload)
    {
        mPayload = payload;
    }

    public Payload getPayload()
    {
        return mPayload;
    }
}
