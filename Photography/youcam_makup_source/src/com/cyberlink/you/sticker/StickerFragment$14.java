// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.app.Activity;
import android.util.Log;
import com.cyberlink.you.database.m;
import com.cyberlink.you.e;
import com.cyberlink.you.friends.p;
import com.cyberlink.you.utility.h;

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
            s = h.a(h.b(s3), false, true);
            if (s != null)
            {
                e.i().a(s);
            }
            s = a.getActivity();
            if (s != null)
            {
                s.runOnUiThread(new Runnable() {

                    final StickerFragment._cls14 a;

                    public void run()
                    {
                        StickerFragment.r(a.a);
                    }

            
            {
                a = StickerFragment._cls14.this;
                super();
            }
                });
                return;
            }
        }
    }

    _cls1.a(StickerFragment stickerfragment)
    {
        a = stickerfragment;
        super();
    }
}
