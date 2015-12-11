// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.internal;

import com.facebook.h;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;

// Referenced classes of package com.facebook.share.internal:
//            f

private static class <init> extends <init>
{

    public void a(SharePhoto sharephoto)
    {
        f.a(sharephoto, this);
    }

    public void a(SharePhotoContent sharephotocontent)
    {
        throw new h("Cannot share SharePhotoContent via web sharing dialogs");
    }

    public void a(ShareVideoContent sharevideocontent)
    {
        throw new h("Cannot share ShareVideoContent via web sharing dialogs");
    }

    private deoContent()
    {
        super(null);
    }

    <init>(<init> <init>1)
    {
        this();
    }
}
