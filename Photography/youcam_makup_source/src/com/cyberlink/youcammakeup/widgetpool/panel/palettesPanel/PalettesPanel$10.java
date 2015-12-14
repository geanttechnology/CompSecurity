// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import android.view.View;
import android.widget.AdapterView;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel:
//            PalettesPanel, a

class a
    implements android.widget.mClickListener
{

    final PalettesPanel a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        view = a.getActivity();
        if (view instanceof EditViewActivity)
        {
            d d1 = PalettesPanel.j(a).a(i);
            String s = d1.d();
            adapterview = (String)PalettesPanel.i(a).get(s);
            PalettesPanel.g(a).put(d1.e(), s);
            if (adapterview == null)
            {
                adapterview = (String)PanelDataCenter.a().l(s).get(0);
            }
            ((EditViewActivity)view).a(missType.b, adapterview);
        }
    }

    missType(PalettesPanel palettespanel)
    {
        a = palettespanel;
        super();
    }
}
