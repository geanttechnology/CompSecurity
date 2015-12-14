// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.util.Log;
import java.lang.reflect.Array;

public class id
{

    public static Bitmap a(Bitmap bitmap, int i)
    {
        bitmap = bitmap.copy(bitmap.getConfig(), true);
        if (i < 1)
        {
            return null;
        }
        int k10 = bitmap.getWidth();
        int l10 = bitmap.getHeight();
        int ai[] = new int[k10 * l10];
        Log.e("pix", (new StringBuilder()).append(k10).append(" ").append(l10).append(" ").append(ai.length).toString());
        bitmap.getPixels(ai, 0, k10, 0, 0, k10, l10);
        int l9 = k10 - 1;
        int i11 = l10 - 1;
        int j = k10 * l10;
        int j11 = i + i + 1;
        int ai1[] = new int[j];
        int ai2[] = new int[j];
        int ai3[] = new int[j];
        int ai4[] = new int[Math.max(k10, l10)];
        j = j11 + 1 >> 1;
        int k11 = j * j;
        int ai5[] = new int[256];
        for (j = 0; j < 256; j++)
        {
            ai5[j] = j;
        }

        int ai6[][] = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            j11, 3
        });
        int l11 = i + 1;
        int j6 = 0;
        j = 0;
        for (int l5 = 0; l5 < l10; l5++)
        {
            int l = 0;
            int l6 = -i;
            int i2 = 0;
            int k2 = 0;
            int i3 = 0;
            int k3 = 0;
            int i4 = 0;
            int l4 = 0;
            int j5 = 0;
            int k1 = 0;
            while (l6 <= i) 
            {
                int k7 = ai[Math.min(l9, Math.max(l6, 0)) + j];
                int ai7[] = ai6[l6 + i];
                ai7[0] = (0xff0000 & k7) >> 16;
                ai7[1] = (0xff00 & k7) >> 8;
                ai7[2] = k7 & 0xff;
                k7 = l11 - Math.abs(l6);
                j5 += ai7[0] * k7;
                l4 += ai7[1] * k7;
                i4 += k7 * ai7[2];
                if (l6 > 0)
                {
                    i2 += ai7[0];
                    k1 += ai7[1];
                    l += ai7[2];
                } else
                {
                    k3 += ai7[0];
                    i3 += ai7[1];
                    k2 += ai7[2];
                }
                l6++;
            }
            l6 = l4;
            boolean flag = false;
            l4 = i;
            int l7 = j5;
            j5 = i4;
            for (int j4 = ((flag) ? 1 : 0); j4 < k10; j4++)
            {
                ai1[j] = ai5[l7 / k11];
                ai2[j] = ai5[l6 / k11];
                ai3[j] = ai5[j5 / k11];
                int ai8[] = ai6[((l4 - i) + j11) % j11];
                int l12 = ai8[0];
                int i12 = ai8[1];
                int l8 = ai8[2];
                if (l5 == 0)
                {
                    ai4[j4] = Math.min(j4 + i + 1, l9);
                }
                int i13 = ai[ai4[j4] + j6];
                ai8[0] = (0xff0000 & i13) >> 16;
                ai8[1] = (0xff00 & i13) >> 8;
                ai8[2] = i13 & 0xff;
                i2 += ai8[0];
                k1 += ai8[1];
                l += ai8[2];
                l7 = (l7 - k3) + i2;
                l6 = (l6 - i3) + k1;
                j5 = (j5 - k2) + l;
                l4 = (l4 + 1) % j11;
                ai8 = ai6[l4 % j11];
                k3 = (k3 - l12) + ai8[0];
                i3 = (i3 - i12) + ai8[1];
                k2 = (k2 - l8) + ai8[2];
                i2 -= ai8[0];
                k1 -= ai8[1];
                l -= ai8[2];
                j++;
            }

            j6 += k10;
        }

        for (int k = 0; k < k10; k++)
        {
            int k5 = 0;
            int k6 = -i * k10;
            int i6 = -i;
            int k4 = 0;
            int l2 = 0;
            int j3 = 0;
            int l3 = 0;
            int i1 = 0;
            int j2 = 0;
            int l1 = 0;
            int i5 = 0;
            while (i6 <= i) 
            {
                int i7 = Math.max(0, k6) + k;
                int ai9[] = ai6[i6 + i];
                ai9[0] = ai1[i7];
                ai9[1] = ai2[i7];
                ai9[2] = ai3[i7];
                int i8 = l11 - Math.abs(i6);
                int i9 = ai1[i7];
                int i10 = ai2[i7];
                int j12 = ai3[i7];
                if (i6 > 0)
                {
                    k4 += ai9[0];
                    i5 += ai9[1];
                    k5 += ai9[2];
                } else
                {
                    l3 += ai9[0];
                    j3 += ai9[1];
                    l2 += ai9[2];
                }
                i7 = k6;
                if (i6 < i11)
                {
                    i7 = k6 + k10;
                }
                i6++;
                i1 = j12 * i8 + i1;
                j2 = i10 * i8 + j2;
                l1 = i9 * i8 + l1;
                k6 = i7;
            }
            int j8 = j2;
            int j9 = l1;
            boolean flag1 = false;
            l1 = k;
            i6 = k5;
            k6 = i5;
            int j7 = k4;
            j2 = l2;
            l2 = j3;
            j3 = l3;
            l3 = i;
            k5 = j9;
            i5 = j8;
            k4 = i1;
            for (int j1 = ((flag1) ? 1 : 0); j1 < l10; j1++)
            {
                ai[l1] = 0xff000000 & ai[l1] | ai5[k5 / k11] << 16 | ai5[i5 / k11] << 8 | ai5[k4 / k11];
                int ai10[] = ai6[((l3 - i) + j11) % j11];
                int j10 = ai10[0];
                int k9 = ai10[1];
                int k8 = ai10[2];
                if (k == 0)
                {
                    ai4[j1] = Math.min(j1 + l11, i11) * k10;
                }
                int k12 = ai4[j1] + k;
                ai10[0] = ai1[k12];
                ai10[1] = ai2[k12];
                ai10[2] = ai3[k12];
                j7 += ai10[0];
                k6 += ai10[1];
                i6 += ai10[2];
                k5 = (k5 - j3) + j7;
                i5 = (i5 - l2) + k6;
                k4 = (k4 - j2) + i6;
                l3 = (l3 + 1) % j11;
                ai10 = ai6[l3];
                j3 = (j3 - j10) + ai10[0];
                l2 = (l2 - k9) + ai10[1];
                j2 = (j2 - k8) + ai10[2];
                j7 -= ai10[0];
                k6 -= ai10[1];
                i6 -= ai10[2];
                l1 += k10;
            }

        }

        Log.e("pix", (new StringBuilder()).append(k10).append(" ").append(l10).append(" ").append(ai.length).toString());
        bitmap.setPixels(ai, 0, k10, 0, 0, k10, l10);
        return bitmap;
    }
}
