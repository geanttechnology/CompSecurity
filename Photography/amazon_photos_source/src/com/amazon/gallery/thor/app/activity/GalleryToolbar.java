// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.graphics.drawable.Drawable;
import android.view.Menu;
import com.amazon.gallery.framework.kindle.activity.OnSortingChangedListener;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            GalleryNavigationSetting

public interface GalleryToolbar
{

    public abstract Drawable getBackground();

    public abstract Menu getMenu();

    public abstract GalleryNavigationSetting getNavigationSetting();

    public abstract void inflateMenu(int i);

    public abstract void invalidateActionsMenu();

    public abstract void removeRefineMenus();

    public abstract void setNavigationOnClickListener(android.view.View.OnClickListener onclicklistener);

    public abstract void setNavigationSetting(GalleryNavigationSetting gallerynavigationsetting);

    public abstract void setOnMenuItemClickListener(android.support.v7.widget.Toolbar.OnMenuItemClickListener onmenuitemclicklistener);

    public abstract void setOnSortChangedListener(OnSortingChangedListener onsortingchangedlistener);

    public abstract void setSubtitle(CharSequence charsequence);

    public abstract void setTitle(CharSequence charsequence);

    public abstract void setupSort(int i, int j);
}
