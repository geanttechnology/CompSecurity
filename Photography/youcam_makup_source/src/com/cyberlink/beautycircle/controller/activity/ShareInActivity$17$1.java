// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.utility.DialogUtils;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInActivity

class a
    implements Runnable
{

    final h a;

    public void run()
    {
        a.a.finish();
    }

    I(I i)
    {
        a = i;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/ShareInActivity$17

/* anonymous class */
    class ShareInActivity._cls17
        implements Runnable
    {

        final ShareInActivity a;

        public void run()
        {
            DialogUtils.a(a, a.getString(m.bc_dialog_title_warning), a.getString(m.bc_error_empty_data), new ShareInActivity._cls17._cls1(this));
        }

            
            {
                a = shareinactivity;
                super();
            }
    }

}
