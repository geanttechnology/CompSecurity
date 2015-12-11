// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Key;
import org.roboguice.shaded.goole.common.base.Objects;

// Referenced classes of package com.google.inject.internal:
//            WeakKeySet

private static final class source
{

    final Key key;
    final Object source;

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof source))
            {
                return false;
            }
            obj = (source)obj;
            if (!Objects.equal(key, ((key) (obj)).key) || !Objects.equal(source, ((source) (obj)).source))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            key, source
        });
    }

    (Key key1, Object obj)
    {
        key = key1;
        source = obj;
    }
}
