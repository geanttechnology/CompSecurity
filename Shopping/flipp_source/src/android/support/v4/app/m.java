// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package android.support.v4.app:
//            o, db

final class m extends o
{

    private db a;

    public m(db db1)
    {
        a = db1;
    }

    public final Parcelable a(View view, Matrix matrix, RectF rectf)
    {
        db db1 = a;
        int i = Math.round(rectf.width());
        int j = Math.round(rectf.height());
        Object obj = null;
        Bitmap bitmap = obj;
        if (i > 0)
        {
            bitmap = obj;
            if (j > 0)
            {
                if (db1.a == null)
                {
                    db1.a = new Matrix();
                }
                db1.a.set(matrix);
                db1.a.postTranslate(-rectf.left, -rectf.top);
                bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
                matrix = new Canvas(bitmap);
                matrix.concat(db1.a);
                view.draw(matrix);
            }
        }
        return bitmap;
    }

    public final View a(Context context, Parcelable parcelable)
    {
        ImageView imageview = null;
        if (parcelable instanceof Bitmap)
        {
            parcelable = (Bitmap)parcelable;
            imageview = new ImageView(context);
            imageview.setImageBitmap(parcelable);
        }
        return imageview;
    }
}
