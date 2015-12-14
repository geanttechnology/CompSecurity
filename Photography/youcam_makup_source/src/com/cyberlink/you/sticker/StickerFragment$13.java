// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.util.Log;
import com.cyberlink.you.friends.p;

// Referenced classes of package com.cyberlink.you.sticker:
//            StickerFragment

class a
    implements p
{

    final StickerFragment a;

    public void a(String s, String s1, String s2, String s3)
    {
        if (s2 == null)
        {
            Log.d("StickerFragment", "Response is null");
        } else
        {
            if (!s2.equals("200"))
            {
                Log.d("StickerFragment", (new StringBuilder()).append("statusCode=").append(s2).toString());
                return;
            }
            s = StickerFragment.a(a, s3);
            if (s != null)
            {
                StickerFragment.a(a, s);
                return;
            }
        }
    }

    (StickerFragment stickerfragment)
    {
        a = stickerfragment;
        super();
    }
}
