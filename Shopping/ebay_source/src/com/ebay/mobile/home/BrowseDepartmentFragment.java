// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.mobile.deals.BrowseDealsActivity;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.content.dm.UssChannelsDataManager;
import com.ebay.nautilus.domain.content.dm.UssContentsDataManager;
import com.ebay.nautilus.domain.data.UnifiedStream.Channel;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelsContainer;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import com.ebay.nautilus.domain.data.UnifiedStream.KeyValue;
import com.ebay.nautilus.domain.data.UnifiedStream.OutputSelector;
import com.ebay.nautilus.domain.data.cos.base.Text;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home:
//            BrowseDepartmentActivity, UssContentsViewAdapter

public class BrowseDepartmentFragment extends BaseFragment
    implements android.widget.AdapterView.OnItemSelectedListener, com.ebay.nautilus.domain.content.dm.UssChannelsDataManager.Observer, com.ebay.nautilus.domain.content.dm.UssContentsDataManager.Observer
{
    protected static class CategorySpinnerAdapter extends ArrayAdapter
    {

        private final int dropDownResource;
        private final LayoutInflater inflater;
        private final int textColorPrimary;

        public View getDropDownView(int i, View view, ViewGroup viewgroup)
        {
            View view1 = view;
            if (view == null)
            {
                view1 = inflater.inflate(dropDownResource, viewgroup, false);
            }
            view = (SpinnerSelection)getItem(i);
            viewgroup = (TextView)view1.findViewById(0x1020014);
            viewgroup.setText(view.toString());
            if (((SpinnerSelection) (view)).isSelected)
            {
                viewgroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0x7f0201c3, 0);
                viewgroup.setTextAppearance(getContext(), 0x7f0a0154);
                viewgroup.setTextColor(textColorPrimary);
                return view1;
            } else
            {
                viewgroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                viewgroup.setTextAppearance(getContext(), 0x7f0a013f);
                viewgroup.setTextColor(textColorPrimary);
                return view1;
            }
        }

        public CategorySpinnerAdapter(Context context, int i, int j, int k, List list)
        {
            super(context, i, j, list);
            setDropDownViewResource(k);
            inflater = LayoutInflater.from(context);
            dropDownResource = k;
            textColorPrimary = ThemeUtil.resolveThemeColor(context.getResources(), context.getTheme(), 0x1010036);
        }
    }

    protected static final class SpinnerSelection
    {

        public String department;
        private String display;
        public boolean isDepartment;
        boolean isSelected;

        public String toString()
        {
            return display;
        }


        public SpinnerSelection(boolean flag, String s, String s1)
        {
            isDepartment = flag;
            department = s;
            display = s1;
        }
    }


    public static final String EXTRA_BROWSE_TYPE = "browse_type";
    public static final String EXTRA_DEPARTMENT_ID = "department_id";
    public static final String EXTRA_DEPARTMENT_TITLE = "department_title";
    public static final String EXTRA_SOURCE_DEPARTMENT_ID = "source_department_id";
    public static final String EXTRA_TOP_LEVEL_CHANNEL = "top_level_channel";
    public static final String FEATURED_CHANNEL_BROWSE = "FEATURED";
    public static final String SUB_DEPARTMENT_BROWSE = "SUB_DEPARTMENT";
    private static String currentTopLevelChannel;
    protected static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logInfo = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("BrowseDepartment", 3, "Browse Department Fragment");
    private RecyclerContentAdapter adapter;
    private List channels;
    private View container;
    private String currentBrowseType;
    private EbayCountry currentCountry;
    protected String currentDepartmentId;
    protected String currentDepartmentTitle;
    private Spinner departmentSpinner;
    private View progressView;
    private RecyclerView recyclerView;
    protected SpinnerSelection selectedSpinnerItem;
    protected String sourceDepartmentId;
    private CategorySpinnerAdapter spinnerAdapter;
    protected ArrayAdapter spinnerSelectionAdapter;
    protected ArrayList spinnerSelections;
    private TextView subDepartmentTitleView;
    private UssChannelsDataManager ussChannelsDataManager;

    public BrowseDepartmentFragment()
    {
    }

    private Channel findTargetTopLevelChannel(String s, List list)
    {
        Object obj = null;
        Channel channel = obj;
        if (list != null)
        {
            channel = obj;
            if (list.size() > 0)
            {
                list = list.iterator();
                do
                {
                    channel = obj;
                    if (!list.hasNext())
                    {
                        break;
                    }
                    channel = (Channel)list.next();
                } while (!s.equals(channel.name));
            }
        }
        return channel;
    }

    private void showProgress(boolean flag)
    {
        byte byte0 = 8;
        Object obj = progressView;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
        obj = recyclerView;
        if (flag)
        {
            i = byte0;
        } else
        {
            i = 0;
        }
        ((RecyclerView) (obj)).setVisibility(i);
    }

    public android.support.v7.widget.RecyclerView.ItemDecoration getItemDecoration()
    {
        return null;
    }

    public void onChannelsChanged(UssChannelsDataManager usschannelsdatamanager, Content content, EbayCountry ebaycountry)
    {
        if (getActivity() instanceof BrowseDepartmentActivity) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ebaycountry = (BrowseDepartmentActivity)getActivity();
        if (getView() == null || ebaycountry == null || ebaycountry.isFinishing())
        {
            continue; /* Loop/switch isn't completed */
        }
        usschannelsdatamanager = content.getStatus();
        if (usschannelsdatamanager.hasError())
        {
            EbayErrorHandler.handleResultStatus(this, 0, usschannelsdatamanager);
            return;
        }
        usschannelsdatamanager = (ChannelsContainer)content.getData();
        if (usschannelsdatamanager != null && ((ChannelsContainer) (usschannelsdatamanager)).channels != null)
        {
            usschannelsdatamanager = ((ChannelsContainer) (usschannelsdatamanager)).channels;
        } else
        {
            usschannelsdatamanager = Collections.emptyList();
        }
        if (channels != null && channels.equals(usschannelsdatamanager))
        {
            continue; /* Loop/switch isn't completed */
        }
        content = findTargetTopLevelChannel(currentTopLevelChannel, usschannelsdatamanager);
        spinnerSelections = new ArrayList();
        if (content != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (logInfo.isLoggable)
        {
            logInfo.logAsError("targetTopLevelChannel is null");
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        content = ((Channel) (content)).subChannels;
        if (content != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (logInfo.isLoggable)
        {
            logInfo.logAsError("targetTopLevelChannel.subChannels is null");
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        channels = usschannelsdatamanager;
        if (!(ebaycountry instanceof BrowseDealsActivity))
        {
            int j = 0;
            int i = 0;
            usschannelsdatamanager = content.iterator();
            do
            {
                if (!usschannelsdatamanager.hasNext())
                {
                    break;
                }
                content = (Channel)usschannelsdatamanager.next();
                Object obj = ebaycountry.getSubDepartmentTitle(((Channel) (content)).name, ((Channel) (content)).displayName.content);
                if (((Channel) (content)).name.equals("FEATURED"))
                {
                    spinnerSelections.add(new SpinnerSelection(false, ((Channel) (content)).name, ((String) (obj))));
                    i++;
                } else
                if (((Channel) (content)).isDepartment)
                {
                    obj = new SpinnerSelection(((Channel) (content)).isDepartment, ((Channel) (content)).departmentName, ((String) (obj)));
                    spinnerSelections.add(obj);
                    int k = j;
                    if (((Channel) (content)).departmentName != null)
                    {
                        k = j;
                        if (((Channel) (content)).departmentName.equals(selectedSpinnerItem.department))
                        {
                            k = i;
                        }
                    }
                    i++;
                    j = k;
                }
            } while (true);
            populateSelectionsSpinner(spinnerSelections, j);
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = getArguments();
        }
        if (bundle1 != null)
        {
            currentDepartmentId = bundle1.getString("department_id");
            currentDepartmentTitle = bundle1.getString("department_title");
            currentBrowseType = bundle1.getString("browse_type", "FEATURED");
            currentTopLevelChannel = bundle1.getString("top_level_channel", ChannelEnum.SHOP.name());
            sourceDepartmentId = bundle1.getString("source_department_id", currentDepartmentId);
        }
        selectedSpinnerItem = new SpinnerSelection(true, currentDepartmentId, currentDepartmentTitle);
        initDataManagers();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03002d, viewgroup, false);
    }

    public void onDestroyView()
    {
        progressView = null;
        recyclerView = null;
        container = null;
        subDepartmentTitleView = null;
        super.onDestroyView();
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        UserContextDataManager usercontextdatamanager = (UserContextDataManager)datamanagercontainer.initialize(UserContextDataManager.KEY, null);
        if (usercontextdatamanager.getCurrentCountry() == null)
        {
            usercontextdatamanager.setCurrentCountry(EbayCountryManager.detectCountry());
        }
        datamanagercontainer.initialize(UssChannelsDataManager.KEY, this);
    }

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        selectedSpinnerItem.isSelected = false;
        selectedSpinnerItem = (SpinnerSelection)adapterview.getItemAtPosition(i);
        selectedSpinnerItem.isSelected = true;
        showProgress(true);
        if (recyclerView.getLayoutManager().getChildCount() > 0)
        {
            recyclerView.getLayoutManager().scrollToPosition(0);
        }
        refreshContents();
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putString("browse_type", currentBrowseType);
        bundle.putString("department_id", selectedSpinnerItem.department);
        bundle.putString("department_title", selectedSpinnerItem.display);
        bundle.putString("top_level_channel", currentTopLevelChannel);
        bundle.putString("source_department_id", sourceDepartmentId);
        super.onSaveInstanceState(bundle);
    }

    public void onStreamChanged(UssContentsDataManager usscontentsdatamanager, Content content, boolean flag, boolean flag1)
    {
        Object obj;
        Activity activity;
        obj = (UssContentsViewAdapter)adapter;
        activity = getActivity();
        if (getView() != null && activity != null && !activity.isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        showProgress(false);
        com.ebay.nautilus.domain.content.dm.UssContentsDataManager.KeyParams keyparams = (com.ebay.nautilus.domain.content.dm.UssContentsDataManager.KeyParams)usscontentsdatamanager.getParams();
        if (TextUtils.isEmpty(keyparams.department))
        {
            usscontentsdatamanager = keyparams.channel;
        } else
        {
            usscontentsdatamanager = keyparams.department;
        }
        currentDepartmentId = usscontentsdatamanager;
        usscontentsdatamanager = content.getStatus();
        if (!usscontentsdatamanager.hasError())
        {
            continue; /* Loop/switch isn't completed */
        }
        ((UssContentsViewAdapter) (obj)).setContents(null);
        EbayErrorHandler.handleResultStatus(this, 0, usscontentsdatamanager);
_L5:
        if (content.getData() == null || !(activity instanceof BrowseDepartmentActivity)) goto _L1; else goto _L3
_L3:
        obj = currentDepartmentId;
        usscontentsdatamanager = ((UssContentsDataManager) (obj));
        if (activity instanceof BrowseDealsActivity)
        {
            usscontentsdatamanager = ((UssContentsDataManager) (obj));
            if (keyparams.requestContextValues != null)
            {
                usscontentsdatamanager = ((UssContentsDataManager) (obj));
                if (keyparams.requestContextValues.size() > 0)
                {
                    usscontentsdatamanager = ((KeyValue)keyparams.requestContextValues.get(0)).value;
                }
            }
        }
        ((BrowseDepartmentActivity)activity).sendTracking(usscontentsdatamanager, (Contents)content.getData());
        return;
        if (content.getData() == null) goto _L1; else goto _L4
_L4:
        ((UssContentsViewAdapter) (obj)).setContents((Contents)content.getData());
          goto _L5
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        Activity activity = getActivity();
        super.onViewCreated(view, bundle);
        container = view.findViewById(0x7f1000cc);
        progressView = view.findViewById(0x7f1000ca);
        recyclerView = (RecyclerView)view.findViewById(0x102000a);
        container.setVisibility(8);
        showProgress(true);
        adapter = ((BrowseDepartmentActivity)activity).getChannelContentAdapter(Boolean.valueOf(currentBrowseType.equals("SUB_DEPARTMENT")));
        adapter.setOnClickListener((com.ebay.mobile.common.view.ViewModel.OnClickListener)activity, new int[0]);
        recyclerView.setLayoutManager(adapter.createLayoutManager());
        bundle = getItemDecoration();
        if (bundle != null)
        {
            recyclerView.addItemDecoration(bundle);
        }
        recyclerView.setAdapter(adapter);
        departmentSpinner = (Spinner)view.findViewById(0x7f100120);
        subDepartmentTitleView = (TextView)view.findViewById(0x7f1000cd);
        if (currentBrowseType.equals("SUB_DEPARTMENT"))
        {
            departmentSpinner.setVisibility(8);
            subDepartmentTitleView.setText(currentDepartmentTitle);
            subDepartmentTitleView.setVisibility(0);
            return;
        } else
        {
            departmentSpinner.setVisibility(0);
            subDepartmentTitleView.setVisibility(8);
            return;
        }
    }

    protected void populateSelectionsSpinner(ArrayList arraylist, int i)
    {
        if (getActivity() instanceof BrowseDepartmentActivity)
        {
            BrowseDepartmentActivity browsedepartmentactivity = (BrowseDepartmentActivity)getActivity();
            Object obj = getView();
            if (obj != null && browsedepartmentactivity != null && !browsedepartmentactivity.isFinishing())
            {
                if (arraylist.size() > 0)
                {
                    obj = (Spinner)((View) (obj)).findViewById(0x7f100120);
                    if (spinnerSelectionAdapter == null)
                    {
                        spinnerSelectionAdapter = new CategorySpinnerAdapter(browsedepartmentactivity, 0x7f030063, 0x1020014, 0x7f030061, arraylist);
                        ((Spinner) (obj)).setAdapter(spinnerSelectionAdapter);
                        if (!browsedepartmentactivity.getResources().getBoolean(0x7f0b0006))
                        {
                            arraylist = getActivity().getWindowManager().getDefaultDisplay();
                            Point point = new Point();
                            arraylist.getSize(point);
                            ((Spinner) (obj)).setDropDownWidth(point.x);
                        }
                        ((Spinner) (obj)).setOnItemSelectedListener(this);
                        if (currentBrowseType.equals(ChannelEnum.DEPARTMENT.name()))
                        {
                            ((Spinner) (obj)).setSelection(i);
                        }
                    } else
                    {
                        spinnerSelectionAdapter.clear();
                        spinnerSelectionAdapter.addAll(arraylist);
                        spinnerSelectionAdapter.notifyDataSetChanged();
                    }
                }
                if (currentBrowseType.equals("SUB_DEPARTMENT"))
                {
                    arraylist = Collections.unmodifiableList(Collections.singletonList(new OutputSelector(browsedepartmentactivity.getContentSourceEnum(currentDepartmentId))));
                    getDataManagerContainer().initialize(UssContentsDataManager.getDepartmentChannelKeyParams(currentDepartmentId, arraylist, browsedepartmentactivity.getContextValues()), this);
                }
                container.setVisibility(0);
                return;
            }
        }
    }

    protected void refreshContents()
    {
        if (selectedSpinnerItem == null)
        {
            return;
        }
        Activity activity = getActivity();
        if (selectedSpinnerItem.isDepartment)
        {
            List list = Collections.unmodifiableList(Collections.singletonList(new OutputSelector(((BrowseDepartmentActivity)activity).getContentSourceEnum(selectedSpinnerItem.department))));
            getDataManagerContainer().initialize(UssContentsDataManager.getDepartmentChannelKeyParams(selectedSpinnerItem.department, list, ((BrowseDepartmentActivity)activity).getContextValues()), this);
            return;
        } else
        {
            List list1 = Collections.unmodifiableList(Collections.singletonList(new OutputSelector(((BrowseDepartmentActivity)activity).getContentSourceEnum("FEATURED"))));
            getDataManagerContainer().initialize(UssContentsDataManager.getChannelKeyParams(selectedSpinnerItem.department, list1, ((BrowseDepartmentActivity)activity).getContextValues()), this);
            return;
        }
    }

}
