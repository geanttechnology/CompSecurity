// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.View;
import com.cyberlink.you.c.c;
import com.cyberlink.you.c.d;
import com.cyberlink.you.sticker.StickerObj;
import com.rockerhieu.emojicon.emoji.Emojicon;
import java.util.Map;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a
    implements d
{

    final ChatDialogActivity a;

    public void a(String s, Map map)
    {
        if (!s.equals("sendText") && !s.equals("sendPhoto") && !s.equals("sendSticker") && !s.equals("scheduleSend") && !s.equals("selfDestruct")) goto _L2; else goto _L1
_L1:
        if (!map.containsKey("text")) goto _L4; else goto _L3
_L3:
        s = (String)map.get("text");
        if (ChatDialogActivity.n(a).getVisibility() != 8) goto _L6; else goto _L5
_L5:
        ChatDialogActivity.a(a, s);
_L8:
        return;
_L6:
        ChatDialogActivity.b(a, s);
        return;
_L4:
        if (map.containsKey("sticer"))
        {
            s = ((String) (map.get("sticer")));
            if (s instanceof StickerObj)
            {
                a.a((StickerObj)s);
                return;
            }
            if (s instanceof Emojicon)
            {
                ChatDialogActivity.o(a).a((Emojicon)s);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (s.equals("sendBCPost"))
        {
            s = ((String) (map.get("post")));
            if (s instanceof String)
            {
                s = (String)s;
                com.cyberlink.you.activity.ChatDialogActivity.c(a, s);
                return;
            }
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    (ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }
}
