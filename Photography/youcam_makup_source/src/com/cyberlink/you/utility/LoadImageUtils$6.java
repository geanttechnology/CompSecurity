// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.util.Log;
import com.cyberlink.you.database.l;
import com.cyberlink.you.e;
import com.cyberlink.you.sticker.StickerObj;

// Referenced classes of package com.cyberlink.you.utility:
//            g, LoadImageUtils

final class c
    implements g
{

    final boolean a;
    final StickerObj b;
    final adBitmapTask c;

    public void a()
    {
        Log.d("LoadImageUtils", "download fail");
    }

    public void a(int i)
    {
        Log.d("LoadImageUtils", (new StringBuilder()).append("download progress=").append(String.valueOf(i)).toString());
    }

    public void a(String s)
    {
        Log.d("LoadImageUtils", "download success");
        if (a)
        {
            b.b(s);
        } else
        {
            b.a(s);
        }
        e.h().a(b.b(), b);
        if (!c.getStatus().equals(android.os.RUNNING) && !c.getStatus().equals(android.os.FINISHED))
        {
            c.execute(new Object[0]);
        }
    }

    adBitmapTask(boolean flag, StickerObj stickerobj, adBitmapTask adbitmaptask)
    {
        a = flag;
        b = stickerobj;
        c = adbitmaptask;
        super();
    }
}
