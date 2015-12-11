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

class this._cls0
    implements android.view.ener
{

    final PlayNowFlyinMenuActivity this$0;

    public boolean onMenuItemActionCollapse(MenuItem menuitem)
    {
        exitSearchMode();
        PlayNowFlyinMenuActivity.access$402(PlayNowFlyinMenuActivity.this, false);
        searchResultsFragment.onMenuItemActionCollapse(menuitem);
        PlayNowFlyinMenuActivity.access$500(PlayNowFlyinMenuActivity.this).post(new Runnable() {

            final PlayNowFlyinMenuActivity._cls6 this$1;

            public void run()
            {
                invalidateOptionsMenu();
            }

            
            {
                this$1 = PlayNowFlyinMenuActivity._cls6.this;
                super();
            }
        });
        menuitem.setTitle(com.xfinity.playerlib.MenuActivity._fld6);
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
            PlayNowFlyinMenuActivity.access$500(PlayNowFlyinMenuActivity.this).post(new Runnable() {

                final PlayNowFlyinMenuActivity._cls6 this$1;

                public void run()
                {
                    invalidateOptionsMenu();
                }

            
            {
                this$1 = PlayNowFlyinMenuActivity._cls6.this;
                super();
            }
            });
        }
        enterSearchMode();
        searchResultsFragment.onMenuItemActionExpand(menuitem);
        return true;
    }

    _cls2.this._cls1()
    {
        this$0 = PlayNowFlyinMenuActivity.this;
        super();
    }
}
