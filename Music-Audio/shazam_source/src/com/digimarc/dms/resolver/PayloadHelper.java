// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;


final class PayloadHelper
{

    PayloadHelper()
    {
    }

    static int getGeoID(long l)
    {
        return (int)(l >> 27 & 31L);
    }

    static int getPayloadID(long l)
    {
        return (int)(0x7ffffffL & l);
    }

    static long make32bitPayload(int i, int j)
    {
        return (long)(0x7ffffff & j) | (long)(i & 0x1f) << 27;
    }
}
