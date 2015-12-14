// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.SeekBar;
import com.fotoable.fotoproedit.activity.ProEditAdjustActivity;
import com.fotoable.fotoproedit.activity.adjust.AdjustButtomItemView;
import java.util.HashMap;

public class ael
    implements android.view.View.OnClickListener
{

    final ProEditAdjustActivity a;

    public ael(ProEditAdjustActivity proeditadjustactivity)
    {
        a = proeditadjustactivity;
        super();
    }

    public void onClick(View view)
    {
        ProEditAdjustActivity.a(a).setSelected(false);
        ProEditAdjustActivity.b(a).setSelected(false);
        ProEditAdjustActivity.c(a).setSelected(false);
        ProEditAdjustActivity.d(a).setSelected(false);
        ProEditAdjustActivity.e(a).setSelected(false);
        ProEditAdjustActivity.f(a).setSelected(false);
        ProEditAdjustActivity.g(a).setSelected(false);
        ProEditAdjustActivity.h(a).setSelected(false);
        view.setSelected(true);
        ProEditAdjustActivity.a(a, view.getTag().toString());
        int i = ((Integer)ProEditAdjustActivity.j(a).get(ProEditAdjustActivity.i(a))).intValue();
        ProEditAdjustActivity.a(a, true);
        ProEditAdjustActivity.k(a).setProgress(i);
    }
}
