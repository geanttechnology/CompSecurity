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
    implements android.view..OnClickListener
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
        view.a = new b() {

            private f._cls4 a;

            public final void a(int i1, int j1)
            {
                Object obj = f.e(a.a);
                float f2 = ((CropEditorView) (obj)).e.width() / ((CropEditorView) (obj)).c;
                float f3 = i1;
                float f4 = j1;
                Geom.b(((CropEditorView) (obj)).i, f3 * f2, f2 * f4);
                f2 = ((CropEditorView) (obj)).f() / 2.0F;
                f3 = f2 / 2.0F;
                i1 = 0;
                do
                {
                    if (i1 >= 20)
                    {
                        break;
                    }
                    ((CropEditorView) (obj)).a(((CropEditorView) (obj)).m, ((CropEditorView) (obj)).a(f2));
                    if (((CropEditorView) (obj)).m.width() <= ((CropEditorView) (obj)).e.width() && ((CropEditorView) (obj)).m.height() <= ((CropEditorView) (obj)).e.height())
                    {
                        break;
                    }
                    f2 -= f3;
                    f3 /= 2.0F;
                    i1++;
                } while (true);
                obj.h = ((CropEditorView) (obj)).a(f2);
                ((CropEditorView) (obj)).q.setProgress(f2);
                ((CropEditorView) (obj)).a(false, false);
                ((CropEditorView) (obj)).a(null, false);
                ((CropEditorView) (obj)).h();
                ((CropEditorView) (obj)).g();
                if (Math.abs(f2) <= 0.1F)
                {
                    ((CropEditorView) (obj)).i();
                }
                ((CropEditorView) (obj)).invalidate();
                obj = AnalyticUtils.getInstance(a.a.getActivity());
                String s = f.f(a.a);
                CropEditorView cropeditorview1 = f.e(a.a);
                i1 = cropeditorview1.s + 1;
                cropeditorview1.s = i1;
                ((AnalyticUtils) (obj)).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCropTryEvent(s, i1, f.e(a.a).getRotation(), com.picsart.studio.editor.fragment.f.a(f.g(a.a)), f.h(a.a), a.a.h.getHeight(), a.a.h.getWidth(), a.a.h.getHeight(), a.a.h.getWidth(), "custom_size"));
            }

            
            {
                a = f._cls4.this;
                super();
            }
        };
        view.show(a.getFragmentManager(), null);
    }

    _cls1.a(f f1)
    {
        a = f1;
        super();
    }
}
