// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.ImageView;
import com.fotoable.fotoproedit.activity.ProEditFilterActivity;

public class afw
    implements android.view.View.OnClickListener
{

    final ProEditFilterActivity a;

    public afw(ProEditFilterActivity proeditfilteractivity)
    {
        a = proeditfilteractivity;
        super();
    }

    public void onClick(View view)
    {
        if (ProEditFilterActivity.h(a).isSelected())
        {
            return;
        }
        ProEditFilterActivity.g(a);
        if (ProEditFilterActivity.i(a))
        {
            ProEditFilterActivity.c(a, false);
            ProEditFilterActivity.a(a, ProEditFilterActivity.j(a), 1);
        }
        ProEditFilterActivity.a(a, 1);
        ProEditFilterActivity.a(a, ProEditFilterActivity.h(a), true);
    }
}
