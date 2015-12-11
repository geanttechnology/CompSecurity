// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.ebay.app.AlertDialogFragment;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.photomanager.PhotoManagerFragment;
import com.ebay.mobile.photomanager.PhotoManagerView;
import com.ebay.mobile.photomanager.PhotoManagerViewAdapter;
import com.ebay.mobile.photomanager.PictureUrl;
import com.ebay.nautilus.domain.content.ListingDraftContent;
import com.ebay.nautilus.domain.content.dm.ListingDraftDataManager;
import com.ebay.nautilus.domain.data.LdsFee;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.sell:
//            BaseSpokeFragment, ListingFragmentActivity

public class PhotosSpokeFragment extends PhotoManagerFragment
    implements com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.Observer
{

    protected static final String EXTRA_UPLOAD_NOTIFICATION = "upload_notification";
    private ActionBar actionBar;
    private ListingDraftDataManager dm;
    private ListingDraft listingDraft;
    private LinearLayout parent;
    private View progress;

    public PhotosSpokeFragment()
    {
    }

    private void handleUploadNotification()
    {
        if (MyApp.getPrefs().getDisplayUploadNotificationAlert())
        {
            MyApp.getPrefs().setDisplayUploadNotificationAlert(false);
            (new com.ebay.app.AlertDialogFragment.Builder()).setTitle(getString(0x7f070791)).setMessage(getString(0x7f070790)).setPositiveButton(0x7f070738).createFromFragment(0, null).show(getFragmentManager(), "photo_dialog");
        }
    }

    protected int getMaxAllowedPhotos()
    {
        int i;
        i = 12;
        if (listingDraft == null)
        {
            return 12;
        }
        if (listingDraft.pictureMaxRemaining == null) goto _L2; else goto _L1
_L1:
        i = listingDraft.pictureUrls.size() + listingDraft.pictureMaxRemaining.getIntValue();
_L4:
        return i;
_L2:
        if (listingDraft.listingMode.equals("ReviseItem"))
        {
            i = listingDraft.pictureUrls.size();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected int getMaxFreePhotos()
    {
        int i = 0;
        for (Iterator iterator = listingDraft.lookupFees.iterator(); iterator.hasNext();)
        {
            LdsFee ldsfee = (LdsFee)iterator.next();
            if ("PhotoFee".equals(ldsfee.type) && "0.0".equals(ldsfee.value))
            {
                return maxPhotos;
            }
        }

        if (listingDraft.pictureMaxFree != null)
        {
            i = listingDraft.pictureMaxFree.getIntValue();
        }
        return i;
    }

    protected List getPictureUrls()
    {
        ArrayList arraylist = new ArrayList();
        if (listingDraft != null)
        {
            if (listingDraft.productStockPhoto != null && listingDraft.productStockPhoto.getStringValue() != null)
            {
                arraylist.add(new PictureUrl(listingDraft.productStockPhoto.getStringValue(), true, true));
            }
            Iterator iterator = listingDraft.pictureUrls.iterator();
            while (iterator.hasNext()) 
            {
                LdsField ldsfield = (LdsField)iterator.next();
                arraylist.add(new PictureUrl(ldsfield.getStringValue(), ldsfield.isEnabled(), false));
            }
        }
        return arraylist;
    }

    public void onBackPressed()
    {
        if (getResources().getBoolean(0x7f0b0006))
        {
            getActivity().finish();
            return;
        } else
        {
            getFragmentManager().popBackStack();
            BaseSpokeFragment.hideDoneButton(getView());
            return;
        }
    }

    public void onContentChanged(ListingDraftDataManager listingdraftdatamanager, ListingDraftContent listingdraftcontent, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType dispatchtype)
    {
        if (!listingdraftcontent.getStatus().hasError())
        {
            parent.setVisibility(0);
            progress.setVisibility(8);
            if (adapter == null)
            {
                listingDraft = (ListingDraft)listingdraftcontent.getData();
                maxPhotos = getMaxAllowedPhotos();
                if (maxPhotos <= 0)
                {
                    Log.w(com/ebay/mobile/sell/PhotosSpokeFragment.getSimpleName(), "PhotoManager's maxPhotos is less than or equal to zero");
                }
                listingdraftdatamanager = getPictureUrls();
                adapter = new PhotoManagerViewAdapter(getActivity(), listingdraftdatamanager, maxPhotos, getMaxFreePhotos());
                adapter.registerDataSetObserver(observer);
                view.setAdapter(adapter);
                if (delayedUploadUri != null)
                {
                    uploadPhoto(delayedUploadUri);
                    delayedUploadUri = null;
                    return;
                }
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
        initDataManagers();
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        datamanagercontainer = (com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams)getArguments().getParcelable("key_params");
        dm = (ListingDraftDataManager)getDataManagerContainer().initialize(datamanagercontainer, this);
    }

    public void onResume()
    {
        super.onResume();
        if (dm == null)
        {
            parent.setVisibility(8);
            progress.setVisibility(0);
        } else
        {
            parent.setVisibility(0);
            progress.setVisibility(8);
        }
        if (getArguments() != null && getArguments().containsKey("upload_notification"))
        {
            handleUploadNotification();
            getArguments().remove("upload_notification");
        }
        ((ListingFragmentActivity)getActivity()).sendTrackingForSpokeEvent("SellingItemPhoto");
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        progress = view.findViewById(0x7f100143);
        parent = (LinearLayout)view.findViewById(0x7f1004bc);
        BaseSpokeFragment.showDoneButton(view, 0x7f070588, new android.view.View.OnClickListener() {

            final PhotosSpokeFragment this$0;

            public void onClick(View view1)
            {
                onBackPressed();
            }

            
            {
                this$0 = PhotosSpokeFragment.this;
                super();
            }
        });
    }

    protected void publishChanges()
    {
        if (adapter != null && adapter.modified())
        {
            adapter.resetModified();
            Object obj = adapter.getUrls();
            ArrayList arraylist = null;
            String s = arraylist;
            if (((ArrayList) (obj)).size() > 0)
            {
                s = arraylist;
                if (((PictureUrl)((ArrayList) (obj)).get(0)).stockPhoto)
                {
                    s = ((PictureUrl)((ArrayList) (obj)).remove(0)).url;
                }
            }
            arraylist = new ArrayList();
            for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(((PictureUrl)((Iterator) (obj)).next()).url)) { }
            dm.updatePhotos(s, arraylist);
        }
    }

    protected void saveOutstandingChanges(boolean flag)
    {
        if (flag)
        {
            dm.validateDraft();
        }
    }
}
