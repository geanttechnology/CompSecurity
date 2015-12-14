// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.editor.view.TiltShiftEditorView;
import com.picsart.studio.view.FloatSeekBar;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.ModernAsyncTask;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            TiltShiftFragment

final class a extends ModernAsyncTask
{

    private TiltShiftFragment a;

    protected final Object doInBackground(Object aobj[])
    {
        if (TiltShiftFragment.d(a) == null)
        {
            return null;
        } else
        {
            return TiltShiftFragment.d(a).a(TiltShiftFragment.b(a));
        }
    }

    protected final void onCancelled(Object obj)
    {
        obj = (Bitmap)obj;
        TiltShiftFragment.o(a);
        if (obj != null && !((Bitmap) (obj)).isRecycled())
        {
            TiltShiftFragment.b(((Bitmap) (obj)));
        }
    }

    protected final void onPostExecute(Object obj)
    {
label0:
        {
            obj = (Bitmap)obj;
            if (obj != null)
            {
                TiltShiftFragment.o(a);
                if (a.getActivity() == null || a.getActivity().isFinishing() || !a.isAdded())
                {
                    break label0;
                }
                e.a().e.d(Tool.TILT_SHIFT.toString().toLowerCase());
                if (TiltShiftFragment.b(a) != null)
                {
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.iftCloseEvent(com.picsart.studio.editor.fragment.TiltShiftFragment.c, "done", TiltShiftFragment.n(a).name().toLowerCase(), String.valueOf(TiltShiftFragment.k(a).a()), TiltShiftFragment.d(a).l, TiltShiftFragment.b(a).getHeight(), TiltShiftFragment.b(a).getWidth(), TiltShiftFragment.d(a).j));
                }
                a.g.a(a, ((Bitmap) (obj)), RasterAction.create(((Bitmap) (obj)), e.a().d.getHistoryDataDirectory()));
            }
            return;
        }
        TiltShiftFragment.b(((Bitmap) (obj)));
    }

    ltShiftMode(TiltShiftFragment tiltshiftfragment)
    {
        a = tiltshiftfragment;
        super();
    }
}
