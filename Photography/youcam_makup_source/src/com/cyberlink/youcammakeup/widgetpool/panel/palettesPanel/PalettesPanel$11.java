// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import android.content.Intent;
import android.view.View;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.ExtraDownloadActivity;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.widgetpool.common.p;
import com.cyberlink.youcammakeup.widgetpool.common.q;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel:
//            PalettesPanel

class a
    implements q
{

    final PalettesPanel a;

    public void a(View view, int i, int j)
    {
        if (PalettesPanel.m(a))
        {
            PalettesPanel.k(a);
        } else
        {
            if (i == etteGroup.a(etteGroup.e) && j == 0)
            {
                view = new Intent(view.getContext(), com/cyberlink/youcammakeup/activity/ExtraDownloadActivity);
                view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(CategoryType.d));
                view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", a.getString(0x7f07033c));
                view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", CategoryType.d);
                view.putExtra("KEY_EXTRA_DOWNLOAD_BACK_TO_MAIN", false);
                a.startActivity(view);
                return;
            }
            PalettesPanel.e(a).a = i;
            PalettesPanel.e(a).b = j;
            view = a.getActivity();
            if (view instanceof EditViewActivity)
            {
                String s = ((aw)PalettesPanel.a(a, i).get(j)).a();
                ((EditViewActivity)view).a(missType.b, s);
                return;
            }
        }
    }

    missType(PalettesPanel palettespanel)
    {
        a = palettespanel;
        super();
    }
}
