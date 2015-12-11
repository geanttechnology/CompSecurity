// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http;

import java.util.Comparator;
import java.util.Map;

// Referenced classes of package org.springframework.http:
//            MediaType

static final class 
    implements Comparator
{

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((MediaType)obj, (MediaType)obj1);
    }

    public int compare(MediaType mediatype, MediaType mediatype1)
    {
        int i;
        byte byte0;
        byte0 = -1;
        double d = mediatype.getQualityValue();
        i = Double.compare(mediatype1.getQualityValue(), d);
        if (i == 0) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        if (mediatype.isWildcardType() && !mediatype1.isWildcardType())
        {
            return 1;
        }
        if (!mediatype1.isWildcardType())
        {
            break; /* Loop/switch isn't completed */
        }
        i = byte0;
        if (!mediatype.isWildcardType()) goto _L1; else goto _L3
_L3:
        if (!mediatype.getType().equals(mediatype1.getType()))
        {
            return 0;
        }
        if (mediatype.isWildcardSubtype() && !mediatype1.isWildcardSubtype())
        {
            return 1;
        }
        if (!mediatype1.isWildcardSubtype())
        {
            break; /* Loop/switch isn't completed */
        }
        i = byte0;
        if (!mediatype.isWildcardSubtype()) goto _L1; else goto _L4
_L4:
        if (!mediatype.getSubtype().equals(mediatype1.getSubtype()))
        {
            return 0;
        }
        int j = MediaType.access$000(mediatype).size();
        int k = MediaType.access$000(mediatype1).size();
        i = byte0;
        if (k >= j)
        {
            return k != j ? 1 : 0;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    ()
    {
    }
}
