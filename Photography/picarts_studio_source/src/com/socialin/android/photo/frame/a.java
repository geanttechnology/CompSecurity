// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.frame;

import android.content.Context;
import android.os.Environment;
import com.picsart.studio.ItemType;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.photo.f;
import com.socialin.android.util.Utils;
import java.io.File;

public final class a
{

    public static int a[] = {
        0x7f0800ae, 0x7f0800aa, 0x7f0800c0, 0x7f0800b9, 0x7f0800b3, 0x7f0800a8, 0x7f0800a7
    };
    public static int b[] = {
        0x7f020105, 0x7f020103, 0x7f020118, 0x7f02010f, 0x7f020109, 0x7f0200fb, 0x7f0200fa
    };
    public static int c[][];
    public static String d[] = {
        "frame_ver2", "frameRecent", "doodle", "travel", "nature", "love", "celebration", "baby"
    };
    public static int e[] = {
        0x7f020290, 0x7f02029b, 0x7f02029f, 0x7f0202a0, 0x7f0202a1, 0x7f0202a2, 0x7f0202a3, 0x7f0202a4, 0x7f0202a5, 0x7f020291, 
        0x7f020292, 0x7f020293, 0x7f020294, 0x7f020295, 0x7f020296, 0x7f020297, 0x7f020298, 0x7f020299, 0x7f02029a, 0x7f02029c, 
        0x7f02029d, 0x7f02029e
    };
    public static int f[] = {
        0x7f07005b, 0x7f070066, 0x7f07006a, 0x7f07006b, 0x7f07006c, 0x7f07006d, 0x7f07006e, 0x7f07006f, 0x7f070070, 0x7f07005c, 
        0x7f07005d, 0x7f07005e, 0x7f07005f, 0x7f070060, 0x7f070061, 0x7f070062, 0x7f070063, 0x7f070064, 0x7f070065, 0x7f070067, 
        0x7f070068, 0x7f070069
    };
    private static int g[] = {
        -256, -256, -256, -256, -256, -256, -256, -256, -256, -256, 
        -256, -256, -256, -256, -256
    };
    private static int h[] = {
        -256, -256, -256, -256, -256, -256, -256, -256, -256, -256
    };
    private static int i[] = {
        -256, -256, -256, -256, -256, -256, -256, -256, -256, -256, 
        -256, -256, -256, -256, -256
    };
    private static int j[] = {
        -256, -256, -256, -256, -256, -256, -256, -256, -256, -256, 
        -256, -256, -256, -256, -256, -256, -256, -256
    };
    private static int k[] = {
        -256, -256, -256, -256, -256, -256, -256, -256, -256, -256, 
        -256, -256, -256, -256, -256, -256, -256, -256, -256, -256, 
        -256, -256, -256
    };
    private static int l[] = {
        -255, -255, -255, -255, -255, -255, -255, -255, -255, -255, 
        -255, -255, -255, -255, -255, -255, -255, -255, -255, -255, 
        -255, -255, -255, -255
    };
    private static int m[];

    public static String a(int i1, int j1)
    {
        if (i1 != 0 && c[i1][j1] == -255)
        {
            return (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append(d[0]).append("/").append(d[i1 + 1]).append("/svg/frame_").append(j1 + 1).append(".svg").toString();
        } else
        {
            return (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append(d[0]).append("/").append(d[i1 + 1]).append("/").append(Utils.b()).append("/frame_").append(j1 + 1).append(".png").toString();
        }
    }

    public static String a(int i1, int j1, Context context)
    {
        String s = (new StringBuilder("frame_")).append(j1 + 1).toString();
        context = (new StringBuilder()).append(context.getString(0x7f0808fb)).append("/").append(context.getString(0x7f0808dc)).append("/").append(d[0]).append("/").append(d[i1 + 1]).toString();
        return (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(context).append("/").append(s).toString();
    }

    public static int[] a(String s, ItemType itemtype)
    {
        File file = new File(s);
        m = null;
        if (file.exists())
        {
            m = new int[com.socialin.android.photo.f.b(s, itemtype, false)];
        }
        if (m == null)
        {
            m = new int[0];
        }
        return m;
    }

    public static String b(int i1, int j1)
    {
        return (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append(d[0]).append("/").append(d[i1 + 1]).append("/icons/frame_").append(d[i1 + 1]).append("_").append(j1 + 1).append(".jpg").toString();
    }

    static 
    {
        m = null;
        c = (new int[][] {
            m, l, g, h, j, k, i
        });
    }
}
