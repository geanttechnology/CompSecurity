// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.tumblr;

import com.flurry.sdk.ec;
import com.flurry.sdk.js;
import com.flurry.sdk.ka;
import com.flurry.sdk.kb;

// Referenced classes of package com.flurry.android.tumblr:
//            Post

class a
    implements kb
{

    final Post a;

    public void a(ec ec1)
    {
        if (ec1.c == Post.a(a) && ec1.b != null)
        {
            PostListener postlistener = Post.b(a);
            if (postlistener != null)
            {
                class _cls1 extends ly
                {

                    final ec a;
                    final PostListener b;
                    final Post._cls1 c;

                    public void a()
                    {
                        String s1;
                        switch (Post._cls2.a[a.b.ordinal()])
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

            _cls1(ec ec1, PostListener postlistener)
            {
                c = Post._cls1.this;
                a = ec1;
                b = postlistener;
                super();
            }
                }

                js.a().a(new _cls1(ec1, postlistener));
                return;
            }
        }
    }

    public volatile void a(ka ka)
    {
        a((ec)ka);
    }

    _cls1(Post post)
    {
        a = post;
        super();
    }
}
