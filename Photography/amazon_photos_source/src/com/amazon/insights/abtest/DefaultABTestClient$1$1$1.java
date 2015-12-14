// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.abtest;

import com.amazon.insights.InsightsCredentials;
import com.amazon.insights.Variation;
import com.amazon.insights.VariationSet;
import com.amazon.insights.core.DefaultInsightsHandler;
import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.error.UnexpectedError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.amazon.insights.abtest:
//            DefaultVariation, DefaultABTestClient

class val.iter
    implements Iterator
{

    final next this$2;
    final Iterator val$iter;

    public boolean hasNext()
    {
        return val$iter.hasNext();
    }

    public Variation next()
    {
        Variation variation = (Variation)val$iter.next();
        setVariationIdsFromAllocatedVariation((DefaultVariation)variation);
        return variation;
    }

    public volatile Object next()
    {
        return next();
    }

    public void remove()
    {
        throw new UnsupportedOperationException("This iterator does not support removal of variations");
    }

    getVariationHandler()
    {
        this$2 = final_getvariationhandler;
        val$iter = Iterator.this;
        super();
    }

    // Unreferenced inner class com/amazon/insights/abtest/DefaultABTestClient$1

/* anonymous class */
    class DefaultABTestClient._cls1
        implements Runnable
    {

        final DefaultABTestClient this$0;
        final AtomicReference val$dimensions;
        final DefaultInsightsHandler val$getVariationHandler;
        final Set val$projectNames;

        public void run()
        {
            Object obj;
            ArrayList arraylist;
            Object obj1;
            int i;
            int j;
            int k;
            try
            {
                arraylist = new ArrayList(projectNames);
                k = DefaultABTestClient.access$000(DefaultABTestClient.this);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                getVariationHandler.onError(new UnexpectedError("An unexpected error occurred. Retrieval of variations could not be completed", ((Exception) (obj))));
                DefaultABTestClient.access$100().e("An unexpected error occurred attempting to get variations", ((Throwable) (obj)));
                return;
            }
            i = 0;
            obj = new ConcurrentHashMap();
_L3:
            if (i >= arraylist.size())
            {
                break MISSING_BLOCK_LABEL_173;
            }
            obj1 = new HashSet();
            j = 0;
_L2:
            if (j >= k)
            {
                break; /* Loop/switch isn't completed */
            }
            if (i >= arraylist.size())
            {
                break; /* Loop/switch isn't completed */
            }
            ((Set) (obj1)).add(arraylist.get(i));
            j++;
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            obj1 = allocateDefaultVariations(((Set) (obj1)), ((Map) (obj)));
            obj1 = allocateCachedVariations(((Set) (obj1)), ((Map) (obj)));
            allocateServerVariations(((Set) (obj1)), ((Map) (obj)), (Map)dimensions.get());
              goto _L3
            Iterator iterator = ((Map) (obj)).entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (((DefaultVariation)entry.getValue()).isDefault())
                {
                    DefaultABTestClient.access$100().devw((new StringBuilder()).append("Resolved default variation: '").append(((DefaultVariation)entry.getValue()).getName()).append("' for project: '").append((String)entry.getKey()).append("'").toString());
                }
            } while (true);
            getVariationHandler.onComplete(((DefaultABTestClient._cls1._cls1) (obj)). new DefaultABTestClient._cls1._cls1());
            return;
        }

            
            {
                this$0 = final_defaultabtestclient;
                projectNames = set;
                dimensions = atomicreference;
                getVariationHandler = DefaultInsightsHandler.this;
                super();
            }
    }


    // Unreferenced inner class com/amazon/insights/abtest/DefaultABTestClient$1$1

/* anonymous class */
    class DefaultABTestClient._cls1._cls1
        implements VariationSet
    {

        final DefaultABTestClient._cls1 this$1;
        final Map val$variations;

        public boolean contains(String s)
        {
            return variations.containsKey(s);
        }

        public Variation getVariation(String s)
        {
            if (contains(s))
            {
                s = (Variation)variations.get(s);
                setVariationIdsFromAllocatedVariation((DefaultVariation)s);
                return s;
            }
            DefaultVariation.Builder builder = new DefaultVariation.Builder();
            String s1 = s;
            if (s == null)
            {
                s1 = "UNKNOWN";
            }
            return builder.setProjectName(s1).setApplicationKey(DefaultABTestClient.access$200(this$0).getCredentials().getApplicationKey()).setUniqueId(DefaultABTestClient.access$200(this$0).getUniqueId()).build();
        }

        public Iterator iterator()
        {
            return variations.values().iterator(). new DefaultABTestClient._cls1._cls1._cls1();
        }

            
            {
                this$1 = final__pcls1;
                variations = Map.this;
                super();
            }
    }

}
