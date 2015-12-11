// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.loader;

import commonlib.loader.event.UpdateEvent;

// Referenced classes of package commonlib.loader:
//            EntityLoader

class this._cls0
{

    final EntityLoader this$0;

    public void onEvent(UpdateEvent updateevent)
    {
        if (updateevent.getClass() == EntityLoader.access$000(EntityLoader.this) && shouldReload(updateevent))
        {
            forceLoad();
        }
    }

    nt()
    {
        this$0 = EntityLoader.this;
        super();
    }
}
