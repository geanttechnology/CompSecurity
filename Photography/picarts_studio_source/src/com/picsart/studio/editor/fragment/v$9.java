// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.e;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.collage.ShapeCropView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            v

final class a
    implements android.view..OnClickListener
{

    final v a;

    public final void onClick(View view)
    {
        (new AsyncTask() {

            private v._cls9 a;

            protected final Object doInBackground(Object aobj[])
            {
                AnalyticUtils.getInstance(a.a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolShapeCropTryEvent(e.a().e.a, "save_to_clipart"));
                if (a.a.getActivity() != null && !a.a.getActivity().isFinishing())
                {
                    aobj = v.b(a.a).b();
                    com.socialin.android.photo.clipart.e.a(a.a.getActivity(), ((android.graphics.Bitmap) (aobj)), "collageCrop");
                }
                return null;
            }

            
            {
                a = v._cls9.this;
                super();
            }
        }).execute(new Void[0]);
    }

    _cls1.a(v v1)
    {
        a = v1;
        super();
    }
}
