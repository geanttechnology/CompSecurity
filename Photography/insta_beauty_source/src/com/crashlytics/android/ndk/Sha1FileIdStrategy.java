// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.ndk;

import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

// Referenced classes of package com.crashlytics.android.ndk:
//            FileIdStrategy

class Sha1FileIdStrategy
    implements FileIdStrategy
{

    Sha1FileIdStrategy()
    {
    }

    private static String getFileSHA(String s)
    {
        BufferedInputStream bufferedinputstream = new BufferedInputStream(new FileInputStream(s));
        s = CommonUtils.b(bufferedinputstream);
        CommonUtils.a(bufferedinputstream);
        return s;
        s;
        bufferedinputstream = null;
_L2:
        CommonUtils.a(bufferedinputstream);
        throw s;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String getId(File file)
    {
        return getFileSHA(file.getPath());
    }
}
