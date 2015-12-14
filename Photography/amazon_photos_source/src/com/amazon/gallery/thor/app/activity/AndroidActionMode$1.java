// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            AndroidActionMode, GalleryActionModeCallback

class lback
    implements android.support.v7.view.ActionMode._cls1
{

    final AndroidActionMode this$0;
    final GalleryActionModeCallback val$actionModeCallback;

    public boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem)
    {
        return val$actionModeCallback.onActionItemClicked(AndroidActionMode.this, menuitem);
    }

    public boolean onCreateActionMode(ActionMode actionmode, Menu menu)
    {
        AndroidActionMode.access$002(AndroidActionMode.this, actionmode);
        if (AndroidActionMode.access$100(AndroidActionMode.this) != null)
        {
            actionmode.setTitle(AndroidActionMode.access$100(AndroidActionMode.this));
        }
        actionmode.getMenuInflater().inflate(AndroidActionMode.access$200(AndroidActionMode.this), menu);
        AndroidActionMode.access$300(AndroidActionMode.this).setVisibility(4);
        AndroidActionMode.access$400(AndroidActionMode.this);
        return val$actionModeCallback.onCreateActionMode(AndroidActionMode.this, menu);
    }

    public void onDestroyActionMode(ActionMode actionmode)
    {
        val$actionModeCallback.onDestroyActionMode(AndroidActionMode.this);
    }

    public boolean onPrepareActionMode(ActionMode actionmode, Menu menu)
    {
        return val$actionModeCallback.onPrepareActionMode(AndroidActionMode.this, menu);
    }

    lback()
    {
        this$0 = final_androidactionmode;
        val$actionModeCallback = GalleryActionModeCallback.this;
        super();
    }
}
