// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import my.googlemusic.play.adapters.comment.CommentsAdapter;
import my.googlemusic.play.internet.Response;

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
        if (obj instanceof String)
        {
            CommentsActivity.access$700(CommentsActivity.this).deleteComment(CommentsActivity.access$600(CommentsActivity.this));
            CommentsActivity.access$700(CommentsActivity.this).notifyDataSetChanged();
        }
    }

    er()
    {
        this$0 = CommentsActivity.this;
        super();
    }
}
