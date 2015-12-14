// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.mp4encoder;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.SparseArray;
import com.socialin.android.d;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.picsart.studio.mp4encoder:
//            a, b

final class c
{

    private static HashMap a = new HashMap();
    private static HashMap b = new HashMap();

    public static b a(String s)
    {
        Object obj;
        SparseArray sparsearray;
        int i;
        boolean flag1;
        flag1 = false;
        obj = new SparseArray();
        sparsearray = new SparseArray();
        if (b.containsKey(s))
        {
            break MISSING_BLOCK_LABEL_318;
        }
        (new StringBuilder("Searching supported color formats for mime type \"")).append(s).append("\"...");
        i = MediaCodecList.getCodecCount() - 1;
_L10:
        if (i < 0) goto _L2; else goto _L1
_L1:
        MediaCodecInfo mediacodecinfo;
        String as[];
        int j;
        mediacodecinfo = MediaCodecList.getCodecInfoAt(i);
        if (!mediacodecinfo.isEncoder())
        {
            continue; /* Loop/switch isn't completed */
        }
        as = mediacodecinfo.getSupportedTypes();
        j = 0;
_L9:
        if (j >= as.length) goto _L4; else goto _L3
_L3:
        android.media.MediaCodecInfo.CodecCapabilities codeccapabilities;
        boolean flag;
        int k;
        if (!as[j].equalsIgnoreCase(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        codeccapabilities = mediacodecinfo.getCapabilitiesForType(s);
        k = 0;
        flag = false;
        do
        {
            String as1[] = a.b;
            if (k > 0)
            {
                break;
            }
            as1 = a.b;
            if (j > 0)
            {
                break;
            }
            if (mediacodecinfo.getName().equalsIgnoreCase(a.b[j]))
            {
                flag = true;
            }
            k++;
        } while (true);
        k = 0;
_L6:
        int l;
        if (k >= codeccapabilities.colorFormats.length)
        {
            continue; /* Loop/switch isn't completed */
        }
        l = codeccapabilities.colorFormats[k];
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (((SparseArray) (obj)).get(l) == null)
        {
            ((SparseArray) (obj)).put(l, new ArrayList());
        }
        ((ArrayList)((SparseArray) (obj)).get(l)).add(mediacodecinfo.getName());
_L7:
        k++;
        if (true) goto _L6; else goto _L5
_L5:
        if (sparsearray.get(l) == null)
        {
            sparsearray.put(l, new ArrayList());
        }
        ((ArrayList)sparsearray.get(l)).add(mediacodecinfo.getName());
          goto _L7
        if (true) goto _L6; else goto _L8
_L8:
        j++;
          goto _L9
_L4:
        i--;
          goto _L10
_L2:
        b.put(s, obj);
        a.put(s, sparsearray);
        sparsearray = (SparseArray)a.get(s);
        s = (SparseArray)b.get(s);
        obj = new b();
        i = android.os.Build.VERSION.SDK_INT;
        i = 0;
_L11:
        int ai2[] = a.a;
        j = ((flag1) ? 1 : 0);
        if (i >= 4)
        {
            break MISSING_BLOCK_LABEL_408;
        }
        obj.a = (String)((ArrayList)sparsearray.get(a.a[i])).get(0);
        obj.b = a.a[i];
        j = ((flag1) ? 1 : 0);
_L12:
        int ai[] = a.a;
        if (j >= 4)
        {
            break MISSING_BLOCK_LABEL_446;
        }
        obj.c = (String)((ArrayList)s.get(a.a[j])).get(0);
        int ai1[] = a.a;
        Exception exception;
        Exception exception1;
        if (((b) (obj)).a != null)
        {
            d.a("CodecManager", (new StringBuilder("Choosen primary codec: ")).append(((b) (obj)).a).append(" with color format: ").append(((b) (obj)).b).toString());
            return ((b) (obj));
        } else
        {
            d.a("CodecManager", "No supported hardware codec found !");
            return ((b) (obj));
        }
        exception1;
        i++;
          goto _L11
        exception;
        j++;
          goto _L12
    }

}
