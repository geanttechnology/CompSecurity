// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.view.LayoutInflater;
import com.xfinity.playerlib.image.CoverArtImageLoader;
import com.xfinity.playerlib.image.NetworkLogoImageLoader;
import com.xfinity.playerlib.model.EditorialProgram;
import com.xfinity.playerlib.view.ScrollStateTracker;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            FeaturedAdapter

public class CoverAdapter extends FeaturedAdapter
{

    public CoverAdapter(LayoutInflater layoutinflater, CoverArtImageLoader coverartimageloader, NetworkLogoImageLoader networklogoimageloader, String s, ScrollStateTracker scrollstatetracker)
    {
        super(layoutinflater, coverartimageloader, networklogoimageloader, s, scrollstatetracker);
    }

    protected String getImageUrl(EditorialProgram editorialprogram)
    {
        return editorialprogram.getImageKey();
    }

    protected int getViewLayoutId()
    {
        return com.xfinity.playerlib.R.layout.featured_cover_item;
    }
}
