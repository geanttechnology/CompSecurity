// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.html;

import android.view.View;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.html:
//            MRAIDPresentationInLine

class this._cls0
    implements android.view.eListener
{

    final MRAIDPresentationInLine this$0;

    public void onChildViewAdded(View view, View view1)
    {
        MRAIDPresentationInLine.access$100(MRAIDPresentationInLine.this).debug("onChildViewAdded");
        if (MRAIDPresentationInLine.access$000(MRAIDPresentationInLine.this) != view1)
        {
            refresh();
        }
    }

    public void onChildViewRemoved(View view, View view1)
    {
        MRAIDPresentationInLine.access$100(MRAIDPresentationInLine.this).debug("onChildViewRemoved, do nothing");
    }

    ()
    {
        this$0 = MRAIDPresentationInLine.this;
        super();
    }
}
