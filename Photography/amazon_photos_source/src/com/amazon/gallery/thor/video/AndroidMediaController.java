// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.video;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.MediaController;
import android.widget.SeekBar;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.framework.gallery.video.GalleryMediaController;
import com.amazon.gallery.framework.gallery.video.GalleryMediaControllerHelper;
import com.amazon.gallery.framework.kindle.ui.ScreenUtil;

public class AndroidMediaController extends MediaController
    implements GalleryMediaController
{

    private final GalleryMediaControllerHelper helper;
    protected Resources resources;

    public AndroidMediaController(Context context)
    {
        super(context);
        helper = new GalleryMediaControllerHelper();
        init();
    }

    public AndroidMediaController(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        helper = new GalleryMediaControllerHelper();
        init();
    }

    public AndroidMediaController(Context context, boolean flag)
    {
        super(context, flag);
        helper = new GalleryMediaControllerHelper();
        init();
    }

    public void addBackKeyPressedListener(com.amazon.gallery.framework.gallery.video.GalleryMediaController.OnBackKeyPressedListener onbackkeypressedlistener)
    {
        helper.addBackKeyPressedListener(onbackkeypressedlistener);
    }

    public void addOnVisibilityChangeListener(com.amazon.gallery.framework.gallery.video.GalleryMediaController.OnVisibilityChangeListener onvisibilitychangelistener)
    {
        helper.addOnVisibilityChangeListener(onvisibilitychangelistener);
    }

    public void clearListeners()
    {
        helper.clearListeners();
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (keyevent.getKeyCode() == 19 && keyevent.getAction() == 0 && hasFocus())
        {
            super.hide();
            helper.onHideController();
        } else
        if (!helper.dispatchKeyEvent(keyevent))
        {
            return super.dispatchKeyEvent(keyevent);
        }
        return true;
    }

    public void hide()
    {
        if (isShowing())
        {
            super.hide();
            helper.hide();
        }
    }

    protected void init()
    {
        resources = getResources();
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        updatePadding();
    }

    public void removeBackKeyPressedListener(com.amazon.gallery.framework.gallery.video.GalleryMediaController.OnBackKeyPressedListener onbackkeypressedlistener)
    {
        helper.removeBackKeyPressedListener(onbackkeypressedlistener);
    }

    public void setAnchorView(View view)
    {
        super.setAnchorView(view);
        updateStyle();
    }

    public void setMediaPlayer(android.widget.MediaController.MediaPlayerControl mediaplayercontrol)
    {
        super.setMediaPlayer(mediaplayercontrol);
        helper.setMediaPlayer(mediaplayercontrol);
    }

    public void show()
    {
        show(0);
    }

    public void show(int i)
    {
        show(i, true);
    }

    public void show(int i, boolean flag)
    {
        show(i, flag, false);
    }

    public void show(int i, boolean flag, boolean flag1)
    {
        if (flag1 || !isShowing())
        {
            super.show(0);
            if (flag)
            {
                helper.show();
            }
        }
        updatePadding();
    }

    protected void updatePadding()
    {
        setPadding(getPaddingLeft(), getPaddingTop(), ScreenUtil.getNavigationBarWidthForPadding(getContext()), ScreenUtil.getNavigationBarHeightForPadding(getContext()));
    }

    protected void updateStyle()
    {
        SeekBar seekbar = (SeekBar)findViewById(resources.getIdentifier("mediacontroller_progress", "id", "android"));
        if (seekbar != null)
        {
            seekbar.getProgressDrawable().setColorFilter(resources.getColor(0x7f090004), android.graphics.PorterDuff.Mode.SRC_ATOP);
            seekbar.getThumb().setColorFilter(resources.getColor(0x106000b), android.graphics.PorterDuff.Mode.SRC_ATOP);
            if (Api.isAtLeastLollipop())
            {
                seekbar.setSplitTrack(false);
            }
        }
    }
}
