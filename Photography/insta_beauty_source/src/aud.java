// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.shareinstagram.HandleBmpView;

public class aud
    implements gm
{

    final HandleBmpView a;

    public aud(HandleBmpView handlebmpview)
    {
        a = handlebmpview;
        super();
    }

    public boolean a(gl gl1)
    {
        HandleBmpView handlebmpview = a;
        handlebmpview.lastAngleDegree = handlebmpview.lastAngleDegree + a.newAngleDegree;
        a.newAngleDegree = gl1.b();
        HandleBmpView.access$002(a, false);
        a.invalidate();
        return true;
    }

    public boolean b(gl gl1)
    {
        gl1 = a;
        gl1.lastAngleDegree = ((HandleBmpView) (gl1)).lastAngleDegree + a.newAngleDegree;
        a.newAngleDegree = 0.0F;
        return true;
    }

    public void c(gl gl1)
    {
        gl1 = a;
        gl1.lastAngleDegree = ((HandleBmpView) (gl1)).lastAngleDegree + a.newAngleDegree;
        a.newAngleDegree = 0.0F;
    }
}
