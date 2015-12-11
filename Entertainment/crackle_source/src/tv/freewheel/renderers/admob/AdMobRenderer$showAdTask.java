// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.admob;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.google.ads.AdView;
import com.google.ads.InterstitialAd;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.admob:
//            AdMobRenderer, Parameters

private class <init>
    implements Runnable
{

    final AdMobRenderer this$0;

    public void run()
    {
        if (AdMobRenderer.access$100(AdMobRenderer.this) instanceof AdView)
        {
            final AdView adView = (AdView)AdMobRenderer.access$100(AdMobRenderer.this);
            if (AdMobRenderer.access$200(AdMobRenderer.this).getType() != AdMobRenderer.access$300(AdMobRenderer.this).SLOT_TYPE_TEMPORAL())
            {
                AdMobRenderer.access$400(AdMobRenderer.this).debug("Show display banner");
                android.widget.ms ms = new android.widget.ms(-2, -2);
                ms.addRule(13);
                AdMobRenderer.access$200(AdMobRenderer.this).getBase().addView(adView, ms);
            } else
            {
                android.widget.er er = new android.widget.<init>(-2, -2);
                if (AdMobRenderer.access$200(AdMobRenderer.this).getTimePositionClass() == AdMobRenderer.access$300(AdMobRenderer.this).TIME_POSITION_CLASS_OVERLAY())
                {
                    AdMobRenderer.access$400(AdMobRenderer.this).debug((new StringBuilder()).append("Show overlay banner, primaryAnchor ").append(AdMobRenderer.access$500(AdMobRenderer.this).primaryAnchor).append(", marginWidth ").append(AdMobRenderer.access$500(AdMobRenderer.this).marginWidth).append(", marginHeight ").append(AdMobRenderer.access$500(AdMobRenderer.this).marginHeight).toString());
                    er.gravity = 0;
                    if (AdMobRenderer.access$500(AdMobRenderer.this).primaryAnchor.contains("t"))
                    {
                        er.gravity = er.gravity | 0x30;
                        er.topMargin = AdMobRenderer.access$500(AdMobRenderer.this).marginHeight;
                    }
                    if (AdMobRenderer.access$500(AdMobRenderer.this).primaryAnchor.contains("l"))
                    {
                        er.gravity = er.gravity | 3;
                        er.leftMargin = AdMobRenderer.access$500(AdMobRenderer.this).marginWidth;
                    }
                    if (AdMobRenderer.access$500(AdMobRenderer.this).primaryAnchor.contains("r"))
                    {
                        er.gravity = er.gravity | 5;
                        er.rightMargin = AdMobRenderer.access$500(AdMobRenderer.this).marginWidth;
                    }
                    if (AdMobRenderer.access$500(AdMobRenderer.this).primaryAnchor.contains("b"))
                    {
                        er.gravity = er.gravity | 0x50;
                        er.bottomMargin = AdMobRenderer.access$500(AdMobRenderer.this).marginHeight;
                    }
                    if (AdMobRenderer.access$500(AdMobRenderer.this).primaryAnchor.contains("c"))
                    {
                        er.gravity = er.gravity | 1;
                    }
                    if (AdMobRenderer.access$500(AdMobRenderer.this).primaryAnchor.contains("m"))
                    {
                        er.gravity = er.gravity | 0x10;
                    }
                    if (AdMobRenderer.access$500(AdMobRenderer.this).primaryAnchor == "c" || AdMobRenderer.access$500(AdMobRenderer.this).primaryAnchor == "m" || AdMobRenderer.access$500(AdMobRenderer.this).primaryAnchor == "cm" || AdMobRenderer.access$500(AdMobRenderer.this).primaryAnchor == "mc")
                    {
                        er.gravity = 17;
                    }
                    AdMobRenderer.access$200(AdMobRenderer.this).getBase().setOnHierarchyChangeListener(new android.view.ViewGroup.OnHierarchyChangeListener() {

                        final AdMobRenderer.showAdTask this$1;
                        final AdView val$adView;

                        public void onChildViewAdded(View view, View view1)
                        {
                            (new Handler(AdMobRenderer.access$600(this$0).getActivity().getMainLooper())).post(new Runnable() {

                                final _cls1 this$2;

                                public void run()
                                {
                                    adView.bringToFront();
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                        }

                        public void onChildViewRemoved(View view, View view1)
                        {
                        }

            
            {
                this$1 = AdMobRenderer.showAdTask.this;
                adView = adview;
                super();
            }
                    });
                } else
                {
                    AdMobRenderer.access$400(AdMobRenderer.this).debug("Show preroll/midroll/postroll banner");
                    er.gravity = 17;
                }
                AdMobRenderer.access$200(AdMobRenderer.this).getBase().addView(adView, er);
            }
            adView.setVisibility(0);
            adView.bringToFront();
        } else
        {
            ((InterstitialAd)AdMobRenderer.access$100(AdMobRenderer.this)).show();
        }
        AdMobRenderer.access$600(AdMobRenderer.this).dispatchEvent(AdMobRenderer.access$300(AdMobRenderer.this).EVENT_AD_STARTED());
    }

    private _cls1.val.adView()
    {
        this$0 = AdMobRenderer.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
