// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package com.googlecode.javacpp:
//            Builder

static final class val.jvmlib
    implements FilenameFilter
{

    final String val$jnipath[];
    final String val$jvmlib;
    final String val$jvmlink;
    final String val$jvmpath[];

    public boolean accept(File file, String s)
    {
        if ((new File(file, "jni.h")).exists())
        {
            val$jnipath[0] = file.getAbsolutePath();
        }
        if ((new File(file, "jni_md.h")).exists())
        {
            val$jnipath[1] = file.getAbsolutePath();
        }
        if ((new File(file, val$jvmlink)).exists())
        {
            val$jvmpath[0] = file.getAbsolutePath();
        }
        if ((new File(file, val$jvmlib)).exists())
        {
            val$jvmpath[1] = file.getAbsolutePath();
        }
        return (new File(file, s)).isDirectory();
    }

    (String as[], String s, String as1[], String s1)
    {
        val$jnipath = as;
        val$jvmlink = s;
        val$jvmpath = as1;
        val$jvmlib = s1;
        super();
    }
}
