// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.a.b;
import com.mopub.c.p;
import com.mopub.common.c.a;
import com.mopub.common.d.f;

// Referenced classes of package com.mopub.common:
//            o, m

public abstract class n extends Enum
{

    public static final n a;
    public static final n b;
    public static final n c;
    public static final n d;
    public static final n e;
    public static final n f;
    public static final n g;
    public static final n h;
    public static final n i;
    public static final n j;
    private static final n l[];
    private final boolean k;

    private n(String s, int i1, boolean flag)
    {
        super(s, i1);
        k = flag;
    }

    n(String s, int i1, boolean flag, byte byte0)
    {
        this(s, i1, flag);
    }

    public static n valueOf(String s)
    {
        return (n)Enum.valueOf(com/mopub/common/n, s);
    }

    public static n[] values()
    {
        return (n[])l.clone();
    }

    protected abstract void a(Context context, Uri uri, o o);

    public final void a(o o, Context context, Uri uri, boolean flag)
    {
        com.mopub.common.c.a.b((new StringBuilder("Ad event URL: ")).append(uri).toString());
        if (k && !flag)
        {
            throw new com.mopub.a.a("Attempted to handle action without user interaction.");
        } else
        {
            a(context, uri, o);
            return;
        }
    }

    public abstract boolean a(Uri uri);

    static 
    {
        a = new n("HANDLE_MOPUB_SCHEME") {

            protected final void a(Context context, Uri uri, o o1)
            {
                context = uri.getHost();
                o1 = o1.a;
                if ("finishLoad".equals(context))
                {
                    o1.a();
                } else
                if (!"close".equals(context))
                {
                    if ("failLoad".equals(context))
                    {
                        o1.b();
                        return;
                    } else
                    {
                        throw new com.mopub.a.a((new StringBuilder("Could not handle MoPub Scheme url: ")).append(uri).toString());
                    }
                }
            }

            public final boolean a(Uri uri)
            {
                return "mopub".equals(uri.getScheme());
            }

        };
        b = new n("IGNORE_ABOUT_SCHEME") {

            protected final void a(Context context, Uri uri, o o)
            {
                com.mopub.common.c.a.b("Link to about page ignored.");
            }

            public final boolean a(Uri uri)
            {
                return "about".equals(uri.getScheme());
            }

        };
        c = new n("HANDLE_PHONE_SCHEME") {

            protected final void a(Context context, Uri uri, o o)
            {
                com.mopub.common.d.f.a(context, uri, (new StringBuilder("Could not handle intent with URI: ")).append(uri).append("\n\tIs this intent supported on your phone?").toString());
            }

            public final boolean a(Uri uri)
            {
                uri = uri.getScheme();
                return "tel".equals(uri) || "voicemail".equals(uri) || "sms".equals(uri) || "mailto".equals(uri) || "geo".equals(uri) || "google.streetview".equals(uri);
            }

        };
        d = new n("OPEN_NATIVE_BROWSER") {

            protected final void a(Context context, Uri uri, o o)
            {
                o = (new StringBuilder("Unable to load mopub native browser url: ")).append(uri).toString();
                try
                {
                    com.mopub.common.d.f.a(context, com.mopub.common.d.f.a(uri), o);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    throw new com.mopub.a.a((new StringBuilder()).append(o).append("\n\t").append(context.getMessage()).toString());
                }
            }

            public final boolean a(Uri uri)
            {
                return "mopubnativebrowser".equals(uri.getScheme());
            }

        };
        e = new n("OPEN_APP_MARKET") {

            protected final void a(Context context, Uri uri, o o)
            {
                com.mopub.common.d.f.b(context, uri);
            }

            public final boolean a(Uri uri)
            {
                String s = uri.getScheme();
                String s1 = uri.getHost();
                return "play.google.com".equals(s1) || "market.android.com".equals(s1) || "market".equals(s) || uri.toString().startsWith("play.google.com/") || uri.toString().startsWith("market.android.com/");
            }

        };
        f = new n("OPEN_IN_APP_BROWSER") {

            protected final void a(Context context, Uri uri, o o1)
            {
                if (!o1.b)
                {
                    com.mopub.common.d.f.a(context, uri);
                }
            }

            public final boolean a(Uri uri)
            {
                uri = uri.getScheme();
                return "http".equals(uri) || "https".equals(uri);
            }

        };
        g = new n("HANDLE_SHARE_TWEET") {

            protected final void a(Context context, Uri uri, o o)
            {
                com.mopub.common.m.a(context);
                com.mopub.common.m.a(uri);
                o = (new StringBuilder("Could not handle share tweet intent with URI ")).append(uri).toString();
                try
                {
                    com.mopub.common.d.f.a(context, Intent.createChooser(com.mopub.common.d.f.b(uri), "Share via"), o);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    throw new com.mopub.a.a((new StringBuilder()).append(o).append("\n\t").append(context.getMessage()).toString());
                }
            }

            public final boolean a(Uri uri)
            {
                com.mopub.common.m.a(uri);
                return "mopubshare".equals(uri.getScheme()) && "tweet".equals(uri.getHost());
            }

        };
        h = new n("FOLLOW_DEEP_LINK_WITH_FALLBACK") {

            protected final void a(Context context, Uri uri, o o1)
            {
                if (!"navigate".equalsIgnoreCase(uri.getHost()))
                {
                    throw new com.mopub.a.a("Deeplink+ URL did not have 'navigate' as the host.");
                }
                String s;
                java.util.List list;
                Object obj;
                try
                {
                    obj = uri.getQueryParameter("primaryUrl");
                    list = uri.getQueryParameters("primaryTrackingUrl");
                    s = uri.getQueryParameter("fallbackUrl");
                    uri = uri.getQueryParameters("fallbackTrackingUrl");
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    throw new com.mopub.a.a("Deeplink+ URL was not a hierarchical URI.");
                }
                if (obj == null)
                {
                    throw new com.mopub.a.a("Deeplink+ did not have 'primaryUrl' query param.");
                }
                obj = Uri.parse(((String) (obj)));
                if (a(((Uri) (obj))))
                {
                    throw new com.mopub.a.a("Deeplink+ had another Deeplink+ as the 'primaryUrl'.");
                }
                try
                {
                    com.mopub.common.d.f.b(context, ((Uri) (obj)));
                    obj = com.mopub.common.a.a.d.c;
                    p.c(list, context);
                    return;
                }
                catch (com.mopub.a.a a1) { }
                if (s == null)
                {
                    throw new com.mopub.a.a("Unable to handle 'primaryUrl' for Deeplink+ and 'fallbackUrl' was missing.");
                }
                if (a(Uri.parse(s)))
                {
                    throw new com.mopub.a.a("Deeplink+ URL had another Deeplink+ URL as the 'fallbackUrl'.");
                } else
                {
                    o1.a(context, s, true, uri);
                    return;
                }
            }

            public final boolean a(Uri uri)
            {
                return "deeplink+".equalsIgnoreCase(uri.getScheme());
            }

        };
        i = new n("FOLLOW_DEEP_LINK") {

            protected final void a(Context context, Uri uri, o o)
            {
                com.mopub.common.d.f.b(context, uri);
            }

            public final boolean a(Uri uri)
            {
                String s = uri.getScheme();
                uri = uri.getHost();
                return !TextUtils.isEmpty(s) && !TextUtils.isEmpty(uri);
            }

        };
        j = new n("NOOP") {

            protected final void a(Context context, Uri uri, o o)
            {
            }

            public final boolean a(Uri uri)
            {
                return false;
            }

        };
        l = (new n[] {
            a, b, c, d, e, f, g, h, i, j
        });
    }
}
