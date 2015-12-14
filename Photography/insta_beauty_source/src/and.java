// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.view.ui.scroll.TProEditStretchSculptBar;

public class and
    implements android.view.View.OnClickListener
{

    final TProEditStretchSculptBar a;

    public and(TProEditStretchSculptBar tproeditstretchsculptbar)
    {
        a = tproeditstretchsculptbar;
        super();
    }

    public void onClick(View view)
    {
        if (a.callback != null)
        {
            a.callback.a();
        }
    }
}
