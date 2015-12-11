// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.vine.android.api.VineComment;
import co.vine.android.api.VineEntity;
import co.vine.android.client.AppController;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.Util;
import co.vine.android.util.ViewUtil;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import co.vine.android.widget.SpanClickListener;
import co.vine.android.widget.StyledClickableSpan;
import co.vine.android.widget.Typefaces;
import co.vine.android.widget.TypefacesSpan;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            CommentViewHolder, VineLoggingException

public class CommentsAdapter extends BaseAdapter
{

    private static final int SPAN_FLAGS = 33;
    private AppController mAppController;
    private TypefacesSpan mBoldSpan;
    private HashMap mCommentSbs;
    private ArrayList mComments;
    private Context mContext;
    private HashMap mIdToPositionMap;
    final SpanClickListener mListener;
    final ArrayList mViewHolders = new ArrayList();
    private int mVineGreen;

    public CommentsAdapter(Context context, AppController appcontroller, SpanClickListener spanclicklistener)
    {
        mIdToPositionMap = new HashMap();
        mComments = new ArrayList();
        mCommentSbs = new HashMap();
        mContext = context;
        mBoldSpan = new TypefacesSpan(null, Typefaces.get(context).getContentTypeface(1, 3));
        mAppController = appcontroller;
        mListener = spanclicklistener;
        mVineGreen = context.getResources().getColor(0x7f090096);
    }

    private void rebuildIdToPositionMap()
    {
        mIdToPositionMap.clear();
        for (int i = 0; i < mComments.size(); i++)
        {
            VineComment vinecomment = (VineComment)mComments.get(i);
            mIdToPositionMap.put(Long.valueOf(vinecomment.commentId), Integer.valueOf(i));
        }

    }

    public void addMyComment(VineComment vinecomment)
    {
        mComments.add(vinecomment);
        rebuildIdToPositionMap();
        notifyDataSetChanged();
    }

    public void bindView(View view, VineComment vinecomment)
    {
        Object obj;
        Object obj1;
        CommentViewHolder commentviewholder;
        ArrayList arraylist;
        String s;
        commentviewholder = (CommentViewHolder)view.getTag();
        obj = vinecomment.username;
        s = vinecomment.comment;
        arraylist = vinecomment.entities;
        view = ((View) (obj));
        if (obj == null)
        {
            view = "";
            CrashUtil.logException(new VineLoggingException(), (new StringBuilder()).append("Username is null for ").append(vinecomment.commentId).toString(), new Object[0]);
        }
        commentviewholder.content.setMovementMethod(LinkMovementMethod.getInstance());
        commentviewholder.timestamp.setText(Util.getRelativeTimeString(mContext, vinecomment.timestamp, false));
        commentviewholder.commentId = String.valueOf(vinecomment.commentId);
        commentviewholder.userId = vinecomment.userId;
        obj1 = (Editable)mCommentSbs.get(commentviewholder.commentId);
        obj = obj1;
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        obj1 = (new SpannableStringBuilder(view)).append(" ").append(s);
        mCommentSbs.put(commentviewholder.commentId, obj1);
        Util.safeSetSpan(((android.text.Spannable) (obj1)), mBoldSpan, 0, view.length(), 33);
        obj = new StyledClickableSpan(1, Long.valueOf(commentviewholder.userId), mListener);
        ((StyledClickableSpan) (obj)).setColor(mVineGreen);
        Util.safeSetSpan(((android.text.Spannable) (obj1)), obj, 0, view.length(), 33);
        obj = obj1;
        if (arraylist == null) goto _L2; else goto _L3
_L3:
        Util.adjustEntities(arraylist, ((Editable) (obj1)), view.length() + 1, false);
        view = arraylist.iterator();
_L7:
        obj = obj1;
        if (!view.hasNext()) goto _L2; else goto _L4
_L4:
        obj = (VineEntity)view.next();
        if (((VineEntity) (obj)).isUserType())
        {
            StyledClickableSpan styledclickablespan = new StyledClickableSpan(1, Long.valueOf(((VineEntity) (obj)).id), mListener);
            styledclickablespan.setColor(mVineGreen);
            Util.safeSetSpan(((android.text.Spannable) (obj1)), styledclickablespan, ((VineEntity) (obj)).start, ((VineEntity) (obj)).end, 33);
            continue; /* Loop/switch isn't completed */
        }
          goto _L5
        view;
        CrashUtil.logException(view);
        obj = obj1;
_L2:
        commentviewholder.content.setText(((CharSequence) (obj)));
        view = vinecomment.avatarUrl;
        if (Util.isDefaultAvatarUrl(view))
        {
            Util.safeSetDefaultAvatar(commentviewholder.profileImage, co.vine.android.util.Util.ProfileImageSize.MEDIUM, 0xff000000 | mVineGreen);
            ViewUtil.setBackground(commentviewholder.profileImage, null);
            return;
        }
        break; /* Loop/switch isn't completed */
_L5:
        if (((VineEntity) (obj)).isTagType())
        {
            StyledClickableSpan styledclickablespan1 = new StyledClickableSpan(3, ((VineEntity) (obj)).title, mListener);
            styledclickablespan1.setColor(mVineGreen);
            Util.safeSetSpan(((android.text.Spannable) (obj1)), styledclickablespan1, ((VineEntity) (obj)).start, ((VineEntity) (obj)).end, 33);
        }
        if (true) goto _L7; else goto _L6
_L6:
        commentviewholder.profileImage.setColorFilter(null);
        view = new ImageKey(view, true);
        commentviewholder.imageKey = view;
        view = mAppController.getPhotoBitmap(view);
        if (view != null)
        {
            commentviewholder.profileImage.setImageDrawable(new RecyclableBitmapDrawable(mContext.getResources(), view));
            return;
        } else
        {
            ViewUtil.setBackground(commentviewholder.profileImage, mContext.getResources().getDrawable(0x7f0200f7));
            commentviewholder.profileImage.setImageDrawable(null);
            return;
        }
    }

    public void deleteComment(long l)
    {
        int i = getPositionForId(l);
        mComments.remove(i);
        rebuildIdToPositionMap();
        notifyDataSetChanged();
    }

    public int getCount()
    {
        return mComments.size();
    }

    public Object getItem(int i)
    {
        return mComments.get(i);
    }

    public long getItemId(int i)
    {
        return ((VineComment)mComments.get(i)).commentId;
    }

    public int getPositionForId(long l)
    {
        if (mIdToPositionMap != null && mIdToPositionMap.get(Long.valueOf(l)) != null)
        {
            return ((Integer)mIdToPositionMap.get(Long.valueOf(l))).intValue();
        } else
        {
            return -1;
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = newView();
        }
        bindView(viewgroup, (VineComment)getItem(i));
        return viewgroup;
    }

    public void mergeComments(ArrayList arraylist)
    {
        mComments.addAll(0, arraylist);
        rebuildIdToPositionMap();
        notifyDataSetChanged();
    }

    public View newView()
    {
        RelativeLayout relativelayout = (RelativeLayout)LayoutInflater.from(mContext).inflate(0x7f030025, null, false);
        CommentViewHolder commentviewholder = new CommentViewHolder();
        commentviewholder.profileImage = (ImageView)relativelayout.findViewById(0x7f0a007a);
        commentviewholder.content = (TextView)relativelayout.findViewById(0x7f0a0061);
        commentviewholder.content.setMovementMethod(LinkMovementMethod.getInstance());
        commentviewholder.timestamp = (TextView)relativelayout.findViewById(0x7f0a007b);
        relativelayout.setTag(commentviewholder);
        mViewHolders.add(new WeakReference(commentviewholder));
        return relativelayout;
    }

    public void updateProfileImages(HashMap hashmap)
    {
        Object obj = new ArrayList();
        int i = mViewHolders.size() - 1;
        while (i >= 0) 
        {
            WeakReference weakreference = (WeakReference)mViewHolders.get(i);
            CommentViewHolder commentviewholder = (CommentViewHolder)weakreference.get();
            if (commentviewholder == null)
            {
                ((ArrayList) (obj)).add(weakreference);
            } else
            if (commentviewholder.imageKey != null)
            {
                UrlImage urlimage = (UrlImage)hashmap.get(commentviewholder.imageKey);
                if (urlimage != null)
                {
                    commentviewholder.profileImage.setImageDrawable(new RecyclableBitmapDrawable(mContext.getResources(), urlimage.bitmap));
                }
            }
            i--;
        }
        for (hashmap = ((ArrayList) (obj)).iterator(); hashmap.hasNext(); mViewHolders.remove(obj))
        {
            obj = (WeakReference)hashmap.next();
        }

    }
}
