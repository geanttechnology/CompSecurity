// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import java.util.List;

// Referenced classes of package com.socialin.android.photo.draw.dialog:
//            SelectCanvasSizeDialog, e

final class c
    implements android.widget.stener
{

    private List a;
    private ImageButton b;
    private ImageButton c;
    private SelectCanvasSizeDialog d;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (e)a.get(i);
        SelectCanvasSizeDialog.a(d).setText(String.valueOf(((e) (adapterview)).b));
        SelectCanvasSizeDialog.b(d).setText(String.valueOf(((e) (adapterview)).c));
        if (SelectCanvasSizeDialog.b(((e) (adapterview)).b, ((e) (adapterview)).c) == ageOrientation.PORTRAIT)
        {
            SelectCanvasSizeDialog.a(b, false);
            SelectCanvasSizeDialog.a(c, true);
            return;
        } else
        {
            SelectCanvasSizeDialog.a(b, true);
            SelectCanvasSizeDialog.a(c, false);
            return;
        }
    }

    ageOrientation(SelectCanvasSizeDialog selectcanvassizedialog, List list, ImageButton imagebutton, ImageButton imagebutton1)
    {
        d = selectcanvassizedialog;
        a = list;
        b = imagebutton;
        c = imagebutton1;
        super();
    }
}
