// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view;

import android.content.ComponentName;
import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.provider.SearchRecentSuggestions;
import android.text.TextUtils;
import com.ebay.common.model.AutoFillSuggestion;
import com.ebay.common.net.api.autocomplete.AutoCompleteApi;
import com.ebay.common.view.util.BarcodeScanUtil;
import com.ebay.mobile.AppSettings;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.util.ScanResult;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.EbayContextFactories;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public abstract class EbaySearchProvider extends SearchRecentSuggestionsProvider
{
    private static final class SearchProviderContext extends EbayContext
    {

        private final EbayContextFactories factories = new EbayContextFactories();

        public EbayContext getApplicationContext()
        {
            return this;
        }

        protected Object getExtension(EbayContext ebaycontext, Class class1)
        {
            return factories.get(class1, ebaycontext);
        }

        public Set getExtensionTypes()
        {
            return Collections.unmodifiableSet(factories.keySet());
        }

        public SearchProviderContext(Context context)
        {
            AppSettings.init(context).addContextFactories(context, factories);
        }
    }


    public static final String AUTHORITY = "com.ebay.mobile.ebaysearch";
    public static final String LANDING_PAGE_SEARCH_SUGGEST_QUERY = "searchLanding";
    private static final String LANDING_PAGE_SEARCH_SUGGEST_QUERY_PATH = "search_suggest_query/searchLanding";
    private static final int MODE = 1;
    public static final String ROW_TYPE_EBAY_NO_CATEGORY = "ebayNoCategory";
    public static final String ROW_TYPE_RECENT = "recent";
    private static final int URI_MATCH_CUSTOM_SUGGEST = 2;
    private static final int URI_MATCH_LANDING_PAGE_SUGGEST = 3;
    private static final int URI_MATCH_SUGGEST = 1;
    private final UriMatcher uriMatcher = new UriMatcher(-1);

    protected EbaySearchProvider(String s)
    {
        uriMatcher.addURI(s, "search_suggest_query", 1);
        uriMatcher.addURI(s, "*/*/search_suggest_query", 2);
        uriMatcher.addURI(s, "search_suggest_query/searchLanding", 3);
        setupSuggestions(s, 1);
    }

    private void addAutoFillSuggestions(String s, ArrayList arraylist, ComponentName componentname)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        if (!TextUtils.isEmpty(s) || !BarcodeScanUtil.isProductQuery(s))
        {
            EbayCountry ebaycountry = getCountry();
            String s1 = s.toLowerCase(Locale.getDefault()).trim();
            s = EbayApiUtil.getAutoCompleteApi(new SearchProviderContext(getContext()), ebaycountry).autoFillSuggestions(s1);
            if (s != null && !s.isEmpty() && !s.isEmpty())
            {
                int i = 0;
                Iterator iterator = s.iterator();
                while (iterator.hasNext()) 
                {
                    AutoFillSuggestion autofillsuggestion = (AutoFillSuggestion)iterator.next();
                    if (!autofillsuggestion.title.equals(s1) || autofillsuggestion.categoryName != null)
                    {
                        s = "";
                        if (autofillsuggestion.categoryName != null)
                        {
                            s = getContext().getString(0x7f07047c, new Object[] {
                                autofillsuggestion.categoryName
                            });
                        }
                        if (shouldSuggestCategories(autofillsuggestion, componentname) && i <= 1)
                        {
                            arraylist.add(((Object) (new Object[] {
                                Integer.valueOf(0), autofillsuggestion.title, s, autofillsuggestion.title, null, Integer.valueOf(1), (new StringBuilder()).append(autofillsuggestion.categoryName).append("|").append(autofillsuggestion.categoryId).toString(), Integer.valueOf(0)
                            })));
                            i++;
                        } else
                        {
                            arraylist.add(((Object) (new Object[] {
                                Integer.valueOf(0), autofillsuggestion.title, null, autofillsuggestion.title, null, Integer.valueOf(1), "ebayNoCategory", Integer.valueOf(0)
                            })));
                        }
                    }
                }
            }
        }
    }

    private void addRecents(Cursor cursor, String s, MatrixCursor matrixcursor, ArrayList arraylist)
    {
        long l1;
label0:
        {
            String s1 = getContext().getString(0x7f07024d);
            int i = cursor.getColumnIndex("suggest_format");
            int k = cursor.getColumnIndex("suggest_text_1");
            int l = cursor.getColumnIndex("suggest_intent_query");
            int i1 = cursor.getColumnIndex("_id");
            HashMap hashmap = new HashMap();
            long l2;
            for (l1 = 0L; cursor.moveToNext(); l1 = l2)
            {
                int j1 = cursor.getInt(i);
                String s2 = cursor.getString(k);
                String s3 = cursor.getString(l);
                long l3 = cursor.getLong(i1);
                l2 = l1;
                if (l3 > l1)
                {
                    l2 = l3;
                }
                hashmap.put(s3, Integer.valueOf(arraylist.size()));
                arraylist.add(((Object) (new Object[] {
                    Integer.valueOf(j1), s2, s1, s3, null, Integer.valueOf(0), "recent", Long.valueOf(l3)
                })));
            }

            if (s != null)
            {
                cursor = s.trim();
                if (cursor.length() > 1)
                {
                    s = (Integer)hashmap.get(cursor);
                    if (s == null)
                    {
                        break label0;
                    }
                    int j = s.intValue();
                    if (j > 0)
                    {
                        matrixcursor.addRow((Object[])arraylist.remove(j));
                    }
                }
            }
            return;
        }
        matrixcursor.addRow(new Object[] {
            Integer.valueOf(0), cursor, null, cursor, null, Integer.valueOf(0), null, Long.valueOf(l1 + 1L)
        });
    }

    private void addSavedSearchesLink(ArrayList arraylist)
    {
        String s = getContext().getString(0x7f070949);
        arraylist.add(((Object) (new Object[] {
            Integer.valueOf(0), s, null, s, Integer.valueOf(0x7f020254), Integer.valueOf(0), null, Integer.valueOf(0)
        })));
    }

    private void addScanButtonIfSupported(ComponentName componentname, ArrayList arraylist, String s)
    {
        while (BarcodeScanUtil.isProductQuery(s) || componentname != null || ScanResult.getScanActivityIntent(getContext()) == null) 
        {
            return;
        }
        componentname = getContext().getString(0x7f07094f);
        arraylist.add(((Object) (new Object[] {
            Integer.valueOf(0), componentname, null, componentname, Integer.valueOf(0x7f02025d), Integer.valueOf(0), null, Integer.valueOf(0)
        })));
    }

    private void addSellerSearch(ArrayList arraylist, String s)
    {
        arraylist.add(((Object) (new Object[] {
            Integer.valueOf(0), getContext().getString(0x7f07095e), s, (new StringBuilder()).append("seller:").append(s).toString(), Integer.valueOf(0x7f0201e3), Integer.valueOf(0), null, Integer.valueOf(0)
        })));
    }

    public static final SearchRecentSuggestions getSuggestionsManager(Context context, String s)
    {
        return new SearchRecentSuggestions(context, s, 1);
    }

    private boolean isCategorySuggestion(AutoFillSuggestion autofillsuggestion)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (autofillsuggestion != null)
        {
            flag = flag1;
            if (autofillsuggestion.categoryId != null)
            {
                flag = true;
            }
        }
        return flag;
    }

    private boolean shouldSuggestCategories(AutoFillSuggestion autofillsuggestion, ComponentName componentname)
    {
        EbayCountry ebaycountry = getCountry();
        boolean flag;
        boolean flag1;
        if (componentname == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = com.ebay.common.view.util.EbayCountryManager.Default.supportsCategorySuggestions(ebaycountry);
        return flag && isCategorySuggestion(autofillsuggestion) && flag1;
    }

    protected MatrixCursor addEbaySuggestions(Cursor cursor, String s, ComponentName componentname)
    {
        MatrixCursor matrixcursor;
        ArrayList arraylist;
        matrixcursor = new MatrixCursor(new String[] {
            "suggest_format", "suggest_text_1", "suggest_text_2", "suggest_intent_query", "suggest_icon_2", "suggest_flags", "suggest_intent_extra_data", "_id"
        });
        arraylist = new ArrayList();
        if (TextUtils.isEmpty(s) || s.length() < 1) goto _L2; else goto _L1
_L1:
        if (MyApp.getApp() != null)
        {
            addAutoFillSuggestions(s, arraylist, componentname);
        }
        addRecents(cursor, s, matrixcursor, arraylist);
        if (!s.startsWith("seller:"))
        {
            addSellerSearch(arraylist, s);
        }
        addScanButtonIfSupported(componentname, arraylist, s);
        addSavedSearchesLink(arraylist);
_L4:
        for (s = arraylist.iterator(); s.hasNext(); matrixcursor.addRow((Object[])s.next())) { }
        break MISSING_BLOCK_LABEL_221;
        s;
        s.printStackTrace();
        cursor.close();
        return matrixcursor;
_L2:
        addScanButtonIfSupported(componentname, arraylist, s);
        addRecents(cursor, s, matrixcursor, arraylist);
        addSavedSearchesLink(arraylist);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        cursor.close();
        throw s;
        cursor.close();
        return matrixcursor;
    }

    protected abstract EbayCountry getCountry();

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        Object obj;
        ComponentName componentname;
        boolean flag;
        flag = false;
        obj = uri;
        componentname = null;
        uriMatcher.match(uri);
        JVM INSTR tableswitch 1 3: default 44
    //                   1 92
    //                   2 98
    //                   3 168;
           goto _L1 _L2 _L3 _L4
_L1:
        s = super.query(((Uri) (obj)), as, s, as1, s1);
        as = s;
        if (flag)
        {
            as = addEbaySuggestions(s, as1[0], componentname);
            as.setNotificationUri(getContext().getContentResolver(), uri);
        }
        return as;
_L2:
        flag = true;
        continue; /* Loop/switch isn't completed */
_L3:
        flag = true;
        obj = uri.getPathSegments();
        componentname = new ComponentName((String)((List) (obj)).get(0), (String)((List) (obj)).get(1));
        obj = uri.buildUpon().path(null).appendPath((String)((List) (obj)).get(2)).build();
        continue; /* Loop/switch isn't completed */
_L4:
        obj = (new android.net.Uri.Builder()).scheme("content").authority("com.ebay.mobile.ebaysearch").appendPath("search_suggest_query").build();
        if (true) goto _L1; else goto _L5
_L5:
    }
}
