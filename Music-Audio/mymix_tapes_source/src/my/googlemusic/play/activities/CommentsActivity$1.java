// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import my.googlemusic.play.adapters.comment.SuggestionAdapter;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Comment;
import my.googlemusic.play.utils.views.AutoCompleteTextChangeListener;
import my.googlemusic.play.utils.views.AutoCompleteTextView;

// Referenced classes of package my.googlemusic.play.activities:
//            CommentsActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

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
            CommentsActivity.access$102(CommentsActivity.this, (ArrayList)obj);
            CommentsActivity.access$200(CommentsActivity.this).message.addTextChangedListener(new AutoCompleteTextChangeListener(CommentsActivity.this, CommentsActivity.access$100(CommentsActivity.this), CommentsActivity.this));
            obj = new ArrayList();
            for (Iterator iterator = CommentsActivity.access$300(CommentsActivity.this).iterator(); iterator.hasNext(); ((List) (obj)).add(((Comment)iterator.next()).getUser())) { }
            CommentsActivity.access$100(CommentsActivity.this).addAll(((java.util.Collection) (obj)));
            CommentsActivity.access$402(CommentsActivity.this, new SuggestionAdapter(CommentsActivity.this, CommentsActivity.access$500(CommentsActivity.this), 0x7f03007f, CommentsActivity.access$100(CommentsActivity.this), CommentsActivity.this));
            CommentsActivity.access$200(CommentsActivity.this).message.setAdapter(CommentsActivity.access$400(CommentsActivity.this));
        }
    }

    pter()
    {
        this$0 = CommentsActivity.this;
        super();
    }
}
