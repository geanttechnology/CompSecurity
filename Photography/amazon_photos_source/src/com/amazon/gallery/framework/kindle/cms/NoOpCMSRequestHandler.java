// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.cms;

import android.content.Context;

// Referenced classes of package com.amazon.gallery.framework.kindle.cms:
//            CMSRequestHandler, CMSObjectID

public class NoOpCMSRequestHandler
    implements CMSRequestHandler
{

    public NoOpCMSRequestHandler()
    {
    }

    public int getMaxAlbumsInCarousel()
    {
        return 0;
    }

    public void initWithContext(Context context)
    {
    }

    public boolean isAlbumFavorite(CMSObjectID cmsobjectid)
    {
        return false;
    }
}
