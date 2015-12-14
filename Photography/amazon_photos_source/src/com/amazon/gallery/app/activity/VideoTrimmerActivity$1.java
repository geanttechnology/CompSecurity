// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.app.activity;

import com.amazon.gallery.framework.gallery.actions.SelectionAction;
import java.util.List;

// Referenced classes of package com.amazon.gallery.app.activity:
//            VideoTrimmerActivity

class this._cls0
    implements SelectionAction
{

    final VideoTrimmerActivity this$0;

    public boolean canExecute(List list)
    {
        return true;
    }

    public boolean canExecuteTags(List list)
    {
        return true;
    }

    public void execute(List list)
    {
        if (VideoTrimmerActivity.access$000(VideoTrimmerActivity.this) == null)
        {
            return;
        } else
        {
            VideoTrimmerActivity.access$100(VideoTrimmerActivity.this);
            VideoTrimmerActivity.access$202(VideoTrimmerActivity.this, true);
            VideoTrimmerActivity.access$300(VideoTrimmerActivity.this);
            return;
        }
    }

    public void executeTags(List list)
    {
    }

    ction()
    {
        this$0 = VideoTrimmerActivity.this;
        super();
    }
}
