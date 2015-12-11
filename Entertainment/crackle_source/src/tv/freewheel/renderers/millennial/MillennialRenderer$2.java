// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.millennial;

import com.millennialmedia.android.MMAdView;

// Referenced classes of package tv.freewheel.renderers.millennial:
//            MillennialRenderer

class this._cls0
    implements Runnable
{

    final MillennialRenderer this$0;

    public void run()
    {
        MillennialRenderer.access$300(MillennialRenderer.this).callForAd();
    }

    ()
    {
        this$0 = MillennialRenderer.this;
        super();
    }
}
