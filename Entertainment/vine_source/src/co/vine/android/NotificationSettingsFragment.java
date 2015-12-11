// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import co.vine.android.api.VineNotificationSetting;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.ViewUtil;
import com.twitter.android.widget.RefreshableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            BaseArrayListFragment, NotificationAlertsSettingsActivity

public class NotificationSettingsFragment extends BaseArrayListFragment
{
    public class NotificationSettingsAdapter extends BaseAdapter
    {

        private static final String CHECK_VALUE_OFF = "off";
        private static final String CHECK_VALUE_ON = "on";
        private static final int TYPE_CHECK = 0;
        private static final int TYPE_SPINNER = 1;
        private Context mContext;
        private ArrayList mSettings;
        final NotificationSettingsFragment this$0;

        private void bindView(View view, int i)
        {
            VineNotificationSetting vinenotificationsetting;
            final NotificationSettingsViewHolder h;
            vinenotificationsetting = (VineNotificationSetting)mSettings.get(i);
            h = new NotificationSettingsViewHolder(view);
            h.title.setText(vinenotificationsetting.title);
            if (!vinenotificationsetting.isBooleanSetting) goto _L2; else goto _L1
_L1:
            setSelected(getResources(), "on".equals(vinenotificationsetting.value), h.selectionIndicator);
            android.view.View.OnClickListener onclicklistener = vinenotificationsetting. new android.view.View.OnClickListener() {

                final NotificationSettingsAdapter this$1;
                final NotificationSettingsAdapter.NotificationSettingsViewHolder val$h;
                final VineNotificationSetting val$setting;

                public void onClick(View view)
                {
                    Object obj = NotificationSettingsAdapter.this;
                    Resources resources = getResources();
                    boolean flag;
                    if (!view.isSelected())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    ((NotificationSettingsAdapter) (obj)).setSelected(resources, flag, h.selectionIndicator);
                    obj = setting;
                    if (view.isSelected())
                    {
                        view = "on";
                    } else
                    {
                        view = "off";
                    }
                    obj.value = view;
                }

            
            {
                this$1 = final_notificationsettingsadapter;
                h = notificationsettingsviewholder;
                setting = VineNotificationSetting.this;
                super();
            }
            };
            h.selectionIndicator.setOnClickListener(onclicklistener);
            view.setOnClickListener(onclicklistener);
_L3:
            int j;
            if (shouldShowHeader(i))
            {
                h.header.setVisibility(0);
                h.headerText.setText(vinenotificationsetting.section);
                return;
            } else
            {
                h.header.setVisibility(8);
                return;
            }
_L2:
            view = new NotificationSettingsSpinnerAdapter(mContext, vinenotificationsetting);
            h.spinner.setAdapter(view);
            h.spinner.setOnItemSelectedListener(view);
            j = 0;
_L4:
            if (j < vinenotificationsetting.choices.size())
            {
label0:
                {
                    if (!((String)((Pair)vinenotificationsetting.choices.get(j)).second).equals(vinenotificationsetting.value))
                    {
                        break label0;
                    }
                    h.spinner.setSelection(j);
                }
            }
              goto _L3
            j++;
              goto _L4
        }

        private boolean shouldShowHeader(int i)
        {
            if (i != 0)
            {
                VineNotificationSetting vinenotificationsetting = (VineNotificationSetting)mSettings.get(i);
                VineNotificationSetting vinenotificationsetting1 = (VineNotificationSetting)mSettings.get(i - 1);
                if (TextUtils.isEmpty(vinenotificationsetting.section) || vinenotificationsetting.section.equals(vinenotificationsetting1.section))
                {
                    return false;
                }
            }
            return true;
        }

        public int getCount()
        {
            return mSettings.size();
        }

        public Object getItem(int i)
        {
            return mSettings.get(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public int getItemViewType(int i)
        {
            return !((VineNotificationSetting)mSettings.get(i)).isBooleanSetting ? 1 : 0;
        }

        public HashMap getMap()
        {
            HashMap hashmap = new HashMap();
            for (Iterator iterator = mSettings.iterator(); iterator.hasNext(); ((VineNotificationSetting)iterator.next()).addToMap(hashmap)) { }
            return hashmap;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            int j = 0x7f030064;
            int k = getItemViewType(i);
            viewgroup = view;
            if (view == null)
            {
                if (k == 1)
                {
                    j = 0x7f030066;
                }
                viewgroup = LayoutInflater.from(mContext).inflate(j, null);
            }
            bindView(viewgroup, i);
            return viewgroup;
        }

        public int getViewTypeCount()
        {
            return 2;
        }

        public void setSelected(Resources resources, boolean flag, View view)
        {
            if (flag)
            {
                Drawable drawable = resources.getDrawable(0x7f02015a).mutate();
                drawable.setColorFilter(new PorterDuffColorFilter(0xff000000 | resources.getColor(0x7f090096), android.graphics.PorterDuff.Mode.SRC_IN));
                ViewUtil.setBackground(view, drawable);
            } else
            {
                Drawable drawable1 = resources.getDrawable(0x7f020159);
                drawable1.setColorFilter(new PorterDuffColorFilter(resources.getColor(0x7f09001a), android.graphics.PorterDuff.Mode.SRC_IN));
                ViewUtil.setBackground(view, drawable1);
            }
            view.setSelected(flag);
        }

        public NotificationSettingsAdapter(Context context, ArrayList arraylist)
        {
            this$0 = NotificationSettingsFragment.this;
            super();
            mSettings = new ArrayList();
            mContext = context;
            mSettings = arraylist;
        }
    }

    class NotificationSettingsAdapter.NotificationSettingsViewHolder
    {

        View header;
        TextView headerText;
        View selectionIndicator;
        Spinner spinner;
        final NotificationSettingsAdapter this$1;
        TextView title;

        public NotificationSettingsAdapter.NotificationSettingsViewHolder(View view)
        {
            this$1 = NotificationSettingsAdapter.this;
            super();
            header = view.findViewById(0x7f0a005b);
            headerText = (TextView)view.findViewById(0x7f0a005c);
            title = (TextView)view.findViewById(0x7f0a004a);
            spinner = (Spinner)view.findViewById(0x7f0a0149);
            selectionIndicator = view.findViewById(0x7f0a0148);
        }
    }

    public class NotificationSettingsListener extends AppSessionListener
    {

        final NotificationSettingsFragment this$0;

        public void onGetNotificationSettingsComplete(String s, ArrayList arraylist)
        {
label0:
            {
                mFetched = true;
                if (removeRequest(s) != null)
                {
                    if (arraylist == null)
                    {
                        break label0;
                    }
                    mAdapter = new NotificationSettingsAdapter(getActivity(), arraylist);
                    mListView.setAdapter(mAdapter);
                    mSucceeded = true;
                    getActivity().invalidateOptionsMenu();
                }
                return;
            }
            showSadface(true);
            mSucceeded = false;
        }

        public void onSaveNotificationSettingsComplete(String s, int i, String s1)
        {
            if (i != 200)
            {
                if (TextUtils.isEmpty(s1))
                {
                    Toast.makeText(getActivity(), 0x7f0e00cb, 1).show();
                    return;
                } else
                {
                    Toast.makeText(getActivity(), s1, 1).show();
                    return;
                }
            } else
            {
                getActivity().finish();
                return;
            }
        }

        public NotificationSettingsListener()
        {
            this$0 = NotificationSettingsFragment.this;
            super();
        }
    }

    public class NotificationSettingsSpinnerAdapter extends BaseAdapter
        implements SpinnerAdapter, android.widget.AdapterView.OnItemSelectedListener
    {

        private Context mContext;
        private VineNotificationSetting mSetting;
        final NotificationSettingsFragment this$0;

        public int getCount()
        {
            return mSetting.choices.size();
        }

        public Object getItem(int i)
        {
            return mSetting.choices.get(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            viewgroup = (Pair)mSetting.choices.get(i);
            TextView textview;
            if (view == null)
            {
                view = LayoutInflater.from(mContext).inflate(0x7f030092, null);
            }
            textview = (TextView)view.findViewById(0x7f0a004a);
            textview.setText((CharSequence)((Pair) (viewgroup)).first);
            textview.setSingleLine(false);
            view.invalidate();
            return view;
        }

        public void onItemSelected(AdapterView adapterview, View view, int i, long l)
        {
            mSetting.value = (String)((Pair)mSetting.choices.get(i)).second;
            adapterview.setSelection(i);
        }

        public void onNothingSelected(AdapterView adapterview)
        {
        }

        public NotificationSettingsSpinnerAdapter(Context context, VineNotificationSetting vinenotificationsetting)
        {
            this$0 = NotificationSettingsFragment.this;
            super();
            mSetting = vinenotificationsetting;
            mContext = context;
        }
    }


    private boolean mFetched;
    private boolean mSucceeded;

    public NotificationSettingsFragment()
    {
        mFetched = false;
        mSucceeded = false;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mRefreshable = false;
        mAppSessionListener = new NotificationSettingsListener();
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (mSucceeded)
        {
            menuinflater.inflate(0x7f100012, menu);
            menu.findItem(0x7f0a0245).setEnabled(true);
            menu.findItem(0x7f0a0245).setEnabled(true);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131362373: 
            break;
        }
        if (mAdapter != null)
        {
            menuitem = ((NotificationSettingsAdapter)mAdapter).getMap();
            addRequest(mAppController.saveNotificationSettings(menuitem));
        }
        return true;
    }

    public void onResume()
    {
        super.onResume();
        mListView.setDividerHeight(0);
        ((RefreshableListView)mListView).disablePTR();
        if (!mFetched)
        {
            addRequest(mAppController.fetchNotificationSettings());
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        view = LayoutInflater.from(getActivity()).inflate(0x7f030063, null);
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final NotificationSettingsFragment this$0;

            public void onClick(View view1)
            {
                view1 = new Intent(getActivity(), co/vine/android/NotificationAlertsSettingsActivity);
                startActivity(view1);
            }

            
            {
                this$0 = NotificationSettingsFragment.this;
                super();
            }
        });
        mListView.addHeaderView(view, null, false);
    }


/*
    static boolean access$002(NotificationSettingsFragment notificationsettingsfragment, boolean flag)
    {
        notificationsettingsfragment.mFetched = flag;
        return flag;
    }

*/


/*
    static boolean access$102(NotificationSettingsFragment notificationsettingsfragment, boolean flag)
    {
        notificationsettingsfragment.mSucceeded = flag;
        return flag;
    }

*/
}
