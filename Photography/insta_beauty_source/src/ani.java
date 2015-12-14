// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.activity.font.ComButtonItemView;
import com.fotoable.fotoproedit.view.ui.scroll.TProEditTextBottomBar;

public class ani
    implements android.view.View.OnClickListener
{

    final TProEditTextBottomBar a;

    public ani(TProEditTextBottomBar tproedittextbottombar)
    {
        a = tproedittextbottombar;
        super();
    }

    public void onClick(View view)
    {
label0:
        {
            if (a.mListener != null)
            {
                a.mListener.a(com.fotoable.fotoproedit.view.ui.scroll.TProEditTextBottomBar.COMBOTTOMBTN.KEYBOARD);
                if (!a.bottom_1.isSelected())
                {
                    break label0;
                }
            }
            return;
        }
        TProEditTextBottomBar.access$000(a, a.bottom_1);
    }
}
