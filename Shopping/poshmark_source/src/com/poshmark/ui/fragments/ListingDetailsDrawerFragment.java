// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.utils.ReportListingDialog;
import java.util.UUID;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, ListingDetailsFragment

public class ListingDetailsDrawerFragment extends PMFragment
    implements PMNotificationListener
{

    Button addToBundleButton;
    private boolean bUpdateViews;
    android.view.View.OnClickListener deleteButtonListener;
    Button deleteListingButton;
    Button editListingButton;
    private boolean isItemSold;
    private boolean isListingAvailable;
    int layoutName;
    private boolean loggedInUser;
    Button markAsAvailableButton;
    Button markNotForSaleButton;
    ListingDetailsFragment parentFragment;
    Button reportListingButton;
    Button viewBundleButton;

    public ListingDetailsDrawerFragment()
    {
        bUpdateViews = true;
        deleteButtonListener = new android.view.View.OnClickListener() {

            final ListingDetailsDrawerFragment this$0;

            public void onClick(View view)
            {
                ((PMContainerActivity)getActivity()).hideDrawer();
                if (parentFragment.listingDetails.getListingStatus() == com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.SOLD && !PMApplicationSession.GetPMSession().isUserAdmin())
                {
                    showAlertMessage("", getString(0x7f06016a));
                    return;
                } else
                {
                    showConfirmationMessage(getString(0x7f0600b8), getString(0x7f0600b9), new android.content.DialogInterface.OnClickListener() {

                        final _cls7 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            if (i == -1)
                            {
                                dialoginterface = new Bundle();
                                dialoginterface.putParcelable("PARENT_ID", new ParcelUuid(parentFragment.getFragmentId()));
                                PMNotificationManager.fireNotification("com.poshmark.intents.DELETE_LISTING_ACTION", dialoginterface);
                            }
                        }

            
            {
                this$1 = _cls7.this;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                this$0 = ListingDetailsDrawerFragment.this;
                super();
            }
        };
    }

    boolean isListingCreatorSameAsLoggedInUser()
    {
        return parentFragment.listingDetails.getUserId().equals(PMApplicationSession.GetPMSession().getUserId());
    }

    public void logScreenTracking()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        fragmentType = PMFragment.FRAGMENT_TYPE.DRAWER;
        if (bundle == null)
        {
            parentFragment = (ListingDetailsFragment)getFragmentDataOfType(com/poshmark/ui/fragments/ListingDetailsFragment);
            return;
        } else
        {
            parentFragment = (ListingDetailsFragment)getActivity().getSupportFragmentManager().getFragment(bundle, getFragmentId().toString());
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutName = 0x7f030066;
        return layoutinflater.inflate(layoutName, viewgroup, false);
    }

    public void onDestroyView()
    {
        super.onDestroyView();
    }

    public void onPMResume()
    {
        super.onPMResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        getActivity().getSupportFragmentManager().putFragment(bundle, getFragmentId().toString(), parentFragment);
    }

    public void setViewNameForAnalytics()
    {
    }

    public void updateDrawer(boolean flag)
    {
        if (getView() != null && (bUpdateViews || flag))
        {
            editListingButton = (Button)getView().findViewById(0x7f0c0193);
            markNotForSaleButton = (Button)getView().findViewById(0x7f0c0194);
            markAsAvailableButton = (Button)getView().findViewById(0x7f0c0195);
            deleteListingButton = (Button)getView().findViewById(0x7f0c0196);
            reportListingButton = (Button)getView().findViewById(0x7f0c0191);
            viewBundleButton = (Button)getView().findViewById(0x7f0c00ba);
            addToBundleButton = (Button)getView().findViewById(0x7f0c0192);
            loggedInUser = isListingCreatorSameAsLoggedInUser();
            isListingAvailable = parentFragment.listingDetails.isListingAvailable();
            isItemSold = parentFragment.listingDetails.isListingSold();
            if (loggedInUser)
            {
                addToBundleButton.setVisibility(8);
                viewBundleButton.setVisibility(8);
                reportListingButton.setVisibility(8);
                deleteListingButton.setVisibility(0);
                editListingButton.setVisibility(0);
                editListingButton.setText(getString(0x7f0600c4));
                editListingButton.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListingDetailsDrawerFragment this$0;

                    public void onClick(View view)
                    {
                        ((PMContainerActivity)getActivity()).hideDrawer();
                        view = new Bundle();
                        view.putParcelable("PARENT_ID", new ParcelUuid(parentFragment.getFragmentId()));
                        PMNotificationManager.fireNotification("com.poshmark.intents.EDIT_LISTING_ACTION", view);
                    }

            
            {
                this$0 = ListingDetailsDrawerFragment.this;
                super();
            }
                });
                if (isItemSold)
                {
                    markNotForSaleButton.setVisibility(8);
                    markAsAvailableButton.setVisibility(8);
                } else
                {
                    markNotForSaleButton.setVisibility(0);
                    markAsAvailableButton.setVisibility(0);
                }
                if (isListingAvailable)
                {
                    markNotForSaleButton.setText(getString(0x7f0601a1));
                    markAsAvailableButton.setVisibility(8);
                } else
                {
                    markAsAvailableButton.setText(getString(0x7f06019d));
                    markNotForSaleButton.setVisibility(8);
                }
                markNotForSaleButton.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListingDetailsDrawerFragment this$0;

                    public void onClick(View view)
                    {
                        ((PMContainerActivity)getActivity()).hideDrawer();
                        showConfirmationMessage(getString(0x7f06019f), getString(0x7f0601a2), new android.content.DialogInterface.OnClickListener() {

                            final _cls2 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                if (i == -1)
                                {
                                    dialoginterface = new Bundle();
                                    dialoginterface.putParcelable("PARENT_ID", new ParcelUuid(parentFragment.getFragmentId()));
                                    PMNotificationManager.fireNotification("com.poshmark.intents.NOT_FOR_SALE_LISTING_ACTION", dialoginterface);
                                }
                            }

            
            {
                this$1 = _cls2.this;
                super();
            }
                        });
                    }

            
            {
                this$0 = ListingDetailsDrawerFragment.this;
                super();
            }
                });
                markAsAvailableButton.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListingDetailsDrawerFragment this$0;

                    public void onClick(View view)
                    {
                        ((PMContainerActivity)getActivity()).hideDrawer();
                        showConfirmationMessage(getString(0x7f06019f), getString(0x7f06019e), new android.content.DialogInterface.OnClickListener() {

                            final _cls3 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                if (i == -1)
                                {
                                    dialoginterface = new Bundle();
                                    dialoginterface.putParcelable("PARENT_ID", new ParcelUuid(parentFragment.getFragmentId()));
                                    PMNotificationManager.fireNotification("com.poshmark.intents.MAKE_AVAILABLE_LISTING_ACTION", dialoginterface);
                                }
                            }

            
            {
                this$1 = _cls3.this;
                super();
            }
                        });
                    }

            
            {
                this$0 = ListingDetailsDrawerFragment.this;
                super();
            }
                });
                deleteListingButton.setText(getString(0x7f0600b8));
                deleteListingButton.setOnClickListener(deleteButtonListener);
            } else
            {
                if (PMApplicationSession.GetPMSession().isUserAdmin())
                {
                    deleteListingButton.setVisibility(0);
                    deleteListingButton.setText(getString(0x7f0600b8));
                    deleteListingButton.setOnClickListener(deleteButtonListener);
                } else
                {
                    deleteListingButton.setVisibility(8);
                }
                editListingButton.setVisibility(8);
                markAsAvailableButton.setVisibility(8);
                markNotForSaleButton.setVisibility(8);
                reportListingButton.setVisibility(0);
                viewBundleButton.setVisibility(0);
                addToBundleButton.setVisibility(0);
                addToBundleButton.setText(getString(0x7f060037));
                addToBundleButton.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListingDetailsDrawerFragment this$0;

                    public void onClick(View view)
                    {
                        ((PMContainerActivity)getActivity()).hideDrawer();
                        view = new Bundle();
                        view.putParcelable("PARENT_ID", new ParcelUuid(parentFragment.getFragmentId()));
                        PMNotificationManager.fireNotification("com.poshmark.intents.ADD_TO_BUNDLE_ACTION", view);
                    }

            
            {
                this$0 = ListingDetailsDrawerFragment.this;
                super();
            }
                });
                viewBundleButton.setText(getString(0x7f0602bc));
                viewBundleButton.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListingDetailsDrawerFragment this$0;

                    public void onClick(View view)
                    {
                        ((PMContainerActivity)getActivity()).hideDrawer();
                        view = new Bundle();
                        view.putParcelable("PARENT_ID", new ParcelUuid(parentFragment.getFragmentId()));
                        PMNotificationManager.fireNotification("com.poshmark.intents.VIEW_BUNDLE_ACTION", view);
                    }

            
            {
                this$0 = ListingDetailsDrawerFragment.this;
                super();
            }
                });
                reportListingButton.setText(getString(0x7f060226));
                reportListingButton.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListingDetailsDrawerFragment this$0;

                    public void onClick(View view)
                    {
                        ((PMContainerActivity)getActivity()).hideDrawer();
                        (new ReportListingDialog(getActivity(), new com.poshmark.utils.ReportListingDialog.ReportReasonListener() {

                            final _cls6 this$1;

                            public void reasonPicked(String s)
                            {
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("PARENT_ID", new ParcelUuid(parentFragment.getFragmentId()));
                                bundle.putString("REPORT_REASON", s);
                                PMNotificationManager.fireNotification("com.poshmark.intents.REPORT_LISTING_ACTION", bundle);
                            }

            
            {
                this$1 = _cls6.this;
                super();
            }
                        })).show();
                    }

            
            {
                this$0 = ListingDetailsDrawerFragment.this;
                super();
            }
                });
            }
            bUpdateViews = false;
        }
    }
}
