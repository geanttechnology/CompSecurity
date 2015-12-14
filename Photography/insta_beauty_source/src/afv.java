// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.ImageView;
import com.fotoable.fotoproedit.activity.ProEditFilterActivity;

public class afv
    implements android.view.View.OnClickListener
{

    final ProEditFilterActivity a;

    public afv(ProEditFilterActivity proeditfilteractivity)
    {
        a = proeditfilteractivity;
        super();
    }

    public void onClick(View view)
    {
        if (ProEditFilterActivity.f(a).isSelected())
        {
            return;
        } else
        {
            ProEditFilterActivity.g(a);
            ProEditFilterActivity.a(a, 0);
            ProEditFilterActivity.a(a, ProEditFilterActivity.f(a), true);
            return;
        }
    }
}
