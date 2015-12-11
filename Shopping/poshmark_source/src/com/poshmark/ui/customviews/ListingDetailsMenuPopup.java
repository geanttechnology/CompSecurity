// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.fragments.ListingDetailsFragment;
import com.poshmark.utils.ReportListingDialog;

public class ListingDetailsMenuPopup extends PopupWindow
{

    TextView addToBundleButton;
    Context context;
    android.view.View.OnClickListener deleteButtonListener;
    TextView deleteListingButton;
    private boolean isItemSold;
    private boolean isListingAvailable;
    ListingDetails listingDetails;
    private boolean loggedInUser;
    ListingDetailsFragment parentFragment;
    View popupView;
    TextView reportListingButton;
    TextView viewBundleButton;

    public ListingDetailsMenuPopup()
    {
        deleteButtonListener = new android.view.View.OnClickListener() {

            final ListingDetailsMenuPopup this$0;

            public void onClick(View view)
            {
                if (listingDetails.getListingStatus() == com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.SOLD && !PMApplicationSession.GetPMSession().isUserAdmin())
                {
                    parentFragment.showAlertMessage("", context.getString(0x7f06016a));
                    return;
                } else
                {
                    parentFragment.showConfirmationMessage(context.getString(0x7f0600b8), context.getString(0x7f0600b9), new android.content.DialogInterface.OnClickListener() {

                        final _cls4 this$1;

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
                this$1 = _cls4.this;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                this$0 = ListingDetailsMenuPopup.this;
                super();
            }
        };
        setOutsideTouchable(true);
        setFocusable(true);
    }

    boolean isListingCreatorSameAsLoggedInUser()
    {
        return listingDetails.getUserId().equals(PMApplicationSession.GetPMSession().getUserId());
    }

    public void setup(ListingDetails listingdetails, ListingDetailsFragment listingdetailsfragment)
    {
        listingDetails = listingdetails;
        parentFragment = listingdetailsfragment;
        context = listingdetailsfragment.getActivity();
        popupView = LayoutInflater.from(listingdetailsfragment.getActivity()).inflate(0x7f030069, null);
        int i = listingdetailsfragment.getView().getWidth();
        setBackgroundDrawable(new ColorDrawable(0x106000d));
        setWindowLayoutMode(1, -2);
        setWidth(i - i / 3);
        setContentView(popupView);
        updateDrawer(false);
    }

    public void showPopup(View view)
    {
        int ai[] = new int[2];
        int i = parentFragment.getView().getWidth();
        view.getLocationOnScreen(ai);
        showAtLocation(view, 0, i - i / 3 - 10, ai[1] + 5);
        (new String("test")).charAt(1);
    }

    public void updateDrawer(boolean flag)
    {
label0:
        {
            if (popupView != null)
            {
                deleteListingButton = (TextView)popupView.findViewById(0x7f0c0196);
                reportListingButton = (TextView)popupView.findViewById(0x7f0c0191);
                viewBundleButton = (TextView)popupView.findViewById(0x7f0c00ba);
                addToBundleButton = (TextView)popupView.findViewById(0x7f0c0192);
                loggedInUser = isListingCreatorSameAsLoggedInUser();
                isListingAvailable = listingDetails.isListingAvailable();
                isItemSold = listingDetails.isListingSold();
                if (!loggedInUser)
                {
                    break label0;
                }
                addToBundleButton.setVisibility(8);
                viewBundleButton.setVisibility(8);
                reportListingButton.setVisibility(8);
                deleteListingButton.setVisibility(0);
                deleteListingButton.setText(context.getString(0x7f0600b8));
                deleteListingButton.setOnClickListener(deleteButtonListener);
            }
            return;
        }
        if (PMApplicationSession.GetPMSession().isUserAdmin())
        {
            deleteListingButton.setVisibility(0);
            deleteListingButton.setText(context.getString(0x7f0600b8));
            deleteListingButton.setOnClickListener(deleteButtonListener);
        } else
        {
            deleteListingButton.setVisibility(8);
        }
        reportListingButton.setVisibility(0);
        viewBundleButton.setVisibility(0);
        addToBundleButton.setVisibility(0);
        addToBundleButton.setText(context.getString(0x7f060037));
        addToBundleButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ListingDetailsMenuPopup this$0;

            public void onClick(View view)
            {
                view = (PMContainerActivity)context;
                dismiss();
                view = new Bundle();
                view.putParcelable("PARENT_ID", new ParcelUuid(parentFragment.getFragmentId()));
                PMNotificationManager.fireNotification("com.poshmark.intents.ADD_TO_BUNDLE_ACTION", view);
            }

            
            {
                this$0 = ListingDetailsMenuPopup.this;
                super();
            }
        });
        viewBundleButton.setText(context.getString(0x7f0602bc));
        viewBundleButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ListingDetailsMenuPopup this$0;

            public void onClick(View view)
            {
                view = (PMContainerActivity)context;
                dismiss();
                view = new Bundle();
                view.putParcelable("PARENT_ID", new ParcelUuid(parentFragment.getFragmentId()));
                PMNotificationManager.fireNotification("com.poshmark.intents.VIEW_BUNDLE_ACTION", view);
            }

            
            {
                this$0 = ListingDetailsMenuPopup.this;
                super();
            }
        });
        reportListingButton.setText(context.getString(0x7f060226));
        reportListingButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ListingDetailsMenuPopup this$0;

            public void onClick(View view)
            {
                view = (PMContainerActivity)context;
                dismiss();
                (new ReportListingDialog(view, new com.poshmark.utils.ReportListingDialog.ReportReasonListener() {

                    final _cls3 this$1;

                    public void reasonPicked(String s)
                    {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("PARENT_ID", new ParcelUuid(parentFragment.getFragmentId()));
                        bundle.putString("REPORT_REASON", s);
                        PMNotificationManager.fireNotification("com.poshmark.intents.REPORT_LISTING_ACTION", bundle);
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                })).show();
            }

            
            {
                this$0 = ListingDetailsMenuPopup.this;
                super();
            }
        });
    }
}
