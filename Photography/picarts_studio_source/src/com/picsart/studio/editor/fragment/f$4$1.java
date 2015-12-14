// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.view.View;
import com.picsart.studio.editor.view.CropEditorView;
import com.picsart.studio.editor.view.RulerView;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.Geom;
import myobfuscated.bj.a;
import myobfuscated.bj.b;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            f

final class a
    implements b
{

    private a a;

    public final void a(int i, int j)
    {
        Object obj = f.e(a.a);
        float f1 = ((CropEditorView) (obj)).e.width() / ((CropEditorView) (obj)).c;
        float f2 = i;
        float f3 = j;
        Geom.b(((CropEditorView) (obj)).i, f2 * f1, f1 * f3);
        f1 = ((CropEditorView) (obj)).f() / 2.0F;
        f2 = f1 / 2.0F;
        i = 0;
        do
        {
            if (i >= 20)
            {
                break;
            }
            ((CropEditorView) (obj)).a(((CropEditorView) (obj)).m, ((CropEditorView) (obj)).a(f1));
            if (((CropEditorView) (obj)).m.width() <= ((CropEditorView) (obj)).e.width() && ((CropEditorView) (obj)).m.height() <= ((CropEditorView) (obj)).e.height())
            {
                break;
            }
            f1 -= f2;
            f2 /= 2.0F;
            i++;
        } while (true);
        obj.h = ((CropEditorView) (obj)).a(f1);
        ((CropEditorView) (obj)).q.setProgress(f1);
        ((CropEditorView) (obj)).a(false, false);
        ((CropEditorView) (obj)).a(null, false);
        ((CropEditorView) (obj)).h();
        ((CropEditorView) (obj)).g();
        if (Math.abs(f1) <= 0.1F)
        {
            ((CropEditorView) (obj)).i();
        }
        ((CropEditorView) (obj)).invalidate();
        obj = AnalyticUtils.getInstance(a.a.getActivity());
        String s = f.f(a.a);
        CropEditorView cropeditorview = f.e(a.a);
        i = cropeditorview.s + 1;
        cropeditorview.s = i;
        ((AnalyticUtils) (obj)).track(new com.socialin.android.apiv3.events.Factory.ToolCropTryEvent(s, i, f.e(a.a).getRotation(), com.picsart.studio.editor.fragment.f.a(f.g(a.a)), f.h(a.a), a.a.h.getHeight(), a.a.h.getWidth(), a.a.h.getHeight(), a.a.h.getWidth(), "custom_size"));
    }

    View(View view)
    {
        a = view;
        super();
    }

    // Unreferenced inner class com/picsart/studio/editor/fragment/f$4

/* anonymous class */
    final class f._cls4
        implements android.view.View.OnClickListener
    {

        final f a;

        public final void onClick(View view)
        {
            view = new a();
            int k = f.e(a).b();
            int l = f.e(a).c();
            CropEditorView cropeditorview = f.e(a);
            float f1;
            int i;
            int j;
            if (cropeditorview.g % 2 == 0)
            {
                i = (int)cropeditorview.c;
            } else
            {
                i = (int)cropeditorview.d;
            }
            cropeditorview = f.e(a);
            if (cropeditorview.g % 2 == 0)
            {
                j = (int)cropeditorview.d;
            } else
            {
                j = (int)cropeditorview.c;
            }
            CropEditorView.d();
            CropEditorView.e();
            view.b = k;
            view.c = l;
            view.d = i;
            view.e = j;
            view.f = 30;
            view.g = 30;
            if (f.e(a).j)
            {
                f1 = f.e(a).k;
            } else
            {
                f1 = -1F;
            }
            view.h = f1;
            view.a = new f._cls4._cls1(this);
            view.show(a.getFragmentManager(), null);
        }

            
            {
                a = f1;
                super();
            }
    }

}
