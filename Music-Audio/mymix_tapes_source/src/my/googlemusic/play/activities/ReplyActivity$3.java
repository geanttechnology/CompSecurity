// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import my.googlemusic.play.adapters.comment.ReplyAdapter;
import my.googlemusic.play.internet.Response;

// Referenced classes of package my.googlemusic.play.activities:
//            ReplyActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

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
            ReplyActivity.access$1800(ReplyActivity.this).deleteReply(ReplyActivity.access$1700(ReplyActivity.this));
            ReplyActivity.access$1800(ReplyActivity.this).notifyDataSetChanged();
        }
    }

    er()
    {
        this$0 = ReplyActivity.this;
        super();
    }
}
