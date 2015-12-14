// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import com.cyberlink.you.database.MessageObj;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity, e

class c
    implements Runnable
{

    final String a;
    final String b;
    final MessageObj c;
    final ChatDialogActivity d;

    public void run()
    {
        if (!a.equals("group.member.leaved") && !a.equals("group.member.created") && !a.equals("group.member.deleted") && !a.equals("group.admin.created") && !a.equals("group.admin.deleted") && !a.equals("media.album.deleted") && !a.equals("group.display.name.updated")) goto _L2; else goto _L1
_L1:
        if (b != null && c != null && ChatDialogActivity.a(d) != null)
        {
            ChatDialogActivity.a(d).d(c);
        }
_L4:
        ChatDialogActivity.F(d);
        return;
_L2:
        if (a.equals("media.media.created") && ChatDialogActivity.a(d) != null)
        {
            ChatDialogActivity.a(d).notifyDataSetChanged();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    (ChatDialogActivity chatdialogactivity, String s, String s1, MessageObj messageobj)
    {
        d = chatdialogactivity;
        a = s;
        b = s1;
        c = messageobj;
        super();
    }
}
