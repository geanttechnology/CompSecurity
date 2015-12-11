// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.image;

import android.view.LayoutInflater;
import com.xfinity.playerlib.model.EditorialProgram;
import com.xfinity.playerlib.view.ScrollStateTracker;
import com.xfinity.playerlib.view.featured.FeaturedAdapter;

// Referenced classes of package com.xfinity.playerlib.image:
//            CoverArtImageLoader, NetworkLogoImageLoader

public class VideoAdapter extends FeaturedAdapter
{

    public VideoAdapter(LayoutInflater layoutinflater, CoverArtImageLoader coverartimageloader, NetworkLogoImageLoader networklogoimageloader, String s, ScrollStateTracker scrollstatetracker)
    {
        super(layoutinflater, coverartimageloader, networklogoimageloader, s, scrollstatetracker);
    }

    protected String getImageUrl(EditorialProgram editorialprogram)
    {
        return coverArtImageLoader.getImageUrl(editorialprogram);
    }

    protected int getViewLayoutId()
    {
        return com.xfinity.playerlib.R.layout.browse_program_item;
    }
}
