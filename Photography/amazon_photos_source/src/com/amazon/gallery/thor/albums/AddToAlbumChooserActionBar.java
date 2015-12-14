// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.support.v7.widget.Toolbar;
import android.util.Pair;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.thor.app.activity.ChooserActionBar;

public class AddToAlbumChooserActionBar extends ChooserActionBar
{

    private static final Pair EMPTY_HEADER_ACTIONS[] = new Pair[0];

    public AddToAlbumChooserActionBar(BeanAwareActivity beanawareactivity, Toolbar toolbar)
    {
        super(beanawareactivity, toolbar);
    }

    protected Pair[] getHeaderActions()
    {
        return EMPTY_HEADER_ACTIONS;
    }

}
