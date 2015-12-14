// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.SeekBar;
import com.socialin.android.dialog.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.picsart.collages:
//            e, CollageCreatorView, a, CollageImage

final class a
    implements Runnable
{

    private Bundle a;
    private e b;

    public final void run()
    {
        float f1 = 0.0F;
        e.l(b).show();
        float f;
        Object obj;
        int i;
        if (e.b(b).b == null || e.b(b).b.isEmpty())
        {
            if (a == null || e.m(b) == 2)
            {
                e.n(b);
                i = 1;
            } else
            {
                e.a(b, a);
                i = 1;
            }
        } else
        {
            i = 0;
        }
        obj = e.b(b).b.iterator();
        f = 3.402823E+38F;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            float f2 = ((a)((Iterator) (obj)).next()).u;
            if (f > f2)
            {
                f = f2;
            }
        } while (true);
        e.a(b, f * (e.o(b) / 100F));
        obj = e.b(b);
        if (e.m(b) == 2)
        {
            f = 0.0F;
        } else
        {
            f = e.o(b);
        }
        ((CollageCreatorView) (obj)).setStrokeWidth(f);
        obj = e.b(b);
        if (e.m(b) == 2)
        {
            f = 0.0F;
        } else
        {
            f = e.o(b);
        }
        ((CollageCreatorView) (obj)).setBorderWidth(f);
        if (a != null)
        {
            a.getInt("count");
            int j = a.getInt("activeCellIndex");
            int l = a.getInt("cornerRadius");
            e.b(b).setActiveCellIndex(j);
            if (i != 0)
            {
                Object obj1 = e.b(b);
                f = f1;
                if (e.m(b) == 1)
                {
                    f = a.getFloat("borderWidth");
                }
                ((CollageCreatorView) (obj1)).setBorderWidth(f);
                e.j(b).setProgress((int)e.h(b));
                e.b(b).setCornerRadiusPercent(l);
                e.p(b).setProgress(l);
                e.b(b).setCollageRotateAngle(a.getInt("rotateAngle"));
                e.b(b, a.getInt("borderWidthProgress"));
                e.a(b, e.q(b));
                HashMap hashmap;
                Matrix matrix;
                float af[];
                int k;
                if (TextUtils.isEmpty(e.b(b).n))
                {
                    if (!TextUtils.isEmpty(a.getString("bgImagePath")))
                    {
                        b.a(a.getString("bgImagePath"));
                    } else
                    {
                        e.b(b).setBackgroundColor(a.getInt("bgImageColor"));
                    }
                }
            }
            obj1 = e.b(b).b;
            k = a.getInt("imagesCount");
            hashmap = (HashMap)a.getSerializable("importedImages");
            i = 0;
            while (i < k) 
            {
                matrix = new Matrix();
                af = a.getFloatArray((new StringBuilder("matrix")).append(i).toString());
                if (af != null)
                {
                    matrix.setValues(af);
                }
                CollageImage collageimage = (CollageImage)hashmap.get(Integer.valueOf(i));
                if (i < ((List) (obj1)).size())
                {
                    if (collageimage != null)
                    {
                        ((a)((List) (obj1)).get(i)).v = true;
                        ((a)((List) (obj1)).get(i)).i = matrix;
                        e.b(b).setImageToCell(collageimage, i, true, matrix, true);
                    }
                } else
                {
                    e.b(b).s.put(Integer.valueOf(i), collageimage);
                }
                i++;
            }
        }
        e.l(b).dismiss();
        if (b.getActivity() != null && b.getActivity().getIntent() != null && b.getActivity().getIntent().getIntExtra("itemsCount", 0) > 0)
        {
            e.b(b, b.getActivity().getIntent().getExtras());
        }
    }

    geImage(e e1, Bundle bundle)
    {
        b = e1;
        a = bundle;
        super();
    }
}
