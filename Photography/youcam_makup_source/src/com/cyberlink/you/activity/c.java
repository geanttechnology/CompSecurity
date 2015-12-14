// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import com.cyberlink.you.database.StickerPackObj;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.g;
import com.cyberlink.you.utility.h;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity, g

class c extends AsyncTask
{

    final ChatDialogActivity a;
    private long b;
    private com.cyberlink.you.activity.g c;

    public c(ChatDialogActivity chatdialogactivity, long l1, com.cyberlink.you.activity.g g1)
    {
        a = chatdialogactivity;
        super();
        b = l1;
        c = g1;
    }

    protected transient StickerPackObj a(Void avoid[])
    {
        Thread.currentThread().setName("RecvSticker AsyncTask");
        avoid = new ArrayList();
        avoid.add(new BasicNameValuePair("token", g.a().e()));
        avoid.add(new BasicNameValuePair("packId", String.valueOf(b)));
        avoid = a.a.a("sticker", "pack.info", avoid);
        String s = (String)((Pair) (avoid)).first;
        if (s == null || !s.equals("200"))
        {
            Log.d("ChatDialogActivity", (new StringBuilder()).append("statusCode = ").append(s).toString());
            return null;
        }
        avoid = h.a(h.b((String)((Pair) (avoid)).second), false, false);
        if (avoid == null || avoid.size() == 0)
        {
            return null;
        } else
        {
            return (StickerPackObj)avoid.get(0);
        }
    }

    protected void a(StickerPackObj stickerpackobj)
    {
        c.a(stickerpackobj);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((StickerPackObj)obj);
    }
}
