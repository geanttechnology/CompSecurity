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
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import my.googlemusic.play.adapters.comment.CommentsClickListener;
import my.googlemusic.play.adapters.comment.CommentsRequestListener;
import my.googlemusic.play.adapters.comment.ReplyAdapter;
import my.googlemusic.play.adapters.comment.SuggestionAdapter;
import my.googlemusic.play.advertising.BannerManager;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Comment;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.CompatibilityUtil;
import my.googlemusic.play.utils.appbar.AppBar;
import my.googlemusic.play.utils.dialog.DialogSkipUser;
import my.googlemusic.play.utils.transformations.CropSquareTransformation;
import my.googlemusic.play.utils.views.AutoCompleteTextChangeListener;

// Referenced classes of package my.googlemusic.play.activities:
//            ProfileActivity

public class ReplyActivity extends ActionBarActivity
    implements CommentsRequestListener, CommentsClickListener, android.view.View.OnClickListener, android.widget.AdapterView.OnItemLongClickListener, android.widget.AdapterView.OnItemClickListener, my.googlemusic.play.utils.views.AutoCompleteTextChangeListener.OnTextChangeListener, my.googlemusic.play.adapters.comment.SuggestionAdapter.OnMentionListener, my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener, android.view.View.OnLongClickListener
{
    private static class ViewHolder
    {

        private RelativeLayout adView;
        private AppBar appBar;
        private ImageView badgeSecondary;
        private TextView comment;
        private ListView list;
        private View loading;
        private AutoCompleteTextView message;
        private TextView name;
        private ImageView photo;
        private Button send;
        private TextView time;
        private TextView username;



/*
        static RelativeLayout access$002(ViewHolder viewholder, RelativeLayout relativelayout)
        {
            viewholder.adView = relativelayout;
            return relativelayout;
        }

*/



/*
        static TextView access$1002(ViewHolder viewholder, TextView textview)
        {
            viewholder.username = textview;
            return textview;
        }

*/



/*
        static ImageView access$1102(ViewHolder viewholder, ImageView imageview)
        {
            viewholder.photo = imageview;
            return imageview;
        }

*/



/*
        static ImageView access$1202(ViewHolder viewholder, ImageView imageview)
        {
            viewholder.badgeSecondary = imageview;
            return imageview;
        }

*/



/*
        static View access$202(ViewHolder viewholder, View view)
        {
            viewholder.loading = view;
            return view;
        }

*/



/*
        static ListView access$302(ViewHolder viewholder, ListView listview)
        {
            viewholder.list = listview;
            return listview;
        }

*/



/*
        static Button access$402(ViewHolder viewholder, Button button)
        {
            viewholder.send = button;
            return button;
        }

*/



/*
        static AutoCompleteTextView access$502(ViewHolder viewholder, AutoCompleteTextView autocompletetextview)
        {
            viewholder.message = autocompletetextview;
            return autocompletetextview;
        }

*/


/*
        static AppBar access$602(ViewHolder viewholder, AppBar appbar)
        {
            viewholder.appBar = appbar;
            return appbar;
        }

*/



/*
        static TextView access$702(ViewHolder viewholder, TextView textview)
        {
            viewholder.name = textview;
            return textview;
        }

*/



/*
        static TextView access$802(ViewHolder viewholder, TextView textview)
        {
            viewholder.time = textview;
            return textview;
        }

*/



/*
        static TextView access$902(ViewHolder viewholder, TextView textview)
        {
            viewholder.comment = textview;
            return textview;
        }

*/

        private ViewHolder()
        {
        }

    }


    private long mAlbumId;
    private long mCommentId;
    private List mComments;
    private Comment mHeaderComment;
    private ViewHolder mHolder;
    private ReplyAdapter mReplyAdapter;
    private Comment mSelectedComment;
    private Server mServer;
    private SuggestionAdapter mSuggestionAdapter;
    private List mSuggestions;
    private User mUser;

    public ReplyActivity()
    {
    }

    private void LoadCommentTask()
    {
        setLoading(0);
        mServer.getReply(mCommentId, new my.googlemusic.play.interfaces.Server.Callback() {

            final ReplyActivity this$0;

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
                    obj = (List)obj;
                    if (!((List) (obj)).isEmpty())
                    {
                        mHeaderComment = (Comment)((List) (obj)).get(0);
                        initHeader(mHeaderComment);
                        ((List) (obj)).remove(0);
                    }
                    Collections.reverse(((List) (obj)));
                    setOrUpdateAdapter(((List) (obj)));
                    setLoading(8);
                }
            }

            
            {
                this$0 = ReplyActivity.this;
                super();
            }
        });
    }

    private void deleteComment()
    {
        mServer.deleteReply(mSelectedComment, new my.googlemusic.play.interfaces.Server.Callback() {

            final ReplyActivity this$0;

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
                    mReplyAdapter.deleteReply(mSelectedComment);
                    mReplyAdapter.notifyDataSetChanged();
                }
            }

            
            {
                this$0 = ReplyActivity.this;
                super();
            }
        });
    }

    private void initAds()
    {
        BannerManager.loadmmdevbanner(mHolder.adView);
    }

    private void initData()
    {
        if (getIntent().getExtras() != null)
        {
            mAlbumId = getIntent().getLongExtra("idAlbum", 0xffffffff80000000L);
            mCommentId = getIntent().getLongExtra("idComment", 0xffffffff80000000L);
            mServer = ((App)getApplication()).getServer();
            mUser = mServer.getUser();
        }
    }

    private void initHeader(Comment comment)
    {
        if (comment != null)
        {
            mHolder.name = (TextView)findViewById(0x7f0d0141);
            mHolder.time = (TextView)findViewById(0x7f0d0143);
            mHolder.comment = (TextView)findViewById(0x7f0d0142);
            mHolder.username = (TextView)findViewById(0x7f0d0140);
            mHolder.photo = (ImageView)findViewById(0x7f0d013e);
            mHolder.badgeSecondary = (ImageView)findViewById(0x7f0d013f);
            mHolder.time.setText(comment.getTime());
            mHolder.comment.setText(comment.getMessage());
            mHolder.name.setText(comment.getUser().getName());
            mHolder.username.setText(comment.getUser().getUsername());
            mHolder.photo.setOnClickListener(this);
            mHolder.username.setOnClickListener(this);
            Picasso.with(this).load(mServer.getLinkUserImage(comment.getUser().getId())).placeholder(0x7f0201db).transform(new CropSquareTransformation()).into(mHolder.photo);
            Picasso.with(this).load(mServer.getLinkBadge(comment.getUser().getId(), comment.getUser().getBadgeSecondary())).into(mHolder.badgeSecondary);
        }
    }

    private void initView()
    {
        setContentView(0x7f030034);
        mHolder = new ViewHolder();
        mHolder.loading = findViewById(0x7f0d019b);
        mHolder.list = (ListView)findViewById(0x7f0d0149);
        mHolder.send = (Button)findViewById(0x7f0d0147);
        mHolder.adView = (RelativeLayout)findViewById(0x7f0d0144);
        mHolder.message = (AutoCompleteTextView)findViewById(0x7f0d0148);
        registerForContextMenu(mHolder.list);
        mHolder.send.setOnClickListener(this);
        mHolder.list.setOnItemClickListener(this);
        mHolder.message.setOnLongClickListener(this);
        mHolder.list.setOnItemLongClickListener(this);
        mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).title("Replies").back();
    }

    public static int randInt(int i, int j)
    {
        return (new Random()).nextInt((j - i) + 1) + i;
    }

    private void reportComment()
    {
        mServer.reportComment(mSelectedComment, new my.googlemusic.play.interfaces.Server.Callback() {

            final ReplyActivity this$0;

            public void onFailure(Response response)
            {
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
            }

            
            {
                this$0 = ReplyActivity.this;
                super();
            }
        });
    }

    private void setLoading(int i)
    {
        mHolder.loading.setVisibility(i);
    }

    private void setOrUpdateAdapter(List list)
    {
        mComments = list;
        if (mReplyAdapter == null)
        {
            mReplyAdapter = new ReplyAdapter(this, mComments, mServer, this, this, mCommentId);
            mHolder.list.setAdapter(mReplyAdapter);
            return;
        } else
        {
            mReplyAdapter.updateListAdapter(mComments);
            mReplyAdapter.notifyDataSetChanged();
            return;
        }
    }

    private void setSuggestionsAdapter()
    {
        mServer.getFollowing(mUser.getId(), mUser.getId(), 1, new my.googlemusic.play.interfaces.Server.Callback() {

            final ReplyActivity this$0;

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
                    mHolder.message.addTextChangedListener(new AutoCompleteTextChangeListener(ReplyActivity.this, mSuggestions, ReplyActivity.this));
                    mSuggestionAdapter = new SuggestionAdapter(ReplyActivity.this, mServer, 0x7f03007f, mSuggestions, ReplyActivity.this);
                    mHolder.message.setAdapter(mSuggestionAdapter);
                    System.out.println("suggestions loaded");
                }
            }

            
            {
                this$0 = ReplyActivity.this;
                super();
            }
        });
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
            overridePendingTransition(0x7f040021, 0x7f040024);
        }
    }

    public void onClick(View view)
    {
        if (view.getId() != 0x7f0d0147) goto _L2; else goto _L1
_L1:
        if (!mServer.getUser().isSkip()) goto _L4; else goto _L3
_L3:
        (new DialogSkipUser()).show(getSupportFragmentManager(), null);
_L6:
        return;
_L4:
        if (mHolder.message.getText().toString().length() != 0)
        {
            view = new Comment(mServer.getUser(), mHolder.message.getText().toString(), "", "", randInt(0, 0x186a0), mAlbumId, 0, Comment.STATUS_PREPARED);
            mReplyAdapter.addReply(view);
            mHolder.message.setText("");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (view.getId() == 0x7f0d013e || view.getId() == 0x7f0d0140)
        {
            if (mServer.getUser().isSkip())
            {
                (new DialogSkipUser()).show(getSupportFragmentManager(), null);
                return;
            } else
            {
                startActivity((new Intent(this, my/googlemusic/play/activities/ProfileActivity)).putExtra("user", mHeaderComment.getUser().getId()));
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
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
        contextmenu.add(getResources().getString(0x7f060047));
        contextmenu.add(getResources().getString(0x7f060049));
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
        mHolder.list.setSelection(mReplyAdapter.getCount());
    }

    public void onProfileClick(User user)
    {
        startActivity((new Intent(this, my/googlemusic/play/activities/ProfileActivity)).putExtra("user", user.getId()));
    }

    public void onReplyClick(Comment comment)
    {
        startActivity((new Intent(this, my/googlemusic/play/activities/ReplyActivity)).putExtra("idComment", comment.getCommentId()).putExtra("idAlbum", comment.getAlbumId()));
    }

    protected void onResume()
    {
        super.onResume();
        if (mServer.getUser().isPremium() && mHolder.adView.getVisibility() == 0)
        {
            mHolder.adView.setVisibility(4);
            android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)mHolder.adView.getLayoutParams();
            layoutparams.height = 1;
            mHolder.adView.setLayoutParams(layoutparams);
        }
    }

    public void onSuccessRequest(Comment comment)
    {
    }

    public void onTextChanged(final List suggestions)
    {
        runOnUiThread(new Runnable() {

            final ReplyActivity this$0;
            final List val$suggestions;

            public void run()
            {
                if (suggestions.isEmpty())
                {
                    mHolder.message.dismissDropDown();
                    return;
                } else
                {
                    mSuggestionAdapter = new SuggestionAdapter(ReplyActivity.this, mServer, 0x7f03007f, suggestions, ReplyActivity.this);
                    mHolder.message.setAdapter(mSuggestionAdapter);
                    mHolder.message.showDropDown();
                    return;
                }
            }

            
            {
                this$0 = ReplyActivity.this;
                suggestions = list;
                super();
            }
        });
    }



/*
    static List access$1302(ReplyActivity replyactivity, List list)
    {
        replyactivity.mSuggestions = list;
        return list;
    }

*/




/*
    static SuggestionAdapter access$1502(ReplyActivity replyactivity, SuggestionAdapter suggestionadapter)
    {
        replyactivity.mSuggestionAdapter = suggestionadapter;
        return suggestionadapter;
    }

*/






/*
    static Comment access$1902(ReplyActivity replyactivity, Comment comment)
    {
        replyactivity.mHeaderComment = comment;
        return comment;
    }

*/



}
