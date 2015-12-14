// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkContest;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.model.network.r;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.u;
import java.io.File;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            AccountManager

public class DialogUtils
{

    public static void a(Activity activity)
    {
        if (activity == null || activity.isFinishing())
        {
            return;
        } else
        {
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            dialog.setContentView(k.bc_promotion_youcam_makeup_dialog);
            Object obj = dialog.getWindow();
            ((Window) (obj)).setBackgroundDrawableResource(0x106000d);
            obj = ((Window) (obj)).getAttributes();
            DisplayMetrics displaymetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            obj.width = (int)((double)displaymetrics.widthPixels * 0.94999999999999996D);
            obj.height = (int)((double)displaymetrics.heightPixels * 0.94999999999999996D);
            dialog.getWindow().setAttributes(((android.view.WindowManager.LayoutParams) (obj)));
            dialog.show();
            activity = dialog.findViewById(j.bc_download_youcam_makeup);
            dialog.findViewById(j.bc_nextTimeButton).setOnClickListener(new android.view.View.OnClickListener(dialog) {

                final Dialog a;

                public void onClick(View view)
                {
                    a.dismiss();
                }

            
            {
                a = dialog;
                super();
            }
            });
            activity.setSelected(true);
            activity.setOnClickListener(new android.view.View.OnClickListener(dialog) {

                final Dialog a;

                public void onClick(View view)
                {
                    a.dismiss();
                    com.perfectcorp.utility.g.a(Globals.d, Globals.n().getPackageName(), "BeautyCircle", "download");
                }

            
            {
                a = dialog;
                super();
            }
            });
            return;
        }
    }

    public static void a(Activity activity, int i)
    {
        if (activity == null)
        {
            e.e(new Object[] {
                "activity is null"
            });
            return;
        } else
        {
            a(activity, activity.getString(m.bc_dialog_title_warning), activity.getString(i), ((Runnable) (null)));
            return;
        }
    }

    public static void a(Activity activity, int i, int l, Runnable runnable)
    {
        if (activity == null)
        {
            e.e(new Object[] {
                "activity is null"
            });
            return;
        } else
        {
            a(activity, activity.getString(i), activity.getString(l), runnable);
            return;
        }
    }

    public static void a(Activity activity, int i, int l, String s)
    {
        a(activity, ((Fragment) (null)), i, l, s, null);
    }

    public static void a(Activity activity, Dialog dialog)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int i = (int)((float)displaymetrics.widthPixels * 0.8611111F);
        dialog.getWindow().getAttributes().width = i;
    }

    public static void a(Activity activity, Fragment fragment, int i)
    {
        if (activity == null)
        {
            return;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        if (fragment != null)
        {
            fragment.startActivityForResult(intent, i);
            return;
        } else
        {
            activity.startActivityForResult(intent, i);
            return;
        }
    }

    public static void a(Activity activity, Fragment fragment, int i, int l, String s, Runnable runnable)
    {
        if (activity == null || activity.isFinishing())
        {
            return;
        } else
        {
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            dialog.setContentView(k.bc_dialog_pick_opt);
            dialog.findViewById(j.itemPhotoLibrary).setOnClickListener(new android.view.View.OnClickListener(activity, fragment, i, dialog) {

                final Activity a;
                final Fragment b;
                final int c;
                final Dialog d;

                public void onClick(View view)
                {
                    DialogUtils.a(a, b, c);
                    d.setOnDismissListener(null);
                    d.dismiss();
                }

            
            {
                a = activity;
                b = fragment;
                c = i;
                d = dialog;
                super();
            }
            });
            dialog.findViewById(j.itemTakePhoto).setOnClickListener(new android.view.View.OnClickListener(activity, fragment, l, s, dialog) {

                final Activity a;
                final Fragment b;
                final int c;
                final String d;
                final Dialog e;

                public void onClick(View view)
                {
                    DialogUtils.a(a, b, c, d);
                    e.setOnDismissListener(null);
                    e.dismiss();
                }

            
            {
                a = activity;
                b = fragment;
                c = i;
                d = s;
                e = dialog;
                super();
            }
            });
            dialog.setOnDismissListener(new android.content.DialogInterface.OnDismissListener(runnable) {

                final Runnable a;

                public void onDismiss(DialogInterface dialoginterface)
                {
                    if (a != null)
                    {
                        a.run();
                    }
                }

            
            {
                a = runnable;
                super();
            }
            });
            a(activity, dialog);
            dialog.show();
            return;
        }
    }

    static void a(Activity activity, Fragment fragment, int i, String s)
    {
        b(activity, fragment, i, s);
    }

    public static void a(Activity activity, Runnable runnable)
    {
        if (activity == null || activity.isFinishing())
        {
            return;
        } else
        {
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            dialog.setContentView(k.bc_dialog_remind_log_in);
            dialog.findViewById(j.bc_remind_login_btn).setOnClickListener(new android.view.View.OnClickListener(activity, dialog) {

                final Activity a;
                final Dialog b;

                public void onClick(View view)
                {
                    if (AccountManager.b() == null)
                    {
                        c.a(a, 2, 0, 0);
                    }
                    b.setOnDismissListener(null);
                    b.dismiss();
                }

            
            {
                a = activity;
                b = dialog;
                super();
            }
            });
            DisplayMetrics displaymetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            dialog.getWindow().getAttributes().width = displaymetrics.widthPixels;
            dialog.getWindow().setBackgroundDrawableResource(g.bc_color_transparent);
            dialog.setOnDismissListener(new android.content.DialogInterface.OnDismissListener(runnable) {

                final Runnable a;

                public void onDismiss(DialogInterface dialoginterface)
                {
                    if (a != null)
                    {
                        a.run();
                    }
                }

            
            {
                a = runnable;
                super();
            }
            });
            dialog.show();
            return;
        }
    }

    public static void a(Activity activity, String s)
    {
        if (activity == null)
        {
            e.e(new Object[] {
                "activity is null"
            });
            return;
        } else
        {
            a(activity, activity.getString(m.bc_dialog_title_warning), s, ((Runnable) (null)));
            return;
        }
    }

    public static void a(Activity activity, String s, String s1, long l, ReportSource reportsource, Runnable runnable)
    {
        String s2 = activity.getResources().getString(m.bc_post_comment_report_sex);
        String s3 = activity.getResources().getString(m.bc_post_comment_report_coprright);
        String s4 = activity.getResources().getString(m.bc_post_comment_report_other);
        if (activity == null || activity.isFinishing())
        {
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
            builder.setTitle(m.bc_post_comment_report_title);
            builder.setNegativeButton(m.bc_dialog_button_cancel, new android.content.DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialoginterface, int i)
                {
                }

            });
            s = new android.content.DialogInterface.OnClickListener(reportsource, s, l, s1, activity, runnable) {

                final ReportSource a;
                final String b;
                final long c;
                final String d;
                final Activity e;
                final Runnable f;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    i;
                    JVM INSTR tableswitch 0 2: default 28
                //                               0 70
                //                               1 94
                //                               2 118;
                       goto _L1 _L2 _L3 _L4
_L1:
                    DialogUtils.a(e, "", e.getResources().getString(m.bc_post_comment_report_confirm), null, null, e.getResources().getString(m.bc_dialog_button_ok), f);
                    return;
_L2:
                    if (a == ReportSource.b)
                    {
                        r.a(b, c, "Inappropriate");
                    } else
                    if (a == com.cyberlink.beautycircle.utility.ReportSource.c)
                    {
                        NetworkPost.a(b, d, c, "Inappropriate");
                        NetworkContest.d(Long.valueOf(c));
                    } else
                    {
                        NetworkPost.a(b, d, c, "Inappropriate");
                    }
_L3:
                    if (a == ReportSource.b)
                    {
                        r.a(b, c, "Copyright");
                    } else
                    if (a == com.cyberlink.beautycircle.utility.ReportSource.c)
                    {
                        NetworkPost.a(b, d, c, "Copyright");
                        NetworkContest.d(Long.valueOf(c));
                    } else
                    {
                        NetworkPost.a(b, d, c, "Copyright");
                    }
_L4:
                    if (a == ReportSource.b)
                    {
                        r.a(b, c, "Other");
                    } else
                    if (a == com.cyberlink.beautycircle.utility.ReportSource.c)
                    {
                        NetworkPost.a(b, d, c, "Other");
                        NetworkContest.d(Long.valueOf(c));
                    } else
                    {
                        NetworkPost.a(b, d, c, "Other");
                    }
                    if (true) goto _L1; else goto _L5
_L5:
                }

            
            {
                a = reportsource;
                b = s;
                c = l;
                d = s1;
                e = activity;
                f = runnable;
                super();
            }

                private class ReportSource extends Enum
                {

                    public static final ReportSource a;
                    public static final ReportSource b;
                    public static final ReportSource c;
                    private static final ReportSource d[];

                    public static ReportSource valueOf(String s)
                    {
                        return (ReportSource)Enum.valueOf(com/cyberlink/beautycircle/utility/DialogUtils$ReportSource, s);
                    }

                    public static ReportSource[] values()
                    {
                        return (ReportSource[])d.clone();
                    }

                    static 
                    {
                        a = new ReportSource("POST", 0);
                        b = new ReportSource("PRODUCT", 1);
                        c = new ReportSource("CONTEST_POST", 2);
                        d = (new ReportSource[] {
                            a, b, c
                        });
                    }

                    private ReportSource(String s, int i)
                    {
                        super(s, i);
                    }
                }

            };
            builder.setItems(new String[] {
                s2, s3, s4
            }, s);
            Globals.a(builder.show(), activity.getResources().getColor(g.bc_color_main_style));
            return;
        }
    }

    public static void a(Activity activity, String s, String s1, Runnable runnable)
    {
        if (activity == null)
        {
            e.e(new Object[] {
                "activity is null"
            });
            return;
        } else
        {
            a(activity, s, s1, null, null, activity.getString(m.bc_dialog_button_ok), runnable, true, null);
            return;
        }
    }

    public static void a(Activity activity, String s, String s1, String s2, Runnable runnable, String s3, Runnable runnable1)
    {
        a(activity, s, s1, s2, runnable, s3, runnable1, true, null);
    }

    public static void a(Activity activity, String s, String s1, String s2, Runnable runnable, String s3, Runnable runnable1, boolean flag, 
            android.content.DialogInterface.OnDismissListener ondismisslistener)
    {
        b(activity, s, s1, s2, runnable, s3, runnable1, flag, ondismisslistener);
    }

    public static void a(View view, int i, boolean flag, android.view.View.OnClickListener onclicklistener)
    {
        if (view != null)
        {
            Object obj = (TextView)view.findViewById(j.error_message_text);
            if (i != 0 && obj != null)
            {
                ((TextView) (obj)).setText(i);
            }
            obj = view.findViewById(j.error_icon);
            if (obj != null)
            {
                if (flag)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                ((View) (obj)).setVisibility(i);
            }
            if (onclicklistener != null)
            {
                view.setOnClickListener(onclicklistener);
            }
        }
    }

    private static void b(Activity activity, Fragment fragment, int i, String s)
    {
        if (activity != null && s != null && !s.isEmpty()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Intent intent;
        intent = new Intent("android.media.action.IMAGE_CAPTURE");
        String s1 = activity.getResources().getString(m.bc_default_camera_app_package_name);
        if (s1 == null || s1.isEmpty())
        {
            continue; /* Loop/switch isn't completed */
        }
        Object obj = activity.getPackageManager().queryIntentActivities(intent, 0);
        if (((List) (obj)).isEmpty())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((List) (obj)).iterator();
        ResolveInfo resolveinfo;
        String s2;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            resolveinfo = (ResolveInfo)((Iterator) (obj)).next();
            s2 = resolveinfo.activityInfo.packageName;
        } while (s2 == null || !s2.contains(s1));
        intent.setClassName(resolveinfo.activityInfo.packageName, resolveinfo.activityInfo.name);
        if (intent.resolveActivity(activity.getPackageManager()) == null || s == null) goto _L1; else goto _L3
_L3:
        intent.putExtra("output", Uri.fromFile(new File(s)));
        if (fragment != null)
        {
            fragment.startActivityForResult(intent, i);
            return;
        } else
        {
            activity.startActivityForResult(intent, i);
            return;
        }
    }

    private static void b(Activity activity, String s, String s1, String s2, Runnable runnable, String s3, Runnable runnable1, boolean flag, 
            android.content.DialogInterface.OnDismissListener ondismisslistener)
    {
        if (activity == null)
        {
            e.e(new Object[] {
                "activity is null"
            });
            return;
        } else
        {
            activity.runOnUiThread(new Runnable(activity, s1, s2, runnable, s3, runnable1, flag, ondismisslistener) {

                final Activity a;
                final String b;
                final String c;
                final Runnable d;
                final String e;
                final Runnable f;
                final boolean g;
                final android.content.DialogInterface.OnDismissListener h;

                public void run()
                {
                    if (a.isFinishing())
                    {
                        return;
                    }
                    Dialog dialog = new Dialog(a);
                    dialog.requestWindowFeature(1);
                    dialog.setContentView(k.bc_dialog_prototype);
                    ((TextView)dialog.findViewById(j.bc_dialog_desc)).setText(Html.fromHtml(u.d(b)));
                    Object obj = (TextView)dialog.findViewById(j.bc_dialog_negative);
                    if (obj != null)
                    {
                        ((TextView) (obj)).setVisibility(8);
                        if (c != null)
                        {
                            ((TextView) (obj)).setText(c);
                            ((TextView) (obj)).setVisibility(0);
                            ((TextView) (obj)).setOnClickListener(new android.view.View.OnClickListener(this, dialog) {

                                final Dialog a;
                                final _cls1 b;

                                public void onClick(View view)
                                {
                                    if (b.d != null)
                                    {
                                        b.d.run();
                                    }
                                    a.dismiss();
                                }

            
            {
                b = _pcls1;
                a = dialog;
                super();
            }
                            });
                        }
                    }
                    obj = (TextView)dialog.findViewById(j.bc_dialog_positive);
                    if (obj != null)
                    {
                        ((TextView) (obj)).setVisibility(8);
                        if (e != null)
                        {
                            ((TextView) (obj)).setText(e);
                            ((TextView) (obj)).setVisibility(0);
                            ((TextView) (obj)).setOnClickListener(new android.view.View.OnClickListener(this, dialog) {

                                final Dialog a;
                                final _cls1 b;

                                public void onClick(View view)
                                {
                                    if (b.f != null)
                                    {
                                        b.f.run();
                                    }
                                    a.dismiss();
                                }

            
            {
                b = _pcls1;
                a = dialog;
                super();
            }
                            });
                        }
                    }
                    obj = new DisplayMetrics();
                    a.getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
                    dialog.getWindow().getAttributes().width = ((DisplayMetrics) (obj)).widthPixels;
                    dialog.getWindow().setBackgroundDrawableResource(g.bc_color_transparent);
                    dialog.setCanceledOnTouchOutside(g);
                    dialog.setCancelable(g);
                    dialog.setOnDismissListener(h);
                    dialog.show();
                }

            
            {
                a = activity;
                b = s;
                c = s1;
                d = runnable;
                e = s2;
                f = runnable1;
                g = flag;
                h = ondismisslistener;
                super();
            }
            });
            return;
        }
    }
}
