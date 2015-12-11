// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.b;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookActivity;
import com.facebook.b.g;
import com.facebook.b.h;
import com.facebook.b.i;
import com.facebook.b.p;
import com.facebook.b.s;
import com.facebook.b.t;
import com.facebook.b.u;
import com.facebook.k;
import com.facebook.share.model.AppInviteContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class com.facebook.share.b.a extends i
{
    private final class a extends com.facebook.b.i.a
    {

        final com.facebook.share.b.a b;

        public final com.facebook.b.a a(Object obj)
        {
            obj = (AppInviteContent)obj;
            com.facebook.b.a a1 = b.b();
            obj = new com.facebook.b.h.a(this, ((AppInviteContent) (obj))) {

                final AppInviteContent a;
                final a b;

                public final Bundle a()
                {
                    return com.facebook.share.b.a.a(a);
                }

                public final Bundle b()
                {
                    Log.e("AppInviteDialog", "Attempting to present the AppInviteDialog with an outdated Facebook app on the device");
                    return new Bundle();
                }

            
            {
                b = a1;
                a = appinvitecontent;
                super();
            }
            };
            Object obj1 = com.facebook.share.b.a.e();
            android.content.Context context = k.g();
            String s = ((g) (obj1)).a();
            int j = com.facebook.b.h.b(((g) (obj1)));
            if (j == -1)
            {
                throw new com.facebook.h("Cannot present this dialog. This likely means that the Facebook app is not installed.");
            }
            if (p.a(j))
            {
                obj = ((com.facebook.b.h.a) (obj)).a();
            } else
            {
                obj = ((com.facebook.b.h.a) (obj)).b();
            }
            obj1 = obj;
            if (obj == null)
            {
                obj1 = new Bundle();
            }
            obj = p.a(context, a1.a.toString(), s, j, ((Bundle) (obj1)));
            if (obj == null)
            {
                throw new com.facebook.h("Unable to create Intent; this likely means theFacebook app is not installed.");
            } else
            {
                a1.b = ((Intent) (obj));
                return a1;
            }
        }

        public final boolean b()
        {
            return com.facebook.share.b.a.d();
        }

        private a()
        {
            b = com.facebook.share.b.a.this;
            super(com.facebook.share.b.a.this);
        }

        a(byte byte0)
        {
            this();
        }
    }

    private final class b extends com.facebook.b.i.a
    {

        final com.facebook.share.b.a b;

        public final com.facebook.b.a a(Object obj)
        {
            obj = (AppInviteContent)obj;
            com.facebook.b.a a1 = b.b();
            Bundle bundle = com.facebook.share.b.a.a(((AppInviteContent) (obj)));
            g g1 = com.facebook.share.b.a.e();
            u.b(k.g());
            u.a(k.g());
            String s1 = g1.name();
            obj = com.facebook.b.h.a(g1);
            if (obj == null)
            {
                throw new com.facebook.h((new StringBuilder("Unable to fetch the Url for the DialogFeature : '")).append(s1).append("'").toString());
            }
            int j = p.a();
            bundle = s.a(a1.a.toString(), j, bundle);
            if (bundle == null)
            {
                throw new com.facebook.h("Unable to fetch the app's key-hash");
            }
            if (((Uri) (obj)).isRelative())
            {
                obj = t.a(s.a(), ((Uri) (obj)).toString(), bundle);
            } else
            {
                obj = t.a(((Uri) (obj)).getAuthority(), ((Uri) (obj)).getPath(), bundle);
            }
            bundle = new Bundle();
            bundle.putString("url", ((Uri) (obj)).toString());
            bundle.putBoolean("is_fallback", true);
            obj = new Intent();
            p.a(((Intent) (obj)), a1.a.toString(), g1.a(), p.a(), bundle);
            ((Intent) (obj)).setClass(k.g(), com/facebook/FacebookActivity);
            ((Intent) (obj)).setAction("FacebookDialogFragment");
            a1.b = ((Intent) (obj));
            return a1;
        }

        public final boolean b()
        {
            return com.facebook.share.b.a.f();
        }

        private b()
        {
            b = com.facebook.share.b.a.this;
            super(com.facebook.share.b.a.this);
        }

        b(byte byte0)
        {
            this();
        }
    }


    private static final int c;

    private com.facebook.share.b.a(Activity activity)
    {
        super(activity, c);
    }

    static Bundle a(AppInviteContent appinvitecontent)
    {
        Bundle bundle = new Bundle();
        bundle.putString("app_link_url", appinvitecontent.a);
        bundle.putString("preview_image_url", appinvitecontent.b);
        return bundle;
    }

    public static void a(Activity activity, AppInviteContent appinvitecontent)
    {
        (new com.facebook.share.b.a(activity)).a(appinvitecontent);
    }

    public static boolean c()
    {
        return g() || h();
    }

    static boolean d()
    {
        return g();
    }

    static g e()
    {
        return com.facebook.share.a.a.a;
    }

    static boolean f()
    {
        return h();
    }

    private static boolean g()
    {
        return com.facebook.b.h.b(com.facebook.share.a.a.a) != -1;
    }

    private static boolean h()
    {
        return com.facebook.b.h.a(com.facebook.share.a.a.a) != null;
    }

    protected final List a()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new a((byte)0));
        arraylist.add(new b((byte)0));
        return arraylist;
    }

    protected final com.facebook.b.a b()
    {
        return new com.facebook.b.a(super.b);
    }

    static 
    {
        c = com.facebook.b.f.b.h.a();
    }
}
