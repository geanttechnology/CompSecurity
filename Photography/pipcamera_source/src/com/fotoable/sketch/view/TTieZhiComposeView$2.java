// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import dt;
import du;

// Referenced classes of package com.fotoable.sketch.view:
//            TTieZhiComposeView, TTieZhiInfoView

class a
    implements du
{

    final TTieZhiComposeView a;

    public boolean a(dt dt1)
    {
        if (a.selecTieZhiInfoView != null)
        {
            a.selecTieZhiInfoView.storeTransform();
            a.selecTieZhiInfoView.setNewRotate((float)(((double)dt1.b() * 3.1415926535897931D) / 180D));
            TTieZhiComposeView.access$000(a, a.selecTieZhiInfoView);
        }
        return true;
    }

    public boolean b(dt dt1)
    {
        if (a.selecTieZhiInfoView != null)
        {
            a.selecTieZhiInfoView.storeTransform();
            a.selecTieZhiInfoView.invalidate();
        }
        return true;
    }

    public void c(dt dt1)
    {
        if (a.selecTieZhiInfoView != null)
        {
            a.selecTieZhiInfoView.storeTransform();
            a.selecTieZhiInfoView.invalidate();
        }
    }

    (TTieZhiComposeView ttiezhicomposeview)
    {
        a = ttiezhicomposeview;
        super();
    }
}
