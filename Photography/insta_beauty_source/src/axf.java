// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.sketch.view.TTieZhiComposeView;
import com.fotoable.sketch.view.TTieZhiInfoView;

public class axf
    implements gm
{

    final TTieZhiComposeView a;

    public axf(TTieZhiComposeView ttiezhicomposeview)
    {
        a = ttiezhicomposeview;
        super();
    }

    public boolean a(gl gl1)
    {
        if (a.selecTieZhiInfoView != null)
        {
            a.selecTieZhiInfoView.storeTransform();
            a.selecTieZhiInfoView.setNewRotate((float)(((double)gl1.b() * 3.1415926535897931D) / 180D));
            TTieZhiComposeView.access$000(a, a.selecTieZhiInfoView);
        }
        return true;
    }

    public boolean b(gl gl1)
    {
        if (a.selecTieZhiInfoView != null)
        {
            a.selecTieZhiInfoView.storeTransform();
            a.selecTieZhiInfoView.invalidate();
        }
        return true;
    }

    public void c(gl gl1)
    {
        if (a.selecTieZhiInfoView != null)
        {
            a.selecTieZhiInfoView.storeTransform();
            a.selecTieZhiInfoView.invalidate();
        }
    }
}
