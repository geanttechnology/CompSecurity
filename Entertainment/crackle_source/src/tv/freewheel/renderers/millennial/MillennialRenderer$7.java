// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.millennial;

import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.millennial:
//            MillennialRenderer

class this._cls0
    implements Runnable
{

    final MillennialRenderer this$0;

    public void run()
    {
        MillennialRenderer.access$000(MillennialRenderer.this).debug("MMAdFailed()");
        if (!MillennialRenderer.access$100(MillennialRenderer.this))
        {
            MillennialRenderer.access$000(MillennialRenderer.this).warn("MMAdFailed has already been received, returning");
            return;
        } else
        {
            MillennialRenderer.access$102(MillennialRenderer.this, false);
            MillennialRenderer.access$200(MillennialRenderer.this);
            MillennialRenderer.access$1300(MillennialRenderer.this, MillennialRenderer.access$800(MillennialRenderer.this).ERROR_NO_AD_AVAILABLE(), "No ad available.");
            return;
        }
    }

    ()
    {
        this$0 = MillennialRenderer.this;
        super();
    }
}
