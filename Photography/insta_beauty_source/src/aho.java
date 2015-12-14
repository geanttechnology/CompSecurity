// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.ImageButton;
import com.fotoable.fotoproedit.activity.ProEditMosaicActivity;
import com.fotoable.fotoproedit.activity.mosaic.MosaicGLSurfaceView;

public class aho
    implements android.view.View.OnClickListener
{

    final ProEditMosaicActivity a;

    public aho(ProEditMosaicActivity proeditmosaicactivity)
    {
        a = proeditmosaicactivity;
        super();
    }

    public void onClick(View view)
    {
        if (ProEditMosaicActivity.e(a).isEnabled())
        {
            ProEditMosaicActivity.d(a).movePrevious();
        }
    }
}
