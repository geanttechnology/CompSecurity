// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.cachemanager;

import java.io.File;

// Referenced classes of package com.ebay.nautilus.kernel.cachemanager:
//            CacheManager

private static class minimalMetaInfo
{

    public final File file;
    private long fileSize;
    public final long lastModified;
    public taInfo minimalMetaInfo;

    public static minimalMetaInfo[] createMeta(File afile[])
    {
        if (afile != null) goto _L2; else goto _L1
_L1:
        minimalMetaInfo aminimalmetainfo[] = new minimalMetaInfo[0];
_L4:
        return aminimalmetainfo;
_L2:
        minimalMetaInfo aminimalmetainfo1[] = new minimalMetaInfo[afile.length];
        int i = 0;
        do
        {
            aminimalmetainfo = aminimalmetainfo1;
            if (i >= afile.length)
            {
                continue;
            }
            aminimalmetainfo1[i] = new <init>(afile[i]);
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private long getRemainingTtl(long l, long l1)
    {
        if (lastModified == 0L)
        {
            return 0L;
        } else
        {
            return l - (l1 - lastModified);
        }
    }

    public int compareTo(lastModified lastmodified)
    {
        if (lastmodified == null)
        {
            throw new IllegalArgumentException("other must not be null");
        } else
        {
            return file.compareTo(lastmodified.file);
        }
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (file)obj;
        if (file != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((file) (obj)).file == null) goto _L1; else goto _L3
_L3:
        return false;
        if (file.equals(((file) (obj)).file)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public boolean exists()
    {
        return file.exists();
    }

    public long getFileSize()
    {
        if (fileSize == -1L)
        {
            fileSize = file.length();
        }
        return fileSize;
    }

    public int hashCode()
    {
        int i;
        if (file == null)
        {
            i = 0;
        } else
        {
            i = file.hashCode();
        }
        return i + 31;
    }

    public boolean isExpired(long l, long l1)
    {
        return getRemainingTtl(l, l1) <= 0L;
    }

    public taInfo(File file1)
    {
        this(file1, null);
    }

    public taInfo(File file1, taInfo tainfo)
    {
        fileSize = -1L;
        file = file1;
        lastModified = file1.lastModified();
        minimalMetaInfo = tainfo;
    }
}
