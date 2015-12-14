// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.widget.ListView;
import java.util.Collections;
import java.util.List;
import my.googlemusic.play.internet.Response;

// Referenced classes of package my.googlemusic.play.activities:
//            CommentsActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final CommentsActivity this$0;

    public void onFailure(Response response)
    {
        CommentsActivity.access$1100(CommentsActivity.this, false);
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
            CommentsActivity.access$800(CommentsActivity.this, ((List) (obj)));
            CommentsActivity.access$200(CommentsActivity.this).list.setSelection(((List) (obj)).size());
            CommentsActivity.access$200(CommentsActivity.this).list.smoothScrollBy(90, 0);
            CommentsActivity.access$1100(CommentsActivity.this, false);
        }
    }

    ewHolder()
    {
        this$0 = CommentsActivity.this;
        super();
    }
}
