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

    final ShareInActivity a;

    public void run()
    {
        DialogUtils.a(a, a.getString(m.bc_dialog_title_warning), a.getString(m.bc_error_empty_data), new Runnable() {

            final ShareInActivity._cls17 a;

            public void run()
            {
                a.a.finish();
            }

            
            {
                a = ShareInActivity._cls17.this;
                super();
            }
        });
    }

    _cls1.a(ShareInActivity shareinactivity)
    {
        a = shareinactivity;
        super();
    }
}
