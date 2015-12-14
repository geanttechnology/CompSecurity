// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.firegnom.rat.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import com.socialin.android.activity.InfoDialogActivity;
import com.socialin.android.dialog.a;
import com.socialin.android.dialog.b;
import com.socialin.android.dialog.f;

public class DialogUtils
{

    private static final String PREFERENCES_NAME = "tips_dialog_shared_preferences";

    private DialogUtils()
    {
    }

    public static void dismissDialog(Activity activity, final Dialog dialog)
    {
        if (activity != null && !activity.isFinishing() && dialog != null && dialog.isShowing())
        {
            activity.runOnUiThread(new Runnable() {

                final Dialog val$dialog;

                public final void run()
                {
                    try
                    {
                        dialog.dismiss();
                        return;
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                }

            
            {
                dialog = dialog1;
                super();
            }
            });
        }
    }

    public static void dismissDialog(Activity activity, Dialog dialog, boolean flag)
    {
        if (flag)
        {
            dismissDialog(activity, dialog);
        } else
        if (activity != null && !activity.isFinishing() && dialog != null && dialog.isShowing())
        {
            try
            {
                dialog.dismiss();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                activity.printStackTrace();
            }
            return;
        }
    }

    public static void openInfoDialog(int i, String s, String s1, String s2, Activity activity, Integer integer)
    {
        Intent intent = new Intent(activity, com/socialin/android/activity/InfoDialogActivity);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("iconResourceId", i);
        intent.putExtra("title", s);
        intent.putExtra("desc", s1);
        intent.putExtra("message", s2);
        if (integer == null)
        {
            activity.startActivity(intent);
            return;
        } else
        {
            activity.startActivityForResult(intent, integer.intValue());
            return;
        }
    }

    public static void openInfoDialog(String s, String s1, String s2, String s3, Activity activity, Integer integer)
    {
        Intent intent = new Intent(activity, com/socialin/android/activity/InfoDialogActivity);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("iconUrl", s);
        intent.putExtra("title", s1);
        intent.putExtra("desc", s2);
        intent.putExtra("message", s3);
        if (integer == null)
        {
            activity.startActivity(intent);
            return;
        } else
        {
            activity.startActivityForResult(intent, integer.intValue());
            return;
        }
    }

    public static void showDialog(final Activity activity, final Dialog dialog)
    {
        if (activity != null && !activity.isFinishing() && dialog != null && !dialog.isShowing())
        {
            activity.runOnUiThread(new Runnable() {

                final Activity val$activity;
                final Dialog val$dialog;

                public final void run()
                {
                    try
                    {
                        if (activity != null && !activity.isFinishing())
                        {
                            dialog.show();
                        }
                        return;
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                }

            
            {
                activity = activity1;
                dialog = dialog1;
                super();
            }
            });
        }
    }

    public static void showDialog(Activity activity, Dialog dialog, boolean flag)
    {
        if (flag)
        {
            showDialog(activity, dialog);
        } else
        if (activity != null && !activity.isFinishing() && dialog != null && !dialog.isShowing())
        {
            try
            {
                dialog.show();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                activity.printStackTrace();
            }
            return;
        }
    }

    public static Dialog showNoLocationProviderDialog(final Activity activity, int i, int j, int k, int l, int i1)
    {
        Object obj = new f(activity);
        obj.b = activity.getString(j);
        obj.d = i1;
        obj.a = activity.getString(i);
        obj = ((f) (obj)).a(activity.getString(k), new android.view.View.OnClickListener() {

            final Activity val$activity;

            public final void onClick(View view)
            {
                activity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            }

            
            {
                activity = activity1;
                super();
            }
        }).b(activity.getString(l)).a();
        if (!activity.isFinishing() && !((Dialog) (obj)).isShowing())
        {
            ((Dialog) (obj)).show();
        }
        return ((Dialog) (obj));
    }

    public static Dialog showNoNetworkDialog(final Activity activity, int i, int j, int k, int l, int i1)
    {
        Object obj = new f(activity);
        obj.b = activity.getString(j);
        obj.d = i1;
        obj.a = activity.getString(i);
        obj = ((f) (obj)).a(activity.getString(k), new android.view.View.OnClickListener() {

            final Activity val$activity;

            public final void onClick(View view)
            {
                activity.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
            }

            
            {
                activity = activity1;
                super();
            }
        }).b(activity.getString(l)).a();
        if (!activity.isFinishing() && !((Dialog) (obj)).isShowing())
        {
            ((Dialog) (obj)).show();
        }
        return ((Dialog) (obj));
    }

    public static void showNoNetworkDialogFragment(final Activity activity, String s)
    {
        b b1 = new b();
        b1.a = activity.getString(0x7f080307);
        b1.b = activity.getString(0x7f080306);
        b1.a(activity.getString(0x7f080308), new android.view.View.OnClickListener() {

            final Activity val$activity;

            public final void onClick(View view)
            {
                activity.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
            }

            
            {
                activity = activity1;
                super();
            }
        }).b(activity.getString(0x7f0802a4)).a().show(activity.getFragmentManager(), s);
    }

    public static boolean showTipDialog(int i, String s, String s1, String s2, Activity activity, Integer integer, String s3)
    {
        boolean flag = false;
        boolean flag1 = activity.getSharedPreferences("tips_dialog_shared_preferences", 0).getBoolean((new StringBuilder("dialog")).append(s3).toString(), false);
        if (!flag1)
        {
            Intent intent = new Intent();
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setClassName(activity.getPackageName(), "com.socialin.android.activity.TipsDialogActivity");
            intent.putExtra("iconResourceId", i);
            intent.putExtra("title", s);
            intent.putExtra("desc", s1);
            intent.putExtra("message", s2);
            intent.putExtra("dialogid", s3);
            if (integer == null)
            {
                activity.startActivity(intent);
            } else
            {
                activity.startActivityForResult(intent, integer.intValue());
            }
        }
        if (!flag1)
        {
            flag = true;
        }
        return flag;
    }
}
