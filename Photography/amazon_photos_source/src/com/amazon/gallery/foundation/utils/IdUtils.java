// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils;

import android.util.Base64;
import java.nio.ByteBuffer;

public class IdUtils
{

    public static String objectIdToNodeId(long l, long l1)
    {
        ByteBuffer bytebuffer = ByteBuffer.wrap(new byte[16]);
        bytebuffer.putLong(l);
        bytebuffer.putLong(l1);
        return Base64.encodeToString(bytebuffer.array(), 11);
    }
}
