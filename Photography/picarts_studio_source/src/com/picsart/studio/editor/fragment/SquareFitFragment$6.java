// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.view.SquareFitEditorView;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.w;
import java.util.HashMap;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SquareFitFragment

final class a extends AsyncTask
{

    private Bundle a;
    private SquareFitFragment b;

    protected final Object doInBackground(Object aobj[])
    {
        int i = PicsartContext.a.getCollageImageMaxSize();
        aobj = a.getString("path");
        HashMap hashmap = (HashMap)a.getSerializable("bufferData");
        int j = a.getInt("degree");
        if (hashmap != null)
        {
            return w.a(hashmap, i, i, j);
        } else
        {
            return w.a(((String) (aobj)), i, i, j);
        }
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Bitmap)obj;
        AnalyticUtils analyticutils = AnalyticUtils.getInstance(b.getActivity());
        String s = SquareFitFragment.c;
        SquareFitEditorView squarefiteditorview = SquareFitFragment.c(b);
        int i = squarefiteditorview.l + 1;
        squarefiteditorview.l = i;
        analyticutils.track(new com.socialin.android.apiv3.events.FitTryEvent(s, "blur_bg_choose", i, SquareFitFragment.g(b).getHeight(), SquareFitFragment.g(b).getWidth()));
        SquareFitFragment.a(b, ((Bitmap) (obj)));
    }

    itTryEvent(SquareFitFragment squarefitfragment, Bundle bundle)
    {
        b = squarefitfragment;
        a = bundle;
        super();
    }
}
