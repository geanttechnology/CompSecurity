// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import com.ebay.mobile.photomanager.net.UploadPhotoNetLoader;

// Referenced classes of package com.ebay.mobile.photomanager:
//            PhotoManagerFragment, PhotoManagerViewAdapter

public static interface 
{

    public abstract PhotoManagerViewAdapter getConfigChangeBackupAdapter();

    public abstract void uploadPhoto(UploadPhotoNetLoader uploadphotonetloader);

    public abstract String urlForUploadedPhoto();
}
