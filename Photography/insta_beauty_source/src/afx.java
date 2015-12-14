// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.ImageView;
import com.fotoable.fotoproedit.activity.ProEditFilterActivity;

public class afx
    implements android.view.View.OnClickListener
{

    final ProEditFilterActivity a;

    public afx(ProEditFilterActivity proeditfilteractivity)
    {
        a = proeditfilteractivity;
        super();
    }

    public void onClick(View view)
    {
        if (ProEditFilterActivity.k(a).isSelected())
        {
            return;
        }
        ProEditFilterActivity.g(a);
        if (ProEditFilterActivity.l(a))
        {
            ProEditFilterActivity.d(a, false);
            ProEditFilterActivity.a(a, ProEditFilterActivity.m(a), 2);
        }
        ProEditFilterActivity.a(a, 2);
        ProEditFilterActivity.a(a, ProEditFilterActivity.k(a), true);
    }
}
