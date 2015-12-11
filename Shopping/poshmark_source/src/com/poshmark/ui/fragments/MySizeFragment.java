// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.gson.reflect.TypeToken;
import com.poshmark.analytics.Analytics;
import com.poshmark.controllers.UserStateSummaryController;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.data_model.models.MySize;
import com.poshmark.db.DbApi;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.StringUtils;
import com.poshmark.utils.meta_data.MySizePickerInfo;
import com.poshmark.utils.view_holders.MultiMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, MySizePickerFragment

public class MySizeFragment extends PMFragment
{

    List currentDressSizes;
    List currentJeansSizes;
    List currentPantsSizes;
    List currentShoeSizes;
    List currentSweaterSizes;
    private RelativeLayout denimLayout;
    private RelativeLayout dressesLayout;
    boolean isDataChanged;
    private RelativeLayout pantsLayout;
    private RelativeLayout shoesLayout;
    MySize sizeData;
    android.view.View.OnClickListener sizeLayoutListener;
    private RelativeLayout sweatersLayout;

    public MySizeFragment()
    {
        currentDressSizes = new ArrayList();
        currentJeansSizes = new ArrayList();
        currentPantsSizes = new ArrayList();
        currentShoeSizes = new ArrayList();
        currentSweaterSizes = new ArrayList();
        isDataChanged = false;
        sizeLayoutListener = new android.view.View.OnClickListener() {

            final MySizeFragment this$0;

            public void onClick(View view)
            {
                view = (String)view.getTag();
                Bundle bundle = new Bundle();
                bundle.putInt("MODE", MySizePickerFragment.MODE.MY_SIZE.ordinal());
                bundle.putString("CATEGORY", view);
                MySizePickerInfo mysizepickerinfo = new MySizePickerInfo();
                mysizepickerinfo.allItems = DbApi.getSizesForCategory(view);
                mysizepickerinfo.selectedItems = getCurrentSelectionsListForCategory(view);
                mysizepickerinfo.currentCategory = new MetaItem(view, view);
                ((PMContainerActivity)getActivity()).launchFragmentForResult(bundle, com/poshmark/ui/fragments/MySizePickerFragment, mysizepickerinfo, MySizeFragment.this, 3);
            }

            
            {
                this$0 = MySizeFragment.this;
                super();
            }
        };
    }

    private List getCurrentSelectionsListForCategory(String s)
    {
        ArrayList arraylist = null;
        if (s.equals(DbApi.DRESSES_ID))
        {
            arraylist = new ArrayList(currentDressSizes);
        } else
        {
            if (s.equals(DbApi.PANTS_ID))
            {
                return new ArrayList(currentPantsSizes);
            }
            if (s.equals(DbApi.JEANS_ID))
            {
                return new ArrayList(currentJeansSizes);
            }
            if (s.equals(DbApi.SWEATERS_ID))
            {
                return new ArrayList(currentSweaterSizes);
            }
            if (s.equals(DbApi.SHOES_ID))
            {
                return new ArrayList(currentShoeSizes);
            }
        }
        return arraylist;
    }

    private void getMySizes()
    {
        if (sizeData == null)
        {
            showProgressDialogWithMessage(getString(0x7f060190));
            PMApi.getMySize(new PMApiResponseHandler() {

                final MySizeFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
label0:
                    {
                        if (isAdded())
                        {
                            hideProgressDialog();
                            if (pmapiresponse.hasError())
                            {
                                break label0;
                            }
                            sizeData = (MySize)pmapiresponse.data;
                            setCurrentSelectionLists();
                            setupViews();
                            setSizeValues();
                        }
                        return;
                    }
                    showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.LOAD_MY_SIZES, getString(0x7f0600e9)));
                }

            
            {
                this$0 = MySizeFragment.this;
                super();
            }
            });
        } else
        {
            setupViews();
            setSizeValues();
            if (isDataChanged)
            {
                showProgressDialogWithMessage(getString(0x7f060232));
                MultiMap multimap = new MultiMap();
                populateHash(multimap, currentShoeSizes, "shoes");
                populateHash(multimap, currentJeansSizes, "denim");
                populateHash(multimap, currentDressSizes, "dresses");
                populateHash(multimap, currentSweaterSizes, "sweaters");
                populateHash(multimap, currentPantsSizes, "pants");
                PMApi.setMySize(multimap, new PMApiResponseHandler() {

                    final MySizeFragment this$0;

                    public void handleResponse(PMApiResponse pmapiresponse)
                    {
label0:
                        {
                            if (isAdded())
                            {
                                hideProgressDialog();
                                if (pmapiresponse.hasError())
                                {
                                    break label0;
                                }
                                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "my_size_updated", null);
                                UserStateSummaryController.getGlobalInteractionsController().refreshModels();
                            }
                            return;
                        }
                        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.UPDATE_MY_SIZE, getString(0x7f0600fe)));
                    }

            
            {
                this$0 = MySizeFragment.this;
                super();
            }
                });
                return;
            }
        }
    }

    private void populateHash(Map map, List list, String s)
    {
        MetaItem metaitem;
        for (list = list.iterator(); list.hasNext(); map.put((new StringBuilder()).append(s).append("[]").toString(), metaitem.getId()))
        {
            metaitem = (MetaItem)list.next();
        }

    }

    private void setCurrentSelectionLists()
    {
        setSizeValues(sizeData.dresses, currentDressSizes, DbApi.DRESSES_ID);
        setSizeValues(sizeData.shoes, currentShoeSizes, DbApi.SHOES_ID);
        setSizeValues(sizeData.pants, currentPantsSizes, DbApi.PANTS_ID);
        setSizeValues(sizeData.sweaters, currentSweaterSizes, DbApi.SWEATERS_ID);
        setSizeValues(sizeData.denim, currentJeansSizes, DbApi.JEANS_ID);
    }

    private void setSizeValues()
    {
        setValues(dressesLayout, currentDressSizes);
        setValues(denimLayout, currentJeansSizes);
        setValues(pantsLayout, currentPantsSizes);
        setValues(sweatersLayout, currentSweaterSizes);
        setValues(shoesLayout, currentShoeSizes);
    }

    private void setSizeValues(String as[], List list, String s)
    {
        list.clear();
        if (as != null)
        {
            String s2 = "";
            for (int i = 0; i < as.length;)
            {
                MetaItem metaitem = DbApi.getSizeForCategoryFromLabel(s, as[i]);
                String s1 = s2;
                if (metaitem != null)
                {
                    list.add(metaitem);
                    s1 = metaitem.getDisplay();
                    s2 = (new StringBuilder()).append(s2).append(s1).toString();
                    s1 = s2;
                    if (i < as.length - 1)
                    {
                        s1 = (new StringBuilder()).append(s2).append(", ").toString();
                    }
                }
                i++;
                s2 = s1;
            }

        }
    }

    private void setTitleOfItem(RelativeLayout relativelayout, String s)
    {
        ((PMTextView)relativelayout.findViewById(0x7f0c020c)).setText(s);
    }

    private void setValues(RelativeLayout relativelayout, List list)
    {
        PMTextView pmtextview = (PMTextView)relativelayout.findViewById(0x7f0c020d);
        if (list.size() > 0)
        {
            relativelayout = "";
            for (int i = 0; i < list.size(); i++)
            {
                String s = ((MetaItem)list.get(i)).getDisplay();
                s = (new StringBuilder()).append(relativelayout).append(s).toString();
                relativelayout = s;
                if (i < list.size() - 1)
                {
                    relativelayout = (new StringBuilder()).append(s).append(", ").toString();
                }
            }

            pmtextview.setTextColor(getResources().getColor(0x7f090038));
            pmtextview.setText(relativelayout);
            return;
        } else
        {
            pmtextview.setTextColor(getResources().getColor(0x7f09003c));
            pmtextview.setText(getString(0x7f060147));
            return;
        }
    }

    private void updateSizes(String s, String s1, Bundle bundle)
    {
        bundle = new TypeToken() {

            final MySizeFragment this$0;

            
            {
                this$0 = MySizeFragment.this;
                super();
            }
        };
        if (s.equals(DbApi.DRESSES_ID))
        {
            currentDressSizes = (List)StringUtils.fromJson(s1, bundle);
        } else
        {
            if (s.equals(DbApi.PANTS_ID))
            {
                currentPantsSizes = (List)StringUtils.fromJson(s1, bundle);
                return;
            }
            if (s.equals(DbApi.JEANS_ID))
            {
                currentJeansSizes = (List)StringUtils.fromJson(s1, bundle);
                return;
            }
            if (s.equals(DbApi.SWEATERS_ID))
            {
                currentSweaterSizes = (List)StringUtils.fromJson(s1, bundle);
                return;
            }
            if (s.equals(DbApi.SHOES_ID))
            {
                currentShoeSizes = (List)StringUtils.fromJson(s1, bundle);
                return;
            }
        }
    }

    public boolean handleBack()
    {
        if (!isDataChanged);
        return false;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setTitle(0x7f0601ba);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        intent = intent.getBundleExtra("RETURNED_RESULTS");
        if (i == 3)
        {
            isDataChanged = intent.getBoolean("SIZE_CHANGED", false);
            if (isDataChanged)
            {
                String s = (String)intent.get("DATA_SELECTED");
                if (s != null)
                {
                    updateSizes(((MetaItem)StringUtils.fromJson(s, com/poshmark/data_model/models/MetaItem)).getId(), (String)intent.get("SIZE_LIST"), intent);
                }
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f03008e, viewgroup, false);
    }

    public void onFragmentResult(Bundle bundle, int i)
    {
        if (i == 3)
        {
            isDataChanged = bundle.getBoolean("SIZE_CHANGED");
        }
    }

    public void onResume()
    {
        super.onResume();
        getMySizes();
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "my_size_screen";
    }

    public void setupViews()
    {
        dressesLayout = (RelativeLayout)getView().findViewById(0x7f0c0210);
        setTitleOfItem(dressesLayout, getString(0x7f0600c1));
        dressesLayout.setTag(DbApi.DRESSES_ID);
        dressesLayout.setOnClickListener(sizeLayoutListener);
        dressesLayout.setBackgroundDrawable(getResources().getDrawable(0x7f020024));
        shoesLayout = (RelativeLayout)getView().findViewById(0x7f0c0213);
        setTitleOfItem(shoesLayout, getString(0x7f060264));
        shoesLayout.setTag(DbApi.SHOES_ID);
        shoesLayout.setOnClickListener(sizeLayoutListener);
        pantsLayout = (RelativeLayout)getView().findViewById(0x7f0c0212);
        setTitleOfItem(pantsLayout, getString(0x7f0601ea));
        pantsLayout.setTag(DbApi.PANTS_ID);
        pantsLayout.setOnClickListener(sizeLayoutListener);
        sweatersLayout = (RelativeLayout)getView().findViewById(0x7f0c0214);
        setTitleOfItem(sweatersLayout, getString(0x7f060294));
        sweatersLayout.setTag(DbApi.SWEATERS_ID);
        sweatersLayout.setBackgroundDrawable(getResources().getDrawable(0x7f020021));
        sweatersLayout.setOnClickListener(sizeLayoutListener);
        denimLayout = (RelativeLayout)getView().findViewById(0x7f0c0211);
        setTitleOfItem(denimLayout, getString(0x7f0600bb));
        denimLayout.setTag(DbApi.JEANS_ID);
        denimLayout.setOnClickListener(sizeLayoutListener);
        int i = pantsLayout.getPaddingTop();
        dressesLayout.setPadding(i, i, i, i);
        sweatersLayout.setPadding(i, i, i, i);
    }



}
