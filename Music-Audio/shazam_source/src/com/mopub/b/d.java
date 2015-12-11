// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.b;


// Referenced classes of package com.mopub.b:
//            j

public class d extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    public static final d e;
    public static final d f;
    public static final d g;
    public static final d h;
    public static final d i;
    public static final d j;
    private static final d l[];
    final String k;

    private d(String s, int i1, String s1)
    {
        super(s, i1);
        k = s1;
    }

    d(String s, int i1, String s1, byte byte0)
    {
        this(s, i1, s1);
    }

    static d a(String s)
    {
        d ad[] = values();
        int j1 = ad.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            d d1 = ad[i1];
            if (d1.k.equals(s))
            {
                return d1;
            }
        }

        return j;
    }

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/mopub/b/d, s);
    }

    public static d[] values()
    {
        return (d[])l.clone();
    }

    boolean a(j j1)
    {
        return false;
    }

    static 
    {
        a = new d("CLOSE", 0, "close");
        b = new d("EXPAND", "expand") {

            final boolean a(j j1)
            {
                return j1 == j.a;
            }

        };
        c = new d("USE_CUSTOM_CLOSE", 2, "usecustomclose");
        d = new d("OPEN", "open") {

            final boolean a(j j1)
            {
                return true;
            }

        };
        e = new d("RESIZE", "resize") {

            final boolean a(j j1)
            {
                return true;
            }

        };
        f = new d("SET_ORIENTATION_PROPERTIES", 5, "setOrientationProperties");
        g = new d("PLAY_VIDEO", "playVideo") {

            final boolean a(j j1)
            {
                return j1 == j.a;
            }

        };
        h = new d("STORE_PICTURE", "storePicture") {

            final boolean a(j j1)
            {
                return true;
            }

        };
        i = new d("CREATE_CALENDAR_EVENT", "createCalendarEvent") {

            final boolean a(j j1)
            {
                return true;
            }

        };
        j = new d("UNSPECIFIED", 9, "");
        l = (new d[] {
            a, b, c, d, e, f, g, h, i, j
        });
    }
}
