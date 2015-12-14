// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.other.ArcMenu;

public class xh
    implements android.view.View.OnClickListener
{

    final View a;
    final int b;
    final ArcMenu c;

    public xh(ArcMenu arcmenu, View view, int i)
    {
        c = arcmenu;
        a = view;
        b = i;
        super();
    }

    public void onClick(View view)
    {
        if (ArcMenu.access$100(c) != null)
        {
            ArcMenu.access$100(c).a(a, b);
        }
        ArcMenu.access$200(c, b - 1);
        ArcMenu.access$300(c);
    }
}
