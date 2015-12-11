// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ads;

import android.graphics.Rect;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package com.amazon.retailsearch.android.ads:
//            AdView

public class AdCache
{

    private final ArrayList ads = new ArrayList();
    private final int cacheSize = 1;
    private ListView parent;
    private final Queue readyToLoadAds = new LinkedBlockingQueue();
    private final Queue readyToShowAds = new LinkedBlockingQueue();
    private final Queue showingAds = new LinkedBlockingQueue(1);

    public AdCache()
    {
    }

    private void resetShowingAds()
    {
        Object obj = new ArrayList();
        Rect rect = new Rect();
        parent.getHitRect(rect);
        Iterator iterator = showingAds.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AdView adview1 = (AdView)iterator.next();
            int ai[] = new int[2];
            adview1.getLocationOnScreen(ai);
            if (ai[1] >= rect.bottom || ai[0] == 0 && ai[1] == 0)
            {
                ((ArrayList) (obj)).add(adview1);
            }
        } while (true);
        AdView adview;
        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); readyToLoadAds.offer(adview))
        {
            adview = (AdView)((Iterator) (obj)).next();
            showingAds.remove(adview);
        }

        reloadAds();
    }

    public AdView getNextAdView()
    {
        AdView adview = (AdView)readyToShowAds.poll();
        if (adview != null && !showingAds.offer(adview))
        {
            AdView adview1 = (AdView)showingAds.poll();
            readyToLoadAds.offer(adview1);
            showingAds.offer(adview);
        }
        return adview;
    }

    public void prepareCache(ListView listview, Set set)
    {
        if (parent != null)
        {
            resetShowingAds();
        } else
        {
            parent = listview;
            listview = new AdView.AdViewListener() {

                final AdCache this$0;

                public void onAdFailedToLoad(AdView adview1)
                {
                    readyToLoadAds.offer(adview1);
                }

                public void onAdLoaded(AdView adview1)
                {
                    readyToShowAds.offer(adview1);
                }

            
            {
                this$0 = AdCache.this;
                super();
            }
            };
            int i = 0;
            while (i < 1) 
            {
                AdView adview = new AdView(parent.getContext(), parent);
                adview.setListener(listview);
                ads.add(adview);
                adview.init(set);
                i++;
            }
        }
    }

    public void reloadAds()
    {
        do
        {
            AdView adview = (AdView)readyToLoadAds.poll();
            if (adview != null)
            {
                adview.loadAd();
            } else
            {
                return;
            }
        } while (true);
    }


}
