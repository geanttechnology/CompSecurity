// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.loader;

import commonlib.loader.event.UpdateEvent;

// Referenced classes of package commonlib.loader:
//            ListLoaderCallbacks

class this._cls0
{

    final rceLoad this$0;

    public void onEvent(UpdateEvent updateevent)
    {
        if (updateevent.getClass() == cess._mth000(this._cls0.this) && ouldReload(updateevent))
        {
            rceLoad();
        }
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
