// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Parcelable;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.EditViewActivityForIntent;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.pages.libraryview.ContentGridView;
import com.cyberlink.youcammakeup.pages.libraryview.LibraryViewActivity;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.al;
import com.cyberlink.youcammakeup.utility.q;
import com.cyberlink.youcammakeup.widgetpool.dialogs.x;
import com.tencent.mm.sdk.openapi.WXImageObject;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.e;
import com.tencent.mm.sdk.openapi.k;
import com.tencent.mm.sdk.openapi.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            ac, ab, Share, aa

public class ShareActionProvider extends ActionProvider
{

    public static final String a = Globals.d().getResources().getString(0x7f0707c7);
    public static int b = 150;
    private static boolean d = true;
    private List c;
    private List e;
    private final ac f = new ac(this);
    private final Context g;
    private List h;
    private String i[] = {
        "com.facebook.katana", "com.cyberlink.youcammakeup", "com.cyberlink.youperfect", "com.tencent.mm", "com.sina.weibo", "com.cyberlink.U", "com.cyberlink.U_beta", "com.whatsapp", "com.instagram.android", "jp.naver.line.android"
    };
    private String j[];

    public ShareActionProvider(Context context)
    {
        super(context);
        c = null;
        e = new ArrayList();
        g = context;
        k();
        a(g);
        a();
    }

    static List a(ShareActionProvider shareactionprovider)
    {
        return shareactionprovider.h;
    }

    public static void a(Activity activity, ArrayList arraylist, boolean flag)
    {
        activity = o.a(activity, a, true);
        activity.a(a);
        Object obj = ((Uri)arraylist.get(0)).getPath();
        WXImageObject wximageobject = new WXImageObject();
        arraylist = new WXMediaMessage(wximageobject);
        android.graphics.Bitmap bitmap = aa.a(((String) (obj)), b, b, 0x2a3000, false);
        wximageobject.setImagePath(((String) (obj)));
        if (bitmap != null)
        {
            arraylist.thumbData = aa.b(bitmap, true);
        }
        obj = new k();
        obj.a = (new StringBuilder()).append("img").append(System.currentTimeMillis()).toString();
        obj.b = arraylist;
        if (flag)
        {
            obj.c = 1;
        } else
        {
            obj.c = 0;
        }
        activity.a(((com.tencent.mm.sdk.openapi.a) (obj)));
    }

    private void a(Context context)
    {
        e.add(ShareActionType.h);
        e.add(ShareActionType.a);
        if (al.a("com.whatsapp"))
        {
            e.add(ShareActionType.i);
        }
        if (al.a("com.instagram.android"))
        {
            e.add(ShareActionType.j);
        }
        if (al.a("com.tencent.mm"))
        {
            e.add(com.cyberlink.youcammakeup.kernelctrl.ShareActionType.e);
            e.add(ShareActionType.f);
        }
        if (al.a("jp.naver.line.android"))
        {
            e.add(com.cyberlink.youcammakeup.kernelctrl.ShareActionType.k);
        }
        e.add(ShareActionType.d);
        if (al.a("com.sina.weibo"))
        {
            e.add(ShareActionType.g);
        }
        if ((Activity)context instanceof EditViewActivityForIntent)
        {
            return;
        } else
        {
            e.add(ShareActionType.c);
            return;
        }
    }

    static void a(ShareActionProvider shareactionprovider, Exception exception)
    {
        shareactionprovider.a(exception);
    }

    private void a(Exception exception)
    {
        String s;
        if (exception.getMessage().equals(Share.ErrorMessage.b.name()))
        {
            s = g.getString(0x7f07005e);
        } else
        if (exception.getMessage().equals(Share.ErrorMessage.c.name()))
        {
            s = g.getString(0x7f070039);
        } else
        {
            s = "something wrong";
        }
        Globals.d().i().a(g, x.a, s, false);
        exception.printStackTrace();
    }

    static Context b(ShareActionProvider shareactionprovider)
    {
        return shareactionprovider.g;
    }

    public static ActivityInfo d()
    {
        return al.a(Globals.d().getPackageManager(), "com.cyberlink.youperfect", "com.cyberlink.action.EDIT", "android.intent.category.DEFAULT");
    }

    public static ActivityInfo e()
    {
        return al.a(Globals.d().getPackageManager(), "com.cyberlink.youperfect", "com.cyberlink.action.COLLAGE", "android.intent.category.DEFAULT");
    }

    public static ActivityInfo f()
    {
        return al.a(Globals.d().getPackageManager(), "com.tencent.mm", "android.intent.action.SEND", "android.intent.category.DEFAULT", "image/*");
    }

    public static ActivityInfo g()
    {
        return al.a(Globals.d().getPackageManager(), "com.sina.weibo", "android.intent.action.SEND", "android.intent.category.DEFAULT", "image/*");
    }

    public static ActivityInfo h()
    {
        return al.a(Globals.d().getPackageManager(), "com.whatsapp", "android.intent.action.SEND", "android.intent.category.DEFAULT", "image/*");
    }

    public static ActivityInfo i()
    {
        return al.a(Globals.d().getPackageManager(), "com.instagram.android", "android.intent.action.SEND", "android.intent.category.DEFAULT", "image/*");
    }

    public static ActivityInfo j()
    {
        return al.a(Globals.d().getPackageManager(), "jp.naver.line.android", "android.intent.action.SEND", "android.intent.category.DEFAULT", "image/*");
    }

    private void k()
    {
        j = i;
    }

    public int a(ResolveInfo resolveinfo)
    {
        boolean flag1 = false;
        if (c != null && c.size() != 0) goto _L2; else goto _L1
_L1:
        int l = -1;
_L4:
        return l;
_L2:
        String s;
        Iterator iterator;
        s = resolveinfo.activityInfo.packageName.toLowerCase(Locale.US);
        resolveinfo = resolveinfo.activityInfo.name.toLowerCase(Locale.US);
        iterator = c.iterator();
        l = 0;
_L5:
        boolean flag;
        flag = flag1;
        if (!iterator.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        Object obj = (ab)iterator.next();
        String s1 = ab.a(((ab) (obj))).toLowerCase(Locale.US);
        obj = ab.b(((ab) (obj))).toLowerCase(Locale.US);
        if (!s1.equals(s) || !((String) (obj)).equals(resolveinfo))
        {
            break MISSING_BLOCK_LABEL_147;
        }
        flag = true;
        if (flag) goto _L4; else goto _L3
_L3:
        return -1;
        l++;
          goto _L5
    }

    public List a(String s, int l, String as[])
    {
        Object obj = new Intent();
        ((Intent) (obj)).setType(s);
        Iterator iterator1;
        String s1;
        int i1;
        if (l > 1)
        {
            ((Intent) (obj)).setAction("android.intent.action.SEND_MULTIPLE");
        } else
        {
            ((Intent) (obj)).setAction("android.intent.action.SEND");
        }
        s = g.getPackageManager().queryIntentActivities(((Intent) (obj)), 0x10000);
        Collections.sort(s, new android.content.pm.ResolveInfo.DisplayNameComparator(g.getPackageManager()));
        if (s.isEmpty() || !d) goto _L2; else goto _L1
_L1:
        obj = new ArrayList();
        iterator1 = s.iterator();
_L6:
        s = ((String) (obj));
        if (!iterator1.hasNext()) goto _L2; else goto _L3
_L3:
        s = (ResolveInfo)iterator1.next();
        s1 = ((ResolveInfo) (s)).activityInfo.packageName.toLowerCase(Locale.US);
        i1 = as.length;
        l = 0;
_L7:
        if (l >= i1)
        {
            break MISSING_BLOCK_LABEL_349;
        }
        if (!s1.equals(as[l].toLowerCase(Locale.US))) goto _L5; else goto _L4
_L4:
        l = 1;
_L8:
        if (l == 0)
        {
            ((List) (obj)).add(s);
        }
          goto _L6
_L5:
        l++;
          goto _L7
_L2:
        if (c != null && c.size() > 0)
        {
            as = new HashMap();
            Iterator iterator = s.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ResolveInfo resolveinfo1 = (ResolveInfo)iterator.next();
                l = a(resolveinfo1);
                if (l != -1)
                {
                    as.put(String.valueOf(l), resolveinfo1);
                }
            } while (true);
            for (l = c.size() - 1; l >= 0; l--)
            {
                ResolveInfo resolveinfo = (ResolveInfo)as.get(String.valueOf(l));
                if (resolveinfo != null)
                {
                    s.remove(resolveinfo);
                    s.add(0, resolveinfo);
                }
            }

        }
        return s;
        l = 0;
          goto _L8
    }

    public void a()
    {
        c = new ArrayList();
        c.addAll(Arrays.asList(new ab[] {
            new ab(this, "com.whatsapp", "com.whatsapp.contactpicker"), new ab(this, "com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI"), new ab(this, "jp.naver.line.android", "jp.naver.line.android.activity.selectchat.SelectChatActivity")
        }));
    }

    public void a(ActivityInfo activityinfo, ArrayList arraylist)
    {
        a(activityinfo.packageName, activityinfo.name, "image/*", arraylist);
    }

    public void a(String s, String s1, String s2, ArrayList arraylist)
    {
        Intent intent;
        for (int l = 0; l < arraylist.size(); l++) { }
        intent = new Intent();
        intent.setType(s2);
        intent.setClassName(s, s1);
        if (arraylist.size() <= 1) goto _L2; else goto _L1
_L1:
        intent.setAction("android.intent.action.SEND_MULTIPLE");
        intent.putExtra("android.intent.extra.STREAM", arraylist);
_L4:
        ((Activity)g).startActivity(intent);
        return;
_L2:
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", (Parcelable)arraylist.get(0));
        if (s.equalsIgnoreCase("com.twitter.android"))
        {
            intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(Globals.b).append(g.getResources().getString(0x7f07067b)).toString());
        } else
        if (s.equalsIgnoreCase("com.sina.weibo"))
        {
            intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(Globals.b).append(g.getResources().getString(0x7f07067a)).toString());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void b(ResolveInfo resolveinfo)
    {
        Object obj = resolveinfo.activityInfo.packageName;
        String s = resolveinfo.activityInfo.name;
        resolveinfo = Globals.d().i();
        if (StatusManager.j().o().equals("libraryView"))
        {
            ContentGridView contentgridview = ((LibraryViewActivity)g).a();
            long al1[] = contentgridview.getCheckedImageIds();
            contentgridview.a();
            resolveinfo.a(g, g.getResources().getString(0x7f0703bf), g.getResources().getString(0x7f0703b9));
            obj = new Share(g, new com.cyberlink.youcammakeup.kernelctrl.aa(resolveinfo, ((String) (obj)), s) {

                final com.cyberlink.youcammakeup.utility.o a;
                final String b;
                final String c;
                final ShareActionProvider d;

                public void a()
                {
                    a.g(ShareActionProvider.b(d));
                }

                public void a(int i1)
                {
                    a.a(i1);
                }

                public void a(Exception exception)
                {
                    ShareActionProvider.a(d, exception);
                }

                public void a(ArrayList arraylist)
                {
                    a.g(ShareActionProvider.b(d));
                    d.a(b, c, "image/*", arraylist);
                }

            
            {
                d = ShareActionProvider.this;
                a = o1;
                b = s;
                c = s1;
                super();
            }
            });
            resolveinfo.a(new q(((Share) (obj))) {

                final Share a;
                final ShareActionProvider b;

                public void a()
                {
                    a.a();
                }

            
            {
                b = ShareActionProvider.this;
                a = share;
                super();
            }
            });
            ((Share) (obj)).a(al1, false);
        } else
        if (StatusManager.j().o().equals("editView"))
        {
            long l = StatusManager.j().l();
            resolveinfo.b(g);
            (new Share(g, new com.cyberlink.youcammakeup.kernelctrl.aa(resolveinfo, ((String) (obj)), s) {

                final com.cyberlink.youcammakeup.utility.o a;
                final String b;
                final String c;
                final ShareActionProvider d;

                public void a()
                {
                }

                public void a(int i1)
                {
                }

                public void a(Exception exception)
                {
                    ShareActionProvider.a(d, exception);
                }

                public void a(ArrayList arraylist)
                {
                    a.h(ShareActionProvider.b(d));
                    d.a(b, c, "image/*", arraylist);
                }

            
            {
                d = ShareActionProvider.this;
                a = o1;
                b = s;
                c = s1;
                super();
            }
            })).a(new long[] {
                l
            }, false);
            return;
        }
    }

    public String[] b()
    {
        return j;
    }

    public List c()
    {
        return e;
    }

    public boolean hasSubMenu()
    {
        return true;
    }

    public View onCreateActionView()
    {
        return null;
    }

    public void onPrepareSubMenu(SubMenu submenu)
    {
        submenu.clear();
        int l = -1;
        if (g instanceof LibraryViewActivity)
        {
            l = ((LibraryViewActivity)g).a().getCheckedImageIds().length;
        } else
        if (g instanceof EditViewActivity)
        {
            l = 1;
        }
        if (l > 0)
        {
            h = a("image/*", l, j);
            PackageManager packagemanager = g.getPackageManager();
            l = 0;
            while (l < h.size()) 
            {
                ResolveInfo resolveinfo = (ResolveInfo)h.get(l);
                submenu.add(0, l, l, resolveinfo.loadLabel(packagemanager)).setIcon(resolveinfo.loadIcon(packagemanager)).setOnMenuItemClickListener(f);
                l++;
            }
        }
    }


    private class ShareActionType extends Enum
    {

        public static final ShareActionType a;
        public static final ShareActionType b;
        public static final ShareActionType c;
        public static final ShareActionType d;
        public static final ShareActionType e;
        public static final ShareActionType f;
        public static final ShareActionType g;
        public static final ShareActionType h;
        public static final ShareActionType i;
        public static final ShareActionType j;
        public static final ShareActionType k;
        private static final ShareActionType l[];

        public static ShareActionType valueOf(String s)
        {
            return (ShareActionType)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/ShareActionProvider$ShareActionType, s);
        }

        public static ShareActionType[] values()
        {
            return (ShareActionType[])l.clone();
        }

        static 
        {
            a = new ShareActionType("Facebook", 0);
            b = new ShareActionType("YouCamPerfectEdit", 1);
            c = new ShareActionType("YouCamPerfectCollage", 2);
            d = new ShareActionType("U", 3);
            e = new ShareActionType("WeChat", 4);
            f = new ShareActionType("WeChatMoment", 5);
            g = new ShareActionType("Weibo", 6);
            h = new ShareActionType("BeautyCircle", 7);
            i = new ShareActionType("WhatsApp", 8);
            j = new ShareActionType("Instagram", 9);
            k = new ShareActionType("Line", 10);
            l = (new ShareActionType[] {
                a, b, c, d, e, f, g, h, i, j, 
                k
            });
        }

        private ShareActionType(String s, int i1)
        {
            super(s, i1);
        }
    }

}
