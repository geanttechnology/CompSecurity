// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;
import com.amazon.gallery.framework.kindle.ui.ScreenUtil;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.ui.MarginHelper;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            GalleryActionMode, GalleryActionModeCallback

public class AndroidActionMode
    implements GalleryActionMode
{

    private final AppCompatActivity actionBarActivity;
    private ActionMode actionMode;
    private final int menuResId;
    private final ScreenModeManager screenModeManager;
    private final CharSequence title;
    private final Toolbar toolbar;

    public AndroidActionMode(Activity activity, int i, CharSequence charsequence)
    {
        actionMode = null;
        menuResId = i;
        title = charsequence;
        actionBarActivity = (AppCompatActivity)activity;
        screenModeManager = (ScreenModeManager)ThorGalleryApplication.getBean(Keys.SCREEN_MODE_MANAGER);
        toolbar = (Toolbar)activity.findViewById(0x7f0c0086);
    }

    private void adjustMargins()
    {
        Resources resources = actionBarActivity.getResources();
        boolean flag = false;
        int i = ((flag) ? 1 : 0);
        if (resources.getConfiguration().orientation == 2)
        {
            i = ((flag) ? 1 : 0);
            if (!screenModeManager.isNormalMode())
            {
                i = ScreenUtil.getNavigationBarWidthForPadding(actionBarActivity);
            }
        }
        MarginHelper.adjustRightMargin(actionBarActivity.findViewById(0x7f0c006e), i);
    }

    public Drawable getBackground()
    {
        return null;
    }

    public Menu getMenu()
    {
        if (actionMode != null)
        {
            return actionMode.getMenu();
        } else
        {
            return null;
        }
    }

    public void invalidate()
    {
        if (actionMode != null)
        {
            actionMode.invalidate();
        }
    }

    public boolean isModeRunning()
    {
        return actionMode != null;
    }

    public void setSubtitle(CharSequence charsequence)
    {
        actionMode.setSubtitle(charsequence);
    }

    public void setTitle(CharSequence charsequence)
    {
        actionMode.setTitle(charsequence);
    }

    public void startActionMode(final GalleryActionModeCallback actionModeCallback)
    {
        actionBarActivity.startSupportActionMode(new android.support.v7.view.ActionMode.Callback() {

            final AndroidActionMode this$0;
            final GalleryActionModeCallback val$actionModeCallback;

            public boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem)
            {
                return actionModeCallback.onActionItemClicked(AndroidActionMode.this, menuitem);
            }

            public boolean onCreateActionMode(ActionMode actionmode, Menu menu)
            {
                actionMode = actionmode;
                if (title != null)
                {
                    actionmode.setTitle(title);
                }
                actionmode.getMenuInflater().inflate(menuResId, menu);
                toolbar.setVisibility(4);
                adjustMargins();
                return actionModeCallback.onCreateActionMode(AndroidActionMode.this, menu);
            }

            public void onDestroyActionMode(ActionMode actionmode)
            {
                actionModeCallback.onDestroyActionMode(AndroidActionMode.this);
            }

            public boolean onPrepareActionMode(ActionMode actionmode, Menu menu)
            {
                return actionModeCallback.onPrepareActionMode(AndroidActionMode.this, menu);
            }

            
            {
                this$0 = AndroidActionMode.this;
                actionModeCallback = galleryactionmodecallback;
                super();
            }
        });
    }

    public void stopActionMode()
    {
        toolbar.setVisibility(0);
        if (actionMode != null)
        {
            actionMode.finish();
            actionMode = null;
        }
    }


/*
    static ActionMode access$002(AndroidActionMode androidactionmode, ActionMode actionmode)
    {
        androidactionmode.actionMode = actionmode;
        return actionmode;
    }

*/




}
