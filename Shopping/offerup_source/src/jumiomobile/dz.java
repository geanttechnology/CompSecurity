// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public final class dz extends Enum
{

    public static final dz a;
    public static final dz b;
    public static final dz c;
    public static final dz d;
    public static final dz e;
    public static final dz f;
    public static final dz g;
    public static final dz h;
    public static final dz i;
    public static final dz j;
    private static final dz o[];
    private int k;
    private String l;
    private String m;
    private boolean n;

    private dz(String s, int i1, int j1, String s1, String s2, boolean flag)
    {
        super(s, i1);
        k = j1;
        l = s1;
        m = s2;
        n = flag;
    }

    public static dz valueOf(String s)
    {
        return (dz)Enum.valueOf(jumiomobile/dz, s);
    }

    public static dz[] values()
    {
        return (dz[])o.clone();
    }

    public final int a()
    {
        return k;
    }

    public final String b()
    {
        return l;
    }

    public final String c()
    {
        return m;
    }

    public final boolean d()
    {
        return n;
    }

    static 
    {
        a = new dz("CREDIT_CARD_NOT_SUPPORTED", 0, 300, "error_view_message_credit_card_not_supported", "error_view_button_try_again", true);
        b = new dz("CANCEL_TYPE_BACKGROUND", 1, 310, "error_view_message_background_execution_not_supported", "", false);
        c = new dz("CREDIT_CARD_EXPIRED", 2, 320, "error_view_message_credit_card_expired", "error_view_button_try_again", true);
        d = new dz("CERTIFICATE_ERROR", 3, 200, "error_view_message_auth_failed", "error_view_button_cancel", false);
        e = new dz("AUTH_FAILED", 4, 210, "error_view_message_auth_failed", "error_view_button_cancel", false);
        f = new dz("INVALID_CREDENTIALS", 5, 220, "error_view_message_auth_failed", "error_view_button_cancel", false);
        g = new dz("OCR_LOADING_FAILED", 6, 240, "error_view_message_startup_error", "error_view_button_cancel", false);
        h = new dz("CANCEL_TYPE_USER", 7, 250, "error_view_message_cancelled_by_user", "", false);
        i = new dz("NO_CAMERA_CONNECTION", 8, 260, "error_view_message_no_camera_connection", "error_view_button_cancel", false);
        j = new dz("CARD_NOT_DETECTED", 9, 0, "", "", true);
        o = (new dz[] {
            a, b, c, d, e, f, g, h, i, j
        });
    }
}
