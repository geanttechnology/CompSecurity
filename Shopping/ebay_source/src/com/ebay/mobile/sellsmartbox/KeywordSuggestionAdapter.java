// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sellsmartbox;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import com.ebay.common.model.KeywordSuggestion;
import com.ebay.common.net.api.autocomplete.AutoCompleteApi;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.app.BaseActivity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.sellsmartbox:
//            SellerTagSpellCheck

public class KeywordSuggestionAdapter extends ArrayAdapter
{
    public static final class SmartboxSuggestion
        implements Serializable
    {

        public long requestId;
        public String title;

        public String toString()
        {
            return title;
        }

        public SmartboxSuggestion()
        {
            requestId = 0L;
        }
    }

    public static final class ViewCache
    {

        public final TextView title;

        public ViewCache(View view)
        {
            title = (TextView)view.findViewById(0x1020014);
        }
    }


    protected final EbayCountry country;
    protected ArrayList data;
    protected final EbayContext ebayContext;
    private final LayoutInflater inflater;
    protected long lastRequestId;

    public KeywordSuggestionAdapter(BaseActivity baseactivity, int i, EbayCountry ebaycountry)
    {
        super(baseactivity, i);
        data = new ArrayList();
        country = ebaycountry;
        ebayContext = baseactivity.getEbayContext();
        inflater = LayoutInflater.from(baseactivity);
    }

    public int getCount()
    {
        return data.size();
    }

    public Filter getFilter()
    {
        return new Filter() {

            final KeywordSuggestionAdapter this$0;

            protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
            {
                android.widget.Filter.FilterResults filterresults;
                ArrayList arraylist;
                filterresults = new android.widget.Filter.FilterResults();
                arraylist = new ArrayList();
                SmartboxSuggestion smartboxsuggestion = new SmartboxSuggestion();
                KeywordSuggestionAdapter keywordsuggestionadapter = KeywordSuggestionAdapter.this;
                long l = System.currentTimeMillis();
                keywordsuggestionadapter.lastRequestId = l;
                smartboxsuggestion.requestId = l;
                if (charsequence != null)
                {
                    smartboxsuggestion.title = charsequence.toString();
                }
                arraylist.add(smartboxsuggestion);
                filterresults.values = arraylist;
                filterresults.count = arraylist.size();
                if (TextUtils.isEmpty(charsequence))
                {
                    return filterresults;
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
                    obj2 = new SmartboxSuggestion();
                    obj2.title = ((String) (obj));
                    arraylist.add(obj2);
                }
                  goto _L7
                charsequence;
                charsequence = (SmartboxSuggestion)arraylist.remove(0);
                arraylist.clear();
                arraylist.add(charsequence);
_L2:
                filterresults.values = arraylist;
                filterresults.count = arraylist.size();
                return filterresults;
                obj = ((KeywordSuggestion) (obj2)).title.substring(0, 1).toLowerCase(Locale.getDefault());
                  goto _L8
            }

            protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
            {
                if (filterresults.count >= 1)
                {
                    if (((SmartboxSuggestion)(charsequence = (ArrayList)filterresults.values).get(0)).requestId == lastRequestId)
                    {
                        data.clear();
                        if (filterresults.count > 0)
                        {
                            data.addAll(charsequence);
                        }
                        notifyDataSetChanged();
                        return;
                    }
                }
            }

            
            {
                this$0 = KeywordSuggestionAdapter.this;
                super();
            }
        };
    }

    public SmartboxSuggestion getItem(int i)
    {
        return (SmartboxSuggestion)data.get(i);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        SmartboxSuggestion smartboxsuggestion;
        if (view == null)
        {
            viewgroup = inflater.inflate(0x7f030209, null);
            view = new ViewCache(viewgroup);
            viewgroup.setTag(view);
        } else
        {
            viewgroup = view;
            view = (ViewCache)viewgroup.getTag();
        }
        smartboxsuggestion = getItem(i);
        ((ViewCache) (view)).title.setText(smartboxsuggestion.title);
        return viewgroup;
    }
}
