// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.widget.BaseAdapter;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            CoverAdapter

public abstract class BaseFeaturedAdapter extends BaseAdapter
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/featured/CoverAdapter);
    List programs;

    public int getCount()
    {
        return programs.size();
    }

    public abstract android.widget.Gallery.LayoutParams getGalleryLayoutParams();

}
