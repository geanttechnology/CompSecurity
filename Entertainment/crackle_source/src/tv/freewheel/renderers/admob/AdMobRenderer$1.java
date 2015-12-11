// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.admob;

import android.view.ViewGroup;
import com.google.ads.AdView;
import tv.freewheel.ad.interfaces.ISlot;

// Referenced classes of package tv.freewheel.renderers.admob:
//            AdMobRenderer

class this._cls0
    implements Runnable
{

    final AdMobRenderer this$0;

    public void run()
    {
        AdView adview = (AdView)AdMobRenderer.access$100(AdMobRenderer.this);
        adview.setVisibility(8);
        AdMobRenderer.access$200(AdMobRenderer.this).getBase().removeView(adview);
    }

    ()
    {
        this$0 = AdMobRenderer.this;
        super();
    }
}
