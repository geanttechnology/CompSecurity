// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.algorithm.DESUtil;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            LruCache

public class TagDecrypter
{

    private final DESUtil des;
    private LruCache tagLruCache;

    public String decryptTag(String s)
    {
        String s1;
        String s2;
        String s3;
        s2 = s;
        s3 = s2;
        s1 = s2;
        if (!s2.startsWith("!"))
        {
            break MISSING_BLOCK_LABEL_209;
        }
        s3 = s2;
        if (tagLruCache.check(s2))
        {
            s3 = s2;
            String as[];
            String s4;
            int i;
            try
            {
                return (String)tagLruCache.get(s2);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_188;
        }
        s3 = s2;
        s2 = s2.substring(1);
        s3 = s2;
        as = s2.split("@");
        s3 = s2;
        s1 = s2;
        if (as.length <= 1)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        s1 = as[0];
        s3 = s2;
        i = Integer.valueOf(as[0]).intValue();
        s3 = s2;
        s4 = s2.substring(s1.length() + 1, s1.length() + 1 + i);
        s3 = s2;
        s1 = s2.substring(s1.length() + 1 + i);
        s3 = s2;
        s1 = (new StringBuilder()).append(des.decryptStr(s4)).append(s1).toString();
        s3 = s2;
        tagLruCache.put(s, s1);
        return s1;
        s1 = (new StringBuilder()).append("[td]").append(s3).toString();
        return s1;
    }
}
