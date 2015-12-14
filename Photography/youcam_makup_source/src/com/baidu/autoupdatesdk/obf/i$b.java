// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

class <init>
    implements FilenameFilter
{

    public boolean accept(File file, String s)
    {
        return !TextUtils.isEmpty(s) && s.endsWith(".xdt");
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
