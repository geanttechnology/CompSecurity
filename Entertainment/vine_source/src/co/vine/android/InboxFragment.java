// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.accounts.AccountManager;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import co.vine.android.api.VineRecipient;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.Session;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.provider.Vine;
import co.vine.android.util.ConversationMenuHelper;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.MuteUtil;
import co.vine.android.util.StringAnchorManager;
import co.vine.android.util.Util;
import co.vine.android.util.ViewUtil;
import co.vine.android.widget.ContactsMenuAdapter;
import co.vine.android.widget.SectionAdapter;
import co.vine.android.widget.Typefaces;
import co.vine.android.widgets.PromptDialogSupportFragment;
import com.edisonwang.android.slog.SLog;
import com.twitter.android.widget.RefreshableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            BaseCursorListFragment, Settings, MessageBoxAdapter, MenuUsersAdapter, 
//            BaseActionBarActivity, ContactEntry, ConversationActivity, OnContactEntryClickedListener, 
//            HomeTabActivity, PendingRequest, SortContactsTask

public class InboxFragment extends BaseCursorListFragment
    implements android.view.View.OnClickListener, com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnOpenedListener, com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnClosedListener
{
    public class ConversationMenuSessionListener extends AppSessionListener
    {

        final InboxFragment this$0;

        public void onGetConversationRowIdComplete(long l, long l1, String s, boolean flag)
        {
            if (l == mWaitingToStartId)
            {
                mWaitingToStartId = -1L;
                mAppController.clearUnreadMessageCount(l1);
                startActivity(ConversationActivity.getIntent(getActivity(), l1, s, l, flag, false));
            }
        }

        public void onGetMessageInboxComplete(String s, int i, String s1, int j)
        {
            s = removeRequest(s);
            if (s != null)
            {
                mLoadingMore = false;
                hideProgress(((PendingRequest) (s)).fetchType);
                InboxFragment.this.onGetMessageInboxComplete(j);
                switch (i)
                {
                default:
                    hideProgress(3);
                    if (((PendingRequest) (s)).fetchType != 3)
                    {
                        Util.showCenteredToast(getActivity(), 0x7f0e00cb);
                    }
                    SLog.e((new StringBuilder()).append("Error ").append(i).append(" - ").append(s1).toString());
                    break;

                case 200: 
                    break;
                }
            }
        }

        public void onGetUsersComplete(Session session, String s, int i, String s1, int j, ArrayList arraylist, int k, 
                int l, long l1)
        {
            session = removeRequest(s);
            if (session != null)
            {
                hideProgress(((PendingRequest) (session)).fetchType);
                switch (i)
                {
                default:
                    hideProgress(3);
                    SLog.e((new StringBuilder()).append("Error:  ").append(s1).toString());
                    break;

                case 200: 
                    break;
                }
            }
        }

        public void onPhotoImageLoaded(HashMap hashmap)
        {
            InboxFragment.this.onPhotoImageLoaded(hashmap);
        }

        public ConversationMenuSessionListener()
        {
            this$0 = InboxFragment.this;
            super();
        }
    }

    private class SortMenuContactsTask extends SortContactsTask
    {

        final InboxFragment this$0;

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ArrayList)obj);
        }

        protected void onPostExecute(ArrayList arraylist)
        {
            mSortMenuTask = null;
            mContactEntryMap = new HashMap();
            ContactEntry contactentry;
            for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); mContactEntryMap.put(Long.valueOf(contactentry.contactId), contactentry))
            {
                contactentry = (ContactEntry)iterator.next();
            }

            mContactEntries = arraylist;
            invalidateContactEntries();
        }

        private SortMenuContactsTask()
        {
            this$0 = InboxFragment.this;
            super();
        }

    }

    public class TabSwicher
        implements android.view.View.OnClickListener, Runnable
    {

        public final BaseAdapter targetAdapter;
        final InboxFragment this$0;

        public void onClick(View view)
        {
            if (mActiveAdapter != targetAdapter && !mIsSwitching)
            {
                mIsSwitching = true;
                mHandler.removeCallbacks(this);
                mHandler.postDelayed(this, 200L);
            }
        }

        public void run()
        {
            mActiveAdapter = targetAdapter;
            mListView.setAdapter(mActiveAdapter);
            mIsSwitching = false;
            invalidateAdapters();
        }

        public TabSwicher(BaseAdapter baseadapter)
        {
            this$0 = InboxFragment.this;
            super();
            targetAdapter = baseadapter;
        }
    }


    protected static final int FETCH_FLAG_BOTH = 3;
    protected static final int FETCH_FLAG_FRIENDS = 2;
    protected static final int FETCH_FLAG_INBOX = 1;
    protected static final int FETCH_FLAG_OTHERS = 4;
    protected static final int LOADER_ID_CONTACTS = 3;
    protected static final int LOADER_ID_FRIENDS = 2;
    protected static final int LOADER_ID_INBOX = 1;
    protected static final int LOADER_ID_OTHERS = 4;
    protected static final int VIEW_TYPE_CONTACTS = 3;
    protected static final int VIEW_TYPE_FRIENDS = 2;
    protected static final int VIEW_TYPE_MESSAGES = 1;
    private BaseAdapter mActiveAdapter;
    private ContactsMenuAdapter mAddressAdapter;
    private Cursor mAddressCursor;
    private StringAnchorManager mAnchorManager;
    private int mColor;
    private final BroadcastReceiver mColorChangedReceiver = new BroadcastReceiver() {

        final InboxFragment this$0;

        public void onReceive(Context context, Intent intent)
        {
            int i = Util.getDefaultSharedPrefs(getActivity()).getInt("profile_background", Settings.DEFAULT_PROFILE_COLOR);
            ((ConversationMenuHelper)((BaseActionBarActivity)getActivity()).getSlidingMenuHelper()).setPersonalizedColor(i);
        }

            
            {
                this$0 = InboxFragment.this;
                super();
            }
    };
    private ArrayList mContactEntries;
    private HashMap mContactEntryMap;
    private long mCurrentLastId;
    private MessageBoxAdapter mDummyAdapter;
    private ImageView mEmptyImage;
    private TextView mEmptyTitle;
    private View mEmptyView;
    private TextView mEmptyWords;
    protected int mFetchFlags;
    private MenuUsersAdapter mFriendsAdapter;
    private TextView mFriendsText;
    protected MessageBoxAdapter mInboxAdapter;
    private int mInboxCursorCount;
    private final Runnable mInvalidateContactEntryRunnable = new Runnable() {

        final InboxFragment this$0;

        public void run()
        {
            if (mActiveAdapter != mSectionAdapter) goto _L2; else goto _L1
_L1:
            boolean flag;
            int i;
            i = mListView.getLastVisiblePosition();
            flag = true;
            if (i != mListView.getCount() - 1) goto _L4; else goto _L3
_L3:
            int j;
            i = mListView.getChildAt(i).getBottom();
            j = mListView.getHeight();
            if (i > j) goto _L4; else goto _L5
_L5:
            flag = true;
_L6:
            boolean flag1 = false;
            boolean flag2 = mInboxAdapter.isEmpty();
            flag1 = flag2;
_L7:
            if (mIsAddressBookShowing || isFetched(1) && flag1 || isFetched(3) && flag)
            {
                addEntriesToAddressAdapter();
            }
_L2:
            return;
_L4:
            flag = false;
              goto _L6
            Exception exception;
            exception;
            SLog.e("Cannot get listview state.");
              goto _L6
            exception;
            CrashUtil.logException(exception);
              goto _L7
        }

            
            {
                this$0 = InboxFragment.this;
                super();
            }
    };
    private final Runnable mInvalidateEmptyViewRunnable = new Runnable() {

        final InboxFragment this$0;

        public void run()
        {
            if (mActiveAdapter != mSectionAdapter) goto _L2; else goto _L1
_L1:
            if (mInboxCursorCount != 0) goto _L4; else goto _L3
_L3:
            if (!mIsEmptyViewAdded)
            {
                SLog.d("Header change: Add.");
                mIsEmptyViewAdded = true;
                mListView.addHeaderView(mEmptyView);
            }
_L6:
            return;
_L4:
            if (!mIsEmptyViewAdded) goto _L6; else goto _L5
_L5:
            SLog.d("Header change: Remove.");
            mIsEmptyViewAdded = false;
            mListView.removeHeaderView(mEmptyView);
            return;
_L2:
            if (mOthersCursorCount != 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (mIsEmptyViewAdded) goto _L6; else goto _L7
_L7:
            SLog.d("Header change: Add.");
            mIsEmptyViewAdded = true;
            mListView.addHeaderView(mEmptyView);
            return;
            if (!mIsEmptyViewAdded) goto _L6; else goto _L8
_L8:
            SLog.d("Header change: Remove.");
            mIsEmptyViewAdded = false;
            mListView.removeHeaderView(mEmptyView);
            return;
        }

            
            {
                this$0 = InboxFragment.this;
                super();
            }
    };
    private boolean mIsAddressBookShowing;
    private boolean mIsEmptyViewAdded;
    private boolean mIsSwitching;
    private final OnContactEntryClickedListener mListener = new OnContactEntryClickedListener() {

        final InboxFragment this$0;

        protected void onContactEntryClicked(ContactEntry contactentry, VineRecipient vinerecipient, int i, String s)
        {
            if (mWaitingToStartId == -1L)
            {
                mWaitingToStartId = vinerecipient.contactId;
                mAppController.fetchConversationRowIdFromSingleRecipient(vinerecipient, 1);
            }
        }

            
            {
                this$0 = InboxFragment.this;
                super();
            }
    };
    private boolean mLoadingMore;
    protected long mMessageCount;
    private MessageBoxAdapter mOtherAdapter;
    private int mOthersCursorCount;
    private TextView mOthersText;
    private SectionAdapter mSectionAdapter;
    private SortMenuContactsTask mSortMenuTask;
    private Typefaces mTypefaces;
    private int mUnReadCount;
    protected long mWaitingToStartId;

    public InboxFragment()
    {
        mWaitingToStartId = -1L;
        mLoadingMore = false;
    }

    private void invalidateAdapters()
    {
        if (mActiveAdapter == mOtherAdapter)
        {
            mFriendsText.setTextColor(0x5a000000);
            mOthersText.setTextColor(0xff333333);
            mFriendsText.setTypeface(mTypefaces.mediumContent);
            mOthersText.setTypeface(mTypefaces.boldContent);
            mCursorAdapter = null;
            mEmptyWords.setText(0x7f0e0280);
            mEmptyImage.setImageResource(0x7f020293);
            mEmptyTitle.setVisibility(8);
            ViewUtil.setBackground(mListView, null);
        } else
        {
            mOthersText.setTextColor(0x5a000000);
            mFriendsText.setTextColor(0xff333333);
            mOthersText.setTypeface(mTypefaces.mediumContent);
            mFriendsText.setTypeface(mTypefaces.boldContent);
            mCursorAdapter = mFriendsAdapter;
            mEmptyTitle.setVisibility(0);
            mEmptyWords.setText(0x7f0e0279);
            mEmptyImage.setImageResource(0x7f02028c);
            mListView.setBackgroundColor(getResources().getColor(0x7f090082));
        }
        invalidateEmptyView(true);
    }

    private void invalidateContactEntries()
    {
        mHandler.removeCallbacks(mInvalidateContactEntryRunnable);
        mHandler.postDelayed(mInvalidateContactEntryRunnable, 100L);
    }

    private void invalidateEmptyView(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        mHandler.removeCallbacks(mInvalidateEmptyViewRunnable);
        if (!flag) goto _L2; else goto _L1
_L1:
        mInvalidateEmptyViewRunnable.run();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mHandler.postDelayed(mInvalidateEmptyViewRunnable, 100L);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void invalidateUnreadCount()
    {
        String s = null;
        if (mUnReadCount > 0)
        {
            if (mUnReadCount > 20)
            {
                s = "20+";
            } else
            {
                s = String.valueOf(mUnReadCount);
            }
        }
        if (mOthersText != null)
        {
            String s1 = mOthersText.getText().toString();
            int i = s1.indexOf("(");
            if (s != null)
            {
                TextView textview = mOthersText;
                StringBuilder stringbuilder = new StringBuilder();
                if (i != -1)
                {
                    s1 = s1.substring(0, i - 1);
                }
                textview.setText(stringbuilder.append(s1).append(" (").append(s).append(") ").toString());
            } else
            if (i != -1)
            {
                mOthersText.setText(s1.substring(0, i - 1));
                return;
            }
        }
    }

    public void addEntriesToAddressAdapter()
    {
        if (mContactEntries != null)
        {
            SLog.d("Showing address book: {}.", Integer.valueOf(mContactEntries.size()));
            mIsAddressBookShowing = true;
            if (mAddressAdapter.getCount() != mContactEntries.size())
            {
                mAddressAdapter.clear();
                mAddressAdapter.addAll(mContactEntries);
            }
            makeSadFaceHeaderView();
        }
    }

    public View createView(LayoutInflater layoutinflater, int i, ViewGroup viewgroup)
    {
        viewgroup = super.createView(layoutinflater, i, viewgroup);
        View view = getActivity().getLayoutInflater().inflate(0x7f030058, mListView, false);
        mFriendsText = (TextView)view.findViewById(0x7f0a0126);
        mOthersText = (TextView)view.findViewById(0x7f0a0127);
        mListView.addHeaderView(view, null, false);
        mEmptyView = layoutinflater.inflate(0x7f0300a6, null);
        mEmptyImage = (ImageView)mEmptyView.findViewById(0x7f0a00e3);
        mEmptyWords = (TextView)mEmptyView.findViewById(0x7f0a0235);
        mEmptyTitle = (TextView)mEmptyView.findViewById(0x7f0a0234);
        return viewgroup;
    }

    protected void fetchContent(int i, int j, boolean flag)
    {
        if (!hasPendingRequest(i)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        i;
        JVM INSTR tableswitch 1 4: default 40
    //                   1 164
    //                   2 158
    //                   3 152
    //                   4 158;
           goto _L3 _L4 _L5 _L6 _L5
_L4:
        break MISSING_BLOCK_LABEL_164;
_L6:
        break; /* Loop/switch isn't completed */
_L3:
        int k = 1;
_L8:
        if (k == 3 && j == 1)
        {
            mLoadingMore = true;
        }
        if ((j & 4) != 0)
        {
            setFetched(4);
            addRequest(mAppController.fetchConversations(k, false, 2), i);
        }
        if ((j & 1) != 0)
        {
            setFetched(1);
            addRequest(mAppController.fetchConversations(k, false, 1), i);
        }
        if ((j & 2) != 0)
        {
            setFetched(2);
            addRequest(mAppController.fetchFriends(k, 1), i);
        }
        if (!flag)
        {
            showProgress(i);
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
        k = 1;
          goto _L8
_L5:
        k = 1;
          goto _L8
        k = 3;
          goto _L8
    }

    protected boolean isFetched(int i)
    {
        return (mFetchFlags & i) != 0;
    }

    public boolean isLoadingMore()
    {
        return mLoadingMore;
    }

    public void onActivityCreated(Bundle bundle)
    {
        int i;
label0:
        {
            super.onActivityCreated(bundle);
            mTypefaces = Typefaces.get(getActivity());
            int j = Util.getDefaultSharedPrefs(getActivity()).getInt("profile_background", Settings.DEFAULT_PROFILE_COLOR);
            if (j != Settings.DEFAULT_PROFILE_COLOR)
            {
                i = j;
                if (j > 0)
                {
                    break label0;
                }
            }
            i = 0xffffff & getResources().getColor(0x7f090096);
        }
        if (mInboxAdapter == null)
        {
            mInboxAdapter = new MessageBoxAdapter(getActivity(), mAppController, this, 0);
        }
        if (mDummyAdapter == null)
        {
            mDummyAdapter = new MessageBoxAdapter(getActivity(), mAppController, this, 0);
        }
        if (mFriendsAdapter == null)
        {
            mFriendsAdapter = new MenuUsersAdapter(getActivity(), mAppController, 0);
            mFriendsAdapter.setInboxAdapter(mInboxAdapter);
        }
        if (mAddressAdapter == null)
        {
            mAddressAdapter = new ContactsMenuAdapter(getActivity());
        }
        if (mOtherAdapter == null)
        {
            mOtherAdapter = new MessageBoxAdapter(getActivity(), mAppController, this, 0);
        }
        bundle = mInboxAdapter;
        MenuUsersAdapter menuusersadapter = mFriendsAdapter;
        ContactsMenuAdapter contactsmenuadapter = mAddressAdapter;
        mSectionAdapter = new SectionAdapter(null, null, new int[] {
            0, 0, 0
        }, new BaseAdapter[] {
            bundle, menuusersadapter, contactsmenuadapter
        }, 0x7f030059, 1);
        mFriendsText.setOnClickListener(new TabSwicher(mSectionAdapter));
        mOthersText.setOnClickListener(new TabSwicher(mOtherAdapter));
        mActiveAdapter = mSectionAdapter;
        mListView.setAdapter(mActiveAdapter);
        mListView.setOnScrollListener(this);
        ((RefreshableListView)mListView).colorizePTR(0xff000000 | i);
        mAnchorManager = Vine.getUserSectionsAnchorManager(getActivity(), 1);
        invalidateAdapters();
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131362060 2131362060: default 24
    //                   2131362060 25;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (!hasPendingRequest(1))
        {
            view.findViewById(0x7f0a010d).setVisibility(8);
            view.findViewById(0x7f0a00b2).setVisibility(0);
            mMessageCount = mMessageCount + 10L;
            restartLoader(1);
            fetchContent(1, 1, true);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onClosed()
    {
        mMessageCount = 10L;
        mAppController.clearInboxPageCursors();
        mListView.setSelectionFromTop(0, 0);
        FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity != null)
        {
            restartLoader();
            ((ConversationMenuHelper)((BaseActionBarActivity)fragmentactivity).getSlidingMenuHelper()).toggleContactSearch(false);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mAppSessionListener = new ConversationMenuSessionListener();
        mMessageCount = 10L;
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        switch (i)
        {
        default:
            bundle = co.vine.android.provider.Vine.InboxView.CONTENT_URI.buildUpon().appendQueryParameter("hidden", "0");
            if (i == 4)
            {
                i = 2;
            } else
            {
                i = 1;
            }
            bundle = bundle.appendQueryParameter("network_type", String.valueOf(i)).appendQueryParameter("limit", String.valueOf(mMessageCount)).build();
            return new CursorLoader(getActivity(), bundle, co.vine.android.provider.VineDatabaseSQL.InboxQuery.PROJECTION, null, null, null);

        case 2: // '\002'
            bundle = ContentUris.withAppendedId(co.vine.android.provider.Vine.UserGroupsView.CONTENT_URI_FRIENDS, mAppController.getActiveId());
            return new CursorLoader(getActivity(), bundle, co.vine.android.provider.VineDatabaseSQL.UsersQuery.PROJECTION, "section_type=1", null, "last_section_refresh DESC, section_index ASC");

        case 3: // '\003'
            return new CursorLoader(getActivity(), ContactEntry.sUri, ContactEntry.sProjection, "mimetype=? OR mimetype=?", ContactEntry.sSelectionArgs, "contact_id ASC ");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return createView(layoutinflater, 0x7f030047, viewgroup);
    }

    protected void onGetMessageInboxComplete(int i)
    {
        if (mActiveAdapter == mSectionAdapter)
        {
            if (i == 0)
            {
                invalidateContactEntries();
            } else
            {
                mAddressAdapter.clear();
                mIsAddressBookShowing = false;
                mAddressAdapter.notifyDataSetChanged();
            }
        }
        invalidateEmptyView(false);
    }

    public void onInboxCursorClicked(Cursor cursor, View view)
    {
        boolean flag = true;
        if (TextUtils.isEmpty(cursor.getString(15)) || cursor.getInt(14) <= 1)
        {
            long l = cursor.getLong(1);
            view = cursor.getString(8);
            long l1;
            if (cursor.getInt(11) != 1)
            {
                flag = false;
            }
            l1 = cursor.getLong(10);
            startActivity(ConversationActivity.getIntent((BaseActionBarActivity)getActivity(), l, view, l1, flag, false));
            return;
        } else
        {
            mAppController.retryMessagesInConversationRowId(cursor.getLong(1));
            ((TextView)view.findViewById(0x7f0a0108)).setText(0x7f0e0142);
            view.findViewById(0x7f0a010a).setVisibility(8);
            view.findViewById(0x7f0a010b).setVisibility(0);
            return;
        }
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
        i -= mListView.getHeaderViewsCount();
        if (i < 0) goto _L2; else goto _L1
_L1:
        if (mActiveAdapter != mSectionAdapter)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        mSectionAdapter.getItemViewType(i);
        JVM INSTR tableswitch 1 3: default 60
    //                   1 61
    //                   2 78
    //                   3 106;
           goto _L2 _L3 _L4 _L5
_L2:
        return;
_L3:
        onInboxCursorClicked((Cursor)mSectionAdapter.getItem(i), view);
        return;
_L4:
        if (mWaitingToStartId == -1L)
        {
            mWaitingToStartId = l;
            mAppController.fetchConversationRowIdFromUserRemoteId(l, 1);
            return;
        }
        if (true) goto _L2; else goto _L5
_L5:
        mListener.onClick(this, (ContactEntry)mContactEntryMap.get(Long.valueOf(l)));
        return;
        onInboxCursorClicked((Cursor)mOtherAdapter.getItem(i), view);
        return;
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        loader.getId();
        JVM INSTR tableswitch 1 4: default 36
    //                   1 233
    //                   2 67
    //                   3 249
    //                   4 179;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        SLog.d("Load finished: {}.", Integer.valueOf(loader.getId()));
        invalidateEmptyView(false);
        if (loader.getId() != 3)
        {
            invalidateContactEntries();
        }
        return;
_L3:
        Cursor cursor1 = mFriendsAdapter.getCursor();
        if (cursor1 != null)
        {
            cursor1.unregisterContentObserver(mChangeObserver);
        }
        if (cursor != null)
        {
            cursor.registerContentObserver(mChangeObserver);
            if (cursor.moveToLast())
            {
                mCurrentLastId = cursor.getLong(1);
                cursor.moveToFirst();
            }
        }
        mFriendsAdapter.swapCursor(cursor);
        if (mFriendsAdapter.isEmpty() && !isFetched(2))
        {
            fetchContent(3, 2, true);
        } else
        {
            makeSadFaceHeaderView();
            hideProgress(3);
        }
        continue; /* Loop/switch isn't completed */
_L5:
        mUnReadCount = 0;
        if (cursor != null && cursor.moveToFirst())
        {
            do
            {
                mUnReadCount = mUnReadCount + cursor.getInt(4);
            } while (cursor.moveToNext());
            cursor.moveToFirst();
        }
        invalidateUnreadCount();
_L2:
        if (cursor != null)
        {
            onLoadMessageBoxComplete(loader.getId(), cursor);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        Cursor cursor2 = mAddressCursor;
        if (cursor2 != null)
        {
            cursor2.unregisterContentObserver(mChangeObserver);
        }
        if (cursor != null)
        {
            cursor.registerContentObserver(mChangeObserver);
        }
        if (cursor != null)
        {
            mAddressCursor = cursor;
            if (mSortMenuTask == null)
            {
                mSortMenuTask = new SortMenuContactsTask();
                mSortMenuTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Cursor[] {
                    mAddressCursor
                });
            }
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    public void onLoadMessageBoxComplete(int i, Cursor cursor)
    {
        MessageBoxAdapter messageboxadapter;
        Cursor cursor1;
        byte byte0;
        if (i == 4)
        {
            messageboxadapter = mOtherAdapter;
        } else
        {
            messageboxadapter = mInboxAdapter;
        }
        if (i == 4)
        {
            byte0 = 4;
        } else
        {
            byte0 = 1;
        }
        cursor1 = messageboxadapter.getCursor();
        if (cursor != null)
        {
            if (i == 4)
            {
                mOthersCursorCount = cursor.getCount();
            } else
            {
                mInboxCursorCount = cursor.getCount();
            }
            if (cursor1 != null)
            {
                cursor1.unregisterContentObserver(mChangeObserver);
            }
            cursor.registerContentObserver(mChangeObserver);
        }
        messageboxadapter.swapCursor(cursor);
        if (messageboxadapter.isEmpty())
        {
            if (!isFetched(byte0))
            {
                fetchContent(3, byte0, true);
                return;
            } else
            {
                showSadface(true);
                return;
            }
        } else
        {
            hideProgress(3);
            return;
        }
    }

    public void onOpened()
    {
        FragmentActivity fragmentactivity;
        AccountManager accountmanager;
        android.accounts.Account account;
        PromptDialogSupportFragment promptdialogsupportfragment;
        fragmentactivity = getActivity();
        if (!(fragmentactivity instanceof HomeTabActivity))
        {
            break MISSING_BLOCK_LABEL_142;
        }
        if (!MuteUtil.isMuted(fragmentactivity))
        {
            fragmentactivity.sendBroadcast(new Intent(MuteUtil.ACTION_CHANGED_TO_MUTE), "co.vine.android.BROADCAST");
        }
        accountmanager = AccountManager.get(fragmentactivity);
        account = VineAccountHelper.getActiveAccount(fragmentactivity);
        if (account == null || Util.getDefaultSharedPrefs(fragmentactivity).getBoolean("vmOnboardInProgress", false) || !VineAccountHelper.shouldShowStoreContactsPrompt(accountmanager, account))
        {
            break MISSING_BLOCK_LABEL_142;
        }
        promptdialogsupportfragment = PromptDialogSupportFragment.newInstance(1);
        promptdialogsupportfragment.setListener((HomeTabActivity)fragmentactivity);
        promptdialogsupportfragment.setMessage(0x7f0e0234);
        promptdialogsupportfragment.setTitle(0x7f0e0233);
        promptdialogsupportfragment.setNegativeButton(0x7f0e014d);
        promptdialogsupportfragment.setPositiveButton(0x7f0e0163);
        promptdialogsupportfragment.show(((HomeTabActivity)fragmentactivity).getSupportFragmentManager());
        VineAccountHelper.setDidShowStoreContactsPrompt(accountmanager, account);
        return;
        Exception exception;
        exception;
        CrashUtil.logException(exception, "Failed to show contact agreement box. ", new Object[0]);
        return;
    }

    public void onPause()
    {
        super.onPause();
        getActivity().unregisterReceiver(mColorChangedReceiver);
    }

    public void onPhotoImageLoaded(HashMap hashmap)
    {
        if (mInboxAdapter != null)
        {
            mInboxAdapter.setUserImages(hashmap);
        }
        if (mFriendsAdapter != null)
        {
            mFriendsAdapter.setUserImages(hashmap);
        }
        if (mOtherAdapter != null)
        {
            mOtherAdapter.setUserImages(hashmap);
        }
    }

    public void onResume()
    {
        super.onResume();
        if (mInboxAdapter.getCursor() == null)
        {
            initLoader(1);
        } else
        if (mInboxAdapter.isEmpty() && !isFetched(1))
        {
            fetchContent(3, 1, false);
        }
        if (mOtherAdapter.getCursor() == null)
        {
            initLoader(4);
        } else
        if (mOtherAdapter.isEmpty() && !isFetched(4))
        {
            fetchContent(3, 4, false);
        }
        if (mFriendsAdapter.getCursor() == null)
        {
            initLoader(2);
        } else
        if (mFriendsAdapter.isEmpty() && !isFetched(2))
        {
            fetchContent(3, 3, false);
        }
        if (mAddressCursor == null)
        {
            initLoader(3);
        }
        getActivity().registerReceiver(mColorChangedReceiver, Util.COLOR_CHANGED_INTENT_FILTER, "co.vine.android.BROADCAST", null);
    }

    protected void onScrollLastItem(Cursor cursor)
    {
label0:
        {
            if (mActiveAdapter == mSectionAdapter)
            {
                if (!mAnchorManager.haveMore())
                {
                    break label0;
                }
                fetchContent(1, 2, false);
            }
            return;
        }
        if (!mIsAddressBookShowing)
        {
            addEntriesToAddressAdapter();
        }
        hideProgress(3);
    }

    protected void refresh()
    {
        if (mActiveAdapter == mSectionAdapter)
        {
            fetchContent(2, 3, false);
            return;
        } else
        {
            fetchContent(2, 4, false);
            return;
        }
    }

    protected void setFetched(int i)
    {
        mFetchFlags = mFetchFlags | i;
    }

    public void setPersonalizedColor(int i)
    {
        int j;
label0:
        {
            mColor = i;
            if (i != Settings.DEFAULT_PROFILE_COLOR)
            {
                j = i;
                if (i > 0)
                {
                    break label0;
                }
            }
            j = 0xffffff & getResources().getColor(0x7f090096);
        }
        if (mListView != null)
        {
            ((RefreshableListView)mListView).colorizePTR(0xff000000 | j);
        }
    }




/*
    static HashMap access$1002(InboxFragment inboxfragment, HashMap hashmap)
    {
        inboxfragment.mContactEntryMap = hashmap;
        return hashmap;
    }

*/


/*
    static BaseAdapter access$102(InboxFragment inboxfragment, BaseAdapter baseadapter)
    {
        inboxfragment.mActiveAdapter = baseadapter;
        return baseadapter;
    }

*/


/*
    static ArrayList access$1102(InboxFragment inboxfragment, ArrayList arraylist)
    {
        inboxfragment.mContactEntries = arraylist;
        return arraylist;
    }

*/




/*
    static boolean access$1402(InboxFragment inboxfragment, boolean flag)
    {
        inboxfragment.mLoadingMore = flag;
        return flag;
    }

*/





/*
    static boolean access$402(InboxFragment inboxfragment, boolean flag)
    {
        inboxfragment.mIsEmptyViewAdded = flag;
        return flag;
    }

*/





/*
    static boolean access$702(InboxFragment inboxfragment, boolean flag)
    {
        inboxfragment.mIsSwitching = flag;
        return flag;
    }

*/



/*
    static SortMenuContactsTask access$902(InboxFragment inboxfragment, SortMenuContactsTask sortmenucontactstask)
    {
        inboxfragment.mSortMenuTask = sortmenucontactstask;
        return sortmenucontactstask;
    }

*/
}
