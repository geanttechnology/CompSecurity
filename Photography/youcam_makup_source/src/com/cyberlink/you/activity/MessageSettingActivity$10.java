// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.os.AsyncTask;
import com.cyberlink.you.ChatListHandler;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.d;
import com.cyberlink.you.database.f;
import com.cyberlink.you.e;

// Referenced classes of package com.cyberlink.you.activity:
//            MessageSettingActivity

class a extends AsyncTask
{

    final MessageSettingActivity a;

    protected transient Void a(Void avoid[])
    {
        e.f().f(String.valueOf(MessageSettingActivity.a(a).b));
        e.d().f(String.valueOf(MessageSettingActivity.a(a).b));
        return null;
    }

    public void a(Void void1)
    {
        com.cyberlink.you.activity.MessageSettingActivity.f(a);
        ChatListHandler.b(MessageSettingActivity.a(a).b);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    public void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    (MessageSettingActivity messagesettingactivity)
    {
        a = messagesettingactivity;
        super();
    }
}
