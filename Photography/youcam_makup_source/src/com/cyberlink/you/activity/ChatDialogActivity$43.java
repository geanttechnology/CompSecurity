// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import com.cyberlink.you.database.StickerPackObj;
import com.cyberlink.you.database.l;
import com.cyberlink.you.database.m;
import com.cyberlink.you.e;
import com.cyberlink.you.sticker.StickerObj;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a
    implements Runnable
{

    final int a;
    final ChatDialogActivity b;

    public void run()
    {
        List list;
        int j;
        int k;
        Thread.currentThread().setName("auto send sticker");
        list = e.i().a();
        k = 1;
        j = 0;
_L9:
        if (k > list.size()) goto _L2; else goto _L1
_L1:
        List list1;
        int i;
        list1 = e.h().b(((StickerPackObj)list.get(k - 1)).b());
        i = j;
        if (list1 == null) goto _L4; else goto _L3
_L3:
        int i1 = 1;
_L7:
        i = j;
        if (i1 >= list1.size()) goto _L4; else goto _L5
_L5:
        i = j + 1;
        b.runOnUiThread(new Runnable(list1, i1 - 1) {

            final List a;
            final int b;
            final ChatDialogActivity._cls43 c;

            public void run()
            {
                c.b.a((StickerObj)a.get(b));
            }

            
            {
                c = ChatDialogActivity._cls43.this;
                a = list;
                b = i;
                super();
            }
        });
        try
        {
            Thread.sleep(ChatDialogActivity.j(b));
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        if (i < a) goto _L6; else goto _L4
_L4:
        k++;
        j = i;
        continue; /* Loop/switch isn't completed */
_L6:
        i1++;
        j = i;
        if (true) goto _L7; else goto _L2
_L2:
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    _cls1.b(ChatDialogActivity chatdialogactivity, int i)
    {
        b = chatdialogactivity;
        a = i;
        super();
    }
}
