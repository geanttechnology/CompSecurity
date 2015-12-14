// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import java.util.List;
import my.googlemusic.play.adapters.comment.SuggestionAdapter;
import my.googlemusic.play.utils.views.AutoCompleteTextView;

// Referenced classes of package my.googlemusic.play.activities:
//            CommentsActivity

class val.suggestions
    implements Runnable
{

    final CommentsActivity this$0;
    final List val$suggestions;

    public void run()
    {
        if (val$suggestions.isEmpty())
        {
            CommentsActivity.access$200(CommentsActivity.this).message.dismissDropDown();
            return;
        } else
        {
            CommentsActivity.access$402(CommentsActivity.this, new SuggestionAdapter(CommentsActivity.this, CommentsActivity.access$500(CommentsActivity.this), 0x7f03007f, val$suggestions, CommentsActivity.this));
            CommentsActivity.access$200(CommentsActivity.this).message.setAdapter(CommentsActivity.access$400(CommentsActivity.this));
            CommentsActivity.access$200(CommentsActivity.this).message.showDropDown();
            return;
        }
    }

    pter()
    {
        this$0 = final_commentsactivity;
        val$suggestions = List.this;
        super();
    }
}
