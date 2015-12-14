// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.view.View;
import android.widget.ImageButton;
import com.fotoable.fotoproedit.activity.mosaic.MosaicGLSurfaceView;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditMosaicActivity

class a
    implements android.view.EditMosaicActivity._cls7
{

    final ProEditMosaicActivity a;

    public void onClick(View view)
    {
        if (ProEditMosaicActivity.e(a).isEnabled())
        {
            ProEditMosaicActivity.d(a).movePrevious();
        }
    }

    ew(ProEditMosaicActivity proeditmosaicactivity)
    {
        a = proeditmosaicactivity;
        super();
    }
}
