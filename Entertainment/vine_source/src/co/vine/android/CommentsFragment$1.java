// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import co.vine.android.client.AppController;

// Referenced classes of package co.vine.android:
//            CommentsFragment

class this._cls0
    implements android.support.v7.view.
{

    final CommentsFragment this$0;

    public boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem)
    {
        addRequest(mAppController.deleteComment(CommentsFragment.access$000(CommentsFragment.this), CommentsFragment.access$100()));
        actionmode.finish();
        return true;
    }

    public boolean onCreateActionMode(ActionMode actionmode, Menu menu)
    {
        actionmode.getMenuInflater().inflate(0x7f100001, menu);
        return true;
    }

    public void onDestroyActionMode(ActionMode actionmode)
    {
        if (CommentsFragment.access$200(CommentsFragment.this) != null)
        {
            CommentsFragment.access$200(CommentsFragment.this).setSelected(false);
        }
        ActionMode _tmp = CommentsFragment.access$302(null);
    }

    public boolean onPrepareActionMode(ActionMode actionmode, Menu menu)
    {
        return false;
    }

    r()
    {
        this$0 = CommentsFragment.this;
        super();
    }
}
