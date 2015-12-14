// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import com.amazon.gallery.framework.model.tags.Tag;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            RenameFragment

class val.tag
    implements Runnable
{

    final RenameFragment this$0;
    final Tag val$tag;

    public void run()
    {
        rename(val$tag);
    }

    ()
    {
        this$0 = final_renamefragment;
        val$tag = Tag.this;
        super();
    }
}
