// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.os.AsyncTask;
import com.cyberlink.you.chat.UnreadCountManager;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.d;
import com.cyberlink.you.e;
import com.cyberlink.you.utility.i;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity, e

class b extends AsyncTask
{

    final boolean a;
    final Group b;
    final ChatDialogActivity c;

    protected transient Void a(Void avoid[])
    {
        Thread.currentThread().setName("updateLastRead");
        avoid = new ArrayList();
        if (a)
        {
            avoid.add("DraftText");
        }
        if (ChatDialogActivity.a(c) != null && ChatDialogActivity.a(c).a() > 0)
        {
            b.k = ChatDialogActivity.a(c).b(ChatDialogActivity.a(c).a() - 1).d().getTime();
            avoid.add("LastRead");
        }
        e.f().a(String.valueOf(b.b), b, avoid);
        UnreadCountManager.b().a(b.c);
        i.a(String.valueOf(b.b));
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    (ChatDialogActivity chatdialogactivity, boolean flag, Group group)
    {
        c = chatdialogactivity;
        a = flag;
        b = group;
        super();
    }
}
