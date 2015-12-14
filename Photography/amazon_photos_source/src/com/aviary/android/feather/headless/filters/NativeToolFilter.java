// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.filters;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaPointParameter;
import com.aviary.android.feather.headless.moa.MoaStrokeParameter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;

// Referenced classes of package com.aviary.android.feather.headless.filters:
//            NativeFilter, MoaJavaToolStrokeResult

public final class NativeToolFilter extends NativeFilter
{
    public static final class BrushMode extends Enum
    {

        private static final BrushMode $VALUES[];
        public static final BrushMode Erase;
        public static final BrushMode Free;
        public static final BrushMode None;
        public static final BrushMode Smart;

        public static BrushMode valueOf(String s)
        {
            return (BrushMode)Enum.valueOf(com/aviary/android/feather/headless/filters/NativeToolFilter$BrushMode, s);
        }

        public static BrushMode[] values()
        {
            return (BrushMode[])$VALUES.clone();
        }

        static 
        {
            None = new BrushMode("None", 0);
            Free = new BrushMode("Free", 1);
            Erase = new BrushMode("Erase", 2);
            Smart = new BrushMode("Smart", 3);
            $VALUES = (new BrushMode[] {
                None, Free, Erase, Smart
            });
        }

        private BrushMode(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class NativeToolType extends Enum
    {

        private static final NativeToolType $VALUES[];
        public static final NativeToolType Blemish;
        public static final NativeToolType Blur;
        public static final NativeToolType ColorSplash;
        public static final NativeToolType None;
        public static final NativeToolType RedEye;
        public static final NativeToolType TiltShift;
        public static final NativeToolType Whiten;

        public static NativeToolType valueOf(String s)
        {
            return (NativeToolType)Enum.valueOf(com/aviary/android/feather/headless/filters/NativeToolFilter$NativeToolType, s);
        }

        public static NativeToolType[] values()
        {
            return (NativeToolType[])$VALUES.clone();
        }

        static 
        {
            ColorSplash = new NativeToolType("ColorSplash", 0);
            TiltShift = new NativeToolType("TiltShift", 1);
            Blemish = new NativeToolType("Blemish", 2);
            RedEye = new NativeToolType("RedEye", 3);
            Whiten = new NativeToolType("Whiten", 4);
            Blur = new NativeToolType("Blur", 5);
            None = new NativeToolType("None", 6);
            $VALUES = (new NativeToolType[] {
                ColorSplash, TiltShift, Blemish, RedEye, Whiten, Blur, None
            });
        }

        private NativeToolType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class TiltShiftMode extends Enum
    {

        private static final TiltShiftMode $VALUES[];
        public static final TiltShiftMode Linear;
        public static final TiltShiftMode None;
        public static final TiltShiftMode Radial;

        public static TiltShiftMode valueOf(String s)
        {
            return (TiltShiftMode)Enum.valueOf(com/aviary/android/feather/headless/filters/NativeToolFilter$TiltShiftMode, s);
        }

        public static TiltShiftMode[] values()
        {
            return (TiltShiftMode[])$VALUES.clone();
        }

        static 
        {
            Radial = new TiltShiftMode("Radial", 0);
            Linear = new TiltShiftMode("Linear", 1);
            None = new TiltShiftMode("None", 2);
            $VALUES = (new TiltShiftMode[] {
                Radial, Linear, None
            });
        }

        private TiltShiftMode(String s, int i)
        {
            super(s, i);
        }
    }


    private Rect mBitmapRect;
    private final MoaAction mFirstAction;
    private final NativeToolType mType;
    private long n_ptr;
    protected List strokes;

    public NativeToolFilter(String s, NativeToolType nativetooltype)
    {
        super("tools");
        n_ptr = 0L;
        strokes = Collections.synchronizedList(new ArrayList());
        mType = nativetooltype;
        n_ptr = nativeCtor(mType.name().toLowerCase(Locale.US));
        mBitmapRect = new Rect();
        mFirstAction = mActions.get(0);
        mFirstAction.setValue("toolname", s);
        if (nativetooltype == NativeToolType.TiltShift)
        {
            setTiltShiftMode(TiltShiftMode.None);
            return;
        } else
        {
            setBrushMode(BrushMode.None);
            mActions.get(0).setValue("strokes", strokes);
            return;
        }
    }

    public void addStrokeData(MoaStrokeParameter moastrokeparameter)
    {
        strokes.add(moastrokeparameter);
    }

    public void dispose()
    {
        this;
        JVM INSTR monitorenter ;
        if (valid())
        {
            nativeDispose(n_ptr);
            n_ptr = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void draw(Bitmap bitmap)
    {
        try
        {
            executeInPlace(bitmap);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
        }
    }

    public transient float[] draw(double d, double d1, int i, boolean flag, MoaJavaToolStrokeResult moajavatoolstrokeresult, 
            float af[])
    {
        if (valid())
        {
            if (mType == NativeToolType.TiltShift)
            {
                mFirstAction.setValue("x", af[0]);
                mFirstAction.setValue("y", af[1]);
                mFirstAction.setValue("radius", d);
                mFirstAction.setValue("angle", d1);
            }
            long l1 = n_ptr;
            long l;
            if (moajavatoolstrokeresult != null)
            {
                l = moajavatoolstrokeresult.getPointer();
            } else
            {
                l = 0L;
            }
            return nativeDraw(l1, d, d1, i, flag, af, l);
        } else
        {
            return null;
        }
    }

    public transient float[] draw(double d, double d1, int i, boolean flag, float af[])
    {
        return draw(d, d1, i, flag, null, af);
    }

    public boolean drawStart(double d, double d1, double d2, double d3)
    {
        return drawStart(d, d1, d2, d3, null);
    }

    public boolean drawStart(double d, double d1, double d2, double d3, MoaJavaToolStrokeResult moajavatoolstrokeresult)
    {
        if (valid())
        {
            long l1 = n_ptr;
            long l;
            if (moajavatoolstrokeresult != null)
            {
                l = moajavatoolstrokeresult.getPointer();
            } else
            {
                l = 0L;
            }
            return nativeDrawStart(l1, d, d1, d2, d3, l) == 0;
        } else
        {
            return false;
        }
    }

    protected void finalize()
        throws Throwable
    {
        dispose();
        super.finalize();
    }

    public int init(Bitmap bitmap, Bitmap bitmap1)
    {
        int i;
        byte byte0;
        byte0 = -1;
        i = byte0;
        if (!valid()) goto _L2; else goto _L1
_L1:
        if (bitmap != null) goto _L4; else goto _L3
_L3:
        i = byte0;
_L2:
        return i;
_L4:
        if (bitmap1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        i = byte0;
        if (bitmap.getWidth() != bitmap1.getWidth())
        {
            continue; /* Loop/switch isn't completed */
        }
        i = byte0;
        if (bitmap.getHeight() != bitmap1.getHeight()) goto _L2; else goto _L5
_L5:
        int j = nativeInit(n_ptr, bitmap, bitmap1);
        i = j;
        if (j == 0)
        {
            mFirstAction.setValue("previewsize", new MoaPointParameter(bitmap.getWidth(), bitmap.getHeight()));
            mBitmapRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            return j;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    native long nativeCtor(String s);

    native void nativeDispose(long l);

    native float[] nativeDraw(long l, double d, double d1, int i, 
            boolean flag, float af[], long l1);

    native int nativeDrawStart(long l, double d, double d1, double d2, double d3, long l1);

    native int nativeInit(long l, Bitmap bitmap, Bitmap bitmap1);

    native int nativeRenderPreview(long l, int i, int j, int k, int i1);

    native int nativeSetBrushMode(long l, String s);

    native int nativeSetTiltShiftMode(long l, String s);

    public boolean renderPreview()
    {
        return renderPreview(0, 0, mBitmapRect.right, mBitmapRect.bottom);
    }

    public boolean renderPreview(int i, int j, int k, int l)
    {
        return valid() && nativeRenderPreview(n_ptr, i, j, k, l) == 0;
    }

    public boolean renderPreview(Rect rect)
    {
        return renderPreview(rect.left, rect.top, rect.right, rect.bottom);
    }

    public boolean renderPreview(RectF rectf)
    {
        return renderPreview((int)rectf.left, (int)rectf.top, (int)rectf.right, (int)rectf.bottom);
    }

    public boolean setBrushMode(BrushMode brushmode)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (valid())
        {
            flag = flag1;
            if (nativeSetBrushMode(n_ptr, brushmode.name().toLowerCase(Locale.US)) == 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    public boolean setTiltShiftMode(TiltShiftMode tiltshiftmode)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (valid())
        {
            mFirstAction.setValue("tiltshiftmode", tiltshiftmode.name().toLowerCase(Locale.US));
            flag = flag1;
            if (nativeSetTiltShiftMode(n_ptr, tiltshiftmode.name().toLowerCase(Locale.US)) == 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    public boolean valid()
    {
        return n_ptr != 0L;
    }
}
