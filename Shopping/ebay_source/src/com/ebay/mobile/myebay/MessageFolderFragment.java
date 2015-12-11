// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.format.DateUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.MessagesActivity;
import com.ebay.mobile.activities.MoveMessagesDialog;
import com.ebay.mobile.activities.UndoMessagesActionToastDialog;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.widget.UserThumbnail;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.dm.MessageFolderContentsDataManager;
import com.ebay.nautilus.domain.content.dm.MessagesUtils;
import com.ebay.nautilus.domain.content.dm.UserAvatarUrlDataManager;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.data.MessageFolder;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwActivity;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessagesBaseFragment, ComposeMessageFragment, MessagesFilterType

public class MessageFolderFragment extends MessagesBaseFragment
    implements android.view.View.OnClickListener, android.view.View.OnLongClickListener, android.widget.AbsListView.OnScrollListener, android.widget.AdapterView.OnItemClickListener, android.widget.Filter.FilterListener, DialogFragmentCallback, com.ebay.mobile.activities.MoveMessagesDialog.OnMoveMessagesDialogListener, com.ebay.mobile.activities.UndoMessagesActionToastDialog.OnUndoMessagesActionDialogListener, com.ebay.nautilus.domain.content.dm.MessageFolderContentsDataManager.Observer, com.ebay.nautilus.domain.content.dm.UserAvatarUrlDataManager.Observer
{
    private static class MessageDateComparator
        implements Comparator
    {

        public int compare(EbayMessage ebaymessage, EbayMessage ebaymessage1)
        {
            return ebaymessage.receiveDate.compareTo(ebaymessage1.receiveDate) * -1;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((EbayMessage)obj, (EbayMessage)obj1);
        }

        private MessageDateComparator()
        {
        }

    }

    final class MessageFolderListAdapter extends ArrayAdapter
        implements android.view.View.OnClickListener, Filterable
    {

        private static final int HEADER_VIEW_ITEM_TYPE = 0;
        private static final int MESSAGE_SELECTED_VIEW_ITEM_TYPE = 2;
        private static final int MESSAGE_UNSELECTED_VIEW_ITEM_TYPE = 1;
        private static final int TOTAL_VIEW_COUNT = 3;
        private ArrayList checkedMessages;
        private final MessageFolderFilter filter = new MessageFolderFilter();
        private MessagesFilterType filterType;
        private List filteredItems;
        private final int flaggedResource = 0x7f0201d9;
        private final ImageCache imageCache;
        private final LayoutInflater inflater;
        private final boolean isDualPane;
        private final int listItemBackground;
        final MessageFolderFragment this$0;
        private final DateFormat todayFormatter = DateFormat.getTimeInstance(3);
        private final int unflaggedResource = 0x7f0201d8;
        private final int unflaggedSelResource = 0x7f0201da;
        private final int unreadTextColor;

        private MessageViewHolder getMessageHolderFromView(View view1)
        {
            MessageViewHolder messageviewholder = new MessageViewHolder();
            messageviewholder.priority = view1.findViewById(0x7f100383);
            messageviewholder.sender = (TextView)view1.findViewById(0x7f100385);
            messageviewholder.subject = (TextView)view1.findViewById(0x7f100389);
            messageviewholder.dateTime = (TextView)view1.findViewById(0x7f100384);
            messageviewholder.userImage = (UserThumbnail)view1.findViewById(0x7f100382);
            messageviewholder.selection = (ImageView)view1.findViewById(0x7f100381);
            messageviewholder.replied = (ImageView)view1.findViewById(0x7f100387);
            messageviewholder.flagged = (ImageView)view1.findViewById(0x7f100386);
            messageviewholder.flagClickZone = view1.findViewById(0x7f100388);
            return messageviewholder;
        }

        private void setupMessageRow(MsgListMessage msglistmessage, EbayMessage ebaymessage, MessageViewHolder messageviewholder, boolean flag)
        {
            Object obj = Calendar.getInstance();
            Object obj1 = Calendar.getInstance();
            ((Calendar) (obj1)).setTime(ebaymessage.receiveDate);
            int i;
            if (((Calendar) (obj1)).get(1) == ((Calendar) (obj)).get(1) && ((Calendar) (obj1)).get(6) == ((Calendar) (obj)).get(6))
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                obj = todayFormatter.format(ebaymessage.receiveDate);
            } else
            {
                obj = DateUtils.formatDateTime(getActivity(), ebaymessage.receiveDate.getTime(), 0x10008);
            }
            obj1 = messageviewholder.priority;
            if (ebaymessage.highPriority)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((View) (obj1)).setVisibility(i);
            if (ebaymessage.isUnread())
            {
                i = getResources().getColor(unreadTextColor);
            } else
            {
                i = getResources().getColor(0x7f0d00e3);
            }
            setupText(messageviewholder.sender, getUserFromMessage(ebaymessage), ebaymessage.isUnread(), Integer.valueOf(i));
            if (ebaymessage.isUnread())
            {
                i = getResources().getColor(unreadTextColor);
            } else
            {
                i = getResources().getColor(0x7f0d00e7);
            }
            setupText(messageviewholder.subject, ebaymessage.subject, ebaymessage.isUnread(), Integer.valueOf(i));
            setupText(messageviewholder.dateTime, ((String) (obj)), false, null);
            setupUserImage(messageviewholder.userImage, ebaymessage);
            if (flag)
            {
                if (checkedMessages.contains(msglistmessage.message))
                {
                    i = 0x7f020054;
                } else
                {
                    i = 0x7f020052;
                }
            } else
            if (checkedMessages.contains(msglistmessage.message))
            {
                i = 0x7f020055;
            } else
            {
                i = 0x7f020053;
            }
            messageviewholder.selection.setImageResource(i);
            messageviewholder.selection.setTag(msglistmessage);
            messageviewholder.selection.setOnClickListener(this);
            obj = messageviewholder.replied;
            if (ebaymessage.replied)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((ImageView) (obj)).setVisibility(i);
            setupMsgFlag(messageviewholder.flagged, ebaymessage, flag);
            messageviewholder.flagClickZone.setTag(msglistmessage);
            messageviewholder.flagClickZone.setOnClickListener(this);
        }

        private void setupMsgFlag(ImageView imageview, EbayMessage ebaymessage, boolean flag)
        {
            if (ebaymessage.flagged)
            {
                imageview.setImageResource(flaggedResource);
                return;
            }
            if (flag)
            {
                imageview.setImageResource(unflaggedSelResource);
                return;
            } else
            {
                imageview.setImageResource(unflaggedResource);
                return;
            }
        }

        private void setupText(TextView textview, String s, boolean flag, Integer integer)
        {
            textview.setText(s);
            if (integer != null)
            {
                textview.setTextColor(integer.intValue());
            }
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            textview.setTypeface(null, i);
            textview.setVisibility(0);
        }

        private void setupUserImage(UserThumbnail userthumbnail, EbayMessage ebaymessage)
        {
            ImageCache.forgetView(userthumbnail);
            if (ebaymessage.isEbayMessage())
            {
                userthumbnail.postImageResource(0x7f020242);
            } else
            {
                ebaymessage = getUserFromMessage(ebaymessage);
                if (ebaymessage != null)
                {
                    userthumbnail.setUserId(ebaymessage);
                    return;
                }
            }
        }

        public boolean areAllItemsEnabled()
        {
            return false;
        }

        public void clear()
        {
            if (filteredItems != null)
            {
                filteredItems.clear();
            }
            super.clear();
        }

        public void clearCheckedMessages()
        {
            checkedMessages.clear();
            notifyDataSetChanged();
        }

        public ArrayList getCheckedMessages()
        {
            return checkedMessages;
        }

        public int getCount()
        {
            if (filteredItems == null)
            {
                return 0;
            } else
            {
                return filteredItems.size();
            }
        }

        public Filter getFilter()
        {
            return filter;
        }

        public MsgListItem getItem(int i)
        {
            if (filteredItems == null)
            {
                return null;
            } else
            {
                return (MsgListItem)filteredItems.get(i);
            }
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public int getItemViewType(int i)
        {
            Object obj = getItem(i);
            if (obj instanceof MsgListSeparator)
            {
                return 0;
            }
            if (obj instanceof MsgListMessage)
            {
                obj = ((MsgListMessage)obj).message;
                if (isDualPane && ((EbayMessage) (obj)).messageId.equals(selectedMessageId))
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                return i == 0 ? 1 : 2;
            } else
            {
                return -1;
            }
        }

        public int getPosition(MsgListItem msglistitem)
        {
            if (filteredItems == null)
            {
                return -1;
            } else
            {
                return filteredItems.indexOf(msglistitem);
            }
        }

        public volatile int getPosition(Object obj)
        {
            return getPosition((MsgListItem)obj);
        }

        public String getUserFromMessage(EbayMessage ebaymessage)
        {
            if (folder == null)
            {
                return null;
            }
            if (folder.isSentFolder())
            {
                return ebaymessage.sendToName;
            } else
            {
                return ebaymessage.sender;
            }
        }

        public View getView(int i, View view1, ViewGroup viewgroup)
        {
            Object obj = getItem(i);
            i = getItemViewType(i);
            if (i == 0)
            {
                if (view1 == null)
                {
                    view1 = inflater.inflate(0x7f03015e, viewgroup, false);
                    viewgroup = new DateViewHolder();
                    viewgroup.text = (TextView)view1.findViewById(0x7f10038a);
                    view1.setTag(viewgroup);
                } else
                {
                    viewgroup = (DateViewHolder)view1.getTag();
                }
                obj = (MsgListSeparator)obj;
                ((DateViewHolder) (viewgroup)).text.setText(((MsgListSeparator) (obj)).date);
                return view1;
            }
            if (i == 1)
            {
                obj = (MsgListMessage)obj;
                EbayMessage ebaymessage = ((MsgListMessage) (obj)).message;
                if (view1 == null)
                {
                    view1 = inflater.inflate(0x7f03015c, viewgroup, false);
                    viewgroup = getMessageHolderFromView(view1);
                    view1.setTag(viewgroup);
                } else
                {
                    viewgroup = (MessageViewHolder)view1.getTag();
                }
                if (checkedMessages.contains(ebaymessage))
                {
                    view1.setBackgroundResource(0x7f0d0016);
                } else
                {
                    view1.setBackgroundResource(listItemBackground);
                }
                setupMessageRow(((MsgListMessage) (obj)), ebaymessage, viewgroup, false);
                return view1;
            }
            if (i == 2)
            {
                obj = (MsgListMessage)obj;
                EbayMessage ebaymessage1 = ((MsgListMessage) (obj)).message;
                if (view1 == null)
                {
                    view1 = inflater.inflate(0x7f03015d, viewgroup, false);
                    viewgroup = getMessageHolderFromView(view1);
                    view1.setTag(viewgroup);
                } else
                {
                    viewgroup = (MessageViewHolder)view1.getTag();
                }
                setupMessageRow(((MsgListMessage) (obj)), ebaymessage1, viewgroup, true);
                return view1;
            } else
            {
                return null;
            }
        }

        public int getViewTypeCount()
        {
            return 3;
        }

        public boolean isEnabled(int i)
        {
            return getItemViewType(i) != 0;
        }

        public boolean isFiltering()
        {
            return filter.filtering;
        }

        public void onClick(View view1)
        {
            Object obj;
            notifyPaneActivated(MessagesBaseFragment.ActivePane.MESSAGES_MASTER);
            obj = view1.getTag();
            view1.getId();
            JVM INSTR lookupswitch 2: default 44
        //                       2131755905: 45
        //                       2131755912: 121;
               goto _L1 _L2 _L3
_L1:
            return;
_L2:
            if ((view1 instanceof ImageView) && (obj instanceof MsgListMessage) && (view1 = (MsgListMessage)obj) != null)
            {
                if (checkedMessages.contains(((MsgListMessage) (view1)).message))
                {
                    checkedMessages.remove(((MsgListMessage) (view1)).message);
                } else
                {
                    checkedMessages.add(((MsgListMessage) (view1)).message);
                }
                processChangeInCheckedMessages();
                notifyDataSetChanged();
                return;
            }
            continue; /* Loop/switch isn't completed */
_L3:
            if (obj instanceof MsgListMessage)
            {
                view1 = ((MsgListMessage)obj).message;
                flagMessage(view1, "MsgEdit");
                return;
            }
            if (true) goto _L1; else goto _L4
_L4:
        }

        public void refilter()
        {
            filter.filter("", MessageFolderFragment.this);
        }

        public void setFilterType(MessagesFilterType messagesfiltertype)
        {
            filterType = messagesfiltertype;
            refilter();
        }



/*
        static List access$802(MessageFolderListAdapter messagefolderlistadapter, List list)
        {
            messagefolderlistadapter.filteredItems = list;
            return list;
        }

*/

        public MessageFolderListAdapter(Activity activity1, List list, ArrayList arraylist)
        {
            this$0 = MessageFolderFragment.this;
            super(activity1, 0x7f03015c, list);
            filterType = MessagesFilterType.FILTER_ALL;
            inflater = activity1.getLayoutInflater();
            imageCache = new ImageCache(activity1, null, Integer.valueOf(0x7f020241));
            activity1 = activity1.getTheme().obtainStyledAttributes(new int[] {
                0x7f010060, 0x1010036
            });
            listItemBackground = activity1.getResourceId(0, 0);
            unreadTextColor = activity1.getResourceId(1, 0);
            activity1.recycle();
            isDualPane = getResources().getBoolean(0x7f0b0005);
            if (arraylist != null)
            {
                checkedMessages = arraylist;
            } else
            {
                checkedMessages = new ArrayList();
            }
            refilter();
        }
    }

    private final class MessageFolderListAdapter.DateViewHolder
    {

        TextView text;
        final MessageFolderListAdapter this$1;

        private MessageFolderListAdapter.DateViewHolder()
        {
            this$1 = MessageFolderListAdapter.this;
            super();
        }

    }

    private class MessageFolderListAdapter.MessageFolderFilter extends Filter
    {

        boolean filtering;
        final MessageFolderListAdapter this$1;

        protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
        {
            filtering = true;
            ArrayList arraylist = new ArrayList();
            charsequence = null;
            Iterator iterator = allListItems.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                MsgListItem msglistitem = (MsgListItem)iterator.next();
                if (msglistitem instanceof MsgListSeparator)
                {
                    charsequence = (MsgListSeparator)msglistitem;
                } else
                if (msglistitem instanceof MsgListMessage)
                {
                    EbayMessage ebaymessage = ((MsgListMessage)msglistitem).message;
                    if (MessagesFilterType.doesMessageMatchFilter(filterType, ebaymessage))
                    {
                        CharSequence charsequence1 = charsequence;
                        if (charsequence != null)
                        {
                            arraylist.add(charsequence);
                            charsequence1 = null;
                        }
                        arraylist.add(msglistitem);
                        charsequence = charsequence1;
                    }
                }
            } while (true);
            charsequence = new android.widget.Filter.FilterResults();
            charsequence.count = arraylist.size();
            charsequence.values = arraylist;
            return charsequence;
        }

        protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
        {
            filtering = false;
            filteredItems = (List)filterresults.values;
            notifyDataSetChanged();
        }

        private MessageFolderListAdapter.MessageFolderFilter()
        {
            this$1 = MessageFolderListAdapter.this;
            super();
            filtering = false;
        }

    }

    private final class MessageFolderListAdapter.MessageViewHolder
    {

        TextView dateTime;
        View flagClickZone;
        ImageView flagged;
        View priority;
        ImageView replied;
        ImageView selection;
        TextView sender;
        TextView subject;
        final MessageFolderListAdapter this$1;
        UserThumbnail userImage;

        private MessageFolderListAdapter.MessageViewHolder()
        {
            this$1 = MessageFolderListAdapter.this;
            super();
        }

    }

    static class MsgListItem
    {

        MsgListItem()
        {
        }
    }

    static final class MsgListMessage extends MsgListItem
    {

        public EbayMessage message;

        public MsgListMessage(EbayMessage ebaymessage)
        {
            message = ebaymessage;
        }
    }

    static final class MsgListSeparator extends MsgListItem
    {

        public String date;

        public MsgListSeparator(String s)
        {
            date = s;
        }
    }


    public static final int MSGACT_DELETE = 2;
    public static final int MSGACT_FLAG = 0;
    public static final int MSGACT_MARK_READ = 6;
    public static final int MSGACT_MARK_UNREAD = 7;
    public static final int MSGACT_MOVE_ARCHIVE = 5;
    public static final int MSGACT_MOVE_FOLDER = 4;
    public static final int MSGACT_REPLY = 3;
    public static final int MSGACT_UNFLAG = 1;
    private static final int RESULT_DELETE_CONFIRM = 2;
    private static final int RESULT_ITEM_CLICK_CONFIRM = 0;
    private static final int RESULT_MOVE_CONFIRM = 1;
    private static final String STATE_CHECKED_MESSAGES = "checkedMessages";
    private static final String STATE_SELECTED_MESSAGE = "selectedMessage";
    private static final String STATE_UNDO_DEST_FOLDER = "stateUndoDestFolder";
    private static final String STATE_UNDO_EVENT_NAME = "stateUndoEventName";
    private static final String STATE_UNDO_MESSAGES = "stateUndoMessages";
    private static final String UNDO_PARAM_DEST_FOLDER = "undoDestFolder";
    private static final String UNDO_PARAM_EVENT_NAME = "undoEventName";
    private static final String UNDO_PARAM_MESSAGES = "undoMessages";
    private static final String UNDO_PARAM_SOURCE_FOLDER = "undoSourceFolder";
    private BaseActivity activity;
    private MessageFolderListAdapter adapter;
    private final List allListItems = new ArrayList();
    private final List allMessages = new ArrayList();
    private Animation animationSlideDown;
    private Animation animationSlideUp;
    private View bottomRibbon;
    private boolean clearDraftOnMove;
    private MessageFolder folder;
    private MessageFolderContentsDataManager folderContentsDm;
    private String inputMessageId;
    private boolean isLoadDataNeeded;
    private boolean isLoadingData;
    private ListView listView;
    private View listViewFooter;
    private View listViewHeader;
    private int previousFirstVisibleItem;
    private int previousScrollY;
    private List promptDeleteMessages;
    private MsgListMessage promptItemClicked;
    private List promptMoveMessages;
    private String selectedMessageId;
    public boolean showTabHeaders;
    private UndoMessagesActionToastDialog undoToastDialog;
    private UserAvatarUrlDataManager userAvatarDm;
    private View view;

    public MessageFolderFragment()
    {
        activity = null;
        selectedMessageId = null;
        isLoadingData = true;
        isLoadDataNeeded = false;
        showTabHeaders = true;
    }

    private void deleteMessages(List list)
    {
        MessageFolderContentsDataManager messagefoldercontentsdatamanager = getFolderContentsDm();
        if (messagefoldercontentsdatamanager != null)
        {
            messagefoldercontentsdatamanager.deleteMessages(list);
        }
    }

    private void deleteMessagesInUi(List list, String s)
    {
        makeDeletedToast(list, s);
        remove(list);
        notifyMessagesRemoved(list, folder);
    }

    private void doPromptItemClick(MsgListMessage msglistmessage)
    {
        if (isDraftInProgress())
        {
            promptItemClicked = msglistmessage;
            ComposeMessageFragment.showConfirmAbandonMessageDialogFragment(this, 0, null);
            return;
        } else
        {
            handleItemClick(msglistmessage);
            return;
        }
    }

    private MsgListMessage findMsgListItem(EbayMessage ebaymessage)
    {
        for (int i = 0; i < allListItems.size(); i++)
        {
            Object obj = (MsgListItem)allListItems.get(i);
            if (!(obj instanceof MsgListMessage))
            {
                continue;
            }
            obj = (MsgListMessage)obj;
            if (((MsgListMessage) (obj)).message.equals(ebaymessage))
            {
                return ((MsgListMessage) (obj));
            }
        }

        return null;
    }

    private MessageFolderContentsDataManager getFolderContentsDm()
    {
        if (folderContentsDm != null)
        {
            return folderContentsDm;
        }
        processArguments();
        if (activity == null)
        {
            return null;
        } else
        {
            com.ebay.nautilus.domain.content.dm.MessageFolderContentsDataManager.KeyParams keyparams = new com.ebay.nautilus.domain.content.dm.MessageFolderContentsDataManager.KeyParams(folder);
            return (MessageFolderContentsDataManager)DataManager.getIfExists(activity.getEbayContext(), keyparams);
        }
    }

    private void handleDeleteMessagesInUi(List list)
    {
        if (isDraftInProgress())
        {
            notifyPaneActivated(MessagesBaseFragment.ActivePane.MESSAGES_DETAIL);
        }
        if (isDraftInProgress() && MessagesUtils.findById(selectedMessageId, list) != null)
        {
            promptDeleteMessages = list;
            ComposeMessageFragment.showConfirmAbandonMessageDialogFragment(this, 2, null);
            return;
        } else
        {
            deleteMessagesInUi(list, "MsgEdit");
            return;
        }
    }

    private void handleItemClick(MsgListMessage msglistmessage)
    {
        selectedMessageId = msglistmessage.message.messageId;
        if (isDualPane())
        {
            adapter.notifyDataSetChanged();
        }
        notifyCurrentMessageChanged(msglistmessage.message, true);
    }

    private void handleMoveSelectedMessages(List list)
    {
        if (isDraftInProgress())
        {
            notifyPaneActivated(MessagesBaseFragment.ActivePane.MESSAGES_DETAIL);
        }
        if (isDraftInProgress() && MessagesUtils.findById(selectedMessageId, list) != null)
        {
            promptMoveMessages = list;
            ComposeMessageFragment.showConfirmAbandonMessageDialogFragment(this, 1, null);
            return;
        } else
        {
            clearDraftOnMove = false;
            promptMoveSelectedMessages(list);
            return;
        }
    }

    private void initMoveButton()
    {
        View view1;
label0:
        {
            if (view != null && folder != null)
            {
                view1 = view.findViewById(0x7f10037c);
                if (!folder.isSentFolder())
                {
                    break label0;
                }
                view1.setVisibility(8);
            }
            return;
        }
        view1.setOnClickListener(this);
        view1.setOnLongClickListener(this);
    }

    private boolean isThisFolderCurrent()
    {
        return folder != null && folder.equals(getCurrentFolder());
    }

    private void makeDeletedToast(List list, String s)
    {
        int i = list.size();
        String s1 = getResources().getQuantityString(0x7f08001e, i, new Object[] {
            Integer.valueOf(i)
        });
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("undoMessages", new ArrayList(list));
        bundle.putString("undoEventName", s);
        undoToastDialog = UndoMessagesActionToastDialog.createInstance(this, s1, bundle);
        undoToastDialog.show(getFragmentManager(), com/ebay/mobile/activities/UndoMessagesActionToastDialog.getName());
    }

    private void makeMovedToast(List list, MessageFolder messagefolder, MessageFolder messagefolder1, String s)
    {
        int i = list.size();
        String s1 = getResources().getQuantityString(0x7f08001f, i, new Object[] {
            Integer.valueOf(i)
        });
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("undoMessages", new ArrayList(list));
        bundle.putParcelable("undoDestFolder", messagefolder1);
        bundle.putParcelable("undoSourceFolder", messagefolder);
        bundle.putString("undoEventName", s);
        undoToastDialog = UndoMessagesActionToastDialog.createInstance(this, s1, bundle);
        undoToastDialog.show(getFragmentManager(), com/ebay/mobile/activities/UndoMessagesActionToastDialog.getName());
    }

    private void moveMessages(List list, MessageFolder messagefolder)
    {
        MessageFolderContentsDataManager messagefoldercontentsdatamanager = getFolderContentsDm();
        if (messagefoldercontentsdatamanager != null)
        {
            messagefoldercontentsdatamanager.moveMessages(list, messagefolder);
        }
    }

    private void moveMessagesInUi(List list, MessageFolder messagefolder, MessageFolder messagefolder1, String s)
    {
        ArrayList arraylist = new ArrayList(list.size());
        for (Iterator iterator = list.iterator(); iterator.hasNext(); arraylist.add(((EbayMessage)iterator.next()).buildUpon().folderId(messagefolder1.folderId).build())) { }
        moveMessages(list, messagefolder1);
        makeMovedToast(list, messagefolder, messagefolder1, s);
        notifyMessagesMoved(list, messagefolder, messagefolder1);
    }

    private void processArguments()
    {
        Bundle bundle = getArguments();
        if (bundle != null)
        {
            folder = (MessageFolder)bundle.getParcelable("folder");
            inputMessageId = bundle.getString("message_id");
            initMoveButton();
        }
    }

    private void processChangeInCheckedMessages()
    {
        ArrayList arraylist = getCheckedMessages();
        setupBottomRibbonVisiblity(arraylist);
        if (!arraylist.isEmpty())
        {
            TextView textview = (TextView)view.findViewById(0x7f10037a);
            int i = arraylist.size();
            textview.setText(getResources().getQuantityString(0x7f080020, i, new Object[] {
                Integer.valueOf(i)
            }));
            setupReadUnreadButtonState(arraylist);
        }
    }

    private void promptMoveSelectedMessages(List list)
    {
        list = MoveMessagesDialog.createInstance(this, getAllFolders(), folder, list.size());
        list.show(getFragmentManager(), list.getClass().getName());
    }

    private void rebuildFolderList(boolean flag)
    {
        Object obj1 = MessagesUtils.findById(selectedMessageId, allMessages);
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = obj1;
            if (!allMessages.isEmpty())
            {
                obj = (EbayMessage)allMessages.get(0);
            }
        }
        int i;
        int j;
        if (obj == null)
        {
            obj1 = null;
        } else
        {
            obj1 = ((EbayMessage) (obj)).messageId;
        }
        selectedMessageId = ((String) (obj1));
        if (isThisFolderCurrent())
        {
            notifyAllMessagesChanged(allMessages);
            notifyCurrentMessageChanged(((EbayMessage) (obj)), flag);
        }
        allListItems.clear();
        obj = Calendar.getInstance();
        i = 0;
        j = 0;
        for (obj1 = allMessages.iterator(); ((Iterator) (obj1)).hasNext();)
        {
            EbayMessage ebaymessage;
            int k;
label0:
            {
                ebaymessage = (EbayMessage)((Iterator) (obj1)).next();
                ((Calendar) (obj)).setTime(ebaymessage.receiveDate);
                if (((Calendar) (obj)).get(1) == j)
                {
                    k = i;
                    if (((Calendar) (obj)).get(2) == i)
                    {
                        break label0;
                    }
                }
                j = ((Calendar) (obj)).get(1);
                k = ((Calendar) (obj)).get(2);
                String s = DateUtils.formatDateTime(getActivity(), ebaymessage.receiveDate.getTime(), 36);
                allListItems.add(new MsgListSeparator(s));
            }
            allListItems.add(new MsgListMessage(ebaymessage));
            i = k;
        }

        if (adapter != null)
        {
            adapter.refilter();
        }
    }

    private void setupBottomRibbonVisiblity(ArrayList arraylist)
    {
        byte byte0 = 0;
        if (bottomRibbon != null)
        {
            boolean flag;
            if (arraylist == null || arraylist.isEmpty())
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
            if (bottomRibbon.getVisibility() != byte0)
            {
                View view1 = bottomRibbon;
                if (flag)
                {
                    arraylist = animationSlideDown;
                } else
                {
                    arraylist = animationSlideUp;
                }
                view1.startAnimation(arraylist);
                bottomRibbon.setVisibility(byte0);
                if (flag)
                {
                    listView.removeFooterView(listViewFooter);
                    return;
                } else
                {
                    listView.addFooterView(listViewFooter);
                    return;
                }
            }
        }
    }

    private void setupReadUnreadButtonState(ArrayList arraylist)
    {
        byte byte0 = 8;
        if (arraylist != null && !arraylist.isEmpty())
        {
            ImageView imageview = (ImageView)view.findViewById(0x7f10037d);
            ImageView imageview1 = (ImageView)view.findViewById(0x7f10037e);
            boolean flag = ((EbayMessage)arraylist.get(0)).read;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            imageview.setVisibility(i);
            if (flag)
            {
                i = byte0;
            } else
            {
                i = 0;
            }
            imageview1.setVisibility(i);
        }
    }

    private void track(String s, TrackingType trackingtype, List list, Integer integer)
    {
        trackingtype = new TrackingData(s, trackingtype);
        if (list != null)
        {
            MessagesActivity.addMessagesCountsArgs(trackingtype, list);
        }
        if (integer != null)
        {
            trackingtype.addKeyValuePair("msgact", String.valueOf(integer));
        }
        trackingtype.send(activity);
        if (log.isLoggable || logTracking.isLoggable)
        {
            logTracking.log(String.format("Tracking messages event=%s, msgact=%s [%s]", new Object[] {
                s, integer, folder
            }));
        }
    }

    private boolean updateAllListItems(EbayMessage ebaymessage)
    {
        boolean flag1 = false;
        Iterator iterator = allListItems.iterator();
        boolean flag;
        do
        {
            flag = flag1;
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (MsgListItem)iterator.next();
            if (!(obj instanceof MsgListMessage))
            {
                continue;
            }
            obj = (MsgListMessage)obj;
            if (!((MsgListMessage) (obj)).message.equals(ebaymessage))
            {
                continue;
            }
            flag = true;
            obj.message = ebaymessage;
            break;
        } while (true);
        return flag;
    }

    private boolean updateAllMessages(EbayMessage ebaymessage)
    {
        return MessagesUtils.update(ebaymessage, allMessages);
    }

    private void updateFolderProgressVisibility()
    {
        boolean flag4 = true;
        if (view != null)
        {
            View view1;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (isLoadingData || adapter == null || adapter.isFiltering())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (adapter != null && adapter.getCount() == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && allListItems.size() > 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            setupVisibility(view, 0x7f100143, flag2);
            view1 = view;
            if (!flag2 && !flag)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            setupVisibility(view1, 0x7f100376, flag3);
            view1 = view;
            if (!flag2 && flag)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            setupVisibility(view1, 0x7f1001be, flag3);
            view1 = view;
            if (!flag2 && flag1)
            {
                flag2 = flag4;
            } else
            {
                flag2 = false;
            }
            setupVisibility(view1, 0x7f10037f, flag2);
        }
    }

    public void add(List list)
    {
        for (list = list.iterator(); list.hasNext(); updateAllMessages((EbayMessage)list.next())) { }
        Collections.sort(allMessages, new MessageDateComparator());
        rebuildFolderList(false);
    }

    public void approveSwitchMessage(EbayMessage ebaymessage, EbayMessage ebaymessage1, boolean flag)
    {
    }

    public void clearMultiSelection()
    {
        setupBottomRibbonVisiblity(null);
        if (adapter != null)
        {
            adapter.clearCheckedMessages();
        }
    }

    public void deleteMessage(EbayMessage ebaymessage, String s)
    {
        deleteMessagesInUi(MessagesUtils.makeList(ebaymessage), s);
    }

    public void flagMessage(EbayMessage ebaymessage, String s)
    {
        int i = 0;
        Object obj;
        MessageFolderContentsDataManager messagefoldercontentsdatamanager;
        boolean flag;
        if (!ebaymessage.flagged)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = ebaymessage.buildUpon().flagged(flag).build();
        updateAllMessages(((EbayMessage) (obj)));
        updateAllListItems(((EbayMessage) (obj)));
        obj = MessagesUtils.makeList(obj);
        messagefoldercontentsdatamanager = getFolderContentsDm();
        if (messagefoldercontentsdatamanager != null)
        {
            messagefoldercontentsdatamanager.flagMessages(((List) (obj)), flag);
        }
        adapter.notifyDataSetChanged();
        notifyMessagesUpdated(((List) (obj)));
        obj = TrackingType.EVENT;
        ebaymessage = MessagesUtils.makeList(ebaymessage);
        if (!flag)
        {
            i = 1;
        }
        track(s, ((TrackingType) (obj)), ebaymessage, Integer.valueOf(i));
    }

    public List getAllMessages()
    {
        return allMessages;
    }

    public ArrayList getCheckedMessages()
    {
        if (adapter != null)
        {
            return new ArrayList(adapter.getCheckedMessages());
        } else
        {
            return new ArrayList();
        }
    }

    public List getFilteredMessages()
    {
        ArrayList arraylist = new ArrayList();
        MessagesFilterType messagesfiltertype = getFilterType();
        Iterator iterator = allMessages.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            EbayMessage ebaymessage = (EbayMessage)iterator.next();
            if (MessagesFilterType.doesMessageMatchFilter(messagesfiltertype, ebaymessage))
            {
                arraylist.add(ebaymessage);
            }
        } while (true);
        return arraylist;
    }

    public MessageFolder getFolder()
    {
        return folder;
    }

    public String getInputMessageId()
    {
        return inputMessageId;
    }

    public boolean getIsLoadingData()
    {
        return isLoadingData;
    }

    public EbayMessage getSelectedMessage()
    {
        return MessagesUtils.findById(selectedMessageId, allMessages);
    }

    protected String[] getSyncKeys()
    {
        return (new String[] {
            SYNC_FILTER_TYPE_CHANGED, SYNC_CURRENT_MESSAGE_CHANGED, SYNC_TAB_HEADERS_HEIGHT_CHANGED, SYNC_MESSAGES_UPDATED
        });
    }

    public void invalidateData()
    {
        MessageFolderContentsDataManager messagefoldercontentsdatamanager = getFolderContentsDm();
        if (adapter != null)
        {
            isLoadDataNeeded = true;
            isLoadingData = true;
            updateFolderProgressVisibility();
            adapter.clear();
            if (messagefoldercontentsdatamanager != null)
            {
                messagefoldercontentsdatamanager.reloadData();
            }
        } else
        if (messagefoldercontentsdatamanager != null)
        {
            messagefoldercontentsdatamanager.invalidateData();
            return;
        }
    }

    public boolean isMultiSelectionInProgress()
    {
        return !getCheckedMessages().isEmpty();
    }

    public void makeThisFolderCurrent()
    {
        notifyCurrentMessageChanged(getSelectedMessage(), false);
    }

    public void moveMessage(EbayMessage ebaymessage, MessageFolder messagefolder, String s)
    {
        moveMessagesInUi(MessagesUtils.makeList(ebaymessage), folder, messagefolder, s);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        activity = (BaseActivity)getActivity();
        ArrayList arraylist = null;
        if (bundle != null)
        {
            arraylist = bundle.getParcelableArrayList("checkedMessages");
        }
        adapter = new MessageFolderListAdapter(activity, allListItems, arraylist);
        adapter.registerDataSetObserver(new DataSetObserver() {

            final MessageFolderFragment this$0;

            public void onChanged()
            {
                updateFolderProgressVisibility();
            }

            
            {
                this$0 = MessageFolderFragment.this;
                super();
            }
        });
        adapter.setFilterType(getFilterType());
        animationSlideUp = AnimationUtils.loadAnimation(activity, 0x7f040017);
        animationSlideDown = AnimationUtils.loadAnimation(activity, 0x7f040014);
        listViewHeader = new View(activity);
        listViewHeader.setMinimumHeight(getTabHeadersHeight());
        listViewFooter = new View(activity);
        listViewFooter.setMinimumHeight((int)getResources().getDimension(0x7f0900d3));
        listView = (ListView)view.findViewById(0x7f100377);
        listView.addHeaderView(listViewHeader);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);
        listView.setOnTouchListener(new android.view.View.OnTouchListener() {

            private boolean notifyOnMove;
            final MessageFolderFragment this$0;

            public boolean onTouch(View view1, MotionEvent motionevent)
            {
                int i = motionevent.getActionMasked();
                if (i == 0)
                {
                    notifyPaneActivated(MessagesBaseFragment.ActivePane.MESSAGES_DETAIL);
                    notifyOnMove = true;
                } else
                if (i == 2 && notifyOnMove)
                {
                    notifyPaneActivated(MessagesBaseFragment.ActivePane.MESSAGES_MASTER);
                    notifyOnMove = false;
                    return false;
                }
                return false;
            }

            
            {
                this$0 = MessageFolderFragment.this;
                super();
                notifyOnMove = true;
            }
        });
        processChangeInCheckedMessages();
    }

    public void onClick(View view1)
    {
        if (!isDraftInProgress())
        {
            notifyPaneActivated(MessagesBaseFragment.ActivePane.MESSAGES_MASTER);
        }
        ArrayList arraylist = getCheckedMessages();
        if (arraylist.isEmpty())
        {
            return;
        }
        switch (view1.getId())
        {
        case 2131755898: 
        default:
            return;

        case 2131755897: 
            clearMultiSelection();
            return;

        case 2131755899: 
            handleDeleteMessagesInUi(arraylist);
            return;

        case 2131755900: 
            handleMoveSelectedMessages(arraylist);
            return;

        case 2131755901: 
            toggleMsgReadState(arraylist, false);
            return;

        case 2131755902: 
            toggleMsgReadState(arraylist, true);
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        processArguments();
        if (log.isLoggable || logUi.isLoggable)
        {
            logUi.log((new StringBuilder()).append("Fragment constructed: ").append(getClass().getSimpleName()).append("(").append(folder).append(")").toString());
        }
        if (bundle != null)
        {
            selectedMessageId = bundle.getString("selectedMessage");
            ArrayList arraylist = bundle.getParcelableArrayList("stateUndoMessages");
            if (arraylist != null)
            {
                MessageFolder messagefolder = (MessageFolder)bundle.getParcelable("stateUndoDestFolder");
                bundle = bundle.getString("stateUndoEventName");
                if (messagefolder != null)
                {
                    makeMovedToast(arraylist, folder, messagefolder, bundle);
                } else
                {
                    makeDeletedToast(arraylist, bundle);
                }
            }
        }
        initDataManagers();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        view = layoutinflater.inflate(0x7f03015b, null);
        bottomRibbon = view.findViewById(0x7f100378);
        layoutinflater = view.findViewById(0x7f100379);
        layoutinflater.setOnClickListener(this);
        layoutinflater.setOnLongClickListener(this);
        layoutinflater = view.findViewById(0x7f10037b);
        layoutinflater.setOnClickListener(this);
        layoutinflater.setOnLongClickListener(this);
        initMoveButton();
        layoutinflater = view.findViewById(0x7f10037d);
        layoutinflater.setOnClickListener(this);
        layoutinflater.setOnLongClickListener(this);
        layoutinflater = view.findViewById(0x7f10037e);
        layoutinflater.setOnClickListener(this);
        layoutinflater.setOnLongClickListener(this);
        viewgroup = getResources();
        layoutinflater = viewgroup.getString(0x7f070661);
        viewgroup = viewgroup.getString(0x7f070662, new Object[] {
            layoutinflater, folder.folderName
        });
        int i = viewgroup.indexOf(layoutinflater);
        viewgroup = new SpannableString(viewgroup);
        viewgroup.setSpan(new ClickableSpan() {

            final MessageFolderFragment this$0;

            public void onClick(View view1)
            {
                adapter.setFilterType(MessagesFilterType.FILTER_ALL);
                notifyFilterTypeChanged(MessagesFilterType.FILTER_ALL);
            }

            
            {
                this$0 = MessageFolderFragment.this;
                super();
            }
        }, i, layoutinflater.length() + i, 33);
        layoutinflater = (TextView)view.findViewById(0x7f10037f);
        layoutinflater.setText(viewgroup);
        layoutinflater.setMovementMethod(new LinkMovementMethod());
        return view;
    }

    public void onDestroyView()
    {
        undoToastDialog = null;
        folderContentsDm = null;
        super.onDestroyView();
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        if (i == 0)
        {
            if (j == 1)
            {
                clearDraft();
                handleItemClick(promptItemClicked);
            } else
            {
                listView.setSelection(adapter.getPosition(promptItemClicked));
            }
            promptItemClicked = null;
        } else
        {
            if (i == 1)
            {
                if (j == 1)
                {
                    clearDraftOnMove = true;
                    promptMoveSelectedMessages(promptMoveMessages);
                }
                promptMoveMessages = null;
                return;
            }
            if (i == 2)
            {
                if (j == 1)
                {
                    clearDraft();
                    notifyPaneActivated(MessagesBaseFragment.ActivePane.MESSAGES_MASTER);
                    deleteMessagesInUi(promptDeleteMessages, "MsgEdit");
                }
                promptDeleteMessages = null;
                return;
            }
        }
    }

    public void onFilterComplete(int i)
    {
        List list = getFilteredMessages();
        if (MessagesUtils.findById(selectedMessageId, list) == null)
        {
            EbayMessage ebaymessage = null;
            if (list.isEmpty())
            {
                selectedMessageId = null;
            } else
            {
                ebaymessage = (EbayMessage)list.get(0);
                selectedMessageId = ebaymessage.messageId;
            }
            if (isThisFolderCurrent())
            {
                notifyCurrentMessageChanged(ebaymessage, false);
            }
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        folderContentsDm = (MessageFolderContentsDataManager)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.MessageFolderContentsDataManager.KeyParams(folder), this);
        userAvatarDm = (UserAvatarUrlDataManager)datamanagercontainer.initialize(UserAvatarUrlDataManager.KEY, this);
        if ("notification.multiple.messages".equals(inputMessageId) && folder.isInbox())
        {
            folderContentsDm.reloadData();
        }
    }

    public void onItemClick(AdapterView adapterview, View view1, int i, long l)
    {
label0:
        {
            adapterview = (MsgListItem)listView.getAdapter().getItem(i);
            if (adapterview instanceof MsgListMessage)
            {
                listView.smoothScrollToPosition(i);
                view1 = ((MsgListMessage)adapterview).message;
                if (((EbayMessage) (view1)).messageId.equals(selectedMessageId))
                {
                    break label0;
                }
                doPromptItemClick((MsgListMessage)adapterview);
            }
            return;
        }
        notifyCurrentMessageChanged(view1, true);
    }

    public boolean onLongClick(View view1)
    {
        Object obj;
        Object obj1;
        int i;
        boolean flag;
        flag = false;
        i = view1.getId();
        obj1 = null;
        obj = obj1;
        i;
        JVM INSTR tableswitch 2131755897 2131755902: default 52
    //                   2131755897 97
    //                   2131755898 54
    //                   2131755899 111
    //                   2131755900 125
    //                   2131755901 139
    //                   2131755902 153;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        obj = obj1;
_L9:
        if (obj != null)
        {
            obj = Toast.makeText(activity, ((CharSequence) (obj)), 0);
            ((Toast) (obj)).setGravity(83, view1.getLeft(), view1.getTop() + view1.getHeight());
            ((Toast) (obj)).show();
            flag = true;
        }
        return flag;
_L2:
        obj = getResources().getString(0x7f07062b);
        continue; /* Loop/switch isn't completed */
_L4:
        obj = getResources().getString(0x7f07062c);
        continue; /* Loop/switch isn't completed */
_L5:
        obj = getResources().getString(0x7f07062e);
        continue; /* Loop/switch isn't completed */
_L6:
        obj = getResources().getString(0x7f07062f);
        continue; /* Loop/switch isn't completed */
_L7:
        obj = getResources().getString(0x7f070631);
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void onMessageContentsChanged(MessageFolderContentsDataManager messagefoldercontentsdatamanager, Content content)
    {
        if (log.isLoggable || logUiDm.isLoggable)
        {
            logUiDm.log((new StringBuilder()).append(getClass().getSimpleName()).append(".onMessageContentsChanged (").append(folder).append("): ").toString());
            logUiDm.log((new StringBuilder()).append("  Result: ").append(contentToString(content)).toString());
        }
        if (!content.getStatus().hasError())
        {
            clearMultiSelection();
            messagefoldercontentsdatamanager = (List)content.getData();
            boolean flag = false;
            messagefoldercontentsdatamanager = messagefoldercontentsdatamanager.iterator();
            do
            {
                if (!messagefoldercontentsdatamanager.hasNext())
                {
                    break;
                }
                content = (EbayMessage)messagefoldercontentsdatamanager.next();
                MsgListMessage msglistmessage = findMsgListItem(content);
                if (msglistmessage != null)
                {
                    flag = true;
                    msglistmessage.message = content;
                    updateAllMessages(content);
                }
            } while (true);
            if (flag)
            {
                adapter.refilter();
            }
            return;
        } else
        {
            notifyApiError(content.getStatus());
            return;
        }
    }

    public void onMessageFolderContentsAdded(MessageFolderContentsDataManager messagefoldercontentsdatamanager, Content content)
    {
        if (log.isLoggable || logUiDm.isLoggable)
        {
            logUiDm.log((new StringBuilder()).append(getClass().getSimpleName()).append(".onMessageFolderContentsIncrementalChanged (").append(folder).append("): ").toString());
            logUiDm.log((new StringBuilder()).append("  Result: ").append(contentToString(content)).toString());
        }
        if (!content.getStatus().hasError())
        {
            add((List)content.getData());
            return;
        } else
        {
            notifyApiError(content.getStatus());
            return;
        }
    }

    public void onMessageFolderContentsLoaded(MessageFolderContentsDataManager messagefoldercontentsdatamanager, Content content)
    {
        if (log.isLoggable || logUiDm.isLoggable)
        {
            logUiDm.log((new StringBuilder()).append(getClass().getSimpleName()).append(".onMessageFolderContentsLoaded (").append(folder).append("): ").toString());
            logUiDm.log((new StringBuilder()).append("  Result: ").append(contentToString(content)).toString());
        }
        isLoadingData = false;
        if (content.getStatus().hasError())
        {
            notifyApiError(content.getStatus());
            updateFolderProgressVisibility();
            return;
        }
        boolean flag;
        boolean flag1;
        if (inputMessageId != null && !"notification.multiple.messages".equals(inputMessageId))
        {
            messagefoldercontentsdatamanager = MessagesUtils.findById(inputMessageId, allMessages);
        } else
        {
            messagefoldercontentsdatamanager = null;
        }
        allMessages.clear();
        allMessages.addAll((Collection)content.getData());
        if (undoToastDialog != null)
        {
            content = undoToastDialog.getCallerContext().getParcelableArrayList("undoMessages");
            allMessages.removeAll(content);
        }
        flag1 = false;
        flag = flag1;
        if (inputMessageId != null)
        {
            flag = flag1;
            if (!"notification.multiple.messages".equals(inputMessageId))
            {
                if (MessagesUtils.findById(inputMessageId, allMessages) == null)
                {
                    if (messagefoldercontentsdatamanager != null)
                    {
                        if (folderContentsDm != null)
                        {
                            folderContentsDm.addNewMessage(messagefoldercontentsdatamanager);
                        }
                        allMessages.add(messagefoldercontentsdatamanager);
                    } else
                    {
                        messagefoldercontentsdatamanager = (new com.ebay.nautilus.domain.data.EbayMessage.Builder(inputMessageId)).folderId(folder.folderId).receiveDate(new Date()).build();
                        allMessages.add(messagefoldercontentsdatamanager);
                    }
                }
                selectedMessageId = inputMessageId;
                inputMessageId = null;
                flag = true;
            }
        }
        Collections.sort(allMessages, new MessageDateComparator());
        rebuildFolderList(flag);
    }

    public void onMessageFolderContentsRemoved(MessageFolderContentsDataManager messagefoldercontentsdatamanager, Content content)
    {
        if (log.isLoggable || logUiDm.isLoggable)
        {
            logUiDm.log((new StringBuilder()).append(getClass().getSimpleName()).append(".onMessageFolderContentsIncrementalChanged (").append(folder).append("): ").toString());
            logUiDm.log((new StringBuilder()).append("  Result: ").append(contentToString(content)).toString());
        }
        if (!content.getStatus().hasError())
        {
            remove((List)content.getData());
            return;
        } else
        {
            notifyApiError(content.getStatus());
            return;
        }
    }

    public void onMoveMessagesFolderSelected(MoveMessagesDialog movemessagesdialog, MessageFolder messagefolder, MessageFolder messagefolder1)
    {
        if (clearDraftOnMove)
        {
            clearDraft();
            notifyPaneActivated(MessagesBaseFragment.ActivePane.MESSAGES_MASTER);
            clearDraftOnMove = false;
        }
        moveMessagesInUi(getCheckedMessages(), messagefolder, messagefolder1, "MsgEdit");
    }

    protected void onNotifyCurrentMessageChanged(EbayMessage ebaymessage, boolean flag)
    {
        if (flag && ebaymessage != null && !ebaymessage.messageId.equals(selectedMessageId) && folder != null && folder.isFolderOf(ebaymessage))
        {
            selectedMessageId = ebaymessage.messageId;
            adapter.notifyDataSetChanged();
        }
    }

    protected void onNotifyFilterTypeChanged(MessagesFilterType messagesfiltertype)
    {
        adapter.setFilterType(messagesfiltertype);
    }

    protected void onNotifyMessagesUpdated(List list)
    {
        if (list != null && !list.isEmpty() && folder != null && folder.isFolderOf((EbayMessage)list.get(0)))
        {
            boolean flag = false;
            list = list.iterator();
label0:
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                EbayMessage ebaymessage = (EbayMessage)list.next();
                Iterator iterator = allListItems.iterator();
                Object obj;
                EbayMessage ebaymessage1;
                do
                {
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            continue label0;
                        }
                        obj = (MsgListItem)iterator.next();
                    } while (!(obj instanceof MsgListMessage));
                    obj = (MsgListMessage)obj;
                    ebaymessage1 = ((MsgListMessage) (obj)).message;
                } while (!ebaymessage1.equals(ebaymessage));
                ebaymessage = ebaymessage1.buildUpon().flagged(ebaymessage.flagged).read(ebaymessage.read).build();
                obj.message = ebaymessage;
                updateAllMessages(ebaymessage);
                flag = true;
            } while (true);
            if (flag)
            {
                adapter.notifyDataSetChanged();
            }
        }
    }

    protected void onNotifyTabHeadersHeightChanged(int i)
    {
        if (listViewHeader != null)
        {
            listViewHeader.setMinimumHeight(i);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("selectedMessage", selectedMessageId);
        bundle.putParcelableArrayList("checkedMessages", getCheckedMessages());
        if (undoToastDialog != null)
        {
            Bundle bundle1 = undoToastDialog.getArguments();
            bundle.putParcelableArrayList("stateUndoMessages", bundle1.getParcelableArrayList("undoMessages"));
            bundle.putParcelable("stateUndoDestFolder", bundle1.getParcelable("undoDestFolder"));
            bundle.putString("stateUndoEventName", bundle1.getString("undoEventName"));
            getFragmentManager().beginTransaction().remove(undoToastDialog).commitAllowingStateLoss();
            undoToastDialog = null;
        }
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        boolean flag1 = false;
        abslistview = listView.getChildAt(0);
        boolean flag;
        if (abslistview != null)
        {
            j = abslistview.getTop();
        } else
        {
            j = previousScrollY;
        }
        if (i == 0)
        {
            flag1 = true;
        }
        flag = flag1;
        if (!flag1)
        {
            if (i > previousFirstVisibleItem)
            {
                flag = false;
            } else
            if (i < previousFirstVisibleItem)
            {
                flag = true;
            } else
            {
                flag = showTabHeaders;
            }
        }
        if (showTabHeaders != flag)
        {
            showTabHeaders = flag;
            notifyShowTabHeadersChanged(Boolean.valueOf(flag));
        }
        previousScrollY = j;
        previousFirstVisibleItem = i;
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    public void onUndoMessagesActionExpired(UndoMessagesActionToastDialog undomessagesactiontoastdialog, Bundle bundle)
    {
        undoToastDialog = null;
        undomessagesactiontoastdialog = bundle.getParcelableArrayList("undoMessages");
        MessageFolder messagefolder = (MessageFolder)bundle.getParcelable("undoDestFolder");
        if (messagefolder == null)
        {
            deleteMessages(undomessagesactiontoastdialog);
        }
        bundle = bundle.getString("undoEventName");
        if (bundle != null)
        {
            byte byte0;
            if (messagefolder == null)
            {
                byte0 = 2;
            } else
            if (messagefolder.isArchiveFolder())
            {
                byte0 = 5;
            } else
            {
                byte0 = 4;
            }
            track(bundle, TrackingType.EVENT, undomessagesactiontoastdialog, Integer.valueOf(byte0));
        }
    }

    public void onUndoMessagesActionSelected(UndoMessagesActionToastDialog undomessagesactiontoastdialog, Bundle bundle)
    {
        undoToastDialog = null;
        undomessagesactiontoastdialog = bundle.getParcelableArrayList("undoMessages");
        Object obj = (MessageFolder)bundle.getParcelable("undoDestFolder");
        bundle = (MessageFolder)bundle.getParcelable("undoSourceFolder");
        if (bundle != null && obj != null)
        {
            notifyMessagesMoved(undomessagesactiontoastdialog, ((MessageFolder) (obj)), bundle);
            obj = new com.ebay.nautilus.domain.content.dm.MessageFolderContentsDataManager.KeyParams(((MessageFolder) (obj)));
            obj = (MessageFolderContentsDataManager)MessageFolderContentsDataManager.get(getFwActivity().getEbayContext(), ((com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams) (obj)));
            if (obj != null)
            {
                ((MessageFolderContentsDataManager) (obj)).moveMessages(undomessagesactiontoastdialog, bundle);
            }
        } else
        if (bundle == null && obj == null)
        {
            add(undomessagesactiontoastdialog);
            return;
        }
    }

    public void onUserAvatarUrlChanged(UserAvatarUrlDataManager useravatarurldatamanager, String s, String s1)
    {
    }

    public void refreshData()
    {
        MessageFolderContentsDataManager messagefoldercontentsdatamanager = getFolderContentsDm();
        if (adapter == null)
        {
            if (messagefoldercontentsdatamanager != null)
            {
                messagefoldercontentsdatamanager.invalidateData();
            }
        } else
        {
            isLoadingData = true;
            adapter.clear();
            if (messagefoldercontentsdatamanager != null)
            {
                messagefoldercontentsdatamanager.reloadData();
                return;
            }
        }
    }

    public void remove(List list)
    {
        clearMultiSelection();
        boolean flag = false;
        ArrayList arraylist = new ArrayList();
        MsgListSeparator msglistseparator = null;
        Iterator iterator = allListItems.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (MsgListItem)iterator.next();
            if (obj instanceof MsgListSeparator)
            {
                if (msglistseparator != null)
                {
                    arraylist.add(msglistseparator);
                }
                msglistseparator = (MsgListSeparator)obj;
            } else
            if (obj instanceof MsgListMessage)
            {
                obj = (MsgListMessage)obj;
                if (list.contains(((MsgListMessage) (obj)).message))
                {
                    arraylist.add(obj);
                    if (((MsgListMessage) (obj)).message.messageId.equals(selectedMessageId))
                    {
                        flag = true;
                    }
                } else
                {
                    msglistseparator = null;
                }
            }
        } while (true);
        if (msglistseparator != null)
        {
            arraylist.add(msglistseparator);
        }
        allListItems.removeAll(arraylist);
        allMessages.removeAll(list);
        if (flag)
        {
            if (allMessages.isEmpty())
            {
                list = null;
            } else
            {
                list = ((EbayMessage)allMessages.get(0)).messageId;
            }
            selectedMessageId = list;
            if (isThisFolderCurrent())
            {
                notifyCurrentMessageChanged(getSelectedMessage(), false);
            }
        }
        if (isThisFolderCurrent())
        {
            notifyAllMessagesChanged(allMessages);
        }
        adapter.refilter();
    }

    public void scrollToTop()
    {
        if (listView != null)
        {
            listView.smoothScrollToPosition(0);
        }
    }

    public void setInputMessageId(String s)
    {
        inputMessageId = s;
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        if (flag && isLoadDataNeeded)
        {
            isLoadDataNeeded = false;
            if (folderContentsDm != null)
            {
                folderContentsDm.loadData(this);
            }
        }
    }

    void setupVisibility(View view1, int i, boolean flag)
    {
        view1 = view1.findViewById(i);
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view1.setVisibility(i);
    }

    void toggleMsgReadState(List list, boolean flag)
    {
        Object obj = new ArrayList(list.size());
        Object obj1 = list.iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            EbayMessage ebaymessage = (EbayMessage)((Iterator) (obj1)).next();
            if (ebaymessage.read != flag)
            {
                ((List) (obj)).add(ebaymessage.buildUpon().read(flag).build());
            }
        } while (true);
        obj1 = getFolderContentsDm();
        if (obj1 != null)
        {
            ((MessageFolderContentsDataManager) (obj1)).markReadMessages(((List) (obj)), flag);
        }
        notifyMessagesUpdated(((List) (obj)));
        obj = TrackingType.EVENT;
        byte byte0;
        if (flag)
        {
            byte0 = 6;
        } else
        {
            byte0 = 7;
        }
        track("MsgEdit", ((TrackingType) (obj)), list, Integer.valueOf(byte0));
    }






}
