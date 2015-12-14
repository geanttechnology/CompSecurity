// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils;

import java.io.File;
import java.io.IOException;

// Referenced classes of package com.amazon.gallery.foundation.utils:
//            LockscreenWallpaperUtil

public class NoopLockscreenWallpaperUtil
    implements LockscreenWallpaperUtil
{

    public NoopLockscreenWallpaperUtil()
    {
    }

    public void addLockscreenWallpaper(File file)
        throws IOException
    {
    }

    public File prepareLockscreenDirectory()
        throws IOException
    {
        return null;
    }
}
