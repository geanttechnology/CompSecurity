// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util.image;

import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package co.vine.android.util.image:
//            ImageUtils

private static class mOwnerId
    implements FilenameFilter
{

    private final long mOwnerId;

    public boolean accept(File file, String s)
    {
        return s.startsWith((new StringBuilder()).append("pic-r-").append(mOwnerId).toString()) || s.startsWith((new StringBuilder()).append("pic-").append(mOwnerId).toString());
    }

    (long l)
    {
        mOwnerId = l;
    }
}
