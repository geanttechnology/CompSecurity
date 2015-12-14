// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

// Referenced classes of package com.bumptech.glide.load.resource.file:
//            FileToStreamDecoder

static class 
{

    public InputStream open(File file)
        throws FileNotFoundException
    {
        return new FileInputStream(file);
    }

    ()
    {
    }
}
