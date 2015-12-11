// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.android:
//            FlurryAds, ReportedIdType, fl, cy, 
//            cw, AdUnit

final class ea
{

    private static String p = "FlurryAgent";
    private FlurryAds fI;

    ea(FlurryAds flurryads)
    {
        fI = flurryads;
    }

    private static boolean h(String s, String s1)
    {
        return s1.equals((new StringBuilder()).append("%{").append(s).append("}").toString());
    }

    final String a(cw cw1, AdUnit adunit, String s, String s1)
    {
        if (h("fids", s1))
        {
            cw1 = new StringBuilder();
            cw1.append(0).append(":").append(FlurryAds.getPhoneId());
            adunit = fI.bi();
            if (adunit != null)
            {
                for (adunit = adunit.entrySet().iterator(); adunit.hasNext();)
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)adunit.next();
                    cw1.append(",").append(((ReportedIdType)entry.getKey()).eS).append(":");
                    if (((ReportedIdType)entry.getKey()).eT)
                    {
                        cw1.append(((ByteBuffer)entry.getValue()).array());
                    } else
                    {
                        cw1.append(fl.d(((ByteBuffer)entry.getValue()).array()));
                    }
                }

            }
            cy.c(p, (new StringBuilder()).append("Replacing param fids with: ").append(cw1.toString()).toString());
            adunit = s.replace(s1, fl.D(cw1.toString()));
        } else
        {
            if (h("sid", s1))
            {
                cw1 = String.valueOf(fI.aJ());
                cy.c(p, (new StringBuilder()).append("Replacing param sid with: ").append(cw1).toString());
                return s.replace(s1, fl.D(cw1));
            }
            if (h("lid", s1))
            {
                cw1 = String.valueOf(cw1.getIndex());
                cy.c(p, (new StringBuilder()).append("Replacing param lid with: ").append(cw1).toString());
                return s.replace(s1, fl.D(cw1));
            }
            if (h("guid", s1))
            {
                cw1 = cw1.aA();
                cy.c(p, (new StringBuilder()).append("Replacing param guid with: ").append(cw1).toString());
                return s.replace(s1, fl.D(cw1));
            }
            if (h("ats", s1))
            {
                cw1 = String.valueOf(System.currentTimeMillis());
                cy.c(p, (new StringBuilder()).append("Replacing param ats with: ").append(cw1).toString());
                return s.replace(s1, fl.D(cw1));
            }
            if (h("apik", s1))
            {
                cw1 = FlurryAds.y();
                cy.c(p, (new StringBuilder()).append("Replacing param apik with: ").append(cw1).toString());
                return s.replace(s1, fl.D(cw1));
            }
            if (h("hid", s1))
            {
                cw1 = adunit.getAdSpace().toString();
                cy.c(p, (new StringBuilder()).append("Replacing param hid with: ").append(cw1).toString());
                return s.replace(s1, fl.D(cw1));
            }
            if (h("eso", s1))
            {
                cw1 = Long.toString(System.currentTimeMillis() - fI.aJ());
                cy.c(p, (new StringBuilder()).append("Replacing param eso with: ").append(cw1).toString());
                return s.replace(s1, fl.D(cw1));
            }
            if (h("uc", s1))
            {
                adunit = fI.bk().entrySet().iterator();
                java.util.Map.Entry entry1;
                for (cw1 = ""; adunit.hasNext(); cw1 = (new StringBuilder()).append(cw1).append("c_").append(fl.D((String)entry1.getKey())).append("=").append(fl.D((String)entry1.getValue())).append("&").toString())
                {
                    entry1 = (java.util.Map.Entry)adunit.next();
                }

                cy.c(p, (new StringBuilder()).append("Replacing param uc with: ").append(cw1).toString());
                s = s.replace(s1, cw1);
                adunit = s;
                if (cw1.equals(""))
                {
                    adunit = s;
                    if (s.length() > 0)
                    {
                        return s.substring(0, s.length() - 1);
                    }
                }
            } else
            {
                cy.c(p, (new StringBuilder()).append("Unknown param: ").append(s1).toString());
                return s.replace(s1, "");
            }
        }
        return adunit;
    }

}
