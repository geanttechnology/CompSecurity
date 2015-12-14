// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo;

import com.socialin.android.constants.CommonConstants;
import java.io.File;
import java.io.FileFilter;

public final class e
    implements FileFilter
{

    private int a;

    public e(int i)
    {
        a = i;
        super();
    }

    public final boolean accept(File file)
    {
        return file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(File.separator) + 1).contains(CommonConstants.b[a]);
    }
}
