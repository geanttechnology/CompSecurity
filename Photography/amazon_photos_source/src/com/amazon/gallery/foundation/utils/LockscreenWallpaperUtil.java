// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils;

import java.io.File;
import java.io.IOException;

public interface LockscreenWallpaperUtil
{

    public abstract void addLockscreenWallpaper(File file)
        throws IOException;

    public abstract File prepareLockscreenDirectory()
        throws IOException;
}
