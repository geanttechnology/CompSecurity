// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.adapters.comment;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Comment;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.transformations.CropSquareTransformation;

// Referenced classes of package my.googlemusic.play.adapters.comment:
//            CommentsRequestListener, CommentsClickListener

public class ReplyAdapter extends BaseAdapter
    implements CommentsRequestListener
{

    static final boolean $assertionsDisabled;
    private static final int RESPONSE_COMMENT_ADDED = 0;
    private CommentsClickListener mClickListener;
    private long mCommentId;
    private Context mContext;
    private ViewHolder mHolder;
    private LayoutInflater mInflater;
    private List mList;
    private CommentsRequestListener mRequestListener;
    private Server mServer;
    private Handler mainHandler;

    public ReplyAdapter(Context context, List list, Server server, CommentsRequestListener commentsrequestlistener, CommentsClickListener commentsclicklistener, long l)
    {
        if (context == null)
        {
            return;
        } else
        {
            mServer = server;
            mList = list;
            mContext = context;
            mInflater = LayoutInflater.from(mContext);
            mRequestListener = commentsrequestlistener;
            mClickListener = commentsclicklistener;
            mCommentId = l;
            mainHandler = new Handler(context.getMainLooper());
            return;
        }
    }

    public void addReply(Comment comment)
    {
        request(comment, false);
    }

    public void deleteReply(Comment comment)
    {
        for (int i = 0; i < mList.size(); i++)
        {
            if (((Comment)mList.get(i)).getCommentId() == comment.getCommentId())
            {
                mList.remove(i);
            }
        }

    }

    public int getCount()
    {
        return mList.size();
    }

    public Object getItem(int i)
    {
        return mList.get(i);
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        boolean flag = false;
    /* block-local class not found */
    class ProfileListener {}

    /* block-local class not found */
    class RetryListener {}

    /* block-local class not found */
    class ViewHolder {}

        Comment comment;
        TextView textview;
        if (view == null)
        {
            mHolder = new ViewHolder(null);
            view = mInflater.inflate(0x7f03007e, viewgroup, false);
            if (!$assertionsDisabled && view == null)
            {
                throw new AssertionError();
            }
            mHolder.replies = (Button)view.findViewById(0x7f0d02a5);
            mHolder.status = (ImageView)view.findViewById(0x7f0d02a1);
            mHolder.name = (TextView)view.findViewById(0x7f0d02a0);
            mHolder.time = (TextView)view.findViewById(0x7f0d02a3);
            mHolder.message = (TextView)view.findViewById(0x7f0d0093);
            mHolder.badge = (ImageView)view.findViewById(0x7f0d029f);
            mHolder.image = (ImageView)view.findViewById(0x7f0d029d);
            mHolder.statusMessage = (TextView)view.findViewById(0x7f0d02a2);
            view.setTag(mHolder);
        } else
        {
            mHolder = (ViewHolder)view.getTag();
        }
        comment = (Comment)mList.get(i);
        mHolder.time.setText(comment.getTime());
        mHolder.message.setText(comment.getMessage());
        textview = mHolder.name;
        if (comment.getUser().getUsername().contains("@"))
        {
            viewgroup = comment.getUser().getUsername();
        } else
        {
            viewgroup = (new StringBuilder()).append("@").append(comment.getUser().getUsername()).toString();
        }
        textview.setText(viewgroup);
        mHolder.replies.setText((new StringBuilder()).append(comment.getReplyCount()).append(" replies").toString());
        mHolder.replies.setVisibility(4);
        Picasso.with(mContext).load(mServer.getLinkBadge(comment.getUser().getId(), comment.getUser().getBadgeSecondary())).into(mHolder.badge);
        Picasso.with(mContext).load(mServer.getLinkUserImage(comment.getUser().getId())).transform(new CropSquareTransformation()).placeholder(0x7f0201db).into(mHolder.image);
        viewgroup = mHolder.statusMessage;
        if (comment.getStatus() == Comment.STATUS_FAILED)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        viewgroup.setVisibility(i);
        viewgroup = mHolder.status;
        i = ((flag) ? 1 : 0);
        if (comment.getStatus() == Comment.STATUS_PREPARED)
        {
            i = 0x7f020131;
        }
        viewgroup.setImageResource(i);
        mHolder.statusMessage.setOnClickListener(new RetryListener(comment));
        mHolder.name.setOnClickListener(new ProfileListener(comment, mClickListener));
        mHolder.image.setOnClickListener(new ProfileListener(comment, mClickListener));
        return view;
    }

    public void onFailedRequest(Comment comment)
    {
        mainHandler.post(new _cls3(comment));
    }

    public void onPrepareRequest(Comment comment)
    {
        mainHandler.post(new _cls2(comment));
    }

    public void onSuccessRequest(Comment comment)
    {
        mainHandler.post(new _cls4(comment));
    }

    public void request(Comment comment, boolean flag)
    {
        (new Thread(new _cls1(flag, comment))).start();
    }

    public void updateListAdapter(List list)
    {
        mList.addAll(0, list);
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/adapters/comment/ReplyAdapter.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }





    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls1 {}

}
