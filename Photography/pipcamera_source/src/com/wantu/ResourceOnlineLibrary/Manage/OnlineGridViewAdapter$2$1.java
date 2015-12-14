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

class a
    implements Runnable
{

    final FotoNativeIcon a;
    final b b;

    public void run()
    {
        b.b.icon = a.nativeItem.b();
        OnlineGridViewAdapter.access$100(b.b).put(b.b, a.nativeItem);
        a.nativeItem.a(b.b);
        if (OnlineGridViewAdapter.access$200(b.b) != null)
        {
            OnlineGridViewAdapter.access$200(b.b).a(b.b, b.b);
        }
        FlurryAgent.logEvent("FBNatice_PIPResIcon_loaded");
    }

    ( , FotoNativeIcon fotonativeicon)
    {
        b = ;
        a = fotonativeicon;
        super();
    }

    // Unreferenced inner class com/wantu/ResourceOnlineLibrary/Manage/OnlineGridViewAdapter$2

/* anonymous class */
    class OnlineGridViewAdapter._cls2
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
                (new Handler(OnlineGridViewAdapter.access$000(d).getMainLooper())).post(new OnlineGridViewAdapter._cls2._cls1(this, fotonativeicon));
            }
            Log.e("SectionedAdapter", "SectionedAdapter fbnative ad loaded");
        }

            
            {
                d = onlinegridviewadapter;
                a = tresinfo;
                b = view;
                c = imageview;
                super();
            }
    }

}
