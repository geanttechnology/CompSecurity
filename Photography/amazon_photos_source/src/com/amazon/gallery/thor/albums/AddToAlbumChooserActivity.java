// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.content.Intent;
import android.os.Bundle;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.gallery.view.ViewNameFactory;
import com.amazon.gallery.framework.kindle.fragment.FragmentController;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.thor.app.activity.ThorNativeGalleryActivity;

public class AddToAlbumChooserActivity extends ThorNativeGalleryActivity
{

    private String albumId;
    private String albumName;

    public AddToAlbumChooserActivity()
    {
    }

    protected MediaContentConfiguration createMediaContentConfiguration()
    {
        ViewDescriptor viewdescriptor = createViewDescriptor();
        com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration.Builder builder = IntentUtil.createMediaContentConfigBuilderFromIntent(this, getIntent());
        builder.withViewDescriptor(viewdescriptor).withSortType(viewdescriptor.getMediaItemSortType());
        if (FeatureManager.isFeatureEnabled(Features.HIDE) && !viewdescriptor.isInHiddenMode())
        {
            builder.appendWhere("hidden", Integer.valueOf(0));
        }
        if (viewdescriptor.getTag() != null)
        {
            builder.withLabel(ViewNameFactory.getTitle(viewdescriptor.getTag(), this));
        }
        builder.appendWhere("sync_state", Integer.valueOf(SyncState.SYNCED.ordinal()));
        return builder.build();
    }

    public String getAlbumId()
    {
        return albumId;
    }

    public void onBackPressed()
    {
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        albumId = getIntent().getStringExtra("TAG_NODE_ID");
        albumName = getIntent().getStringExtra("TAG_NAME");
    }

    public void setActivityContentView()
    {
        setContentView(0x7f0300eb);
    }

    protected void setupFragmentController()
    {
        super.setupFragmentController();
        fragmentController.setInAddToAlbumChooserMode(true);
    }

    protected void setupNavPane()
    {
    }
}
