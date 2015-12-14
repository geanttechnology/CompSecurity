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
//            b, c

final class <init> extends ModernAsyncTask
{

    private ctivity.d a;

    private transient d a()
    {
        Object obj = b.g(a.a).b;
        com.photo.gpu.e.ReadPixelsResultType readpixelsresulttype = com.photo.gpu.e.ReadPixelsResultType.ReadPixelsResultTypeBitmap;
        obj = ((GPUImage) (obj)).a(((GPUImage) (obj)).e, readpixelsresulttype);
        try
        {
            Thread.sleep(300L);
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
            return ((d) (obj));
        }
        return ((d) (obj));
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (d)obj;
        b.a(a.a, false);
        ((EditorActivity)a.a.getActivity()).e();
        AnalyticUtils.getInstance(a.a.getActivity()).track(new com.socialin.android.apiv3.events.actory.EditToolsApplyEvent("tool_adjust"));
        e.a().e.c("adjust");
        a.a.g.a(a.a, ((d) (obj)).a, RasterAction.create(((d) (obj)).a, e.a().d.getHistoryDataDirectory()));
    }

    protected final void onPreExecute()
    {
        ((EditorActivity)a.a.getActivity()).d();
    }

    tion(tion tion)
    {
        a = tion;
        super();
    }

    // Unreferenced inner class com/picsart/studio/editor/fragment/b$10

/* anonymous class */
    final class b._cls10
        implements com.picsart.studio.editor.fragment.c
    {

        final b a;

        public final void a(Bitmap bitmap)
        {
            Object obj = a.getActivity();
            if (obj != null && !((Activity) (obj)).isFinishing())
            {
                obj = new ImageView(((android.content.Context) (obj)));
                ((ImageView) (obj)).setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                ((ImageView) (obj)).setImageBitmap(bitmap);
                ((ImageView) (obj)).setBackgroundColor(0xff000000);
                bitmap = a.getView();
                if (bitmap != null)
                {
                    ((FrameLayout)bitmap.findViewById(0x7f10053f)).addView(((View) (obj)));
                }
                b.a(a, true);
                (new b._cls10._cls1(this)).executeOnExecutor(b.o(a), new Void[] {
                    null
                });
            }
        }

            
            {
                a = b1;
                super();
            }
    }

}
