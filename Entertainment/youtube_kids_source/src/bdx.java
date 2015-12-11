// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;

public final class bdx
{

    private static final bnt a = new bdy();
    private static final bnt b = new bej();
    private static final bnt c = new ben();
    private static final bnt d = new beo();
    private static final bnt e = new bep();
    private static final bnt f = new beq();
    private static final bnt g = new ber();
    private static final bnt h = new bes();
    private static final bnt i = new bet();
    private static final bnt j = new bdz();
    private static final bnt k = new bea();

    static int a(String s, int l)
    {
        return b(s, l);
    }

    private static void a(String s, bmi bmi, bnr bnr1)
    {
        bmi = new bem(bmi);
        bnr1.a(String.valueOf(s).concat("/AdSystem"), a).a(String.valueOf(s).concat("/Impression"), b).a(String.valueOf(s).concat("/Error"), d).a(String.valueOf(s).concat("/Creatives/Creative/Linear/TrackingEvents/Tracking"), c).a(String.valueOf(s).concat("/Creatives/Creative/Linear/VideoClicks/ClickThrough"), e).a(String.valueOf(s).concat("/Creatives/Creative/Linear/VideoClicks/ClickTracking"), f).a(String.valueOf(s).concat("/Creatives/Creative/Linear/VideoClicks/CustomClick"), g).a(String.valueOf(s).concat("/Extensions/Extension/AdFormatExclusionPolicy/TrackingUri"), h).a(String.valueOf(s).concat("/Extensions/Extension/AdFormatExclusionPolicy/AdAssetFrequencyCap"), i).a(String.valueOf(s).concat("/Extensions/Extension/AdFormatExclusionPolicy/AdAssetTimeToLive"), bmi).a(String.valueOf(s).concat("/Extensions/Extension/ConversionUrl"), j).a(String.valueOf(s).concat("/Extensions/Extension/CustomTracking/Tracking"), k);
    }

    public static void a(String s, bmi bmi, bnr bnr1, bev bev, bdp bdp)
    {
        b.a(s);
        b.a(bmi);
        b.a(bnr1);
        b(s, bmi, bnr1, bev, bdp);
        for (int l = 0; l < 3; l++)
        {
            s = String.valueOf(s).concat("/VAST/Ad/Wrapper/Extensions/Extension/AdXml");
            b(s, bmi, bnr1, new beb(), bdp);
        }

    }

    private static int b(String s, int l)
    {
        if (TextUtils.isEmpty(s))
        {
            return l;
        }
        int i1;
        try
        {
            i1 = Integer.parseInt(s.trim());
        }
        catch (NumberFormatException numberformatexception)
        {
            String s1 = String.valueOf(Integer.toString(l));
            bmo.c((new StringBuilder(String.valueOf(s).length() + 30 + String.valueOf(s1).length())).append("Bad integer parse of:'").append(s).append("' using:").append(s1).toString());
            return l;
        }
        return i1;
    }

    private static void b(String s, bmi bmi, bnr bnr1, bev bev, bdp bdp)
    {
        String s1 = String.valueOf(s).concat("/VAST/Ad/InLine");
        String s2 = String.valueOf(s).concat("/VAST/Ad/Wrapper");
        bnr1.a(String.valueOf(s).concat("/VAST"), new bel(bev)).a(String.valueOf(s).concat("/VAST/Ad"), new bek(bdp)).a(String.valueOf(s1).concat("/Creatives/Creative/Linear/Duration"), new bei()).a(String.valueOf(s1).concat("/Creatives/Creative/Linear/AdParameters"), new beh()).a(String.valueOf(s1).concat("/Creatives/Creative/Linear/MediaFiles/MediaFile"), new beg(bmi)).a(String.valueOf(s1).concat("/Creatives/Creative/NonLinearAds/NonLinear/AdParameters"), new bef()).a(String.valueOf(s1).concat("/Extensions/Extension/ShowYouTubeAnnotations"), new bee()).a(String.valueOf(s1).concat("/Extensions/Extension"), new bed()).a(String.valueOf(s2).concat("/VASTAdTagURI"), new bec());
        a(s1, bmi, bnr1);
        a(s2, bmi, bnr1);
        bpq.a(String.valueOf(s1).concat("/Extensions/Extension"), bnr1);
    }

}
