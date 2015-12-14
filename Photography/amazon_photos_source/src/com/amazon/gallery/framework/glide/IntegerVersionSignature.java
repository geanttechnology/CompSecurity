// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.glide;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class IntegerVersionSignature
    implements Key
{

    private int currentVersion;

    public IntegerVersionSignature(int i)
    {
        currentVersion = i;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof IntegerVersionSignature)
        {
            obj = (IntegerVersionSignature)obj;
            flag = flag1;
            if (currentVersion == ((IntegerVersionSignature) (obj)).currentVersion)
            {
                flag = true;
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return currentVersion;
    }

    public void updateDiskCacheKey(MessageDigest messagedigest)
    {
        messagedigest.update(ByteBuffer.allocate(32).putInt(currentVersion).array());
    }
}
