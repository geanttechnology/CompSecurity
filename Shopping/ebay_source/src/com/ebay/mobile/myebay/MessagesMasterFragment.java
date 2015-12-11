// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.ebay.android.widget.OnSizeRelativeLayout;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.dm.MessageFolderContentsDataManager;
import com.ebay.nautilus.domain.content.dm.MessageFoldersDataManager;
import com.ebay.nautilus.domain.content.dm.MessagesUtils;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.data.MessageFolder;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwActivity;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessagesBaseFragment, MessagesFilterType, ScrollingTabAdapter, MessageFolderFragment, 
//            ScrollingTabView, ComposeMessageFragment

public class MessagesMasterFragment extends MessagesBaseFragment
    implements android.support.v4.view.ViewPager.OnPageChangeListener, android.widget.AdapterView.OnItemSelectedListener, com.ebay.android.widget.OnSizeRelativeLayout.OnSizeChangedListener, DialogFragmentCallback, ScrollingTabView.OnCurrentTabReselected, com.ebay.nautilus.domain.content.dm.MessageFoldersDataManager.Observer
{
    private class FolderComparator
        implements Comparator
    {

        private final Collator collator;
        final MessagesMasterFragment this$0;

        public int compare(MessageFolder messagefolder, MessageFolder messagefolder1)
        {
            if (!messagefolder.isInbox() || !messagefolder1.isInbox())
            {
                if (messagefolder.isInbox())
                {
                    return -1;
                }
                if (messagefolder1.isInbox())
                {
                    return 1;
                }
                if (!messagefolder.isSentFolder() || !messagefolder1.isSentFolder())
                {
                    if (messagefolder.isSentFolder())
                    {
                        return -1;
                    }
                    if (messagefolder1.isSentFolder())
                    {
                        return 1;
                    }
                    if (!messagefolder.isArchiveFolder() || !messagefolder1.isArchiveFolder())
                    {
                        if (messagefolder.isArchiveFolder())
                        {
                            return 1;
                        }
                        if (messagefolder1.isArchiveFolder())
                        {
                            return -1;
                        } else
                        {
                            return collator.compare(messagefolder.folderName, messagefolder1.folderName);
                        }
                    }
                }
            }
            return 0;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((MessageFolder)obj, (MessageFolder)obj1);
        }

        public FolderComparator(Collator collator1)
        {
            this$0 = MessagesMasterFragment.this;
            super();
            collator = collator1;
            collator1.setStrength(0);
        }
    }


    private static final int RESULT_NEW_FILTER_CONFIRM = 1;
    private static final int RESULT_TAB_CHANGE_CONFIRM = 0;
    private static final String STATE_FOLDER_POSITION = "currentFolderId";
    private final List allFolders = new ArrayList();
    private ViewGroup belowtabContainer;
    private boolean confirmAbandonMsgDlgShowingForFilter;
    private boolean dmReloadNeeded;
    private MessagesFilterType filterType;
    private int folderPosition;
    private String inputMessageId;
    private boolean isTabControlsAnimating;
    private MessageFoldersDataManager messageFoldersDm;
    private int promptFolderPosition;
    private MessagesFilterType promptNewFilterType;
    private Boolean requestShowTabControls;
    private MessagesFilterType savedFilterType;
    private boolean showTabHeaders;
    private Spinner spinner;
    private Boolean spinnerIsSentFolder;
    private ScrollingTabAdapter tabAdapter;
    private OnSizeRelativeLayout tabHostContainer;
    private int tabHostHeight;
    private boolean userSelectedSpinnerChange;
    private ViewPager viewPager;

    public MessagesMasterFragment()
    {
        folderPosition = 0;
        filterType = MessagesFilterType.FILTER_ALL;
        spinnerIsSentFolder = null;
        dmReloadNeeded = false;
        showTabHeaders = true;
        userSelectedSpinnerChange = true;
    }

    private void addTab(MessageFolder messagefolder, String s, Integer integer)
    {
        View view = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f030162, null, false);
        if (messagefolder != null)
        {
            TextView textview = (TextView)view.findViewById(0x7f10039a);
            if (messagefolder.folderName != null)
            {
                textview.setText(messagefolder.folderName.toUpperCase(Locale.getDefault()));
            }
            setUnreadBadge(view, messagefolder.newMessageCount);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("folder", messagefolder);
        bundle.putString("message_id", s);
        if (integer == null)
        {
            tabAdapter.addTab(view, bundle);
            return;
        } else
        {
            tabAdapter.addTabAtIndex(view, bundle, integer.intValue());
            return;
        }
    }

    private boolean configureSpinner(boolean flag)
    {
        if (spinnerIsSentFolder == null || flag != spinnerIsSentFolder.booleanValue())
        {
            spinnerIsSentFolder = Boolean.valueOf(flag);
            Object obj = getActivity();
            int i;
            if (flag)
            {
                i = 0x7f0e0015;
            } else
            {
                i = 0x7f0e0014;
            }
            obj = ArrayAdapter.createFromResource(((android.content.Context) (obj)), i, 0x1090008);
            ((ArrayAdapter) (obj)).setDropDownViewResource(0x1090009);
            spinner.setAdapter(((android.widget.SpinnerAdapter) (obj)));
            return true;
        } else
        {
            return false;
        }
    }

    private MessageFolderFragment getCurrentFolderFragment()
    {
        if (tabAdapter != null)
        {
            return getFolderFragmentIfExists(tabAdapter.getCurrentTab());
        } else
        {
            return null;
        }
    }

    private MessageFolderFragment getFolderFragmentIfExists(int i)
    {
        return (MessageFolderFragment)tabAdapter.getItemIfExists(viewPager, i);
    }

    private MessageFolderFragment getFolderFragmentIfExists(MessageFolder messagefolder)
    {
        for (int i = 0; i < allFolders.size(); i++)
        {
            if (((MessageFolder)allFolders.get(i)).equals(messagefolder))
            {
                return (MessageFolderFragment)tabAdapter.getItemIfExists(viewPager, i);
            }
        }

        return null;
    }

    private String getFolderName(MessageFolder messagefolder)
    {
label0:
        {
            String s1 = messagefolder.folderName;
            String s = s1;
            if (s1 == null)
            {
                if (!messagefolder.isInbox())
                {
                    break label0;
                }
                s = getString(0x7f07047d);
            }
            return s;
        }
        if (messagefolder.isSentFolder())
        {
            return getString(0x7f070a49);
        }
        if (messagefolder.isArchiveFolder())
        {
            return getString(0x7f070172);
        } else
        {
            return getString(0x7f07064a, new Object[] {
                String.valueOf(messagefolder.folderId - 1L)
            });
        }
    }

    private void handleTabChanged(int i)
    {
        notifyPaneActivated(MessagesBaseFragment.ActivePane.MESSAGES_MASTER);
        updateFilterSpinnerOnTabChanged(i);
        folderPosition = i;
        MessageFolderFragment messagefolderfragment = getFolderFragmentIfExists(i);
        showTabHeaders(true);
        if (messagefolderfragment != null)
        {
            messagefolderfragment.showTabHeaders = true;
            messagefolderfragment.makeThisFolderCurrent();
        }
        notifyCurrentFolderChanged(getCurrentFolder());
    }

    private void incrementallyRefreshTabs(List list)
    {
        MessageFolder messagefolder1;
        MessageFolder messagefolder2;
        FolderComparator foldercomparator;
        int j;
        int k;
        foldercomparator = new FolderComparator(Collator.getInstance(Locale.getDefault()));
        messagefolder2 = (MessageFolder)allFolders.get(0);
        messagefolder1 = (MessageFolder)list.get(0);
        k = 0;
        j = 0;
_L3:
        MessageFolder messagefolder;
        String s;
        int i;
        if (messagefolder2 == null && messagefolder1 == null || messagefolder1 == null)
        {
            return;
        }
        if (messagefolder1.isInbox())
        {
            s = inputMessageId;
        } else
        {
            s = null;
        }
        messagefolder = messagefolder1;
        i = j;
        if (messagefolder2 == null)
        {
            allFolders.add(messagefolder1);
            addTab(messagefolder1, s, null);
            i = j + 1;
            if (i != list.size())
            {
                messagefolder = (MessageFolder)list.get(i);
            } else
            {
                messagefolder = null;
            }
        }
        j = foldercomparator.compare(messagefolder, messagefolder2);
        if (j != 0) goto _L2; else goto _L1
_L1:
        allFolders.set(k, messagefolder);
        setUnreadBadge(tabAdapter.getTabAtIndex(k), messagefolder.newMessageCount);
        k++;
        i++;
        if (i != list.size())
        {
            messagefolder = (MessageFolder)list.get(i);
        } else
        {
            messagefolder = null;
        }
_L4:
        if (k != allFolders.size())
        {
            messagefolder2 = (MessageFolder)allFolders.get(k);
        } else
        {
            messagefolder2 = null;
        }
        messagefolder1 = messagefolder;
        j = i;
        if (true) goto _L3; else goto _L2
_L2:
        if (j < 0)
        {
            allFolders.add(k, messagefolder);
            addTab(messagefolder, s, Integer.valueOf(k));
            k++;
            i++;
            if (i != list.size())
            {
                messagefolder = (MessageFolder)list.get(i);
            } else
            {
                messagefolder = null;
            }
        } else
        {
            allFolders.remove(k);
            tabAdapter.removeTabAtIndex(k);
        }
          goto _L4
    }

    private void refreshData(String s)
    {
        int i;
        int j;
        if (tabAdapter == null)
        {
            i = 0;
        } else
        {
            i = tabAdapter.getCount();
        }
        for (j = 0; j < i; j++)
        {
            MessageFolderFragment messagefolderfragment = getFolderFragmentIfExists(j);
            if (messagefolderfragment == null)
            {
                continue;
            }
            MessageFolder messagefolder = messagefolderfragment.getFolder();
            if (messagefolder != null && messagefolder.isInbox())
            {
                messagefolderfragment.setInputMessageId(s);
            }
            messagefolderfragment.refreshData();
        }

        if (messageFoldersDm != null)
        {
            messageFoldersDm.reloadData();
            return;
        } else
        {
            dmReloadNeeded = true;
            return;
        }
    }

    private void setUnreadBadge(View view, int i)
    {
        if (view != null)
        {
            view = (TextView)view.findViewById(0x7f10039b);
            view.setText(Util.countAsString(getActivity(), i));
            if (i > 0)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    private void showTabHeaders(boolean flag)
    {
        if (flag == showTabHeaders) goto _L2; else goto _L1
_L1:
        if (isTabControlsAnimating) goto _L4; else goto _L3
_L3:
        isTabControlsAnimating = true;
        showTabHeadersTranslateAnimation(flag);
_L6:
        return;
_L4:
        requestShowTabControls = Boolean.valueOf(flag);
        return;
_L2:
        if (isTabControlsAnimating)
        {
            requestShowTabControls = Boolean.valueOf(flag);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void showTabHeadersTranslateAnimation(final boolean show)
    {
        TranslateAnimation translateanimation;
        if (show)
        {
            translateanimation = new TranslateAnimation(0.0F, 0.0F, -tabHostHeight, 0.0F);
        } else
        {
            translateanimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -tabHostHeight);
        }
        translateanimation.setDuration(200L);
        translateanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final MessagesMasterFragment this$0;
            final boolean val$show;

            public void onAnimationEnd(Animation animation)
            {
                animation = tabHostContainer;
                int i;
                if (show)
                {
                    i = 0;
                } else
                {
                    i = 4;
                }
                animation.setVisibility(i);
                isTabControlsAnimating = false;
                if (requestShowTabControls != null && requestShowTabControls.booleanValue() != show)
                {
                    showTabHeaders(requestShowTabControls.booleanValue());
                }
                requestShowTabControls = null;
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
                showTabHeaders = show;
            }

            
            {
                this$0 = MessagesMasterFragment.this;
                show = flag;
                super();
            }
        });
        tabHostContainer.startAnimation(translateanimation);
    }

    private void updateFilterSpinnerOnTabChanged(int i)
    {
        MessagesFilterType messagesfiltertype;
        Object obj;
        MessagesFilterType messagesfiltertype1;
        MessageFolder messagefolder;
        boolean flag;
        boolean flag1;
        if (i >= 0 && i < allFolders.size())
        {
            obj = (MessageFolder)allFolders.get(i);
        } else
        {
            obj = null;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        messagesfiltertype1 = getFilterType();
        messagesfiltertype = messagesfiltertype1;
        flag = ((MessageFolder) (obj)).isSentFolder();
        messagefolder = getCurrentFolder();
        flag1 = configureSpinner(flag);
        if (!flag) goto _L4; else goto _L3
_L3:
label0:
        {
            obj = messagesfiltertype;
            if (messagesfiltertype1 == MessagesFilterType.FILTER_ALL)
            {
                break label0;
            }
            obj = messagesfiltertype;
            if (messagesfiltertype1 == MessagesFilterType.FILTER_UNREAD)
            {
                break label0;
            }
            obj = messagesfiltertype;
            if (messagesfiltertype1 == MessagesFilterType.FILTER_FLAGGED)
            {
                break label0;
            }
            if (messagefolder != null)
            {
                obj = messagesfiltertype;
                if (messagefolder.isSentFolder())
                {
                    break label0;
                }
            }
            savedFilterType = messagesfiltertype1;
            obj = MessagesFilterType.FILTER_ALL;
        }
_L6:
        if (flag1 || !messagesfiltertype1.equals(obj))
        {
            setSpinnerSelectionProgramatically(((MessagesFilterType) (obj)).ordinal());
            notifyFilterTypeChanged(((MessagesFilterType) (obj)));
        }
_L2:
        return;
_L4:
        obj = messagesfiltertype;
        if (messagefolder != null)
        {
            obj = messagesfiltertype;
            if (messagefolder.isSentFolder())
            {
                obj = messagesfiltertype;
                if (savedFilterType != null)
                {
                    obj = savedFilterType;
                }
            }
        }
        savedFilterType = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void clearMultiSelection()
    {
        MessageFolderFragment messagefolderfragment = getCurrentFolderFragment();
        if (messagefolderfragment != null)
        {
            messagefolderfragment.clearMultiSelection();
        }
    }

    public void deleteMessage(EbayMessage ebaymessage)
    {
        MessageFolderFragment messagefolderfragment = getCurrentFolderFragment();
        if (messagefolderfragment != null && ebaymessage != null)
        {
            messagefolderfragment.deleteMessage(ebaymessage, "ViewMessage");
            return;
        } else
        {
            log.logAsWarning((new StringBuilder()).append("Unable to delete message ").append(ebaymessage).toString());
            return;
        }
    }

    void doFilter(MessagesFilterType messagesfiltertype)
    {
        filterType = messagesfiltertype;
        notifyFilterTypeChanged(filterType);
    }

    public void flagMessage(EbayMessage ebaymessage)
    {
        MessageFolderFragment messagefolderfragment = getCurrentFolderFragment();
        if (messagefolderfragment != null && ebaymessage != null)
        {
            messagefolderfragment.flagMessage(ebaymessage, "ViewMessage");
            return;
        } else
        {
            log.logAsWarning((new StringBuilder()).append("Unable to flag message ").append(ebaymessage).toString());
            return;
        }
    }

    public List getAllFolders()
    {
        return allFolders;
    }

    public List getAllMessages()
    {
        MessageFolderFragment messagefolderfragment = getCurrentFolderFragment();
        if (messagefolderfragment == null)
        {
            return new ArrayList();
        } else
        {
            return messagefolderfragment.getAllMessages();
        }
    }

    public MessageFolder getCurrentFolder()
    {
        Object obj = null;
        MessageFolder messagefolder = obj;
        if (folderPosition >= 0)
        {
            messagefolder = obj;
            if (folderPosition < allFolders.size())
            {
                messagefolder = (MessageFolder)allFolders.get(folderPosition);
            }
        }
        return messagefolder;
    }

    public EbayMessage getCurrentMessage()
    {
        MessageFolderFragment messagefolderfragment = getCurrentFolderFragment();
        if (messagefolderfragment == null)
        {
            return null;
        } else
        {
            return messagefolderfragment.getSelectedMessage();
        }
    }

    public MessagesFilterType getFilterType()
    {
        return filterType;
    }

    public List getFilteredMessages()
    {
        MessageFolderFragment messagefolderfragment = getCurrentFolderFragment();
        if (messagefolderfragment == null)
        {
            return new ArrayList();
        } else
        {
            return messagefolderfragment.getFilteredMessages();
        }
    }

    public String getInputMessageId()
    {
        return inputMessageId;
    }

    public boolean getIsMessageListLoaded()
    {
        MessageFolderFragment messagefolderfragment = getCurrentFolderFragment();
        return messagefolderfragment != null && !messagefolderfragment.getIsLoadingData();
    }

    protected String[] getSyncKeys()
    {
        return (new String[] {
            SYNC_FILTER_TYPE_CHANGED, SYNC_MESSAGE_SENT, SYNC_SHOW_TAB_HEADERS_CHANGED
        });
    }

    public int getTabHeadersHeight()
    {
        return tabHostHeight;
    }

    public boolean isMultiSelectionInProgress()
    {
        MessageFolderFragment messagefolderfragment = getCurrentFolderFragment();
        if (messagefolderfragment == null)
        {
            return false;
        } else
        {
            return messagefolderfragment.isMultiSelectionInProgress();
        }
    }

    public void moveMessage(EbayMessage ebaymessage, MessageFolder messagefolder)
    {
        MessageFolderFragment messagefolderfragment = getCurrentFolderFragment();
        if (messagefolderfragment != null && ebaymessage != null && messagefolder != null)
        {
            messagefolderfragment.moveMessage(ebaymessage, messagefolder, "ViewMessage");
            return;
        } else
        {
            log.logAsWarning((new StringBuilder()).append("Unable to move message ").append(ebaymessage).append(" to ").append(messagefolder).toString());
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Bundle bundle1 = getArguments();
        if (bundle1 != null)
        {
            inputMessageId = bundle1.getString("message_id");
        }
        if (bundle != null)
        {
            folderPosition = bundle.getInt("currentFolderId");
        }
        setRetainInstance(true);
        initDataManagers();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = getActivity();
        showTabHeaders = true;
        viewPager = (ViewPager)viewgroup.findViewById(0x7f10055a);
        if (isDualPane())
        {
            viewPager.setPageMargin((int)getResources().getDimension(0x7f0900d2));
        }
        bundle = (ScrollingTabView)viewgroup.findViewById(0x7f10055c);
        tabAdapter = new ScrollingTabAdapter(layoutinflater, viewPager, bundle, com/ebay/mobile/myebay/MessageFolderFragment);
        tabAdapter.addOnPageChangeListener(this);
        tabAdapter.setOnCurrentTabReselected(this);
        tabHostContainer = (OnSizeRelativeLayout)viewgroup.findViewById(0x7f10055b);
        tabHostHeight = tabHostContainer.getHeight();
        tabHostContainer.setOnSizeListener(this);
        bundle.setOnTouchListener(new android.view.View.OnTouchListener() {

            final MessagesMasterFragment this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                int i = motionevent.getActionMasked();
                if (i == 1 || i == 3)
                {
                    notifyPaneActivated(MessagesBaseFragment.ActivePane.MESSAGES_MASTER);
                }
                return false;
            }

            
            {
                this$0 = MessagesMasterFragment.this;
                super();
            }
        });
        if (!allFolders.isEmpty())
        {
            bundle = allFolders.iterator();
            while (bundle.hasNext()) 
            {
                MessageFolder messagefolder = (MessageFolder)bundle.next();
                if (messagefolder.isInbox())
                {
                    layoutinflater = inputMessageId;
                } else
                {
                    layoutinflater = null;
                }
                addTab(messagefolder, layoutinflater, null);
            }
            tabAdapter.notifyDataSetChanged();
        }
        viewgroup.findViewById(0x7f100559).setVisibility(0);
        viewgroup.findViewById(0x7f10055e).setVisibility(0);
        belowtabContainer = (ViewGroup)viewgroup.findViewById(0x7f10055d);
        View.inflate(getActivity(), 0x7f03015a, belowtabContainer);
        spinner = (Spinner)belowtabContainer.findViewById(0x7f100375);
        spinner.setOnItemSelectedListener(this);
        spinner.setOnTouchListener(new android.view.View.OnTouchListener() {

            final MessagesMasterFragment this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1 && !isDraftInProgress())
                {
                    notifyPaneActivated(MessagesBaseFragment.ActivePane.MESSAGES_MASTER);
                }
                return false;
            }

            
            {
                this$0 = MessagesMasterFragment.this;
                super();
            }
        });
        boolean flag;
        if (spinnerIsSentFolder == null)
        {
            flag = false;
        } else
        {
            flag = spinnerIsSentFolder.booleanValue();
        }
        spinnerIsSentFolder = null;
        userSelectedSpinnerChange = false;
        configureSpinner(flag);
        tabAdapter.setPosition(folderPosition);
        return null;
    }

    public void onDestroyView()
    {
        tabAdapter.clearAllTabs();
        confirmAbandonMsgDlgShowingForFilter = false;
        super.onDestroyView();
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        if (i != 0) goto _L2; else goto _L1
_L1:
        i = promptFolderPosition;
        promptFolderPosition = 0;
        if (j == 1)
        {
            clearDraft();
            tabAdapter.setPosition(i);
        }
_L4:
        return;
_L2:
        if (i != 1) goto _L4; else goto _L3
_L3:
        confirmAbandonMsgDlgShowingForFilter = false;
        if (j != 1) goto _L6; else goto _L5
_L5:
        clearDraft();
        doFilter(promptNewFilterType);
_L8:
        promptNewFilterType = filterType;
        return;
_L6:
        dialogfragment = MessagesFilterType.values();
        i = 0;
        do
        {
            if (i < dialogfragment.length)
            {
label0:
                {
                    if (!dialogfragment[i].equals(filterType))
                    {
                        break label0;
                    }
                    setSpinnerSelectionProgramatically(i);
                }
            }
            if (true)
            {
                continue;
            }
            i++;
        } while (true);
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        messageFoldersDm = (MessageFoldersDataManager)datamanagercontainer.initialize(MessageFoldersDataManager.KEY, this);
        if (dmReloadNeeded)
        {
            dmReloadNeeded = false;
            messageFoldersDm.reloadData();
        }
    }

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
label0:
        {
            if (userSelectedSpinnerChange)
            {
                savedFilterType = null;
            } else
            {
                userSelectedSpinnerChange = true;
            }
            adapterview = MessagesFilterType.values()[i];
            if (!filterType.equals(adapterview))
            {
                if (!isDraftInProgress())
                {
                    break label0;
                }
                if (!confirmAbandonMsgDlgShowingForFilter)
                {
                    confirmAbandonMsgDlgShowingForFilter = true;
                    promptNewFilterType = adapterview;
                    ComposeMessageFragment.showConfirmAbandonMessageDialogFragment(this, 1, null);
                    notifyPaneActivated(MessagesBaseFragment.ActivePane.MESSAGES_DETAIL);
                }
            }
            return;
        }
        doFilter(adapterview);
    }

    public void onMessageFoldersDataChanged(MessageFoldersDataManager messagefoldersdatamanager, Content content)
    {
        if (log.isLoggable || logUiDm.isLoggable)
        {
            logUiDm.log((new StringBuilder()).append(getClass().getSimpleName()).append(".onMessageFoldersDataChanged: ").toString());
            logUiDm.log((new StringBuilder()).append("  Result: ").append(contentToString(content)).toString());
        }
        break MISSING_BLOCK_LABEL_79;
_L2:
        int j;
        do
        {
            do
            {
                return;
            } while (ensureActivity() == null || content == null);
            messagefoldersdatamanager = (List)content.getData();
        } while (messagefoldersdatamanager == null || tabAdapter == null);
        j = tabAdapter.getCount();
        messagefoldersdatamanager = messagefoldersdatamanager.iterator();
_L3:
        if (!messagefoldersdatamanager.hasNext()) goto _L2; else goto _L1
_L1:
        ListIterator listiterator;
        int i;
        content = (MessageFolder)messagefoldersdatamanager.next();
        listiterator = allFolders.listIterator();
        i = 0;
_L4:
        if (i < j && listiterator.hasNext())
        {
label0:
            {
                MessageFolder messagefolder = (MessageFolder)listiterator.next();
                if (!content.equals(messagefolder))
                {
                    break label0;
                }
                listiterator.set(messagefolder.buildUpon().newMessageCount(((MessageFolder) (content)).newMessageCount).totalMessageCount(((MessageFolder) (content)).totalMessageCount).build());
                setUnreadBadge(tabAdapter.getTabAtIndex(i), ((MessageFolder) (content)).newMessageCount);
            }
        }
          goto _L3
          goto _L2
        i++;
          goto _L4
    }

    public void onMessageFoldersListChanged(MessageFoldersDataManager messagefoldersdatamanager, Content content)
    {
        if (log.isLoggable || logUiDm.isLoggable)
        {
            logUiDm.log((new StringBuilder()).append(getClass().getSimpleName()).append(".onMessageFolderListChanged: ").toString());
            logUiDm.log((new StringBuilder()).append("  Result: ").append(contentToString(content)).toString());
        }
        if (ensureActivity() != null)
        {
            if (content.getStatus().hasError())
            {
                notifyApiError(content.getStatus());
                return;
            }
            if (!((List)content.getData()).isEmpty())
            {
                Object obj = new ArrayList((Collection)content.getData());
                content = getCurrentFolder();
                boolean flag;
                if (content == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                messagefoldersdatamanager = content;
                if (inputMessageId != null)
                {
                    Iterator iterator = allFolders.iterator();
                    do
                    {
                        messagefoldersdatamanager = content;
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        messagefoldersdatamanager = (MessageFolder)iterator.next();
                    } while (!messagefoldersdatamanager.isInbox());
                }
                MessageFolder messagefolder;
                for (content = ((List) (obj)).listIterator(); content.hasNext(); content.set(messagefolder.buildUpon().folderName(getFolderName(messagefolder)).build()))
                {
                    messagefolder = (MessageFolder)content.next();
                }

                Collections.sort(((List) (obj)), new FolderComparator(Collator.getInstance(Locale.getDefault())));
                if (messagefoldersdatamanager != null)
                {
                    folderPosition = ((List) (obj)).indexOf(messagefoldersdatamanager);
                    if (folderPosition == -1)
                    {
                        folderPosition = 0;
                    }
                }
                if (allFolders.isEmpty())
                {
                    allFolders.clear();
                    allFolders.addAll(((Collection) (obj)));
                    content = allFolders.iterator();
                    while (content.hasNext()) 
                    {
                        obj = (MessageFolder)content.next();
                        if (((MessageFolder) (obj)).isInbox())
                        {
                            messagefoldersdatamanager = inputMessageId;
                        } else
                        {
                            messagefoldersdatamanager = null;
                        }
                        addTab(((MessageFolder) (obj)), messagefoldersdatamanager, null);
                    }
                } else
                {
                    incrementallyRefreshTabs(((List) (obj)));
                }
                tabAdapter.notifyDataSetChanged();
                tabAdapter.setPosition(folderPosition);
                if (inputMessageId != null && !filterType.equals(MessagesFilterType.FILTER_ALL))
                {
                    doFilter(MessagesFilterType.FILTER_ALL);
                }
                if (flag)
                {
                    inputMessageId = null;
                    return;
                }
                content = getCurrentFolderFragment();
                if (content != null)
                {
                    messagefoldersdatamanager = content.getSelectedMessage();
                    boolean flag1 = false;
                    boolean flag2 = false;
                    if (inputMessageId != null)
                    {
                        messagefoldersdatamanager = content.getAllMessages();
                        messagefoldersdatamanager = MessagesUtils.findById(inputMessageId, messagefoldersdatamanager);
                        flag1 = flag2;
                        if (messagefoldersdatamanager != null)
                        {
                            flag1 = true;
                        }
                        inputMessageId = null;
                    }
                    if (messagefoldersdatamanager != null)
                    {
                        notifyCurrentMessageChanged(messagefoldersdatamanager, flag1);
                        return;
                    }
                }
            }
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
        filterType = MessagesFilterType.FILTER_ALL;
        notifyFilterTypeChanged(MessagesFilterType.FILTER_ALL);
    }

    protected void onNotifyFilterTypeChanged(MessagesFilterType messagesfiltertype)
    {
        filterType = messagesfiltertype;
        setSpinnerSelectionProgramatically(messagesfiltertype.ordinal());
    }

    protected void onNotifyMessageSent()
    {
        super.onNotifyMessageSent();
        Object obj = MessagesUtils.findById(1L, getAllFolders());
        if (obj != null)
        {
            MessageFolderFragment messagefolderfragment = getFolderFragmentIfExists(((MessageFolder) (obj)));
            if (messagefolderfragment != null)
            {
                messagefolderfragment.invalidateData();
            } else
            {
                FwActivity fwactivity = getFwActivity();
                obj = new com.ebay.nautilus.domain.content.dm.MessageFolderContentsDataManager.KeyParams(((MessageFolder) (obj)));
                if (fwactivity != null)
                {
                    obj = (MessageFolderContentsDataManager)DataManager.getIfExists(fwactivity.getEbayContext(), ((com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams) (obj)));
                } else
                {
                    obj = null;
                }
                if (obj != null)
                {
                    ((MessageFolderContentsDataManager) (obj)).invalidateData();
                    return;
                }
            }
        }
    }

    protected void onNotifyShowTabHeadersChanged(boolean flag)
    {
        showTabHeaders(flag);
    }

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
label0:
        {
            if (i >= 0 && i < tabAdapter.getCount() && i != folderPosition)
            {
                if (isDraftInProgress())
                {
                    break label0;
                }
                handleTabChanged(i);
            }
            return;
        }
        (new Handler()).post(new Runnable() {

            final MessagesMasterFragment this$0;

            public void run()
            {
                tabAdapter.setPosition(folderPosition);
            }

            
            {
                this$0 = MessagesMasterFragment.this;
                super();
            }
        });
        promptFolderPosition = i;
        ComposeMessageFragment.showConfirmAbandonMessageDialogFragment(this, 0, null);
        notifyPaneActivated(MessagesBaseFragment.ActivePane.MESSAGES_DETAIL);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("currentFolderId", folderPosition);
    }

    public void onSizeChanged(int i, int j, int k, int l)
    {
        tabHostHeight = j;
        notifyTabHeadersHeightChanged(Integer.valueOf(j));
    }

    public void onTabReselected(int i)
    {
        MessageFolderFragment messagefolderfragment = getCurrentFolderFragment();
        if (messagefolderfragment != null)
        {
            messagefolderfragment.scrollToTop();
        }
    }

    public void refreshData()
    {
        int i;
        int j;
        if (tabAdapter == null)
        {
            i = 0;
        } else
        {
            i = tabAdapter.getCount();
        }
        for (j = 0; j < i; j++)
        {
            MessageFolderFragment messagefolderfragment = getFolderFragmentIfExists(j);
            if (messagefolderfragment != null)
            {
                messagefolderfragment.refreshData();
            }
        }

        messageFoldersDm.reloadData();
    }

    public void setInputMessageId(String s)
    {
        inputMessageId = s;
        refreshData(s);
    }

    public void setSpinnerSelectionProgramatically(int i)
    {
        userSelectedSpinnerChange = false;
        spinner.setSelection(i);
    }




/*
    static boolean access$202(MessagesMasterFragment messagesmasterfragment, boolean flag)
    {
        messagesmasterfragment.showTabHeaders = flag;
        return flag;
    }

*/



/*
    static boolean access$402(MessagesMasterFragment messagesmasterfragment, boolean flag)
    {
        messagesmasterfragment.isTabControlsAnimating = flag;
        return flag;
    }

*/



/*
    static Boolean access$502(MessagesMasterFragment messagesmasterfragment, Boolean boolean1)
    {
        messagesmasterfragment.requestShowTabControls = boolean1;
        return boolean1;
    }

*/

}
