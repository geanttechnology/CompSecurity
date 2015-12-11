// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.facebook.f;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.internal.c;
import com.facebook.share.internal.g;
import com.facebook.share.internal.h;
import com.facebook.share.internal.i;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7:
//            jq, ke, jg, jp, 
//            ji, jo, jn

public final class kf extends jq
    implements ke
{
    private class a extends jq.a
    {

        final kf b;

        public Object a()
        {
            return b.d;
        }

        public boolean a(ShareContent sharecontent)
        {
            return (sharecontent instanceof ShareLinkContent) || (sharecontent instanceof ShareFeedContent);
        }

        public volatile boolean a(Object obj)
        {
            return a((ShareContent)obj);
        }

        public ji b(ShareContent sharecontent)
        {
            kf.a(b, android.support.v7.kf.c(b), sharecontent, b.d);
            ji ji1 = b.d();
            if (sharecontent instanceof ShareLinkContent)
            {
                sharecontent = (ShareLinkContent)sharecontent;
                com.facebook.share.internal.f.b(sharecontent);
                sharecontent = i.b(sharecontent);
            } else
            {
                sharecontent = i.a((ShareFeedContent)sharecontent);
            }
            jp.a(ji1, "feed", sharecontent);
            return ji1;
        }

        public volatile ji b(Object obj)
        {
            return b((ShareContent)obj);
        }

        private a()
        {
            b = kf.this;
            super(kf.this);
        }

    }

    public static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        private static final b e[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(android/support/v7/kf$b, s);
        }

        public static b[] values()
        {
            return (b[])e.clone();
        }

        static 
        {
            a = new b("AUTOMATIC", 0);
            b = new b("NATIVE", 1);
            c = new b("WEB", 2);
            d = new b("FEED", 3);
            e = (new b[] {
                a, b, c, d
            });
        }

        private b(String s, int i)
        {
            super(s, i);
        }
    }

    private class c extends jq.a
    {

        final kf b;

        public Object a()
        {
            return b.b;
        }

        public boolean a(ShareContent sharecontent)
        {
            return sharecontent != null && kf.b(sharecontent.getClass());
        }

        public volatile boolean a(Object obj)
        {
            return a((ShareContent)obj);
        }

        public ji b(ShareContent sharecontent)
        {
            kf.a(b, kf.a(b), sharecontent, b.b);
            com.facebook.share.internal.f.a(sharecontent);
            ji ji1 = b.d();
            jp.a(ji1, new jp.a(this, ji1, sharecontent, b.e()) {

                final ji a;
                final ShareContent b;
                final boolean c;
                final c d;

                public Bundle a()
                {
                    return com.facebook.share.internal.b.a(a.c(), b, c);
                }

                public Bundle b()
                {
                    return com.facebook.share.internal.a.a(a.c(), b, c);
                }

            
            {
                d = c1;
                a = ji1;
                b = sharecontent;
                c = flag;
                super();
            }
            }, android.support.v7.kf.c(sharecontent.getClass()));
            return ji1;
        }

        public volatile ji b(Object obj)
        {
            return b((ShareContent)obj);
        }

        private c()
        {
            b = kf.this;
            super(kf.this);
        }

    }

    private class d extends jq.a
    {

        final kf b;

        private String c(ShareContent sharecontent)
        {
            if (sharecontent instanceof ShareLinkContent)
            {
                return "share";
            }
            if (sharecontent instanceof ShareOpenGraphContent)
            {
                return "share_open_graph";
            } else
            {
                return null;
            }
        }

        public Object a()
        {
            return android.support.v7.b.c;
        }

        public boolean a(ShareContent sharecontent)
        {
            return sharecontent != null && kf.d(sharecontent.getClass());
        }

        public volatile boolean a(Object obj)
        {
            return a((ShareContent)obj);
        }

        public ji b(ShareContent sharecontent)
        {
            kf.a(b, kf.b(b), sharecontent, android.support.v7.b.c);
            ji ji1 = b.d();
            com.facebook.share.internal.f.b(sharecontent);
            Bundle bundle;
            if (sharecontent instanceof ShareLinkContent)
            {
                bundle = i.a((ShareLinkContent)sharecontent);
            } else
            {
                bundle = i.a((ShareOpenGraphContent)sharecontent);
            }
            jp.a(ji1, c(sharecontent), bundle);
            return ji1;
        }

        public volatile ji b(Object obj)
        {
            return b((ShareContent)obj);
        }

        private d()
        {
            b = kf.this;
            super(kf.this);
        }

    }


    private static final int b;
    private boolean c;
    private boolean d;

    public kf(Activity activity)
    {
        super(activity, b);
        c = false;
        d = true;
        h.a(b);
    }

    static Activity a(kf kf1)
    {
        return kf1.b();
    }

    private void a(Context context, ShareContent sharecontent, b b1)
    {
        if (d)
        {
            b1 = b.a;
        }
        static class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[b.values().length];
                try
                {
                    a[b.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[android.support.v7.b.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[b.b.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[b1.ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 105
    //                   2 111
    //                   3 117;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_117;
_L1:
        b1 = "unknown";
_L5:
        sharecontent = g(sharecontent.getClass());
        Bundle bundle;
        if (sharecontent == g.a)
        {
            sharecontent = "status";
        } else
        if (sharecontent == g.b)
        {
            sharecontent = "photo";
        } else
        if (sharecontent == g.c)
        {
            sharecontent = "video";
        } else
        if (sharecontent == com.facebook.share.internal.c.a)
        {
            sharecontent = "open_graph";
        } else
        {
            sharecontent = "unknown";
        }
        context = jg.b(context);
        bundle = new Bundle();
        bundle.putString("fb_share_dialog_show", b1);
        bundle.putString("fb_share_dialog_content_type", sharecontent);
        context.a("fb_share_dialog_show", null, bundle);
        return;
_L2:
        b1 = "automatic";
          goto _L5
_L3:
        b1 = "web";
          goto _L5
        b1 = "native";
          goto _L5
    }

    static void a(kf kf1, Context context, ShareContent sharecontent, b b1)
    {
        kf1.a(context, sharecontent, b1);
    }

    public static boolean a(Class class1)
    {
        return f(class1) || e(class1);
    }

    static Activity b(kf kf1)
    {
        return kf1.b();
    }

    static boolean b(Class class1)
    {
        return e(class1);
    }

    static Activity c(kf kf1)
    {
        return kf1.b();
    }

    static jo c(Class class1)
    {
        return g(class1);
    }

    static boolean d(Class class1)
    {
        return f(class1);
    }

    private static boolean e(Class class1)
    {
        class1 = g(class1);
        return class1 != null && jp.a(class1);
    }

    private static boolean f(Class class1)
    {
        return com/facebook/share/model/ShareLinkContent.isAssignableFrom(class1) || com/facebook/share/model/ShareOpenGraphContent.isAssignableFrom(class1);
    }

    private static jo g(Class class1)
    {
        if (com/facebook/share/model/ShareLinkContent.isAssignableFrom(class1))
        {
            return g.a;
        }
        if (com/facebook/share/model/SharePhotoContent.isAssignableFrom(class1))
        {
            return g.b;
        }
        if (com/facebook/share/model/ShareVideoContent.isAssignableFrom(class1))
        {
            return g.c;
        }
        if (com/facebook/share/model/ShareOpenGraphContent.isAssignableFrom(class1))
        {
            return com.facebook.share.internal.c.a;
        } else
        {
            return null;
        }
    }

    protected void a(jn jn, f f1)
    {
        h.a(a(), jn, f1);
    }

    protected List c()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new c(null));
        arraylist.add(new a(null));
        arraylist.add(new d(null));
        return arraylist;
    }

    protected ji d()
    {
        return new ji(a());
    }

    public boolean e()
    {
        return c;
    }

    static 
    {
        b = jn.b.b.a();
    }
}
