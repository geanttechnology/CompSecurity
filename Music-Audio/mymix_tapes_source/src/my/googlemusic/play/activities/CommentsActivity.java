// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import my.googlemusic.play.adapters.comment.CommentsAdapter;
import my.googlemusic.play.adapters.comment.CommentsClickListener;
import my.googlemusic.play.adapters.comment.CommentsRequestListener;
import my.googlemusic.play.adapters.comment.SuggestionAdapter;
import my.googlemusic.play.advertising.BannerManager;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Connection;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Comment;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.CompatibilityUtil;
import my.googlemusic.play.utils.appbar.AppBar;
import my.googlemusic.play.utils.dialog.DialogSkipUser;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;
import my.googlemusic.play.utils.views.AutoCompleteTextChangeListener;
import my.googlemusic.play.utils.views.AutoCompleteTextView;

// Referenced classes of package my.googlemusic.play.activities:
//            ProfileActivity, ReplyActivity

public class CommentsActivity extends ActionBarActivity
    implements CommentsRequestListener, CommentsClickListener, android.view.View.OnClickListener, android.widget.AbsListView.OnScrollListener, android.widget.AdapterView.OnItemLongClickListener, my.googlemusic.play.utils.views.AutoCompleteTextChangeListener.OnTextChangeListener, my.googlemusic.play.adapters.comment.SuggestionAdapter.OnMentionListener, my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener, android.view.View.OnLongClickListener, android.view.View.OnTouchListener, android.widget.AdapterView.OnItemClickListener, android.widget.TextView.OnEditorActionListener
{
    private static class ViewHolder
    {

        RelativeLayout adView;
        AppBar appBar;
        Button library;
        ListView list;
        View loading;
        AutoCompleteTextView message;
        View offline;
        Button send;

        private ViewHolder()
        {
        }

    }


    public static final int LIMIT_ROWS_IN_SCREEN = 6;
    public static final int SMOOTH_SCROLL_DURATION = 0;
    public static final int SMOOTH_SCROLL_POSITION = 90;
    private boolean autoScrollLocked;
    private View header;
    private Album mAlbum;
    private List mComments;
    private CommentsAdapter mCommentsAdapter;
    private Connection mConnection;
    private ViewHolder mHolder;
    private boolean mLoadMore;
    private Comment mSelectedComment;
    private Server mServer;
    private SuggestionAdapter mSuggestionAdapter;
    private List mSuggestions;
    private User mUser;

    public CommentsActivity()
    {
        autoScrollLocked = true;
    }

    private void LoadCommentMoreTask(String s)
    {
        setLoading(true);
        mServer.getComments(mAlbum, 20, s, new my.googlemusic.play.interfaces.Server.Callback() {

            final CommentsActivity this$0;

            public void onFailure(Response response)
            {
                setLoading(false);
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                if (obj instanceof List)
                {
                    obj = (List)obj;
                    Collections.reverse(((List) (obj)));
                    setOrUpdateAdapter(((List) (obj)));
                    mHolder.list.setSelection(((List) (obj)).size());
                    mHolder.list.smoothScrollBy(90, 0);
                    setLoading(false);
                }
            }

            
            {
                this$0 = CommentsActivity.this;
                super();
            }
        });
    }

    private void LoadCommentTask()
    {
        setLoading(0);
        mServer.getComments(mAlbum, 20, "", new my.googlemusic.play.interfaces.Server.Callback() {

            final CommentsActivity this$0;

            public void onFailure(Response response)
            {
                if (response.getStatus() == 6)
                {
                    mHolder.offline.setVisibility(0);
                    mHolder.library = (Button)findViewById(0x7f0d01a7);
                    ((TextView)findViewById(0x7f0d01a6)).setText("Comments are unavailable offline.");
            /* block-local class not found */
            class _cls1 {}

                    mHolder.library.setOnClickListener(new _cls1());
                }
                setLoading(8);
                setLoading(false);
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                if (obj instanceof List)
                {
                    obj = (List)obj;
                    Collections.reverse(((List) (obj)));
                    setOrUpdateAdapter(((List) (obj)));
                    ListView listview = mHolder.list;
                    int i;
                    if (((List) (obj)).size() != 0)
                    {
                        i = ((List) (obj)).size() - 1;
                    } else
                    {
                        i = 0;
                    }
                    listview.setSelection(i);
                    autoScrollLocked = false;
                    setLoading(8);
                    setLoading(false);
                }
            }

            
            {
                this$0 = CommentsActivity.this;
                super();
            }
        });
    }

    private void closeKeyboard()
    {
        InputMethodManager inputmethodmanager = (InputMethodManager)getSystemService("input_method");
        if (getCurrentFocus() != null)
        {
            inputmethodmanager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    private void deleteComment()
    {
        mServer.deleteComment(mSelectedComment, new my.googlemusic.play.interfaces.Server.Callback() {

            final CommentsActivity this$0;

            public void onFailure(Response response)
            {
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                if (obj instanceof String)
                {
                    mCommentsAdapter.deleteComment(mSelectedComment);
                    mCommentsAdapter.notifyDataSetChanged();
                }
            }

            
            {
                this$0 = CommentsActivity.this;
                super();
            }
        });
    }

    private View getHeaderView()
    {
        return LayoutInflater.from(this).inflate(0x7f030042, mHolder.list, false);
    }

    private void initAds()
    {
        BannerManager.loadmmdevbanner(mHolder.adView);
    }

    private void initData()
    {
        mConnection = Connection.with(this);
        mAlbum = (Album)App.getGson().fromJson(getIntent().getStringExtra("album"), my/googlemusic/play/model/Album);
        mServer = ((App)getApplication()).getServer();
        mComments = new ArrayList();
        mUser = mServer.getUser();
    }

    private void initView()
    {
        setContentView(0x7f03001d);
        mHolder = new ViewHolder();
        mHolder.list = (ListView)findViewById(0x7f0d0096);
        mHolder.send = (Button)findViewById(0x7f0d0094);
        mHolder.offline = findViewById(0x7f0d01a3);
        mHolder.loading = findViewById(0x7f0d019b);
        mHolder.adView = (RelativeLayout)findViewById(0x7f0d0095);
        mHolder.message = (AutoCompleteTextView)findViewById(0x7f0d0093);
        header = getHeaderView();
        mHolder.message.setEnabled(true);
        header.setVisibility(0);
        mHolder.list.addHeaderView(header);
        registerForContextMenu(mHolder.list);
        mHolder.send.setOnClickListener(this);
        mHolder.list.setOnScrollListener(this);
        mHolder.list.setOnItemClickListener(this);
        mHolder.list.setOnItemLongClickListener(this);
        mHolder.message.setOnEditorActionListener(this);
        mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).title((new StringBuilder()).append(mAlbum.getCommentsCount()).append(" Comments").toString()).back();
    }

    public static int randInt(int i, int j)
    {
        return (new Random()).nextInt((j - i) + 1) + i;
    }

    private void reportComment()
    {
        mServer.reportComment(mSelectedComment, new my.googlemusic.play.interfaces.Server.Callback() {

            final CommentsActivity this$0;

            public void onFailure(Response response)
            {
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                if (obj instanceof String)
                {
                    Toast.with(CommentsActivity.this).message(obj.toString()).show();
                }
            }

            
            {
                this$0 = CommentsActivity.this;
                super();
            }
        });
    }

    private void setLoading(int i)
    {
        mHolder.loading.setVisibility(i);
    }

    private void setLoading(boolean flag)
    {
        mLoadMore = flag;
        if (mComments != null && mComments.size() < 6)
        {
            mHolder.list.removeHeaderView(header);
        }
    }

    private void setOrUpdateAdapter(List list)
    {
        mComments = list;
        if (mCommentsAdapter == null)
        {
            mCommentsAdapter = new CommentsAdapter(this, mComments, mServer, this, this);
            mHolder.list.setAdapter(mCommentsAdapter);
            return;
        } else
        {
            mCommentsAdapter.updateListAdapter(mComments);
            mCommentsAdapter.notifyDataSetChanged();
            return;
        }
    }

    private void setSuggestionsAdapter()
    {
        if (!mServer.getUser().isSkip())
        {
            mServer.getFollowing(mUser.getId(), mUser.getId(), 1, new my.googlemusic.play.interfaces.Server.Callback() {

                final CommentsActivity this$0;

                public void onFailure(Response response)
                {
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    if (obj instanceof List)
                    {
                        mSuggestions = (ArrayList)obj;
                        mHolder.message.addTextChangedListener(new AutoCompleteTextChangeListener(CommentsActivity.this, mSuggestions, CommentsActivity.this));
                        obj = new ArrayList();
                        for (Iterator iterator = mComments.iterator(); iterator.hasNext(); ((List) (obj)).add(((Comment)iterator.next()).getUser())) { }
                        mSuggestions.addAll(((java.util.Collection) (obj)));
                        mSuggestionAdapter = new SuggestionAdapter(CommentsActivity.this, mServer, 0x7f03007f, mSuggestions, CommentsActivity.this);
                        mHolder.message.setAdapter(mSuggestionAdapter);
                    }
                }

            
            {
                this$0 = CommentsActivity.this;
                super();
            }
            });
        }
    }

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.BACK)
        {
            finish();
        }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        if (CompatibilityUtil.getSdkVersion() > 10)
        {
            overridePendingTransition(0x7f040022, 0x7f04001e);
        }
        Runtime.getRuntime().gc();
        finish();
    }

    public void onClick(View view)
    {
        if (view.getId() == 0x7f0d0094)
        {
            if (mServer.getUser().isSkip())
            {
                (new DialogSkipUser()).show(getSupportFragmentManager(), null);
            } else
            if (mConnection.isConnected() && mHolder.message.getText().toString().length() != 0)
            {
                view = new Comment(mServer.getUser(), mHolder.message.getText().toString(), "", "", randInt(0, 0x186a0), mAlbum.getId(), 0, Comment.STATUS_PREPARED);
                mCommentsAdapter.addComment(view);
                mHolder.message.setText("");
                return;
            }
        }
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        if (!mServer.getUser().isSkip()) goto _L2; else goto _L1
_L1:
        (new DialogSkipUser()).show(getSupportFragmentManager(), null);
_L4:
        return super.onContextItemSelected(menuitem);
_L2:
        if (menuitem.getTitle().equals(getResources().getString(0x7f060046)))
        {
            deleteComment();
        } else
        if (menuitem.getTitle().equals(getResources().getString(0x7f060048)))
        {
            onReplyClick(mSelectedComment);
        } else
        if (menuitem.getTitle().equals(getResources().getString(0x7f060049)))
        {
            reportComment();
        } else
        if (menuitem.getTitle().equals(getResources().getString(0x7f060047)))
        {
            onProfileClick(mSelectedComment.getUser());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        initData();
        initView();
        initAds();
        LoadCommentTask();
        setSuggestionsAdapter();
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        if (mSelectedComment.getUser().getId() == mServer.getUser().getId())
        {
            contextmenu.add(getResources().getString(0x7f060046));
        }
        contextmenu.add(getResources().getString(0x7f060048));
        contextmenu.add(getResources().getString(0x7f060047));
        if (mSelectedComment.getUser().getId() != mServer.getUser().getId())
        {
            contextmenu.add(getResources().getString(0x7f060049));
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        closeKeyboard();
        return true;
    }

    public void onFailedRequest(Comment comment)
    {
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = ((AdapterView) (mHolder.list.getAdapter().getItem(i)));
        if (adapterview instanceof Comment)
        {
            mSelectedComment = (Comment)adapterview;
        }
        view.showContextMenu();
    }

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = ((AdapterView) (mHolder.list.getAdapter().getItem(i)));
        if (adapterview instanceof Comment)
        {
            mSelectedComment = (Comment)adapterview;
        }
        return false;
    }

    public boolean onLongClick(View view)
    {
        return true;
    }

    public void onMention(User user)
    {
        int i = mHolder.message.getText().toString().lastIndexOf("@");
        String s = mHolder.message.getText().toString().substring(0, i);
        mHolder.message.setText((new StringBuilder()).append(s).append(user.getUsername()).append(" ").toString());
        mHolder.message.setSelection(mHolder.message.getText().toString().length());
    }

    public void onPrepareRequest(Comment comment)
    {
        mHolder.list.setSelection(mCommentsAdapter.getCount());
    }

    public void onProfileClick(User user)
    {
        if (mServer.getUser().isSkip())
        {
            (new DialogSkipUser()).show(getSupportFragmentManager(), null);
            return;
        } else
        {
            startActivity((new Intent(this, my/googlemusic/play/activities/ProfileActivity)).putExtra("user", user.getId()));
            return;
        }
    }

    public void onReplyClick(Comment comment)
    {
        if (mServer.getUser().isSkip())
        {
            (new DialogSkipUser()).show(getSupportFragmentManager(), null);
        } else
        {
            startActivity((new Intent(this, my/googlemusic/play/activities/ReplyActivity)).putExtra("idComment", comment.getCommentId()).putExtra("idAlbum", comment.getAlbumId()));
            if (CompatibilityUtil.getSdkVersion() > 10)
            {
                overridePendingTransition(0x7f040020, 0x7f040023);
                return;
            }
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (!mServer.getUser().isPremium())
        {
            BannerManager.loadmmdevbanner(mHolder.adView);
            return;
        } else
        {
            mHolder.adView.setVisibility(4);
            android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)mHolder.adView.getLayoutParams();
            layoutparams.height = 1;
            mHolder.adView.setLayoutParams(layoutparams);
            return;
        }
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (mComments != null && mComments.size() <= 6)
        {
            autoScrollLocked = true;
        }
        if (i == 0 && !mLoadMore && !autoScrollLocked && mComments != null && mComments.size() > 1)
        {
            LoadCommentMoreTask(((Comment)mComments.get(0)).getDate());
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    public void onSuccessRequest(Comment comment)
    {
    }

    public void onTextChanged(final List suggestions)
    {
        runOnUiThread(new Runnable() {

            final CommentsActivity this$0;
            final List val$suggestions;

            public void run()
            {
                if (suggestions.isEmpty())
                {
                    mHolder.message.dismissDropDown();
                    return;
                } else
                {
                    mSuggestionAdapter = new SuggestionAdapter(CommentsActivity.this, mServer, 0x7f03007f, suggestions, CommentsActivity.this);
                    mHolder.message.setAdapter(mSuggestionAdapter);
                    mHolder.message.showDropDown();
                    return;
                }
            }

            
            {
                this$0 = CommentsActivity.this;
                suggestions = list;
                super();
            }
        });
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        view.requestFocus();
        ((InputMethodManager)getSystemService("input_method")).showSoftInput(view, 1);
        return true;
    }




/*
    static List access$102(CommentsActivity commentsactivity, List list)
    {
        commentsactivity.mSuggestions = list;
        return list;
    }

*/






/*
    static SuggestionAdapter access$402(CommentsActivity commentsactivity, SuggestionAdapter suggestionadapter)
    {
        commentsactivity.mSuggestionAdapter = suggestionadapter;
        return suggestionadapter;
    }

*/






/*
    static boolean access$902(CommentsActivity commentsactivity, boolean flag)
    {
        commentsactivity.autoScrollLocked = flag;
        return flag;
    }

*/
}
