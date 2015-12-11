// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc:
//            DiscCacheAware

public abstract class BaseDiscCache
    implements DiscCacheAware
{

    private static final String ERROR_ARG_NULL = "\"%s\" argument must be not null";
    protected File cacheDir;
    private FileNameGenerator fileNameGenerator;

    public BaseDiscCache(File file)
    {
        this(file, DefaultConfigurationFactory.createFileNameGenerator());
    }

    public BaseDiscCache(File file, FileNameGenerator filenamegenerator)
    {
        if (file == null)
        {
            throw new IllegalArgumentException("cacheDir\"%s\" argument must be not null");
        }
        if (filenamegenerator == null)
        {
            throw new IllegalArgumentException("fileNameGenerator\"%s\" argument must be not null");
        } else
        {
            cacheDir = file;
            fileNameGenerator = filenamegenerator;
            return;
        }
    }

    public void clear()
    {
        File afile[] = cacheDir.listFiles();
        if (afile == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = afile.length;
        i = 0;
_L5:
        if (i < j) goto _L3; else goto _L2
_L2:
        return;
_L3:
        afile[i].delete();
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public File get(String s)
    {
        s = fileNameGenerator.generate(s);
        return new File(cacheDir, s);
    }
}
