// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.content.Intent;
import android.os.Bundle;
import com.picsart.studio.EditingData;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.history.RasterAction;
import com.socialin.android.util.w;
import com.socialin.android.util.x;
import java.io.File;
import java.util.HashMap;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i

public final class e extends i
{

    private File c;

    public e()
    {
    }

    public final Tool e()
    {
        return Tool.CLONE;
    }

    public final boolean f()
    {
        return false;
    }

    public final void onActivityResult(int j, int k, Intent intent)
    {
        super.onActivityResult(j, k, intent);
        if (j == 1)
        {
            if (k == -1)
            {
                Object obj = intent.getExtras();
                j = PicsartContext.a(getActivity());
                if (intent.hasExtra("result_buffer_Data"))
                {
                    intent = w.a((HashMap)((Bundle) (obj)).getSerializable("result_buffer_Data"), j, 0);
                } else
                {
                    intent = w.b(((Bundle) (obj)).getString("path"), j, 0);
                }
                if (intent != null)
                {
                    if (((Bundle) (obj)).containsKey("editing_data"))
                    {
                        obj = (EditingData)((Bundle) (obj)).getParcelable("editing_data");
                        com.picsart.studio.editor.e.a().e = ((EditingData) (obj));
                    }
                    g.a(this, intent, RasterAction.create(intent, com.picsart.studio.editor.e.a().d.getHistoryDataDirectory()));
                } else
                {
                    g.a(this);
                }
                if (c != null)
                {
                    c.delete();
                }
            } else
            if (k == 0)
            {
                g.a(this);
                return;
            }
        }
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            c = new File(x.a(getActivity()), String.valueOf(System.currentTimeMillis()));
            bundle = c.getPath();
            Object obj = h;
            getActivity();
            bundle = w.a(bundle, ((android.graphics.Bitmap) (obj)));
            obj = new Intent(getActivity(), m.c());
            ((Intent) (obj)).putExtra("bufferData", bundle);
            ((Intent) (obj)).putExtra("degree", 0);
            ((Intent) (obj)).putExtra("maxPixel", PicsartContext.a(getActivity()));
            ((Intent) (obj)).putExtra("openedFromEffects", true);
            ((Intent) (obj)).putExtra("enable_effects_analytics", false);
            ((Intent) (obj)).putExtra("buffer_to_save", (new File(x.a(getActivity()), String.valueOf(System.currentTimeMillis()))).getPath());
            ((Intent) (obj)).putExtra("editing_data", com.picsart.studio.editor.e.a().e);
            startActivityForResult(((Intent) (obj)), 1);
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("a", 1);
    }
}
