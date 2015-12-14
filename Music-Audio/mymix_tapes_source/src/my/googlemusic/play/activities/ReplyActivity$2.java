// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.widget.AutoCompleteTextView;
import java.util.List;
import my.googlemusic.play.adapters.comment.SuggestionAdapter;

// Referenced classes of package my.googlemusic.play.activities:
//            ReplyActivity

class val.suggestions
    implements Runnable
{

    final ReplyActivity this$0;
    final List val$suggestions;

    public void run()
    {
        if (val$suggestions.isEmpty())
        {
            ewHolder.access._mth500(ReplyActivity.access$1400(ReplyActivity.this)).dismissDropDown();
            return;
        } else
        {
            ReplyActivity.access$1502(ReplyActivity.this, new SuggestionAdapter(ReplyActivity.this, ReplyActivity.access$1600(ReplyActivity.this), 0x7f03007f, val$suggestions, ReplyActivity.this));
            ewHolder.access._mth500(ReplyActivity.access$1400(ReplyActivity.this)).setAdapter(ReplyActivity.access$1500(ReplyActivity.this));
            ewHolder.access._mth500(ReplyActivity.access$1400(ReplyActivity.this)).showDropDown();
            return;
        }
    }

    Adapter()
    {
        this$0 = final_replyactivity;
        val$suggestions = List.this;
        super();
    }
}
