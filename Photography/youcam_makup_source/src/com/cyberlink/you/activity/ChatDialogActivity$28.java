// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.os.AsyncTask;
import com.cyberlink.you.database.o;
import com.cyberlink.you.e;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.friends.l;
import java.util.Map;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a extends AsyncTask
{

    final String a;
    final ChatDialogActivity b;

    protected transient Void a(Void avoid[])
    {
        Thread.currentThread().setName("updateGroupMember4AddNewMember AsyncTask");
        avoid = b.a.a(a);
        if (avoid != null)
        {
            e.g().a(avoid);
            if (ChatDialogActivity.N(b) != null)
            {
                ChatDialogActivity.N(b).put(Long.valueOf(((Friend) (avoid)).a), avoid);
            }
        }
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    (ChatDialogActivity chatdialogactivity, String s)
    {
        b = chatdialogactivity;
        a = s;
        super();
    }
}
