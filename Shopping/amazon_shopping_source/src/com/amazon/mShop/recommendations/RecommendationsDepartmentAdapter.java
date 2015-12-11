// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.recommendations;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.control.recommendations.RecommendationsBrowser;
import com.amazon.mShop.control.recommendations.RecommendationsController;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.rio.j2me.client.services.mShop.CategoryResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.recommendations:
//            RecommendationsResultsView

public class RecommendationsDepartmentAdapter extends BaseAdapter
    implements android.widget.AdapterView.OnItemClickListener, ListAdapter
{

    private int mCurrentPosition;
    private final CategoryResult mDefaultCategory = new CategoryResult();
    private AmazonAlertDialog mDialog;
    private List mList;
    private final RecommendationsResultsView mResultsView;

    public RecommendationsDepartmentAdapter(RecommendationsResultsView recommendationsresultsview)
    {
        mResultsView = recommendationsresultsview;
        mDefaultCategory.setDisplayName(recommendationsresultsview.getContext().getResources().getString(com.amazon.mShop.android.lib.R.string.search_all_departments));
        mList = new ArrayList();
    }

    public void bindAmazonAlertDialog(AmazonAlertDialog amazonalertdialog)
    {
        mDialog = amazonalertdialog;
    }

    public void clear()
    {
        mList.clear();
        mList.add(mDefaultCategory);
    }

    public int getCount()
    {
        if (mList == null)
        {
            return 0;
        } else
        {
            return mList.size();
        }
    }

    public CategoryResult getItem(int i)
    {
        return (CategoryResult)mList.get(i);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getSelectedPosition()
    {
        return mCurrentPosition;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = LayoutInflater.from(mResultsView.getContext()).inflate(com.amazon.mShop.android.lib.R.layout.search_refine_item, null, false);
        }
        viewgroup = getItem(i);
        ((TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.item_name)).setText(viewgroup.getDisplayName());
        viewgroup = (ImageView)view.findViewById(com.amazon.mShop.android.lib.R.id.check_mark);
        if (i == mCurrentPosition)
        {
            viewgroup.setVisibility(0);
            return view;
        } else
        {
            viewgroup.setVisibility(4);
            return view;
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (mCurrentPosition == i) goto _L2; else goto _L1
_L1:
        mCurrentPosition = i;
        view = mResultsView.getBrowser();
        adapterview = getItem(i);
        if (adapterview != null) goto _L4; else goto _L3
_L3:
        return;
_L4:
        if (mDefaultCategory != adapterview || view.hasCategoryResult())
        {
            view = (new StringBuilder()).append(User.getUser().getFullName()).append("_").append(AppLocale.getInstance().getCurrentLocaleName()).toString();
            RecommendationsController.getInstance().sendRecsRatingsForUser(view);
            mResultsView.refine(adapterview);
            RefMarkerObserver.logRefMarker("recs_dept");
        }
_L2:
        if (mDialog != null)
        {
            mDialog.dismiss();
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void update(List list)
    {
        clear();
        if (list != null && !list.isEmpty())
        {
            CategoryResult categoryresult;
            for (list = list.iterator(); list.hasNext(); mList.add(categoryresult))
            {
                categoryresult = (CategoryResult)list.next();
            }

        }
    }
}
