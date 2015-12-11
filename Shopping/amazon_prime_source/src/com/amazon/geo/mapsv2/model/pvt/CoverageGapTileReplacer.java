// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import android.util.Log;
import com.amazon.geo.mapsv2.model.BoundedTileReplacer;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;

public final class CoverageGapTileReplacer extends BoundedTileReplacer
{

    private static final String CHAR_SET = "UTF-8";
    private static final String HASH_ALGO = "MD5";
    private static final char HEX_ARRAY[] = "0123456789abcdef".toCharArray();
    private static final String TAG = "Maps-CoverageGapTileReplacer";
    private final String mUrlFormat;
    public final String version;

    public CoverageGapTileReplacer(String s, int i, int j, List list, double d, int k, 
            String s1)
    {
        super(i, j, list, d, k);
        mUrlFormat = s;
        version = s1;
    }

    private String getHash(int i, int j, int k)
    {
        byte abyte0[];
        String s1;
        char ac[];
        int l;
        int i1;
        try
        {
            String s = (new StringBuilder()).append(i).append("_").append(j).append("_").append(k).toString();
            abyte0 = MessageDigest.getInstance("MD5").digest(s.getBytes("UTF-8"));
            ac = new char[abyte0.length * 2];
        }
        catch (Exception exception)
        {
            Log.e("Maps-CoverageGapTileReplacer", (new StringBuilder()).append("Could not generate hash (").append(j).append(", ").append(k).append(", ").append(i).append(")").toString(), exception);
            return "";
        }
        l = 0;
        if (l >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = abyte0[l] & 0xff;
        ac[l * 2] = HEX_ARRAY[i1 >>> 4];
        ac[l * 2 + 1] = HEX_ARRAY[i1 & 0xf];
        l++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_63;
_L1:
        s1 = new String(Arrays.copyOfRange(ac, 4, 8));
        return s1;
    }

    public boolean equals(Object obj)
    {
        boolean flag2;
        boolean flag3;
        flag2 = true;
        flag3 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag3;
        if (!(obj instanceof CoverageGapTileReplacer)) goto _L4; else goto _L3
_L3:
        obj = (CoverageGapTileReplacer)obj;
        if (latLngBounds != null) goto _L6; else goto _L5
_L5:
        flag = flag3;
        if (((CoverageGapTileReplacer) (obj)).latLngBounds != null) goto _L4; else goto _L7
_L7:
        if (mUrlFormat != null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        flag = flag3;
        if (((CoverageGapTileReplacer) (obj)).mUrlFormat != null) goto _L4; else goto _L8
_L8:
        boolean flag1;
        if (zoomCap == ((CoverageGapTileReplacer) (obj)).zoomCap && zoomFloor == ((CoverageGapTileReplacer) (obj)).zoomFloor)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        return flag1;
_L6:
        if (!latLngBounds.equals(((CoverageGapTileReplacer) (obj)).latLngBounds))
        {
            return false;
        }
          goto _L7
        if (!mUrlFormat.equals(((CoverageGapTileReplacer) (obj)).mUrlFormat))
        {
            return false;
        }
          goto _L8
    }

    public URL getTileUrl(int i, int j, int k)
    {
        String s = getHash(k, i, j);
        s = String.format(mUrlFormat, new Object[] {
            s, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j)
        });
        URL url;
        try
        {
            url = new URL(s);
        }
        catch (Exception exception)
        {
            Log.e("Maps-CoverageGapTileReplacer", (new StringBuilder()).append("Could not create URL for string ").append(s).toString(), exception);
            return null;
        }
        return url;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        int k;
        int l;
        long l1;
        if (latLngBounds == null)
        {
            i = 0;
        } else
        {
            i = latLngBounds.hashCode();
        }
        l1 = Double.doubleToLongBits(zoomCap);
        k = (int)(l1 >>> 32 ^ l1);
        l = zoomFloor;
        if (mUrlFormat != null)
        {
            j = mUrlFormat.hashCode();
        }
        return (((i + 527) * 31 + k) * 31 + l) * 31 + j;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer("CoverageGapTileReplacer{latLngBounds=");
        stringbuffer.append(latLngBounds);
        stringbuffer.append(", zoomCap=");
        stringbuffer.append(zoomCap);
        stringbuffer.append(", mUrlFormat=");
        stringbuffer.append(mUrlFormat);
        stringbuffer.append("}");
        return stringbuffer.toString();
    }

}
