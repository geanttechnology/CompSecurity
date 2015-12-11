// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.util.LongSparseArray;
import co.vine.android.api.VineRTCConversation;
import co.vine.android.api.VineRTCParticipant;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.Util;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            HomeTabActivity, SettingsActivity

class this._cls0 extends AppSessionListener
{

    final HomeTabActivity this$0;

    public void onAbortAllRequestsComplete()
    {
        super.onAbortAllRequestsComplete();
        mAppController.fetchActivityCounts();
    }

    public void onGetMessageCountComplete(String s, int i, String s1, int j)
    {
label0:
        {
            if (i == 200)
            {
                s = Util.getDefaultSharedPrefs(HomeTabActivity.this);
                i = s.getInt("pref_mrumc", 0);
                if (!s.getBoolean("pref_dismissed", false))
                {
                    break label0;
                }
                if (i != j)
                {
                    s.edit()._mth0("pref_dismissed", false)._mth0();
                    HomeTabActivity.access$102(HomeTabActivity.this, j);
                    HomeTabActivity.access$200(HomeTabActivity.this);
                }
            }
            return;
        }
        HomeTabActivity.access$102(HomeTabActivity.this, j);
        HomeTabActivity.access$200(HomeTabActivity.this);
    }

    public void onGetPendingNotificationCountComplete(String s, int i, String s1, int j)
    {
        if (i == 200)
        {
            HomeTabActivity.access$002(HomeTabActivity.this, j);
            invalidateActivityBadge();
        }
    }

    public void onReceiveRTCMessage(ArrayList arraylist)
    {
        for (arraylist = arraylist.iterator(); arraylist.hasNext();)
        {
            VineRTCConversation vinertcconversation = (VineRTCConversation)arraylist.next();
            Iterator iterator = vinertcconversation.participants.iterator();
            while (iterator.hasNext()) 
            {
                VineRTCParticipant vinertcparticipant = (VineRTCParticipant)iterator.next();
                long l = vinertcparticipant.lastMessageId;
                if (l > 0L)
                {
                    Long long1 = (Long)HomeTabActivity.access$500(HomeTabActivity.this).get(vinertcparticipant.userId);
                    if (long1 != null && l > long1.longValue())
                    {
                        mAppController.fetchConversation(1, false, vinertcconversation.conversationId, 0L, true);
                        if (!getSlidingMenu().isMenuShowing())
                        {
                            mAppController.fetchActivityCounts();
                        }
                    } else
                    {
                        HomeTabActivity.access$500(HomeTabActivity.this).put(vinertcparticipant.userId, Long.valueOf(l));
                    }
                }
            }
        }

    }

    public void onVerifyEmailComplete(String s, int i, String s1)
    {
        if (i == 200)
        {
            s = new Intent(HomeTabActivity.this, co/vine/android/SettingsActivity);
            s.setAction(HomeTabActivity.ACTION_VERIFICATION_COMPLETE);
            startActivityForResult(s, 1);
        } else
        {
            s = getApplicationContext();
            if (s1 == null)
            {
                s1 = getString(0x7f0e0105);
            }
            Util.showCenteredToast(s, s1);
        }
        dismissDialog();
    }

    ()
    {
        this$0 = HomeTabActivity.this;
        super();
    }
}
