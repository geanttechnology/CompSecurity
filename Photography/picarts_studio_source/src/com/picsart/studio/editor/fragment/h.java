// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.content.Intent;
import android.os.Bundle;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.helper.a;
import com.picsart.studio.editor.history.RasterAction;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i

public final class h extends i
{

    public h()
    {
    }

    public final Tool e()
    {
        return Tool.DRAW;
    }

    public final boolean f()
    {
        return false;
    }

    public final void onActivityResult(int j, int k, Intent intent)
    {
        super.onActivityResult(j, k, intent);
        if (j == 1 && k == -1)
        {
            android.graphics.Bitmap bitmap = a.a().a(intent.getIntExtra("bitmap.key", -1));
            if (bitmap != null)
            {
                intent = (EditingData)intent.getParcelableExtra("editing_data");
                com.picsart.studio.editor.e.a().e = intent;
                g.a(this, bitmap, RasterAction.create(bitmap, com.picsart.studio.editor.e.a().d.getHistoryDataDirectory()));
                return;
            } else
            {
                g.a(this);
                return;
            }
        } else
        {
            g.a(this);
            return;
        }
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            int j = a.a().a(h);
            bundle = new Intent(getActivity(), m.g());
            bundle.putExtra("comingFrom", 0);
            bundle.putExtra("extra.has.bg.image", true);
            bundle.putExtra("editing_data", com.picsart.studio.editor.e.a().e);
            bundle.putExtra("origin", com.picsart.studio.editor.e.a().e.b);
            bundle.putExtra("bitmap.key", j);
            startActivityForResult(bundle, 1);
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("a", 1);
    }
}
