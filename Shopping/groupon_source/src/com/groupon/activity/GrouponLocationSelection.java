// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.groupon.adapter.GrouponLocationSelectionListAdapter;
import com.groupon.db.dao.DaoMyGrouponItem;
import com.groupon.http.Http;
import com.groupon.models.place.GrouponIdContainer;
import com.groupon.models.place.PlaceContainer;
import com.groupon.service.LoginService;
import com.groupon.util.DialogManager;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponListActivity

public class GrouponLocationSelection extends GrouponListActivity
    implements GrouponDialogListener
{
    protected class SetPlaceHttp extends Http
    {

        final GrouponLocationSelection this$0;

        protected void onException(Exception exception)
        {
            super.onException(exception);
        }

        protected void onFinally()
        {
            super.onFinally();
            ((GrouponLocationSelectionListAdapter)getListAdapter()).setAllItemsEnabled(true);
            showItemProgress(false);
        }

        protected void onSuccess(PlaceContainer placecontainer)
            throws Exception
        {
            placecontainer = placecontainer.groupon.id;
            updateGrouponNumberAndLocated(placecontainer);
            setResult(-1);
            finish();
        }

        protected volatile void onSuccess(Object obj)
            throws Exception
        {
            onSuccess((PlaceContainer)obj);
        }

        public SetPlaceHttp()
        {
            this$0 = GrouponLocationSelection.this;
            super(GrouponLocationSelection.this, com/groupon/models/place/PlaceContainer, getUrl());
        }
    }


    private static final String GROUPON_LOCATION_SELECTION_DIALOG = "groupon_location_selection_dialog";
    public static final int REQUEST_CODE = 10141;
    public static final String SET_PLACE_URL = "https:/users/%1$s/groupons/%2$s/set_place";
    private DialogManager dialogManager;
    String grouponId;
    private DaoMyGrouponItem grouponItemDao;
    HashMap locationAddressIdPairs;
    private List locationsAddress;
    private LoginService loginService;
    private int selectedItemIndex;
    private String selectedLocationId;

    public GrouponLocationSelection()
    {
        locationsAddress = new ArrayList();
    }

    private String getUrl()
    {
        return String.format("https:/users/%1$s/groupons/%2$s/set_place", new Object[] {
            loginService.getUserId(), grouponId
        });
    }

    private void setLocation()
    {
        (new SetPlaceHttp()).method("POST").nvps(new Object[] {
            "place", selectedLocationId
        }).execute();
    }

    private void showItemProgress(boolean flag)
    {
        GrouponLocationSelectionListAdapter grouponlocationselectionlistadapter = (GrouponLocationSelectionListAdapter)getListAdapter();
        grouponlocationselectionlistadapter.setShowItemProgressIndicator(flag);
        grouponlocationselectionlistadapter.notifyDataSetChanged();
    }

    private void updateGrouponNumberAndLocated(final String grouponNumber)
    {
        try
        {
            grouponItemDao.callBatchTasks(new Callable() {

                final GrouponLocationSelection this$0;
                final String val$grouponNumber;

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

                public Void call()
                    throws Exception
                {
                    grouponItemDao.updateGrouponNumberAndLocatedById(grouponId, grouponNumber, true);
                    return null;
                }

            
            {
                this$0 = GrouponLocationSelection.this;
                grouponNumber = s;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (final String grouponNumber)
        {
            return;
        }
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getString(0x7f08035b));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        java.util.Map.Entry entry;
        for (bundle = locationAddressIdPairs.entrySet().iterator(); bundle.hasNext(); locationsAddress.add(entry.getKey()))
        {
            entry = (java.util.Map.Entry)bundle.next();
        }

        setListAdapter(new GrouponLocationSelectionListAdapter(this, -1, locationsAddress));
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogItemClick(String s, DialogInterface dialoginterface, int i)
    {
    }

    public void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag)
    {
    }

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "groupon_location_selection_dialog"))
        {
            s = (GrouponLocationSelectionListAdapter)getListAdapter();
            s.setAllItemsEnabled(false);
            s.setProgressItemIndex(selectedItemIndex);
            showItemProgress(true);
            setLocation();
        }
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
        super.onListItemClick(listview, view, i, l);
        listview = (String)locationsAddress.get(i);
        selectedItemIndex = i;
        selectedLocationId = (String)locationAddressIdPairs.get(listview);
        GrouponDialogFragment.show(getFragmentManager(), dialogManager.getDialogFragment(Integer.valueOf(0x7f080258), Integer.valueOf(0x7f080259), Integer.valueOf(0x7f0804fe), Integer.valueOf(0x7f080084), false), "groupon_location_selection_dialog");
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        if (bundle != null && bundle.containsKey("selected_location_id"))
        {
            selectedLocationId = bundle.getString("selected_location_id");
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (bundle != null && Strings.notEmpty(selectedLocationId))
        {
            bundle.putString("selected_location_id", selectedLocationId);
        }
    }




}
