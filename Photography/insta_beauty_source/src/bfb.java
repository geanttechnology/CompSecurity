// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import java.lang.reflect.Array;

public class bfb
{

    public static Bitmap a(Context context, Bitmap bitmap, int i)
    {
        Bitmap bitmap1 = null;
        if (bitmap != null)
        {
            bitmap1 = b(context, bitmap, i);
        }
        return bitmap1;
    }

    public static Bitmap b(Context context, Bitmap bitmap, int i)
    {
        context = bitmap.copy(bitmap.getConfig(), true);
        if (i < 1)
        {
            return null;
        }
        int l10 = context.getWidth();
        int i11 = context.getHeight();
        bitmap = new int[l10 * i11];
        Log.e("pix", (new StringBuilder()).append(l10).append(" ").append(i11).append(" ").append(bitmap.length).toString());
        context.getPixels(bitmap, 0, l10, 0, 0, l10, i11);
        int i10 = l10 - 1;
        int j11 = i11 - 1;
        int j = l10 * i11;
        int k11 = i + i + 1;
        int ai[] = new int[j];
        int ai1[] = new int[j];
        int ai2[] = new int[j];
        int ai3[] = new int[Math.max(l10, i11)];
        j = k11 + 1 >> 1;
        int l = j * j;
        int ai4[] = new int[l * 256];
        for (j = 0; j < l * 256; j++)
        {
            ai4[j] = j / l;
        }

        int ai5[][] = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            k11, 3
        });
        int l11 = i + 1;
        int k6 = 0;
        j = 0;
        for (int i6 = 0; i6 < i11; i6++)
        {
            int i1 = 0;
            int i7 = -i;
            int j2 = 0;
            int l2 = 0;
            int j3 = 0;
            int l3 = 0;
            int j4 = 0;
            int i5 = 0;
            int k5 = 0;
            int l1 = 0;
            while (i7 <= i) 
            {
                int l7 = bitmap[Math.min(i10, Math.max(i7, 0)) + j];
                int ai6[] = ai5[i7 + i];
                ai6[0] = (0xff0000 & l7) >> 16;
                ai6[1] = (0xff00 & l7) >> 8;
                ai6[2] = l7 & 0xff;
                l7 = l11 - Math.abs(i7);
                k5 += ai6[0] * l7;
                i5 += ai6[1] * l7;
                j4 += l7 * ai6[2];
                if (i7 > 0)
                {
                    j2 += ai6[0];
                    l1 += ai6[1];
                    i1 += ai6[2];
                } else
                {
                    l3 += ai6[0];
                    j3 += ai6[1];
                    l2 += ai6[2];
                }
                i7++;
            }
            i7 = i5;
            boolean flag = false;
            i5 = i;
            int i8 = k5;
            k5 = j4;
            for (int k4 = ((flag) ? 1 : 0); k4 < l10; k4++)
            {
                ai[j] = ai4[i8];
                ai1[j] = ai4[i7];
                ai2[j] = ai4[k5];
                int ai7[] = ai5[((i5 - i) + k11) % k11];
                int l12 = ai7[0];
                int i12 = ai7[1];
                int i9 = ai7[2];
                if (i6 == 0)
                {
                    ai3[k4] = Math.min(k4 + i + 1, i10);
                }
                int i13 = bitmap[ai3[k4] + k6];
                ai7[0] = (0xff0000 & i13) >> 16;
                ai7[1] = (0xff00 & i13) >> 8;
                ai7[2] = i13 & 0xff;
                j2 += ai7[0];
                l1 += ai7[1];
                i1 += ai7[2];
                i8 = (i8 - l3) + j2;
                i7 = (i7 - j3) + l1;
                k5 = (k5 - l2) + i1;
                i5 = (i5 + 1) % k11;
                ai7 = ai5[i5 % k11];
                l3 = (l3 - l12) + ai7[0];
                j3 = (j3 - i12) + ai7[1];
                l2 = (l2 - i9) + ai7[2];
                j2 -= ai7[0];
                l1 -= ai7[1];
                i1 -= ai7[2];
                j++;
            }

            k6 += l10;
        }

        for (int k = 0; k < l10; k++)
        {
            int l5 = 0;
            int l6 = -i * l10;
            int j6 = -i;
            int l4 = 0;
            int i3 = 0;
            int k3 = 0;
            int i4 = 0;
            int j1 = 0;
            int k2 = 0;
            int i2 = 0;
            int j5 = 0;
            while (j6 <= i) 
            {
                int j7 = Math.max(0, l6) + k;
                int ai8[] = ai5[j6 + i];
                ai8[0] = ai[j7];
                ai8[1] = ai1[j7];
                ai8[2] = ai2[j7];
                int j8 = l11 - Math.abs(j6);
                int j9 = ai[j7];
                int j10 = ai1[j7];
                int j12 = ai2[j7];
                if (j6 > 0)
                {
                    l4 += ai8[0];
                    j5 += ai8[1];
                    l5 += ai8[2];
                } else
                {
                    i4 += ai8[0];
                    k3 += ai8[1];
                    i3 += ai8[2];
                }
                j7 = l6;
                if (j6 < j11)
                {
                    j7 = l6 + l10;
                }
                j6++;
                j1 = j12 * j8 + j1;
                k2 = j10 * j8 + k2;
                i2 = j9 * j8 + i2;
                l6 = j7;
            }
            int k8 = k2;
            int k9 = i2;
            boolean flag1 = false;
            i2 = k;
            j6 = l5;
            l6 = j5;
            int k7 = l4;
            k2 = i3;
            i3 = k3;
            k3 = i4;
            i4 = i;
            l5 = k9;
            j5 = k8;
            l4 = j1;
            for (int k1 = ((flag1) ? 1 : 0); k1 < i11; k1++)
            {
                bitmap[i2] = 0xff000000 & bitmap[i2] | ai4[l5] << 16 | ai4[j5] << 8 | ai4[l4];
                int ai9[] = ai5[((i4 - i) + k11) % k11];
                int k10 = ai9[0];
                int l9 = ai9[1];
                int l8 = ai9[2];
                if (k == 0)
                {
                    ai3[k1] = Math.min(k1 + l11, j11) * l10;
                }
                int k12 = ai3[k1] + k;
                ai9[0] = ai[k12];
                ai9[1] = ai1[k12];
                ai9[2] = ai2[k12];
                k7 += ai9[0];
                l6 += ai9[1];
                j6 += ai9[2];
                l5 = (l5 - k3) + k7;
                j5 = (j5 - i3) + l6;
                l4 = (l4 - k2) + j6;
                i4 = (i4 + 1) % k11;
                ai9 = ai5[i4];
                k3 = (k3 - k10) + ai9[0];
                i3 = (i3 - l9) + ai9[1];
                k2 = (k2 - l8) + ai9[2];
                k7 -= ai9[0];
                l6 -= ai9[1];
                j6 -= ai9[2];
                i2 += l10;
            }

        }

        Log.e("pix", (new StringBuilder()).append(l10).append(" ").append(i11).append(" ").append(bitmap.length).toString());
        context.setPixels(bitmap, 0, l10, 0, 0, l10, i11);
        return context;
    }
}
