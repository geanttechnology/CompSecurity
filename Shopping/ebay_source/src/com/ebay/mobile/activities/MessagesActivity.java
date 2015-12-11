// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import com.ebay.app.AlertDialogFragment;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.common.Preferences;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ServiceStarter;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.myebay.ComposeMessageFragment;
import com.ebay.mobile.myebay.MessagesBaseFragment;
import com.ebay.mobile.myebay.MessagesDetailFragment;
import com.ebay.mobile.myebay.MessagesFilterType;
import com.ebay.mobile.myebay.MessagesMasterFragment;
import com.ebay.mobile.myebay.MessagesSync;
import com.ebay.mobile.notifications.NotificationTrackingUtil;
import com.ebay.mobile.ui_stuff.MenuHandler;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.nautilus.domain.content.dm.MessagesUtils;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.data.MessageFolder;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity, MoveMessagesDialog, SignInModalActivity

public class MessagesActivity extends BaseActivity
    implements DialogFragmentCallback, MoveMessagesDialog.OnMoveMessagesDialogListener, MessagesSync, com.ebay.mobile.util.ContentSyncManager.ContentSync
{

    private static final int DIALOG_BACK = 1;
    private static final int DIALOG_ERROR = 2;
    private static final int DIALOG_MESSAGE_ID_ERROR = 3;
    private static final int ERROR_BAD_MESSAGE_ID = 20118;
    public static final String NOTIFICATION_MULTIPLE_MESSAGES = "notification.multiple.messages";
    private static final String STATE_ACTIVE_PANE = "instanceStateActivePane";
    private static final String STATE_CURRENT_MSG = "instanceStateCurrentMsg";
    private static final String STATE_ERROR_DIALOG_SHOWING = "errorDialogShowing";
    private static final String STATE_MSG_ID_ERROR_DIALOG_SHOWING = "msgIdErrorDialogShowing";
    private static final String STATE_NO_MASTER_ON_BACK = "instanceStateNoMasterOnBack";
    private static final String TAG_DETAILS_FRAGMENT = "messages.details";
    private static final String TAG_MASTER_FRAGMENT = "messages.master";
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("Messages", 3, "User Messages sent between eBay members and to/from eBay.");
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTracking = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("Messages.Tracking", 3, "User Messages sent between eBay members and to/from eBay.");
    private com.ebay.mobile.myebay.MessagesBaseFragment.ActivePane activePane;
    private Animation animationScreenIn;
    private Animation animationScreenOut;
    private ComposeMessageFragment composeFragment;
    private MessagesDetailFragment detailFragment;
    private AlertDialogFragment errorDialog;
    private ImageCache imageCache;
    private String inputMessageId;
    private boolean isDetailPaneVisible;
    private boolean isDualPane;
    private boolean isErrorDialogShowing;
    private boolean isMasterPaneVisible;
    private boolean isMsgIdErrorDialogShowing;
    private boolean isShoppingCartEnabled;
    private MessageFolder lastTrackedFolder;
    private EbayMessage lastTrackedMessage;
    private MessagesMasterFragment masterFragment;
    private boolean noMasterOnBack;
    private final String syncTags[];
    private boolean trackingNoInboxDataSent;

    public MessagesActivity()
    {
        syncTags = (new String[] {
            MessagesBaseFragment.SYNC_CURRENT_MESSAGE_CHANGED, MessagesBaseFragment.SYNC_MESSAGES_MOVED, MessagesBaseFragment.SYNC_MESSAGES_REMOVED, MessagesBaseFragment.SYNC_MESSAGE_SENT, MessagesBaseFragment.SYNC_API_ERROR, MessagesBaseFragment.SYNC_PANE_ACTIVATED, MessagesBaseFragment.SYNC_CURRENT_FOLDER_CHANGED, MessagesBaseFragment.SYNC_ALL_MESSAGES_CHANGED
        });
        noMasterOnBack = false;
        isErrorDialogShowing = false;
        isMsgIdErrorDialogShowing = false;
        activePane = com.ebay.mobile.myebay.MessagesBaseFragment.ActivePane.MESSAGES_MASTER;
        lastTrackedFolder = null;
        lastTrackedMessage = null;
        isShoppingCartEnabled = false;
        trackingNoInboxDataSent = false;
    }

    public static TrackingData addMessagesCountsArgs(TrackingData trackingdata, List list)
    {
        if (list != null)
        {
            int j = 0;
            int i = 0;
            for (list = list.iterator(); list.hasNext();)
            {
                if (((EbayMessage)list.next()).isEbayMessage())
                {
                    j++;
                } else
                {
                    i++;
                }
            }

            trackingdata.addKeyValuePair("eBaymes", String.valueOf(j));
            trackingdata.addKeyValuePair("memmes", String.valueOf(i));
        }
        return trackingdata;
    }

    private void clearMultiSelection()
    {
        masterFragment.clearMultiSelection();
    }

    private boolean getIsMessageListLoaded()
    {
        return masterFragment.getIsMessageListLoaded();
    }

    private void handleDeleteSelected()
    {
        if (isDraftInProgress())
        {
            showDialog(0x7f1009e8);
            return;
        } else
        {
            doDelete();
            return;
        }
    }

    private void handleMoveSelected()
    {
        if (isDraftInProgress())
        {
            showDialog(0x7f1009e9);
            return;
        } else
        {
            doMove();
            return;
        }
    }

    private void handleRefreshSelected()
    {
        doRefresh();
    }

    private void initComposeFragment()
    {
        if (composeFragment == null)
        {
            composeFragment = (ComposeMessageFragment)getFragmentManager().findFragmentByTag("compose.fragment");
        }
    }

    private boolean isMultiSelectionInProgress()
    {
        return masterFragment.isMultiSelectionInProgress();
    }

    private void processIntentArguments(Intent intent)
    {
        inputMessageId = intent.getStringExtra("message_id");
        boolean flag;
        if (inputMessageId != null && !"notification.multiple.messages".equals(inputMessageId))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        noMasterOnBack = flag;
        if (inputMessageId != null)
        {
            intent.removeExtra("message_id");
        }
        if (intent.getIntExtra("noti_type_id", -1) != -1)
        {
            intent = intent.getStringExtra("event_type");
            if (!TextUtils.isEmpty(intent))
            {
                ServiceStarter.startUpdateNotificationCacheService(this, intent, null);
            }
        }
    }

    private void setDetailVisibility(boolean flag, boolean flag1)
    {
        View view = findViewById(0x7f100370);
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        if (flag1 && view.getVisibility() != i)
        {
            Animation animation;
            if (flag)
            {
                animation = animationScreenIn;
            } else
            {
                animation = animationScreenOut;
            }
            view.startAnimation(animation);
        }
        view.setVisibility(i);
    }

    private void setPaneVisibility(boolean flag, boolean flag1, boolean flag2)
    {
        String s = null;
        isMasterPaneVisible = flag;
        isDetailPaneVisible = flag1;
        Object obj;
        Object obj1;
        boolean flag3;
        if (flag && flag1)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        isDualPane = flag3;
        if (!isDualPane)
        {
            if (flag)
            {
                obj = com.ebay.mobile.myebay.MessagesBaseFragment.ActivePane.MESSAGES_MASTER;
            } else
            {
                obj = com.ebay.mobile.myebay.MessagesBaseFragment.ActivePane.MESSAGES_DETAIL;
            }
            activePane = ((com.ebay.mobile.myebay.MessagesBaseFragment.ActivePane) (obj));
        }
        setDetailVisibility(flag1, flag2);
        obj1 = null;
        obj = obj1;
        if (!flag)
        {
            obj = getCurrentFolder();
            MessagesFilterType messagesfiltertype = getFilterType();
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = ((MessageFolder) (obj)).folderName;
            }
            if (messagesfiltertype != null)
            {
                s = getResources().getStringArray(0x7f0e0014)[messagesfiltertype.ordinal()];
            }
            if (obj != null)
            {
                if (s != null)
                {
                    obj = (new StringBuilder()).append(((String) (obj))).append(": ").append(s).toString();
                }
            } else
            {
                obj = obj1;
                if (s != null)
                {
                    obj = s;
                }
            }
        }
        if (obj == null)
        {
            setTitle(0x7f070620);
            return;
        } else
        {
            setTitle(((CharSequence) (obj)));
            return;
        }
    }

    private void showErrorDialog()
    {
        errorDialog = (new com.ebay.app.AlertDialogFragment.Builder()).setTitle(0x7f070629).setMessage(0x7f070628).setNegativeButton(0x7f0701cc).setPositiveButton(0x7f0708f3).createFromActivity(2);
        errorDialog.show(getFragmentManager(), "message_general_error");
    }

    private void showMessageIdErrorDialog()
    {
        (new com.ebay.app.AlertDialogFragment.Builder()).setTitle(0x7f070629).setMessage(0x7f070621).setPositiveButton(0x7f0708f3).createFromActivity(3).show(getFragmentManager(), "message_general_error");
    }

    private void trackFolder(MessageFolder messagefolder)
    {
        if (messagefolder == null)
        {
            messagefolder = getCurrentFolder();
        }
        if (isMasterPaneVisible && messagefolder != null && !messagefolder.equals(lastTrackedFolder))
        {
            if (log.isLoggable || logTracking.isLoggable)
            {
                logTracking.log((new StringBuilder()).append("Tracking folder ").append(messagefolder).toString());
            }
            lastTrackedFolder = messagefolder;
            Object obj = null;
            if (messagefolder.isSentFolder())
            {
                messagefolder = "MsgSent";
            } else
            if (messagefolder.isArchiveFolder())
            {
                messagefolder = "MsgArchive";
            } else
            if (messagefolder.isInbox())
            {
                trackInbox(messagefolder);
                messagefolder = obj;
            } else
            {
                messagefolder = "MsgMyFolder";
            }
            if (messagefolder != null)
            {
                messagefolder = new TrackingData(messagefolder, TrackingType.PAGE_IMPRESSION);
                messagefolder.addSourceIdentification(getIntent());
                messagefolder.send(this);
            }
        }
    }

    private void trackInbox(MessageFolder messagefolder)
    {
        if (isMasterPaneVisible && messagefolder != null && messagefolder.isInbox())
        {
            messagefolder = new TrackingData("MsgInbox", TrackingType.PAGE_IMPRESSION);
            messagefolder.addSourceIdentification(getIntent());
            messagefolder.send(this);
            trackingNoInboxDataSent = true;
            if (getIsMessageListLoaded())
            {
                trackInboxData(getAllMessages());
            }
        }
    }

    private void trackInboxData(List list)
    {
        if (list != null)
        {
            if (log.isLoggable || logTracking.isLoggable)
            {
                logTracking.log("Tracking message count data for Inbox");
            }
            TrackingData trackingdata = new TrackingData("MsgData", TrackingType.EVENT);
            addMessagesCountsArgs(trackingdata, list);
            trackingdata.send(this);
            trackingNoInboxDataSent = false;
        }
    }

    private void trackMessage(EbayMessage ebaymessage)
    {
        TrackingData trackingdata = null;
        if (ebaymessage == null) goto _L2; else goto _L1
_L1:
        if (isDetailPaneVisible && ebaymessage != null && !ebaymessage.equals(lastTrackedMessage))
        {
            if (log.isLoggable || logTracking.isLoggable)
            {
                logTracking.log((new StringBuilder()).append("Tracking message ").append(ebaymessage).toString());
            }
            trackingdata = new TrackingData("ViewMessage", TrackingType.PAGE_IMPRESSION);
            addMessagesCountsArgs(trackingdata, MessagesUtils.makeList(ebaymessage));
            Intent intent = getIntent();
            NotificationTrackingUtil.addNotificationTracking(this, trackingdata, intent, intent.getStringExtra("event_type"));
            intent.removeExtra("noti_type_id");
            trackingdata.send(this);
            lastTrackedMessage = ebaymessage;
        }
        return;
_L2:
        ebaymessage = trackingdata;
        if (detailFragment != null)
        {
            ebaymessage = detailFragment.getCurrentMessage();
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void clearDraft()
    {
        initComposeFragment();
        if (composeFragment != null)
        {
            composeFragment.clearDraft();
            getCurrentFocus().clearFocus();
        }
    }

    void doBack()
    {
        if (isDetailPaneVisible && !isMasterPaneVisible && !noMasterOnBack)
        {
            setPaneVisibility(true, false, true);
            invalidateOptionsMenu();
            lastTrackedFolder = null;
            lastTrackedMessage = null;
            trackFolder(null);
            return;
        } else
        {
            finish();
            return;
        }
    }

    void doDelete()
    {
        masterFragment.deleteMessage(getCurrentMessage());
    }

    void doMove()
    {
        Object obj = masterFragment.getCurrentFolder();
        if (obj != null)
        {
            obj = MoveMessagesDialog.createInstance(getAllFolders(), ((MessageFolder) (obj)), 1);
            ((MoveMessagesDialog) (obj)).show(getFragmentManager(), obj.getClass().getName());
        }
    }

    void doRefresh()
    {
        masterFragment.refreshData();
    }

    public List getAllFolders()
    {
        return masterFragment.getAllFolders();
    }

    public List getAllMessages()
    {
        return masterFragment.getAllMessages();
    }

    public MessageFolder getCurrentFolder()
    {
        return masterFragment.getCurrentFolder();
    }

    public EbayMessage getCurrentMessage()
    {
        return masterFragment.getCurrentMessage();
    }

    public MessagesFilterType getFilterType()
    {
        return masterFragment.getFilterType();
    }

    public List getFilteredMessages()
    {
        return masterFragment.getFilteredMessages();
    }

    public ImageCache getImageCache()
    {
        return imageCache;
    }

    public int getTabHeadersHeight()
    {
        return masterFragment.getTabHeadersHeight();
    }

    public String getTrackingEventName()
    {
        return "ViewMessage";
    }

    public boolean isDetailPaneVisible()
    {
        return isDetailPaneVisible;
    }

    public boolean isDraftInProgress()
    {
        initComposeFragment();
        if (composeFragment == null)
        {
            return false;
        } else
        {
            return composeFragment.isDraftInProgress();
        }
    }

    public boolean isDualPane()
    {
        return isDualPane;
    }

    public boolean isMasterPaneVisible()
    {
        return isMasterPaneVisible;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 65 && j == 0)
        {
            finish();
            return;
        } else
        {
            super.onActivityResult(i, j, intent);
            return;
        }
    }

    public void onBackPressed()
    {
        if (isDetailPaneVisible && detailFragment.goBackInMessageWebViewHistory())
        {
            return;
        }
        if (isDraftInProgress())
        {
            showDialog(1);
            return;
        }
        if (isMultiSelectionInProgress() && isMasterPaneVisible)
        {
            clearMultiSelection();
            return;
        } else
        {
            doBack();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag3 = true;
        boolean flag2 = true;
        super.onCreate(bundle);
        setContentView(0x7f030156);
        processIntentArguments(getIntent());
        if (bundle != null)
        {
            activePane = (com.ebay.mobile.myebay.MessagesBaseFragment.ActivePane)bundle.getSerializable("instanceStateActivePane");
            if (com.ebay.mobile.myebay.MessagesBaseFragment.ActivePane.MESSAGES_DETAIL.equals(activePane))
            {
                inputMessageId = bundle.getString("instanceStateCurrentMsg", inputMessageId);
            }
            isErrorDialogShowing = bundle.getBoolean("errorDialogShowing");
            isMsgIdErrorDialogShowing = bundle.getBoolean("msgIdErrorDialogShowing");
            noMasterOnBack = bundle.getBoolean("instanceStateNoMasterOnBack");
        }
        boolean flag4 = getResources().getBoolean(0x7f0b0005);
        if (inputMessageId != null)
        {
            flag3 = "notification.multiple.messages".equals(inputMessageId);
            boolean flag;
            if (flag4 || flag3)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isMasterPaneVisible = flag;
            flag = flag2;
            if (!flag4)
            {
                if (!flag3)
                {
                    flag = flag2;
                } else
                {
                    flag = false;
                }
            }
            isDetailPaneVisible = flag;
        } else
        {
            boolean flag1;
            if (flag4 || activePane == com.ebay.mobile.myebay.MessagesBaseFragment.ActivePane.MESSAGES_MASTER)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            isMasterPaneVisible = flag1;
            flag1 = flag3;
            if (!flag4)
            {
                if (activePane == com.ebay.mobile.myebay.MessagesBaseFragment.ActivePane.MESSAGES_DETAIL)
                {
                    flag1 = flag3;
                } else
                {
                    flag1 = false;
                }
            }
            isDetailPaneVisible = flag1;
            if (!flag4 && isMasterPaneVisible && isDetailPaneVisible)
            {
                isDetailPaneVisible = false;
            }
        }
        animationScreenIn = AnimationUtils.loadAnimation(this, 0x10a0000);
        animationScreenOut = AnimationUtils.loadAnimation(this, 0x10a0001);
        masterFragment = (MessagesMasterFragment)getFragmentManager().findFragmentByTag("messages.master");
        if (masterFragment == null)
        {
            masterFragment = new MessagesMasterFragment();
            if (inputMessageId != null)
            {
                bundle = new Bundle();
                bundle.putString("message_id", inputMessageId);
                masterFragment.setArguments(bundle);
            }
            getFragmentManager().beginTransaction().add(0x7f10036f, masterFragment, "messages.master").commit();
        } else
        if (inputMessageId != null)
        {
            masterFragment.setInputMessageId(inputMessageId);
        }
        detailFragment = (MessagesDetailFragment)getFragmentManager().findFragmentByTag("messages.details");
        if (detailFragment == null)
        {
            detailFragment = MessagesDetailFragment.createFragment(new SourceIdentification(getTrackingEventName()), inputMessageId);
            getFragmentManager().beginTransaction().add(0x7f100370, detailFragment, "messages.details").commit();
        } else
        if (inputMessageId != null)
        {
            detailFragment.setInputMessageId(inputMessageId);
        }
        inputMessageId = null;
        setPaneVisibility(isMasterPaneVisible, isDetailPaneVisible, false);
        if (isErrorDialogShowing)
        {
            showErrorDialog();
        } else
        if (isMsgIdErrorDialogShowing)
        {
            showMessageIdErrorDialog();
        }
        imageCache = new ImageCache(this, null, Integer.valueOf(0x7f020241));
        if (!MyApp.getPrefs().isSignedIn())
        {
            startActivityForResult(SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this), 65);
        }
    }

    protected Dialog onCreateDialog(int i)
    {
        if (i == 0x7f1009e9)
        {
            return ComposeMessageFragment.getConfirmAbandonMessageDialog(this, new android.content.DialogInterface.OnClickListener() {

                final MessagesActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    clearDraft();
                    doMove();
                }

            
            {
                this$0 = MessagesActivity.this;
                super();
            }
            }, null);
        }
        if (i == 0x7f1009e8)
        {
            return ComposeMessageFragment.getConfirmAbandonMessageDialog(this, new android.content.DialogInterface.OnClickListener() {

                final MessagesActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    clearDraft();
                    doDelete();
                }

            
            {
                this$0 = MessagesActivity.this;
                super();
            }
            }, null);
        }
        if (i == 1)
        {
            return ComposeMessageFragment.getConfirmAbandonMessageDialog(this, new android.content.DialogInterface.OnClickListener() {

                final MessagesActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    clearDraft();
                    doBack();
                }

            
            {
                this$0 = MessagesActivity.this;
                super();
            }
            }, null);
        } else
        {
            return super.onCreateDialog(i);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(0x7f110002, menu);
        return true;
    }

    protected void onDestroy()
    {
        imageCache.clearImageFetching();
        errorDialog = null;
        super.onDestroy();
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        i;
        JVM INSTR tableswitch 2 3: default 24
    //                   2 25
    //                   3 45;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        isErrorDialogShowing = false;
        errorDialog = null;
        if (j == 1)
        {
            doRefresh();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        isMsgIdErrorDialogShowing = false;
        if (j == 1 || j == 3)
        {
            doRefresh();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onMoveMessagesFolderSelected(MoveMessagesDialog movemessagesdialog, MessageFolder messagefolder, MessageFolder messagefolder1)
    {
        masterFragment.moveMessage(getCurrentMessage(), messagefolder1);
    }

    protected void onNewIntent(Intent intent)
    {
label0:
        {
label1:
            {
                boolean flag1 = false;
                super.onNewIntent(intent);
                setIntent(intent);
                processIntentArguments(intent);
                if (inputMessageId == null)
                {
                    break label0;
                }
                boolean flag3 = getResources().getBoolean(0x7f0b0005);
                boolean flag2 = "notification.multiple.messages".equals(inputMessageId);
                boolean flag;
                if (flag3 || flag2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                isMasterPaneVisible = flag;
                if (!flag3)
                {
                    flag = flag1;
                    if (flag2)
                    {
                        break label1;
                    }
                }
                flag = true;
            }
            isDetailPaneVisible = flag;
            masterFragment.setInputMessageId(inputMessageId);
            detailFragment.setInputMessageId(inputMessageId);
            inputMessageId = null;
            setPaneVisibility(isMasterPaneVisible, isDetailPaneVisible, true);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131757544: 
            handleDeleteSelected();
            return true;

        case 2131757545: 
            handleMoveSelected();
            return true;

        case 2131757546: 
            masterFragment.flagMessage(getCurrentMessage());
            break;
        }
        invalidateOptionsMenu();
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        ContentSyncManager.unregister(this, syncTags);
        lastTrackedFolder = null;
        lastTrackedMessage = null;
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        boolean flag2 = false;
        super.onPrepareOptionsMenu(menu);
        MenuHandler.prepare(this, menu);
        Object obj;
        boolean flag;
        boolean flag1;
        if (isDetailPaneVisible() && !isMasterPaneVisible())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = menu.findItem(0x7f1009e6);
        if (!flag && isShoppingCartEnabled)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ((MenuItem) (obj)).setVisible(flag1);
        obj = menu.findItem(0x7f1009ea).setVisible(flag);
        if (flag)
        {
            EbayMessage ebaymessage = getCurrentMessage();
            int i;
            int j;
            if (ebaymessage != null && ebaymessage.isFlagged())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                j = 0x7f0201d7;
            } else
            {
                j = 0x7f0201d6;
            }
            obj = ((MenuItem) (obj)).setIcon(j);
            if (i != 0)
            {
                i = 0x7f070630;
            } else
            {
                i = 0x7f07062d;
            }
            ((MenuItem) (obj)).setTitle(i);
        }
        menu.findItem(0x7f1009e8).setVisible(flag);
        obj = getCurrentFolder();
        menu = menu.findItem(0x7f1009e9);
        flag1 = flag2;
        if (flag)
        {
            flag1 = flag2;
            if (obj != null)
            {
                flag1 = flag2;
                if (!((MessageFolder) (obj)).isSentFolder())
                {
                    flag1 = true;
                }
            }
        }
        menu.setVisible(flag1);
        return true;
    }

    public void onResume()
    {
        super.onResume();
        ContentSyncManager.register(this, syncTags);
        isShoppingCartEnabled = MyApp.getDeviceConfiguration().isShoppingCartEnabled();
        trackMessage(null);
        trackFolder(null);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("instanceStateActivePane", activePane);
        if (com.ebay.mobile.myebay.MessagesBaseFragment.ActivePane.MESSAGES_DETAIL.equals(activePane))
        {
            EbayMessage ebaymessage = getCurrentMessage();
            if (ebaymessage != null)
            {
                bundle.putString("instanceStateCurrentMsg", ebaymessage.messageId);
            }
        }
        bundle.putBoolean("errorDialogShowing", isErrorDialogShowing);
        bundle.putBoolean("msgIdErrorDialogShowing", isMsgIdErrorDialogShowing);
        bundle.putBoolean("instanceStateNoMasterOnBack", noMasterOnBack);
    }

    public void startDraft()
    {
        initComposeFragment();
        composeFragment.startDraft();
    }

    public void updateContent(String s, Object obj)
    {
        boolean flag2;
        if (!MessagesBaseFragment.SYNC_CURRENT_MESSAGE_CHANGED.equals(s))
        {
            break MISSING_BLOCK_LABEL_104;
        }
        s = MessagesBaseFragment.getSyncContent(obj);
        obj = (EbayMessage)(EbayMessage)s.get(0);
        flag2 = ((Boolean)(Boolean)s.get(1)).booleanValue();
        if (!isDetailPaneVisible || isMasterPaneVisible) goto _L2; else goto _L1
_L1:
        invalidateOptionsMenu();
_L4:
        trackMessage(((EbayMessage) (obj)));
        return;
_L2:
        if (isDetailPaneVisible || !isMasterPaneVisible || !flag2) goto _L4; else goto _L3
_L3:
        boolean flag;
        boolean flag1;
        try
        {
            setPaneVisibility(false, true, true);
            invalidateOptionsMenu();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
          goto _L4
        if (MessagesBaseFragment.SYNC_MESSAGES_MOVED.equals(s) || MessagesBaseFragment.SYNC_MESSAGES_REMOVED.equals(s))
        {
            if (isDetailPaneVisible && !isMasterPaneVisible)
            {
                setPaneVisibility(true, false, true);
                invalidateOptionsMenu();
                return;
            }
            break MISSING_BLOCK_LABEL_526;
        }
        if (MessagesBaseFragment.SYNC_MESSAGE_SENT.equals(s))
        {
            clearDraft();
            if (isDetailPaneVisible() && !isMasterPaneVisible())
            {
                setPaneVisibility(true, false, true);
                invalidateOptionsMenu();
            }
            Toast.makeText(this, getString(0x7f070617), 1).show();
            return;
        }
        if (!MessagesBaseFragment.SYNC_API_ERROR.equals(s))
        {
            break MISSING_BLOCK_LABEL_429;
        }
        s = (ResultStatus)MessagesBaseFragment.getSyncContent(obj).get(0);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_405;
        }
        flag1 = false;
        s = s.getMessages().iterator();
_L6:
        flag = flag1;
        if (!s.hasNext())
        {
            break MISSING_BLOCK_LABEL_286;
        }
        obj = (com.ebay.nautilus.kernel.content.ResultStatus.Message)s.next();
        if (obj == null) goto _L6; else goto _L5
_L5:
        if (((com.ebay.nautilus.kernel.content.ResultStatus.Message) (obj)).getId() != 20118) goto _L6; else goto _L7
_L7:
        flag = true;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_314;
        }
        if (errorDialog != null)
        {
            errorDialog.dismiss();
            errorDialog = null;
            isErrorDialogShowing = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_405;
        }
        if (!isMsgIdErrorDialogShowing)
        {
            inputMessageId = null;
            masterFragment.setInputMessageId(inputMessageId);
            detailFragment.setInputMessageId(inputMessageId);
            isMsgIdErrorDialogShowing = true;
            showMessageIdErrorDialog();
            if (!isDualPane && isDetailPaneVisible)
            {
                isMasterPaneVisible = true;
                isDetailPaneVisible = isDualPane;
                setPaneVisibility(isMasterPaneVisible, isDetailPaneVisible, true);
                invalidateOptionsMenu();
            }
        }
        if (!isErrorDialogShowing && !isMsgIdErrorDialogShowing)
        {
            isErrorDialogShowing = true;
            showErrorDialog();
            return;
        }
        break MISSING_BLOCK_LABEL_526;
        if (MessagesBaseFragment.SYNC_PANE_ACTIVATED.equals(s))
        {
            activePane = (com.ebay.mobile.myebay.MessagesBaseFragment.ActivePane)MessagesBaseFragment.getSyncContent(obj).get(0);
            return;
        }
        if (MessagesBaseFragment.SYNC_CURRENT_FOLDER_CHANGED.equals(s))
        {
            trackFolder((MessageFolder)MessagesBaseFragment.getSyncContent(obj).get(0));
            return;
        }
        if (!MessagesBaseFragment.SYNC_ALL_MESSAGES_CHANGED.equals(s) || !trackingNoInboxDataSent)
        {
            break MISSING_BLOCK_LABEL_526;
        }
        s = getCurrentFolder();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_526;
        }
        if (s.isInbox())
        {
            trackInboxData(getAllMessages());
        }
    }

}
