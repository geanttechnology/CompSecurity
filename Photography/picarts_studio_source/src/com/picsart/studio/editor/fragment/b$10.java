// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.photo.gpu.GPUImage;
import com.photo.gpu.GPUImageView;
import com.photo.gpu.d;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.ModernAsyncTask;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            c, b

final class a
    implements com.picsart.studio.editor.fragment.c
{

    final b a;

    public final void a(Bitmap bitmap)
    {
        Object obj = a.getActivity();
        if (obj != null && !((Activity) (obj)).isFinishing())
        {
            obj = new ImageView(((android.content.Context) (obj)));
            ((ImageView) (obj)).setScaleType(android.widget.View.ScaleType.FIT_XY);
            ((ImageView) (obj)).setImageBitmap(bitmap);
            ((ImageView) (obj)).setBackgroundColor(0xff000000);
            bitmap = a.getView();
            if (bitmap != null)
            {
                ((FrameLayout)bitmap.findViewById(0x7f10053f)).addView(((View) (obj)));
            }
            b.a(a, true);
            (new ModernAsyncTask() {

                private b._cls10 a;

                private transient d a()
                {
                    Object obj1 = b.g(a.a).b;
                    com.photo.gpu.GPUImage.ReadPixelsResultType readpixelsresulttype = com.photo.gpu.GPUImage.ReadPixelsResultType.ReadPixelsResultTypeBitmap;
                    obj1 = ((GPUImage) (obj1)).a(((GPUImage) (obj1)).e, readpixelsresulttype);
                    try
                    {
                        Thread.sleep(300L);
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        interruptedexception.printStackTrace();
                        return ((d) (obj1));
                    }
                    return ((d) (obj1));
                }

                protected final Object doInBackground(Object aobj[])
                {
                    return a();
                }

                protected final void onPostExecute(Object obj1)
                {
                    obj1 = (d)obj1;
                    b.a(a.a, false);
                    ((EditorActivity)a.a.getActivity()).e();
                    AnalyticUtils.getInstance(a.a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.EditToolsApplyEvent("tool_adjust"));
                    e.a().e.c("adjust");
                    a.a.g.a(a.a, ((d) (obj1)).a, RasterAction.create(((d) (obj1)).a, e.a().d.getHistoryDataDirectory()));
                }

                protected final void onPreExecute()
                {
                    ((EditorActivity)a.a.getActivity()).d();
                }

            
            {
                a = b._cls10.this;
                super();
            }
            }).executeOnExecutor(b.o(a), new Void[] {
                null
            });
        }
    }

    k(b b1)
    {
        a = b1;
        super();
    }
}
