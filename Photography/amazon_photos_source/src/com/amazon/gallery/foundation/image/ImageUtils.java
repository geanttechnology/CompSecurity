// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.image;

import com.amazon.gallery.foundation.gfx.ScaleMode;
import com.amazon.gallery.foundation.utils.DebugAssert;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.foundation.image:
//            Dimension

public class ImageUtils
{

    public static int calculateImageDimensionDelta(int i, int j, int k, int l)
    {
        boolean flag;
        if (i > j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            i = j;
        }
        if (!flag)
        {
            k = l;
        }
        return i - k;
    }

    public static Map getMatchJSONImage(List list, int i, int j, ScaleMode scalemode, int k, int l)
    {
        int i1 = 0x7fffffff;
        Object obj = null;
        Dimension dimension = scaleDimension(new Dimension(k, l), new Dimension(i, j), scalemode);
        Iterator iterator = list.iterator();
        i = i1;
        list = obj;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Map map = (Map)iterator.next();
            j = objectToInt(map.get("width"));
            k = objectToInt(map.get("height"));
            if (isMatched(j, k, dimension.width, dimension.height, scalemode))
            {
                return map;
            }
            if (scalemode == ScaleMode.SCALE_TO_FILL)
            {
                list = map;
            } else
            {
                j = calculateImageDimensionDelta(j, k, dimension.width, dimension.height);
                if (Math.abs(j) < Math.abs(i))
                {
                    i = j;
                    list = map;
                }
            }
        } while (true);
        return list;
    }

    private static boolean isDimensionMatched(int i, int j)
    {
        return i / 2 <= j && j <= i;
    }

    public static boolean isMatched(int i, int j, int k, int l, ScaleMode scalemode)
    {
        if (scalemode == ScaleMode.SCALE_TO_FILL)
        {
            return i >= k && j >= l;
        }
        boolean flag;
        boolean flag1;
        if (scalemode == ScaleMode.SCALE_TO_FIT)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        DebugAssert.assertTrue(flag1);
        if (i > j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            i = j;
        }
        if (!flag)
        {
            k = l;
        }
        return isDimensionMatched(i, k);
    }

    public static int objectToInt(Object obj)
    {
        if (java/lang/Integer.isInstance(obj))
        {
            return ((Integer)obj).intValue();
        } else
        {
            return ((Long)obj).intValue();
        }
    }

    public static Dimension scaleDimension(Dimension dimension, Dimension dimension1, ScaleMode scalemode)
    {
        return scaleDimension(dimension, dimension1, scalemode, false);
    }

    public static Dimension scaleDimension(Dimension dimension, Dimension dimension1, ScaleMode scalemode, boolean flag)
    {
        float f;
        float f1;
        float f2;
        if (scalemode == ScaleMode.NO_RESIZE || dimension.equals(dimension1))
        {
            return dimension;
        }
        f1 = ((float)dimension1.height * 1.0F) / (float)dimension.height;
        f2 = ((float)dimension1.width * 1.0F) / (float)dimension.width;
        f = 1.0F;
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$foundation$gfx$ScaleMode[];

            static 
            {
                $SwitchMap$com$amazon$gallery$foundation$gfx$ScaleMode = new int[ScaleMode.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$foundation$gfx$ScaleMode[ScaleMode.SCALE_TO_FIT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$foundation$gfx$ScaleMode[ScaleMode.SCALE_TO_FILL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.gallery.foundation.gfx.ScaleMode[scalemode.ordinal()];
        JVM INSTR tableswitch 1 2: default 80
    //                   1 93
    //                   2 105;
           goto _L1 _L2 _L3
_L1:
        if (!flag && f >= 1.0F)
        {
            return dimension;
        }
        break; /* Loop/switch isn't completed */
_L2:
        f = Math.min(f1, f2);
        continue; /* Loop/switch isn't completed */
_L3:
        f = Math.max(f1, f2);
        if (true) goto _L1; else goto _L4
_L4:
        dimension1 = new Dimension();
        if (scalemode == ScaleMode.SCALE_TO_FILL)
        {
            dimension1.width = (int)Math.ceil((float)dimension.width * f);
            dimension1.height = (int)Math.ceil((float)dimension.height * f);
            return dimension1;
        } else
        {
            dimension1.width = Math.round((float)dimension.width * f);
            dimension1.height = Math.round((float)dimension.height * f);
            return dimension1;
        }
    }
}
