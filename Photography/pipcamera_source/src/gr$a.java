// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class >
    implements FileFilter
{

    public boolean accept(File file)
    {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }

    >()
    {
    }
}
