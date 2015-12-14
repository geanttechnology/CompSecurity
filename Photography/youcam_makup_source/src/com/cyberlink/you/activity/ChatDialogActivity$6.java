// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.os.AsyncTask;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.d;
import com.cyberlink.you.e;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a extends AsyncTask
{

    final List a;
    final ChatDialogActivity b;

    protected transient Group a(Void avoid[])
    {
        if (a == null || a.isEmpty())
        {
            return null;
        } else
        {
            return e.f().a(a);
        }
    }

    public void a(Group group)
    {
        ChatDialogActivity.a(b, group);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    public void onPostExecute(Object obj)
    {
        a((Group)obj);
    }

    (ChatDialogActivity chatdialogactivity, List list)
    {
        b = chatdialogactivity;
        a = list;
        super();
    }
}
