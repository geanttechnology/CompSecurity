// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.content.ContentValues;
import android.database.Cursor;
import com.medialets.thrift.MMAdDownload;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.medialets.advertising:
//            aa, a

final class ae
{

    public static final int TYPE_BANNER = 1;
    public static final int TYPE_BANNER_EXPANDABLE = 3;
    public static final int TYPE_INTERSTITIAL = 5;
    public static final int TYPE_INTERSTITIAL_LANDSCAPE = 6;
    private int A;
    private String a;
    private String b;
    private int c;
    private String d;
    private int e;
    private int f;
    private boolean g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private String p;
    private String q;
    private String r;
    private List s;
    private Date t;
    private Date u;
    private int v;
    private String w;
    private float x;
    private Date y;
    private boolean z;

    private ae()
    {
        m = 0;
        n = 0;
    }

    public static ae a(Cursor cursor)
    {
        ae ae1 = new ae();
        ae1.d = cursor.getString(cursor.getColumnIndex("adID"));
        ae1.a = cursor.getString(cursor.getColumnIndex("mainFile"));
        ae1.h = cursor.getInt(cursor.getColumnIndex("adSlotType"));
        ae1.A = cursor.getInt(cursor.getColumnIndex("adType"));
        ae1.e = cursor.getInt(cursor.getColumnIndex("maxImpressions"));
        ae1.f = cursor.getInt(cursor.getColumnIndex("maxRunImpressions"));
        ae1.c = cursor.getInt(cursor.getColumnIndex("adVersion"));
        ae1.i = cursor.getInt(cursor.getColumnIndex("width"));
        ae1.j = cursor.getInt(cursor.getColumnIndex("height"));
        ae1.k = cursor.getInt(cursor.getColumnIndex("expandedWidth"));
        ae1.l = cursor.getInt(cursor.getColumnIndex("expandedHeight"));
        ae1.b = cursor.getString(cursor.getColumnIndex("expandedMainFile"));
        ae1.m = cursor.getInt(cursor.getColumnIndex("impressions"));
        ae1.n = cursor.getInt(cursor.getColumnIndex("runImpressions"));
        ae1.g = aa.a(cursor.getInt(cursor.getColumnIndex("transparentView")));
        ae1.o = aa.a(cursor.getInt(cursor.getColumnIndex("creativeDownloaded")));
        ae1.p = cursor.getString(cursor.getColumnIndex("slotTargetNames"));
        ae1.q = cursor.getString(cursor.getColumnIndex("slotTargetKeywords"));
        ae1.r = cursor.getString(cursor.getColumnIndex("blockList"));
        ae1.s = aa.a(cursor.getString(cursor.getColumnIndex("trackingPixels")));
        ae1.t = aa.a(cursor.getString(cursor.getColumnIndex("startTimestamp")), aa.sDateFormat);
        ae1.u = aa.a(cursor.getString(cursor.getColumnIndex("endTimestamp")), aa.sDateFormat);
        ae1.v = cursor.getInt(cursor.getColumnIndex("minNetwork"));
        ae1.y = aa.a(cursor.getString(cursor.getColumnIndex("lastDisplayTimestamp")), aa.sDateFormat);
        return ae1;
    }

    public static ae a(MMAdDownload mmaddownload)
    {
        ae ae1 = new ae();
        mmaddownload = b(mmaddownload);
        ae1.d = (String)mmaddownload.get("adID");
        ae1.a = (String)mmaddownload.get("mainFile");
        ae1.b = (String)mmaddownload.get("expandedMainFile");
        ae1.w = (String)mmaddownload.get("bundleURL");
        ae1.p = (String)mmaddownload.get("slotTargetNames");
        ae1.q = (String)mmaddownload.get("slotTargetKeywords");
        ae1.r = (String)mmaddownload.get("blockList");
        ae1.s = aa.a((String)mmaddownload.get("trackingPixels"));
        ae1.c = aa.b((String)mmaddownload.get("adVersion"));
        ae1.h = aa.b((String)mmaddownload.get("adSlotType"));
        ae1.A = aa.b((String)mmaddownload.get("adType"));
        ae1.i = aa.b((String)mmaddownload.get("width"));
        ae1.j = aa.b((String)mmaddownload.get("height"));
        ae1.k = aa.b((String)mmaddownload.get("expandedWidth"));
        ae1.l = aa.b((String)mmaddownload.get("expandedHeight"));
        ae1.e = aa.b((String)mmaddownload.get("maxImpressions"));
        ae1.f = aa.b((String)mmaddownload.get("maxRunImpressions"));
        ae1.x = aa.c((String)mmaddownload.get("adWeight"));
        ae1.z = (new Boolean((String)mmaddownload.get("notForAdRotation"))).booleanValue();
        ae1.o = (new Boolean((String)mmaddownload.get("creativeDownloaded"))).booleanValue();
        String s1;
        if (mmaddownload.get("transparentView") != null && !((String)mmaddownload.get("transparentView")).equals("0"))
        {
            ae1.g = true;
        } else
        {
            ae1.g = false;
        }
        s1 = (String)mmaddownload.get("minNetwork");
        if (s1 != null && !s1.equals(""))
        {
            if (s1.equals("NotConnected"))
            {
                ae1.v = 0;
            } else
            if (s1.equals("CDNConnected"))
            {
                ae1.v = 2;
            } else
            if (s1.equals("WiFiConnected"))
            {
                ae1.v = 3;
            } else
            {
                ae1.v = 1;
            }
        } else
        {
            ae1.v = 1;
        }
        ae1.t = aa.a((String)mmaddownload.get("startDate"), aa.sDateFormat);
        ae1.u = aa.a((String)mmaddownload.get("endDate"), aa.sDateFormat);
        ae1.y = new Date();
        return ae1;
    }

    private static HashMap b(MMAdDownload mmaddownload)
    {
        String s1;
        HashMap hashmap;
        hashmap = new HashMap();
        s1 = mmaddownload.getAdControlPlist();
        hashmap.put("bundleURL", mmaddownload.getBundleURL());
        BufferedReader bufferedreader = new BufferedReader(new StringReader(s1), 8096);
        mmaddownload = "";
        int i1 = "\" = \"".length();
        boolean flag;
        s1 = "";
        flag = false;
_L2:
        String s2 = bufferedreader.readLine();
        Object obj;
        obj = hashmap;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_340;
        }
        s2 = s2.trim();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        if (s2.indexOf(");") == -1)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        hashmap.put(s1, mmaddownload);
        flag = false;
        continue; /* Loop/switch isn't completed */
        obj = mmaddownload;
        if (!mmaddownload.equals(""))
        {
            obj = (new StringBuilder()).append(mmaddownload).append(",").toString();
        }
        mmaddownload = ((MMAdDownload) (obj));
        if (s2.indexOf('"') == -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        mmaddownload = ((MMAdDownload) (obj));
        int j1;
        int l1;
        try
        {
            if (s2.lastIndexOf('"') != -1)
            {
                mmaddownload = (new StringBuilder()).append(((String) (obj))).append(s2.substring(s2.indexOf('"') + 1, s2.lastIndexOf('"'))).toString();
            }
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (MMAdDownload mmaddownload)
        {
            com.medialets.advertising.a.c((new StringBuilder()).append("Error parsing advertisement control data: ").append(mmaddownload.toString()).toString());
            obj = null;
        }
        break MISSING_BLOCK_LABEL_340;
        if (s2.equals("{") || s2.equals("}"))
        {
            continue; /* Loop/switch isn't completed */
        }
        j1 = s2.indexOf('"');
        l1 = s2.indexOf("\" = \"");
        if (l1 == -1)
        {
            break MISSING_BLOCK_LABEL_342;
        }
        mmaddownload = s2.substring(j1);
        s1 = mmaddownload.substring(1, l1);
        obj = mmaddownload.substring(l1 + i1, mmaddownload.indexOf("\";"));
        mmaddownload = ((MMAdDownload) (obj));
        if (obj == null)
        {
            mmaddownload = "";
        }
        hashmap.put(s1, mmaddownload);
        continue; /* Loop/switch isn't completed */
        return ((HashMap) (obj));
        int k1 = s2.indexOf("\" = (");
        if (k1 == -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = s2.substring(1, k1);
        mmaddownload = "";
        flag = true;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final String a()
    {
        return a;
    }

    public final void a(boolean flag)
    {
        o = true;
    }

    public final String b()
    {
        return b;
    }

    public final int c()
    {
        return c;
    }

    public final String d()
    {
        return d;
    }

    public final int e()
    {
        return e;
    }

    public final int f()
    {
        return f;
    }

    public final boolean g()
    {
        return g;
    }

    public final int h()
    {
        return i;
    }

    public final int i()
    {
        return j;
    }

    public final int j()
    {
        return k;
    }

    public final int k()
    {
        return l;
    }

    public final int l()
    {
        return m;
    }

    public final int m()
    {
        return n;
    }

    public final String n()
    {
        return p;
    }

    public final String o()
    {
        return q;
    }

    public final String p()
    {
        return r;
    }

    public final List q()
    {
        return s;
    }

    public final int r()
    {
        return v;
    }

    public final String s()
    {
        return w;
    }

    public final float t()
    {
        return x;
    }

    public final ContentValues u()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("adID", d);
        contentvalues.put("adVersion", Integer.valueOf(c));
        contentvalues.put("mainFile", a);
        contentvalues.put("expandedMainFile", b);
        contentvalues.put("adType", Integer.valueOf(A));
        contentvalues.put("adSlotType", Integer.valueOf(h));
        contentvalues.put("width", Integer.valueOf(i));
        contentvalues.put("height", Integer.valueOf(j));
        contentvalues.put("expandedWidth", Integer.valueOf(k));
        contentvalues.put("expandedHeight", Integer.valueOf(l));
        contentvalues.put("maxImpressions", Integer.valueOf(e));
        contentvalues.put("maxRunImpressions", Integer.valueOf(f));
        contentvalues.put("startTimestamp", aa.sDateFormat.format(t));
        contentvalues.put("endTimestamp", aa.sDateFormat.format(u));
        contentvalues.put("blockList", r);
        contentvalues.put("slotTargetNames", p);
        contentvalues.put("slotTargetKeywords", q);
        contentvalues.put("trackingPixels", aa.a(s));
        contentvalues.put("notForAdRotation", Boolean.valueOf(z));
        contentvalues.put("transparentView", Boolean.valueOf(g));
        contentvalues.put("creativeDownloaded", Boolean.valueOf(o));
        if (m != 0)
        {
            contentvalues.put("impressions", Integer.valueOf(m));
        }
        contentvalues.put("runImpressions", Integer.valueOf(n));
        contentvalues.put("minNetwork", Integer.valueOf(v));
        contentvalues.put("lastDisplayTimestamp", aa.sDateFormat.format(y));
        return contentvalues;
    }

    public final void v()
    {
        m = m + 1;
        n = n + 1;
        y = new Date();
    }
}
