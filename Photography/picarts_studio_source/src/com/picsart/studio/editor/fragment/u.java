// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.picsart.studio.EditingData;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.socialin.android.photo.select.SelectionActivity;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i

public final class u extends i
{

    public u()
    {
    }

    public final Tool e()
    {
        return Tool.SELECTION;
    }

    public final boolean f()
    {
        return false;
    }

    public final void onActivityResult(int j, int k, Intent intent)
    {
        super.onActivityResult(j, k, intent);
        if (j != 1) goto _L2; else goto _L1
_L1:
        if (k != -1) goto _L4; else goto _L3
_L3:
        Object obj;
        obj = intent.getExtras();
        PicsartContext.a(getActivity());
        intent = SelectionActivity.a;
        SelectionActivity.a = null;
        if (intent == null) goto _L6; else goto _L5
_L5:
        if (((Bundle) (obj)).containsKey("editing_data"))
        {
            Log.e("ex1", "extras.containsKey(CommonConstants.EXTRA_EDITING_DATA)");
            obj = (EditingData)((Bundle) (obj)).getParcelable("editing_data");
            com.picsart.studio.editor.e.a().e = ((EditingData) (obj));
        }
        g.a(this, intent, RasterAction.create(intent, com.picsart.studio.editor.e.a().d.getHistoryDataDirectory()));
_L2:
        return;
_L6:
        g.a(this);
        return;
_L4:
        if (k == 0)
        {
            g.a(this);
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            bundle = SelectionActivity.a(getActivity(), h, com.picsart.studio.editor.e.a().e);
            bundle.putExtra("editing_data", com.picsart.studio.editor.e.a().e);
            startActivityForResult(bundle, 1);
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("a", 1);
    }
}
