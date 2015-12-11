// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.magicpiano;

import android.text.TextUtils;
import com.smule.android.c.f;
import com.smule.android.network.core.NetworkResponseCallback;
import com.smule.android.network.core.o;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.magicpiano.ProductListFragment;
import com.smule.pianoandroid.utils.q;

// Referenced classes of package com.smule.magicpiano:
//            PianoCoreBridge

final class 
    implements NetworkResponseCallback
{

    public void handleResponse(o o1)
    {
        if (o1.a())
        {
            f f1;
            String s;
            if (!TextUtils.isEmpty(ProductListFragment.a))
            {
                o1 = ProductListFragment.a;
            } else
            {
                o1 = "n/a";
            }
            s = PianoCoreBridge.getSong().songId;
            if (PianoCoreBridge.sJoin)
            {
                f1 = f.e;
            } else
            {
                f1 = f.a;
            }
            q.c(s, o1, f1);
        }
    }

    public volatile void handleResponse(Object obj)
    {
        handleResponse((o)obj);
    }

    ()
    {
    }
}
