// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.a.b;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package android.support.v4.app:
//            ag

public final class android.support.v4.app.a extends b
{
    private static final class a extends b.a
    {

        private ag a;

        public final Parcelable a(View view, Matrix matrix, RectF rectf)
        {
            ag ag1 = a;
            if (!(view instanceof ImageView)) goto _L2; else goto _L1
_L1:
            Object obj;
            ImageView imageview;
            Object obj2;
            imageview = (ImageView)view;
            obj = imageview.getDrawable();
            obj2 = imageview.getBackground();
            if (obj == null || obj2 != null) goto _L2; else goto _L3
_L3:
            obj2 = ag.a(((android.graphics.drawable.Drawable) (obj)));
            if (obj2 == null) goto _L2; else goto _L4
_L4:
            obj = new Bundle();
            ((Bundle) (obj)).putParcelable("sharedElement:snapshot:bitmap", ((Parcelable) (obj2)));
            ((Bundle) (obj)).putString("sharedElement:snapshot:imageScaleType", imageview.getScaleType().toString());
            if (imageview.getScaleType() == android.widget.ImageView.ScaleType.MATRIX)
            {
                view = imageview.getImageMatrix();
                matrix = new float[9];
                view.getValues(matrix);
                ((Bundle) (obj)).putFloatArray("sharedElement:snapshot:imageMatrix", matrix);
            }
_L6:
            return ((Parcelable) (obj));
_L2:
            int j = Math.round(rectf.width());
            int i = Math.round(rectf.height());
            Object obj1 = null;
            obj = obj1;
            if (j > 0)
            {
                obj = obj1;
                if (i > 0)
                {
                    float f = Math.min(1.0F, (float)android.support.v4.app.ag.b / (float)(j * i));
                    j = (int)((float)j * f);
                    i = (int)((float)i * f);
                    if (ag1.a == null)
                    {
                        ag1.a = new Matrix();
                    }
                    ag1.a.set(matrix);
                    ag1.a.postTranslate(-rectf.left, -rectf.top);
                    ag1.a.postScale(f, f);
                    matrix = Bitmap.createBitmap(j, i, android.graphics.Bitmap.Config.ARGB_8888);
                    rectf = new Canvas(matrix);
                    rectf.concat(ag1.a);
                    view.draw(rectf);
                    return matrix;
                }
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        public final View a(Context context, Parcelable parcelable)
        {
            return ag.a(context, parcelable);
        }

        public a(ag ag1)
        {
            a = ag1;
        }
    }


    static b.a a(ag ag)
    {
        a a1 = null;
        if (ag != null)
        {
            a1 = new a(ag);
        }
        return a1;
    }
}
