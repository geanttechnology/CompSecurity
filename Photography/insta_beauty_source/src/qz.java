// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.gpuimage.sample.activity.TShareGridView;

class qz
    implements android.view.View.OnClickListener
{

    final qy a;

    qz(qy qy1)
    {
        a = qy1;
        super();
    }

    public void onClick(View view)
    {
        view = (View)view.getTag();
        if (TShareGridView.access$800(a.a) != null)
        {
            TShareGridView.access$800(a.a).a((String)view.getTag(), a.a);
        }
    }
}
