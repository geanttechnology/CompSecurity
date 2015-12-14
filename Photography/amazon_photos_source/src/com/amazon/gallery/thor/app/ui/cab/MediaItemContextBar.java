// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.ui.cab;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.amazon.gallery.framework.gallery.actions.SelectionAction;
import com.amazon.gallery.thor.app.activity.GalleryActionMode;
import java.util.ArrayList;

// Referenced classes of package com.amazon.gallery.thor.app.ui.cab:
//            BaseContextBar, TitleUpdater

public class MediaItemContextBar extends BaseContextBar
{

    private final int OPAQUE = 255;
    protected final int TRANSLUCENT = 196;

    public MediaItemContextBar(Activity activity, int i, TitleUpdater titleupdater)
    {
        super(activity, i, titleupdater, new ArrayList());
        updateBackground(activity.getResources().getConfiguration().orientation);
    }

    private void updateBackground(int i)
    {
        Object obj = galleryActionMode.getBackground();
        if (obj != null)
        {
            i = getAlphaTarget(i);
            obj = ObjectAnimator.ofInt(obj, "alpha", new int[] {
                ((Drawable) (obj)).getAlpha(), i
            });
            ((ObjectAnimator) (obj)).setDuration(500L);
            ((ObjectAnimator) (obj)).start();
        }
    }

    protected void executeAction(SelectionAction selectionaction)
    {
        selectionaction.execute(new ArrayList(getSelectables()));
    }

    protected int getAlphaTarget(int i)
    {
        return i != 2 ? 255 : 196;
    }

    protected void updateActionSelectable(int i, SelectionAction selectionaction)
    {
        setMenuItemSelectable(i, selectionaction.canExecute(getSelectables()));
    }
}
