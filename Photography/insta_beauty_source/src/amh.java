// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.view.ui.ProEditTextFontStyleView;
import com.fotoable.fotoproedit.view.ui.scroll.StyleItemView;

public class amh
    implements android.view.View.OnClickListener
{

    final ProEditTextFontStyleView a;

    public amh(ProEditTextFontStyleView proedittextfontstyleview)
    {
        a = proedittextfontstyleview;
        super();
    }

    public void onClick(View view)
    {
        int i = 1;
        if (a.listener != null)
        {
            view = a.bottom_3;
            boolean flag;
            if (!a.bottom_3.isSelected())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setSelected(flag);
            if (!a.bottom_3.isSelected())
            {
                i = 0;
            }
            a.listener.a("shadow", Integer.valueOf(i));
        }
    }
}
