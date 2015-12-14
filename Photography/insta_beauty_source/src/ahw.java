// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.ImageButton;
import com.fotoable.fotoproedit.activity.ProEditMosaicActivity;
import com.fotoable.fotoproedit.activity.mosaic.MosaicGLSurfaceView;

public class ahw
    implements android.view.View.OnClickListener
{

    final ProEditMosaicActivity a;

    public ahw(ProEditMosaicActivity proeditmosaicactivity)
    {
        a = proeditmosaicactivity;
        super();
    }

    public void onClick(View view)
    {
        ProEditMosaicActivity.a(a, ProEditMosaicActivity.l(a), false);
        ProEditMosaicActivity.a(a, ProEditMosaicActivity.m(a), false);
        ProEditMosaicActivity.a(a, ProEditMosaicActivity.n(a), false);
        ProEditMosaicActivity.a(a, ProEditMosaicActivity.o(a), false);
        ProEditMosaicActivity.a(a, (ImageButton)view, true);
        switch (((Integer)view.getTag()).intValue())
        {
        default:
            return;

        case 1024: 
            view = ProEditMosaicActivity.d(a);
            int i;
            if (ProEditMosaicActivity.h(a))
            {
                i = ProEditMosaicActivity.p(a);
            } else
            {
                i = (int)((double)ProEditMosaicActivity.p(a) * 0.5D);
            }
            view.setBrushSize(i);
            return;

        case 1025: 
            view = ProEditMosaicActivity.d(a);
            int j;
            if (ProEditMosaicActivity.h(a))
            {
                j = (int)((double)ProEditMosaicActivity.p(a) * 1.5D);
            } else
            {
                j = ProEditMosaicActivity.p(a);
            }
            view.setBrushSize(j);
            return;

        case 1026: 
            view = ProEditMosaicActivity.d(a);
            int k;
            if (ProEditMosaicActivity.h(a))
            {
                k = ProEditMosaicActivity.p(a) * 2;
            } else
            {
                k = (int)((double)ProEditMosaicActivity.p(a) * 1.5D);
            }
            view.setBrushSize(k);
            return;

        case 1027: 
            view = ProEditMosaicActivity.d(a);
            break;
        }
        int l;
        if (ProEditMosaicActivity.h(a))
        {
            l = ProEditMosaicActivity.p(a) * 3;
        } else
        {
            l = (int)((double)ProEditMosaicActivity.p(a) * 2.2000000000000002D);
        }
        view.setBrushSize(l);
    }
}
