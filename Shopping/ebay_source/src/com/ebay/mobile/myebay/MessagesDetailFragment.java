// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.common.Preferences;
import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.common.net.api.trading.AddMemberMessageRTQNetLoader;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.dm.MessageContentsDataManager;
import com.ebay.nautilus.domain.content.dm.MessagesUtils;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.EbayItem;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessagesBaseFragment, MessageFragment, ComposeMessageFragment, MessagesFilterType, 
//            MessagesSync, MessageTransformer

public class MessagesDetailFragment extends MessagesBaseFragment
    implements DialogFragmentCallback, ComposeMessageFragment.OnMessageSendListener, MessageFragment.OnSaveMessageFragmentStateListener
{
    private class MessagesDetailPagerAdapter extends FragmentStatePagerAdapter
    {

        private final List messages;
        final MessagesDetailFragment this$0;

        public int getCount()
        {
            if (messages != null)
            {
                return messages.size();
            } else
            {
                return 0;
            }
        }

        public Fragment getItem(int i)
        {
            MessageFragment messagefragment = new MessageFragment();
            Bundle bundle = new Bundle();
            if (messages != null && i < messages.size())
            {
                EbayMessage ebaymessage = (EbayMessage)messages.get(i);
                bundle.putParcelable("com.ebay.mobile.param.message", ebaymessage);
                if (ebaymessage.equals(currentMessage) && MessagesDetailFragment.currentMessageState != null)
                {
                    bundle.putBundle("com.ebay.mobile.param.webview.state", MessagesDetailFragment.currentMessageState);
                    MessagesDetailFragment.currentMessageState = null;
                }
            }
            messagefragment.setArguments(bundle);
            messagefragment.setOnSaveMessageFragmentStateListener(MessagesDetailFragment.this);
            return messagefragment;
        }

        public boolean updateMessages(List list)
        {
            return MessagesUtils.updateAll(list, messages);
        }

        public MessagesDetailPagerAdapter(FragmentManager fragmentmanager, List list)
        {
            this$0 = MessagesDetailFragment.this;
            super(fragmentmanager);
            messages = new ArrayList(list);
        }
    }


    private static final String ERROR_INVALID_ITEM = "16202";
    private static final int LOADER_ID_SELLER_REPLY_TO_QUESTION = 1;
    public static final String PARAM_OUT_MESSAGE = "com.ebay.mobile.param.message";
    public static final String PARAM_OUT_REPLY_SENT = "com.ebay.mobile.param.reply_sent";
    private static final int RESULT_PAGE_SCROLLED = 1;
    private static Bundle currentMessageState;
    private List allMessages;
    private Animation animationSlideDown;
    private Animation animationSlideUp;
    private ComposeMessageFragment composeMessageFragment;
    private ViewGroup composeMessageHolder;
    private EbayMessage currentMessage;
    private EbayMessage inputMessage;
    private String inputMessageId;
    private Boolean pageSelectIsUserAction;
    private boolean pageSelectSkipDraftPrompt;
    private int promptPageScrollDesiredPage;
    private SourceIdentification sid;
    private ViewPager viewPager;

    public MessagesDetailFragment()
    {
        pageSelectSkipDraftPrompt = false;
        pageSelectIsUserAction = null;
        promptPageScrollDesiredPage = -1;
    }

    public static MessagesDetailFragment createFragment(SourceIdentification sourceidentification, String s)
    {
        MessagesDetailFragment messagesdetailfragment = new MessagesDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("message_id", s);
        bundle.putParcelable("com.ebay.mobile.analytics.sid", sourceidentification);
        messagesdetailfragment.setArguments(bundle);
        return messagesdetailfragment;
    }

    private void doPageSelect(int i)
    {
        MessageFragment messagefragment;
        boolean flag;
        if (pageSelectIsUserAction != null)
        {
            flag = pageSelectIsUserAction.booleanValue();
        } else
        {
            flag = isDetailPaneVisible();
        }
        messagefragment = getCurrentFragment();
        if (messagefragment != null)
        {
            setCurrentMessage(messagefragment.getMessage(), flag);
        }
        notifyCurrentMessageChanged(currentMessage, flag);
        setupComposeVisiblity();
    }

    private void doPromptPageSelect(int i, int j)
    {
        if (!pageSelectSkipDraftPrompt && isDraftInProgress())
        {
            promptPageScrollDesiredPage = j;
            viewPager.setCurrentItem(i);
            ComposeMessageFragment.showConfirmAbandonMessageDialogFragment(this, 1, null);
            return;
        } else
        {
            pageSelectSkipDraftPrompt = false;
            doPageSelect(j);
            return;
        }
    }

    private MessageFragment getCurrentFragment()
    {
        Object obj = null;
        MessageFragment messagefragment = obj;
        if (viewPager != null)
        {
            int i = viewPager.getCurrentItem();
            MessagesDetailPagerAdapter messagesdetailpageradapter = (MessagesDetailPagerAdapter)viewPager.getAdapter();
            messagefragment = obj;
            if (messagesdetailpageradapter != null)
            {
                messagefragment = (MessageFragment)messagesdetailpageradapter.instantiateItem(viewPager, i);
            }
        }
        return messagefragment;
    }

    private FragmentManager getPre17ChildFragmentManager()
    {
        return getFragmentManager();
    }

    private EbayTradingApi getTradingApi()
    {
        Activity activity = getActivity();
        com.ebay.nautilus.domain.app.Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication != null)
        {
            return EbayApiUtil.getTradingApi(activity, authentication);
        }
        if (activity != null)
        {
            activity.finish();
        }
        return null;
    }

    private void handleAddMessageError(EbaySimpleNetLoader ebaysimplenetloader, String s)
    {
        Object obj;
        obj = null;
        ebaysimplenetloader = ebaysimplenetloader.getServiceErrorsAndWarnings();
        if (ebaysimplenetloader != null)
        {
            ebaysimplenetloader = (EbayResponseError)ebaysimplenetloader.get(0);
        } else
        {
            ebaysimplenetloader = null;
        }
        if (ebaysimplenetloader != null)
        {
            obj = ((EbayResponseError) (ebaysimplenetloader)).longMessage;
        }
        if (ebaysimplenetloader == null || !"16202".equals(((EbayResponseError) (ebaysimplenetloader)).code)) goto _L2; else goto _L1
_L1:
        ebaysimplenetloader = getString(0x7f070636);
_L4:
        obj = new android.support.v7.app.AlertDialog.Builder(getActivity());
        ((android.support.v7.app.AlertDialog.Builder) (obj)).setIcon(0x1080027).setTitle(s).setMessage(ebaysimplenetloader).setPositiveButton(0x7f070738, new android.content.DialogInterface.OnClickListener() {

            final MessagesDetailFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = MessagesDetailFragment.this;
                super();
            }
        }).create();
        ((android.support.v7.app.AlertDialog.Builder) (obj)).show();
        return;
_L2:
        ebaysimplenetloader = ((EbaySimpleNetLoader) (obj));
        if (obj == null)
        {
            s = getString(0x7f070629);
            ebaysimplenetloader = getString(0x7f070635);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void onReplyComplete(EbaySimpleNetLoader ebaysimplenetloader, int i)
    {
        if (!ebaysimplenetloader.isError() && ebaysimplenetloader.getResponse() != null)
        {
            ebaysimplenetloader = new com.ebay.nautilus.domain.content.dm.MessageContentsDataManager.KeyParams(currentMessage);
            ebaysimplenetloader = (MessageContentsDataManager)DataManager.getIfExists(getFwActivity().getEbayContext(), ebaysimplenetloader);
            if (ebaysimplenetloader != null)
            {
                ebaysimplenetloader.markRepliedMessage();
            }
            notifyMessageSent();
        } else
        {
            composeMessageFragment.setSendEnabled(true);
            if (Util.checkForIAFTokenError(ebaysimplenetloader))
            {
                ebaysimplenetloader = (BaseActivity)getActivity();
                if (ebaysimplenetloader != null)
                {
                    ebaysimplenetloader.handleIafTokenExpiration();
                    return;
                }
            } else
            {
                handleAddMessageError(ebaysimplenetloader, getString(i));
                return;
            }
        }
    }

    private void setCurrentMessage(EbayMessage ebaymessage, boolean flag)
    {
        currentMessage = ebaymessage;
        if (flag && currentMessage != null && currentMessage.isUnread() && getFilterType() != MessagesFilterType.FILTER_UNREAD)
        {
            ebaymessage = getCurrentFragment();
            if (ebaymessage != null)
            {
                ebaymessage.markReadMessage(true);
            }
        }
    }

    private void setupComposeVisiblity()
    {
        byte byte0 = 0;
        boolean flag;
        if (currentMessage == null || !currentMessage.responseEnabled)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            byte0 = 8;
        }
        if (composeMessageHolder.getVisibility() != byte0)
        {
            ViewGroup viewgroup = composeMessageHolder;
            Animation animation;
            if (flag)
            {
                animation = animationSlideDown;
            } else
            {
                animation = animationSlideUp;
            }
            viewgroup.startAnimation(animation);
            composeMessageHolder.setVisibility(byte0);
        }
    }

    private void showCurrentMessage(boolean flag, boolean flag1)
    {
        if (allMessages != null)
        {
            EbayMessage ebaymessage = currentMessage;
            int j = allMessages.indexOf(currentMessage);
            int i = j;
            if (j == -1)
            {
                if (allMessages.isEmpty())
                {
                    ebaymessage = null;
                    i = j;
                } else
                {
                    i = 0;
                    ebaymessage = (EbayMessage)allMessages.get(0);
                }
            }
            if (currentMessage != ebaymessage)
            {
                currentMessage = ebaymessage;
                notifyCurrentMessageChanged(currentMessage, flag1);
            }
            if (i != -1 && viewPager != null)
            {
                pageSelectSkipDraftPrompt = flag;
                pageSelectIsUserAction = Boolean.valueOf(flag1);
                viewPager.setCurrentItem(i);
            }
        }
    }

    public ComposeMessageFragment getComposeMessageFragment()
    {
        return composeMessageFragment;
    }

    public EbayMessage getCurrentMessage()
    {
        return currentMessage;
    }

    public String getInputMessageId()
    {
        return inputMessageId;
    }

    protected String[] getSyncKeys()
    {
        return (new String[] {
            SYNC_CURRENT_MESSAGE_CHANGED, SYNC_ALL_MESSAGES_CHANGED, SYNC_FILTER_TYPE_CHANGED, SYNC_MESSAGES_UPDATED
        });
    }

    public boolean goBackInMessageWebViewHistory()
    {
        MessageFragment messagefragment = getCurrentFragment();
        return messagefragment != null && messagefragment.goBackInMessageWebViewHistory();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (allMessages == null)
        {
            allMessages = getFilteredMessages();
            bundle = new MessagesDetailPagerAdapter(getPre17ChildFragmentManager(), allMessages);
            viewPager.setAdapter(bundle);
        }
        if (currentMessage == null)
        {
            currentMessage = getMessagesSync().getCurrentMessage();
        }
        showCurrentMessage(false, false);
        if (currentMessage != null && currentMessage.isUnread() && getFilterType() != MessagesFilterType.FILTER_UNREAD)
        {
            bundle = getCurrentFragment();
            if (bundle != null)
            {
                bundle.markReadMessage(true);
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
        composeMessageFragment = ComposeMessageFragment.newInstance(this, 0, null, null);
        getFragmentManager().beginTransaction().add(0x7f10014b, composeMessageFragment, "compose.fragment").commit();
        bundle = getArguments();
        if (bundle != null)
        {
            sid = (SourceIdentification)bundle.getParcelable("com.ebay.mobile.analytics.sid");
            inputMessageId = bundle.getString("message_id");
            if (inputMessageId != null && "notification.multiple.messages".equals(inputMessageId))
            {
                inputMessageId = null;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        composeMessageHolder = (ViewGroup)viewgroup.findViewById(0x7f10014b);
        composeMessageHolder.setVisibility(8);
        composeMessageFragment.setOnClickListener(new android.view.View.OnClickListener() {

            final MessagesDetailFragment this$0;

            public void onClick(View view)
            {
                notifyPaneActivated(MessagesBaseFragment.ActivePane.MESSAGES_DETAIL);
            }

            
            {
                this$0 = MessagesDetailFragment.this;
                super();
            }
        });
        viewPager = (ViewPager)viewgroup.findViewById(0x7f100399);
        viewPager.setOnPageChangeListener(new android.support.v4.view.ViewPager.SimpleOnPageChangeListener() {

            private int lastPageSelection;
            final MessagesDetailFragment this$0;

            public void onPageSelected(int i)
            {
                int j = lastPageSelection;
                lastPageSelection = i;
                if (!currentMessage.equals(allMessages.get(i)) && -1 == promptPageScrollDesiredPage)
                {
                    notifyPaneActivated(MessagesBaseFragment.ActivePane.MESSAGES_DETAIL);
                    doPromptPageSelect(j, i);
                }
                pageSelectSkipDraftPrompt = false;
                pageSelectIsUserAction = null;
            }

            
            {
                this$0 = MessagesDetailFragment.this;
                super();
                lastPageSelection = -1;
            }
        });
        if (!isDualPane())
        {
            viewPager.setPageTransformer(true, new MessageTransformer());
            viewPager.setBackgroundResource(0x106000c);
        }
        layoutinflater = getActivity();
        animationSlideUp = AnimationUtils.loadAnimation(layoutinflater, 0x7f040017);
        animationSlideDown = AnimationUtils.loadAnimation(layoutinflater, 0x7f040014);
        if (inputMessageId != null)
        {
            setInputMessageId(inputMessageId);
        }
        return null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        composeMessageHolder = null;
        promptPageScrollDesiredPage = -1;
        viewPager = null;
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        if (i == 1)
        {
            i = promptPageScrollDesiredPage;
            promptPageScrollDesiredPage = -1;
            if (j == 1)
            {
                clearDraft();
                viewPager.setCurrentItem(i, true);
            }
        }
    }

    public void onMessageSend(int i, String s, ArrayList arraylist, Bundle bundle)
    {
        Activity activity;
        activity = ensureActivity();
        break MISSING_BLOCK_LABEL_6;
        if (activity != null && s.length() > 0)
        {
            Toast.makeText(activity, getResources().getString(0x7f070109), 0).show();
            bundle = getCurrentFragment();
            Long long1;
            Object obj;
            Object obj1;
            boolean flag;
            if (bundle == null)
            {
                bundle = null;
            } else
            {
                bundle = bundle.getItem();
            }
            if (bundle == null)
            {
                long1 = null;
            } else
            {
                long1 = Long.valueOf(((EbayItem) (bundle)).id);
            }
            if (bundle == null)
            {
                obj = "";
            } else
            {
                obj = ((EbayItem) (bundle)).sellerUserId;
            }
            obj1 = MyApp.getPrefs().getCurrentUser();
            if (bundle == null)
            {
                flag = false;
            } else
            {
                flag = ((String) (obj1)).equalsIgnoreCase(((String) (obj)));
            }
            obj = getTradingApi();
            obj1 = new TrackingData("M2M", TrackingType.EVENT);
            if (long1 != null)
            {
                ((TrackingData) (obj1)).addKeyValuePair("itm", String.valueOf(long1));
            }
            if (flag)
            {
                ((TrackingData) (obj1)).addKeyValuePair(com.ebay.mobile.analytics.Tracking.Tag.MESSAGE_DIRECTION, String.valueOf(com.ebay.mobile.activities.ComposeNewMessageActivity.MemberMessageTagValues.SELLER_REPLY.ordinal()));
            } else
            {
                ((TrackingData) (obj1)).addKeyValuePair(com.ebay.mobile.analytics.Tracking.Tag.MESSAGE_DIRECTION, String.valueOf(com.ebay.mobile.activities.ComposeNewMessageActivity.MemberMessageTagValues.BUYER_ASK_QUESTION.ordinal()));
            }
            if (sid != null)
            {
                ((TrackingData) (obj1)).addSourceIdentification(sid);
            }
            if (bundle != null)
            {
                CurrencyAmount currencyamount = new CurrencyAmount(((EbayItem) (bundle)).currentPrice);
                ((TrackingData) (obj1)).addKeyValuePair("shipsiteid", (new StringBuilder()).append("").append(EbaySite.getInstanceFromId(((EbayItem) (bundle)).site).idInt).toString());
                ((TrackingData) (obj1)).addKeyValuePair("curprice", (new StringBuilder()).append("").append(currencyamount.getValueAsBigDecimal().doubleValue()).toString());
                ((TrackingData) (obj1)).addKeyValuePair("leaf", (new StringBuilder()).append("").append(((EbayItem) (bundle)).primaryCategoryId).toString());
            }
            ((TrackingData) (obj1)).send(activity);
            s = new AddMemberMessageRTQNetLoader(getFwActivity().getEbayContext(), ((EbayTradingApi) (obj)), currentMessage.externalMessageId, long1, currentMessage.sender, s, arraylist);
            getFwLoaderManager().start(1, s, false);
            s = new TrackingData("ViewMessage", TrackingType.EVENT);
            s.addKeyValuePair("memmes", String.valueOf(1));
            s.addKeyValuePair("msgact", String.valueOf(3));
            s.send(activity);
            if (log.isLoggable || logTracking.isLoggable)
            {
                logTracking.log(String.format("Tracking messages event=%s, eBaymes=%s, memmes=%s, msgact=%s [%s]", new Object[] {
                    "ViewMessage", Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3), currentMessage
                }));
                return;
            }
        }
        return;
    }

    protected void onNotifyAllMessagesChanged(List list)
    {
        if (ensureActivity() != null)
        {
            allMessages = getFilteredMessages();
            if (viewPager != null)
            {
                list = new MessagesDetailPagerAdapter(getPre17ChildFragmentManager(), allMessages);
                viewPager.setAdapter(list);
                showCurrentMessage(true, false);
                return;
            }
        }
    }

    protected void onNotifyCurrentMessageChanged(EbayMessage ebaymessage, boolean flag)
    {
        if (ensureActivity() != null && viewPager != null && (ebaymessage != null || inputMessage == null))
        {
            inputMessage = null;
            if (currentMessage == null || ebaymessage == null || ebaymessage.folderId != currentMessage.folderId)
            {
                allMessages = getFilteredMessages();
                MessagesDetailPagerAdapter messagesdetailpageradapter = new MessagesDetailPagerAdapter(getPre17ChildFragmentManager(), allMessages);
                viewPager.setAdapter(messagesdetailpageradapter);
            }
            currentMessage = ebaymessage;
            showCurrentMessage(false, flag);
            setupComposeVisiblity();
            if (flag && currentMessage != null && currentMessage.isUnread() && getFilterType() != MessagesFilterType.FILTER_UNREAD)
            {
                ebaymessage = getCurrentFragment();
                if (ebaymessage != null)
                {
                    ebaymessage.markReadMessage(true);
                    return;
                }
            }
        }
    }

    protected void onNotifyFilterTypeChanged(MessagesFilterType messagesfiltertype)
    {
        allMessages = getFilteredMessages();
        if (viewPager != null)
        {
            messagesfiltertype = new MessagesDetailPagerAdapter(getPre17ChildFragmentManager(), allMessages);
            viewPager.setAdapter(messagesfiltertype);
            showCurrentMessage(false, false);
        }
    }

    protected void onNotifyMessagesUpdated(List list)
    {
        boolean flag = MessagesUtils.updateAll(list, allMessages);
        if (viewPager != null)
        {
            MessagesDetailPagerAdapter messagesdetailpageradapter = (MessagesDetailPagerAdapter)viewPager.getAdapter();
            if (!(flag & messagesdetailpageradapter.updateMessages(list)))
            {
                messagesdetailpageradapter.notifyDataSetChanged();
            }
        }
    }

    public void onSaveMessageFragmentState(EbayMessage ebaymessage, Bundle bundle)
    {
        if (currentMessage != null && currentMessage.equals(ebaymessage))
        {
            currentMessageState = bundle;
        }
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        if (ensureActivity() == null)
        {
            return;
        }
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            onReplyComplete((AddMemberMessageRTQNetLoader)fwloader, 0x7f070919);
            break;
        }
    }

    public void setInputMessageId(String s)
    {
label0:
        {
            if (s != null && !"notification.multiple.messages".equals(s))
            {
                if (viewPager == null)
                {
                    break label0;
                }
                inputMessage = (new com.ebay.nautilus.domain.data.EbayMessage.Builder(s)).folderId(0L).receiveDate(new Date()).build();
                allMessages = MessagesUtils.makeList(inputMessage);
                s = new MessagesDetailPagerAdapter(getPre17ChildFragmentManager(), allMessages);
                viewPager.setAdapter(s);
                showCurrentMessage(false, true);
                inputMessageId = null;
            }
            return;
        }
        inputMessageId = s;
    }






/*
    static boolean access$402(MessagesDetailFragment messagesdetailfragment, boolean flag)
    {
        messagesdetailfragment.pageSelectSkipDraftPrompt = flag;
        return flag;
    }

*/


/*
    static Boolean access$502(MessagesDetailFragment messagesdetailfragment, Boolean boolean1)
    {
        messagesdetailfragment.pageSelectIsUserAction = boolean1;
        return boolean1;
    }

*/



/*
    static Bundle access$602(Bundle bundle)
    {
        currentMessageState = bundle;
        return bundle;
    }

*/
}
