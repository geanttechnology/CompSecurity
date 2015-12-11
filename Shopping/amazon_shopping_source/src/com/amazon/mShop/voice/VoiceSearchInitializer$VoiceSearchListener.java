// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.voice;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.search.SearchActivity;
import com.amazon.mShop.search.SearchIntentBuilder;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.searchapp.retailsearch.client.SearchMethod;
import com.amazon.shopapp.voice.module.VoiceSearchActionListener;

// Referenced classes of package com.amazon.mShop.voice:
//            VoiceSearchInitializer

public class this._cls0
    implements VoiceSearchActionListener
{

    final VoiceSearchInitializer this$0;

    public void search(Context context, String s, String s1, String s2, int i, String s3, String s4)
    {
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_163;
        }
        if (!(context instanceof AmazonActivity))
        {
            return;
        }
        String s5 = s3;
        if (TextUtils.isEmpty(s3))
        {
            s5 = "vos_search_query";
        }
        s3 = s4;
        try
        {
            if (TextUtils.isEmpty(s4))
            {
                s3 = ClickStreamTag.ORIGIN_SEARCH_VOICE.getTag();
            }
            s = (new SearchIntentBuilder((AmazonActivity)context)).query(s).searchMethod(SearchMethod.VOICE).showSearchEntryView(false).clickStreamOrigin(s3).asrRequestId(s1).utteranceId(s2);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e(VoiceSearchInitializer.access$000(), "Failed to execute search", context);
            return;
        }
        if (i >= 0)
        {
            i++;
        } else
        {
            i = 0;
        }
        s = s.interpretationNum(i).build();
        if (!(context instanceof SearchActivity))
        {
            break MISSING_BLOCK_LABEL_151;
        }
        ((SearchActivity)context).doSearch(s);
_L1:
        RefMarkerObserver.logRefMarker(s5);
        return;
        ActivityUtils.startSearchActivity((AmazonActivity)context, s);
          goto _L1
    }

    public ()
    {
        this$0 = VoiceSearchInitializer.this;
        super();
    }
}
