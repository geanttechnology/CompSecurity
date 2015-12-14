// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.graphics.drawable.Drawable;
import android.view.Menu;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            GalleryActionModeCallback

public interface GalleryActionMode
{

    public abstract Drawable getBackground();

    public abstract Menu getMenu();

    public abstract void invalidate();

    public abstract boolean isModeRunning();

    public abstract void setSubtitle(CharSequence charsequence);

    public abstract void setTitle(CharSequence charsequence);

    public abstract void startActionMode(GalleryActionModeCallback galleryactionmodecallback);

    public abstract void stopActionMode();
}
