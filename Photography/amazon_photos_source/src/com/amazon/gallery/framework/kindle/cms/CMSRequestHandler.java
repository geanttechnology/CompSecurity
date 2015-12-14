// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.cms;

import android.content.Context;

// Referenced classes of package com.amazon.gallery.framework.kindle.cms:
//            CMSObjectID

public interface CMSRequestHandler
{
    public static interface RequestHandlerFactory
    {

        public abstract CMSRequestHandler newInstance(boolean flag);
    }


    public abstract int getMaxAlbumsInCarousel();

    public abstract void initWithContext(Context context);

    public abstract boolean isAlbumFavorite(CMSObjectID cmsobjectid);
}
