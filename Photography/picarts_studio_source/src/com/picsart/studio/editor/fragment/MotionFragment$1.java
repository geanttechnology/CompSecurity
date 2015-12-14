// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.editor.view.MotionView;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.motion.MotionDrawer;
import com.socialin.android.util.ModernAsyncTask;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            MotionFragment

final class a extends ModernAsyncTask
{

    private MotionFragment a;

    protected final Object doInBackground(Object aobj[])
    {
        if (com.picsart.studio.editor.fragment.MotionFragment.c(a) == null)
        {
            return null;
        } else
        {
            return com.picsart.studio.editor.fragment.MotionFragment.c(a).i();
        }
    }

    protected final volatile void onCancelled(Object obj)
    {
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Bitmap)obj;
        if (obj != null)
        {
            com.picsart.studio.editor.fragment.MotionFragment.c(a).g();
            com.picsart.studio.editor.fragment.MotionFragment.c(a).r.b();
            AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.lMotionCloseEvent(e.a().e.a, "done", (int)MotionFragment.d(a).d()));
            a.g.a(a, ((Bitmap) (obj)), RasterAction.create(((Bitmap) (obj)), e.a().d.getHistoryDataDirectory()));
        }
    }

    MotionCloseEvent(MotionFragment motionfragment)
    {
        a = motionfragment;
        super();
    }
}
