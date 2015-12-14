// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import com.cyberlink.you.g;
import com.cyberlink.you.utility.w;
import com.cyberlink.you.widgetpool.common.CLFragmentTabHost;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.cyberlink.you.activity:
//            StickerShopAcitvity, u

class t extends AsyncTask
{

    final StickerShopAcitvity a;

    private t(StickerShopAcitvity stickershopacitvity)
    {
        a = stickershopacitvity;
        super();
    }

    t(StickerShopAcitvity stickershopacitvity, StickerShopAcitvity._cls1 _pcls1)
    {
        this(stickershopacitvity);
    }

    protected transient Long a(Void avoid[])
    {
        if (isCancelled())
        {
            return null;
        } else
        {
            Log.v("StickerShopAcitvity", "checkNewSticker");
            return Long.valueOf(w.a());
        }
    }

    protected void a(Long long1)
    {
        if (StickerShopAcitvity.b(a))
        {
            Log.v("StickerShopAcitvity", "Destorying, checkNewSticker cancel");
            return;
        }
        long l = g.a().w();
        boolean flag;
        if (long1.longValue() > l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            g.a().b(long1.longValue());
            g.a().b(true);
            g.a().a(true);
        }
        StickerShopAcitvity.b().set(false);
        long1 = null;
        if (StickerShopAcitvity.c(a).getCurrentTab() != 0) goto _L2; else goto _L1
_L1:
        long1 = (u)a.getSupportFragmentManager().findFragmentByTag("Top");
_L4:
        if (long1 != null)
        {
            long1.a(flag);
        }
        Log.v("StickerShopAcitvity", "checkNewSticker done");
        return;
_L2:
        if (StickerShopAcitvity.c(a).getCurrentTab() == 1)
        {
            long1 = (u)a.getSupportFragmentManager().findFragmentByTag("New");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void b(Long long1)
    {
        Log.v("StickerShopAcitvity", "checkNewSticker cancel");
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onCancelled(Object obj)
    {
        b((Long)obj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Long)obj);
    }
}
