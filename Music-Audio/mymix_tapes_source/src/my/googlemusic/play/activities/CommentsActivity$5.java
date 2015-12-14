// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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
        if (response.getStatus() == 6)
        {
            CommentsActivity.access$200(CommentsActivity.this).offline.setVisibility(0);
            CommentsActivity.access$200(CommentsActivity.this).library = (Button)findViewById(0x7f0d01a7);
            ((TextView)findViewById(0x7f0d01a6)).setText("Comments are unavailable offline.");
    /* block-local class not found */
    class _cls1 {}

            CommentsActivity.access$200(CommentsActivity.this).library.setOnClickListener(new _cls1());
        }
        CommentsActivity.access$1000(CommentsActivity.this, 8);
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
            ListView listview = CommentsActivity.access$200(CommentsActivity.this).list;
            int i;
            if (((List) (obj)).size() != 0)
            {
                i = ((List) (obj)).size() - 1;
            } else
            {
                i = 0;
            }
            listview.setSelection(i);
            CommentsActivity.access$902(CommentsActivity.this, false);
            CommentsActivity.access$1000(CommentsActivity.this, 8);
            CommentsActivity.access$1100(CommentsActivity.this, false);
        }
    }

    _cls1()
    {
        this$0 = CommentsActivity.this;
        super();
    }
}
