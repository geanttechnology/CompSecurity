// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import java.util.Collections;
import java.util.List;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Comment;

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
        if (obj instanceof List)
        {
            obj = (List)obj;
            if (!((List) (obj)).isEmpty())
            {
                ReplyActivity.access$1902(ReplyActivity.this, (Comment)((List) (obj)).get(0));
                ReplyActivity.access$2000(ReplyActivity.this, ReplyActivity.access$1900(ReplyActivity.this));
                ((List) (obj)).remove(0);
            }
            Collections.reverse(((List) (obj)));
            ReplyActivity.access$2100(ReplyActivity.this, ((List) (obj)));
            ReplyActivity.access$2200(ReplyActivity.this, 8);
        }
    }

    ()
    {
        this$0 = ReplyActivity.this;
        super();
    }
}
