// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.ebay.app.AlertDialogFragment;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.common.model.EbaySuggestedCategory;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.nautilus.domain.content.ListingDraftContent;
import com.ebay.nautilus.domain.content.dm.ListingDraftDataManager;
import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;

// Referenced classes of package com.ebay.mobile.sell:
//            BaseSpokeFragment, CategoryDialogFragment, ListingFragmentActivity

public class CategorySpokeFragment extends BaseSpokeFragment
    implements android.view.View.OnClickListener, DialogFragmentCallback, com.ebay.mobile.util.ContentSyncManager.ContentSync, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.Observer
{

    private static final String CATEGORY_DIALOG = "categoryDialog";
    private static final int DIALOG_DROP_PRODUCT = 0;
    private TextView categoryDisplay;
    private ListingDraftDataManager dm;
    private ListingDraft latestDraft;
    private String newCategoryId;
    private String newCategoryPathDisplay;
    private boolean wasFragmentRetained;

    public CategorySpokeFragment()
    {
        wasFragmentRetained = false;
    }

    private boolean isCategoryChangeWithProduct(String s)
    {
        while (s.equals(latestDraft.category.getStringValue()) || latestDraft.productId.getStringValue() == null) 
        {
            return false;
        }
        return true;
    }

    private void showModifyCategoryWithProductDialog()
    {
        com.ebay.app.AlertDialogFragment.Builder builder = new com.ebay.app.AlertDialogFragment.Builder();
        builder.setTitle(getResources().getText(0x7f070bb6));
        builder.setMessage(getString(0x7f070135));
        builder.setPositiveButton(0x7f070738);
        builder.setNegativeButton(0x7f0701cc);
        builder.createFromFragment(0, this).show(getFragmentManager(), "dropProduct");
    }

    private void updateCategory(String s, String s1)
    {
        dm.updateCategory(s, s1);
    }

    private void updateState()
    {
        String s;
        if (latestDraft.categoryNamePath != null)
        {
            s = latestDraft.categoryNamePath.getStringValue();
        } else
        {
            s = "";
        }
        if (s.length() > 0)
        {
            categoryDisplay.setText(s);
        } else
        {
            categoryDisplay.setText(getString(0x7f070531));
        }
        if (!latestDraft.category.isEnabled())
        {
            categoryDisplay.setEnabled(false);
        }
    }

    protected int getLayoutResource()
    {
        return 0x7f0301f4;
    }

    public int getTitleRes()
    {
        return 0x7f070530;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (wasFragmentRetained)
        {
            return;
        } else
        {
            wasFragmentRetained = true;
            categoryDisplay = (TextView)getView().findViewById(0x7f10061e);
            categoryDisplay.setOnClickListener(this);
            ContentSyncManager.register(this, new String[] {
                com/ebay/mobile/sell/CategoryDialogFragment$CategoryDialogClick.getName()
            });
            return;
        }
    }

    protected void onCategorySelected(EbayCategory ebaycategory)
    {
        newCategoryId = Long.toString(ebaycategory.id);
        newCategoryPathDisplay = ebaycategory.namePath.replaceAll(":", " > ");
        if (isCategoryChangeWithProduct(newCategoryId))
        {
            showModifyCategoryWithProductDialog();
            return;
        } else
        {
            updateCategory(newCategoryId, newCategoryPathDisplay);
            return;
        }
    }

    public void onClick(View view)
    {
        Object obj = (com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams)getArguments().getParcelable("key_params");
        view = new Bundle();
        view.putParcelable("site", ((com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams) (obj)).draftSite);
        obj = new CategoryDialogFragment();
        ((CategoryDialogFragment) (obj)).setArguments(view);
        ((CategoryDialogFragment) (obj)).show(getActivity().getFragmentManager(), "categoryDialog");
    }

    public void onContentChanged(ListingDraftDataManager listingdraftdatamanager, ListingDraftContent listingdraftcontent, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType dispatchtype)
    {
        if (listingdraftcontent.getStatus().hasError())
        {
            return;
        } else
        {
            latestDraft = (ListingDraft)listingdraftcontent.getData();
            updateState();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initDataManagers();
    }

    public void onDestroy()
    {
        super.onDestroy();
        ContentSyncManager.unregister(this, new String[] {
            com/ebay/mobile/sell/CategoryDialogFragment$CategoryDialogClick.getName()
        });
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        i;
        JVM INSTR tableswitch 0 0: default 20
    //                   0 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j == 1)
        {
            updateCategory(newCategoryId, newCategoryPathDisplay);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        dm = (ListingDraftDataManager)datamanagercontainer.initialize((com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams)getArguments().getParcelable("key_params"), this);
    }

    public void onResume()
    {
        super.onResume();
        ((ListingFragmentActivity)getActivity()).sendTrackingForSpokeEvent("SellingCategory");
    }

    protected void onSuggestedCategorySelected(EbaySuggestedCategory ebaysuggestedcategory)
    {
        newCategoryId = Long.toString(ebaysuggestedcategory.id);
        newCategoryPathDisplay = ebaysuggestedcategory.getCategoryNamePath().replaceAll(":", " > ");
        if (isCategoryChangeWithProduct(newCategoryId))
        {
            showModifyCategoryWithProductDialog();
            return;
        } else
        {
            updateCategory(newCategoryId, newCategoryPathDisplay);
            return;
        }
    }

    protected void saveOutstandingChanges(boolean flag)
    {
        if (flag)
        {
            dm.validateDraft();
        }
    }

    public void updateContent(String s, Object obj)
    {
        if (s.equals(com/ebay/mobile/sell/CategoryDialogFragment$CategoryDialogClick.getName()))
        {
            s = (CategoryDialogFragment.CategoryDialogClick)obj;
            if (((CategoryDialogFragment.CategoryDialogClick) (s)).category != null)
            {
                onCategorySelected(((CategoryDialogFragment.CategoryDialogClick) (s)).category);
            } else
            if (((CategoryDialogFragment.CategoryDialogClick) (s)).suggestion != null)
            {
                onSuggestedCategorySelected(((CategoryDialogFragment.CategoryDialogClick) (s)).suggestion);
                return;
            }
        }
    }
}
