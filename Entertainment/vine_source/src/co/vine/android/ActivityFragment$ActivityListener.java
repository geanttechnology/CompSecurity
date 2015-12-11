// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.widget.BaseAdapter;
import android.widget.TextView;
import co.vine.android.api.VinePagedData;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppSessionListener;
import co.vine.android.service.GCMNotificationService;
import co.vine.android.util.Util;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            ActivityFragment, ActivityAdapter, PendingRequest, HomeTabActivity

class this._cls0 extends AppSessionListener
{

    final ActivityFragment this$0;

    public void onFollowComplete(String s, int i, String s1, long l)
    {
        if (removeRequest(s) != null && i != 200)
        {
            ((ActivityAdapter)mAdapter).unfollow(l);
        }
    }

    public void onGetActivityComplete(String s, int i, String s1, VinePagedData vinepageddata, VinePagedData vinepageddata1)
    {
        PendingRequest pendingrequest = removeRequest(s);
        if (pendingrequest != null)
        {
            hideProgress(pendingrequest.fetchType);
            s = Util.getDefaultSharedPrefs(getActivity());
            ActivityFragment.access$002(ActivityFragment.this, s.getBoolean("settings_private", false));
            int j = 0;
            int k;
            if (vinepageddata != null)
            {
                if (vinepageddata.items == null)
                {
                    j = 0;
                } else
                {
                    j = vinepageddata.items.size();
                }
            }
            k = 0;
            if (vinepageddata1 != null)
            {
                if (vinepageddata1.items == null)
                {
                    k = 0;
                } else
                {
                    k = vinepageddata1.items.size();
                }
            }
            if (mAdapter.getCount() == 0 && j == 0 && k == 0)
            {
                if (i != 200)
                {
                    mEmptyTextStringRes = 0x7f0e00d8;
                    mEmptyText.setText(mEmptyTextStringRes);
                }
                showSadface(true);
            } else
            {
                showSadface(false);
            }
            if (i == 200)
            {
                if (vinepageddata != null)
                {
                    mNextPage = vinepageddata.nextPage;
                    mAnchor = vinepageddata.anchor;
                }
                if (mAdapter != null)
                {
                    ActivityAdapter activityadapter = (ActivityAdapter)mAdapter;
                    boolean flag;
                    if (vinepageddata == null)
                    {
                        s = null;
                    } else
                    {
                        s = vinepageddata.items;
                    }
                    if (vinepageddata1 == null)
                    {
                        s1 = null;
                    } else
                    {
                        s1 = vinepageddata1.items;
                    }
                    if (pendingrequest.fetchType == 1)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    activityadapter.mergeData(s, s1, flag);
                }
            }
            s = getActivity();
            if (s != null)
            {
                s.startService(GCMNotificationService.getClearNotificationIntent(getActivity(), 1));
                ((HomeTabActivity)s).markActivitiesRead();
            }
        }
    }

    public void onGetUsersMeComplete(String s, int i, String s1, long l, VineUser vineuser)
    {
        if (vineuser != null && vineuser.isPrivate())
        {
            ActivityFragment.access$002(ActivityFragment.this, true);
        }
    }

    public void onPhotoImageLoaded(HashMap hashmap)
    {
        ((ActivityAdapter)mAdapter).setImages(hashmap);
    }

    public void onUnFollowComplete(String s, int i, String s1, long l)
    {
        if (removeRequest(s) != null && i != 200)
        {
            ((ActivityAdapter)mAdapter).follow(l);
        }
    }

    ()
    {
        this$0 = ActivityFragment.this;
        super();
    }
}
