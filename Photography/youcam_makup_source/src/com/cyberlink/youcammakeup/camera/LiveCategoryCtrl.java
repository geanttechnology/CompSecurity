// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.app.Fragment;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent;
import com.cyberlink.youcammakeup.kernelctrl.LiveDemoConfigHelper;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.widgetpool.common.TextLoopView;
import com.cyberlink.youcammakeup.widgetpool.common.am;
import com.cyberlink.youcammakeup.widgetpool.panel.c.a;
import com.cyberlink.youcammakeup.widgetpool.panel.c.b;
import com.cyberlink.youcammakeup.widgetpool.panel.c.d;
import com.cyberlink.youcammakeup.widgetpool.panel.c.h;
import com.cyberlink.youcammakeup.widgetpool.panel.c.j;
import com.cyberlink.youcammakeup.widgetpool.panel.c.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            t, CameraCtrl

public class LiveCategoryCtrl
{

    public static final LiveCategory a;
    private static final LiveCategory f[];
    private HashMap b;
    private LiveCategory c;
    private t d;
    private TextLoopView e;
    private a g;
    private h h;
    private b i;
    private d j;
    private j k;
    private x l;

    public LiveCategoryCtrl(View view)
    {
        c = null;
        d = null;
        if (LiveDemoConfigHelper.h().d())
        {
            view.setVisibility(4);
        }
        b = new HashMap();
        ArrayList arraylist = new ArrayList();
        Resources resources = Globals.d().getResources();
        LiveCategory alivecategory[] = f;
        int j1 = alivecategory.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            arraylist.add(resources.getString(alivecategory[i1].a()).toUpperCase(Locale.getDefault()));
        }

        e = (TextLoopView)view.findViewById(0x7f0c009e);
        e.setCategoryList(arraylist);
        view = Locale.getDefault().getLanguage();
        if (view.equals("zh") || view.equals("ja"))
        {
            e.setDisplayCount(4.9F);
        } else
        {
            e.setDisplayCount(4.2F);
        }
        e.a(3);
        e.setNormalColor(0xff000000);
        e.setHighlightColor(Color.parseColor("#F23B77"));
        e.setTextSize("360:12:default; 360:11:de,en; 360:10:fr; 360:9:ru,pt,ms,es");
        e.setTypeface(Typeface.SANS_SERIF);
        e.setOnIndexChangeListener(new am() {

            final LiveCategoryCtrl a;

            public void a(int k1, boolean flag)
            {
                LiveCategory livecategory = com.cyberlink.youcammakeup.camera.LiveCategoryCtrl.b()[k1];
                a.a(livecategory);
                YMKLiveCamEvent.c(livecategory.toString());
                if (flag)
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKLiveCamEvent(true, 0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent.Operation.d, true, false));
                } else
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKLiveCamEvent(true, 0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent.Operation.e, true, false));
                }
                YMKLiveCamEvent.c("None");
                YMKLiveCamEvent.a(true);
                if (com.cyberlink.youcammakeup.camera.LiveCategoryCtrl.a(a) != null)
                {
                    com.cyberlink.youcammakeup.camera.LiveCategoryCtrl.a(a).a(livecategory);
                }
            }

            
            {
                a = LiveCategoryCtrl.this;
                super();
            }
        });
    }

    static t a(LiveCategoryCtrl livecategoryctrl)
    {
        return livecategoryctrl.d;
    }

    static LiveCategory[] b()
    {
        return f;
    }

    public Fragment a(LiveCategory livecategory, CameraCtrl cameractrl)
    {
        class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[LiveCategory.values().length];
                try
                {
                    a[LiveCategory.f.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[LiveCategory.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[com.cyberlink.youcammakeup.camera.LiveCategory.b.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[com.cyberlink.youcammakeup.camera.LiveCategory.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[LiveCategory.e.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.cyberlink.youcammakeup.camera.LiveCategory.a.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.cyberlink.youcammakeup.camera._cls2.a[livecategory.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            if (g == null)
            {
                livecategory = new a(cameractrl);
                g = livecategory;
                return livecategory;
            } else
            {
                return g;
            }

        case 2: // '\002'
            if (h == null)
            {
                livecategory = new h(cameractrl);
                h = livecategory;
                return livecategory;
            } else
            {
                return h;
            }

        case 3: // '\003'
            if (i == null)
            {
                livecategory = new b(cameractrl);
                i = livecategory;
                return livecategory;
            } else
            {
                return i;
            }

        case 4: // '\004'
            if (j == null)
            {
                livecategory = new d(cameractrl);
                j = livecategory;
                return livecategory;
            } else
            {
                return j;
            }

        case 5: // '\005'
            if (k == null)
            {
                livecategory = new j(cameractrl);
                k = livecategory;
                return livecategory;
            } else
            {
                return k;
            }

        case 6: // '\006'
            break;
        }
        if (l == null)
        {
            livecategory = new x(cameractrl);
            l = livecategory;
            return livecategory;
        } else
        {
            return l;
        }
    }

    public void a()
    {
        if (l != null)
        {
            l.e();
        }
    }

    public void a(LiveCategory livecategory)
    {
        c = livecategory;
        z.a(livecategory);
    }

    public void a(t t)
    {
        d = t;
    }

    static 
    {
        a = com.cyberlink.youcammakeup.camera.LiveCategory.a;
        f = (new LiveCategory[] {
            LiveCategory.c, com.cyberlink.youcammakeup.camera.LiveCategory.d, com.cyberlink.youcammakeup.camera.LiveCategory.b, com.cyberlink.youcammakeup.camera.LiveCategory.a, LiveCategory.e, LiveCategory.f
        });
    }

    private class LiveCategory extends Enum
    {

        public static final LiveCategory a;
        public static final LiveCategory b;
        public static final LiveCategory c;
        public static final LiveCategory d;
        public static final LiveCategory e;
        public static final LiveCategory f;
        private static final LiveCategory g[];

        public static LiveCategory valueOf(String s)
        {
            return (LiveCategory)Enum.valueOf(com/cyberlink/youcammakeup/camera/LiveCategoryCtrl$LiveCategory, s);
        }

        public static LiveCategory[] values()
        {
            return (LiveCategory[])g.clone();
        }

        public abstract int a();

        static 
        {
            a = new LiveCategory("LOOKS", 0) {

                public int a()
                {
                    return 0x7f070502;
                }

                public String toString()
                {
                    return "LOOKS";
                }

            };
            b = new LiveCategory("EYE_LINER", 1) {

                public int a()
                {
                    return 0x7f07033b;
                }

                public String toString()
                {
                    return "EYE_LINER";
                }

            };
            c = new LiveCategory("EYELASHES", 2) {

                public int a()
                {
                    return 0x7f07033a;
                }

                public String toString()
                {
                    return "EYELASHES";
                }

            };
            d = new LiveCategory("EYE_SHADOW", 3) {

                public int a()
                {
                    return 0x7f07033c;
                }

                public String toString()
                {
                    return "EYE_SHADOW";
                }

            };
            e = new LiveCategory("LIP_COLOR", 4) {

                public int a()
                {
                    return 0x7f070345;
                }

                public String toString()
                {
                    return "LIP_COLOR";
                }

            };
            f = new LiveCategory("BLUSH", 5) {

                public int a()
                {
                    return 0x7f070332;
                }

                public String toString()
                {
                    return "BLUSH";
                }

            };
            g = (new LiveCategory[] {
                a, b, c, d, e, f
            });
        }

        private LiveCategory(String s, int i1)
        {
            super(s, i1);
        }

    }

}
