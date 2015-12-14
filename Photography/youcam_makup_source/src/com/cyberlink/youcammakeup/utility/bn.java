// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.app.Activity;
import android.util.Log;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.MoreMakeupActivity;
import com.cyberlink.youcammakeup.database.more.makeup.MKCategoryV2Status;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.database.more.makeup.a;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.j;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ar;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.av;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.aw;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.k;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.m;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.u;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.v;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.w;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.x;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.y;
import com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem;
import com.cyberlink.youcammakeup.pages.moreview.p;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class bn
{

    private static final NetworkManager a = Globals.d().w();

    public static void a(long l, MakeupItemMetadata makeupitemmetadata, j j)
    {
        if (makeupitemmetadata == null)
        {
            return;
        }
        Long long1 = Long.valueOf(makeupitemmetadata.a());
        Log.d("TemplateItemUtil", (new StringBuilder()).append("[downloadTemplate] tid: ").append(long1).toString());
        try
        {
            a.a(long1.longValue(), l, makeupitemmetadata, j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MakeupItemMetadata makeupitemmetadata)
        {
            makeupitemmetadata.printStackTrace();
        }
    }

    private static void a(long l, com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype, MKCategoryV2Status mkcategoryv2status, e e)
    {
        a.a(new av(a, -1L, displaymakeuptype, mkcategoryv2status, new aw(e) {

            final e a;

            public void a(ar ar1)
            {
                a.a(null);
            }

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
            {
                java.util.Map map = MakeupItemTreeManager.a().b();
                Globals.d().w().K().a(MoreMakeupActivity.a, map);
                a.b(bn1);
            }

            public volatile void a(Object obj)
            {
                a((ar)obj);
            }

            public void a(Void void1)
            {
                a.c(void1);
            }

            public void b(Object obj)
            {
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = e1;
                super();
            }
        }));
    }

    public static void a(MKCategoryV2Status mkcategoryv2status, long l, com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype, e e)
    {
        a(l, displaymakeuptype, mkcategoryv2status, e);
    }

    public static void a(MakeupItemMetadata makeupitemmetadata)
    {
        if (makeupitemmetadata == null)
        {
            return;
        } else
        {
            long l = makeupitemmetadata.a();
            Log.d("TemplateItemUtil", (new StringBuilder()).append("[cancelDownloadTemplate] tid: ").append(Long.valueOf(l)).toString());
            a.d(makeupitemmetadata.a());
            return;
        }
    }

    public static void a(e e)
    {
        a.a(new k(a, new com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.l(e) {

            final e a;

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
            {
                a.b(bn1);
            }

            public void a(m m1)
            {
                a.a(m1.a());
            }

            public volatile void a(Object obj)
            {
                a((m)obj);
            }

            public void a(Void void1)
            {
                a.c(void1);
            }

            public void b(Object obj)
            {
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = e1;
                super();
            }
        }), com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.TaskPriority.b);
    }

    public static void a(ag ag, MakeupItemMetadata makeupitemmetadata, ImageView imageview, PanelDataCenter.ImageType imagetype)
    {
        long l = makeupitemmetadata.a();
        if (imagetype == com.cyberlink.youcammakeup.utility.PanelDataCenter.ImageType.a)
        {
            imagetype = makeupitemmetadata.f();
        } else
        {
            imagetype = makeupitemmetadata.g();
        }
        makeupitemmetadata = new com.cyberlink.youcammakeup.kernelctrl.networkmanager.k(makeupitemmetadata.a(), "Makeup_Item", imagetype);
        imageview.setTag(Long.valueOf(l));
        a.a(makeupitemmetadata, new l(imageview, ag, l) {

            final ImageView a;
            final ag b;
            final long c;

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a a1)
            {
            }

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
            {
                if (bn1 == null);
            }

            public volatile void a(Object obj)
            {
                a((String)obj);
            }

            public void a(String s)
            {
                if (a.getContext() == null)
                {
                    return;
                } else
                {
                    Globals.d(new Runnable(this, s) {

                        final String a;
                        final _cls3 b;

                        public void run()
                        {
                            if (b.b != null && b.a != null && ((Long)b.a.getTag()).longValue() == b.c)
                            {
                                b.b.a(a, b.a);
                            }
                        }

            
            {
                b = _pcls3;
                a = s;
                super();
            }
                    });
                    return;
                }
            }

            public void a(Void void1)
            {
            }

            public void b(Object obj)
            {
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            public void d(Object obj)
            {
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.a)obj);
            }

            
            {
                a = imageview;
                b = ag;
                c = l1;
                super();
            }
        });
    }

    public static void a(ag ag, MakeupItemMetadata makeupitemmetadata, DownloadGridItem downloadgriditem, PanelDataCenter.ImageType imagetype)
    {
        long l = makeupitemmetadata.a();
        if (imagetype == com.cyberlink.youcammakeup.utility.PanelDataCenter.ImageType.a)
        {
            imagetype = makeupitemmetadata.f();
        } else
        {
            imagetype = makeupitemmetadata.g();
        }
        makeupitemmetadata = new com.cyberlink.youcammakeup.kernelctrl.networkmanager.k(makeupitemmetadata.a(), "Makeup_Item", imagetype);
        a.a(makeupitemmetadata, new l(downloadgriditem, ag, l) {

            final DownloadGridItem a;
            final ag b;
            final long c;

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a a1)
            {
            }

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
            {
                if (bn1 == null);
            }

            public volatile void a(Object obj)
            {
                a((String)obj);
            }

            public void a(String s)
            {
                Activity activity = (Activity)a.getContext();
                if (activity == null)
                {
                    return;
                } else
                {
                    activity.runOnUiThread(new Runnable(this, s) {

                        final String a;
                        final _cls2 b;

                        public void run()
                        {
                            if (b.b != null && b.a != null && ((p)b.a.getTag()).b().longValue() == b.c)
                            {
                                b.b.a(a, b.a.getThumbView());
                            }
                            if (b.a != null)
                            {
                                b.a.c();
                            }
                        }

            
            {
                b = _pcls2;
                a = s;
                super();
            }
                    });
                    return;
                }
            }

            public void a(Void void1)
            {
            }

            public void b(Object obj)
            {
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            public void d(Object obj)
            {
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.a)obj);
            }

            
            {
                a = downloadgriditem;
                b = ag;
                c = l1;
                super();
            }
        });
    }

    public static void a(ag ag, a a1, ImageView imageview)
    {
        if (a1.c() == null)
        {
            return;
        } else
        {
            long l = a1.a();
            Log.d("TemplateItemUtil", (new StringBuilder()).append("[setThumbnail] categoryId: ").append(l).toString());
            a1 = new com.cyberlink.youcammakeup.kernelctrl.networkmanager.k(l, "Makeup_Category", a1.c());
            a.a(a1, new l(l, imageview, ag) {

                final long a;
                final ImageView b;
                final ag c;

                public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a a2)
                {
                }

                public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
                {
                    if (bn1 != null)
                    {
                        Log.d("TemplateItemUtil", (new StringBuilder()).append("[setThumbnail] error: ").append(bn1.toString()).append(" categoryId: ").append(a).toString());
                    }
                }

                public volatile void a(Object obj)
                {
                    a((String)obj);
                }

                public void a(String s)
                {
                    Log.d("TemplateItemUtil", (new StringBuilder()).append("[setThumbnail] complete: ").append(s).append(" categoryId: ").append(a).toString());
                    ((Activity)b.getContext()).runOnUiThread(new Runnable(this, s) {

                        final String a;
                        final _cls1 b;

                        public void run()
                        {
                            if (b.c != null)
                            {
                                b.c.a(a, b.b);
                            }
                        }

            
            {
                b = _pcls1;
                a = s;
                super();
            }
                    });
                }

                public void a(Void void1)
                {
                }

                public void b(Object obj)
                {
                    a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
                }

                public void c(Object obj)
                {
                    a((Void)obj);
                }

                public void d(Object obj)
                {
                    a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.a)obj);
                }

            
            {
                a = l1;
                b = imageview;
                c = ag;
                super();
            }
            });
            return;
        }
    }

    public static void a(List list, e e)
    {
        a.a(new w(a, list, new x(e) {

            final e a;

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
            {
                a.b(bn1);
            }

            public void a(y y1)
            {
                a.a(y1.a());
            }

            public volatile void a(Object obj)
            {
                a((y)obj);
            }

            public void a(Void void1)
            {
                a.c(void1);
            }

            public void b(Object obj)
            {
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = e1;
                super();
            }
        }), com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.TaskPriority.b);
    }

    public static boolean a(MakeupItemMetadata makeupitemmetadata, PanelDataCenter.ImageType imagetype)
    {
        if (imagetype == com.cyberlink.youcammakeup.utility.PanelDataCenter.ImageType.a)
        {
            imagetype = makeupitemmetadata.f();
        } else
        {
            imagetype = makeupitemmetadata.g();
        }
        makeupitemmetadata = new com.cyberlink.youcammakeup.kernelctrl.networkmanager.k(makeupitemmetadata.a(), "Makeup_Item", imagetype);
        return (new File(a.a(makeupitemmetadata))).exists();
    }

    public static void b(List list, e e)
    {
        a.a(new u(a, list, new v(e) {

            final e a;

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
            {
                a.b(bn1);
            }

            public void a(y y1)
            {
                a.a(y1.a());
            }

            public volatile void a(Object obj)
            {
                a((y)obj);
            }

            public void a(Void void1)
            {
                a.c(void1);
            }

            public void b(Object obj)
            {
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = e1;
                super();
            }
        }), com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.TaskPriority.b);
    }

}
