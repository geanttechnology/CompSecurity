// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import java.io.File;
import java.util.Comparator;

// Referenced classes of package com.amazon.mShop.net:
//            MShopDiskCachePolicy

public static class mCanonicalPath
{

    public static final Comparator COMPARATOR = new Comparator() {

        public int compare(MShopDiskCachePolicy.FileLruInf filelruinf, MShopDiskCachePolicy.FileLruInf filelruinf1)
        {
            if (filelruinf.mLastModifiedTime == filelruinf1.mLastModifiedTime)
            {
                return 0;
            }
            return filelruinf.mLastModifiedTime <= filelruinf1.mLastModifiedTime ? -1 : 1;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((MShopDiskCachePolicy.FileLruInf)obj, (MShopDiskCachePolicy.FileLruInf)obj1);
        }

    };
    public String mCanonicalPath;
    public File mFile;
    public String mFileName;
    public String mInfFile;
    public long mLastModifiedTime;


    public _cls1(File file, String s)
    {
        mFileName = file.getName();
        mFile = file;
        mLastModifiedTime = file.lastModified();
        mCanonicalPath = s;
        mInfFile = (new StringBuilder()).append(mCanonicalPath).append(".inf").toString();
    }
}
