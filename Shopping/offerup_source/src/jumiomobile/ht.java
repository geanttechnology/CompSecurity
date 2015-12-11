// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;

// Referenced classes of package jumiomobile:
//            mk

public final class ht extends Enum
{

    public static final ht a;
    public static final ht b;
    public static final ht c;
    public static final ht d;
    public static final ht e;
    public static final ht f;
    public static final ht g;
    public static final ht h;
    public static final ht i;
    public static final ht j;
    public static final ht k;
    public static final ht l;
    public static final ht m;
    public static final ht n;
    public static final ht o;
    private static final ht s[];
    protected int p;
    protected String q;
    protected boolean r;

    private ht(String s1, int i1, int j1, String s2, boolean flag)
    {
        super(s1, i1);
        p = j1;
        q = s2;
        r = flag;
    }

    public static ht a(int i1)
    {
        switch (i1)
        {
        default:
            return null;

        case 100: // 'd'
            return a;

        case 110: // 'n'
            return b;

        case 120: // 'x'
            return c;

        case 130: 
            return d;

        case 140: 
            return e;

        case 150: 
            return f;

        case 160: 
            return g;

        case 200: 
            return h;

        case 210: 
            return i;

        case 220: 
            return j;

        case 230: 
            return k;

        case 240: 
            return l;

        case 250: 
            return m;

        case 260: 
            return n;
        }
    }

    public static ht valueOf(String s1)
    {
        return (ht)Enum.valueOf(jumiomobile/ht, s1);
    }

    public static ht[] values()
    {
        return (ht[])s.clone();
    }

    public final int a()
    {
        return p;
    }

    public final String a(Context context)
    {
        return mk.a(context, q);
    }

    public final boolean b()
    {
        return r;
    }

    static 
    {
        a = new ht("REQUEST_SETTINGS_FAILED", 0, 100, "error_network_problems", true);
        b = new ht("REQUEST_INITIATE_FAILED", 1, 110, "error_network_problems", true);
        c = new ht("REQUEST_START_ATTEMPT_FAILED", 2, 120, "error_network_problems", true);
        d = new ht("REQUEST_ADD_PART_FAILED", 3, 130, "error_network_problems", true);
        e = new ht("REQUEST_DATA_FAILED", 4, 140, "error_network_problems", true);
        f = new ht("REQUEST_EXTRACT_DATA_FAILED", 5, 150, "error_network_problems", true);
        g = new ht("REQUEST_FINALIZE_FAILED", 6, 160, "error_network_problems", true);
        h = new ht("CERTIFICATE_ERROR", 7, 200, "error_auth_failed", false);
        i = new ht("AUTH_FAILED", 8, 210, "error_auth_failed", false);
        j = new ht("INVALID_CREDENTIALS", 9, 220, "error_auth_failed", false);
        k = new ht("DEVICE_IS_OFFLINE", 10, 230, "error_device_is_offline", true);
        l = new ht("OCR_LOADING_FAILED", 11, 240, "error_startup_error", false);
        m = new ht("CANCEL_TYPE_USER", 12, 250, "error_cancelled_by_user", false);
        n = new ht("NO_CAMERA_CONNECTION", 13, 260, "error_no_camera_connection", false);
        o = new ht("SAVING_INSTANCE_NOT_SUPPORTED", 14, 270, "error_saving_instance_not_supported", false);
        s = (new ht[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o
        });
    }
}
