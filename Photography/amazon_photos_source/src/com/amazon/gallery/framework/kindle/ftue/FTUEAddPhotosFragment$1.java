// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;

import android.view.View;

// Referenced classes of package com.amazon.gallery.framework.kindle.ftue:
//            FTUEAddPhotosFragment

class val.facebookRow
    implements Runnable
{

    final FTUEAddPhotosFragment this$0;
    final View val$facebookRow;

    public void run()
    {
        synchronized (FTUEAddPhotosFragment.this)
        {
            if (!FTUEAddPhotosFragment.access$000(FTUEAddPhotosFragment.this) && getView() != null)
            {
                val$facebookRow.setVisibility(8);
            }
        }
        return;
        exception;
        ftueaddphotosfragment;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ()
    {
        this$0 = final_ftueaddphotosfragment;
        val$facebookRow = View.this;
        super();
    }
}
