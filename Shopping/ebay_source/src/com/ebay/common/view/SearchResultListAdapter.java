// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import java.text.NumberFormat;
import java.util.List;

// Referenced classes of package com.ebay.common.view:
//            DefaultItemAdapter, ViewCache, ItemAdapter

public class SearchResultListAdapter extends ArrayAdapter
{

    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo currencyLog = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("CurrencyConversion", 3, "Log CurrencyConversion");
    protected final LayoutInflater inflater;
    private final ItemAdapter itemAdapter;
    private final int itemCount;
    private int layout;

    public SearchResultListAdapter(Activity activity, int i, boolean flag, int j, List list, boolean flag1)
    {
        this(((Context) (activity)), ((ItemAdapter) (new DefaultItemAdapter(activity, flag, true, true, j, flag1))), i, list);
    }

    public SearchResultListAdapter(Activity activity, boolean flag, int i, List list, boolean flag1)
    {
        this(activity, -1, flag, i, list, flag1);
    }

    public SearchResultListAdapter(Context context, ItemAdapter itemadapter, int i, List list)
    {
        super(context, 0x7f030074, list);
        layout = 0x7f030074;
        inflater = (LayoutInflater)context.getSystemService("layout_inflater");
        itemAdapter = itemadapter;
        itemCount = i;
    }

    public SearchResultListAdapter(Context context, ItemAdapter itemadapter, List list)
    {
        this(context, itemadapter, -1, list);
    }

    public SearchResultListAdapter(Context context, ItemAdapter itemadapter, List list, Integer integer)
    {
        this(context, itemadapter, -1, list);
        if (integer != null)
        {
            layout = integer.intValue();
        }
    }

    private final View getItemCountHeader(ViewGroup viewgroup)
    {
        viewgroup = (TextView)inflater.inflate(0x7f030077, viewgroup, false);
        Resources resources = viewgroup.getResources();
        String s = NumberFormat.getInstance().format(itemCount);
        viewgroup.setText(resources.getQuantityString(0x7f080015, itemCount, new Object[] {
            s
        }));
        return viewgroup;
    }

    public boolean areAllItemsEnabled()
    {
        return itemCount == -1;
    }

    public int getCount()
    {
        int j = super.getCount();
        int i = j;
        if (itemCount != -1)
        {
            i = j;
            if (j > 0)
            {
                i = j + 1;
            }
        }
        return i;
    }

    public EbaySearchListItem getItem(int i)
    {
        if (super.getCount() >= 1)
        {
            if (itemCount == -1)
            {
                return (EbaySearchListItem)super.getItem(i);
            }
            if (i != 0)
            {
                return (EbaySearchListItem)super.getItem(i - 1);
            }
        }
        return null;
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        EbaySearchListItem ebaysearchlistitem = getItem(i);
        if (ebaysearchlistitem == null)
        {
            return (long)(-1 - i);
        } else
        {
            return ebaysearchlistitem.id;
        }
    }

    public int getItemViewType(int i)
    {
        int j = -1;
        if (itemCount == -1)
        {
            j = super.getItemViewType(i);
        } else
        if (i != 0)
        {
            return super.getItemViewType(i - 1);
        }
        return j;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (i == 0 && itemCount != -1)
        {
            return getItemCountHeader(viewgroup);
        }
        EbaySearchListItem ebaysearchlistitem;
        if (view == null)
        {
            viewgroup = inflater.inflate(layout, viewgroup, false);
            view = new ViewCache(viewgroup);
            viewgroup.setTag(view);
            itemAdapter.init(view);
        } else
        {
            viewgroup = view;
            view = (ViewCache)viewgroup.getTag();
        }
        ebaysearchlistitem = getItem(i);
        view.object = ebaysearchlistitem;
        if (ebaysearchlistitem != null)
        {
            itemAdapter.setItem(view, ebaysearchlistitem, i);
            return viewgroup;
        } else
        {
            ((ViewCache) (view)).image.setImageResource(0x7f0201f5);
            ((ViewCache) (view)).image.setTag(null);
            ((ViewCache) (view)).text.setText(null);
            ((ViewCache) (view)).rightColumnText1.setText(null);
            ((ViewCache) (view)).rightColumnText2.setText(null);
            ((ViewCache) (view)).rightColumnText3.setText(null);
            ((ViewCache) (view)).rightColumnText4.setText(null);
            ((ViewCache) (view)).rightColumnText5.setVisibility(8);
            ((ViewCache) (view)).specialText.setVisibility(8);
            return viewgroup;
        }
    }

    public boolean isEnabled(int i)
    {
        int j = i;
        if (itemCount != -1)
        {
            if (i == 0)
            {
                return false;
            }
            j = i - 1;
        }
        return super.isEnabled(j);
    }

    public void markItemAsVisited(View view, EbaySearchListItem ebaysearchlistitem)
    {
        itemAdapter.markItemAsVisited(view, ebaysearchlistitem);
    }

    public final void refresh(AbsListView abslistview)
    {
        itemAdapter.refresh(abslistview);
    }

    protected void setLayout(int i)
    {
        layout = i;
    }

}
