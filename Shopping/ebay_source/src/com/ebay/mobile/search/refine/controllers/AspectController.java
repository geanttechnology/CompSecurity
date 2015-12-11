// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.controllers;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.search.DetailMode;
import com.ebay.mobile.search.RefinementActor;
import com.ebay.mobile.search.SearchRefineFragment;
import com.ebay.mobile.search.SummarizableWithDefault;
import com.ebay.mobile.search.refine.adapters.AspectOptionAdapter;
import com.ebay.mobile.search.refine.adapters.RefineOptionAdapter;
import java.util.BitSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.search.refine.controllers:
//            CheckedDetailController

public class AspectController extends CheckedDetailController
    implements SummarizableWithDefault
{
    public static interface AspectProvider
        extends RefinementActor
    {

        public abstract void aspectUpdated(com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect1);

        public abstract EbayAspectHistogram getAspectHistogram();
    }


    public static final String EXTRA_ASPECT_NAME = "aspect";
    public static final String EXTRA_SCROLL_OFFSET = "sTop";
    public static final String EXTRA_SCROLL_POS = "sPos";
    private static final int MAX_DISPLAYABLE_ASPECT_VALUES = 10;
    private AspectOptionAdapter adapter;
    private com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect;
    private final AspectProvider aspectProvider;
    private List items;
    private final BitSet itemsCheckedStateSet = new BitSet();

    public AspectController(SearchRefineFragment searchrefinefragment, com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect1, ListView listview)
    {
        super(searchrefinefragment, listview, false);
        items = null;
        aspectProvider = searchrefinefragment;
        items = new LinkedList();
        if (adapter == null)
        {
            adapter = new AspectOptionAdapter(refineActivity, items);
        }
        initForAspect(aspect1);
    }

    public static String getDefaultSummary(com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect1)
    {
        if (aspect1 == null)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder("");
        int j = Math.min(10, aspect1.size());
        for (int i = 0; i < j; i++)
        {
            com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue = (com.ebay.common.model.search.EbayAspectHistogram.AspectValue)aspect1.get(i);
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(AspectOptionAdapter.getReadableItemTitle(aspectvalue));
        }

        if (stringbuilder.length() == 0)
        {
            return MyApp.getApp().getResources().getString(0x7f07055e);
        } else
        {
            return stringbuilder.toString();
        }
    }

    public static String getSummary(com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect1)
    {
        return getSummary(aspect1, getDefaultSummary(aspect1));
    }

    public static String getSummary(com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect1, String s)
    {
        if (aspect1 == null)
        {
            s = "";
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("");
            int j = 10;
            int l = aspect1.size();
            int k;
            for (int i = 0; i < l && j > 0; j = k)
            {
                com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue = (com.ebay.common.model.search.EbayAspectHistogram.AspectValue)aspect1.get(i);
                k = j;
                if (aspectvalue.checked)
                {
                    if (stringbuilder.length() > 0)
                    {
                        stringbuilder.append(", ");
                    }
                    stringbuilder.append(AspectOptionAdapter.getReadableItemTitle(aspectvalue));
                    k = j - 1;
                }
                i++;
            }

            aspect1 = stringbuilder.toString();
            if (aspect1.length() != 0)
            {
                return aspect1;
            }
        }
        return s;
    }

    private void init()
    {
        setAspect(aspect);
        if (aspect != null)
        {
            aspectProvider.aspectUpdated(aspect);
        }
    }

    private void initForAspect(com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect1)
    {
        if (aspect1 == null)
        {
            return;
        } else
        {
            aspect = aspect1;
            init();
            return;
        }
    }

    public static boolean isConfigured(com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect1)
    {
        for (aspect1 = aspect1.iterator(); aspect1.hasNext();)
        {
            if (((com.ebay.common.model.search.EbayAspectHistogram.AspectValue)aspect1.next()).checked)
            {
                return true;
            }
        }

        return false;
    }

    private void setAspect(com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect1)
    {
        items.clear();
        com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue = new com.ebay.common.model.search.EbayAspectHistogram.AspectValue();
        aspectvalue.value = getString(0x7f07055e);
        items.add(aspectvalue);
        int j = aspect1.size();
        for (int i = 0; i < j; i++)
        {
            com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue1 = (com.ebay.common.model.search.EbayAspectHistogram.AspectValue)aspect1.get(i);
            items.add(aspectvalue1);
        }

        adapter.notifyDataSetChanged();
    }

    public RefineOptionAdapter getAdapter()
    {
        return adapter;
    }

    public String getDefaultSummary()
    {
        return getString(0x7f07055e);
    }

    public DetailMode getDetailMode()
    {
        return DetailMode.ASPECTS;
    }

    public Bundle getStateExtras()
    {
        int i = 0;
        Bundle bundle = super.getStateExtras();
        if (aspect == null)
        {
            return bundle;
        }
        bundle.putString("aspect", aspect.name);
        int j = listView.getFirstVisiblePosition();
        View view = listView.getChildAt(0);
        if (view != null)
        {
            i = view.getTop();
        }
        bundle.putInt("sPos", j);
        bundle.putInt("sTop", i);
        return bundle;
    }

    public String getSummary()
    {
        return getSummary(aspect, getDefaultSummary());
    }

    public String getTitle()
    {
        if (aspect == null)
        {
            return "";
        } else
        {
            return aspect.name;
        }
    }

    public boolean isDefault()
    {
        return !isConfigured(aspect);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        boolean flag = true;
        if (i != 0) goto _L2; else goto _L1
_L1:
        for (view = items.iterator(); view.hasNext();)
        {
            ((com.ebay.common.model.search.EbayAspectHistogram.AspectValue)view.next()).checked = false;
        }

        itemsCheckedStateSet.clear();
        listView.clearChoices();
        listView.setItemChecked(0, true);
        aspectProvider.getAspectHistogram().mergeStrategy = com.ebay.common.model.search.EbayAspectHistogram.HistoMergeStrategy.MERGE_ALL;
        update(((com.ebay.common.model.search.EbayAspectHistogram.AspectValue) (null)));
_L4:
        adapterview = (com.ebay.common.model.search.EbayAspectHistogram.AspectValue)adapterview.getItemAtPosition(i);
        if (i == 0 || update(adapterview))
        {
            aspectProvider.searchParamsUpdated();
        }
        return;
_L2:
        itemsCheckedStateSet.flip(i);
        if (itemsCheckedStateSet.nextSetBit(1) != -1)
        {
            flag = false;
        }
        listView.setItemChecked(0, flag);
        if (flag)
        {
            aspectProvider.getAspectHistogram().mergeStrategy = com.ebay.common.model.search.EbayAspectHistogram.HistoMergeStrategy.MERGE_ALL;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onResume()
    {
        if (aspect == null)
        {
            closeIfActive();
            return;
        }
        super.onResume();
        int j = items.size();
        for (int i = 1; i < j; i++)
        {
            if (((com.ebay.common.model.search.EbayAspectHistogram.AspectValue)items.get(i)).checked)
            {
                itemsCheckedStateSet.set(i);
            }
        }

        if (itemsCheckedStateSet.cardinality() == 0)
        {
            itemsCheckedStateSet.set(0);
        }
        setupListView(itemsCheckedStateSet);
        refineFragment.trackingEventListener.onRefineAspect();
    }

    public void onSearchParametersUpdated(SearchParameters searchparameters, EbayAspectHistogram ebayaspecthistogram, EbayCategoryHistogram ebaycategoryhistogram)
    {
        if (ebayaspecthistogram != null && aspect != null) goto _L2; else goto _L1
_L1:
        closeIfActive();
_L4:
        return;
_L2:
        int j = ebayaspecthistogram.size();
        int i = 0;
        do
        {
            if (i < j)
            {
label0:
                {
                    searchparameters = (com.ebay.common.model.search.EbayAspectHistogram.Aspect)ebayaspecthistogram.get(i);
                    if (!((com.ebay.common.model.search.EbayAspectHistogram.Aspect) (searchparameters)).name.equals(aspect.name))
                    {
                        break label0;
                    }
                    if (!aspect.equals(searchparameters))
                    {
                        aspect = searchparameters;
                        init();
                        return;
                    }
                }
            }
            if (true)
            {
                continue;
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setStateExtras(Bundle bundle)
    {
        super.setStateExtras(bundle);
        if (bundle != null && bundle.containsKey("aspect")) goto _L2; else goto _L1
_L1:
        return;
_L2:
        bundle = bundle.getString("aspect");
        EbayAspectHistogram ebayaspecthistogram = aspectProvider.getAspectHistogram();
        if (ebayaspecthistogram != null)
        {
            int i = 0;
            while (i < ebayaspecthistogram.size()) 
            {
                com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect1 = (com.ebay.common.model.search.EbayAspectHistogram.Aspect)ebayaspecthistogram.get(i);
                if (aspect1.name.equals(bundle))
                {
                    initForAspect(aspect1);
                    return;
                }
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void setupListView(BitSet bitset)
    {
        super.setupListView(bitset);
        if (deferredStateExtras != null && deferredStateExtras.containsKey("sPos"))
        {
            int i = deferredStateExtras.getInt("sTop");
            listView.setSelectionFromTop(deferredStateExtras.getInt("sPos"), i);
            deferredStateExtras = null;
        }
    }

    protected boolean update(com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue)
    {
        if (aspectvalue != null)
        {
            boolean flag;
            if (!aspectvalue.checked)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            aspectvalue.checked = flag;
        }
        if (aspectvalue != null) goto _L2; else goto _L1
_L1:
        itemsCheckedStateSet.clear();
_L4:
        aspectProvider.aspectUpdated(aspect);
        return true;
_L2:
        int j = adapter.getCount();
        int i = 0;
        do
        {
            if (i < j)
            {
label0:
                {
                    if (!((com.ebay.common.model.search.EbayAspectHistogram.AspectValue)adapter.getItem(i)).value.equals(aspectvalue.value))
                    {
                        break label0;
                    }
                    itemsCheckedStateSet.set(i, aspectvalue.checked);
                }
            }
            if (true)
            {
                continue;
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected volatile boolean update(Object obj)
    {
        return update((com.ebay.common.model.search.EbayAspectHistogram.AspectValue)obj);
    }
}
