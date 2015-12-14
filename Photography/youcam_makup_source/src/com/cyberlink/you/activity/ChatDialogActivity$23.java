// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.f;
import com.cyberlink.you.database.g;
import com.cyberlink.you.e;
import java.util.Collections;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity, e

class a extends AsyncTask
{

    final ChatDialogActivity a;

    protected transient List a(Void avoid[])
    {
        Object obj;
        long l;
        obj = null;
        Thread.currentThread().setName("messageQueryTask");
        l = System.currentTimeMillis();
        avoid = obj;
        if (ChatDialogActivity.a(a) == null) goto _L2; else goto _L1
_L1:
        avoid = obj;
        if (ChatDialogActivity.a(a).isEmpty()) goto _L2; else goto _L3
_L3:
        int i = 0;
_L6:
        if (i >= ChatDialogActivity.a(a).getCount())
        {
            break MISSING_BLOCK_LABEL_195;
        }
        if (ChatDialogActivity.a(a).b(i).e() == com.cyberlink.you.database..g) goto _L5; else goto _L4
_L4:
        avoid = ChatDialogActivity.a(a).b(i);
_L7:
        avoid = e.d().a(String.valueOf(ChatDialogActivity.b(a).b), String.valueOf(avoid.d().getTime()));
_L2:
        if (avoid != null)
        {
            Collections.sort(avoid, new g());
        }
        Log.d("ChatDialogActivity", (new StringBuilder()).append("query message list ").append(String.valueOf((new StringBuilder()).append(System.currentTimeMillis() - l).append(" ms").toString())).toString());
        return avoid;
_L5:
        i++;
          goto _L6
        avoid = null;
          goto _L7
    }

    protected void a(List list)
    {
        if (list == null)
        {
            return;
        }
        if (!list.isEmpty() && ChatDialogActivity.a(a) != null)
        {
            int i = ChatDialogActivity.a(a).getCount();
            ChatDialogActivity.a(a).a(list, false);
            int j = ChatDialogActivity.a(a).getCount();
            ChatDialogActivity.c(a).setSelection(j - i);
        }
        ChatDialogActivity.a(a, null);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((List)obj);
    }

    (ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }
}
