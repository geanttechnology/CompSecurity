// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.admob;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import com.google.ads.AdView;
import tv.freewheel.renderers.interfaces.IRendererContext;

// Referenced classes of package tv.freewheel.renderers.admob:
//            AdMobRenderer

class val.adView
    implements android.view.Listener
{

    final val.adView this$1;
    final AdView val$adView;

    public void onChildViewAdded(View view, View view1)
    {
        (new Handler(AdMobRenderer.access$600(_fld0).getActivity().getMainLooper())).post(new Runnable() {

            final AdMobRenderer.showAdTask._cls1 this$2;

            public void run()
            {
                adView.bringToFront();
            }

            
            {
                this$2 = AdMobRenderer.showAdTask._cls1.this;
                super();
            }
        });
    }

    public void onChildViewRemoved(View view, View view1)
    {
    }

    _cls1.this._cls2()
    {
        this$1 = final__pcls2;
        val$adView = AdView.this;
        super();
    }
}
