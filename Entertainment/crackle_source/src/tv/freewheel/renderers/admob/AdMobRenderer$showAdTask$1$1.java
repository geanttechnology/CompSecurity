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

class this._cls2
    implements Runnable
{

    final l.adView this$2;

    public void run()
    {
        adView.bringToFront();
    }

    l.adView()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class tv/freewheel/renderers/admob/AdMobRenderer$showAdTask$1

/* anonymous class */
    class AdMobRenderer.showAdTask._cls1
        implements android.view.ViewGroup.OnHierarchyChangeListener
    {

        final AdMobRenderer.showAdTask this$1;
        final AdView val$adView;

        public void onChildViewAdded(View view, View view1)
        {
            (new Handler(AdMobRenderer.access$600(this$0).getActivity().getMainLooper())).post(new AdMobRenderer.showAdTask._cls1._cls1());
        }

        public void onChildViewRemoved(View view, View view1)
        {
        }

            
            {
                this$1 = final_showadtask;
                adView = AdView.this;
                super();
            }
    }

}
