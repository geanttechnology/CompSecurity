// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor;

import android.os.Environment;
import com.socialin.android.util.FileUtils;
import java.io.File;

public final class b
{

    public static final String a = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/PicsArt/editor/.projects").toString();

    public static void a()
    {
        File file = new File(a);
        if (file.exists())
        {
            File file1 = new File((new StringBuilder()).append(file.getAbsolutePath()).append(System.currentTimeMillis()).toString());
            file.renameTo(file1);
            FileUtils.b(file1);
        }
    }

}
