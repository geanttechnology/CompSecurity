// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.TabsAdapter;
import com.ebay.common.net.api.trading.GetFeedbackNetLoader;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity, FeedbackFragment, SignInModalActivity

public class ViewFeedbackActivity extends BaseActivity
    implements android.widget.TabHost.OnTabChangeListener, com.ebay.common.TabsAdapter.TabsAdapterGetter
{
    public static final class TabChoice extends Enum
    {

        private static final TabChoice $VALUES[];
        public static final TabChoice AS_BUYER;
        public static final TabChoice AS_SELLER;
        public final int value;

        public static TabChoice valueOf(String s)
        {
            return (TabChoice)Enum.valueOf(com/ebay/mobile/activities/ViewFeedbackActivity$TabChoice, s);
        }

        public static TabChoice[] values()
        {
            return (TabChoice[])$VALUES.clone();
        }

        static 
        {
            AS_BUYER = new TabChoice("AS_BUYER", 0, 1);
            AS_SELLER = new TabChoice("AS_SELLER", 1, 0);
            $VALUES = (new TabChoice[] {
                AS_BUYER, AS_SELLER
            });
        }

        private TabChoice(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }

    public static final class TypeChoice extends Enum
    {

        private static final TypeChoice $VALUES[];
        public static final TypeChoice ALL;
        public static final TypeChoice NEGATIVE;
        public static final TypeChoice NEUTRAL;
        public static final TypeChoice POSITIVE;
        public int value;

        public static TypeChoice getByValue(int i)
        {
            TypeChoice atypechoice[] = values();
            int k = atypechoice.length;
            for (int j = 0; j < k; j++)
            {
                TypeChoice typechoice = atypechoice[j];
                if (typechoice.value == i)
                {
                    return typechoice;
                }
            }

            return ALL;
        }

        public static TypeChoice valueOf(String s)
        {
            return (TypeChoice)Enum.valueOf(com/ebay/mobile/activities/ViewFeedbackActivity$TypeChoice, s);
        }

        public static TypeChoice[] values()
        {
            return (TypeChoice[])$VALUES.clone();
        }

        static 
        {
            ALL = new TypeChoice("ALL", 0, 0);
            POSITIVE = new TypeChoice("POSITIVE", 1, 1);
            NEUTRAL = new TypeChoice("NEUTRAL", 2, 2);
            NEGATIVE = new TypeChoice("NEGATIVE", 3, 3);
            $VALUES = (new TypeChoice[] {
                ALL, POSITIVE, NEUTRAL, NEGATIVE
            });
        }

        private TypeChoice(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }


    private static final int DEFAULT_TAB_MODE = 0;
    public static final String EXTRA_TAB_MODE = "feedbackTabMode";
    public static final String NEGATIVE = "negative";
    public static final String NEUTRAL = "neutral";
    private static final String PARAM_MONTHS = "months";
    private static final String PARAM_TYPE = "type";
    private static final String PARAM_USER_ID = "id";
    public static final String POSITIVE = "positive";
    private static final String SIGN_IN_ACTIVITY_STARTED = "sign_in_activity_started";
    public static final int TAB_MODE_BUYER = 1;
    public static final int TAB_MODE_SELLER = 0;
    private static final String TAB_TAG_BUYER = "ebayTabBuyer";
    private static final String TAB_TAG_SELLER = "ebayTabSeller";
    private TabsAdapter adapter;
    private Integer months;
    protected ViewPager pager;
    private boolean signInActivityStarted;
    private TypeChoice startType;
    private TabHost tabHost;
    private int tabMode;
    protected String userId;

    public ViewFeedbackActivity()
    {
        signInActivityStarted = false;
        startType = TypeChoice.ALL;
    }

    public static void StartActivity(Activity activity, String s)
    {
        StartActivity(activity, s, null);
    }

    public static void StartActivity(Activity activity, String s, Intent intent)
    {
        Intent intent1 = new Intent(activity, com/ebay/mobile/activities/ViewFeedbackActivity);
        intent1.putExtra("id", s);
        if (intent != null)
        {
            intent1.putExtras(intent);
        }
        activity.startActivityForResult(intent1, 518);
    }

    public static void StartActivity(Activity activity, String s, TabChoice tabchoice, TypeChoice typechoice, Integer integer)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/activities/ViewFeedbackActivity);
        intent.putExtra("id", s);
        if (tabchoice != null)
        {
            intent.putExtra("feedbackTabMode", tabchoice.value);
        }
        if (typechoice != null)
        {
            intent.putExtra("type", typechoice.value);
        }
        if (integer != null)
        {
            intent.putExtra("months", integer.intValue());
        }
        activity.startActivityForResult(intent, 518);
    }

    private void addTab(int i, String s, Class class1)
    {
        View view = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030268, tabHost.getTabWidget(), false);
        ((TextView)view.findViewById(0x7f10005f)).setText(i);
        adapter.addTab(tabHost.newTabSpec(s).setIndicator(view), class1, getIntent().getExtras());
    }

    private FeedbackFragment getCurrentFragment(Integer integer)
    {
        TabsAdapter tabsadapter = adapter;
        int i;
        if (integer != null)
        {
            i = integer.intValue();
        } else
        {
            i = pager.getCurrentItem();
        }
        integer = (FeedbackFragment)tabsadapter.getItem(i);
        if (integer != null && integer.isAdded())
        {
            return integer;
        } else
        {
            return null;
        }
    }

    public static Intent getIntent(String s, Intent intent)
    {
        Intent intent1 = new Intent(MyApp.getApp().getApplicationContext(), com/ebay/mobile/activities/ViewFeedbackActivity);
        intent1.putExtra("id", s);
        if (intent != null)
        {
            intent1.putExtras(intent);
        }
        return intent1;
    }

    protected TypeChoice getInitialType()
    {
        return startType;
    }

    protected Integer getMonths()
    {
        return months;
    }

    public TabsAdapter getTabsAdaptor()
    {
        return adapter;
    }

    public String getTrackingEventName()
    {
        return "ViewFeedback";
    }

    public void issueDataRequest(int i, int j, com.ebay.common.net.api.trading.GetFeedbackRequest.CommentType commenttype, com.ebay.common.net.api.trading.GetFeedbackRequest.FeedbackType feedbacktype)
    {
        this;
        JVM INSTR monitorenter ;
        if (getFwLoaderManager().getRunningLoader(j) == null)
        {
            com.ebay.nautilus.domain.net.api.trading.EbayTradingApi ebaytradingapi = EbayApiUtil.getTradingApi(this, MyApp.getPrefs().getAuthentication());
            commenttype = new GetFeedbackNetLoader(getEbayContext(), ebaytradingapi, userId, i, commenttype, feedbacktype);
            getFwLoaderManager().start(j, commenttype, true);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        commenttype;
        throw commenttype;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        switch (i)
        {
        default:
            return;

        case 65: // 'A'
            signInActivityStarted = false;
            break;
        }
        if (j != -1)
        {
            finish();
            return;
        } else
        {
            addTab(0x7f070174, "ebayTabSeller", com/ebay/mobile/activities/FeedbackFragment);
            addTab(0x7f070173, "ebayTabBuyer", com/ebay/mobile/activities/FeedbackFragment);
            adapter.startListening(tabMode);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030269);
        if (bundle != null)
        {
            signInActivityStarted = bundle.getBoolean("sign_in_activity_started");
        }
        bundle = getIntent();
        tabMode = bundle.getIntExtra("feedbackTabMode", 0);
        userId = bundle.getStringExtra("id");
        startType = TypeChoice.getByValue(bundle.getIntExtra("type", TypeChoice.ALL.value));
        months = Integer.valueOf(bundle.getIntExtra("months", -1));
        if (months.intValue() == -1)
        {
            months = null;
        }
        tabHost = (TabHost)findViewById(0x1020012);
        tabHost.setup();
        tabHost.getTabWidget().setStripEnabled(false);
        pager = (ViewPager)findViewById(0x7f10055a);
        adapter = new TabsAdapter(this, tabHost, pager);
        if (MyApp.getPrefs().isSignedIn())
        {
            addTab(0x7f070174, "ebayTabSeller", com/ebay/mobile/activities/FeedbackFragment);
            addTab(0x7f070173, "ebayTabBuyer", com/ebay/mobile/activities/FeedbackFragment);
            adapter.startListening(tabMode);
        }
        setTitle(userId);
        if (!MyApp.getPrefs().isSignedIn() && !signInActivityStarted)
        {
            signInActivityStarted = true;
            startActivityForResult(SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this), 65);
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        super.onPrepareOptionsMenu(menu);
        for (int i = 0; i < menu.size(); i++)
        {
            MenuItem menuitem = menu.getItem(i);
            menuitem.setEnabled(false);
            menuitem.setVisible(false);
        }

        return true;
    }

    protected void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).addSourceIdentification(getIntent()).send(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("sign_in_activity_started", signInActivityStarted);
    }

    public void onTabChanged(String s)
    {
        int i;
        if (s.equals("ebayTabSeller"))
        {
            i = 0;
        } else
        {
            i = 1;
        }
        s = getCurrentFragment(Integer.valueOf(i));
        if (s != null)
        {
            s.onTabChanged();
        }
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        if (isFinishing() || !(fwloader instanceof GetFeedbackNetLoader)) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 0 1: default 36
    //                   0 37
    //                   1 37;
           goto _L2 _L3 _L3
_L2:
        FeedbackFragment feedbackfragment;
        return;
_L3:
        if ((feedbackfragment = (FeedbackFragment)adapter.getItem(i)) != null)
        {
            feedbackfragment.onGetFeedbackComplete((GetFeedbackNetLoader)fwloader);
            return;
        }
        if (true) goto _L2; else goto _L4
_L4:
    }

    public void showTabs(boolean flag)
    {
        TabHost tabhost = tabHost;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        tabhost.setVisibility(i);
    }
}
