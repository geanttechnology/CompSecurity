// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import android.widget.CompoundButton;
import com.amazon.gallery.foundation.utils.log.GLogger;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.gallery.framework.kindle:
//            AutoSaveManagerImpl

class this._cls0
    implements android.widget.edChangeListener
{

    final AutoSaveManagerImpl this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        GLogger.v(AutoSaveManagerImpl.TAG, "Apply to future tags explicitly modified, set to %b", new Object[] {
            Boolean.valueOf(flag)
        });
        AutoSaveManagerImpl.access$1000(AutoSaveManagerImpl.this).set(flag);
    }

    ()
    {
        this$0 = AutoSaveManagerImpl.this;
        super();
    }
}
