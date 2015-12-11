// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.chunk;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;
import shared_presage.com.google.android.exoplayer.MediaCodecUtil;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.chunk:
//            Format, FormatWrapper

public final class VideoFormatSelectorUtil
{

    private static final float FRACTION_TO_CONSIDER_FULLSCREEN = 0.98F;

    private VideoFormatSelectorUtil()
    {
    }

    private static Point getDisplaySize(Display display)
    {
        Point point = new Point();
        if (Util.SDK_INT >= 17)
        {
            getDisplaySizeV17(display, point);
            return point;
        }
        if (Util.SDK_INT >= 16)
        {
            getDisplaySizeV16(display, point);
            return point;
        } else
        {
            getDisplaySizeV9(display, point);
            return point;
        }
    }

    private static void getDisplaySizeV16(Display display, Point point)
    {
        display.getSize(point);
    }

    private static void getDisplaySizeV17(Display display, Point point)
    {
        display.getRealSize(point);
    }

    private static void getDisplaySizeV9(Display display, Point point)
    {
        point.x = display.getWidth();
        point.y = display.getHeight();
    }

    private static Point getMaxVideoSizeInViewport(boolean flag, int i, int j, int k, int l)
    {
        boolean flag2 = true;
        int j1 = i;
        int i1 = j;
        if (flag)
        {
            boolean flag1;
            if (k > l)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (i <= j)
            {
                flag2 = false;
            }
            j1 = i;
            i1 = j;
            if (flag1 != flag2)
            {
                i1 = i;
                j1 = j;
            }
        }
        if (k * i1 >= l * j1)
        {
            return new Point(j1, Util.ceilDivide(j1 * l, k));
        } else
        {
            return new Point(Util.ceilDivide(i1 * k, l), i1);
        }
    }

    private static boolean isFormatPlayable(Format format, String as[], boolean flag, int i)
    {
        while (as != null && !Util.contains(as, format.mimeType) || flag && (format.width >= 1280 || format.height >= 720) || format.width > 0 && format.height > 0 && format.width * format.height > i) 
        {
            return false;
        }
        return true;
    }

    public static int[] selectVideoFormats(List list, String as[], boolean flag, boolean flag1, int i, int j)
    {
        int k = 0x7fffffff;
        ArrayList arraylist = new ArrayList();
        int j1 = MediaCodecUtil.maxH264DecodableFrameSize();
        int k1 = list.size();
        for (int l = 0; l < k1; l++)
        {
            Format format = ((FormatWrapper)list.get(l)).getFormat();
            if (!isFormatPlayable(format, as, flag, j1))
            {
                continue;
            }
            arraylist.add(Integer.valueOf(l));
            if (format.width <= 0 || format.height <= 0)
            {
                continue;
            }
            Point point = getMaxVideoSizeInViewport(flag1, i, j, format.width, format.height);
            int i1 = format.width * format.height;
            if (format.width >= (int)((float)point.x * 0.98F) && format.height >= (int)((float)point.y * 0.98F) && i1 < k)
            {
                k = i1;
            }
        }

        for (i = arraylist.size() - 1; i >= 0; i--)
        {
            as = ((FormatWrapper)list.get(i)).getFormat();
            if (((Format) (as)).width <= 0 || ((Format) (as)).height <= 0)
            {
                continue;
            }
            j = ((Format) (as)).width;
            if (((Format) (as)).height * j > k)
            {
                arraylist.remove(i);
            }
        }

        return Util.toArray(arraylist);
    }

    public static int[] selectVideoFormatsForDefaultDisplay(Context context, List list, String as[], boolean flag)
    {
        context = getDisplaySize(((WindowManager)context.getSystemService("window")).getDefaultDisplay());
        return selectVideoFormats(list, as, flag, true, ((Point) (context)).x, ((Point) (context)).y);
    }
}
