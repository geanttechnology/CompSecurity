// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v7.internal.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;
import myobfuscated.b.a;
import myobfuscated.b.b;

// Referenced classes of package android.support.v7.app:
//            AppCompatDelegateImplV7, AppCompatCallback

class mWrapped
    implements b
{

    private b mWrapped;
    final AppCompatDelegateImplV7 this$0;

    public boolean onActionItemClicked(a a, MenuItem menuitem)
    {
        return mWrapped.onActionItemClicked(a, menuitem);
    }

    public boolean onCreateActionMode(a a, Menu menu)
    {
        return mWrapped.onCreateActionMode(a, menu);
    }

    public void onDestroyActionMode(a a)
    {
        mWrapped.onDestroyActionMode(a);
        if (mActionModePopup == null) goto _L2; else goto _L1
_L1:
        mWindow.getDecorView().removeCallbacks(mShowActionModePopup);
        mActionModePopup.dismiss();
_L4:
        if (mActionModeView != null)
        {
            mActionModeView.removeAllViews();
        }
        if (mAppCompatCallback != null)
        {
            mAppCompatCallback.onSupportActionModeFinished(mActionMode);
        }
        mActionMode = null;
        return;
_L2:
        if (mActionModeView != null)
        {
            mActionModeView.setVisibility(8);
            if (mActionModeView.getParent() != null)
            {
                ViewCompat.requestApplyInsets((View)mActionModeView.getParent());
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean onPrepareActionMode(a a, Menu menu)
    {
        return mWrapped.onPrepareActionMode(a, menu);
    }

    public (b b1)
    {
        this$0 = AppCompatDelegateImplV7.this;
        super();
        mWrapped = b1;
    }
}
