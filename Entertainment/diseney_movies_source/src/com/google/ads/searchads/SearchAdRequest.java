// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.searchads;

import android.content.Context;
import android.graphics.Color;
import com.google.ads.AdRequest;
import com.google.ads.mediation.admob.AdMobAdapterExtras;
import java.util.Locale;
import java.util.Map;

public class SearchAdRequest extends AdRequest
{
    public static final class BorderType extends Enum
    {

        public static final BorderType DASHED;
        public static final BorderType DOTTED;
        public static final BorderType NONE;
        public static final BorderType SOLID;
        private static final BorderType b[];
        private String a;

        public static BorderType valueOf(String s)
        {
            return (BorderType)Enum.valueOf(com/google/ads/searchads/SearchAdRequest$BorderType, s);
        }

        public static BorderType[] values()
        {
            return (BorderType[])b.clone();
        }

        public String toString()
        {
            return a;
        }

        static 
        {
            NONE = new BorderType("NONE", 0, "none");
            DASHED = new BorderType("DASHED", 1, "dashed");
            DOTTED = new BorderType("DOTTED", 2, "dotted");
            SOLID = new BorderType("SOLID", 3, "solid");
            b = (new BorderType[] {
                NONE, DASHED, DOTTED, SOLID
            });
        }

        private BorderType(String s, int i1, String s1)
        {
            super(s, i1);
            a = s1;
        }
    }


    private String a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private String h;
    private int i;
    private int j;
    private BorderType k;
    private int l;
    private String m;

    public SearchAdRequest()
    {
    }

    private String a(int i1)
    {
        return String.format(Locale.US, "#%06x", new Object[] {
            Integer.valueOf(0xffffff & i1)
        });
    }

    public Map getRequestMap(Context context)
    {
        AdMobAdapterExtras admobadapterextras1 = (AdMobAdapterExtras)getNetworkExtras(com/google/ads/mediation/admob/AdMobAdapterExtras);
        AdMobAdapterExtras admobadapterextras = admobadapterextras1;
        if (admobadapterextras1 == null)
        {
            admobadapterextras = new AdMobAdapterExtras();
            setNetworkExtras(admobadapterextras);
        }
        if (a != null)
        {
            admobadapterextras.getExtras().put("q", a);
        }
        if (Color.alpha(b) != 0)
        {
            admobadapterextras.getExtras().put("bgcolor", a(b));
        }
        if (Color.alpha(c) == 255 && Color.alpha(d) == 255)
        {
            admobadapterextras.getExtras().put("gradientfrom", a(c));
            admobadapterextras.getExtras().put("gradientto", a(d));
        }
        if (Color.alpha(e) != 0)
        {
            admobadapterextras.getExtras().put("hcolor", a(e));
        }
        if (Color.alpha(f) != 0)
        {
            admobadapterextras.getExtras().put("dcolor", a(f));
        }
        if (Color.alpha(g) != 0)
        {
            admobadapterextras.getExtras().put("acolor", a(g));
        }
        if (h != null)
        {
            admobadapterextras.getExtras().put("font", h);
        }
        admobadapterextras.getExtras().put("headersize", Integer.toString(i));
        if (Color.alpha(j) != 0)
        {
            admobadapterextras.getExtras().put("bcolor", a(j));
        }
        if (k != null)
        {
            admobadapterextras.getExtras().put("btype", k.toString());
        }
        admobadapterextras.getExtras().put("bthick", Integer.toString(l));
        if (m != null)
        {
            admobadapterextras.getExtras().put("channel", m);
        }
        return super.getRequestMap(context);
    }

    public void setAnchorTextColor(int i1)
    {
        g = i1;
    }

    public void setBackgroundColor(int i1)
    {
        if (Color.alpha(i1) == 255)
        {
            b = i1;
            c = 0;
            d = 0;
        }
    }

    public void setBackgroundGradient(int i1, int j1)
    {
        if (Color.alpha(i1) == 255 && Color.alpha(j1) == 255)
        {
            b = Color.argb(0, 0, 0, 0);
            c = i1;
            d = j1;
        }
    }

    public void setBorderColor(int i1)
    {
        j = i1;
    }

    public void setBorderThickness(int i1)
    {
        l = i1;
    }

    public void setBorderType(BorderType bordertype)
    {
        k = bordertype;
    }

    public void setCustomChannels(String s)
    {
        m = s;
    }

    public void setDescriptionTextColor(int i1)
    {
        f = i1;
    }

    public void setFontFace(String s)
    {
        h = s;
    }

    public void setHeaderTextColor(int i1)
    {
        e = i1;
    }

    public void setHeaderTextSize(int i1)
    {
        i = i1;
    }

    public void setQuery(String s)
    {
        a = s;
    }
}
