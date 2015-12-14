// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.NewFilterContainer;

public class ir
    implements android.view.View.OnClickListener
{

    final NewFilterContainer a;

    public ir(NewFilterContainer newfiltercontainer)
    {
        a = newfiltercontainer;
        super();
    }

    public void onClick(View view)
    {
        if (a.mListener != null)
        {
            a.mListener.a();
        }
    }
}
