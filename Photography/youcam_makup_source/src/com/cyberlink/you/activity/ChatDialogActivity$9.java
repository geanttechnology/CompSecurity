// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import com.cyberlink.you.b.c;
import com.cyberlink.you.chat.b;
import com.cyberlink.you.database.Group;
import java.util.Map;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a
    implements c
{

    final ChatDialogActivity a;

    public boolean a(b b1, Map map)
    {
        String s;
        String s1;
        String s2;
        if (b1 != null)
        {
            s1 = b1.i();
            s = b1.o();
        } else
        {
            s = null;
            s1 = null;
        }
        s2 = (String)map.get("eventType");
        if (!s2.equals("group.group.created") && !s2.equals("group.group.updated") && !s2.equals("group.member.leaved") && !s2.equals("group.member.created") && !s2.equals("group.member.deleted") && !s2.equals("media.media.created") && !s2.equals("group.admin.created") && !s2.equals("group.admin.deleted") && !s2.equals("media.album.created") && !s2.equals("media.media.deleted") && !s2.equals("media.album.deleted") && !s2.equals("group.display.name.updated")) goto _L2; else goto _L1
_L1:
        ChatDialogActivity.a(a, s2, (String)map.get("groupId"), (String)map.get("userId"), s1);
_L4:
        return true;
_L2:
        if (!s2.equals("chat.message.recalled"))
        {
            if (s2.equals("user.display.name.updated") || s2.equals("user.avatar.updated") || s2.equals("user.status.updated") || s2.equals("user.coverart.updated"))
            {
                ChatDialogActivity.d(a, s);
            } else
            if (s2.equals("friend.friend.unblocked") || s2.equals("friend.friend.blocked"))
            {
                ChatDialogActivity.e(a, (String)map.get("userId"));
            } else
            if (s2.equals("group.group.disabled") || s2.equals("group.group.enabled"))
            {
                ChatDialogActivity.f(a, (String)map.get("groupId"));
            } else
            if (s2.equals("friend.friend.broke.up") && com.cyberlink.you.activity.ChatDialogActivity.b(a).e.equals("Dual") && com.cyberlink.you.activity.ChatDialogActivity.b(a).c.equals(b1.o()))
            {
                a.finish();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    (ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }
}
