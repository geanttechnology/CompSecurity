// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.filters;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import com.aviary.android.feather.headless.filters.NativeFilter;
import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionFactory;
import com.aviary.android.feather.headless.moa.MoaActionList;
import java.util.Iterator;

public class AdjustFilter extends NativeFilter
{

    private static final String TAG = "AdjustFilter";

    AdjustFilter()
    {
        super(new String[0]);
    }

    private Bitmap generateIntermediateBitmap(Bitmap bitmap, MoaAction moaaction)
    {
        Log.i("AdjustFilter", (new StringBuilder()).append("generateIntermediateBitmap: ").append(moaaction).toString());
        if (moaaction == null)
        {
            return bitmap;
        }
        String s = moaaction.getName();
        Log.d("AdjustFilter", (new StringBuilder()).append("name: ").append(s).toString());
        if ("flip".equals(s))
        {
            return generateIntermediateBitmapFlip(bitmap, moaaction);
        }
        if ("rotate90".equals(s))
        {
            return generateIntermediateBitmapRotate90(bitmap, moaaction);
        } else
        {
            return null;
        }
    }

    private Bitmap generateIntermediateBitmapFlip(Bitmap bitmap, MoaAction moaaction)
    {
        Log.i("AdjustFilter", "generateIntermediateBitmapFlip");
        Object obj = (Boolean)moaaction.getValue("horizontal", Boolean.valueOf(false));
        Boolean boolean1 = (Boolean)moaaction.getValue("vertical", Boolean.valueOf(false));
        Log.d("AdjustFilter", (new StringBuilder()).append("horizontal: ").append(obj).append(", vertical: ").append(boolean1).toString());
        if (!((Boolean) (obj)).booleanValue() && !boolean1.booleanValue())
        {
            return bitmap;
        }
        moaaction = new Paint();
        Matrix matrix = new Matrix();
        matrix.setScale(1.0F, 1.0F);
        if (((Boolean) (obj)).booleanValue())
        {
            matrix.postScale(-1F, 1.0F);
            matrix.postTranslate(bitmap.getWidth(), 0.0F);
        }
        if (boolean1.booleanValue())
        {
            matrix.postScale(1.0F, -1F);
            matrix.postTranslate(0.0F, bitmap.getHeight());
        }
        obj = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        (new Canvas(((Bitmap) (obj)))).drawBitmap(bitmap, matrix, moaaction);
        return ((Bitmap) (obj));
    }

    private Bitmap generateIntermediateBitmapRotate90(Bitmap bitmap, MoaAction moaaction)
    {
        Log.i("AdjustFilter", "generateIntermediateBitmapRotate90");
        Object obj = (Integer)moaaction.getValue("angle", Integer.valueOf(0));
        if (((Integer) (obj)).intValue() == 0)
        {
            return bitmap;
        } else
        {
            Object obj1 = new RectF(0.0F, 0.0F, bitmap.getWidth(), bitmap.getHeight());
            moaaction = new Matrix();
            moaaction.setScale(1.0F, 1.0F);
            moaaction.postRotate(((Integer) (obj)).intValue());
            obj = new RectF();
            moaaction.mapRect(((RectF) (obj)), ((RectF) (obj1)));
            obj1 = Bitmap.createBitmap((int)((RectF) (obj)).width(), (int)((RectF) (obj)).height(), bitmap.getConfig());
            Canvas canvas = new Canvas(((Bitmap) (obj1)));
            Paint paint = new Paint();
            moaaction.postTranslate(-((RectF) (obj)).left, -((RectF) (obj)).top);
            canvas.drawBitmap(bitmap, moaaction, paint);
            return ((Bitmap) (obj1));
        }
    }

    private void setFeatherEditSize(int i, int j)
    {
        MoaAction moaaction1 = mActions.get("setfeathereditsize");
        MoaAction moaaction = moaaction1;
        if (moaaction1 == null)
        {
            moaaction = MoaActionFactory.action("setfeathereditsize");
            mActions.add(moaaction);
        }
        moaaction.setValue("width", i);
        moaaction.setValue("height", j);
    }

    public Bitmap generateBitmap(Bitmap bitmap)
    {
        Iterator iterator = mActions.iterator();
        Bitmap bitmap1 = bitmap;
        Bitmap bitmap3 = bitmap1;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Bitmap bitmap2 = generateIntermediateBitmap(bitmap3, (MoaAction)iterator.next());
            bitmap = bitmap2;
            if (!bitmap2.equals(bitmap3))
            {
                bitmap3.recycle();
                bitmap3 = bitmap2;
                bitmap = bitmap2;
            }
        } while (true);
        return bitmap;
    }

    public boolean setFixedRotation(int i)
    {
        if (i % 90 == 0 && i != 0)
        {
            MoaAction moaaction1 = mActions.get("rotate90");
            MoaAction moaaction = moaaction1;
            if (moaaction1 == null)
            {
                moaaction = MoaActionFactory.action("rotate90");
                mActions.add(moaaction);
                setFeatherEditSize(1, 1);
            }
            moaaction.setValue("angle", i);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean setFlip(boolean flag, boolean flag1)
    {
        if (flag || flag1)
        {
            MoaAction moaaction1 = mActions.get("flip");
            MoaAction moaaction = moaaction1;
            if (moaaction1 == null)
            {
                moaaction = MoaActionFactory.action("flip");
                mActions.add(moaaction);
            }
            moaaction.setValue("horizontal", flag);
            moaaction.setValue("vertical", flag1);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean setStraighten(double d, double d1, double d2)
    {
        if (d != 0.0D)
        {
            MoaAction moaaction1 = mActions.get("rotate");
            MoaAction moaaction = moaaction1;
            if (moaaction1 == null)
            {
                moaaction = MoaActionFactory.action("rotate");
                mActions.add(moaaction);
            }
            moaaction.setValue("angle", d);
            moaaction.setValue("width", d1);
            moaaction.setValue("height", d2);
            return true;
        } else
        {
            return false;
        }
    }
}
