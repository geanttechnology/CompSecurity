// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

final class agb extends LinearLayout
{

    ArrayList a;

    public agb(afz afz, Context context)
    {
        super(context);
        a = new ArrayList();
    }

    static void a(View view)
    {
        aga aga1 = (aga)view.getTag(0x7f10001a);
        view.setTag(0x7f10001a, null);
        if (aga1 != null)
        {
            aga1.a();
        }
    }

    protected final void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        for (int i = getChildCount() - 1; i >= 0; i--)
        {
            a(getChildAt(i));
        }

    }
}
