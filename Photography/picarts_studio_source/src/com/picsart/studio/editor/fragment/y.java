// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.photo.morph.StretchActivityMainProcess;
import com.picsart.studio.EditingData;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.socialin.android.util.w;
import com.socialin.android.util.x;
import java.io.File;
import java.util.HashMap;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i

public final class y extends i
{

    private File c;

    public y()
    {
    }

    public final Tool e()
    {
        return Tool.STRETCH;
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
                Bundle bundle = intent.getExtras();
                j = PicsartContext.a(getActivity());
                if (intent.hasExtra("bufferData"))
                {
                    intent = w.a((HashMap)bundle.getSerializable("bufferData"), j, 0);
                } else
                {
                    intent = w.b(bundle.getString("path"), j, 0);
                }
                if (intent != null)
                {
                    g.a(this, intent, RasterAction.create(intent, com.picsart.studio.editor.e.a().d.getHistoryDataDirectory()));
                    if (bundle.containsKey("editing_data"))
                    {
                        Log.e("ex1", "extras.containsKey(CommonConstants.EXTRA_EDITING_DATA)");
                        intent = (EditingData)bundle.getParcelable("editing_data");
                        com.picsart.studio.editor.e.a().e = intent;
                    }
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
            obj = new Intent(getActivity(), com/photo/morph/StretchActivityMainProcess);
            ((Intent) (obj)).putExtra("bufferData", bundle);
            ((Intent) (obj)).putExtra("degree", 0);
            ((Intent) (obj)).putExtra("maxPixels", PicsartContext.a());
            ((Intent) (obj)).putExtra("launchSource", "editor");
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
