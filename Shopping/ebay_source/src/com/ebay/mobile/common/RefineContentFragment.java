// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.ebay.app.AlertDialogFragment;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.mobile.activities.BaseFragment;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.common:
//            ListSelectionHandler, ListSelector, SimpleRefineFragment

public abstract class RefineContentFragment extends BaseFragment
    implements android.view.View.OnClickListener, DialogFragmentCallback, ListSelector.OnSelectionChangeListener, SimpleRefineFragment.SimpleRefineCallback
{

    protected static final int DIALOG_CONFIRM_DELETE = 0;
    protected static final String STATE_IS_DRAWER_OPEN = "drawerOpen";
    private static final String STATE_IS_EDIT_ENABLED = "editEnabled";
    private static final String STATE_IS_REFINE_ENABLED = "refineEnabled";
    private View cancelButton;
    private View deleteButton;
    private ViewGroup deleteFloatingBar;
    protected DrawerLayout drawerLayout;
    private View editButton;
    private boolean isEditAvailable;
    private boolean isRefineEnabled;
    private boolean isShowingDeleteDialog;
    protected View refineButton;
    protected SimpleRefineFragment refineFragment;
    protected ListSelector selectionModeHandler;

    public RefineContentFragment()
    {
        isShowingDeleteDialog = false;
        selectionModeHandler = new ListSelectionHandler();
    }

    private void leaveEditMode()
    {
        selectionModeHandler.setIsSelectionEnabled(false);
        setEditAvailability(true);
        setRefineVisible(isRefineEnabled);
    }

    private void setRefineVisible(boolean flag)
    {
        boolean flag1 = false;
        if (isRefineEnabled)
        {
            Object obj = refineButton;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((View) (obj)).setVisibility(i);
            obj = drawerLayout;
            if (flag)
            {
                i = ((flag1) ? 1 : 0);
            } else
            {
                i = 1;
            }
            ((DrawerLayout) (obj)).setDrawerLockMode(i);
        }
    }

    private void showConfirmDeleteDialog()
    {
        com.ebay.app.AlertDialogFragment.Builder builder = new com.ebay.app.AlertDialogFragment.Builder();
        builder.setMessage(getResources().getString(0x7f07025f));
        builder.setNegativeButton(0x1040009);
        builder.setPositiveButton(0x7f070cc7);
        builder.createFromFragment(0, this).show(getFragmentManager(), getClass().getName());
    }

    private void updateDeleteFooter(boolean flag, boolean flag1)
    {
        if (deleteFloatingBar != null)
        {
            ViewGroup viewgroup = deleteFloatingBar;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            viewgroup.setVisibility(i);
        }
        if (editButton != null)
        {
            deleteButton.setEnabled(flag1);
        }
    }

    protected void clearRefinePanelAndRequery()
    {
        refineFragment.forceReloadData();
    }

    protected void clearSelectedItems()
    {
        if (selectionModeHandler != null)
        {
            selectionModeHandler.clearSelectedItems();
        }
    }

    public void closeRefinePanel()
    {
        drawerLayout.closeDrawer(5);
    }

    protected void deleteItems(List list)
    {
    }

    protected boolean doesHeaderContainSpinner()
    {
        return false;
    }

    public List getFilterByRefinements()
    {
        return null;
    }

    public List getSortByRefinements()
    {
        return null;
    }

    protected String getTitleText(Resources resources)
    {
        return "";
    }

    protected boolean hasCustomLayoutHandling()
    {
        return false;
    }

    public boolean isInEditMode()
    {
        return isEditAvailable && selectionModeHandler.getIsSelectionEnabled() && !hasCustomLayoutHandling();
    }

    public boolean isRefinePanelOpen()
    {
        return drawerLayout != null && drawerLayout.isDrawerOpen(5);
    }

    protected void notifyRefineFragmentOfChange()
    {
        refineFragment.updateRecyclerView();
    }

    protected void onCancelPressed()
    {
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 4: default 48
    //                   2131755370: 90
    //                   2131756354: 49
    //                   2131756355: 74
    //                   2131756358: 95;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L3:
        selectionModeHandler.setIsSelectionEnabled(true);
        setEditAvailability(true);
        setRefineVisible(false);
        onEditPressed();
        return;
_L4:
        if (!isShowingDeleteDialog)
        {
            leaveEditMode();
            onCancelPressed();
            return;
        }
          goto _L1
_L2:
        showConfirmDeleteDialog();
        return;
_L5:
        openRefinePanel();
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        selectionModeHandler = new ListSelectionHandler(this);
    }

    protected View onCreateCustomView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return null;
    }

    protected abstract View onCreateMainContentView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle);

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (hasCustomLayoutHandling())
        {
            return onCreateCustomView(layoutinflater, viewgroup, bundle);
        }
        drawerLayout = (DrawerLayout)layoutinflater.inflate(0x7f0301bb, viewgroup, false);
        Object obj = layoutinflater.getContext();
        FrameLayout framelayout = (FrameLayout)drawerLayout.findViewById(0x7f1001a2);
        View view = layoutinflater.inflate(0x7f0301ba, framelayout, false);
        framelayout.addView(view);
        if (doesHeaderContainSpinner())
        {
            view.findViewById(0x7f100544).setVisibility(8);
            obj = (Spinner)view.findViewById(0x7f100545);
            ((Spinner) (obj)).setVisibility(0);
            onInitializeSpinner(((Spinner) (obj)));
        } else
        {
            obj = getTitleText(((Context) (obj)).getResources());
            TextView textview = (TextView)view.findViewById(0x7f100544);
            textview.setText(((CharSequence) (obj)));
            textview.setVisibility(0);
            view.findViewById(0x7f100545).setVisibility(8);
        }
        editButton = view.findViewById(0x7f100542);
        editButton.setOnClickListener(this);
        refineButton = view.findViewById(0x7f100546);
        refineButton.setOnClickListener(this);
        cancelButton = view.findViewById(0x7f100543);
        cancelButton.setOnClickListener(this);
        deleteFloatingBar = (ViewGroup)drawerLayout.findViewById(0x7f100169);
        deleteButton = deleteFloatingBar.findViewById(0x7f10016a);
        deleteButton.setOnClickListener(this);
        refineFragment = (SimpleRefineFragment)getFragmentManager().findFragmentById(0x7f100547);
        refineFragment.setSimpleRefineCallback(this);
        ((FrameLayout)drawerLayout.findViewById(0x7f1001a3)).addView(onCreateMainContentView(layoutinflater, viewgroup, bundle));
        if (bundle != null)
        {
            if (bundle.getBoolean("drawerOpen", false))
            {
                openRefinePanel();
            }
            selectionModeHandler.restoreState(bundle);
            setEditAvailability(bundle.getBoolean("editEnabled"));
            setRefineAvailability(bundle.getBoolean("refineEnabled"));
        } else
        {
            setEditAvailability(false);
            drawerLayout.setDrawerLockMode(1);
            setRefineAvailability(false);
        }
        return drawerLayout;
    }

    public final void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        isShowingDeleteDialog = false;
        i;
        JVM INSTR tableswitch 0 0: default 24
    //                   0 25;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j == 1)
        {
            dialogfragment = new ArrayList(selectionModeHandler.getSelectedItems());
            leaveEditMode();
            deleteItems(dialogfragment);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onDonePressed()
    {
        closeRefinePanel();
    }

    protected void onEditPressed()
    {
    }

    public void onHardwareBackWhileEditing()
    {
        if (!hasCustomLayoutHandling())
        {
            leaveEditMode();
            clearSelectedItems();
        }
    }

    protected void onInitializeSpinner(Spinner spinner)
    {
    }

    public void onLeavingViaNavigation()
    {
        if (!hasCustomLayoutHandling())
        {
            leaveEditMode();
            clearSelectedItems();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("refineEnabled", isRefineEnabled);
        bundle.putBoolean("drawerOpen", drawerLayout.isDrawerOpen(5));
        bundle.putBoolean("editEnabled", isEditAvailable);
        selectionModeHandler.saveState(bundle);
    }

    public void onSelectionChanged(boolean flag)
    {
        updateDeleteFooter(true, selectionModeHandler.hasSelectedItems());
    }

    public void openRefinePanel()
    {
        drawerLayout.openDrawer(5);
    }

    protected void setEditAvailability(boolean flag)
    {
        isEditAvailable = flag;
        if (flag && selectionModeHandler.getIsSelectionEnabled())
        {
            editButton.setVisibility(8);
            cancelButton.setVisibility(0);
            updateDeleteFooter(true, selectionModeHandler.hasSelectedItems());
            return;
        }
        View view = editButton;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        cancelButton.setVisibility(8);
        updateDeleteFooter(false, false);
    }

    protected void setRefineAvailability(boolean flag)
    {
        int i = 8;
        boolean flag1 = false;
        isRefineEnabled = flag;
        if (flag && selectionModeHandler.getIsSelectionEnabled())
        {
            setRefineVisible(false);
            return;
        }
        if (drawerLayout.isDrawerOpen(5))
        {
            View view = refineButton;
            if (flag)
            {
                i = 0;
            }
            view.setVisibility(i);
            drawerLayout.setDrawerLockMode(0);
            return;
        }
        Object obj = refineButton;
        if (flag)
        {
            i = 0;
        }
        ((View) (obj)).setVisibility(i);
        obj = drawerLayout;
        if (flag)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 1;
        }
        ((DrawerLayout) (obj)).setDrawerLockMode(i);
    }
}
