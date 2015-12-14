// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.view.ui.ProEditTextFontStyleView;
import com.fotoable.fotoproedit.view.ui.scroll.StyleItemView;

public class amk
    implements android.view.View.OnClickListener
{

    final ProEditTextFontStyleView a;

    public amk(ProEditTextFontStyleView proedittextfontstyleview)
    {
        a = proedittextfontstyleview;
        super();
    }

    public void onClick(View view)
    {
        if (a.listener != null)
        {
            a.bottom_4.setSelected(false);
            a.bottom_5.setSelected(false);
            a.bottom_6.setSelected(true);
            a.listener.a("right", Integer.valueOf(2));
        }
    }
}
