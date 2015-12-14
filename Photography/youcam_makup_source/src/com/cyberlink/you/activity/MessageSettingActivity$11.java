// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.os.AsyncTask;
import com.cyberlink.you.database.o;
import com.cyberlink.you.e;
import com.cyberlink.you.friends.Friend;

// Referenced classes of package com.cyberlink.you.activity:
//            MessageSettingActivity, n

class a extends AsyncTask
{

    final Friend a;
    final MessageSettingActivity b;

    protected transient Void a(Void avoid[])
    {
        a.d = true;
        e.g().a(String.valueOf(a.a), a, "IsBlocked");
        return null;
    }

    public void a(Void void1)
    {
        if (MessageSettingActivity.h(b) != null)
        {
            MessageSettingActivity.h(b).notifyDataSetChanged();
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    public void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    (MessageSettingActivity messagesettingactivity, Friend friend)
    {
        b = messagesettingactivity;
        a = friend;
        super();
    }
}
