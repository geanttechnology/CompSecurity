// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.LongSparseArray;
import android.view.View;
import com.cyberlink.you.database.o;
import com.cyberlink.you.e;
import com.cyberlink.you.g;
import com.cyberlink.you.utility.d;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            SelectUsersActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        d.a(SelectUsersActivity.m(a.a), false);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/you/activity/SelectUsersActivity$4

/* anonymous class */
    class SelectUsersActivity._cls4
        implements android.view.View.OnClickListener
    {

        final SelectUsersActivity a;

        public void onClick(View view)
        {
            SelectUsersActivity.m(a).runOnUiThread(new SelectUsersActivity._cls4._cls1(this));
            view = new Intent();
            Bundle bundle = new Bundle();
            ArrayList arraylist = new ArrayList(com.cyberlink.you.activity.SelectUsersActivity.d(a).size());
            int i = 0;
            while (i < com.cyberlink.you.activity.SelectUsersActivity.d(a).size()) 
            {
                long l = com.cyberlink.you.activity.SelectUsersActivity.d(a).keyAt(i);
                if (!SelectUsersActivity.a(a, l))
                {
                    continue;
                }
                com.cyberlink.you.friends.Friend friend = e.g().a(String.valueOf(l));
                boolean flag;
                if (SelectUsersActivity.a(a) != null && SelectUsersActivity.a(a).contains(friend))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (friend != null && !flag)
                {
                    arraylist.add(friend);
                }
                i++;
            }
            long l1 = g.a().g().longValue();
            arraylist.add(e.g().a(String.valueOf(l1)));
            bundle.putParcelableArrayList("INTENT_RESULT_SELECTED_USERS_LIST", arraylist);
            view.putExtras(bundle);
            a.setResult(-1, view);
            a.finish();
        }

            
            {
                a = selectusersactivity;
                super();
            }
    }

}
