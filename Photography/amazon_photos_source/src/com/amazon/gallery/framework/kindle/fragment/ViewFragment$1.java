// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.activity.NativeGalleryActivity;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.kindle.recyclerview.RecyclerAdapter;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            ViewFragment

class init> extends android.support.v7.widget.apterDataObserver
{

    final ViewFragment this$0;

    public void onChanged()
    {
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        ViewDescriptor viewdescriptor = contentConfiguration.toViewDescriptor();
        if (fragmentactivity != null && ViewFragment.access$000(ViewFragment.this) && (viewdescriptor == null || !viewdescriptor.hasCollectionTypeChanged()))
        {
            ((NativeGalleryActivity)fragmentactivity).updateNoContentOverlay(mAdapter.getItemCount());
        }
    }

    pter()
    {
        this$0 = ViewFragment.this;
        super();
    }
}
