// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3;

import com.bumptech.glide.load.e;
import com.socialin.android.apiv3.model.ImageItem;
import myobfuscated.v.ac;
import myobfuscated.v.ae;
import myobfuscated.w.a;

// Referenced classes of package com.socialin.android.apiv3:
//            SocialinApiV3

public class PicsartModelLoader extends a
{

    public PicsartModelLoader(ae ae, ac ac)
    {
        super(ae, ac);
    }

    protected String getUrl(ImageItem imageitem, int i, int j, e e)
    {
        return SocialinApiV3.getPhotoURL(imageitem, i, j);
    }

    protected volatile String getUrl(Object obj, int i, int j, e e)
    {
        return getUrl((ImageItem)obj, i, j, e);
    }

    public boolean handles(ImageItem imageitem)
    {
        return false;
    }

    public volatile boolean handles(Object obj)
    {
        return handles((ImageItem)obj);
    }
}
