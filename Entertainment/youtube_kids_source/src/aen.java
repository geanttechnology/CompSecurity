// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.drawable.Drawable;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;

public final class aen
    implements afx
{

    ImageView a;
    public Drawable b;
    private Drawable c;

    public aen(ImageView imageview)
    {
        a = imageview;
    }

    public final void a()
    {
        if (c == null && b == null || c != null && c.equals(b))
        {
            return;
        } else
        {
            a.animate().alpha(0.0F).withEndAction(new aeo(this)).setDuration(150L);
            c = b;
            return;
        }
    }
}
