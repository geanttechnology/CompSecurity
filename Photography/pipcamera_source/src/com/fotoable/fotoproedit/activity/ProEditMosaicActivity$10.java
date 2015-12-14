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
    implements android.view.ditMosaicActivity._cls10
{

    final ProEditMosaicActivity a;

    public void onClick(View view)
    {
        ProEditMosaicActivity.a(a, ProEditMosaicActivity.h(a), false);
        ProEditMosaicActivity.a(a, ProEditMosaicActivity.i(a), false);
        ProEditMosaicActivity.a(a, ProEditMosaicActivity.j(a), false);
        ProEditMosaicActivity.a(a, ProEditMosaicActivity.k(a), false);
        ProEditMosaicActivity.a(a, (ImageButton)view, true);
        switch (((Integer)view.getTag()).intValue())
        {
        default:
            return;

        case 1024: 
            view = ProEditMosaicActivity.d(a);
            int i;
            if (ProEditMosaicActivity.l(a))
            {
                i = ProEditMosaicActivity.m(a);
            } else
            {
                i = (int)((double)ProEditMosaicActivity.m(a) * 0.5D);
            }
            view.setBrushSize(i);
            return;

        case 1025: 
            view = ProEditMosaicActivity.d(a);
            int j;
            if (ProEditMosaicActivity.l(a))
            {
                j = (int)((double)ProEditMosaicActivity.m(a) * 1.5D);
            } else
            {
                j = ProEditMosaicActivity.m(a);
            }
            view.setBrushSize(j);
            return;

        case 1026: 
            view = ProEditMosaicActivity.d(a);
            int k;
            if (ProEditMosaicActivity.l(a))
            {
                k = ProEditMosaicActivity.m(a) * 2;
            } else
            {
                k = (int)((double)ProEditMosaicActivity.m(a) * 1.5D);
            }
            view.setBrushSize(k);
            return;

        case 1027: 
            view = ProEditMosaicActivity.d(a);
            break;
        }
        int l;
        if (ProEditMosaicActivity.l(a))
        {
            l = ProEditMosaicActivity.m(a) * 3;
        } else
        {
            l = (int)((double)ProEditMosaicActivity.m(a) * 2.2000000000000002D);
        }
        view.setBrushSize(l);
    }

    w(ProEditMosaicActivity proeditmosaicactivity)
    {
        a = proeditmosaicactivity;
        super();
    }
}
