// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.flyinmenu;

import android.content.Intent;
import android.os.Handler;
import android.view.MenuItem;
import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.xfinity.playerlib.view.search.SearchActivity;
import com.xfinity.playerlib.view.search.SearchResultsFragment;

// Referenced classes of package com.xfinity.playerlib.view.flyinmenu:
//            PlayNowFlyinMenuActivity

class this._cls1
    implements Runnable
{

    final lidateOptionsMenu this$1;

    public void run()
    {
        invalidateOptionsMenu();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6

/* anonymous class */
    class PlayNowFlyinMenuActivity._cls6
        implements android.view.MenuItem.OnActionExpandListener
    {

        final PlayNowFlyinMenuActivity this$0;

        public boolean onMenuItemActionCollapse(MenuItem menuitem)
        {
            exitSearchMode();
            PlayNowFlyinMenuActivity.access$402(PlayNowFlyinMenuActivity.this, false);
            searchResultsFragment.onMenuItemActionCollapse(menuitem);
            PlayNowFlyinMenuActivity.access$500(PlayNowFlyinMenuActivity.this).post(new PlayNowFlyinMenuActivity._cls6._cls2());
            menuitem.setTitle(com.xfinity.playerlib.R.string.search);
            getTalkDelegate().stopSpeaking();
            return true;
        }

        public boolean onMenuItemActionExpand(MenuItem menuitem)
        {
            if (PlayNowFlyinMenuActivity.access$100(PlayNowFlyinMenuActivity.this).isAccessibilityEnabled())
            {
                menuitem = new Intent(PlayNowFlyinMenuActivity.this, com/xfinity/playerlib/view/search/SearchActivity);
                menuitem.putExtra("KEY_SHOW_KEYBOARD_ON_START", true);
                startActivityForResult(menuitem, 0);
                return false;
            }
            if (!PlayNowFlyinMenuActivity.access$400(PlayNowFlyinMenuActivity.this))
            {
                PlayNowFlyinMenuActivity.access$402(PlayNowFlyinMenuActivity.this, true);
                PlayNowFlyinMenuActivity.access$500(PlayNowFlyinMenuActivity.this).post(new PlayNowFlyinMenuActivity._cls6._cls1());
            }
            enterSearchMode();
            searchResultsFragment.onMenuItemActionExpand(menuitem);
            return true;
        }

            
            {
                this$0 = PlayNowFlyinMenuActivity.this;
                super();
            }

        // Unreferenced inner class com/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6$1

/* anonymous class */
        class PlayNowFlyinMenuActivity._cls6._cls1
            implements Runnable
        {

            final PlayNowFlyinMenuActivity._cls6 this$1;

            public void run()
            {
                invalidateOptionsMenu();
            }

                    
                    {
                        this$1 = PlayNowFlyinMenuActivity._cls6.this;
                        super();
                    }
        }

    }

}
