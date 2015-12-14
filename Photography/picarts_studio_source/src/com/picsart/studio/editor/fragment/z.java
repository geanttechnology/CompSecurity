// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.picsart.studio.EditingData;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.editor.view.SvgCropView;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.colorpicker.f;
import com.socialin.android.colorpicker.g;
import com.socialin.android.photo.frame.a;
import com.socialin.android.util.ScaleRotateGestureDetector;
import com.socialin.android.util.c;
import com.socialin.android.util.l;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i

public class z extends i
{

    private static final String c = com/picsart/studio/editor/fragment/z.getSimpleName();
    private SvgCropView d;
    private int e;
    private android.graphics.BitmapFactory.Options f;
    private final com.socialin.android.colorpicker.c i = new com.socialin.android.colorpicker.c() {

        private z a;

        public final void a(int j)
        {
            com.picsart.studio.editor.fragment.z.a(a).setSvgColor(j);
        }

            
            {
                a = z.this;
                super();
            }
    };

    public z()
    {
        e = 0;
        f = new android.graphics.BitmapFactory.Options();
    }

    static int a(z z1, int j)
    {
        z1.e = j;
        return j;
    }

    private View a(int j, ViewGroup viewgroup)
    {
        if (PicsartContext.a == com.picsart.studio.PicsartContext.MemoryType.LOW)
        {
            f.inSampleSize = 2;
        }
        int k = (int)getResources().getDimension(0x7f0b011f);
        ImageView imageview = (ImageView)LayoutInflater.from(getActivity()).inflate(0x7f030123, viewgroup, false);
        try
        {
            imageview.setImageResource(a.e[j]);
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap bitmap = null;
            while (bitmap == null) 
            {
                if (options.inSampleSize > 4)
                {
                    bitmap = null;
                } else
                {
                    bitmap = com.socialin.android.util.c.a(getResources(), a.e[j], options, c);
                    imageview.setImageBitmap(bitmap);
                    options.inSampleSize = options.inSampleSize + 1;
                }
            }
        }
        imageview.setPadding(k, k, k, k);
        imageview.setOnClickListener(new android.view.View.OnClickListener(viewgroup, j) {

            private ViewGroup a;
            private int b;
            private z c;

            public final void onClick(View view)
            {
                View view1 = a.getChildAt(com.picsart.studio.editor.fragment.z.c(c));
                if (view == view1)
                {
                    return;
                }
                AnalyticUtils.getInstance(c.getActivity()).trackLocalAction((new StringBuilder("frameSvgCategory:svg selected ")).append(b).toString());
                com.picsart.studio.editor.fragment.z.a(c).setSvgRes(a.f[b]);
                if (view1 != null)
                {
                    view1.setSelected(false);
                }
                view.setSelected(true);
                com.picsart.studio.editor.fragment.z.a(c, b);
            }

            
            {
                c = z.this;
                a = viewgroup;
                b = j;
                super();
            }
        });
        return imageview;
    }

    static SvgCropView a(z z1)
    {
        return z1.d;
    }

    static void a(z z1, com.socialin.android.colorpicker.c c1, int j)
    {
        g g1 = new g();
        g1.a = c1;
        g1.e = j;
        g1.f = j;
        g1.c = true;
        z1 = g1.a(z1.getActivity());
        if (!z1.isShowing())
        {
            z1.show();
        }
    }

    static com.socialin.android.colorpicker.c b(z z1)
    {
        return z1.i;
    }

    static int c(z z1)
    {
        return z1.e;
    }

    public final void a(Bitmap bitmap)
    {
        super.a(bitmap);
        if (d != null)
        {
            d.setImage(bitmap);
        }
    }

    public final Tool e()
    {
        return Tool.FRAME_PHOTO;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03011e, viewgroup, false);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("selectedSvgIndexKey", e);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        view.setLayerType(1, null);
        d = (SvgCropView)view.findViewById(0x7f1001c2);
        if (h != null)
        {
            d.setImage(h);
        }
        if (bundle != null)
        {
            e = bundle.getInt("selectedSvgIndexKey");
        }
        bundle = (ViewGroup)getView().findViewById(0x7f100629);
        for (int j = 0; j < a.e.length; j++)
        {
            bundle.addView(a(j, bundle));
        }

        bundle.getChildAt(e).setSelected(true);
        d.setSvgRes(a.f[e]);
        view.findViewById(0x7f10054f).setOnClickListener(new android.view.View.OnClickListener() {

            private z a;

            public final void onClick(View view1)
            {
                a.g.a(a);
            }

            
            {
                a = z.this;
                super();
            }
        });
        view.findViewById(0x7f100550).setOnClickListener(new android.view.View.OnClickListener() {

            private z a;

            public final void onClick(View view1)
            {
                com.picsart.studio.editor.e.a().e.d("svg_crop");
                view1 = com.picsart.studio.editor.fragment.z.a(a);
                Object obj = new RectF(0.0F, 0.0F, ((SvgCropView) (view1)).e.a, ((SvgCropView) (view1)).e.b);
                Object obj1 = new RectF();
                ((SvgCropView) (view1)).h.mapRect(((RectF) (obj1)), ((RectF) (obj)));
                int k = (int)Math.max(((SvgCropView) (view1)).d.getWidth(), ((RectF) (obj1)).width());
                int i1 = (int)Math.max(((SvgCropView) (view1)).d.getHeight(), ((RectF) (obj1)).height());
                int j1 = (int)Math.min(((SvgCropView) (view1)).d.getWidth(), ((RectF) (obj1)).width());
                int k1 = (int)Math.min(((SvgCropView) (view1)).d.getHeight(), ((RectF) (obj1)).height());
                Matrix matrix = new Matrix(((SvgCropView) (view1)).i.f);
                float f1 = 1.0F / l.a(matrix);
                matrix.postScale(f1, f1);
                ((SvgCropView) (view1)).h.postScale(f1, f1);
                ((SvgCropView) (view1)).h.mapRect(((RectF) (obj1)), ((RectF) (obj)));
                f1 = ((RectF) (obj1)).width();
                float f2 = ((RectF) (obj1)).height();
                float f4;
                float f5;
                Canvas canvas;
                if (f1 > (float)k)
                {
                    float f3 = (float)k / f1;
                    f1 = f3;
                    f2 *= f3;
                } else
                if (f1 < (float)j1)
                {
                    f4 = (float)j1 / f1;
                    f1 = f4;
                    f2 *= f4;
                } else
                {
                    f1 = 1.0F;
                }
                if (f2 <= (float)i1) goto _L2; else goto _L1
_L1:
                f4 = f1 * ((float)i1 / f2);
_L4:
                matrix.postScale(f4, f4);
                ((SvgCropView) (view1)).h.postScale(f4, f4);
                ((SvgCropView) (view1)).h.mapRect(((RectF) (obj1)), ((RectF) (obj)));
                k = (int)((RectF) (obj1)).width();
                i1 = (int)((RectF) (obj1)).height();
                f1 = ((SvgCropView) (view1)).f.left;
                f2 = ((RectF) (obj1)).left;
                f4 = ((SvgCropView) (view1)).f.top;
                f5 = ((RectF) (obj1)).top;
                obj = new Path();
                ((Path) (obj)).addPath(view1.a(), ((SvgCropView) (view1)).h);
                obj1 = com.socialin.android.util.c.a(k, i1, android.graphics.Bitmap.Config.ARGB_8888, SvgCropView.a);
                canvas = new Canvas(((Bitmap) (obj1)));
                canvas.translate(f1 - f2, f4 - f5);
                canvas.save();
                canvas.clipPath(((Path) (obj)));
                canvas.drawBitmap(((SvgCropView) (view1)).d, matrix, SvgCropView.b);
                canvas.restore();
                ((SvgCropView) (view1)).e.a(canvas, ((SvgCropView) (view1)).h);
                view1.c = false;
                a.g.a(a, ((Bitmap) (obj1)), RasterAction.create(((Bitmap) (obj1)), com.picsart.studio.editor.e.a().d.getHistoryDataDirectory()));
                return;
_L2:
                f4 = f1;
                if (f2 < (float)k1)
                {
                    f4 = f1 * ((float)k1 / f2);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = z.this;
                super();
            }
        });
        view.findViewById(0x7f100597).setOnClickListener(new android.view.View.OnClickListener() {

            private z a;

            public final void onClick(View view1)
            {
                view1 = com.picsart.studio.editor.fragment.z.a(a);
                Matrix matrix = ((SvgCropView) (view1)).i.f;
                ((SvgCropView) (view1)).j.set(((SvgCropView) (view1)).g);
                matrix.mapRect(((SvgCropView) (view1)).j);
                matrix.postRotate(10F, ((SvgCropView) (view1)).j.centerX(), ((SvgCropView) (view1)).j.centerY());
                view1.invalidate();
            }

            
            {
                a = z.this;
                super();
            }
        });
        view.findViewById(0x7f100596).setOnClickListener(new android.view.View.OnClickListener() {

            private z a;

            public final void onClick(View view1)
            {
                view1 = com.picsart.studio.editor.fragment.z.a(a);
                Matrix matrix = ((SvgCropView) (view1)).i.f;
                ((SvgCropView) (view1)).j.set(((SvgCropView) (view1)).g);
                matrix.mapRect(((SvgCropView) (view1)).j);
                matrix.postRotate(-10F, ((SvgCropView) (view1)).j.centerX(), ((SvgCropView) (view1)).j.centerY());
                view1.invalidate();
            }

            
            {
                a = z.this;
                super();
            }
        });
        view.findViewById(0x7f1003ae).setOnClickListener(new android.view.View.OnClickListener() {

            private z a;

            public final void onClick(View view1)
            {
                int l = com.picsart.studio.editor.fragment.z.a(a).e.c;
                view1 = a;
                com.socialin.android.colorpicker.c c1 = z.b(a);
                int k = l;
                if (l == -256)
                {
                    k = 0xff000000;
                }
                com.picsart.studio.editor.fragment.z.a(view1, c1, k);
            }

            
            {
                a = z.this;
                super();
            }
        });
    }

}
