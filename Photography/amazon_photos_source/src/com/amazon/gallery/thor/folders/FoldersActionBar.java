// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.folders;

import android.support.v7.widget.Toolbar;
import android.util.Pair;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.framework.kindle.action.MultiselectModeAction;
import com.amazon.gallery.thor.app.actions.SortAction;
import com.amazon.gallery.thor.app.activity.ThorActionBar;
import com.amazon.gallery.thor.view.PhotosNavigationPane;

public class FoldersActionBar extends ThorActionBar
{

    private static final Pair ACTIONS[] = {
        new Pair(com/amazon/gallery/framework/kindle/action/MultiselectModeAction, Integer.valueOf(0x7f0c024b)), new Pair(com/amazon/gallery/thor/app/actions/SortAction, Integer.valueOf(0x7f0c023a))
    };

    public FoldersActionBar(PhotosNavigationPane photosnavigationpane, BeanAwareActivity beanawareactivity, boolean flag, Toolbar toolbar)
    {
        super(photosnavigationpane, beanawareactivity, flag, toolbar);
    }

    protected Pair[] getHeaderActions()
    {
        return ACTIONS;
    }

}
