// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.extension.pausead;

import tv.freewheel.hybrid.ad.interfaces.IEvent;
import tv.freewheel.hybrid.ad.interfaces.IEventListener;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.extension.pausead:
//            PauseAdExtension

class this._cls0
    implements IEventListener
{

    final PauseAdExtension this$0;

    public void run(IEvent ievent)
    {
        PauseAdExtension.access$100(PauseAdExtension.this).debug("adErrorListener");
        if (PauseAdExtension.access$800(PauseAdExtension.this, ievent).booleanValue())
        {
            PauseAdExtension.access$100(PauseAdExtension.this).debug("adErrorListener, ad failed");
            PauseAdExtension.access$702(PauseAdExtension.this, Boolean.valueOf(false));
        }
    }

    ()
    {
        this$0 = PauseAdExtension.this;
        super();
    }
}
