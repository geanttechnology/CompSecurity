// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk;

import android.view.ViewGroup;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.sdk.widget.AviaryBottomBarViewFlipper;
import it.sephiroth.android.library.imagezoom.ImageViewTouchBase;

// Referenced classes of package com.aviary.android.feather.sdk:
//            AviaryMainController

public static interface 
{

    public abstract ViewGroup activatePopupContainer();

    public abstract void deactivatePopupContainer();

    public abstract int getActionBarSize();

    public abstract AviaryBottomBarViewFlipper getBottomBar();

    public abstract ViewGroup getDrawingImageContainer();

    public abstract ImageViewTouchBase getMainImage();

    public abstract ViewGroup getOptionsPanelContainer();

    public abstract AviaryTracker getTracker();

    public abstract void hideModalProgress();

    public abstract void hideToolProgress();

    public abstract void showModalProgress();

    public abstract void showToolProgress();
}
