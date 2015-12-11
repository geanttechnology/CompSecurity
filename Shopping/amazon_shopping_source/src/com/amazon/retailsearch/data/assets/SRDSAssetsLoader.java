// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.assets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.amazon.ansel.fetch.AbstractResourceListener;
import com.amazon.ansel.fetch.ImageLoader;
import com.amazon.ansel.fetch.ImageRequest;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.ansel.fetch.tools.ref.StrongObjectReference;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.client.AndroidRetailSearchClient;
import com.amazon.retailsearch.client.SearchClientUtil;
import com.amazon.retailsearch.client.UiInvocationHandler;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.experiment.FeatureStateUtil;
import com.amazon.searchapp.retailsearch.client.AssetsServiceCall;
import com.amazon.searchapp.retailsearch.client.RetailSearchClient;
import com.amazon.searchapp.retailsearch.client.web.AbstractServiceCallListener;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallListener;
import com.amazon.searchapp.retailsearch.model.Assets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.data.assets:
//            AssetsLoader, AssetFetchType

public class SRDSAssetsLoader
    implements AssetsLoader
{
    private class RequestListener extends AbstractServiceCallListener
    {

        private boolean cancelled;
        final SRDSAssetsLoader this$0;

        public void endRequest()
        {
            if (cancelled)
            {
                return;
            }
            if (!gotData)
            {
                doLoad = true;
                return;
            } else
            {
                retailSearchLogger.searchSRDSAssetsCompleted();
                return;
            }
        }

        public void error(Exception exception)
        {
            if (!cancelled)
            {
                retailSearchLogger.searchSRDSAssetsError("Assets request error", exception, serviceCall, fetchType);
                doLoad = true;
            }
        }

        public void result(Assets assets)
        {
            if (!cancelled && retreiveBadges(assets) != null)
            {
                gotData = true;
            }
        }

        public volatile void result(Object obj)
        {
            result((Assets)obj);
        }

        public void startRequest()
        {
            if (!cancelled)
            {
                retailSearchLogger.searchSRDSAssetsStarted(fetchType);
            }
        }


/*
        static boolean access$102(RequestListener requestlistener, boolean flag)
        {
            requestlistener.cancelled = flag;
            return flag;
        }

*/

        private RequestListener()
        {
            this$0 = SRDSAssetsLoader.this;
            super();
        }

    }


    private static final Map resourceIdMapping;
    private final Map badges = new HashMap();
    Context context;
    private boolean doLoad;
    FeatureConfiguration featureConfig;
    private AssetFetchType fetchType;
    private boolean gotData;
    private final ResourceProvider loaderGroup;
    ResourceProvider parentResourceProvider;
    private RequestListener requestListener;
    private RetailSearchLogger retailSearchLogger;
    private AssetsServiceCall serviceCall;

    public SRDSAssetsLoader()
    {
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        doLoad = true;
        gotData = false;
        RetailSearchDaggerGraphController.inject(this);
        loaderGroup = new ResourceProvider(parentResourceProvider);
    }

    private Map retreiveBadges(Assets assets)
    {
        if (assets == null || assets.getMedia() == null)
        {
            return null;
        }
        assets = assets.getMedia();
        Iterator iterator = assets.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            final String badgeId = (String)iterator.next();
            if (!badges.containsKey(badgeId))
            {
                Object obj = (String)assets.get(badgeId);
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    badgeId = new AbstractResourceListener() {

                        final SRDSAssetsLoader this$0;
                        final String val$badgeId;

                        public void error(Throwable throwable)
                        {
                            doLoad = true;
                        }

                        public void result(Bitmap bitmap)
                        {
                            badges.put(badgeId, bitmap);
                        }

                        public volatile void result(Object obj1)
                        {
                            result((Bitmap)obj1);
                        }

            
            {
                this$0 = SRDSAssetsLoader.this;
                badgeId = s;
                super();
            }
                    };
                    obj = new ImageLoader(loaderGroup.getContext(), new StrongObjectReference(badgeId), 0L, new ImageRequest(((String) (obj))));
                    loaderGroup.execute(((com.amazon.ansel.fetch.ResourceLoader) (obj)));
                }
            }
        } while (true);
        return badges;
    }

    public void clear()
    {
        if (loaderGroup != null)
        {
            loaderGroup.cancel();
        }
        if (requestListener != null)
        {
            requestListener.cancelled = true;
        }
        badges.clear();
        doLoad = true;
    }

    public Map getBadges()
    {
        return badges;
    }

    public void load(AssetFetchType assetfetchtype)
    {
        boolean flag = false;
        if (doLoad) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        preloadLocalResources();
        s = FeatureStateUtil.getAssetsWeblab(featureConfig);
        if ("C".equals(s) || "T1".equals(s) && !AssetFetchType.POST_SEARCH_PAGE_LOAD.equals(assetfetchtype)) goto _L1; else goto _L3
_L3:
        if ("T2".equals(s) || "T4".equals(s))
        {
            flag = true;
        }
        if (AssetFetchType.STARTUP_SEQUENCE.equals(assetfetchtype) && !flag) goto _L1; else goto _L4
_L4:
        try
        {
            doLoad = false;
            gotData = false;
            fetchType = assetfetchtype;
            assetfetchtype = AndroidRetailSearchClient.getClient();
            requestListener = new RequestListener();
            serviceCall = assetfetchtype.assets((ServiceCallListener)UiInvocationHandler.createUiProxy(requestListener, com/amazon/searchapp/retailsearch/client/web/ServiceCallListener));
            SearchClientUtil.executeRequest(serviceCall);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AssetFetchType assetfetchtype)
        {
            retailSearchLogger.error("Error while running the assets loader's load method", assetfetchtype);
        }
        return;
    }

    public void preloadLocalResources()
    {
        String s;
        s = FeatureStateUtil.getAssetsWeblab(featureConfig);
        break MISSING_BLOCK_LABEL_8;
        if (("C".equals(s) || "T3".equals(s) || "T4".equals(s)) && resourceIdMapping != null && resourceIdMapping.entrySet() != null)
        {
            Iterator iterator = resourceIdMapping.entrySet().iterator();
            while (iterator.hasNext()) 
            {
                Object obj = (java.util.Map.Entry)iterator.next();
                String s1 = (String)((java.util.Map.Entry) (obj)).getKey();
                if (badges.get(s1) == null)
                {
                    try
                    {
                        obj = (Integer)((java.util.Map.Entry) (obj)).getValue();
                        badges.put(s1, BitmapFactory.decodeResource(context.getResources(), ((Integer) (obj)).intValue()));
                    }
                    catch (Exception exception)
                    {
                        retailSearchLogger.error((new StringBuilder()).append("SRDSAssetsLoader encountered an error while preloading '").append(s1).append("' from local resources").toString(), exception);
                    }
                }
            }
        }
        return;
    }

    static 
    {
        resourceIdMapping = new HashMap(20);
        resourceIdMapping.put("addOnBadge", Integer.valueOf(com.amazon.retailsearch.R.drawable.rs_assets_add_on_badge));
        resourceIdMapping.put("autoRipBadge", Integer.valueOf(com.amazon.retailsearch.R.drawable.rs_assets_auto_rip_badge));
        resourceIdMapping.put("bestSellerBadge", Integer.valueOf(com.amazon.retailsearch.R.drawable.rs_assets_best_seller_badge));
        resourceIdMapping.put("fbaBadge", Integer.valueOf(com.amazon.retailsearch.R.drawable.rs_assets_fba_badge));
        resourceIdMapping.put("primeBadge", Integer.valueOf(com.amazon.retailsearch.R.drawable.rs_assets_prime_badge));
        resourceIdMapping.put("primeFreshBadge", Integer.valueOf(com.amazon.retailsearch.R.drawable.rs_assets_prime_fresh_badge));
        resourceIdMapping.put("primeOneDayBadge", Integer.valueOf(com.amazon.retailsearch.R.drawable.rs_assets_prime_one_day_badge));
        resourceIdMapping.put("primePantryBadge", Integer.valueOf(com.amazon.retailsearch.R.drawable.rs_assets_prime_pantry_badge));
        resourceIdMapping.put("primeStandardBadge", Integer.valueOf(com.amazon.retailsearch.R.drawable.rs_assets_prime_standard_badge));
        resourceIdMapping.put("stars1Image", Integer.valueOf(com.amazon.retailsearch.R.drawable.stars_1));
        resourceIdMapping.put("stars2Image", Integer.valueOf(com.amazon.retailsearch.R.drawable.stars_2));
        resourceIdMapping.put("stars3Image", Integer.valueOf(com.amazon.retailsearch.R.drawable.stars_3));
        resourceIdMapping.put("stars4Image", Integer.valueOf(com.amazon.retailsearch.R.drawable.stars_4));
        resourceIdMapping.put("stars5Image", Integer.valueOf(com.amazon.retailsearch.R.drawable.stars_5));
    }


/*
    static boolean access$202(SRDSAssetsLoader srdsassetsloader, boolean flag)
    {
        srdsassetsloader.doLoad = flag;
        return flag;
    }

*/







/*
    static boolean access$702(SRDSAssetsLoader srdsassetsloader, boolean flag)
    {
        srdsassetsloader.gotData = flag;
        return flag;
    }

*/

}
