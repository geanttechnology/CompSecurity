// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.Manage;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.flurry.android.FlurryAgent;
import com.fotoable.fotovariant.nativeAds.FotoNativeIcon;
import com.wantu.model.res.TResInfo;
import fr;
import ja;
import java.util.HashMap;
import jc;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.Manage:
//            OnlineGridViewAdapter

class c
    implements ja
{

    final TResInfo a;
    final View b;
    final ImageView c;
    final OnlineGridViewAdapter d;

    public void adIconFailed()
    {
        FlurryAgent.logEvent("FBNatice_PIPResIcon_Failed");
    }

    public void adIconLoaded(FotoNativeIcon fotonativeicon)
    {
        if (OnlineGridViewAdapter.access$000(d) != null)
        {
            (new Handler(OnlineGridViewAdapter.access$000(d).getMainLooper())).post(new Runnable(fotonativeicon) {

                final FotoNativeIcon a;
                final OnlineGridViewAdapter._cls2 b;

                public void run()
                {
                    b.a.icon = a.nativeItem.b();
                    OnlineGridViewAdapter.access$100(b.d).put(b.a, a.nativeItem);
                    a.nativeItem.a(b.b);
                    if (OnlineGridViewAdapter.access$200(b.d) != null)
                    {
                        OnlineGridViewAdapter.access$200(b.d).a(b.a, b.c);
                    }
                    FlurryAgent.logEvent("FBNatice_PIPResIcon_loaded");
                }

            
            {
                b = OnlineGridViewAdapter._cls2.this;
                a = fotonativeicon;
                super();
            }
            });
        }
        Log.e("SectionedAdapter", "SectionedAdapter fbnative ad loaded");
    }

    _cls1.a(OnlineGridViewAdapter onlinegridviewadapter, TResInfo tresinfo, View view, ImageView imageview)
    {
        d = onlinegridviewadapter;
        a = tresinfo;
        b = view;
        c = imageview;
        super();
    }
}
