// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable.wear;

import com.amazon.mShop.wearable.model.WearableSearchResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.wearable.wear:
//            MShopWearListenerService

class pleResultListener extends pleResultListener
{

    final MShopWearListenerService this$0;
    final List val$results;

    public void onFoundProduct(WearableSearchResult wearablesearchresult)
    {
        val$results.add(wearablesearchresult);
    }

    public void onSuccess()
    {
        Object obj;
        try
        {
            obj = MShopWearListenerService.access$1600().createArrayNode();
            ObjectWriter objectwriter = MShopWearListenerService.access$1600().writerWithDefaultPrettyPrinter();
            String s;
            for (Iterator iterator = val$results.iterator(); iterator.hasNext(); ((ArrayNode) (obj)).add(MShopWearListenerService.access$1600().readTree(s)))
            {
                s = objectwriter.writeValueAsString((WearableSearchResult)iterator.next());
            }

        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            onError("Failed to serialize results to JSON", ((Throwable) (obj)));
            return;
        }
        obj = MShopWearListenerService.access$1600().writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        MShopWearListenerService.access$1400(mNode, mMessageId, "/search/text/result", ((String) (obj)));
        return;
    }

    pleResultListener(String s1, List list)
    {
        this$0 = final_mshopwearlistenerservice;
        val$results = list;
        super(final_mshopwearlistenerservice, String.this, s1);
    }
}
