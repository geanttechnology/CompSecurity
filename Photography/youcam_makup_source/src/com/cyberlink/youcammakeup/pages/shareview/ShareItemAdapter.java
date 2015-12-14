// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.shareview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivityForIntent;
import com.cyberlink.youcammakeup.activity.FacebookSharingActivity;
import com.cyberlink.youcammakeup.activity.FacebookSharingActivityForIntent;
import com.cyberlink.youcammakeup.activity.WeiboSharingActivity;
import com.cyberlink.youcammakeup.clflurry.YMKAfterSavePhotoEvent;
import com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent;
import com.cyberlink.youcammakeup.clflurry.YMKShareToEvent;
import com.cyberlink.youcammakeup.clflurry.YMKShareToEventOld;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.flurry.ShareItemSelectionEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider;
import com.cyberlink.youcammakeup.utility.aj;
import com.cyberlink.youcammakeup.utility.ak;
import com.cyberlink.youcammakeup.utility.al;
import com.cyberlink.youcammakeup.utility.bd;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.pages.shareview:
//            ShareItemView

public class ShareItemAdapter extends BaseAdapter
{

    public static final UUID a = UUID.randomUUID();
    private List b;
    private ShareActionProvider c;
    private Context d;
    private PackageManager e;
    private boolean f;
    private final int g;

    public ShareItemAdapter(Context context)
    {
        g = (int)((((double)Globals.d().getResources().getDisplayMetrics().widthPixels * 0.94444444444444442D) / 878D) * 7D);
        d = context;
        e = d.getPackageManager();
        c = new ShareActionProvider(context);
        f = (Activity)context instanceof EditViewActivityForIntent;
        b = c.a("image/*", 1, c.b());
    }

    public ResolveInfo a(int i)
    {
        return (ResolveInfo)b.get(i);
    }

    public void a(int i, ArrayList arraylist)
    {
        List list = c.c();
        if (list != null && i < list.size())
        {
            a((com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType)list.get(i), arraylist);
            return;
        }
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKAfterSavePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKAfterSavePhotoEvent.FeatureName.e));
        int j = i;
        if (list != null)
        {
            j = i - list.size();
        }
        a(((ResolveInfo)b.get(j)).activityInfo, arraylist);
    }

    public void a(ActivityInfo activityinfo, ArrayList arraylist)
    {
        String s = activityinfo.packageName.toLowerCase(Locale.getDefault());
        com.cyberlink.youcammakeup.flurry.a.a(new ShareItemSelectionEvent(s));
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKShareToEventOld(s));
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKShareToEvent(com.cyberlink.youcammakeup.clflurry.YMKShareToEvent.Operation.b, s));
        c.a(activityinfo, arraylist);
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType shareactiontype, ArrayList arraylist)
    {
        if (shareactiontype != com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.a) goto _L2; else goto _L1
_L1:
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKAfterSavePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKAfterSavePhotoEvent.FeatureName.e));
        com.cyberlink.youcammakeup.flurry.a.a(new ShareItemSelectionEvent("Fackbook"));
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKShareToEventOld("Fackbook"));
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKShareToEvent(com.cyberlink.youcammakeup.clflurry.YMKShareToEvent.Operation.b, "Fackbook"));
        Globals.d().a(arraylist);
        if (f)
        {
            shareactiontype = com/cyberlink/youcammakeup/activity/FacebookSharingActivityForIntent;
        } else
        {
            shareactiontype = com/cyberlink/youcammakeup/activity/FacebookSharingActivity;
        }
        shareactiontype = new Intent(d.getApplicationContext(), shareactiontype);
        d.startActivity(shareactiontype);
_L4:
        return;
_L2:
        if (shareactiontype == com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.b)
        {
            Object obj = ShareActionProvider.d();
            if (obj == null)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKResultPageEvent(com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent.Operation.f, YMKResultPageEvent.b, System.currentTimeMillis()));
                bd.a((Activity)d, "com.cyberlink.youperfect", "ymk", "sharepagedialog");
                return;
            } else
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKResultPageEvent(com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent.Operation.e, YMKResultPageEvent.b, System.currentTimeMillis()));
                shareactiontype = ((ActivityInfo) (obj)).packageName;
                obj = ((ActivityInfo) (obj)).name;
                c.a(shareactiontype, ((String) (obj)), "image/*", arraylist);
                return;
            }
        }
        if (shareactiontype == com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.c)
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKAfterSavePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKAfterSavePhotoEvent.FeatureName.c));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKShareToEvent(com.cyberlink.youcammakeup.clflurry.YMKShareToEvent.Operation.b, "YouCam Perfect Collage"));
            Object obj1 = ShareActionProvider.e();
            if (obj1 == null)
            {
                bd.a((Activity)d, "com.cyberlink.youperfect", "ymk", "sharepagedialog");
                return;
            } else
            {
                shareactiontype = ((ActivityInfo) (obj1)).packageName;
                obj1 = ((ActivityInfo) (obj1)).name;
                c.a(shareactiontype, ((String) (obj1)), "image/*", arraylist);
                return;
            }
        }
        if (shareactiontype == com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.d)
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKAfterSavePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKAfterSavePhotoEvent.FeatureName.a));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKShareToEventOld(com.cyberlink.youcammakeup.clflurry.YMKShareToEventOld.FeatureName.a.a()));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKShareToEvent(com.cyberlink.youcammakeup.clflurry.YMKShareToEvent.Operation.b, "U"));
            ActivityInfo activityinfo = al.a(d.getPackageManager(), "com.cyberlink.U", "android.intent.action.SEND", "android.intent.category.DEFAULT", "image/*");
            shareactiontype = activityinfo;
            if (activityinfo == null)
            {
                shareactiontype = al.a(d.getPackageManager(), "com.cyberlink.U_beta", "android.intent.action.SEND", "android.intent.category.DEFAULT", "image/*");
            }
            if (shareactiontype != null)
            {
                String s = ((ActivityInfo) (shareactiontype)).packageName;
                shareactiontype = ((ActivityInfo) (shareactiontype)).name;
                Intent intent = new Intent();
                intent.setClassName(s, shareactiontype);
                intent.setType("image/*");
                intent.setAction("android.intent.action.SEND");
                if (arraylist != null && arraylist.size() > 0)
                {
                    intent.putExtra("android.intent.extra.STREAM", (Parcelable)arraylist.get(0));
                }
                intent.putExtra("ProductName", "YouCamPerfect");
                ((Activity)d).startActivity(intent);
                return;
            } else
            {
                bd.a((Activity)d, "com.cyberlink.U", "ymk", "sharepagedialog");
                return;
            }
        }
        if (shareactiontype != com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.e)
        {
            break; /* Loop/switch isn't completed */
        }
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKAfterSavePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKAfterSavePhotoEvent.FeatureName.e));
        com.cyberlink.youcammakeup.flurry.a.a(new ShareItemSelectionEvent("WeChat"));
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKShareToEventOld("WeChat"));
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKShareToEvent(com.cyberlink.youcammakeup.clflurry.YMKShareToEvent.Operation.b, "WeChat"));
        if (arraylist.size() == 1)
        {
            shareactiontype = ((Uri)arraylist.get(0)).getPath();
            if (!(new File(shareactiontype)).exists())
            {
                arraylist = d.getString(0x7f070060);
                Toast.makeText(d, (new StringBuilder()).append(arraylist).append(" path = ").append(shareactiontype).toString(), 1).show();
                return;
            } else
            {
                ShareActionProvider.a((Activity)d, arraylist, false);
                return;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (shareactiontype != com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.f)
        {
            break; /* Loop/switch isn't completed */
        }
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKAfterSavePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKAfterSavePhotoEvent.FeatureName.e));
        com.cyberlink.youcammakeup.flurry.a.a(new ShareItemSelectionEvent("WeChatMoment"));
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKShareToEventOld("WeChatMoment"));
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKShareToEvent(com.cyberlink.youcammakeup.clflurry.YMKShareToEvent.Operation.b, "WeChatMoment"));
        if (arraylist.size() == 1)
        {
            shareactiontype = ((Uri)arraylist.get(0)).getPath();
            if (!(new File(shareactiontype)).exists())
            {
                arraylist = d.getString(0x7f070060);
                Toast.makeText(d, (new StringBuilder()).append(arraylist).append(" path = ").append(shareactiontype).toString(), 1).show();
                return;
            } else
            {
                ShareActionProvider.a((Activity)d, arraylist, true);
                return;
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (shareactiontype != com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.g)
        {
            break; /* Loop/switch isn't completed */
        }
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKAfterSavePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKAfterSavePhotoEvent.FeatureName.e));
        com.cyberlink.youcammakeup.flurry.a.a(new ShareItemSelectionEvent("Weibo"));
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKShareToEventOld("Weibo"));
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKShareToEvent(com.cyberlink.youcammakeup.clflurry.YMKShareToEvent.Operation.b, "Weibo"));
        if (arraylist.size() == 1)
        {
            shareactiontype = new Intent(d.getApplicationContext(), com/cyberlink/youcammakeup/activity/WeiboSharingActivity);
            Bundle bundle = new Bundle();
            bundle.putString("mimeType", "image/*");
            bundle.putString("url", ((Uri)arraylist.get(0)).getPath());
            shareactiontype.putExtras(bundle);
            d.startActivity(shareactiontype);
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
        if (shareactiontype == com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.h)
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKAfterSavePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKAfterSavePhotoEvent.FeatureName.d));
            com.cyberlink.youcammakeup.flurry.a.a(new ShareItemSelectionEvent(com.cyberlink.youcammakeup.clflurry.YMKAfterSavePhotoEvent.FeatureName.d.toString()));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKShareToEventOld(com.cyberlink.youcammakeup.clflurry.YMKAfterSavePhotoEvent.FeatureName.d.toString()));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKShareToEvent(com.cyberlink.youcammakeup.clflurry.YMKShareToEvent.Operation.b, "Beauty Circle"));
            com.cyberlink.beautycircle.a.a(d, ((Uri)arraylist.get(0)).toString(), null);
            return;
        }
        if (shareactiontype == com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.i)
        {
            shareactiontype = ShareActionProvider.h();
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKShareToEvent(com.cyberlink.youcammakeup.clflurry.YMKShareToEvent.Operation.b, "WhatsApp"));
            c.a(shareactiontype, arraylist);
            return;
        }
        if (shareactiontype == com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.j)
        {
            shareactiontype = ShareActionProvider.i();
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKShareToEvent(com.cyberlink.youcammakeup.clflurry.YMKShareToEvent.Operation.b, "Instagram"));
            c.a(shareactiontype, arraylist);
            return;
        }
        if (shareactiontype == com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.k)
        {
            shareactiontype = ShareActionProvider.j();
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKShareToEvent(com.cyberlink.youcammakeup.clflurry.YMKShareToEvent.Operation.b, "Line"));
            c.a(shareactiontype, arraylist);
            return;
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    public int getCount()
    {
        int j = b.size();
        List list = c.c();
        int i = j;
        if (list != null)
        {
            i = j + list.size();
        }
        return i;
    }

    public Object getItem(int i)
    {
        return a(i);
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj2 = null;
        Object obj6 = null;
        View view1 = null;
        Object obj7 = null;
        Object obj = null;
        Object obj8 = null;
        Object obj9 = null;
        Object obj10 = null;
        Object obj11 = null;
        Object obj1 = null;
        viewgroup = c.c();
        DividerStyle dividerstyle = com.cyberlink.youcammakeup.pages.shareview.DividerStyle.a;
        if (viewgroup != null && i < viewgroup.size())
        {
            viewgroup = (com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType)viewgroup.get(i);
            int j;
            if (viewgroup == com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.a)
            {
                obj1 = Globals.d().getResources().getDrawable(0x7f020747);
                obj = Globals.d().getText(0x7f070671);
            } else
            if (viewgroup == com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.b)
            {
                obj1 = Globals.d().getResources().getDrawable(0x7f020283);
                obj = Globals.d().getText(0x7f0706a6);
            } else
            if (viewgroup == com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.c)
            {
                obj1 = Globals.d().getResources().getDrawable(0x7f020282);
                obj = Globals.d().getText(0x7f0706a3);
            } else
            if (viewgroup == com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.d)
            {
                obj = al.a(d.getPackageManager(), "com.cyberlink.U", "android.intent.action.SEND", "android.intent.category.DEFAULT", "image/*");
                if (obj != null)
                {
                    obj = ((ActivityInfo) (obj)).loadIcon(e);
                } else
                {
                    obj = Globals.d().getResources().getDrawable(0x7f02075c);
                }
                obj2 = Globals.d().getText(0x7f070687);
                obj1 = obj;
                obj = obj2;
            } else
            if (viewgroup == com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.e)
            {
                obj2 = ShareActionProvider.f();
                if (obj2 != null)
                {
                    obj = ((ActivityInfo) (obj2)).loadIcon(e);
                    obj1 = Globals.d().getText(0x7f070697);
                }
                obj2 = obj;
                obj = obj1;
                obj1 = obj2;
            } else
            if (viewgroup == com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.f)
            {
                obj1 = Globals.d().getResources().getDrawable(0x7f02075d);
                obj = Globals.d().getText(0x7f070673);
            } else
            if (viewgroup == com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.g)
            {
                obj6 = ShareActionProvider.g();
                obj1 = obj8;
                obj = obj2;
                if (obj6 != null)
                {
                    obj = ((ActivityInfo) (obj6)).loadIcon(e);
                    obj1 = ((ActivityInfo) (obj6)).loadLabel(e);
                }
                obj2 = obj;
                obj = obj1;
                obj1 = obj2;
            } else
            if (viewgroup == com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.h)
            {
                obj1 = Globals.d().getResources().getDrawable(0x7f02075b);
                obj = Globals.d().getText(0x7f0703c9);
            } else
            if (viewgroup == com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.i)
            {
                Object obj3 = ShareActionProvider.h();
                obj1 = obj9;
                obj = obj6;
                if (obj3 != null)
                {
                    obj = ((ActivityInfo) (obj3)).loadIcon(e);
                    obj1 = ((ActivityInfo) (obj3)).loadLabel(e);
                }
                obj3 = obj;
                obj = obj1;
                obj1 = obj3;
            } else
            if (viewgroup == com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.j)
            {
                Object obj4 = ShareActionProvider.i();
                obj1 = obj10;
                obj = view1;
                if (obj4 != null)
                {
                    obj = ((ActivityInfo) (obj4)).loadIcon(e);
                    obj1 = ((ActivityInfo) (obj4)).loadLabel(e);
                }
                obj4 = obj;
                obj = obj1;
                obj1 = obj4;
            } else
            if (viewgroup == com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.k)
            {
                Object obj5 = ShareActionProvider.j();
                obj1 = obj11;
                obj = obj7;
                if (obj5 != null)
                {
                    obj = ((ActivityInfo) (obj5)).loadIcon(e);
                    obj1 = ((ActivityInfo) (obj5)).loadLabel(e);
                }
                obj5 = obj;
                obj = obj1;
                obj1 = obj5;
            } else
            {
                obj = null;
                obj1 = null;
            }
        } else
        {
            if (viewgroup != null)
            {
                j = i - viewgroup.size();
            } else
            {
                j = i;
            }
            viewgroup = a(j);
            obj1 = viewgroup.loadIcon(e);
            obj = viewgroup.loadLabel(e);
            viewgroup = null;
        }
        if (view == null)
        {
            view = new ShareItemView(d);
        }
        obj2 = (ImageView)view.findViewById(0x7f0c08db);
        obj6 = (TextView)view.findViewById(0x7f0c08dc);
        view1 = view.findViewById(0x7f0c08dd);
        if (viewgroup != null && viewgroup == com.cyberlink.youcammakeup.kernelctrl.ShareActionProvider.ShareActionType.b)
        {
            viewgroup = aj.a(((Activity)d).getWindowManager().getDefaultDisplay(), new ak[] {
                new ak(360F, 18F, new String[] {
                    "ru", "de"
                })
            });
            if (viewgroup != null)
            {
                ((TextView) (obj6)).setTextSize(0, Math.min(((TextView) (obj6)).getTextSize(), TypedValue.applyDimension(1, viewgroup.floatValue(), ((Activity)d).getResources().getDisplayMetrics())));
                ((TextView) (obj6)).setSingleLine(false);
                ((TextView) (obj6)).setMaxLines(2);
            }
        }
        ((ImageView) (obj2)).setImageDrawable(((android.graphics.drawable.Drawable) (obj1)));
        ((TextView) (obj6)).setText(((CharSequence) (obj)));
        if (i == getCount() - 1)
        {
            view1.setVisibility(8);
            return view;
        } else
        {
            view1.setVisibility(0);
            return view;
        }
    }


    private class DividerStyle extends Enum
    {

        public static final DividerStyle a;
        public static final DividerStyle b;
        private static final DividerStyle c[];

        public static DividerStyle valueOf(String s)
        {
            return (DividerStyle)Enum.valueOf(com/cyberlink/youcammakeup/pages/shareview/ShareItemAdapter$DividerStyle, s);
        }

        public static DividerStyle[] values()
        {
            return (DividerStyle[])c.clone();
        }

        static 
        {
            a = new DividerStyle("thin", 0);
            b = new DividerStyle("thick", 1);
            c = (new DividerStyle[] {
                a, b
            });
        }

        private DividerStyle(String s, int i)
        {
            super(s, i);
        }
    }

}
