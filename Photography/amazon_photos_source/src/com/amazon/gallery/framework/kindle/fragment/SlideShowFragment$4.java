// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            SlideShowFragment

class t> extends android.support.v4.view.geChangeListener
{

    final SlideShowFragment this$0;

    public void onPageSelected(int i)
    {
        ViewDescriptor viewdescriptor = contentConfiguration.toViewDescriptor();
        viewdescriptor.setFocusedIndex(i);
        viewdescriptor.setCollectionSize(SlideShowFragment.access$400(SlideShowFragment.this).getCount());
    }

    rsorImagePagerAdapter()
    {
        this$0 = SlideShowFragment.this;
        super();
    }
}
