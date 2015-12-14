// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.view.ui.ProEditTextFontStyleView;
import com.fotoable.fotoproedit.view.ui.scroll.StyleItemView;

public class amg
    implements android.view.View.OnClickListener
{

    final ProEditTextFontStyleView a;

    public amg(ProEditTextFontStyleView proedittextfontstyleview)
    {
        a = proedittextfontstyleview;
        super();
    }

    public void onClick(View view)
    {
        byte byte0 = 1;
        if (a.listener == null) goto _L2; else goto _L1
_L1:
        view = a.bottom_2;
        boolean flag;
        if (!a.bottom_2.isSelected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setSelected(flag);
        if (!a.bottom_1.isSelected()) goto _L4; else goto _L3
_L3:
        if (a.bottom_2.isSelected())
        {
            byte0 = 3;
        } else
        {
            byte0 = 2;
        }
_L6:
        a.listener.a("italic", Integer.valueOf(byte0));
_L2:
        return;
_L4:
        if (!a.bottom_2.isSelected())
        {
            byte0 = 0;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
