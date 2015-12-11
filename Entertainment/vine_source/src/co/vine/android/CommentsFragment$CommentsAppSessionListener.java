// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import co.vine.android.api.VineComment;
import co.vine.android.client.AppSessionListener;
import co.vine.android.provider.VineSuggestionsProvider;
import co.vine.android.service.PendingAction;
import co.vine.android.widget.ConversationList;
import co.vine.android.widget.PopupEditText;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            CommentsFragment, PendingRequestHelper, CommentsAdapter, UsersAutoCompleteAdapter

class this._cls0 extends AppSessionListener
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
                CommentsFragment.access$402(CommentsFragment.this, j);
                CommentsFragment.access$502(CommentsFragment.this, l);
                CommentsFragment.access$600(CommentsFragment.this);
                s = (CommentsAdapter)mAdapter;
                s.mergeComments(arraylist);
                j = s.getPositionForId(CommentsFragment.access$700(CommentsFragment.this));
                mListView.setSelectionFromTop(mListView.getHeaderViewsCount() + j, CommentsFragment.access$800(CommentsFragment.this));
            }
            if (CommentsFragment.access$900(CommentsFragment.this) && (CommentsFragment.access$400(CommentsFragment.this) <= 0 || arraylist == null || arraylist.size() == 0))
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
            CommentsFragment.access$1100(CommentsFragment.this).performFilter(false);
        }
    }

    public void onGetUserTypeAheadComplete(String s, int i, String s1, String s2, ArrayList arraylist)
    {
        if (removeRequest(s) != null && i == 200 && !arraylist.isEmpty())
        {
            VineSuggestionsProvider.addRealtimeUserSuggestions(s2, arraylist);
            CommentsFragment.access$1100(CommentsFragment.this).performFilter(false);
        }
    }

    public void onPhotoImageLoaded(HashMap hashmap)
    {
        super.onPhotoImageLoaded(hashmap);
        ((CommentsAdapter)mAdapter).updateProfileImages(hashmap);
        CommentsFragment.access$1000(CommentsFragment.this).setUserImages(hashmap);
    }

    public void onPostCommentComplete(final String listView, int i, String s, long l, String s1, VineComment vinecomment)
    {
label0:
        {
            dismissDialog();
            if (removeRequest(listView) != null && l == CommentsFragment.access$000(CommentsFragment.this))
            {
                listView = mListView;
                listView.post(new Runnable() {

                    final CommentsFragment.CommentsAppSessionListener this$1;
                    final ListView val$listView;

                    public void run()
                    {
                        listView.setSelection(listView.getCount() - 1);
                    }

            
            {
                this$1 = CommentsFragment.CommentsAppSessionListener.this;
                listView = listview;
                super();
            }
                });
                if (i == 200)
                {
                    break label0;
                }
                CommentsFragment.access$1100(CommentsFragment.this).setText(s1);
            }
            return;
        }
        ((CommentsAdapter)mAdapter).addMyComment(vinecomment);
        showSadface(false);
    }

    _cls1.val.listView()
    {
        this$0 = CommentsFragment.this;
        super();
    }
}
