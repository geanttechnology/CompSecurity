// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.widget.TextView;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;
import java.text.NumberFormat;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity

class this._cls0
    implements Runnable
{

    final AkActivity this$0;

    public void run()
    {
        if (uiTextNbFaces != null)
        {
            uiTextNbFaces.setText(NumberFormat.getInstance().format(AkActivity.access$502(AkActivity.this, AkPlayerBelongingsFactory.sharedInstance().getFacesBalance())));
        }
    }

    ingsFactory()
    {
        this$0 = AkActivity.this;
        super();
    }
}
