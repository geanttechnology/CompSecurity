// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.ebay.android.widget.ContainerLayout;
import com.ebay.app.AlertDialogFragment;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.common.Preferences;
import com.ebay.common.model.EbaySuggestedCategory;
import com.ebay.common.net.api.trading.GetCategoriesNetLoader;
import com.ebay.common.net.api.trading.GetCategoriesResponse;
import com.ebay.common.net.api.trading.GetSuggestedCategoriesNetLoader;
import com.ebay.common.net.api.trading.GetSuggestedCategoriesResponse;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseDialogFragment;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.lds.ListingCategoryFilters;
import com.ebay.nautilus.shell.app.BaseActivity;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.mobile.sell:
//            ListingFragmentActivity

public class CategoryDialogFragment extends BaseDialogFragment
    implements android.view.View.OnClickListener, DialogFragmentCallback
{
    public static class CategoryDialogClick
    {

        public EbayCategory category;
        public EbaySuggestedCategory suggestion;

        public CategoryDialogClick()
        {
        }
    }

    public static interface CategoryDialogHost
        extends FwActivity
    {

        public abstract void detachCategoryDialog();

        public abstract String getSelectedCategoryId();

        public abstract boolean isDataAvailable();

        public abstract String keywordsForSuggestions();

        public abstract boolean showMotorsWithUsCats();
    }

    class SuggestedCategoryViewHolder
    {

        public final ImageView image;
        final CategoryDialogFragment this$0;
        public final TextView title;

        public SuggestedCategoryViewHolder(View view)
        {
            this$0 = CategoryDialogFragment.this;
            super();
            image = (ImageView)view.findViewById(0x7f10005b);
            title = (TextView)view.findViewById(0x1020014);
        }
    }

    public static class ViewHolder
    {

        TextView categoryName;
        TextView categoryPath;
        ImageView checkbox;
        ImageView icon;

        public ViewHolder(View view)
        {
            categoryName = (TextView)view.findViewById(0x1020014);
            categoryPath = (TextView)view.findViewById(0x1020015);
            checkbox = (ImageView)view.findViewById(0x7f100623);
            icon = (ImageView)view.findViewById(0x7f100622);
        }
    }


    private static final int DIALOG_UNSUPPORTED = 1;
    private static final int DIALOG_UNSUPPORTED_ALTERNATE = 2;
    private static final int LOADER_GET_SUGGESTED_CATEGORIES = 0;
    private static final int LOADER_ID_CATEGORY = 1;
    private static final String STATE_CATEGORY_ID_LIST = "categoryIdList";
    private static final String STATE_CATEGORY_NAME_LIST = "categoryNameList";
    private String categoryId;
    private ArrayList categoryIds;
    private ArrayList categoryNames;
    private EbaySite draftSite;
    private ViewFlipper flip;

    public CategoryDialogFragment()
    {
    }

    private void addSuggestionsToLayout(ContainerLayout containerlayout, ArrayList arraylist)
    {
        int i = 0;
        while (i < arraylist.size()) 
        {
            EbaySuggestedCategory ebaysuggestedcategory = (EbaySuggestedCategory)arraylist.get(i);
            View view = getActivity().getLayoutInflater().inflate(0x7f0301f8, null);
            SuggestedCategoryViewHolder suggestedcategoryviewholder = new SuggestedCategoryViewHolder(view);
            suggestedcategoryviewholder.title.setText(ebaysuggestedcategory.getPathDisplayFromLevel(0));
            if (ListingCategoryFilters.categoryOkForNewListing(draftSite.id, ebaysuggestedcategory.getCategoryIdPath()))
            {
                suggestedcategoryviewholder.title.setEnabled(true);
            } else
            {
                suggestedcategoryviewholder.title.setEnabled(false);
            }
            if (categoryId != null && categoryId.equals(Long.toString(ebaysuggestedcategory.id)))
            {
                suggestedcategoryviewholder.image.setImageResource(0x7f020098);
            } else
            {
                suggestedcategoryviewholder.image.setImageDrawable(null);
            }
            view.setTag(ebaysuggestedcategory);
            view.setOnClickListener(this);
            containerlayout.addView(view);
            i++;
        }
    }

    private View createCategoryView(ArrayList arraylist)
    {
        View view = getActivity().getLayoutInflater().inflate(0x7f0301f7, null);
        ((LinearLayout)view.findViewById(0x7f100625)).setMotionEventSplittingEnabled(false);
        if (arraylist != null && !arraylist.isEmpty())
        {
            ContainerLayout containerlayout = (ContainerLayout)view.findViewById(0x7f100627);
            containerlayout.setMotionEventSplittingEnabled(false);
            addSuggestionsToLayout(containerlayout, arraylist);
            view.findViewById(0x7f100626).setVisibility(0);
            containerlayout.setVisibility(0);
            view.findViewById(0x7f100628).setVisibility(0);
        }
        return view;
    }

    private void createInitialViews(ArrayList arraylist)
    {
        getDialog().findViewById(0x7f100620).setVisibility(8);
        for (int i = 0; i < categoryIds.size(); i++)
        {
            flip.addView(createCategoryView(null), 0);
        }

        flip.addView(createCategoryView(arraylist), 0);
        flip.setDisplayedChild(0);
    }

    private void downloadCategoriesForCurrentView()
    {
        Object obj = MyApp.getPrefs().getAuthentication();
        com.ebay.nautilus.domain.net.api.trading.EbayTradingApi ebaytradingapi = EbayApiUtil.getTradingApi(draftSite, getActivity(), ((com.ebay.nautilus.domain.app.Authentication) (obj)));
        obj = null;
        if (categoryIds.size() > 0)
        {
            obj = new EbayCategory();
            obj.id = ((Integer)categoryIds.get(flip.getDisplayedChild() - 1)).intValue();
            obj.name = (String)categoryNames.get(flip.getDisplayedChild() - 1);
            obj.level = categoryIds.size();
        }
        obj = new GetCategoriesNetLoader(getBaseActivity().getEbayContext(), ebaytradingapi, ((EbayCategory) (obj)));
        getFwLoaderManager().start(1, ((FwLoader) (obj)), true);
    }

    private void onGetCategoriesFinished(GetCategoriesNetLoader getcategoriesnetloader)
    {
        if (getcategoriesnetloader.getResponse() != null)
        {
            Object obj = ((GetCategoriesResponse)getcategoriesnetloader.getResponse()).categories;
            boolean flag = ((CategoryDialogHost)getActivity()).showMotorsWithUsCats();
            ListingCategoryFilters.updateList(draftSite.id, getcategoriesnetloader.getCategory(), ((ArrayList) (obj)), flag, getResources().getString(0x7f0702aa));
            if (getcategoriesnetloader.getCategory() != null)
            {
                ((ArrayList) (obj)).add(0, new EbayCategory(-1L, getcategoriesnetloader.getCategory().name));
            }
            getcategoriesnetloader = (ContainerLayout)flip.getCurrentView().findViewById(0x7f100629);
            getcategoriesnetloader.setMotionEventSplittingEnabled(false);
            obj = ((ArrayList) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                EbayCategory ebaycategory = (EbayCategory)((Iterator) (obj)).next();
                View view = LayoutInflater.from(getActivity()).inflate(0x7f0301f6, null);
                ViewHolder viewholder = new ViewHolder(view);
                viewholder.categoryName.setText(ebaycategory.name);
                viewholder.categoryName.setEnabled(ListingCategoryFilters.isCategorySupported(draftSite.id, Long.valueOf(ebaycategory.id), Long.valueOf(ebaycategory.parentId), flag));
                viewholder.categoryPath.setVisibility(8);
                if (ebaycategory.id == -1L)
                {
                    viewholder.icon.setImageResource(0x7f020253);
                    viewholder.categoryName.setTextColor(ThemeUtil.resolveThemeColorStateList(getResources(), getActivity().getTheme(), 0x1010212));
                    viewholder.checkbox.setImageDrawable(null);
                    viewholder.checkbox.setVisibility(8);
                    view.setPadding(10, 0, 10, 0);
                } else
                {
                    viewholder.icon.setImageDrawable(null);
                    view.setPadding(10, 0, 10, 0);
                    if (ebaycategory.isLeaf && categoryId != null && categoryId.equals(Long.toString(ebaycategory.id)))
                    {
                        viewholder.checkbox.setImageResource(0x7f0202f1);
                    } else
                    {
                        viewholder.checkbox.setImageDrawable(null);
                        viewholder.checkbox.setVisibility(8);
                    }
                }
                view.setTag(ebaycategory);
                view.setOnClickListener(this);
                getcategoriesnetloader.addView(view);
            }
            getcategoriesnetloader.setVisibility(0);
            getcategoriesnetloader.refreshDrawableState();
            flip.getCurrentView().findViewById(0x7f100624).setVisibility(8);
            flip.getCurrentView().findViewById(0x7f1004bc).setVisibility(0);
        }
        getView().findViewById(0x7f100620).setVisibility(8);
    }

    private void onGetSuggestedCategoriesFinished(GetSuggestedCategoriesNetLoader getsuggestedcategoriesnetloader)
    {
        if (getsuggestedcategoriesnetloader.getResponse() != null)
        {
            Object obj = ((GetSuggestedCategoriesResponse)getsuggestedcategoriesnetloader.getResponse()).suggestions;
            getsuggestedcategoriesnetloader = new ArrayList();
            if (getActivity() instanceof ListingFragmentActivity)
            {
                boolean flag = ListingCategoryFilters.isMotorsCategoryPath(((ListingFragmentActivity)getActivity()).getSelectedCategoryIdPath());
                obj = ((ArrayList) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    EbaySuggestedCategory ebaysuggestedcategory = (EbaySuggestedCategory)((Iterator) (obj)).next();
                    if (flag == ListingCategoryFilters.isMotorsCategoryPath(ebaysuggestedcategory.getCategoryIdPath()))
                    {
                        getsuggestedcategoriesnetloader.add(ebaysuggestedcategory);
                    }
                } while (true);
                createInitialViews(getsuggestedcategoriesnetloader);
            } else
            {
                createInitialViews(((ArrayList) (obj)));
            }
            downloadCategoriesForCurrentView();
        }
    }

    private void sendUpdate(EbaySuggestedCategory ebaysuggestedcategory)
    {
        CategoryDialogClick categorydialogclick = new CategoryDialogClick();
        categorydialogclick.suggestion = ebaysuggestedcategory;
        ContentSyncManager.notifyUpdate(categorydialogclick, com/ebay/mobile/sell/CategoryDialogFragment$CategoryDialogClick.getName());
    }

    private void sendUpdate(EbayCategory ebaycategory)
    {
        Object obj = new StringBuilder();
        String s;
        for (Iterator iterator = categoryNames.iterator(); iterator.hasNext(); ((StringBuilder) (obj)).append(s))
        {
            s = (String)iterator.next();
            if (((StringBuilder) (obj)).length() > 0)
            {
                ((StringBuilder) (obj)).append(":");
            }
        }

        ((StringBuilder) (obj)).append(":").append(ebaycategory.name);
        StringBuilder stringbuilder = new StringBuilder();
        Integer integer;
        for (Iterator iterator1 = categoryIds.iterator(); iterator1.hasNext(); stringbuilder.append(integer))
        {
            integer = (Integer)iterator1.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append(":");
            }
        }

        stringbuilder.append(":").append(ebaycategory.id);
        ebaycategory.namePath = ((StringBuilder) (obj)).toString();
        ebaycategory.idPath = stringbuilder.toString();
        obj = new CategoryDialogClick();
        obj.category = ebaycategory;
        ContentSyncManager.notifyUpdate(obj, com/ebay/mobile/sell/CategoryDialogFragment$CategoryDialogClick.getName());
    }

    private void showUnsupportedDialog(String s)
    {
        if (!TextUtils.isEmpty(MyApp.getDeviceConfiguration().getConfig().get(com.ebay.nautilus.domain.dcs.DcsDomain.Selling.S.carsAndTrucksUrl)) && ListingCategoryFilters.isMotorsCarsAndTrucks(s))
        {
            s = new com.ebay.app.AlertDialogFragment.Builder();
            s.setMessage(getString(0x7f070b91));
            s.setPositiveButton(getString(0x7f070cc7));
            s.setNegativeButton(getString(0x7f070655));
            s.createFromFragment(2, this).show(getFragmentManager(), "dialog_unsupported_alternate");
            return;
        } else
        {
            s = new com.ebay.app.AlertDialogFragment.Builder();
            s.setMessage(getString(0x7f070b90));
            s.setPositiveButton(getString(0x7f070738));
            s.createFromFragment(1, this).show(getFragmentManager(), "dialog_unsupported");
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = AnimationUtils.loadAnimation(getActivity(), 0x10a0001);
        Object obj = AnimationUtils.loadAnimation(getActivity(), 0x10a0000);
        flip = (ViewFlipper)getView().findViewById(0x7f10061f);
        flip.setInAnimation(((android.view.animation.Animation) (obj)));
        flip.setOutAnimation(bundle);
        categoryIds = new ArrayList();
        categoryNames = new ArrayList();
        draftSite = (EbaySite)getArguments().getParcelable("site");
        if (EbaySite.MOTOR.equals(draftSite))
        {
            bundle = EbaySite.US;
        } else
        {
            bundle = draftSite;
        }
        obj = (CategoryDialogHost)getActivity();
        if (!((CategoryDialogHost) (obj)).isDataAvailable())
        {
            dismiss();
            return;
        } else
        {
            String s = ((CategoryDialogHost) (obj)).keywordsForSuggestions();
            categoryId = ((CategoryDialogHost) (obj)).getSelectedCategoryId();
            com.ebay.nautilus.domain.app.Authentication authentication = MyApp.getPrefs().getAuthentication();
            bundle = new GetSuggestedCategoriesNetLoader(((CategoryDialogHost) (obj)).getEbayContext(), EbayApiUtil.getTradingApi(bundle, getActivity(), authentication), s);
            getFwLoaderManager().start(0, bundle, true);
            return;
        }
    }

    public void onClick(View view)
    {
        if (!(view.getTag() instanceof EbaySuggestedCategory)) goto _L2; else goto _L1
_L1:
        view = (EbaySuggestedCategory)view.getTag();
        if (ListingCategoryFilters.categoryOkForNewListing(draftSite.id, view.getCategoryIdPath())) goto _L4; else goto _L3
_L3:
        showUnsupportedDialog(view.getCategoryIdPath());
_L6:
        return;
_L4:
        sendUpdate(view);
        dismiss();
        return;
_L2:
        if (!(view.getTag() instanceof EbayCategory))
        {
            continue; /* Loop/switch isn't completed */
        }
        view = (EbayCategory)view.getTag();
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(TextUtils.join(":", categoryIds));
        if (TextUtils.isEmpty(stringbuilder))
        {
            stringbuilder.append(((EbayCategory) (view)).id);
        } else
        {
            stringbuilder.append(":").append(((EbayCategory) (view)).id);
        }
        if (!ListingCategoryFilters.isCategorySupported(draftSite.id, Long.valueOf(((EbayCategory) (view)).id), Long.valueOf(((EbayCategory) (view)).parentId), ((CategoryDialogHost)getActivity()).showMotorsWithUsCats()))
        {
            showUnsupportedDialog(stringbuilder.toString());
            return;
        }
        if (((EbayCategory) (view)).id == -1L)
        {
            view = flip.getCurrentView();
            flip.showPrevious();
            flip.removeView(view);
            categoryIds.remove(categoryIds.size() - 1);
            categoryNames.remove(categoryNames.size() - 1);
            return;
        }
        if (((EbayCategory) (view)).isLeaf)
        {
            sendUpdate(view);
            dismiss();
            return;
        }
        if (flip.getDisplayedChild() >= flip.getChildCount()) goto _L6; else goto _L5
_L5:
        flip.addView(createCategoryView(null));
        flip.showNext();
        categoryNames.add(((EbayCategory) (view)).name);
        categoryIds.add(Integer.valueOf((int)((EbayCategory) (view)).id));
        downloadCategoriesForCurrentView();
        return;
        if (view.getId() != 0x7f1003ab) goto _L6; else goto _L7
_L7:
        dismiss();
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(0, 0x7f0a027d);
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f0301f5, viewgroup, false);
    }

    public void onDetach()
    {
        ((CategoryDialogHost)getActivity()).detachCategoryDialog();
        super.onDetach();
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        dialogfragment = MyApp.getDeviceConfiguration().getConfig().get(com.ebay.nautilus.domain.dcs.DcsDomain.Selling.S.carsAndTrucksUrl);
        if (j != 1)
        {
            return;
        }
        switch (i)
        {
        default:
            return;

        case 2: // '\002'
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(dialogfragment)));
            break;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putIntegerArrayList("categoryIdList", categoryIds);
        bundle.putStringArrayList("categoryNameList", categoryNames);
        super.onSaveInstanceState(bundle);
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
label0:
        {
            if (!getActivity().isFinishing())
            {
                switch (i)
                {
                default:
                    throw new IllegalArgumentException();

                case 1: // '\001'
                    break label0;

                case 0: // '\0'
                    onGetSuggestedCategoriesFinished((GetSuggestedCategoriesNetLoader)fwloader);
                    break;
                }
            }
            return;
        }
        onGetCategoriesFinished((GetCategoriesNetLoader)fwloader);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        ((TextView)view.findViewById(0x7f1003a5)).setText(0x7f070531);
        view.findViewById(0x7f1003ab).setOnClickListener(this);
    }
}
