// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.widget.SwitchCompat;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ga extends Animation
{

    final float a;
    final float b;
    final SwitchCompat c;

    public ga(SwitchCompat switchcompat, float f, float f1)
    {
        c = switchcompat;
        a = f;
        b = f1;
        super();
    }

    protected void applyTransformation(float f, Transformation transformation)
    {
        SwitchCompat.access$000(c, a + b * f);
    }
}
