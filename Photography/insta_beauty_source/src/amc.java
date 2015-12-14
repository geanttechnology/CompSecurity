// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.view.ui.FontPreViewDialog;

public class amc
    implements android.view.View.OnClickListener
{

    final FontPreViewDialog a;

    public amc(FontPreViewDialog fontpreviewdialog)
    {
        a = fontpreviewdialog;
        super();
    }

    public void onClick(View view)
    {
        if (a.a != null)
        {
            a.a.b(a.j);
        }
    }
}
