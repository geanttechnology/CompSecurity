// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import com.fotoable.beautyui.NewFilterContainer;
import com.fotoable.beautyui.newui.FlexibleThumbSeekbar;

public class it
    implements im
{

    final NewFilterContainer a;

    public it(NewFilterContainer newfiltercontainer)
    {
        a = newfiltercontainer;
        super();
    }

    public void a(int i, Object obj, String s)
    {
        NewFilterContainer.access$002(a, i);
        if (i == 0x7f0600d4)
        {
            a.mFilterSeekBar.setVisibility(4);
        } else
        {
            a.mFilterSeekBar.setVisibility(0);
        }
        if (a.mListener != null)
        {
            NewFilterContainer.access$102(a, 0.7F);
            if (i == 0x7f06009d)
            {
                NewFilterContainer.access$102(a, 1.0F);
            }
            a.mListener.a(a.getResources().getString(i));
        }
    }
}
