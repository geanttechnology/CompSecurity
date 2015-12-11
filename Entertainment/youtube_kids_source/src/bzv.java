// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.http.client.HttpResponseException;

public final class bzv extends HttpResponseException
    implements bmn
{

    private static final List a;
    private List b;

    public bzv(int i, String s, List list)
    {
        String s1;
        if (list == null || list.size() == 0)
        {
            s1 = "none";
        } else
        {
            s1 = list.toString();
        }
        super(i, (new StringBuilder(String.valueOf(s).length() + 20 + String.valueOf(s1).length())).append(s).append(", GData error(s):\n  ").append(s1).toString());
        if (list == null)
        {
            s = Collections.emptyList();
        } else
        {
            s = Collections.unmodifiableList(list);
        }
        b = s;
    }

    public static bzv a(int i, String s)
    {
        return new bzv(i, s, a);
    }

    private boolean a(String s, String s1, String s2, String s3)
    {
        for (s2 = b.iterator(); s2.hasNext();)
        {
            cdp cdp1 = (cdp)s2.next();
            if (TextUtils.equals(s, cdp1.a) && TextUtils.equals(s1, cdp1.b) && (s3 == null || TextUtils.equals(s3, cdp1.d)))
            {
                return true;
            }
        }

        return false;
    }

    public final Pair a(Context context)
    {
        if (a("yt:service", "disabled_in_maintenance_mode", null, null))
        {
            return Pair.create(context.getString(0x7f0b00ae), "youtubeServerDown");
        }
        if (a())
        {
            return Pair.create(context.getString(0x7f0b00af), "noLinkedYoutubeAccount");
        }
        if (a("GData", "InvalidRequestUriException", null, null))
        {
            return Pair.create(context.getString(0x7f0b00b0), "invalidRequest");
        }
        if (a("GData", "ServiceForbiddenException", null, "Private video"))
        {
            return Pair.create(context.getString(0x7f0b007f), "videoIsPrivate");
        } else
        {
            return a.a(context, this);
        }
    }

    public final boolean a()
    {
        return a("yt:service", "youtube_signup_required", null, null) || a("GData", "InvalidRequestUriException", null, "Missing or invalid username.");
    }

    static 
    {
        ArrayList arraylist = new ArrayList(1);
        a = arraylist;
        arraylist.add(new cdp("yt:service", "youtube_signup_required", null, null));
    }
}
