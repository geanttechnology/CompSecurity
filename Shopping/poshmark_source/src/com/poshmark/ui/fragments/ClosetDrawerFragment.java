// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.utils.ReportUserDialog;
import java.util.UUID;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

public class ClosetDrawerFragment extends PMFragment
    implements PMNotificationListener
{

    Button blockUserButton;
    boolean isUserBlocked;
    UUID parentFragmentId;
    Button reportUserButton;
    Button shareClosetButton;
    Button unblockUserButton;
    String userId;
    Button viewBundleButton;

    public ClosetDrawerFragment()
    {
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.SET_BLOCK_USER_STATUS_ACTION"))
        {
            intent = intent.getBundleExtra("RESULT");
            ParcelUuid parceluuid = (ParcelUuid)intent.getParcelable("PARENT_ID");
            if (parentFragmentId.equals(parceluuid.getUuid()))
            {
                isUserBlocked = intent.getBoolean("BLOCK_USER_STATUS");
                updateViews();
            }
        }
    }

    public void logScreenTracking()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = (PMContainerActivity)getActivity();
        updateViews();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        fragmentType = PMFragment.FRAGMENT_TYPE.DRAWER;
        if (bundle == null)
        {
            bundle = (Bundle)getFragmentDataOfType(android/os/Bundle);
            if (bundle != null)
            {
                parentFragmentId = ((ParcelUuid)bundle.getParcelable("PARENT_FRAGMENT_ID")).getUuid();
                userId = bundle.getString("USER_ID");
                isUserBlocked = bundle.getBoolean("BLOCK_USER_STATUS");
            }
            return;
        } else
        {
            parentFragmentId = ((ParcelUuid)bundle.getParcelable("PARENT_FRAGMENT_ID")).getUuid();
            userId = bundle.getString("USER_ID");
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f030025, viewgroup, false);
    }

    public void onDestroyView()
    {
        super.onDestroyView();
    }

    public void onPMResume()
    {
        super.onPMResume();
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.SET_BLOCK_USER_STATUS_ACTION", this);
    }

    public void onPause()
    {
        super.onPause();
        PMNotificationManager.getNotificationManager().unregisterAllEvents(this);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("PARENT_FRAGMENT_ID", new ParcelUuid(parentFragmentId));
        bundle.putString("USER_ID", userId);
    }

    public void setViewNameForAnalytics()
    {
    }

    public void updateViews()
    {
        byte byte0 = 0;
        boolean flag = byte0;
        if (userId.equals(PMApplicationSession.GetPMSession().getUserId()))
        {
            flag = byte0;
            if (PMApplicationSession.GetPMSession().isLoggedIn())
            {
                flag = true;
            }
        }
        viewBundleButton = (Button)getView().findViewById(0x7f0c00ba);
        viewBundleButton.setText(getString(0x7f0602bc));
        Button button = viewBundleButton;
        if (flag)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        button.setVisibility(byte0);
        viewBundleButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ClosetDrawerFragment this$0;

            public void onClick(View view)
            {
                ((PMContainerActivity)getActivity()).hideDrawer();
                view = new Bundle();
                view.putParcelable("PARENT_ID", new ParcelUuid(parentFragmentId));
                PMNotificationManager.fireNotification("com.poshmark.intents.VIEW_BUNDLE_ACTION", view);
            }

            
            {
                this$0 = ClosetDrawerFragment.this;
                super();
            }
        });
        shareClosetButton = (Button)getView().findViewById(0x7f0c00bb);
        shareClosetButton.setText(getString(0x7f060255));
        reportUserButton = (Button)getView().findViewById(0x7f0c00bc);
        reportUserButton.setText(getString(0x7f060227));
        shareClosetButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ClosetDrawerFragment this$0;

            public void onClick(View view)
            {
                view = new Bundle();
                view.putParcelable("PARENT_ID", new ParcelUuid(parentFragmentId));
                PMNotificationManager.fireNotification("com.poshmark.intents.SHARE_CLOSET_ACTION", view);
                ((PMContainerActivity)getActivity()).hideDrawer();
            }

            
            {
                this$0 = ClosetDrawerFragment.this;
                super();
            }
        });
        reportUserButton = (Button)getView().findViewById(0x7f0c00bc);
        reportUserButton.setText(getString(0x7f060227));
        button = reportUserButton;
        if (flag)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        button.setVisibility(byte0);
        reportUserButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ClosetDrawerFragment this$0;

            public void onClick(View view)
            {
                ((PMContainerActivity)getActivity()).hideDrawer();
                (new ReportUserDialog(getActivity(), new com.poshmark.utils.ReportUserDialog.ReportReasonListener() {

                    final _cls3 this$1;

                    public void reasonPicked(String s)
                    {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("PARENT_ID", new ParcelUuid(parentFragmentId));
                        bundle.putString("REPORT_REASON", s);
                        PMNotificationManager.fireNotification("com.poshmark.intents.REPORT_USER_ACTION", bundle);
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                })).show();
            }

            
            {
                this$0 = ClosetDrawerFragment.this;
                super();
            }
        });
        blockUserButton = (Button)getView().findViewById(0x7f0c00bd);
        unblockUserButton = (Button)getView().findViewById(0x7f0c00be);
        if (flag)
        {
            blockUserButton.setVisibility(8);
            unblockUserButton.setVisibility(8);
            return;
        }
        if (isUserBlocked)
        {
            blockUserButton.setVisibility(8);
            unblockUserButton.setVisibility(0);
            unblockUserButton = (Button)getView().findViewById(0x7f0c00be);
            unblockUserButton.setText(getString(0x7f0602a4));
            unblockUserButton.setOnClickListener(new android.view.View.OnClickListener() {

                final ClosetDrawerFragment this$0;

                public void onClick(View view)
                {
                    ((PMContainerActivity)getActivity()).hideDrawer();
                    showConfirmationMessage("Unblock User", "Are you sure you want to unblock this user?", new android.content.DialogInterface.OnClickListener() {

                        final _cls4 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            if (i == -1)
                            {
                                dialoginterface = new Bundle();
                                dialoginterface.putParcelable("PARENT_ID", new ParcelUuid(parentFragmentId));
                                PMNotificationManager.fireNotification("com.poshmark.intents.UNBLOCK_USER_ACTION", dialoginterface);
                            }
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                }

            
            {
                this$0 = ClosetDrawerFragment.this;
                super();
            }
            });
            return;
        } else
        {
            unblockUserButton.setVisibility(8);
            blockUserButton.setVisibility(0);
            blockUserButton.setText(getString(0x7f060054));
            blockUserButton.setOnClickListener(new android.view.View.OnClickListener() {

                final ClosetDrawerFragment this$0;

                public void onClick(View view)
                {
                    ((PMContainerActivity)getActivity()).hideDrawer();
                    showConfirmationMessage("Block User", "Are you sure you want to block this user?", new android.content.DialogInterface.OnClickListener() {

                        final _cls5 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            if (i == -1)
                            {
                                dialoginterface = new Bundle();
                                dialoginterface.putParcelable("PARENT_ID", new ParcelUuid(parentFragmentId));
                                PMNotificationManager.fireNotification("com.poshmark.intents.BLOCK_USER_ACTION", dialoginterface);
                            }
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                }

            
            {
                this$0 = ClosetDrawerFragment.this;
                super();
            }
            });
            return;
        }
    }
}
