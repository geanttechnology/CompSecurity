// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.widget.AutoCompleteTextView;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import my.googlemusic.play.adapters.comment.SuggestionAdapter;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.utils.views.AutoCompleteTextChangeListener;

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
            ReplyActivity.access$1302(ReplyActivity.this, (ArrayList)obj);
            ewHolder.access._mth500(ReplyActivity.access$1400(ReplyActivity.this)).addTextChangedListener(new AutoCompleteTextChangeListener(ReplyActivity.this, ReplyActivity.access$1300(ReplyActivity.this), ReplyActivity.this));
            ReplyActivity.access$1502(ReplyActivity.this, new SuggestionAdapter(ReplyActivity.this, ReplyActivity.access$1600(ReplyActivity.this), 0x7f03007f, ReplyActivity.access$1300(ReplyActivity.this), ReplyActivity.this));
            ewHolder.access._mth500(ReplyActivity.access$1400(ReplyActivity.this)).setAdapter(ReplyActivity.access$1500(ReplyActivity.this));
            System.out.println("suggestions loaded");
        }
    }

    Adapter()
    {
        this$0 = ReplyActivity.this;
        super();
    }
}
