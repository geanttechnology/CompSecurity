// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.common.Preferences;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ShowWebViewActivity;
import com.ebay.mobile.activities.UserDetailActivity;
import com.ebay.mobile.activities.ViewFeedbackActivity;
import com.ebay.mobile.activities.eBay;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.motors.videos.FwContextUtil;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.dm.MessageContentsDataManager;
import com.ebay.nautilus.domain.content.dm.MessagesUtils;
import com.ebay.nautilus.domain.data.EbayItem;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.nautilus.shell.app.TrackingSupport;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessagesBaseFragment, ComposeMessageFragment, PhotoGalleryFragment

public class MessageFragment extends MessagesBaseFragment
    implements android.view.View.OnClickListener, DialogFragmentCallback, com.ebay.nautilus.domain.content.dm.MessageContentsDataManager.Observer
{
    public static interface OnSaveMessageFragmentStateListener
    {

        public abstract void onSaveMessageFragmentState(EbayMessage ebaymessage, Bundle bundle);
    }


    public static final String PARAM_MESSAGE = "com.ebay.mobile.param.message";
    public static final String PARAM_SAVED_STATE = "com.ebay.mobile.param.webview.state";
    private static final int RESULT_DEEP_LINK_CONFIRM = 7;
    private static final int RESULT_FOLLOW_LINK_CONFIRM = 6;
    private static final int RESULT_GO_HOME_CONFIRM = 3;
    public static final int RESULT_MESSAGE_CHANGED = 1;
    public static final int RESULT_MESSAGE_ERROR = 2;
    private static final int RESULT_NONE = -1;
    private static final int RESULT_USER_PROFILE_CONFIRM = 1;
    private static final int RESULT_USER_PROFILE_HTML_CONFIRM = 2;
    private static final int RESULT_VIEW_FEEDBACK_CONFIRM = 5;
    private static final int RESULT_VIEW_ITEM_CONFIRM = 0;
    private static final int RESULT_VIEW_MY_EBAY_CONFIRM = 4;
    private static final String STATE_CONFIRM_RESULT_ID = null;
    private static final String STATE_DEEP_LINK_INTENT = "deepLinkIntent";
    private static final String STATE_FEEDBACK_USER_ID = "feedbackUserId";
    private static final String STATE_ITEM_ID = "itemId";
    private static final String STATE_LINK_URL = "linkurlDuringDraft";
    private static final String STATE_LINK_USE_SSO = "useSso";
    private static final String STATE_USER_ID_HTML = "userIdHtml";
    protected static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logWebView = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("Messages.WebView", 3, "User Messages sent between eBay members and to/from eBay.");
    private static final String urlKeyUserDetails = "myworld.ebay.com";
    private final DateFormat dateFormatMsg = DateFormat.getDateInstance();
    private String eventType;
    private Bundle instanceState;
    private EbayItem item;
    private Long itemId;
    private Boolean markReadMessage;
    private EbayMessage message;
    private MessageContentsDataManager messageDm;
    private String messageId;
    private OnSaveMessageFragmentStateListener onSaveMessageFragmentStateListener;
    private int promptConfirmResultId;
    private Intent promptDeepLinkIntent;
    private String promptLinkUrl;
    private boolean promptLinkUseSso;
    private String promptViewFeedbackUserId;
    private long promptViewItemId;
    private String promptViewUserIdHtml;
    private final DateFormat timeFormatMsg = DateFormat.getTimeInstance(3);
    private WebView wv;

    public MessageFragment()
    {
        message = null;
        markReadMessage = null;
        promptConfirmResultId = -1;
    }

    private Intent addSourceIdTracking(Intent intent)
    {
        Activity activity = getActivity();
        if (activity instanceof TrackingSupport)
        {
            intent.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(((TrackingSupport)activity).getTrackingEventName()));
        }
        return intent;
    }

    private void doDelayedMarkReadMessage()
    {
        if (markReadMessage != null)
        {
            markReadMessage(markReadMessage.booleanValue());
        }
    }

    private void doPromptDeepLink(Intent intent)
    {
        if (isDraftInProgress())
        {
            promptDeepLinkIntent = intent;
            promptToAbandonDraft(7);
            return;
        } else
        {
            startActivity(addSourceIdTracking(intent));
            return;
        }
    }

    private void doPromptFollowLink(String s, boolean flag)
    {
        if (isDraftInProgress())
        {
            promptLinkUrl = s;
            promptLinkUseSso = flag;
            promptToAbandonDraft(6);
            return;
        } else
        {
            doFollowLink(s, flag);
            return;
        }
    }

    private void doPromptGoBackHome(boolean flag)
    {
        if (flag)
        {
            MyApp.signOut(false);
            return;
        }
        if (isDraftInProgress())
        {
            promptToAbandonDraft(3);
            return;
        } else
        {
            goBackHome();
            return;
        }
    }

    private void doPromptViewFeedback(String s)
    {
        if (isDraftInProgress())
        {
            promptViewFeedbackUserId = s;
            promptToAbandonDraft(5);
            return;
        } else
        {
            doViewFeedback(s);
            return;
        }
    }

    private void doPromptViewItem(long l)
    {
        if (isDraftInProgress())
        {
            promptViewItemId = l;
            promptToAbandonDraft(0);
            return;
        } else
        {
            doViewItem(l);
            return;
        }
    }

    private void doPromptViewMyEbay()
    {
        if (isDraftInProgress())
        {
            promptToAbandonDraft(4);
            return;
        } else
        {
            doViewMyEbay();
            return;
        }
    }

    private void doPromptViewUserProfile()
    {
        if (isDraftInProgress())
        {
            promptToAbandonDraft(1);
            return;
        } else
        {
            doViewUserProfile();
            return;
        }
    }

    private void doPromptViewUserProfileHtml(String s)
    {
        if (isDraftInProgress())
        {
            promptViewUserIdHtml = s;
            promptToAbandonDraft(1);
            return;
        } else
        {
            doViewUserProfileHtml(s);
            return;
        }
    }

    private void doViewFeedback(String s)
    {
        Activity activity = ensureActivity();
        if (activity == null)
        {
            return;
        } else
        {
            ViewFeedbackActivity.StartActivity(activity, s, addSourceIdTracking(new Intent()));
            return;
        }
    }

    private void doViewItem(long l)
    {
        Activity activity = ensureActivity();
        if (activity == null)
        {
            return;
        } else
        {
            ItemViewActivity.StartActivity(activity, l, com.ebay.common.ConstantsCommon.ItemKind.Found, addSourceIdTracking(new Intent()));
            return;
        }
    }

    private void doViewMyEbay()
    {
        Activity activity = ensureActivity();
        if (activity == null)
        {
            return;
        } else
        {
            Intent intent = new Intent(activity, com/ebay/mobile/activities/eBay);
            intent.putExtra("HomeStartChannelTab", ChannelEnum.ACTIVITY);
            intent.setFlags(0x4000000);
            addSourceIdTracking(intent);
            activity.startActivity(intent);
            return;
        }
    }

    private void doViewUserProfile()
    {
        Activity activity = ensureActivity();
        if (activity == null)
        {
            return;
        }
        String s1 = message.sender;
        String s;
        String s2;
        boolean flag;
        if (item == null)
        {
            s = "";
        } else
        {
            s = item.sellerUserId;
        }
        s2 = MyApp.getPrefs().getCurrentUser();
        if (item == null)
        {
            flag = false;
        } else
        {
            flag = s2.equalsIgnoreCase(s);
        }
        if (flag || itemId == null)
        {
            UserDetailActivity.StartActivity(activity, null, s1, null, null, false, false, false, true, null, false, addSourceIdTracking(new Intent()));
            return;
        } else
        {
            Intent intent = new Intent(activity, com/ebay/mobile/activities/UserDetailActivity);
            intent.putExtra("user_id", s1);
            intent.putExtra("isBuyer", false);
            addSourceIdTracking(intent);
            startActivity(intent);
            return;
        }
    }

    private void doViewUserProfileHtml(String s)
    {
        Activity activity = ensureActivity();
        if (activity == null)
        {
            return;
        } else
        {
            UserDetailActivity.StartActivity(activity, null, s, null, "", false, true, false, true, null, false, addSourceIdTracking(new Intent()));
            return;
        }
    }

    private void goBackHome()
    {
        Activity activity = ensureActivity();
        if (activity == null)
        {
            return;
        } else
        {
            Intent intent = new Intent(activity, com/ebay/mobile/activities/eBay);
            intent.setFlags(0x4000000);
            startActivity(intent);
            activity.finish();
            return;
        }
    }

    private boolean handleBestOfferButtons(String s)
    {
        String as[] = Uri.parse(s).getQuery().split("&");
        Object obj = null;
        int j = as.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                s = obj;
                if (i < j)
                {
                    s = as[i].split("=");
                    if (s == null || s.length != 2 || !s[0].equalsIgnoreCase("itemId"))
                    {
                        break label1;
                    }
                    s = s[1];
                }
                if (s == null)
                {
                    break label0;
                }
                try
                {
                    doPromptViewItem(Long.parseLong(s));
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    break label0;
                }
                return true;
            }
            i++;
        } while (true);
        return false;
    }

    private static boolean isMessagePlaceholder(EbayMessage ebaymessage)
    {
        return ebaymessage == null || ebaymessage.sender == null;
    }

    private void loadWebview()
    {
        if (wv != null)
        {
            if (instanceState != null)
            {
                wv.restoreState(instanceState);
            }
            if (wv.copyBackForwardList().getCurrentIndex() <= 0)
            {
                if (TextUtils.isEmpty(message.text))
                {
                    showProgress(true);
                    return;
                }
                try
                {
                    wv.loadDataWithBaseURL(null, message.text, "text/html", "utf-8", null);
                    return;
                }
                catch (Exception exception)
                {
                    Log.w(getClass().getSimpleName(), "Exception setting up message body", exception);
                }
                String s = getResources().getString(0x7f0701cd);
                StringBuilder stringbuilder = new StringBuilder();
                stringbuilder.append("<html><body>");
                stringbuilder.append(s);
                stringbuilder.append("</body></html>");
                wv.loadDataWithBaseURL(null, stringbuilder.toString(), "text/html", "utf-8", null);
                return;
            }
        }
    }

    private void processArguments()
    {
        Bundle bundle = getArguments();
        if (bundle != null)
        {
            message = (EbayMessage)bundle.getParcelable("com.ebay.mobile.param.message");
            if (message == null)
            {
                messageId = bundle.getString("message_id");
                if (!TextUtils.isEmpty(messageId))
                {
                    message = (new com.ebay.nautilus.domain.data.EbayMessage.Builder(messageId)).build();
                    eventType = bundle.getString("event_type");
                }
            }
            instanceState = bundle.getBundle("com.ebay.mobile.param.webview.state");
            if (instanceState != null)
            {
                promptConfirmResultId = instanceState.getInt(STATE_CONFIRM_RESULT_ID, -1);
                promptLinkUrl = instanceState.getString("linkurlDuringDraft");
                promptLinkUseSso = instanceState.getBoolean("useSso");
                promptViewItemId = instanceState.getLong("itemId");
                promptViewUserIdHtml = instanceState.getString("userIdHtml");
                promptViewFeedbackUserId = instanceState.getString("feedbackUserId");
                promptDeepLinkIntent = (Intent)instanceState.getParcelable("deepLinkIntent");
            }
        }
    }

    private void promptToAbandonDraft(int i)
    {
        promptConfirmResultId = i;
        ComposeMessageFragment.showConfirmAbandonMessageDialogFragment(this, i, null, false);
    }

    private void reply()
    {
        getView().playSoundEffect(0);
        startDraft();
    }

    private void setUpHeaderUi()
    {
        boolean flag = true;
        View view = getView();
        showProgress(false);
        Object obj = message.subject.replace("\r", "<br>");
        ((TextView)view.findViewById(0x7f100389)).setText(Html.fromHtml(((String) (obj))));
        obj = (TextView)view.findViewById(0x7f100385);
        if (message.sender != null)
        {
            ((TextView) (obj)).setText(message.sender);
        }
        Calendar calendar;
        if (message.isEbayMessage())
        {
            view.findViewById(0x7f10038c).setEnabled(false);
            ((TextView) (obj)).setTextColor(ThemeUtil.resolveThemeColorStateList(getResources(), getActivity().getTheme(), 0x1010038));
        } else
        {
            setupViewClick(0x7f10038c, true);
        }
        obj = Calendar.getInstance();
        calendar = Calendar.getInstance();
        calendar.setTime(message.receiveDate);
        if (calendar.get(1) != ((Calendar) (obj)).get(1) || calendar.get(6) != ((Calendar) (obj)).get(6))
        {
            flag = false;
        }
        if (flag)
        {
            obj = timeFormatMsg.format(message.receiveDate);
        } else
        {
            obj = dateFormatMsg.format(message.receiveDate);
        }
        ((TextView)view.findViewById(0x7f10038e)).setText(((CharSequence) (obj)));
    }

    private void setUpItemUi()
    {
        ImageCache imagecache = getImageCache();
        View view = getView();
        Object obj1 = getActivity();
        if (item != null && view != null)
        {
            ViewGroup viewgroup = (ViewGroup)view.findViewById(0x7f100397);
            if (viewgroup != null)
            {
                viewgroup.removeAllViews();
                final ArrayList pictureUrls;
                if (item.pictureUrls != null)
                {
                    pictureUrls = item.pictureUrls;
                } else
                {
                    pictureUrls = new ArrayList();
                }
                if (pictureUrls.isEmpty())
                {
                    pictureUrls.add(item.galleryUrl);
                }
                if (pictureUrls != null)
                {
                    Object obj2 = getResources().getDisplayMetrics();
                    int j = (int)TypedValue.applyDimension(2, 100F, ((android.util.DisplayMetrics) (obj2)));
                    int k = (int)TypedValue.applyDimension(2, 4F, ((android.util.DisplayMetrics) (obj2)));
                    int l = pictureUrls.size();
                    int i = 0;
                    obj2 = pictureUrls.iterator();
                    while (((Iterator) (obj2)).hasNext()) 
                    {
                        String s = (String)((Iterator) (obj2)).next();
                        ImageView imageview = new ImageView(((android.content.Context) (obj1)));
                        imageview.setBackgroundColor(getResources().getColor(0x106000b));
                        imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
                        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(j, j);
                        if (i != 0)
                        {
                            layoutparams.leftMargin = k;
                        }
                        if (i != l - 1)
                        {
                            layoutparams.rightMargin = k;
                        }
                        imageview.setLayoutParams(layoutparams);
                        if (s == null || imagecache == null)
                        {
                            imageview.setImageResource(0x7f02027a);
                        } else
                        {
                            imagecache.setImage(imageview, s);
                        }
                        imageview.setOnClickListener(new android.view.View.OnClickListener() {

                            final MessageFragment this$0;
                            final ArrayList val$pictureUrls;

                            public void onClick(View view1)
                            {
                                view1 = (String)view1.getTag();
                                PhotoGalleryFragment.newInstance(pictureUrls, view1).show(getFragmentManager(), null);
                            }

            
            {
                this$0 = MessageFragment.this;
                pictureUrls = arraylist;
                super();
            }
                        });
                        viewgroup.addView(imageview);
                        i++;
                    }
                }
            }
            Object obj = (ImageView)view.findViewById(0x7f1000fc);
            if (obj != null)
            {
                if (!TextUtils.isEmpty(item.galleryUrl) && imagecache != null)
                {
                    imagecache.setImage(((ImageView) (obj)), item.galleryUrl);
                } else
                {
                    ((ImageView) (obj)).setImageResource(0x7f02027a);
                }
            }
            ((TextView)view.findViewById(0x7f100108)).setText(item.title);
            if (itemId.longValue() > 0L)
            {
                obj = String.valueOf(itemId);
            } else
            {
                obj = null;
            }
            ((TextView)view.findViewById(0x7f100391)).setText(((CharSequence) (obj)));
            setupViewClick(0x7f100390, true);
            view.findViewById(0x7f10038f).setVisibility(0);
            view.findViewById(0x7f100390).setVisibility(0);
            obj = view.findViewById(0x7f100394);
            if ((obj instanceof TextView) && item.endDate != null)
            {
                obj1 = DateUtils.formatDateTime(((android.content.Context) (obj1)), item.endDate.getTime(), 0x14015);
                ((TextView)obj).setText((new StringBuilder()).append(getResources().getString(0x7f0703c2)).append(": ").append(((String) (obj1))).toString());
            }
            view = view.findViewById(0x7f100395);
            if (view instanceof TextView)
            {
                if (item.listingStatus != null)
                {
                    obj = (new StringBuilder()).append(getResources().getString(0x7f070498)).append(": ").append(item.listingStatus).toString();
                } else
                {
                    obj = null;
                }
                ((TextView)view).setText(((CharSequence) (obj)));
            }
        } else
        if (view != null)
        {
            view.findViewById(0x7f10038f).setVisibility(8);
            view.findViewById(0x7f100390).setVisibility(8);
            return;
        }
    }

    private void setupViewClick(int i, boolean flag)
    {
        View view = getView().findViewById(i);
        view.setOnClickListener(this);
        view.setEnabled(flag);
    }

    private void showProgress(boolean flag)
    {
        boolean flag2;
label0:
        {
            flag2 = false;
            boolean flag1 = false;
            View view = getView();
            if (view != null)
            {
                View view1 = view.findViewById(0x7f100143);
                int i;
                if (flag)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                view1.setVisibility(i);
                view = view.findViewById(0x7f100016);
                if (view == null)
                {
                    break label0;
                }
                if (!flag)
                {
                    i = ((flag1) ? 1 : 0);
                } else
                {
                    i = 8;
                }
                view.setVisibility(i);
            }
            return;
        }
        WebView webview = wv;
        int j;
        if (!flag)
        {
            j = ((flag2) ? 1 : 0);
        } else
        {
            j = 8;
        }
        webview.setVisibility(j);
    }

    protected void doFollowLink(String s, boolean flag)
    {
        Object obj;
        for (obj = ensureActivity(); obj == null || obj == null;)
        {
            return;
        }

        obj = new Intent(((android.content.Context) (obj)), com/ebay/mobile/activities/ShowWebViewActivity);
        ((Intent) (obj)).putExtra("url", s);
        ((Intent) (obj)).putExtra("back", true);
        ((Intent) (obj)).putExtra("use_sso", flag);
        try
        {
            if ("rover.ebay.com".equals((new URL(s)).getHost()))
            {
                if (log.isLoggable || logWebView.isLoggable)
                {
                    logWebView.log("  Using SSO");
                }
                promptLinkUseSso = true;
                ((Intent) (obj)).putExtra("use_sso", true);
                ((Intent) (obj)).putExtra(ShowWebViewActivity.EXTRA_NUM_HISTORY_TO_SKIP, 1);
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        startActivity(((Intent) (obj)));
    }

    public EbayItem getItem()
    {
        return item;
    }

    public EbayMessage getMessage()
    {
        if (message == null)
        {
            processArguments();
        }
        return message;
    }

    public MessageContentsDataManager getMessageContentsDataManager()
    {
        if (messageDm != null)
        {
            return messageDm;
        }
        processArguments();
        FwActivity fwactivity = getFwActivity();
        if (fwactivity == null)
        {
            return null;
        } else
        {
            com.ebay.nautilus.domain.content.dm.MessageContentsDataManager.KeyParams keyparams = new com.ebay.nautilus.domain.content.dm.MessageContentsDataManager.KeyParams(message);
            return (MessageContentsDataManager)DataManager.getIfExists(fwactivity.getEbayContext(), keyparams);
        }
    }

    protected String[] getSyncKeys()
    {
        return (new String[] {
            SYNC_MESSAGES_UPDATED
        });
    }

    public boolean goBackInMessageWebViewHistory()
    {
        boolean flag;
        if (wv != null && wv.canGoBack())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            Object obj = wv.copyBackForwardList();
            obj = ((WebBackForwardList) (obj)).getItemAtIndex(((WebBackForwardList) (obj)).getCurrentIndex() - 1).getUrl();
            wv.goBack();
            if ("about:blank".equals(obj))
            {
                wv.loadDataWithBaseURL(null, message.text, "text/html", "utf-8", null);
            }
        }
        return flag;
    }

    public void markReadMessage(boolean flag)
    {
        EbayMessage ebaymessage = getMessage();
        if (isMessagePlaceholder(ebaymessage))
        {
            markReadMessage = Boolean.valueOf(flag);
            return;
        }
        if (ebaymessage.read == flag)
        {
            markReadMessage = null;
            return;
        }
        ebaymessage = ebaymessage.buildUpon().read(flag).build();
        MessageContentsDataManager messagecontentsdatamanager = getMessageContentsDataManager();
        if (messagecontentsdatamanager == null)
        {
            markReadMessage = Boolean.valueOf(flag);
        } else
        if (messagecontentsdatamanager.markReadMessage(flag) != null)
        {
            markReadMessage = null;
        } else
        {
            markReadMessage = Boolean.valueOf(flag);
        }
        notifyMessagesUpdated(MessagesUtils.makeList(ebaymessage));
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (promptConfirmResultId != -1)
        {
            promptToAbandonDraft(promptConfirmResultId);
        }
        if (!isMessagePlaceholder(message))
        {
            setUpHeaderUi();
            setUpItemUi();
        } else
        {
            showProgress(true);
        }
        if (messageDm != null)
        {
            messageDm.loadData(this);
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 65 65: default 20
    //                   65 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j == -1)
        {
            if ((intent = getMessageContentsDataManager()) != null)
            {
                intent.reloadData();
                return;
            }
        } else
        {
            doPromptGoBackHome(true);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onClick(View view)
    {
        notifyPaneActivated(MessagesBaseFragment.ActivePane.MESSAGES_DETAIL);
        view.getId();
        JVM INSTR lookupswitch 2: default 36
    //                   2131755916: 37
    //                   2131755920: 42;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        doPromptViewUserProfile();
        return;
_L3:
        if (message.itemId != -1L)
        {
            doPromptViewItem(message.itemId);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        processArguments();
        if (log.isLoggable || logUi.isLoggable)
        {
            logUi.log((new StringBuilder()).append("Fragment constructed: ").append(getClass().getSimpleName()).append("(").append(message).append(")").toString());
        }
        initDataManagers();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03015f, null);
        layoutinflater.findViewById(0x7f10038c).setEnabled(false);
        viewgroup = new android.view.View.OnTouchListener() {

            final MessageFragment this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                int i = motionevent.getActionMasked();
                if (i == 0 || i == 1 || i == 3)
                {
                    notifyPaneActivated(MessagesBaseFragment.ActivePane.MESSAGES_DETAIL);
                }
                return false;
            }

            
            {
                this$0 = MessageFragment.this;
                super();
            }
        };
        bundle = layoutinflater.findViewById(0x7f100016);
        if (bundle != null)
        {
            bundle.setOnTouchListener(viewgroup);
        }
        wv = (WebView)layoutinflater.findViewById(0x7f1000f8);
        if (wv != null)
        {
            wv.setOnTouchListener(viewgroup);
        }
        viewgroup = wv.getSettings();
        viewgroup.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NORMAL);
        viewgroup.setLoadsImagesAutomatically(true);
        viewgroup.setJavaScriptEnabled(true);
        viewgroup.setJavaScriptCanOpenWindowsAutomatically(false);
        viewgroup.setSupportZoom(true);
        viewgroup.setBuiltInZoomControls(true);
        viewgroup.setDisplayZoomControls(false);
        wv.setFocusable(false);
        wv.setFocusableInTouchMode(false);
        wv.setWebViewClient(new WebViewClient() {

            final MessageFragment this$0;

            public void onReceivedError(WebView webview, int i, String s, String s1)
            {
                Toast.makeText(getActivity(), s, 0).show();
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                Uri uri;
                Object obj1;
                boolean flag1;
                boolean flag2;
                if (MessagesBaseFragment.log.isLoggable || MessageFragment.logWebView.isLoggable)
                {
                    MessageFragment.logWebView.log((new StringBuilder()).append("WebView redirect: ").append(s).toString());
                }
                notifyPaneActivated(MessagesBaseFragment.ActivePane.MESSAGES_DETAIL);
                uri = Uri.parse(s);
                flag1 = false;
                flag2 = false;
                obj1 = null;
                String s1 = uri.getQueryParameter("loc");
                Object obj = obj1;
                int i;
                int j;
                long l;
                boolean flag;
                if (s1 != null)
                {
                    try
                    {
                        obj = Uri.parse(s1);
                    }
                    catch (Exception exception)
                    {
                        exception = obj1;
                    }
                }
                if (obj == null)
                {
                    obj = uri;
                }
                if (!s.contains("ViewItem") && !s.contains("?BinConfirm&")) goto _L2; else goto _L1
_L1:
                if (MessagesBaseFragment.log.isLoggable || MessageFragment.logWebView.isLoggable)
                {
                    MessageFragment.logWebView.log("  Handle as ItemView/BIN");
                }
                webview = null;
                obj = uri.getQueryParameter("loc");
                if (obj == null) goto _L4; else goto _L3
_L3:
                obj = Uri.parse(((String) (obj))).getQueryParameter("item");
                webview = ((WebView) (obj));
_L8:
                flag = flag2;
                if (webview == null)
                {
                    break MISSING_BLOCK_LABEL_229;
                }
                obj = webview;
                flag = flag1;
                if (12 >= webview.length())
                {
                    break MISSING_BLOCK_LABEL_200;
                }
                flag = flag1;
                obj = webview.substring(0, 12);
                flag = flag1;
                l = Long.parseLong(((String) (obj)));
                flag = true;
                flag1 = true;
                doPromptViewItem(l);
                flag = flag1;
_L6:
                flag1 = flag;
                if (!flag)
                {
                    if (MessagesBaseFragment.log.isLoggable || MessageFragment.logWebView.isLoggable)
                    {
                        MessageFragment.logWebView.log("  Handle as web redirect");
                    }
                    flag = false;
                    if (uri.getHost().startsWith("bulksell."))
                    {
                        flag = true;
                    }
                    doPromptFollowLink(s, flag);
                    flag1 = true;
                }
                return flag1;
_L4:
                obj = uri.getQueryParameter("item");
                webview = ((WebView) (obj));
                continue; /* Loop/switch isn't completed */
_L2:
                if (s.contains("?ManageBestOffers&") || ((Uri) (obj)).isHierarchical() && ((Uri) (obj)).getQueryParameter("ManageBestOffers") != null)
                {
                    if (MessagesBaseFragment.log.isLoggable || MessageFragment.logWebView.isLoggable)
                    {
                        MessageFragment.logWebView.log("  Handle as ItemView/Best Offer");
                    }
                    flag = handleBestOfferButtons(s);
                } else
                if (s.contains("M2MContact"))
                {
                    if (MessagesBaseFragment.log.isLoggable || MessageFragment.logWebView.isLoggable)
                    {
                        MessageFragment.logWebView.log("  Handle as Reply");
                    }
                    reply();
                    flag = true;
                } else
                if (s.contains("FBuyHub"))
                {
                    if (MessagesBaseFragment.log.isLoggable || MessageFragment.logWebView.isLoggable)
                    {
                        MessageFragment.logWebView.log("  Handle as Home");
                    }
                    doPromptGoBackHome(false);
                    flag = true;
                } else
                if (((Uri) (obj)).isHierarchical() && (((Uri) (obj)).getQueryParameter("MyeBay") != null || ((Uri) (obj)).getQueryParameter("MyEbay") != null))
                {
                    if (MessagesBaseFragment.log.isLoggable || MessageFragment.logWebView.isLoggable)
                    {
                        MessageFragment.logWebView.log("  Handle as My eBay");
                    }
                    doPromptViewMyEbay();
                    flag = true;
                } else
                if (s.contains("myworld.ebay.com"))
                {
                    if (MessagesBaseFragment.log.isLoggable || MessageFragment.logWebView.isLoggable)
                    {
                        MessageFragment.logWebView.log("  Handle as User Details");
                    }
                    webview = ((Uri) (obj)).getPathSegments();
                    flag = flag2;
                    if (webview != null)
                    {
                        flag = flag2;
                        if (!webview.isEmpty())
                        {
                            webview = (String)webview.get(webview.size() - 1);
                            doPromptViewUserProfileHtml(webview);
                            flag = true;
                        }
                    }
                } else
                {
                    flag = flag2;
                    if (!s.contains("?ReviseFeedbackAccept&"))
                    {
                        flag = flag2;
                        if (!s.contains("?ReviseFeedbackDecline&"))
                        {
                            if (s.contains("feedback.ebay.com"))
                            {
                                if (MessagesBaseFragment.log.isLoggable || MessageFragment.logWebView.isLoggable)
                                {
                                    MessageFragment.logWebView.log("  Handle as Seller Feedback");
                                }
                                i = s.indexOf("userid%") + 9;
                                j = s.indexOf("%", i);
                                flag = flag2;
                                if (i >= 0)
                                {
                                    flag = flag2;
                                    if (i < j)
                                    {
                                        doPromptViewFeedback(s.substring(i, j));
                                        flag = true;
                                    }
                                }
                            } else
                            {
                                obj = new Intent("android.intent.action.VIEW", uri);
                                if (!uri.isHierarchical())
                                {
                                    if (MessagesBaseFragment.log.isLoggable || MessageFragment.logWebView.isLoggable)
                                    {
                                        MessageFragment.logWebView.log("  Handle as a non-hierarchical link");
                                    }
                                    doPromptDeepLink(((Intent) (obj)));
                                    flag = true;
                                } else
                                {
                                    webview = FwContextUtil.getLocalActivity(webview.getContext(), ((Intent) (obj)));
                                    flag = flag2;
                                    if (webview.getComponent() != null)
                                    {
                                        if (MessagesBaseFragment.log.isLoggable || MessageFragment.logWebView.isLoggable)
                                        {
                                            MessageFragment.logWebView.log("  Handle as Deep Link");
                                        }
                                        doPromptDeepLink(webview);
                                        flag = true;
                                    }
                                }
                            }
                        }
                    }
                }
                continue; /* Loop/switch isn't completed */
                webview;
                if (true) goto _L6; else goto _L5
_L5:
                obj;
                if (true) goto _L8; else goto _L7
_L7:
            }

            
            {
                this$0 = MessageFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onDeleteMessageCompleted(MessageContentsDataManager messagecontentsdatamanager, Content content)
    {
        if (content.getStatus().hasError())
        {
            notifyApiError(content.getStatus());
        }
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        wv = null;
        onSaveMessageFragmentStateListener = null;
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        if (j != 1) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 0 7: default 52
    //                   0 58
    //                   1 78
    //                   2 89
    //                   3 109
    //                   4 120
    //                   5 131
    //                   6 151
    //                   7 180;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L2:
        promptConfirmResultId = -1;
        return;
_L3:
        clearDraft();
        doViewItem(promptViewItemId);
        promptViewItemId = 0L;
        continue; /* Loop/switch isn't completed */
_L4:
        clearDraft();
        doViewUserProfile();
        continue; /* Loop/switch isn't completed */
_L5:
        clearDraft();
        doViewUserProfileHtml(promptViewUserIdHtml);
        promptViewUserIdHtml = null;
        continue; /* Loop/switch isn't completed */
_L6:
        clearDraft();
        goBackHome();
        continue; /* Loop/switch isn't completed */
_L7:
        clearDraft();
        doViewMyEbay();
        continue; /* Loop/switch isn't completed */
_L8:
        clearDraft();
        doViewFeedback(promptViewFeedbackUserId);
        promptViewFeedbackUserId = null;
        continue; /* Loop/switch isn't completed */
_L9:
        clearDraft();
        doFollowLink(promptLinkUrl, promptLinkUseSso);
        promptLinkUrl = null;
        promptLinkUseSso = false;
        continue; /* Loop/switch isn't completed */
_L10:
        clearDraft();
        if (promptDeepLinkIntent != null)
        {
            startActivity(addSourceIdTracking(promptDeepLinkIntent));
            promptDeepLinkIntent = null;
        }
        if (true) goto _L2; else goto _L11
_L11:
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        messageDm = (MessageContentsDataManager)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.MessageContentsDataManager.KeyParams(message), this);
        doDelayedMarkReadMessage();
    }

    public void onMessageContentsChanged(MessageContentsDataManager messagecontentsdatamanager, Content content)
    {
        if (log.isLoggable || logUiDm.isLoggable)
        {
            logUiDm.log((new StringBuilder()).append(getClass().getSimpleName()).append(".onMessageContentsChanged: ").toString());
            logUiDm.log((new StringBuilder()).append("  Result: ").append(contentToString(content)).toString());
        }
        if (getView() != null)
        {
            showProgress(false);
        }
        if (content != null && content.getData() != null && !content.getStatus().hasError())
        {
            boolean flag = isMessagePlaceholder(message);
            message = (EbayMessage)content.getData();
            if (flag && !isMessagePlaceholder(message))
            {
                setUpHeaderUi();
                setUpItemUi();
                markReadMessage = Boolean.valueOf(true);
                content = MessagesUtils.findById(message.messageId, getAllMessages());
                if (content == null || isMessagePlaceholder(content))
                {
                    messagecontentsdatamanager.messageIsNew();
                }
            }
            loadWebview();
            doDelayedMarkReadMessage();
            return;
        } else
        {
            notifyApiError(content.getStatus());
            return;
        }
    }

    public void onMessageItemChanged(MessageContentsDataManager messagecontentsdatamanager, Content content)
    {
label0:
        {
            if (log.isLoggable || logUiDm.isLoggable)
            {
                logUiDm.log((new StringBuilder()).append(getClass().getSimpleName()).append(".onMessageItemChanged: ").toString());
                logUiDm.log((new StringBuilder()).append("  Result: ").append(contentToString(content)).toString());
            }
            if (getView() != null)
            {
                showProgress(false);
            }
            if (content != null)
            {
                if (content.getStatus().hasError())
                {
                    break label0;
                }
                item = (EbayItem)content.getData();
                itemId = Long.valueOf(item.id);
                setUpItemUi();
            }
            return;
        }
        notifyApiError(content.getStatus());
    }

    public void onMoveMessageCompleted(MessageContentsDataManager messagecontentsdatamanager, Content content, long l)
    {
        if (content.getStatus().hasError())
        {
            notifyApiError(content.getStatus());
        }
    }

    protected void onNotifyMessagesUpdated(List list)
    {
        int i;
        if (message != null)
        {
            if ((i = list.indexOf(message)) >= 0)
            {
                list = (EbayMessage)list.get(i);
                message = message.buildUpon().read(((EbayMessage) (list)).read).flagged(((EbayMessage) (list)).flagged).build();
                return;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        wv.saveState(bundle);
        bundle.putInt(STATE_CONFIRM_RESULT_ID, promptConfirmResultId);
        bundle.putString("linkurlDuringDraft", promptLinkUrl);
        bundle.putBoolean("useSso", promptLinkUseSso);
        bundle.putLong("itemId", promptViewItemId);
        bundle.putString("userIdHtml", promptViewUserIdHtml);
        bundle.putString("feedbackUserId", promptViewFeedbackUserId);
        bundle.putParcelable("deepLinkIntent", promptDeepLinkIntent);
        if (onSaveMessageFragmentStateListener != null)
        {
            onSaveMessageFragmentStateListener.onSaveMessageFragmentState(getMessage(), bundle);
        }
    }

    public void setOnSaveMessageFragmentStateListener(OnSaveMessageFragmentStateListener onsavemessagefragmentstatelistener)
    {
        onSaveMessageFragmentStateListener = onsavemessagefragmentstatelistener;
    }










}
