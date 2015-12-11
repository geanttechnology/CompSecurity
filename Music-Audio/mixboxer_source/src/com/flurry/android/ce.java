// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.os.Looper;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.flurry.android:
//            cy, FlurryDataSenderIndex, FlurryAgent, FlurryDataSenderBlockInfo, 
//            cu, FlurryDataSenderAsyncOperation

final class ce
{

    private static volatile String ei = null;
    private static volatile String ej = "http://data.flurry.com/aap.do";
    private static volatile String ek = "https://data.flurry.com/aap.do";
    private static boolean el = false;
    FlurryDataSenderIndex em;
    private String en;
    private String eo;
    Set ep;
    private Context mContext;

    ce(Context context, String s, String s1)
    {
        mContext = null;
        em = null;
        en = null;
        eo = null;
        ep = new HashSet();
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            cy.d("FlurryDataSender", "FlurryDataSender constructor running on the MAIN thread!");
        }
        mContext = context;
        en = s;
        eo = s1;
        em = new FlurryDataSenderIndex(context, au());
        av();
    }

    static void a(ce ce1)
    {
        ce1.av();
    }

    private void av()
    {
        if (FlurryAgent.an == null || FlurryAgent.an.getNetworkStatus()) goto _L2; else goto _L1
_L1:
        cy.g("FlurryDataSender", "Reports were not sent! No Internet connection!");
_L4:
        return;
_L2:
        String s1;
        List list;
        s1 = au();
        list = em.getNotSentBlocksForDataKey(s1);
        if (list == null || list.isEmpty()) goto _L4; else goto _L3
_L3:
        int i;
        cy.e("FlurryDataSender", (new StringBuilder()).append("Number of not sent blocks = ").append(list.size()).toString());
        i = 0;
_L7:
        if (i >= list.size()) goto _L4; else goto _L5
_L5:
        String s2;
        s2 = (String)list.get(i);
        if (ep.contains(s2))
        {
            break MISSING_BLOCK_LABEL_189;
        }
        boolean flag;
        if (ep.size() <= 8)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L4; else goto _L6
_L6:
        byte abyte0[] = (new FlurryDataSenderBlockInfo(mContext, s2)).getData();
        if (abyte0 == null || abyte0.length == 0)
        {
            cy.d("FlurryDataSender", "Internal ERROR! Report is empty!");
            em.removeBlockInfoWithIdentifier(s2, s1);
        } else
        {
            ep.add(s2);
            String s;
            HashMap hashmap;
            if (ei != null)
            {
                s = ei;
            } else
            if (el)
            {
                s = ek;
            } else
            {
                s = ej;
            }
            cy.e("FlurryDataSender", (new StringBuilder()).append("FlurryDataSender: start upload data with id = ").append(s2).append(" to ").append(s).toString());
            hashmap = new HashMap();
            hashmap.put("del", new cu(this));
            hashmap.put("url", s);
            hashmap.put("data", abyte0);
            hashmap.put("id", s2);
            (new FlurryDataSenderAsyncOperation()).execute(new HashMap[] {
                hashmap
            });
        }
        i++;
          goto _L7
    }

    static boolean getUseHttps()
    {
        return el;
    }

    static void setReportUrl(String s)
    {
        if (s != null)
        {
            s.endsWith(".do");
        }
        ei = s;
    }

    static void setUseHttps(boolean flag)
    {
        el = flag;
    }

    public final void a(byte abyte0[])
        throws IOException
    {
        if (abyte0 == null || abyte0.length == 0)
        {
            cy.d("FlurryDataSender", "Report that has to be sent is EMPTY or NULL");
            return;
        }
        String s = au();
        if (s != null)
        {
            FlurryDataSenderBlockInfo flurrydatasenderblockinfo = new FlurryDataSenderBlockInfo(mContext);
            flurrydatasenderblockinfo.setData(abyte0);
            flurrydatasenderblockinfo.getIdentifier();
            em.addBlockInfo(flurrydatasenderblockinfo, s);
        }
        av();
    }

    final String au()
    {
        return (new StringBuilder()).append("Data_").append(en).append("_").append(eo).toString();
    }

    final void onNetworkStateChanged(boolean flag)
    {
        if (flag)
        {
            av();
        }
    }

}
