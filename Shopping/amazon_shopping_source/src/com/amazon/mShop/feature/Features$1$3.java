// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.feature;

import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.Feature;
import com.amazon.rio.j2me.client.services.mShop.FeatureStateResponse;
import com.amazon.rio.j2me.client.services.mShop.FeatureStateResponseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.feature:
//            Features

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        Features.access$300(_fld0);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/feature/Features$1

/* anonymous class */
    class Features._cls1
        implements FeatureStateResponseListener
    {

        final Features this$0;

        public void cancelled(ServiceCall servicecall)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Features._cls1._cls3());
        }

        public void completed(final FeatureStateResponse response, ServiceCall servicecall)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Features._cls1._cls1());
        }

        public void error(final Exception e, ServiceCall servicecall)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Features._cls1._cls2());
        }

            
            {
                this$0 = Features.this;
                super();
            }

        // Unreferenced inner class com/amazon/mShop/feature/Features$1$1

/* anonymous class */
        class Features._cls1._cls1
            implements Runnable
        {

            final Features._cls1 this$1;
            final FeatureStateResponse val$response;

            public void run()
            {
                List list = response.getFeatureStates();
                Object obj = new ArrayList(Features.access$000(this$0));
                for (Iterator iterator = list.iterator(); iterator.hasNext(); ((List) (obj)).remove(((Feature)iterator.next()).getFeatureName())) { }
                Feature feature;
                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); list.add(feature))
                {
                    String s = (String)((Iterator) (obj)).next();
                    feature = new Feature();
                    feature.setFeatureName(s);
                    feature.setClientTreatmentPath("");
                    feature.setSendTrigger(Boolean.valueOf(false));
                    feature.setCacheStamp(null);
                }

                Features.access$100(this$0, list);
            }

                    
                    {
                        this$1 = Features._cls1.this;
                        response = featurestateresponse;
                        super();
                    }
        }


        // Unreferenced inner class com/amazon/mShop/feature/Features$1$2

/* anonymous class */
        class Features._cls1._cls2
            implements Runnable
        {

            final Features._cls1 this$1;
            final Exception val$e;

            public void run()
            {
                Features.access$200(this$0, e);
            }

                    
                    {
                        this$1 = Features._cls1.this;
                        e = exception;
                        super();
                    }
        }

    }

}
