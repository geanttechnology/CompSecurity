// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;


// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCdsDownloaderFactory

static class  extends 
{

    protected String getCacheDirName()
    {
        return "aviary-cds-featured-image-cache";
    }

    protected String getLocalPath( )
    {
        return .eImageLocalPath();
    }

    protected String getLocalPathColumnName()
    {
        return "content_featureImageLocalPath";
    }

    protected String getRemotePath(eImageLocalPath eimagelocalpath)
    {
        return eimagelocalpath.eImageURL();
    }

    protected String getRemoteUrlColumnName()
    {
        return "content_featureImageURL";
    }

    ()
    {
    }
}
