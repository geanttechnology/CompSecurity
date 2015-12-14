// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.tumblr;

import android.os.Bundle;
import android.text.TextUtils;
import com.flurry.sdk.ec;
import com.flurry.sdk.js;
import com.flurry.sdk.ka;
import com.flurry.sdk.kb;
import com.flurry.sdk.kc;
import com.flurry.sdk.kg;
import com.flurry.sdk.ly;
import com.flurry.sdk.me;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.flurry.android.tumblr:
//            PostListener

public abstract class Post
{

    private static final String a = com/flurry/android/tumblr/Post.getName();
    private static AtomicInteger g = new AtomicInteger(0);
    private String b;
    private String c;
    private String d;
    private PostListener e;
    private int f;
    private final kb h = new kb() {

        final Post a;

        public void a(ec ec1)
        {
            if (ec1.c == Post.a(a) && ec1.b != null)
            {
                PostListener postlistener = Post.b(a);
                if (postlistener != null)
                {
                    js.a().a(new ly(this, ec1, postlistener) {

                        final ec a;
                        final PostListener b;
                        final _cls1 c;

                        public void a()
                        {
                            class _cls2
                            {

                                static final int a[];

                                static 
                                {
                                    a = new int[com.flurry.sdk.ec.a.values().length];
                                    try
                                    {
                                        a[com.flurry.sdk.ec.a.a.ordinal()] = 1;
                                    }
                                    catch (NoSuchFieldError nosuchfielderror1) { }
                                    try
                                    {
                                        a[com.flurry.sdk.ec.a.b.ordinal()] = 2;
                                    }
                                    catch (NoSuchFieldError nosuchfielderror)
                                    {
                                        return;
                                    }
                                }
                            }

                            String s1;
                            switch (_cls2.a[a.b.ordinal()])
                            {
                            default:
                                return;

                            case 1: // '\001'
                                kg.a(3, Post.h(), (new StringBuilder()).append("Post success for ").append(a.c).toString());
                                b.onPostSuccess(a.f);
                                kc.a().b("com.flurry.android.impl.analytics.tumblr.TumblrEvents", Post.c(c.a));
                                me.a().a(Post.a(c.a));
                                return;

                            case 2: // '\002'
                                s1 = a.e;
                                break;
                            }
                            String s = s1;
                            if (TextUtils.isEmpty(s1))
                            {
                                s = "Internal error.";
                            }
                            kg.a(3, Post.h(), (new StringBuilder()).append("Post failed for ").append(a.c).append(" with error code: ").append(a.d).append("  and error message: ").append(s).toString());
                            b.onPostFailure(s);
                            kc.a().b("com.flurry.android.impl.analytics.tumblr.TumblrEvents", Post.c(c.a));
                            me.a().a(Post.a(c.a));
                        }

            
            {
                c = _pcls1;
                a = ec1;
                b = postlistener;
                super();
            }
                    });
                    return;
                }
            }
        }

        public volatile void a(ka ka)
        {
            a((ec)ka);
        }

            
            {
                a = Post.this;
                super();
            }
    };

    Post()
    {
        f = 0;
        f = g.incrementAndGet();
        kc.a().a("com.flurry.android.impl.analytics.tumblr.TumblrEvents", h);
    }

    static int a(Post post)
    {
        return post.f;
    }

    static PostListener b(Post post)
    {
        return post.e;
    }

    static kb c(Post post)
    {
        return post.h;
    }

    static String h()
    {
        return a;
    }

    abstract Bundle c();

    String d()
    {
        return c;
    }

    String e()
    {
        return b;
    }

    String f()
    {
        return d;
    }

    int g()
    {
        return f;
    }

    public void setAndroidDeeplink(String s)
    {
        c = s;
    }

    public void setIOSDeepLink(String s)
    {
        b = s;
    }

    public void setPostListener(PostListener postlistener)
    {
        e = postlistener;
    }

    public void setWebLink(String s)
    {
        d = s;
    }

}
