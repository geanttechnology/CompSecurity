// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.app.Activity;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.data.MessageFolder;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessagesSync, MessagesFilterType

public class MessagesBaseFragment extends BaseFragment
    implements MessagesSync, com.ebay.mobile.util.ContentSyncManager.ContentSync
{
    public static final class ActivePane extends Enum
    {

        private static final ActivePane $VALUES[];
        public static final ActivePane MESSAGES_DETAIL;
        public static final ActivePane MESSAGES_MASTER;

        public static ActivePane valueOf(String s)
        {
            return (ActivePane)Enum.valueOf(com/ebay/mobile/myebay/MessagesBaseFragment$ActivePane, s);
        }

        public static ActivePane[] values()
        {
            return (ActivePane[])$VALUES.clone();
        }

        static 
        {
            MESSAGES_MASTER = new ActivePane("MESSAGES_MASTER", 0);
            MESSAGES_DETAIL = new ActivePane("MESSAGES_DETAIL", 1);
            $VALUES = (new ActivePane[] {
                MESSAGES_MASTER, MESSAGES_DETAIL
            });
        }

        private ActivePane(String s, int i)
        {
            super(s, i);
        }
    }

    private static class SyncObject
    {

        public ArrayList args;
        public MessagesBaseFragment sendingFragment;

        public transient SyncObject(MessagesBaseFragment messagesbasefragment, Object aobj[])
        {
            args = new ArrayList();
            sendingFragment = messagesbasefragment;
            if (aobj != null)
            {
                int j = aobj.length;
                for (int i = 0; i < j; i++)
                {
                    messagesbasefragment = ((MessagesBaseFragment) (aobj[i]));
                    args.add(messagesbasefragment);
                }

            }
        }
    }


    public static String SYNC_ALL_FOLDERS_CHANGED = "MessagesState.AllFoldersChanged";
    public static String SYNC_ALL_MESSAGES_CHANGED = "MessagesState.AllMessagesChanged";
    public static String SYNC_API_ERROR = "MessageState.ApiError";
    public static String SYNC_CURRENT_FOLDER_CHANGED = "MessagesState.CurrentFolderChanged";
    public static String SYNC_CURRENT_MESSAGE_CHANGED = "MessagesState.CurrentMessageChanged";
    public static String SYNC_FILTER_TYPE_CHANGED = "MessagesState.FilterTypeChanged";
    public static String SYNC_MESSAGES_MOVED = "MessagesState.MessagesMoved";
    public static String SYNC_MESSAGES_REMOVED = "MessagesState.MessagesRemoved";
    public static String SYNC_MESSAGES_UPDATED = "MessagesState.MessagesUpdated";
    public static String SYNC_MESSAGE_SENT = "MessageState.MessageSent";
    public static String SYNC_PANE_ACTIVATED = "MessageState.PaneActivated";
    public static String SYNC_REFRESH = "MessageState.Refresh";
    public static String SYNC_SHOW_TAB_HEADERS_CHANGED = "TabHost.ShowTabHeadersChanged";
    public static String SYNC_TAB_HEADERS_HEIGHT_CHANGED = "TabHost.TabHeadersHeightChanged";
    protected static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("Messages", 3, "User Messages sent between eBay members and to/from eBay.");
    protected static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTracking = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("Messages.Tracking", 3, "User Messages sent between eBay members and to/from eBay.");
    protected static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logUi = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("Messages.Ui", 3, "User Messages sent between eBay members and to/from eBay.");
    protected static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logUiDm = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("Messages.Ui.Dm", 3, "User Messages sent between eBay members and to/from eBay.");
    private MessagesSync messagesSync;

    public MessagesBaseFragment()
    {
    }

    protected static String contentToString(Content content)
    {
        Object obj1 = null;
        StringBuilder stringbuilder = (new StringBuilder()).append("status[");
        Object obj;
        if (content == null)
        {
            obj = null;
        } else
        {
            obj = content.getStatus();
        }
        obj = stringbuilder.append(obj).append("], data[");
        if (content == null)
        {
            content = obj1;
        } else
        {
            content = ((Content) (content.getData()));
        }
        return ((StringBuilder) (obj)).append(content).append("]").toString();
    }

    public static List getSyncContent(Object obj)
    {
        ArrayList arraylist = new ArrayList();
        if (obj instanceof SyncObject)
        {
            arraylist = ((SyncObject)obj).args;
        }
        return arraylist;
    }

    private MessagesSync setMessagesSync()
    {
        Object obj = getTargetFragment();
        if (obj instanceof MessagesSync)
        {
            messagesSync = (MessagesSync)obj;
            return messagesSync;
        }
        obj = getActivity();
        if (obj instanceof MessagesSync)
        {
            messagesSync = (MessagesSync)obj;
        }
        return messagesSync;
    }

    public void clearDraft()
    {
        if (messagesSync != null)
        {
            messagesSync.clearDraft();
        }
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

    public List getAllFolders()
    {
        if (messagesSync != null)
        {
            return messagesSync.getAllFolders();
        } else
        {
            return new ArrayList();
        }
    }

    public List getAllMessages()
    {
        if (messagesSync != null)
        {
            return messagesSync.getAllMessages();
        } else
        {
            return new ArrayList();
        }
    }

    public MessageFolder getCurrentFolder()
    {
        if (messagesSync != null)
        {
            return messagesSync.getCurrentFolder();
        } else
        {
            return null;
        }
    }

    public EbayMessage getCurrentMessage()
    {
        if (messagesSync != null)
        {
            return messagesSync.getCurrentMessage();
        } else
        {
            return null;
        }
    }

    public MessagesFilterType getFilterType()
    {
        if (messagesSync != null)
        {
            return messagesSync.getFilterType();
        } else
        {
            return MessagesFilterType.FILTER_ALL;
        }
    }

    public List getFilteredMessages()
    {
        if (messagesSync != null)
        {
            return messagesSync.getFilteredMessages();
        } else
        {
            return new ArrayList();
        }
    }

    public ImageCache getImageCache()
    {
        if (messagesSync != null)
        {
            return messagesSync.getImageCache();
        } else
        {
            return null;
        }
    }

    protected MessagesSync getMessagesSync()
    {
        return messagesSync;
    }

    protected String[] getSyncKeys()
    {
        return null;
    }

    public int getTabHeadersHeight()
    {
        if (messagesSync != null)
        {
            return messagesSync.getTabHeadersHeight();
        } else
        {
            return 0;
        }
    }

    public boolean isDetailPaneVisible()
    {
        if (messagesSync != null)
        {
            return messagesSync.isDetailPaneVisible();
        } else
        {
            return false;
        }
    }

    public boolean isDraftInProgress()
    {
        if (messagesSync != null)
        {
            return messagesSync.isDraftInProgress();
        } else
        {
            return false;
        }
    }

    public boolean isDualPane()
    {
        if (messagesSync != null)
        {
            return messagesSync.isDualPane();
        } else
        {
            return false;
        }
    }

    public boolean isMasterPaneVisible()
    {
        if (messagesSync != null)
        {
            return messagesSync.isMasterPaneVisible();
        } else
        {
            return false;
        }
    }

    protected void notifyAllFoldersChanged(List list)
    {
        ContentSyncManager.notifyUpdate(new SyncObject(this, new Object[] {
            list
        }), SYNC_ALL_FOLDERS_CHANGED);
    }

    protected void notifyAllMessagesChanged(List list)
    {
        ContentSyncManager.notifyUpdate(new SyncObject(this, new Object[] {
            list
        }), SYNC_ALL_MESSAGES_CHANGED);
    }

    protected void notifyApiError(ResultStatus resultstatus)
    {
        ContentSyncManager.notifyUpdate(new SyncObject(this, new Object[] {
            resultstatus
        }), SYNC_API_ERROR);
    }

    protected void notifyCurrentFolderChanged(MessageFolder messagefolder)
    {
        ContentSyncManager.notifyUpdate(new SyncObject(this, new Object[] {
            messagefolder
        }), SYNC_CURRENT_FOLDER_CHANGED);
    }

    protected void notifyCurrentMessageChanged(EbayMessage ebaymessage, boolean flag)
    {
        ContentSyncManager.notifyUpdate(new SyncObject(this, new Object[] {
            ebaymessage, Boolean.valueOf(flag)
        }), SYNC_CURRENT_MESSAGE_CHANGED);
    }

    protected void notifyFilterTypeChanged(MessagesFilterType messagesfiltertype)
    {
        ContentSyncManager.notifyUpdate(new SyncObject(this, new Object[] {
            messagesfiltertype
        }), SYNC_FILTER_TYPE_CHANGED);
    }

    protected void notifyMessageSent()
    {
        ContentSyncManager.notifyUpdate(new SyncObject(this, (Object[])null), SYNC_MESSAGE_SENT);
    }

    protected void notifyMessagesMoved(List list, MessageFolder messagefolder, MessageFolder messagefolder1)
    {
        ContentSyncManager.notifyUpdate(new SyncObject(this, new Object[] {
            list, messagefolder, messagefolder1
        }), SYNC_MESSAGES_MOVED);
    }

    protected void notifyMessagesRemoved(List list, MessageFolder messagefolder)
    {
        ContentSyncManager.notifyUpdate(new SyncObject(this, new Object[] {
            list, messagefolder
        }), SYNC_MESSAGES_REMOVED);
    }

    protected void notifyMessagesUpdated(List list)
    {
        ContentSyncManager.notifyUpdate(new SyncObject(this, new Object[] {
            list
        }), SYNC_MESSAGES_UPDATED);
    }

    protected void notifyPaneActivated(ActivePane activepane)
    {
        ContentSyncManager.notifyUpdate(new SyncObject(this, new Object[] {
            activepane
        }), SYNC_PANE_ACTIVATED);
    }

    protected void notifyRefresh()
    {
        ContentSyncManager.notifyUpdate(new SyncObject(this, (Object[])null), SYNC_REFRESH);
    }

    protected void notifyShowTabHeadersChanged(Boolean boolean1)
    {
        ContentSyncManager.notifyUpdate(new SyncObject(this, new Object[] {
            boolean1
        }), SYNC_SHOW_TAB_HEADERS_CHANGED);
    }

    protected void notifyTabHeadersHeightChanged(Integer integer)
    {
        ContentSyncManager.notifyUpdate(new SyncObject(this, new Object[] {
            integer
        }), SYNC_TAB_HEADERS_HEIGHT_CHANGED);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        setMessagesSync();
        activity = getSyncKeys();
        if (activity != null)
        {
            ContentSyncManager.register(this, activity);
        }
    }

    public void onDetach()
    {
        super.onDetach();
        String as[] = getSyncKeys();
        if (as != null)
        {
            ContentSyncManager.unregister(this, as);
        }
        setMessagesSync();
    }

    protected void onNotifyAllFoldersChanged(List list)
    {
    }

    protected void onNotifyAllMessagesChanged(List list)
    {
    }

    protected void onNotifyApiError(ResultStatus resultstatus)
    {
    }

    protected void onNotifyCurrentFolderChanged(MessageFolder messagefolder)
    {
    }

    protected void onNotifyCurrentMessageChanged(EbayMessage ebaymessage, boolean flag)
    {
    }

    protected void onNotifyFilterTypeChanged(MessagesFilterType messagesfiltertype)
    {
    }

    protected void onNotifyMessageSent()
    {
    }

    protected void onNotifyMessagesMoved(List list, MessageFolder messagefolder, MessageFolder messagefolder1)
    {
    }

    protected void onNotifyMessagesRemoved(List list, MessageFolder messagefolder)
    {
    }

    protected void onNotifyMessagesUpdated(List list)
    {
    }

    protected void onNotifyPaneActivated(ActivePane activepane)
    {
    }

    protected void onNotifyRefresh()
    {
    }

    protected void onNotifyShowTabHeadersChanged(boolean flag)
    {
    }

    protected void onNotifyTabHeadersHeightChanged(int i)
    {
    }

    public void startDraft()
    {
        if (messagesSync != null)
        {
            messagesSync.startDraft();
        }
    }

    public void updateContent(String s, Object obj)
    {
        obj = (SyncObject)obj;
        if (((SyncObject) (obj)).sendingFragment.getClass().equals(getClass()))
        {
            break MISSING_BLOCK_LABEL_440;
        }
        if (SYNC_ALL_FOLDERS_CHANGED.equals(s))
        {
            onNotifyAllFoldersChanged((List)((SyncObject) (obj)).args.get(0));
            return;
        }
        try
        {
            if (SYNC_ALL_MESSAGES_CHANGED.equals(s))
            {
                onNotifyAllMessagesChanged((List)((SyncObject) (obj)).args.get(0));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.logAsWarning("Problem with received ContentSync data.", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.logAsWarning("Problem with received ContentSync data.", s);
            return;
        }
        if (SYNC_CURRENT_FOLDER_CHANGED.equals(s))
        {
            onNotifyCurrentFolderChanged((MessageFolder)((SyncObject) (obj)).args.get(0));
            return;
        }
        if (SYNC_CURRENT_MESSAGE_CHANGED.equals(s))
        {
            onNotifyCurrentMessageChanged((EbayMessage)((SyncObject) (obj)).args.get(0), ((Boolean)((SyncObject) (obj)).args.get(1)).booleanValue());
            return;
        }
        if (SYNC_FILTER_TYPE_CHANGED.equals(s))
        {
            onNotifyFilterTypeChanged((MessagesFilterType)((SyncObject) (obj)).args.get(0));
            return;
        }
        if (SYNC_REFRESH.equals(s))
        {
            onNotifyRefresh();
            return;
        }
        if (SYNC_MESSAGES_MOVED.equals(s))
        {
            onNotifyMessagesMoved((List)((SyncObject) (obj)).args.get(0), (MessageFolder)((SyncObject) (obj)).args.get(1), (MessageFolder)((SyncObject) (obj)).args.get(2));
            return;
        }
        if (SYNC_MESSAGES_REMOVED.equals(s))
        {
            onNotifyMessagesRemoved((List)((SyncObject) (obj)).args.get(0), (MessageFolder)((SyncObject) (obj)).args.get(1));
            return;
        }
        if (SYNC_MESSAGES_UPDATED.equals(s))
        {
            onNotifyMessagesUpdated((List)((SyncObject) (obj)).args.get(0));
            return;
        }
        if (SYNC_MESSAGE_SENT.equals(s))
        {
            onNotifyMessageSent();
            return;
        }
        if (SYNC_TAB_HEADERS_HEIGHT_CHANGED.equals(s))
        {
            onNotifyTabHeadersHeightChanged(((Integer)((SyncObject) (obj)).args.get(0)).intValue());
            return;
        }
        if (SYNC_SHOW_TAB_HEADERS_CHANGED.equals(s))
        {
            onNotifyShowTabHeadersChanged(((Boolean)((SyncObject) (obj)).args.get(0)).booleanValue());
            return;
        }
        if (SYNC_API_ERROR.equals(s))
        {
            onNotifyApiError((ResultStatus)((SyncObject) (obj)).args.get(0));
            return;
        }
        if (SYNC_PANE_ACTIVATED.equals(s))
        {
            onNotifyPaneActivated((ActivePane)((SyncObject) (obj)).args.get(0));
        }
    }

}
