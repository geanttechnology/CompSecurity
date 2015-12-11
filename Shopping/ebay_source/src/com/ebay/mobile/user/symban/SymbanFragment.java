// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.user.symban;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.content.EbayBroadcast;
import com.ebay.common.model.mdns.NotificationPreference;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.MessagesActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.EbayUtil;
import com.ebay.mobile.shoppingcart.ShoppingCartActivity;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.viewitem.ItemViewBidTracking;
import com.ebay.mobile.widget.OnCascadingScrollListener;
import com.ebay.mobile.widget.SwipeDismissListViewTouchListener;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.SymbanDataManager;
import com.ebay.nautilus.domain.data.SymbanNotification;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.BaseListFragment;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.TrackingSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.user.symban:
//            SymbanAdapter

public class SymbanFragment extends BaseListFragment
    implements android.widget.AbsListView.OnScrollListener, com.ebay.mobile.ErrorDialogFragment.OnDismissMessageListener, SymbanAdapter.OnItemDismissedListener, com.ebay.nautilus.domain.content.dm.SymbanDataManager.Observer
{
    public static interface OnSymbanAdapterChangedListener
    {

        public abstract void onSymbanAdapterChanged(SymbanFragment symbanfragment, SymbanAdapter symbanadapter);
    }

    private static class SquishAnimation extends Animation
    {

        private static final AccelerateInterpolator animInterpolator = new AccelerateInterpolator();
        final int startHeight;
        final View view;

        protected void applyTransformation(float f, Transformation transformation)
        {
            int i = (int)((float)startHeight * (1.0F - f));
            view.getLayoutParams().height = i;
            view.requestLayout();
        }


        public SquishAnimation(View view1)
        {
            view = view1;
            startHeight = view1.getHeight();
            setInterpolator(animInterpolator);
        }
    }

    private final class SymbanUpdateReceiver extends BroadcastReceiver
    {

        final SymbanFragment this$0;

        public void onReceive(Context context, Intent intent)
        {
            if ("com.ebay.common.intent.action.EBAY_SYMBAN_UPDATE".equals(intent.getAction()))
            {
                refresh();
            }
        }

        private SymbanUpdateReceiver()
        {
            this$0 = SymbanFragment.this;
            super();
        }

    }


    private static final int DISMISS_COMMIT_DELAY = 6000;
    private static final int PNACT_ACTED_UPON = 1;
    private static final int PNACT_DISMISSED = 0;
    private static final int RESULT_LIST_CHANGED = 1;
    private static final int RESULT_MARK_ALL_READ = 2;
    private static final String STATE_ADAPTER = "state_adapter";
    private static final String STATE_LIST_VIEW = "state_list_view";
    private static final int STATUS_NEW = 1;
    private static final int STATUS_VIEWED = 2;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("Symban", 3, "SYMBA Notifications");
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logUi = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("Symban.Ui", 3, "SYMBA Notifications UI");
    private Bundle adapterState;
    private int animDuration;
    private final Runnable commitDismissedItemsRunnable = new Runnable() {

        final SymbanFragment this$0;

        public void run()
        {
            if (ensureActivity() == null)
            {
                return;
            } else
            {
                commitDismissedItems();
                return;
            }
        }

            
            {
                this$0 = SymbanFragment.this;
                super();
            }
    };
    protected final List dismissingItems = new ArrayList();
    private TextView emptyView;
    private android.widget.AbsListView.OnScrollListener externalScrollListener;
    private Parcelable listViewState;
    private TrackingData pendingNotificationsViewedData;
    protected SwipeRefreshLayout refreshLayout;
    private OnSymbanAdapterChangedListener symbanAdapterChangedListener;
    protected SymbanDataManager symbanDm;
    private final SymbanUtils.SymbanErrorHandler symbanErrorHandler = new SymbanUtils.SymbanErrorHandler();
    private BroadcastReceiver symbanUpdateReceiver;

    public SymbanFragment()
    {
        listViewState = null;
        adapterState = null;
    }

    private void createNotificationActionEvent(SymbanNotification symbannotification, int i, int j)
    {
        String s = String.valueOf(symbannotification.getMdnsName());
        Object obj;
        int k;
        if (symbannotification.isNew())
        {
            k = 1;
        } else
        {
            k = 2;
        }
        obj = symbannotification.getMessageId();
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            symbannotification = symbannotification.getListingId();
        } else
        {
            symbannotification = ((SymbanNotification) (obj));
        }
        obj = new TrackingData("BadgeNotificationAction", TrackingType.EVENT);
        ((TrackingData) (obj)).addKeyValuePair("ntype", s);
        ((TrackingData) (obj)).addKeyValuePair("nRow", String.valueOf(i));
        ((TrackingData) (obj)).addKeyValuePair("nStatus", String.valueOf(k));
        ((TrackingData) (obj)).addKeyValuePair("itm", symbannotification);
        ((TrackingData) (obj)).addKeyValuePair("pnact", String.valueOf(j));
        ((TrackingData) (obj)).send(getActivity());
    }

    private void createNotificationsViewedEvent()
    {
        Activity activity = ensureActivity();
        if (activity != null)
        {
            TrackingData trackingdata = new TrackingData("BellNotification", TrackingType.PAGE_IMPRESSION);
            trackingdata.addSourceIdentification(activity.getIntent());
            sendNotificationsViewedEventIfReady(trackingdata);
        }
    }

    private static String getBidSource(com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum mdnsnameenum)
    {
        if (mdnsnameenum == null) goto _L2; else goto _L1
_L1:
        static class _cls7
        {

            static final int $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum = new int[com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum[com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.OUTBID.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum[com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.BIDITEM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum[com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.BODECLND.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum[com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.CNTROFFR.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum[com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.BOACCPTD.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum[com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.OFRDCLNDACPT.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum[com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.OFREXPIRED.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum[com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.WATCHITM.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum[com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.BESTOFR.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum[com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.COACCPTED.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum[com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.CODECLND.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum[com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.OFRRETRACTED.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum[com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.ITMWON.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum[com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.ITMSHPD.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum[com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.COCMPLT.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum[com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.ITMSOLD.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum[com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.SHOPCARTITM.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$MdnsNameEnum[com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.MSGM2MMSGHDR.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls7..SwitchMap.com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum[mdnsnameenum.ordinal()];
        JVM INSTR tableswitch 1 17: default 96
    //                   1 154
    //                   2 102
    //                   3 110
    //                   4 114
    //                   5 106
    //                   6 142
    //                   7 146
    //                   8 162
    //                   9 98
    //                   10 118
    //                   11 126
    //                   12 150
    //                   13 138
    //                   14 130
    //                   15 122
    //                   16 134
    //                   17 158;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19
_L2:
        return null;
_L11:
        return ItemViewBidTracking.BID_SOURCE_BESTOFR_NOTIFICATION;
_L4:
        return ItemViewBidTracking.BID_SOURCE_BID_ITEM_ENDING_NOTIFICATION;
_L7:
        return ItemViewBidTracking.BID_SOURCE_BOACCPTD_NOTIFICATION;
_L5:
        return ItemViewBidTracking.BID_SOURCE_BODECLND_NOTIFICATION;
_L6:
        return ItemViewBidTracking.BID_SOURCE_CNTROFFR_NOTIFICATION;
_L12:
        return ItemViewBidTracking.BID_SOURCE_COACCPTED_NOTIFICATION;
_L17:
        return ItemViewBidTracking.BID_SOURCE_COCMPLT_NOTIFICATION;
_L13:
        return ItemViewBidTracking.BID_SOURCE_CODECLND_NOTIFICATION;
_L16:
        return ItemViewBidTracking.BID_SOURCE_ITMSHPD_NOTIFICATION;
_L18:
        return ItemViewBidTracking.BID_SOURCE_ITMSOLD_NOTIFICATION;
_L15:
        return ItemViewBidTracking.BID_SOURCE_ITMWON_NOTIFICATION;
_L8:
        return ItemViewBidTracking.BID_SOURCE_OFRDCLNDACPT_NOTIFICATION;
_L9:
        return ItemViewBidTracking.BID_SOURCE_OFREXPIRED_NOTIFICATION;
_L14:
        return ItemViewBidTracking.BID_SOURCE_OFRRETRACTED_NOTIFICATION;
_L3:
        return ItemViewBidTracking.BID_SOURCE_OUTBID_NOTIFICATION;
_L19:
        return ItemViewBidTracking.BID_SOURCE_SHOPCARTITM_NOTIFICATION;
_L10:
        return ItemViewBidTracking.BID_SOURCE_WATCHED_ITEM_ENDING_NOTIFICATION;
    }

    private static com.ebay.common.ConstantsCommon.ItemKind getItemKind(com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum mdnsnameenum)
    {
label0:
        {
label1:
            {
label2:
                {
label3:
                    {
label4:
                        {
                            com.ebay.common.ConstantsCommon.ItemKind itemkind1 = com.ebay.common.ConstantsCommon.ItemKind.Unknown;
                            com.ebay.common.ConstantsCommon.ItemKind itemkind = itemkind1;
                            if (mdnsnameenum != null)
                            {
                                itemkind = itemkind1;
                                switch (_cls7..SwitchMap.com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum[mdnsnameenum.ordinal()])
                                {
                                default:
                                    itemkind = com.ebay.common.ConstantsCommon.ItemKind.Unknown;
                                    break;

                                case 1: // '\001'
                                case 2: // '\002'
                                case 3: // '\003'
                                case 4: // '\004'
                                case 5: // '\005'
                                case 6: // '\006'
                                case 7: // '\007'
                                    break label4;

                                case 8: // '\b'
                                    break label3;

                                case 9: // '\t'
                                case 10: // '\n'
                                case 11: // '\013'
                                case 12: // '\f'
                                    break label2;

                                case 13: // '\r'
                                case 14: // '\016'
                                    break label1;

                                case 15: // '\017'
                                case 16: // '\020'
                                    break label0;

                                case 17: // '\021'
                                    break;
                                }
                            }
                            return itemkind;
                        }
                        return com.ebay.common.ConstantsCommon.ItemKind.Bidding;
                    }
                    return com.ebay.common.ConstantsCommon.ItemKind.Watched;
                }
                return com.ebay.common.ConstantsCommon.ItemKind.Selling;
            }
            return com.ebay.common.ConstantsCommon.ItemKind.Won;
        }
        return com.ebay.common.ConstantsCommon.ItemKind.Sold;
    }

    private Intent getShopCartIntent(Activity activity, SymbanNotification symbannotification)
    {
        activity = new Intent(activity, com/ebay/mobile/shoppingcart/ShoppingCartActivity);
        symbannotification = symbannotification.getListingId();
        if (!TextUtils.isEmpty(symbannotification))
        {
            activity.putExtra("item_id", symbannotification);
        }
        symbannotification = getBidSource(com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.SHOPCARTITM);
        if (symbannotification != null)
        {
            activity.putExtra("com.ebay.mobile.tracking.BidSource", symbannotification);
        }
        activity.putExtra("noti_type_id", NotificationPreference.nameToId(com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.SHOPCARTITM.name()));
        return activity;
    }

    private Intent getViewItemIntent(Activity activity, SymbanNotification symbannotification, com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum mdnsnameenum, String s)
    {
        activity = new Intent(activity, com/ebay/mobile/viewitem/ItemViewActivity);
        activity.putExtra("item_id", s);
        if (mdnsnameenum != null)
        {
            activity.putExtra("event_type", mdnsnameenum.name());
        }
        symbannotification = symbannotification.getTransactionId();
        String s1;
        if (!TextUtils.isEmpty(symbannotification))
        {
            activity.putExtra("transaction_id", symbannotification);
            com.ebay.common.ConstantsCommon.ItemKind itemkind = getItemKind(mdnsnameenum);
            if (itemkind != null)
            {
                activity.putExtra("item_kind", itemkind.name());
            }
        } else
        {
            activity.putExtra("item_kind", com.ebay.common.ConstantsCommon.ItemKind.Unknown.name());
        }
        s1 = getBidSource(mdnsnameenum);
        if (s1 != null)
        {
            activity.putExtra("com.ebay.mobile.tracking.BidSource", s1);
        }
        if (mdnsnameenum != null)
        {
            activity.putExtra("noti_type_id", NotificationPreference.nameToId(mdnsnameenum.name()));
        }
        try
        {
            ItemViewActivity.invalidateCache(Long.parseLong(s), symbannotification);
        }
        // Misplaced declaration of an exception variable
        catch (SymbanNotification symbannotification)
        {
            return activity;
        }
        return activity;
    }

    private Intent getViewMessageIntent(Activity activity, String s)
    {
        activity = new Intent(activity, com/ebay/mobile/activities/MessagesActivity);
        if (!TextUtils.isEmpty(s))
        {
            activity.putExtra("message_id", s);
        }
        return activity;
    }

    private void resetCommitDismissedItemsTimer()
    {
        View view = getView();
        if (view != null)
        {
            view.removeCallbacks(commitDismissedItemsRunnable);
            view.postDelayed(commitDismissedItemsRunnable, 6000L);
        }
    }

    private void sendNotificationsViewedEventIfNeeded()
    {
        if (pendingNotificationsViewedData != null)
        {
            TrackingData trackingdata = pendingNotificationsViewedData;
            pendingNotificationsViewedData = null;
            sendNotificationsViewedEventIfReady(trackingdata);
        }
    }

    private void sendNotificationsViewedEventIfReady(TrackingData trackingdata)
    {
        Integer integer;
        SymbanAdapter symbanadapter;
        if (symbanDm == null)
        {
            integer = null;
        } else
        {
            integer = symbanDm.getCountIfExists();
        }
        symbanadapter = (SymbanAdapter)getListAdapter();
        if (integer != null && symbanadapter != null)
        {
            trackingdata.addKeyValuePair("aiBellCnt", String.valueOf(integer));
            trackingdata.addKeyValuePair("NotificationCnt", String.valueOf(symbanadapter.getCount()));
            trackingdata.send(getActivity());
            return;
        } else
        {
            pendingNotificationsViewedData = trackingdata;
            return;
        }
    }

    protected void commitDismissedItems()
    {
        commitDismissedItems(null);
    }

    protected void commitDismissedItems(Runnable runnable)
    {
        int j;
label0:
        {
            boolean flag = false;
            int i = 0;
            final SymbanAdapter adapter = (SymbanAdapter)getListAdapter();
            j = ((flag) ? 1 : 0);
            if (symbanDm != null)
            {
                j = ((flag) ? 1 : 0);
                if (adapter != null)
                {
                    Object obj = adapter.getDismissedItems();
                    j = ((flag) ? 1 : 0);
                    if (obj != null)
                    {
                        j = ((flag) ? 1 : 0);
                        if (!((List) (obj)).isEmpty())
                        {
                            Object obj1 = new ArrayList();
                            obj = ((List) (obj)).iterator();
                            do
                            {
                                if (!((Iterator) (obj)).hasNext())
                                {
                                    break;
                                }
                                SymbanNotification symbannotification = (SymbanNotification)((Iterator) (obj)).next();
                                if (!dismissingItems.contains(symbannotification))
                                {
                                    dismissingItems.add(symbannotification);
                                    ((List) (obj1)).add(symbannotification);
                                    createNotificationActionEvent(symbannotification, adapter.getPosition(symbannotification), 0);
                                }
                            } while (true);
                            if (!((List) (obj1)).isEmpty())
                            {
                                symbanDm.updateStatus(com.ebay.nautilus.domain.data.SymbanNotification.StatusEnum.DELETED, (SymbanNotification[])((List) (obj1)).toArray(new SymbanNotification[((List) (obj1)).size()]));
                            }
                            j = ((flag) ? 1 : 0);
                            if (ensureActivity() != null)
                            {
                                ListView listview = getListView();
                                int k = listview.getFirstVisiblePosition();
                                int l = listview.getLastVisiblePosition();
                                obj1 = ((List) (obj1)).iterator();
                                do
                                {
                                    j = i;
                                    if (!((Iterator) (obj1)).hasNext())
                                    {
                                        break;
                                    }
                                    final SymbanNotification notif = (SymbanNotification)((Iterator) (obj1)).next();
                                    j = adapter.getPosition(notif);
                                    View view = listview.getChildAt(j - k);
                                    if (view != null && j >= k && j <= l)
                                    {
                                        i = animDuration;
                                        SquishAnimation squishanimation = new SquishAnimation(view);
                                        squishanimation.setDuration(animDuration);
                                        squishanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                                            final SymbanFragment this$0;
                                            final SymbanAdapter val$adapter;
                                            final SymbanNotification val$notif;

                                            public void onAnimationEnd(Animation animation)
                                            {
                                                adapter.remove(notif);
                                                dismissingItems.remove(notif);
                                            }

                                            public void onAnimationRepeat(Animation animation)
                                            {
                                            }

                                            public void onAnimationStart(Animation animation)
                                            {
                                            }

            
            {
                this$0 = SymbanFragment.this;
                adapter = symbanadapter;
                notif = symbannotification;
                super();
            }
                                        });
                                        view.startAnimation(squishanimation);
                                    } else
                                    {
                                        adapter.remove(notif);
                                        dismissingItems.remove(notif);
                                    }
                                } while (true);
                            }
                        }
                    }
                }
            }
            if (runnable != null)
            {
                if (j != 0)
                {
                    break label0;
                }
                runnable.run();
            }
            return;
        }
        (new Handler()).postDelayed(runnable, j);
    }

    protected Activity ensureActivity()
    {
        Activity activity;
label0:
        {
            Activity activity1 = getActivity();
            if (activity1 != null)
            {
                activity = activity1;
                if (!activity1.isFinishing())
                {
                    break label0;
                }
            }
            activity = null;
        }
        return activity;
    }

    public void markAllRead()
    {
        if (symbanDm != null)
        {
            Integer integer = symbanDm.getCountIfExists();
            if (integer != null && integer.intValue() > 0)
            {
                symbanDm.markAllRead();
            }
        }
        commitDismissedItems();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setListShown(false);
        animDuration = getResources().getInteger(0x10e0000);
    }

    public void onCreate(Bundle bundle)
    {
        if (log.isLoggable || logUi.isLoggable)
        {
            logUi.log((new StringBuilder()).append("Fragment constructed: ").append(getClass().getSimpleName()).toString());
        }
        super.onCreate(bundle);
        if (bundle != null)
        {
            listViewState = bundle.getParcelable("state_list_view");
            adapterState = (Bundle)bundle.getParcelable("state_adapter");
        }
        initDataManagers();
        symbanUpdateReceiver = new SymbanUpdateReceiver();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030264, viewgroup, false);
        emptyView = (TextView)layoutinflater.findViewById(0x1020004);
        layoutinflater.findViewById(0x7f1003ab).setOnClickListener(new android.view.View.OnClickListener() {

            final SymbanFragment this$0;

            public void onClick(View view)
            {
                getActivity().finish();
            }

            
            {
                this$0 = SymbanFragment.this;
                super();
            }
        });
        refreshLayout = (SwipeRefreshLayout)layoutinflater.findViewById(0x7f1002e1);
        refreshLayout.setOnRefreshListener(new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

            final SymbanFragment this$0;

            public void onRefresh()
            {
                refreshLayout.setRefreshing(true);
                refresh();
            }

            
            {
                this$0 = SymbanFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onDismissMessage(int i, boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 1 2: default 28
    //                   1 29
    //                   2 34;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        refresh();
        return;
_L4:
        markAllRead();
        return;
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        symbanDm = (SymbanDataManager)datamanagercontainer.initialize(SymbanDataManager.KEY, this);
        datamanagercontainer = ensureActivity();
        if (datamanagercontainer != null && !EbayUtil.isPushActive(datamanagercontainer, MyApp.getPrefs().getCurrentUser(), "AEAPP"))
        {
            symbanDm.reloadList();
            return;
        } else
        {
            symbanDm.loadList(this);
            return;
        }
    }

    public void onItemDismissed(SymbanNotification symbannotification)
    {
        resetCommitDismissedItemsTimer();
    }

    public void onItemUnDismissed(SymbanNotification symbannotification)
    {
        resetCommitDismissedItemsTimer();
    }

    public void onListItemClick(final ListView finalIntent, View view, int i, long l)
    {
        Activity activity = ensureActivity();
        if (activity != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum mdnsnameenum;
        String s;
        String s1;
        int j;
        super.onListItemClick(finalIntent, view, i, l);
        finalIntent = (SymbanAdapter)getListAdapter();
        if (finalIntent.isItemDismissed(i))
        {
            continue; /* Loop/switch isn't completed */
        }
        view = (SymbanNotification)finalIntent.getItem(i);
        mdnsnameenum = view.getMdnsName();
        finalIntent = null;
        s1 = view.getMessageId();
        s = view.getListingId();
        j = SymbanAdapter.getItemViewType(view.getAction(), mdnsnameenum, s1, s);
        if (!com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.SHOPCARTITM.equals(mdnsnameenum))
        {
            break; /* Loop/switch isn't completed */
        }
        finalIntent = getShopCartIntent(activity, view);
_L4:
        if (finalIntent != null)
        {
            createNotificationActionEvent(view, i, 1);
            if (activity instanceof TrackingSupport)
            {
                finalIntent.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(((TrackingSupport)activity).getTrackingEventName()));
            }
            if (view.isNew())
            {
                symbanDm.updateStatus(com.ebay.nautilus.domain.data.SymbanNotification.StatusEnum.READ, new SymbanNotification[] {
                    view
                });
            }
            commitDismissedItems(new Runnable() {

                final SymbanFragment this$0;
                final Intent val$finalIntent;

                public void run()
                {
                    if (ensureActivity() == null)
                    {
                        return;
                    } else
                    {
                        startActivity(finalIntent);
                        return;
                    }
                }

            
            {
                this$0 = SymbanFragment.this;
                finalIntent = intent;
                super();
            }
            });
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.UCI.equals(mdnsnameenum))
        {
            finalIntent = ActivityStarter.getUciWebViewIntent(activity, "NOTIFY");
        } else
        if (1 == j)
        {
            finalIntent = getViewMessageIntent(activity, s1);
        } else
        if (j == 0)
        {
            finalIntent = getViewItemIntent(activity, view, mdnsnameenum, s);
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void onMarkAllReadCompleted(SymbanDataManager symbandatamanager, ResultStatus resultstatus)
    {
        refreshLayout.setRefreshing(false);
        if (EbayErrorHandler.handleResultStatus(this, 2, resultstatus));
    }

    public void onNoItemsDismissed()
    {
        View view = getView();
        if (view != null)
        {
            view.removeCallbacks(commitDismissedItemsRunnable);
        }
    }

    public void onPause()
    {
        EbayBroadcast.unregisterReceiver(getActivity(), symbanUpdateReceiver);
        super.onPause();
    }

    public void onResume()
    {
        EbayBroadcast.registerReceiver(getActivity(), symbanUpdateReceiver, "com.ebay.common.intent.action.EBAY_SYMBAN_UPDATE");
        super.onResume();
        createNotificationsViewedEvent();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("state_list_view", getListView().onSaveInstanceState());
        SymbanAdapter symbanadapter = (SymbanAdapter)getListAdapter();
        if (symbanadapter != null)
        {
            bundle.putParcelable("state_adapter", symbanadapter.onSaveInstanceState());
        }
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (i == 1)
        {
            commitDismissedItems();
        }
    }

    public void onSymbanCountChanged(SymbanDataManager symbandatamanager, int i)
    {
        sendNotificationsViewedEventIfNeeded();
    }

    public void onSymbanListChanged(SymbanDataManager symbandatamanager, Content content)
    {
        symbandatamanager = ensureActivity();
        if (symbandatamanager == null)
        {
            return;
        }
        commitDismissedItems();
        ResultStatus resultstatus = content.getStatus();
        resultstatus.setCanRetry(true);
        if (!EbayErrorHandler.handleResultStatus(this, 1, resultstatus, symbanErrorHandler))
        {
            emptyView.setText(0x7f070b4f);
            refreshLayout.setRefreshing(false);
            setListShown(true);
            return;
        }
        emptyView.setText(0x7f070b4e);
        content = new SymbanAdapter(symbandatamanager, new ArrayList((Collection)content.getData()));
        content.setOnItemDismissedListener(this);
        if (adapterState != null)
        {
            content.onRestoreInstanceState(adapterState);
            adapterState = null;
        }
        setListAdapter(content);
        sendNotificationsViewedEventIfNeeded();
        symbandatamanager = getListView();
        if (listViewState != null)
        {
            symbandatamanager.onRestoreInstanceState(listViewState);
            listViewState = null;
        }
        if (!content.isEmpty())
        {
            int i;
            if (((SymbanNotification)content.getItem(content.getCount() - 1)).isNew())
            {
                i = content.getNewItemBackgroundColor();
            } else
            {
                i = content.getOldItemBackgroundColor();
            }
            symbandatamanager.setBackgroundColor(i);
        }
        setListShown(true);
        refreshLayout.setRefreshing(false);
        if (symbanAdapterChangedListener != null)
        {
            symbanAdapterChangedListener.onSymbanAdapterChanged(this, content);
        }
        content = new OnCascadingScrollListener(new android.widget.AbsListView.OnScrollListener[] {
            content.setupDismissListener(symbandatamanager).makeScrollListener(), this
        });
        if (externalScrollListener != null)
        {
            content.add(externalScrollListener);
        }
        symbandatamanager.setOnScrollListener(content);
    }

    public void onSymbanUpdatedCompleted(SymbanDataManager symbandatamanager, SymbanNotification symbannotification, com.ebay.nautilus.domain.data.SymbanNotification.StatusEnum statusenum)
    {
        refreshLayout.setRefreshing(false);
    }

    public void refresh()
    {
        commitDismissedItems(new Runnable() {

            final SymbanFragment this$0;

            public void run()
            {
                if (ensureActivity() == null)
                {
                    return;
                } else
                {
                    setListShown(false);
                    symbanDm.reloadList();
                    return;
                }
            }

            
            {
                this$0 = SymbanFragment.this;
                super();
            }
        });
    }

    public void setOnScrollListener(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        externalScrollListener = onscrolllistener;
    }

    public void setOnSymbanAdapterChangedListener(OnSymbanAdapterChangedListener onsymbanadapterchangedlistener)
    {
        symbanAdapterChangedListener = onsymbanadapterchangedlistener;
    }

}
