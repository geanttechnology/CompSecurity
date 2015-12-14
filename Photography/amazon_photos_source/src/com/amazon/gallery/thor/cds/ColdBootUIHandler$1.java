// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.content.SharedPreferences;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            ColdBootUIHandler

class this._cls0
    implements Runnable
{

    final ColdBootUIHandler this$0;

    public void run()
    {
        ColdBootUIHandler.access$100(ColdBootUIHandler.this).edit().putInt("cold_boot_progress", ColdBootUIHandler.access$000(ColdBootUIHandler.this)).apply();
    }

    ()
    {
        this$0 = ColdBootUIHandler.this;
        super();
    }
}
