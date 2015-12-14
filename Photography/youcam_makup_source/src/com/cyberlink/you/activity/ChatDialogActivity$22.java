// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.widget.ListView;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.f;
import com.cyberlink.you.database.g;
import com.cyberlink.you.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity, e

class a extends AsyncTask
{

    final Group a;
    final ChatDialogActivity b;

    protected transient Pair a(Void avoid[])
    {
        Thread.currentThread().setName("resetMessageList AsyncTask");
        long l = System.currentTimeMillis();
        avoid = e.d().a(String.valueOf(a.b), null);
        if (avoid != null)
        {
            Collections.sort(avoid, new g());
        }
        List list = e.d().d(String.valueOf(a.b));
        Log.d("ChatDialogActivity", (new StringBuilder()).append("get message list ").append(String.valueOf((new StringBuilder()).append(System.currentTimeMillis() - l).append(" ms").toString())).toString());
        return Pair.create(avoid, list);
    }

    protected void a(Pair pair)
    {
        Object obj;
        int i;
        if (pair == null)
        {
            return;
        }
        obj = (List)pair.first;
        if (obj == null)
        {
            obj = new ArrayList();
        }
        pair = (List)pair.second;
        if (pair == null)
        {
            pair = new ArrayList();
        }
        i = ((List) (obj)).size() - 1;
_L3:
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_303;
        }
        if (((MessageObj)((List) (obj)).get(i)).d().getTime() > a.k) goto _L2; else goto _L1
_L1:
        MessageObj messageobj;
        if (((List) (obj)).size() - 1 - i < 5)
        {
            break MISSING_BLOCK_LABEL_303;
        }
        messageobj = MessageObj.d(new Date(a.k));
        ((List) (obj)).add(i + 1, messageobj);
_L4:
        ChatDialogActivity.a(b).clear();
        ChatDialogActivity.a(b).a(((List) (obj)), true);
        ChatDialogActivity.a(b).a(ChatDialogActivity.I(b), true);
        ChatDialogActivity.a(b).a(pair);
        ChatDialogActivity.c(b).setOnItemClickListener(ChatDialogActivity.J(b));
        ChatDialogActivity.c(b).setAdapter(ChatDialogActivity.a(b));
        ChatDialogActivity.b(b, ChatDialogActivity.a(b).getCount() - 1);
        if (messageobj != null)
        {
            ChatDialogActivity.b(b, ChatDialogActivity.a(b).a(messageobj) - 1);
        }
        ChatDialogActivity.c(b).setSelection(ChatDialogActivity.K(b));
        b.d();
        ChatDialogActivity.L(b);
        return;
_L2:
        i--;
          goto _L3
        messageobj = null;
          goto _L4
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Pair)obj);
    }

    (ChatDialogActivity chatdialogactivity, Group group)
    {
        b = chatdialogactivity;
        a = group;
        super();
    }
}
