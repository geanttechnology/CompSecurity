// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.internal;

import android.support.v7.kb;
import android.support.v7.kc;
import com.facebook.h;
import com.facebook.k;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class f
{
    private static class a
    {

        private boolean a;

        public void a(ShareLinkContent sharelinkcontent)
        {
            f.a(sharelinkcontent, this);
        }

        public void a(ShareOpenGraphAction shareopengraphaction)
        {
            f.a(shareopengraphaction, this);
        }

        public void a(ShareOpenGraphContent shareopengraphcontent)
        {
            a = true;
            f.a(shareopengraphcontent, this);
        }

        public void a(ShareOpenGraphObject shareopengraphobject)
        {
            f.a(shareopengraphobject, this);
        }

        public void a(ShareOpenGraphValueContainer shareopengraphvaluecontainer, boolean flag)
        {
            f.a(shareopengraphvaluecontainer, this, flag);
        }

        public void a(SharePhoto sharephoto)
        {
            f.b(sharephoto, this);
        }

        public void a(SharePhotoContent sharephotocontent)
        {
            f.a(sharephotocontent, this);
        }

        public void a(ShareVideo sharevideo)
        {
            f.a(sharevideo, this);
        }

        public void a(ShareVideoContent sharevideocontent)
        {
            f.a(sharevideocontent, this);
        }

        public boolean a()
        {
            return a;
        }

        private a()
        {
            a = false;
        }

    }

    private static class b extends a
    {

        public void a(SharePhoto sharephoto)
        {
            f.a(sharephoto, this);
        }

        public void a(SharePhotoContent sharephotocontent)
        {
            throw new h("Cannot share SharePhotoContent via web sharing dialogs");
        }

        public void a(ShareVideoContent sharevideocontent)
        {
            throw new h("Cannot share ShareVideoContent via web sharing dialogs");
        }

        private b()
        {
        }

    }


    private static a a;
    private static a b;

    private static a a()
    {
        if (b == null)
        {
            b = new a();
        }
        return b;
    }

    public static void a(ShareContent sharecontent)
    {
        a(sharecontent, a());
    }

    private static void a(ShareContent sharecontent, a a1)
        throws h
    {
        if (sharecontent == null)
        {
            throw new h("Must provide non-null content to share");
        }
        if (sharecontent instanceof ShareLinkContent)
        {
            a1.a((ShareLinkContent)sharecontent);
        } else
        {
            if (sharecontent instanceof SharePhotoContent)
            {
                a1.a((SharePhotoContent)sharecontent);
                return;
            }
            if (sharecontent instanceof ShareVideoContent)
            {
                a1.a((ShareVideoContent)sharecontent);
                return;
            }
            if (sharecontent instanceof ShareOpenGraphContent)
            {
                a1.a((ShareOpenGraphContent)sharecontent);
                return;
            }
        }
    }

    static void a(ShareLinkContent sharelinkcontent, a a1)
    {
        b(sharelinkcontent, a1);
    }

    static void a(ShareOpenGraphAction shareopengraphaction, a a1)
    {
        b(shareopengraphaction, a1);
    }

    static void a(ShareOpenGraphContent shareopengraphcontent, a a1)
    {
        b(shareopengraphcontent, a1);
    }

    static void a(ShareOpenGraphObject shareopengraphobject, a a1)
    {
        b(shareopengraphobject, a1);
    }

    static void a(ShareOpenGraphValueContainer shareopengraphvaluecontainer, a a1, boolean flag)
    {
        b(shareopengraphvaluecontainer, a1, flag);
    }

    static void a(SharePhoto sharephoto, a a1)
    {
        e(sharephoto, a1);
    }

    static void a(SharePhotoContent sharephotocontent, a a1)
    {
        b(sharephotocontent, a1);
    }

    static void a(ShareVideo sharevideo, a a1)
    {
        b(sharevideo, a1);
    }

    static void a(ShareVideoContent sharevideocontent, a a1)
    {
        b(sharevideocontent, a1);
    }

    private static void a(Object obj, a a1)
    {
        if (obj instanceof ShareOpenGraphObject)
        {
            a1.a((ShareOpenGraphObject)obj);
        } else
        if (obj instanceof SharePhoto)
        {
            a1.a((SharePhoto)obj);
            return;
        }
    }

    private static void a(String s, boolean flag)
    {
        if (flag)
        {
            String as[] = s.split(":");
            if (as.length < 2)
            {
                throw new h("Open Graph keys must be namespaced: %s", new Object[] {
                    s
                });
            }
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                if (as[i].isEmpty())
                {
                    throw new h("Invalid key found in Open Graph dictionary: %s", new Object[] {
                        s
                    });
                }
                i++;
            }
        }
    }

    private static a b()
    {
        if (a == null)
        {
            a = new b();
        }
        return a;
    }

    public static void b(ShareContent sharecontent)
    {
        a(sharecontent, b());
    }

    private static void b(ShareLinkContent sharelinkcontent, a a1)
    {
        sharelinkcontent = sharelinkcontent.c();
        if (sharelinkcontent != null && !kb.b(sharelinkcontent))
        {
            throw new h("Image Url must be an http:// or https:// url");
        } else
        {
            return;
        }
    }

    private static void b(ShareOpenGraphAction shareopengraphaction, a a1)
    {
        if (shareopengraphaction == null)
        {
            throw new h("Must specify a non-null ShareOpenGraphAction");
        }
        if (kb.a(shareopengraphaction.a()))
        {
            throw new h("ShareOpenGraphAction must have a non-empty actionType");
        } else
        {
            a1.a(shareopengraphaction, false);
            return;
        }
    }

    private static void b(ShareOpenGraphContent shareopengraphcontent, a a1)
    {
        a1.a(shareopengraphcontent.a());
        a1 = shareopengraphcontent.b();
        if (kb.a(a1))
        {
            throw new h("Must specify a previewPropertyName.");
        }
        if (shareopengraphcontent.a().a(a1) == null)
        {
            throw new h((new StringBuilder()).append("Property \"").append(a1).append("\" was not found on the action. ").append("The name of the preview property must match the name of an ").append("action property.").toString());
        } else
        {
            return;
        }
    }

    private static void b(ShareOpenGraphObject shareopengraphobject, a a1)
    {
        if (shareopengraphobject == null)
        {
            throw new h("Cannot share a null ShareOpenGraphObject");
        } else
        {
            a1.a(shareopengraphobject, true);
            return;
        }
    }

    private static void b(ShareOpenGraphValueContainer shareopengraphvaluecontainer, a a1, boolean flag)
    {
        for (Iterator iterator = shareopengraphvaluecontainer.c().iterator(); iterator.hasNext();)
        {
            Object obj = (String)iterator.next();
            a(((String) (obj)), flag);
            obj = shareopengraphvaluecontainer.a(((String) (obj)));
            if (obj instanceof List)
            {
                obj = ((List)obj).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    Object obj1 = ((Iterator) (obj)).next();
                    if (obj1 == null)
                    {
                        throw new h("Cannot put null objects in Lists in ShareOpenGraphObjects and ShareOpenGraphActions");
                    }
                    a(obj1, a1);
                }
            } else
            {
                a(obj, a1);
            }
        }

    }

    static void b(SharePhoto sharephoto, a a1)
    {
        d(sharephoto, a1);
    }

    private static void b(SharePhotoContent sharephotocontent, a a1)
    {
        sharephotocontent = sharephotocontent.a();
        if (sharephotocontent == null || sharephotocontent.isEmpty())
        {
            throw new h("Must specify at least one Photo in SharePhotoContent.");
        }
        if (sharephotocontent.size() > 6)
        {
            throw new h(String.format(Locale.ROOT, "Cannot add more than %d photos.", new Object[] {
                Integer.valueOf(6)
            }));
        }
        for (sharephotocontent = sharephotocontent.iterator(); sharephotocontent.hasNext(); a1.a((SharePhoto)sharephotocontent.next())) { }
    }

    private static void b(ShareVideo sharevideo, a a1)
    {
        if (sharevideo == null)
        {
            throw new h("Cannot share a null ShareVideo");
        }
        sharevideo = sharevideo.b();
        if (sharevideo == null)
        {
            throw new h("ShareVideo does not have a LocalUrl specified");
        }
        if (!kb.c(sharevideo) && !kb.d(sharevideo))
        {
            throw new h("ShareVideo must reference a video that is on the device");
        } else
        {
            return;
        }
    }

    private static void b(ShareVideoContent sharevideocontent, a a1)
    {
        a1.a(sharevideocontent.d());
        sharevideocontent = sharevideocontent.c();
        if (sharevideocontent != null)
        {
            a1.a(sharevideocontent);
        }
    }

    private static void c(SharePhoto sharephoto, a a1)
    {
        if (sharephoto == null)
        {
            throw new h("Cannot share a null SharePhoto");
        }
        android.graphics.Bitmap bitmap = sharephoto.b();
        sharephoto = sharephoto.c();
        if (bitmap == null)
        {
            if (sharephoto == null)
            {
                throw new h("SharePhoto does not have a Bitmap or ImageUrl specified");
            }
            if (kb.b(sharephoto) && !a1.a())
            {
                throw new h("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
            }
        }
    }

    private static void d(SharePhoto sharephoto, a a1)
    {
        c(sharephoto, a1);
        if (sharephoto.b() != null || !kb.b(sharephoto.c()))
        {
            kc.c(k.f());
        }
    }

    private static void e(SharePhoto sharephoto, a a1)
    {
        if (sharephoto == null)
        {
            throw new h("Cannot share a null SharePhoto");
        }
        sharephoto = sharephoto.c();
        if (sharephoto == null || !kb.b(sharephoto))
        {
            throw new h("SharePhoto must have a non-null imageUrl set to the Uri of an image on the web");
        } else
        {
            return;
        }
    }
}
