// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.PendingIntent;

public final class pp
{

    public static final pp a = new pp(0, null);
    private final PendingIntent b;
    private final int c;

    public pp(int i, PendingIntent pendingintent)
    {
        c = i;
        b = pendingintent;
    }

    private String e()
    {
        switch (c)
        {
        case 12: // '\f'
        default:
            return (new StringBuilder()).append("unknown status code ").append(c).toString();

        case 0: // '\0'
            return "SUCCESS";

        case 1: // '\001'
            return "SERVICE_MISSING";

        case 2: // '\002'
            return "SERVICE_VERSION_UPDATE_REQUIRED";

        case 3: // '\003'
            return "SERVICE_DISABLED";

        case 4: // '\004'
            return "SIGN_IN_REQUIRED";

        case 5: // '\005'
            return "INVALID_ACCOUNT";

        case 6: // '\006'
            return "RESOLUTION_REQUIRED";

        case 7: // '\007'
            return "NETWORK_ERROR";

        case 8: // '\b'
            return "INTERNAL_ERROR";

        case 9: // '\t'
            return "SERVICE_INVALID";

        case 10: // '\n'
            return "DEVELOPER_ERROR";

        case 11: // '\013'
            return "LICENSE_CHECK_FAILED";

        case 13: // '\r'
            return "CANCELED";

        case 14: // '\016'
            return "TIMEOUT";

        case 15: // '\017'
            return "INTERRUPTED";
        }
    }

    public void a(Activity activity, int i)
    {
        if (!a())
        {
            return;
        } else
        {
            activity.startIntentSenderForResult(b.getIntentSender(), i, null, 0, 0, 0);
            return;
        }
    }

    public boolean a()
    {
        return c != 0 && b != null;
    }

    public boolean b()
    {
        return c == 0;
    }

    public int c()
    {
        return c;
    }

    public PendingIntent d()
    {
        return b;
    }

    public String toString()
    {
        return adv.a(this).a("statusCode", e()).a("resolution", b).toString();
    }

}
