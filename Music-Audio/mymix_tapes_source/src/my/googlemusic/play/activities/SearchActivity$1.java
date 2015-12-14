// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import java.io.PrintStream;
import java.util.TimerTask;

// Referenced classes of package my.googlemusic.play.activities:
//            SearchActivity

class this._cls0 extends TimerTask
{

    final SearchActivity this$0;

    public void run()
    {
        System.out.println("INSIDE");
        SearchActivity.access$100(SearchActivity.this);
    }

    ()
    {
        this$0 = SearchActivity.this;
        super();
    }
}
