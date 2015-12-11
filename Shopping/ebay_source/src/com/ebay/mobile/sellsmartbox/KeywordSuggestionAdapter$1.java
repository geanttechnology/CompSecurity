// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sellsmartbox;

import android.text.TextUtils;
import android.widget.Filter;
import com.ebay.common.model.KeywordSuggestion;
import com.ebay.common.net.api.autocomplete.AutoCompleteApi;
import com.ebay.mobile.util.EbayApiUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.sellsmartbox:
//            KeywordSuggestionAdapter, SellerTagSpellCheck

class this._cls0 extends Filter
{

    final KeywordSuggestionAdapter this$0;

    protected android.widget.tionAdapter._cls1 performFiltering(CharSequence charsequence)
    {
        android.widget.xt xt;
        ArrayList arraylist;
        xt = new android.widget.();
        arraylist = new ArrayList();
        artboxSuggestion artboxsuggestion = new artboxSuggestion();
        KeywordSuggestionAdapter keywordsuggestionadapter = KeywordSuggestionAdapter.this;
        long l = System.currentTimeMillis();
        keywordsuggestionadapter.lastRequestId = l;
        artboxsuggestion.requestId = l;
        if (charsequence != null)
        {
            artboxsuggestion.title = charsequence.toString();
        }
        arraylist.add(artboxsuggestion);
        xt. = arraylist;
        xt. = arraylist.size();
        if (TextUtils.isEmpty(charsequence))
        {
            return xt;
        }
        Object obj1 = EbayApiUtil.getAutoCompleteApi(ebayContext, country).keywordSearch(charsequence.toString().toLowerCase(Locale.getDefault()));
        Object obj;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        obj = obj1;
        if (!((ArrayList) (obj1)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_206;
        }
        Object obj2 = SellerTagSpellCheck.execute(ebayContext, country, charsequence.toString().toLowerCase(Locale.getDefault()));
        obj = obj1;
        if (!TextUtils.isEmpty(((CharSequence) (obj2))))
        {
            obj = EbayApiUtil.getAutoCompleteApi(ebayContext, country).keywordSearch(((String) (obj2)));
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (((ArrayList) (obj)).isEmpty()) goto _L2; else goto _L3
_L3:
        obj1 = ((ArrayList) (obj)).iterator();
_L7:
        if (!((Iterator) (obj1)).hasNext()) goto _L2; else goto _L4
_L4:
        obj2 = (KeywordSuggestion)((Iterator) (obj1)).next();
        obj = null;
        if (TextUtils.isEmpty(((KeywordSuggestion) (obj2)).title)) goto _L6; else goto _L5
_L5:
        if (!Character.isUpperCase(charsequence.toString().charAt(0)))
        {
            break MISSING_BLOCK_LABEL_401;
        }
        obj = ((KeywordSuggestion) (obj2)).title.substring(0, 1).toUpperCase(Locale.getDefault());
_L8:
        obj = (new StringBuilder()).append(((String) (obj))).append(((KeywordSuggestion) (obj2)).title.substring(1)).toString();
_L6:
        if (!((KeywordSuggestion) (obj2)).title.equalsIgnoreCase(charsequence.toString()))
        {
            obj2 = new artboxSuggestion();
            obj2.title = ((String) (obj));
            arraylist.add(obj2);
        }
          goto _L7
        charsequence;
        charsequence = (artboxSuggestion)arraylist.remove(0);
        arraylist.clear();
        arraylist.add(charsequence);
_L2:
        xt. = arraylist;
        xt. = arraylist.size();
        return xt;
        obj = ((KeywordSuggestion) (obj2)).title.substring(0, 1).toLowerCase(Locale.getDefault());
          goto _L8
    }

    protected void publishResults(CharSequence charsequence, android.widget.tionAdapter._cls1 _pcls1)
    {
        if (_pcls1._fld1 >= 1)
        {
            if (((artboxSuggestion)(charsequence = (ArrayList)_pcls1.).get(0)).requestId == lastRequestId)
            {
                data.clear();
                if (_pcls1.data > 0)
                {
                    data.addAll(charsequence);
                }
                notifyDataSetChanged();
                return;
            }
        }
    }

    artboxSuggestion()
    {
        this$0 = KeywordSuggestionAdapter.this;
        super();
    }
}
