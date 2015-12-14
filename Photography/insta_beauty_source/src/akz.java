// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.util.Log;
import java.lang.reflect.Array;

public class akz
{

    public static Bitmap a(Bitmap bitmap, int i)
    {
        int ai[];
        int ai1[];
        int ai2[];
        int ai3[];
        int ai4[];
        int ai5[];
        int ai6[][];
        int ai7[];
        int j;
        int k;
        int i1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        int l4;
        int i5;
        int l5;
        int j6;
        Bitmap bitmap1;
        int j5;
        int k5;
        try
        {
            bitmap1 = bitmap.copy(bitmap.getConfig(), true);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return bitmap;
        }
        if (i < 1)
        {
            return null;
        }
        j4 = bitmap1.getWidth();
        k4 = bitmap1.getHeight();
        ai = new int[j4 * k4];
        Log.e("pix", (new StringBuilder()).append(j4).append(" ").append(k4).append(" ").append(ai.length).toString());
        bitmap1.getPixels(ai, 0, j4, 0, 0, j4, k4);
        i4 = j4 - 1;
        l4 = k4 - 1;
        j = j4 * k4;
        i5 = i + i + 1;
        ai1 = new int[j];
        ai2 = new int[j];
        ai3 = new int[j];
        ai4 = new int[Math.max(j4, k4)];
        j = i5 + 1 >> 1;
        j5 = j * j;
        ai5 = new int[256];
        break MISSING_BLOCK_LABEL_169;
_L12:
        ai6 = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            i5, 3
        });
        k5 = i + 1;
        l2 = 0;
        j = 0;
        i3 = 0;
          goto _L1
_L15:
        if (j3 > i) goto _L3; else goto _L2
_L2:
        k3 = ai[Math.min(i4, Math.max(j3, 0)) + j];
        ai7 = ai6[j3 + i];
        ai7[0] = (0xff0000 & k3) >> 16;
        ai7[1] = (0xff00 & k3) >> 8;
        ai7[2] = k3 & 0xff;
        k3 = k5 - Math.abs(j3);
        break MISSING_BLOCK_LABEL_292;
_L16:
        if (l1 >= j4) goto _L5; else goto _L4
_L4:
        ai1[j] = ai5[k2 / j5];
        ai2[j] = ai5[j3 / j5];
        ai3[j] = ai5[k3 / j5];
        ai7 = ai6[((j2 - i) + i5) % i5];
        j6 = ai7[0];
        l5 = ai7[1];
        l3 = ai7[2];
        if (i3 != 0) goto _L7; else goto _L6
_L6:
        ai4[l1] = Math.min(l1 + i + 1, i4);
          goto _L7
_L19:
        if (i3 > i) goto _L9; else goto _L8
_L8:
        j3 = Math.max(0, l2) + j;
        ai7 = ai6[i3 + i];
        ai7[0] = ai1[j3];
        ai7[1] = ai2[j3];
        ai7[2] = ai3[j3];
        k3 = k5 - Math.abs(i3);
        break MISSING_BLOCK_LABEL_529;
_L20:
        if (i2 >= k4)
        {
            break MISSING_BLOCK_LABEL_1496;
        }
        ai[k1] = 0xff000000 & ai[k1] | ai5[k2 / j5] << 16 | ai5[l2 / j5] << 8 | ai5[j3 / j5];
        ai7 = ai6[((i3 - i) + i5) % i5];
        i4 = ai7[0];
        l3 = ai7[1];
        k3 = ai7[2];
        if (j != 0) goto _L11; else goto _L10
_L10:
        ai4[i2] = Math.min(i2 + k5, l4) * j4;
          goto _L11
_L18:
        Log.e("pix", (new StringBuilder()).append(j4).append(" ").append(k4).append(" ").append(ai.length).toString());
        bitmap1.setPixels(ai, 0, j4, 0, 0, j4, k4);
        return bitmap1;
        j = 0;
        while (j < 256) 
        {
            ai5[j] = j;
            j++;
        }
          goto _L12
_L1:
        if (i3 >= k4) goto _L14; else goto _L13
_L13:
        int l;
        int j1;
        k = 0;
        j3 = -i;
        k1 = 0;
        l = 0;
        j1 = 0;
        l1 = 0;
        i2 = 0;
        j2 = 0;
        k2 = 0;
        i1 = 0;
          goto _L15
        k2 += ai7[0] * k3;
        j2 += ai7[1] * k3;
        i2 += k3 * ai7[2];
        if (j3 > 0)
        {
            k1 += ai7[0];
            i1 += ai7[1];
            k += ai7[2];
        } else
        {
            l1 += ai7[0];
            j1 += ai7[1];
            l += ai7[2];
        }
        j3++;
          goto _L15
_L3:
        j3 = j2;
        k3 = i2;
        l3 = 0;
        j2 = i;
        i2 = l1;
        l1 = l3;
          goto _L16
_L7:
        int k6 = ai[ai4[l1] + l2];
        ai7[0] = (0xff0000 & k6) >> 16;
        ai7[1] = (0xff00 & k6) >> 8;
        ai7[2] = k6 & 0xff;
        k1 += ai7[0];
        i1 += ai7[1];
        k += ai7[2];
        k2 = (k2 - i2) + k1;
        j3 = (j3 - j1) + i1;
        k3 = (k3 - l) + k;
        j2 = (j2 + 1) % i5;
        ai7 = ai6[j2 % i5];
        i2 = (i2 - j6) + ai7[0];
        j1 = (j1 - l5) + ai7[1];
        l = (l - l3) + ai7[2];
        k1 -= ai7[0];
        i1 -= ai7[1];
        k -= ai7[2];
        j++;
        l1++;
          goto _L16
_L5:
        l2 += j4;
        i3++;
          goto _L1
_L14:
        j = 0;
_L21:
        if (j >= j4) goto _L18; else goto _L17
_L17:
        k = 0;
        l2 = -i * j4;
        i3 = -i;
        k1 = 0;
        l = 0;
        j1 = 0;
        l1 = 0;
        i2 = 0;
        j2 = 0;
        k2 = 0;
        i1 = 0;
          goto _L19
        l3 = ai1[j3];
        i4 = ai2[j3];
        l5 = ai3[j3];
        if (i3 > 0)
        {
            k1 += ai7[0];
            i1 += ai7[1];
            k += ai7[2];
        } else
        {
            l1 += ai7[0];
            j1 += ai7[1];
            l += ai7[2];
        }
        j3 = l2;
        if (i3 < l4)
        {
            j3 = l2 + j4;
        }
        i3++;
        i2 = l5 * k3 + i2;
        j2 = i4 * k3 + j2;
        k2 = l3 * k3 + k2;
        l2 = j3;
          goto _L19
_L9:
        l2 = j2;
        i4 = 0;
        j3 = i2;
        i2 = j;
        j2 = l;
        k3 = j1;
        l3 = l1;
        i3 = i;
        l = i1;
        j1 = k1;
        i1 = j2;
        l1 = k3;
        j2 = l3;
        k1 = i2;
        i2 = i4;
          goto _L20
_L11:
        int i6 = ai4[i2] + j;
        ai7[0] = ai1[i6];
        ai7[1] = ai2[i6];
        ai7[2] = ai3[i6];
        j1 += ai7[0];
        l += ai7[1];
        k += ai7[2];
        k2 = (k2 - j2) + j1;
        l2 = (l2 - l1) + l;
        j3 = (j3 - i1) + k;
        i3 = (i3 + 1) % i5;
        ai7 = ai6[i3];
        j2 = (j2 - i4) + ai7[0];
        l1 = (l1 - l3) + ai7[1];
        i1 = (i1 - k3) + ai7[2];
        j1 -= ai7[0];
        l -= ai7[1];
        k -= ai7[2];
        k1 += j4;
        i2++;
          goto _L20
        j++;
          goto _L21
    }
}
