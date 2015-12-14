// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.interactors;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import java.util.concurrent.CopyOnWriteArraySet;

// Referenced classes of package com.amazon.gallery.thor.interactors:
//            ThisDayInteractor

private class this._cls0 extends ContentObserver
{

    final ThisDayInteractor this$0;

    public void onChange(boolean flag)
    {
        onChange(flag, null);
    }

    public void onChange(boolean flag, Uri uri)
    {
        if (ThisDayInteractor.access$000(ThisDayInteractor.this).isEmpty())
        {
            ThisDayInteractor.access$102(ThisDayInteractor.this, true);
            ThisDayInteractor.access$202(ThisDayInteractor.this, true);
            ThisDayInteractor.access$302(ThisDayInteractor.this, true);
            return;
        } else
        {
            ThisDayInteractor.access$400(ThisDayInteractor.this, S_DAY);
            ThisDayInteractor.access$400(ThisDayInteractor.this, S_WEEK);
            ThisDayInteractor.access$400(ThisDayInteractor.this, UFFLE);
            return;
        }
    }

    public (Handler handler)
    {
        this$0 = ThisDayInteractor.this;
        super(handler);
    }
}
