// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.view.Menu;
import android.view.MenuItem;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.controllers.AddTagFollowingController;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.RemoveTagFollowingController;
import com.socialin.android.apiv3.request.ParamWithTagName;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.picsart.profile.util.y;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            m

public class TagPhotosActivity extends BaseActivity
{

    private static final String c = com/socialin/android/picsart/profile/activity/TagPhotosActivity.getSimpleName();
    protected String a;
    protected boolean b;
    private BaseSocialinApiRequestController d;
    private BaseSocialinApiRequestController e;
    private boolean f;

    public TagPhotosActivity()
    {
        b = true;
        d = new AddTagFollowingController();
        e = new RemoveTagFollowingController();
        f = false;
    }

    static boolean a(TagPhotosActivity tagphotosactivity)
    {
        return tagphotosactivity.f;
    }

    static String c()
    {
        return c;
    }

    public final void a(boolean flag)
    {
        f = flag;
        invalidateOptionsMenu();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        if (b)
        {
            MenuItem menuitem;
            int i;
            if (f)
            {
                i = 0x7f0805c4;
            } else
            {
                i = 0x7f0805b5;
            }
            menuitem = menu.add(0, 1, 0, getString(i));
            if (f)
            {
                i = 0x7f020223;
            } else
            {
                i = 0x7f020224;
            }
            menuitem.setIcon(i).setShowAsAction(2);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 1)
        {
            if (y.c(this))
            {
                boolean flag;
                if (f)
                {
                    AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.TagUnFavoriteEvent("tag_page", a));
                } else
                {
                    AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.TagFavoriteEvent("tag_page", a));
                }
                d.cancelRequest(c);
                e.cancelRequest(c);
                if (f)
                {
                    menuitem = e;
                } else
                {
                    menuitem = d;
                }
                if (!f)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                a(flag);
                ((ParamWithTagName)menuitem.getRequestParams()).tagName = a;
                menuitem.setRequestCompleteListener(new m(this, (byte)0));
                menuitem.doRequest(c);
            }
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        MenuItem menuitem = menu.findItem(1);
        if (menuitem != null)
        {
            int i;
            if (f)
            {
                i = 0x7f0805c4;
            } else
            {
                i = 0x7f0805b5;
            }
            menuitem.setTitle(getString(i));
            if (f)
            {
                i = 0x7f020223;
            } else
            {
                i = 0x7f020224;
            }
            menuitem.setIcon(i);
        }
        return super.onPrepareOptionsMenu(menu);
    }

}
