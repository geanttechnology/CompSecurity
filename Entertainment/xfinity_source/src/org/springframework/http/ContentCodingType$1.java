// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http;

import java.util.Comparator;

// Referenced classes of package org.springframework.http:
//            ContentCodingType

static final class 
    implements Comparator
{

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((ContentCodingType)obj, (ContentCodingType)obj1);
    }

    public int compare(ContentCodingType contentcodingtype, ContentCodingType contentcodingtype1)
    {
        double d = contentcodingtype.getQualityValue();
        int i = Double.compare(contentcodingtype1.getQualityValue(), d);
        if (i != 0)
        {
            return i;
        }
        if (contentcodingtype.isWildcardType() && !contentcodingtype1.isWildcardType())
        {
            return 1;
        }
        if (contentcodingtype1.isWildcardType() && !contentcodingtype.isWildcardType())
        {
            return -1;
        }
        return contentcodingtype.getType().equals(contentcodingtype1.getType()) ? 0 : 0;
    }

    ()
    {
    }
}
