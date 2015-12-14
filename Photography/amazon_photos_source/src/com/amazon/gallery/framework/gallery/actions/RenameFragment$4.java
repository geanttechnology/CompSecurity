// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.support.design.widget.Snackbar;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            RenameFragment

class val.context
    implements Runnable
{

    final RenameFragment this$0;
    final Activity val$context;

    public void run()
    {
        if (RenameFragment.access$100(RenameFragment.this))
        {
            Snackbar.make(val$context.findViewById(0x7f0c0122), val$context.getString(0x7f0e01fe), 0).show();
            return;
        } else
        {
            Snackbar.make(val$context.findViewById(0x7f0c0122), val$context.getString(0x7f0e01fd), 0).show();
            return;
        }
    }

    ()
    {
        this$0 = final_renamefragment;
        val$context = Activity.this;
        super();
    }
}
