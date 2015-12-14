// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.Button;
import com.fotoable.fotoproedit.activity.ProEditSlimBodyActivity;
import java.util.ArrayList;

public class aja
    implements android.view.View.OnClickListener
{

    final ProEditSlimBodyActivity a;

    public aja(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        a = proeditslimbodyactivity;
        super();
    }

    public void onClick(View view)
    {
        int i = a.d.size();
        if (i > 0)
        {
            view = (add)a.d.get(i - 1);
            ProEditSlimBodyActivity.a(a).a(view);
            a.d.remove(i - 1);
            ProEditSlimBodyActivity.j(a);
            ProEditSlimBodyActivity.k(a).setEnabled(true);
            if (a.d.size() <= 0)
            {
                ProEditSlimBodyActivity.l(a).setEnabled(false);
            }
        }
    }
}
