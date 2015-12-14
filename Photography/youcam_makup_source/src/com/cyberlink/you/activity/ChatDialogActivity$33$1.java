// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.Activity;
import android.util.Log;
import android.widget.ImageView;
import com.cyberlink.you.database.o;
import com.cyberlink.you.e;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.friends.p;
import com.cyberlink.you.utility.LoadImageUtils;
import com.cyberlink.you.utility.h;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a
    implements Runnable
{

    final Friend a;
    final b b;

    public void run()
    {
        LoadImageUtils.a(b.b, a, b.b);
    }

    ( , Friend friend)
    {
        b = ;
        a = friend;
        super();
    }

    // Unreferenced inner class com/cyberlink/you/activity/ChatDialogActivity$33

/* anonymous class */
    class ChatDialogActivity._cls33
        implements p
    {

        final ImageView a;
        final ChatDialogActivity b;

        public void a(String s, String s1, String s2, String s3)
        {
            if (s2 == null)
            {
                Log.d("ChatDialogActivity", "Response is null");
                return;
            }
            if (!s2.equals("200"))
            {
                Log.d("ChatDialogActivity", (new StringBuilder()).append("statusCode=").append(s2).toString());
                return;
            } else
            {
                s = h.a(h.a(s3));
                e.g().a(s);
                ChatDialogActivity.g(b).runOnUiThread(new ChatDialogActivity._cls33._cls1(this, s));
                return;
            }
        }

            
            {
                b = chatdialogactivity;
                a = imageview;
                super();
            }
    }

}
