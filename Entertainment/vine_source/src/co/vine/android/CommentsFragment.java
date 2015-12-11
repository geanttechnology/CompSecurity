// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.view.ActionMode;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import co.vine.android.api.VineComment;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.provider.VineSuggestionsProvider;
import co.vine.android.service.PendingAction;
import co.vine.android.util.Util;
import co.vine.android.widget.ConversationList;
import co.vine.android.widget.PopupEditText;
import co.vine.android.widget.SpanClickListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            BaseArrayListFragment, ComposeFilter, CommentViewHolder, ProfileActivity, 
//            UsersAutoCompleteAdapter, TagsAutoCompleteAdapter, HashtagActivity, ComposeTokenizer, 
//            CommentsAdapter, PendingRequestHelper

public class CommentsFragment extends BaseArrayListFragment
    implements SpanClickListener, android.view.View.OnClickListener, android.widget.AdapterView.OnItemLongClickListener, android.widget.AdapterView.OnItemClickListener, android.widget.TextView.OnEditorActionListener, Filterable, co.vine.android.widget.PopupEditText.PopupEditTextListener, co.vine.android.widget.ConversationList.GetMoreListener, TextWatcher
{
    class CommentsAppSessionListener extends AppSessionListener
    {

        final CommentsFragment this$0;

        public void onCaptchaRequired(String s, String s1, PendingAction pendingaction)
        {
            if (removeRequest(s) != null)
            {
                mPendingRequestHelper.onCaptchaRequired(getActivity(), s, pendingaction.actionCode, pendingaction.bundle, s1);
            }
        }

        public void onDeleteCommentComplete(String s, int i, String s1, long l)
        {
            if (removeRequest(s) != null && i == 200)
            {
                ((CommentsAdapter)mAdapter).deleteComment(l);
                if (mAdapter.getCount() == 0)
                {
                    showSadface(true, false);
                }
            }
        }

        public void onGetCommentsComplete(String s, int i, String s1, int j, long l, ArrayList arraylist)
        {
            if (removeRequest(s) != null)
            {
                hideProgress(3);
                if (arraylist == null || arraylist.size() == 0)
                {
                    if (i != 200)
                    {
                        mEmptyText.setText(0x7f0e00d9);
                    }
                    showSadface(true, false);
                } else
                {
                    showSadface(false);
                }
                if (i == 200)
                {
                    mNextPage = j;
                    mAnchor = l;
                    saveTopItemInfo();
                    s = (CommentsAdapter)mAdapter;
                    s.mergeComments(arraylist);
                    j = s.getPositionForId(mLastTopItemId);
                    mListView.setSelectionFromTop(mListView.getHeaderViewsCount() + j, mLastTopItemPixelOffset);
                }
                if (mFetched && (mNextPage <= 0 || arraylist == null || arraylist.size() == 0))
                {
                    ((ConversationList)mListView).deactivateRefresh();
                }
                if (i != 200)
                {
                    ((ConversationList)mListView).deactivateRefresh();
                }
            }
        }

        public void onGetTagTypeAheadComplete(String s, int i, String s1, String s2, ArrayList arraylist)
        {
            if (removeRequest(s) != null && i == 200 && !arraylist.isEmpty())
            {
                VineSuggestionsProvider.addRealtimeTagSuggestions(s2, arraylist);
                mEdit.performFilter(false);
            }
        }

        public void onGetUserTypeAheadComplete(String s, int i, String s1, String s2, ArrayList arraylist)
        {
            if (removeRequest(s) != null && i == 200 && !arraylist.isEmpty())
            {
                VineSuggestionsProvider.addRealtimeUserSuggestions(s2, arraylist);
                mEdit.performFilter(false);
            }
        }

        public void onPhotoImageLoaded(HashMap hashmap)
        {
            super.onPhotoImageLoaded(hashmap);
            ((CommentsAdapter)mAdapter).updateProfileImages(hashmap);
            mUsersAdapter.setUserImages(hashmap);
        }

        public void onPostCommentComplete(String s, int i, String s1, long l, String s2, VineComment vinecomment)
        {
label0:
            {
                dismissDialog();
                if (removeRequest(s) != null && l == mPostId)
                {
                    s = mListView;
                    s.post(s. new Runnable() {

                        final CommentsAppSessionListener this$1;
                        final ListView val$listView;

                        public void run()
                        {
                            listView.setSelection(listView.getCount() - 1);
                        }

            
            {
                this$1 = final_commentsappsessionlistener;
                listView = ListView.this;
                super();
            }
                    });
                    if (i == 200)
                    {
                        break label0;
                    }
                    mEdit.setText(s2);
                }
                return;
            }
            ((CommentsAdapter)mAdapter).addMyComment(vinecomment);
            showSadface(false);
        }

        CommentsAppSessionListener()
        {
            this$0 = CommentsFragment.this;
            super();
        }
    }


    public static final String ARG_HIDE_KEYBOARD = "hide_keyboard";
    public static final String ARG_POST_AUTHOR_ID = "post_author_id";
    public static final String ARG_POST_ID = "post_id";
    public static final int DEFAULT_PAGE_SIZE = 20;
    private static final String EVENT_SOURCE_TITLE = "Comments List";
    private static final int MAX_CHARS = 140;
    private static final String STATE_FETCHED = "fetched";
    private static ActionMode mActionMode;
    private static String mSelectedCommentId;
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat();
    private final android.support.v7.view.ActionMode.Callback mActionModeCallback = new android.support.v7.view.ActionMode.Callback() {

        final CommentsFragment this$0;

        public boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem)
        {
            addRequest(mAppController.deleteComment(mPostId, CommentsFragment.mSelectedCommentId));
            actionmode.finish();
            return true;
        }

        public boolean onCreateActionMode(ActionMode actionmode, Menu menu)
        {
            actionmode.getMenuInflater().inflate(0x7f100001, menu);
            return true;
        }

        public void onDestroyActionMode(ActionMode actionmode)
        {
            if (mSelectedView != null)
            {
                mSelectedView.setSelected(false);
            }
            CommentsFragment.mActionMode = null;
        }

        public boolean onPrepareActionMode(ActionMode actionmode, Menu menu)
        {
            return false;
        }

            
            {
                this$0 = CommentsFragment.this;
                super();
            }
    };
    private long mAnchor;
    private PopupEditText mEdit;
    private boolean mFetched;
    private Filter mFilter;
    private long mLastTopItemId;
    private int mLastTopItemPixelOffset;
    private int mNextPage;
    private long mPostAuthorId;
    private long mPostId;
    private View mSelectedView;
    private ImageView mSendButton;
    private TagsAutoCompleteAdapter mTagsAdapter;
    private ComposeTokenizer mTokenizer;
    private CursorAdapter mTypeaheadAdapter;
    private UsersAutoCompleteAdapter mUsersAdapter;

    public CommentsFragment()
    {
        mLastTopItemId = -1L;
        mLastTopItemPixelOffset = 0;
        mAnchor = 0L;
        mNextPage = 1;
    }

    private int editTextLength()
    {
        return mEdit.getText().toString().trim().length();
    }

    private void fetchContent()
    {
        if (hasPendingRequest())
        {
            return;
        } else
        {
            mFetched = true;
            addRequest(mAppController.fetchComments(mPostId, mNextPage, mAnchor, 20));
            return;
        }
    }

    private void insertText(String s)
    {
        if (mEdit != null)
        {
            int i = mEdit.getSelectionStart();
            int j = mEdit.getSelectionEnd();
            if (mEdit.getText() != null && i >= 0 && j <= mEdit.length())
            {
                mEdit.getText().replace(i, j, s);
            }
        }
    }

    private void saveTopItemInfo()
    {
        if (mAdapter.getCount() != 0)
        {
            mLastTopItemId = mAdapter.getItemId(mListView.getFirstVisiblePosition());
            View view = mListView.getChildAt(mListView.getFirstVisiblePosition() + mListView.getHeaderViewsCount());
            if (view != null)
            {
                mLastTopItemPixelOffset = view.getTop();
                return;
            }
        }
    }

    private void sendComment()
    {
        if (editTextLength() > 140)
        {
            Util.showTopToast(getActivity(), 0x7f0e0063);
            return;
        } else
        {
            postComment(mEdit);
            Util.setSoftKeyboardVisibility(getActivity(), mEdit, false);
            mEdit.clearFocus();
            return;
        }
    }

    private boolean validate(EditText edittext)
    {
        return edittext != null && edittext.length() > 0;
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public Filter getFilter()
    {
        if (mFilter == null)
        {
            mFilter = new ComposeFilter(this, mAppController.getActiveId());
        }
        return mFilter;
    }

    public void getMore()
    {
        fetchContent();
    }

    public CursorAdapter getPopupAdapter()
    {
        return mTypeaheadAdapter;
    }

    public void hideProgress(int i)
    {
        super.hideProgress(i);
        if (i == 1)
        {
            ((ConversationList)mListView).hideProgress();
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (!getArguments().getBoolean("hide_keyboard", false))
        {
            mEdit.requestFocus();
            Util.setSoftKeyboardVisibility(getActivity(), mEdit, true);
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            view = (CommentViewHolder)view.getTag();
            ProfileActivity.start(getActivity(), ((CommentViewHolder) (view)).userId, "Comments List");
            return;

        case 2131361922: 
            sendComment();
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        DATE_FORMAT.applyPattern(getResources().getString(0x7f0e00ab));
        if (bundle != null && bundle.containsKey("fetched"))
        {
            mFetched = bundle.getBoolean("fetched");
        }
        mAppSessionListener = new CommentsAppSessionListener();
        mUsersAdapter = new UsersAutoCompleteAdapter(getActivity(), mAppController);
        mTagsAdapter = new TagsAutoCompleteAdapter(getActivity(), mAppController);
        mTypeaheadAdapter = mTagsAdapter;
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(0x7f100002, menu);
        super.onCreateOptionsMenu(menu, menuinflater);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return createView(layoutinflater, 0x7f030026, viewgroup);
    }

    public void onDestroy()
    {
        super.onDestroy();
        VineSuggestionsProvider.clearRealtimeUserSuggestions();
        VineSuggestionsProvider.clearRealtimeTagSuggestions();
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        switch (textview.getId())
        {
        default:
            return false;

        case 2131361923: 
            break;
        }
        if (i == 4)
        {
            sendComment();
        }
        return true;
    }

    public void onFiltering(CharSequence charsequence)
    {
        boolean flag1 = true;
        boolean flag = true;
        if (!TextUtils.isEmpty(charsequence))
        {
            charsequence = charsequence.toString();
            String s;
            int i;
            if (charsequence.startsWith("@"))
            {
                s = "mention";
                charsequence = charsequence.substring(1, charsequence.length());
            } else
            if (charsequence.startsWith("#"))
            {
                s = "tag";
                charsequence = charsequence.substring(1, charsequence.length());
            } else
            {
                s = null;
                charsequence = null;
            }
            i = mAppController.getTypeaheadFetchThreshold(s);
            if (!TextUtils.isEmpty(charsequence) && charsequence.length() >= i)
            {
                if ("mention".equals(s))
                {
                    if (VineSuggestionsProvider.getRealtimeUserSuggestions(charsequence) != null)
                    {
                        flag = false;
                    }
                } else
                if ("tag".equals(s))
                {
                    if (VineSuggestionsProvider.getRealtimeTagSuggestions(charsequence) == null)
                    {
                        flag = flag1;
                    } else
                    {
                        flag = false;
                    }
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    if ("mention".equals(s))
                    {
                        addRequest(mAppController.fetchUserTypeahead(charsequence));
                    } else
                    if ("tag".equals(s))
                    {
                        addRequest(mAppController.fetchTagTypeahead(charsequence));
                        return;
                    }
                }
            }
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (CommentViewHolder)view.getTag();
        ProfileActivity.start(getActivity(), ((CommentViewHolder) (adapterview)).userId, "Comments List");
    }

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        if (mActionMode == null && (view.getTag() instanceof CommentViewHolder))
        {
            adapterview = (CommentViewHolder)view.getTag();
            l = mAppController.getActiveId();
            if (l == ((CommentViewHolder) (adapterview)).userId || l == mPostAuthorId)
            {
                mSelectedView = view;
                mSelectedView.setSelected(true);
                mSelectedCommentId = ((CommentViewHolder)view.getTag()).commentId;
                mActionMode = ((ActionBarActivity)getActivity()).startSupportActionMode(mActionModeCallback);
                return true;
            }
        }
        return false;
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
        super.onListItemClick(listview, view, i, l);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 2131362366 2131362367: default 28
    //                   2131362366 34
    //                   2131362367 43;
           goto _L1 _L2 _L3
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        insertText("@");
_L5:
        return true;
_L3:
        insertText("#");
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void onPopupItemSelected(int i, int j, CharSequence charsequence, long l)
    {
    }

    public void onPopupShown()
    {
    }

    public void onResume()
    {
        super.onResume();
        if (mAdapter.isEmpty() && !mFetched)
        {
            fetchContent();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("fetched", mFetched);
    }

    public void onSpanClicked(View view, int i, Object obj)
    {
        switch (i)
        {
        case 2: // '\002'
        default:
            return;

        case 1: // '\001'
            ProfileActivity.start(getActivity(), ((Long)obj).longValue(), "Comments List");
            return;

        case 3: // '\003'
            HashtagActivity.start(getActivity(), (String)obj);
            break;
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (mEdit.getText().length() > 0)
        {
            mSendButton.setColorFilter(getResources().getColor(0x7f090096) | 0xff000000);
            return;
        } else
        {
            mSendButton.setColorFilter(getResources().getColor(0x7f09001f) | 0xff000000);
            return;
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        bundle = (PopupEditText)view.findViewById(0x7f0a0083);
        bundle.setOnEditorActionListener(this);
        bundle.setAdapter(mTypeaheadAdapter);
        mTokenizer = new ComposeTokenizer(this);
        bundle.setTokenizer(mTokenizer, this, mAppController.getTypeaheadThrottle());
        bundle.setPopupEditTextListener(this);
        mEdit = bundle;
        mEdit.addTextChangedListener(this);
        bundle = getArguments();
        mPostId = bundle.getLong("post_id");
        mPostAuthorId = bundle.getLong("post_author_id");
        mSendButton = (ImageView)view.findViewById(0x7f0a0082);
        mSendButton.setOnClickListener(this);
        mSendButton.setColorFilter(0xff000000 | getResources().getColor(0x7f09001f), android.graphics.PorterDuff.Mode.SRC_ATOP);
        mListView.setOnItemLongClickListener(this);
        mListView.setOnItemClickListener(this);
        mAdapter = new CommentsAdapter(getActivity(), mAppController, this);
        ((ConversationList)mListView).setGetMoreListener(this);
        mListView.setAdapter(mAdapter);
    }

    public void postComment(EditText edittext)
    {
        if (validate(edittext))
        {
            ProgressDialog progressdialog = new ProgressDialog(getActivity(), 0x7f0f0037);
            progressdialog.setMessage(getString(0x7f0e0066));
            progressdialog.setProgressStyle(0);
            progressdialog.show();
            mProgressDialog = progressdialog;
            addRequest(mAppController.postComment(mPostId, mAppController.getActiveSession(), edittext.getText().toString(), mEdit.getEntities()));
            edittext.getText().clear();
        }
    }

    public void setPopupAdapter(String s)
    {
        if (!"users_adapter".equals(s)) goto _L2; else goto _L1
_L1:
        mTypeaheadAdapter = mUsersAdapter;
_L4:
        mEdit.setAdapter(mTypeaheadAdapter);
        return;
_L2:
        if ("tags_adapter".equals(s))
        {
            mTypeaheadAdapter = mTagsAdapter;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void showProgress(int i)
    {
        super.showProgress(i);
        if (i == 1 && mNextPage > 0)
        {
            ((ConversationList)mListView).showProgress();
        }
    }







/*
    static ActionMode access$302(ActionMode actionmode)
    {
        mActionMode = actionmode;
        return actionmode;
    }

*/



/*
    static int access$402(CommentsFragment commentsfragment, int i)
    {
        commentsfragment.mNextPage = i;
        return i;
    }

*/


/*
    static long access$502(CommentsFragment commentsfragment, long l)
    {
        commentsfragment.mAnchor = l;
        return l;
    }

*/




}
