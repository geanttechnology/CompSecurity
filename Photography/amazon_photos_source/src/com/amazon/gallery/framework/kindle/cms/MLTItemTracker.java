// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.cms;

import com.amazon.gallery.framework.data.dao.tag.TagDao;

// Referenced classes of package com.amazon.gallery.framework.kindle.cms:
//            CMSClient, CMSImageStore, CMSDB

public class MLTItemTracker
{

    private static final String TAG = com/amazon/gallery/framework/kindle/cms/MLTItemTracker.getName();
    protected CMSClient cmsClient;
    protected CMSImageStore cmsImageStore;
    private CMSDB db;
    protected TagDao tagDao;

    public MLTItemTracker()
    {
    }

    public void setCMSClient(CMSClient cmsclient)
    {
        cmsClient = cmsclient;
    }

    public void setCMSDB(CMSDB cmsdb)
    {
        db = cmsdb;
    }

    public void setCMSImageStore(CMSImageStore cmsimagestore)
    {
        cmsImageStore = cmsimagestore;
    }

    public void setTagDao(TagDao tagdao)
    {
        tagDao = tagdao;
    }

}
