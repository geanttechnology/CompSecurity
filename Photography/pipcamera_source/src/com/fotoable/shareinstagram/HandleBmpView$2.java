// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.shareinstagram;

import dt;
import du;

// Referenced classes of package com.fotoable.shareinstagram:
//            HandleBmpView

class a
    implements du
{

    final HandleBmpView a;

    public boolean a(dt dt1)
    {
        HandleBmpView handlebmpview = a;
        handlebmpview.lastAngleDegree = handlebmpview.lastAngleDegree + a.newAngleDegree;
        a.newAngleDegree = dt1.b();
        HandleBmpView.access$002(a, false);
        a.invalidate();
        return true;
    }

    public boolean b(dt dt1)
    {
        dt1 = a;
        dt1.lastAngleDegree = ((HandleBmpView) (dt1)).lastAngleDegree + a.newAngleDegree;
        a.newAngleDegree = 0.0F;
        return true;
    }

    public void c(dt dt1)
    {
        dt1 = a;
        dt1.lastAngleDegree = ((HandleBmpView) (dt1)).lastAngleDegree + a.newAngleDegree;
        a.newAngleDegree = 0.0F;
    }

    (HandleBmpView handlebmpview)
    {
        a = handlebmpview;
        super();
    }
}
