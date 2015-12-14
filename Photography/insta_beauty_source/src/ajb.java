// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.Button;
import com.fotoable.fotoproedit.activity.ProEditSlimBodyActivity;
import java.util.ArrayList;

public class ajb
    implements android.view.View.OnClickListener
{

    final ProEditSlimBodyActivity a;

    public ajb(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        a = proeditslimbodyactivity;
        super();
    }

    public void onClick(View view)
    {
        int j = (int)ProEditSlimBodyActivity.a(a).b();
        if (j > 0)
        {
            a.d.add(ProEditSlimBodyActivity.a(a).a(j - 1));
            view = new ado();
            for (int i = 0; i < j - 1; i++)
            {
                view.a(ProEditSlimBodyActivity.a(a).a(i));
            }

            ProEditSlimBodyActivity.a(a).d();
            ProEditSlimBodyActivity.a(a, view);
            ProEditSlimBodyActivity.j(a);
            ProEditSlimBodyActivity.l(a).setEnabled(true);
            if (ProEditSlimBodyActivity.a(a).b() <= 0L)
            {
                ProEditSlimBodyActivity.k(a).setEnabled(false);
            }
        }
    }
}
