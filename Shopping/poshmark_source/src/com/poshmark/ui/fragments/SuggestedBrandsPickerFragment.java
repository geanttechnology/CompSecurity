// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.data_model.models.Brand;
import com.poshmark.data_model.models.inner_models.CoverShot;
import com.poshmark.db.AllBrandsModel;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMClickableImageView;
import com.poshmark.ui.customviews.PMImageView;
import com.poshmark.ui.customviews.PMImageViewOnClickListener;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.ViewUtils;
import com.poshmark.utils.meta_data.MetaItemPickerInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, FindFriendsFragment, MetaItemListViewFragment

public class SuggestedBrandsPickerFragment extends PMFragment
{

    AllBrandsModel allBrandsModel;
    PMImageViewOnClickListener customOnCLickListener;
    TextView retryButton;
    int serverSuggestedBrandsCount;
    Map suggestedBrandsMap;

    public SuggestedBrandsPickerFragment()
    {
        allBrandsModel = null;
        suggestedBrandsMap = null;
        retryButton = null;
        customOnCLickListener = new PMImageViewOnClickListener() {

            final SuggestedBrandsPickerFragment this$0;

            public void onClick(PMImageView pmimageview, final Bundle brand)
            {
                pmimageview = (FrameLayout)pmimageview.getParent();
                int i = brand.getInt("POSITION");
                brand = (Brand)allBrandsModel.data.get(i);
                if (GlobalDbController.getGlobalDbController().isFollowingBrand(((Brand) (brand)).canonical_name))
                {
                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "brand", "onramp_brand_unfollowed", null);
                    PMApi.unFollowBrand(((Brand) (brand)).canonical_name, pmimageview. new PMApiResponseHandler() {

                        final _cls5 this$1;
                        final Brand val$brand;
                        final FrameLayout val$parent;

                        public void handleResponse(PMApiResponse pmapiresponse)
                        {
                            if (!pmapiresponse.hasError())
                            {
                                GlobalDbController.getGlobalDbController().unFollowBrand(brand.canonical_name);
                                return;
                            } else
                            {
                                setOverlay(parent, 0);
                                showAutoHideProgressDialogWithMessage("Oops!");
                                return;
                            }
                        }

            
            {
                this$1 = final__pcls5;
                brand = brand1;
                parent = FrameLayout.this;
                super();
            }
                    });
                    setOverlay(pmimageview, 4);
                    return;
                } else
                {
                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "brand", "onramp_brand_followed", null);
                    PMApi.followBrand(((Brand) (brand)).canonical_name, pmimageview. new PMApiResponseHandler() {

                        final _cls5 this$1;
                        final Brand val$brand;
                        final FrameLayout val$parent;

                        public void handleResponse(PMApiResponse pmapiresponse)
                        {
                            if (!pmapiresponse.hasError())
                            {
                                GlobalDbController.getGlobalDbController().followBrand(brand.canonical_name);
                                return;
                            } else
                            {
                                setOverlay(parent, 4);
                                showAutoHideProgressDialogWithMessage("Oops!");
                                return;
                            }
                        }

            
            {
                this$1 = final__pcls5;
                brand = brand1;
                parent = FrameLayout.this;
                super();
            }
                    });
                    setOverlay(pmimageview, 0);
                    return;
                }
            }

            
            {
                this$0 = SuggestedBrandsPickerFragment.this;
                super();
            }
        };
    }

    private int getBrandOverlayVisibility(Brand brand)
    {
        return !GlobalDbController.getGlobalDbController().isFollowingBrand(brand.canonical_name) ? 4 : 0;
    }

    private ImageView getFollowingOverlay(ViewGroup viewgroup)
    {
        Object obj1 = null;
        int i = 0;
        do
        {
label0:
            {
                Object obj = obj1;
                if (i < viewgroup.getChildCount())
                {
                    obj = viewgroup.getChildAt(i);
                    if (obj instanceof PMClickableImageView)
                    {
                        break label0;
                    }
                    obj = (ImageView)obj;
                }
                return ((ImageView) (obj));
            }
            i++;
        } while (true);
    }

    private void setOverlay(FrameLayout framelayout, int i)
    {
        framelayout = getFollowingOverlay(framelayout);
        if (framelayout != null)
        {
            framelayout.setVisibility(i);
        }
    }

    private void setupBrandList()
    {
        if (allBrandsModel == null)
        {
            showProgressDialogWithMessage(getResources().getString(0x7f060190));
            PMApi.getSuggestedBrandsForUser(new PMApiResponseHandler() {

                final SuggestedBrandsPickerFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    hideProgressDialog();
                    if (!pmapiresponse.hasError())
                    {
                        retryButton.setVisibility(4);
                        allBrandsModel = (AllBrandsModel)pmapiresponse.data;
                        serverSuggestedBrandsCount = allBrandsModel.data.size();
                        setupSuggestedBrandMap();
                        showSuggestedBrands();
                        return;
                    } else
                    {
                        pmapiresponse = new ActionErrorContext(pmapiresponse.apiError, null, null, com.poshmark.ui.model.ActionErrorContext.Severity.LOW);
                        showError(pmapiresponse);
                        retryButton.setVisibility(0);
                        return;
                    }
                }

            
            {
                this$0 = SuggestedBrandsPickerFragment.this;
                super();
            }
            });
            return;
        }
        for (int i = allBrandsModel.data.size() - 1; i >= serverSuggestedBrandsCount; i--)
        {
            allBrandsModel.data.remove(i);
        }

        showSuggestedBrands();
    }

    private void setupRetryButton()
    {
        View view = getView();
        if (view != null)
        {
            retryButton = (TextView)view.findViewById(0x7f0c02ec);
            if (retryButton != null)
            {
                retryButton.setVisibility(4);
                retryButton.setOnClickListener(new android.view.View.OnClickListener() {

                    final SuggestedBrandsPickerFragment this$0;

                    public void onClick(View view1)
                    {
                        setupBrandList();
                    }

            
            {
                this$0 = SuggestedBrandsPickerFragment.this;
                super();
            }
                });
            }
        }
    }

    private void setupSuggestedBrandMap()
    {
        suggestedBrandsMap = new HashMap();
        Brand brand;
        for (Iterator iterator = allBrandsModel.data.iterator(); iterator.hasNext(); suggestedBrandsMap.put(brand.canonical_name, brand))
        {
            brand = (Brand)iterator.next();
        }

    }

    private void showCurrentFollowingBrands(int i, LinearLayout linearlayout)
    {
        Object obj = getView();
        if (obj != null)
        {
            int j = allBrandsModel.data.size();
            PMClickableImageView pmclickableimageview = null;
            Object obj1 = null;
            LayoutInflater layoutinflater = LayoutInflater.from(getActivity());
            LinearLayout linearlayout1 = (LinearLayout)((View) (obj)).findViewById(0x7f0c02ea);
            obj = GlobalDbController.getGlobalDbController().getAllFollowingBrands();
            if (obj != null)
            {
                Iterator iterator = ((List) (obj)).iterator();
                obj = linearlayout;
                linearlayout = obj1;
                while (iterator.hasNext()) 
                {
                    String s = (String)iterator.next();
                    if (!suggestedBrandsMap.containsKey(s))
                    {
                        Object obj2 = new Brand();
                        obj2.canonical_name = s;
                        allBrandsModel.data.add(obj2);
                        if (i == 0)
                        {
                            obj = (LinearLayout)layoutinflater.inflate(0x7f0300c3, null, false);
                            linearlayout1.addView(((View) (obj)), linearlayout1.getChildCount() - 1);
                        }
                        if (i == 0)
                        {
                            pmclickableimageview = (PMClickableImageView)((LinearLayout) (obj)).findViewById(0x7f0c02ef);
                            linearlayout = (FrameLayout)((LinearLayout) (obj)).findViewById(0x7f0c02ee);
                        } else
                        if (i == 1)
                        {
                            pmclickableimageview = (PMClickableImageView)((LinearLayout) (obj)).findViewById(0x7f0c02f1);
                            linearlayout = (FrameLayout)((LinearLayout) (obj)).findViewById(0x7f0c02f0);
                        } else
                        if (i == 2)
                        {
                            pmclickableimageview = (PMClickableImageView)((LinearLayout) (obj)).findViewById(0x7f0c02f3);
                            linearlayout = (FrameLayout)((LinearLayout) (obj)).findViewById(0x7f0c02f2);
                        }
                        obj2 = new Bundle();
                        ((Bundle) (obj2)).putInt("POSITION", j);
                        pmclickableimageview.setBundle(((Bundle) (obj2)));
                        pmclickableimageview.setCustomOnClickListener(customOnCLickListener);
                        pmclickableimageview.loadImageWithString(s, false);
                        setOverlay(linearlayout, 0);
                        if (i == 2)
                        {
                            i = 0;
                        } else
                        {
                            i++;
                        }
                        j++;
                    }
                }
            }
        }
    }

    private void showSuggestedBrands()
    {
        Object obj1 = getView();
        if (obj1 != null)
        {
            int j = 0;
            int i = 0;
            LinearLayout linearlayout = null;
            PMClickableImageView pmclickableimageview = null;
            Object obj = null;
            LayoutInflater layoutinflater = LayoutInflater.from(getActivity());
            obj1 = (LinearLayout)((View) (obj1)).findViewById(0x7f0c02ea);
            Iterator iterator = allBrandsModel.data.iterator();
            while (iterator.hasNext()) 
            {
                Brand brand = (Brand)iterator.next();
                if (i == 0)
                {
                    linearlayout = (LinearLayout)layoutinflater.inflate(0x7f0300c3, null, false);
                    ((LinearLayout) (obj1)).addView(linearlayout, ((LinearLayout) (obj1)).getChildCount() - 1);
                }
                Bundle bundle;
                if (i == 0)
                {
                    pmclickableimageview = (PMClickableImageView)linearlayout.findViewById(0x7f0c02ef);
                    obj = (FrameLayout)linearlayout.findViewById(0x7f0c02ee);
                } else
                if (i == 1)
                {
                    pmclickableimageview = (PMClickableImageView)linearlayout.findViewById(0x7f0c02f1);
                    obj = (FrameLayout)linearlayout.findViewById(0x7f0c02f0);
                } else
                if (i == 2)
                {
                    pmclickableimageview = (PMClickableImageView)linearlayout.findViewById(0x7f0c02f3);
                    obj = (FrameLayout)linearlayout.findViewById(0x7f0c02f2);
                }
                bundle = new Bundle();
                bundle.putInt("POSITION", j);
                pmclickableimageview.setBundle(bundle);
                pmclickableimageview.setCustomOnClickListener(customOnCLickListener);
                if (brand.logo != null && brand.logo.url_small != null)
                {
                    pmclickableimageview.loadImage(brand.logo.url_small);
                    int l = (int)ViewUtils.dipToPixels(PMApplication.getContext(), 0.5F);
                    int k = l;
                    if (l == 0)
                    {
                        k = 1;
                    }
                    pmclickableimageview.setPadding(k, k, k, k);
                    pmclickableimageview.setBackgroundColor(PMApplication.getContext().getResources().getColor(0x7f090016));
                } else
                {
                    pmclickableimageview.loadImageWithString(brand.canonical_name, false);
                }
                setOverlay(((FrameLayout) (obj)), getBrandOverlayVisibility(brand));
                if (i == 2)
                {
                    i = 0;
                } else
                {
                    i++;
                }
                j++;
            }
            showCurrentFollowingBrands(i, linearlayout);
            obj = (PMTextView)((LinearLayout) (obj1)).findViewById(0x7f0c02eb);
            ((PMTextView) (obj)).setVisibility(0);
            ((PMTextView) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                final SuggestedBrandsPickerFragment this$0;

                public void onClick(View view)
                {
                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "brand", "view_more_brands_onramp", null);
                    view = new MetaItemPickerInfo();
                    view.allItems = GlobalDbController.getGlobalDbController().getAllBrands();
                    Bundle bundle1 = new Bundle();
                    bundle1.putInt("META_ITEM_MODE", MetaItemListViewFragment.META_ITEM_MODES.BRAND_MODE.ordinal());
                    bundle1.putBoolean("SEARCH_ENABLED", true);
                    bundle1.putBoolean("BRAND_FOLLOW_BUTTON", true);
                    PMActivity pmactivity = (PMActivity)getActivity();
                    if (pmactivity != null && pmactivity.isActivityInForeground())
                    {
                        pmactivity.launchFragment(bundle1, com/poshmark/ui/fragments/MetaItemListViewFragment, view);
                    }
                }

            
            {
                this$0 = SuggestedBrandsPickerFragment.this;
                super();
            }
            });
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setupRetryButton();
        setupBrandList();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f0300c2, viewgroup, false);
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "suggested_brands_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        setTitle(0x7f060290);
        setNextActionButton("Next", new android.view.View.OnClickListener() {

            final SuggestedBrandsPickerFragment this$0;

            public void onClick(View view)
            {
                List list = GlobalDbController.getGlobalDbController().getAllFollowingBrands();
                int i;
                if (list != null)
                {
                    i = list.size();
                } else
                {
                    i = 0;
                }
                if (i > 0)
                {
                    view = new String();
                    for (int j = 0; j < list.size(); j++)
                    {
                        String s = (new StringBuilder()).append(view).append((String)list.get(j)).toString();
                        view = s;
                        if (j + 1 < list.size())
                        {
                            view = (new StringBuilder()).append(s).append(",").toString();
                        }
                    }

                    Analytics.getInstance().trackEventWithValue(viewNameForAnalytics, "user", "total_onramp_brands_followed", view, i);
                } else
                {
                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "onramp_brand_next_nofollowed", null);
                }
                (new Bundle()).putString("NAME", PMApplicationSession.GetPMSession().getUserId());
                ((PMActivity)getActivity()).launchFragment(null, com/poshmark/ui/fragments/FindFriendsFragment, null);
            }

            
            {
                this$0 = SuggestedBrandsPickerFragment.this;
                super();
            }
        });
    }




}
