// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.view.Menu;
import android.view.MenuItem;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            GalleryActionMode

public interface GalleryActionModeCallback
{

    public abstract boolean onActionItemClicked(GalleryActionMode galleryactionmode, MenuItem menuitem);

    public abstract boolean onCreateActionMode(GalleryActionMode galleryactionmode, Menu menu);

    public abstract void onDestroyActionMode(GalleryActionMode galleryactionmode);

    public abstract boolean onPrepareActionMode(GalleryActionMode galleryactionmode, Menu menu);
}
