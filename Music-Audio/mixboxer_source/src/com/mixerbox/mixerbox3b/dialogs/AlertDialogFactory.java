// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Resources;

public class AlertDialogFactory
{

    public AlertDialogFactory()
    {
    }

    public static AlertDialog AskPostAlertDialog(final Activity activity)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setTitle(activity.getResources().getString(0x7f0800bd));
        builder.setCancelable(false);
        builder.setMessage(activity.getResources().getString(0x7f0800be)).setCancelable(true).setPositiveButton(0x7f08007e, new _cls9()).setNegativeButton(0x7f080063, new _cls8());
        return builder.create();
    }

    public static AlertDialog AskRateAlertDialog(final Activity activity)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setTitle(activity.getResources().getString(0x7f0800de)).setMessage(activity.getResources().getString(0x7f0800df)).setCancelable(true).setPositiveButton(0x7f08007e, new _cls7()).setNegativeButton(0x7f080063, new _cls6());
        return builder.create();
    }

    public static AlertDialog AskUpdateAlertDialog(final Activity activity)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setMessage(activity.getResources().getString(0x7f0800a8)).setCancelable(true).setPositiveButton(0x7f08007e, new _cls4()).setNegativeButton(0x7f080063, new _cls3());
        return builder.create();
    }

    public static AlertDialog DeviceWarningAlertDialog(final Activity activity)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setTitle(activity.getResources().getString(0x7f0800f7));
        builder.setMessage(activity.getResources().getString(0x7f0800f8)).setCancelable(true).setPositiveButton(activity.getResources().getString(0x7f0800f9), new _cls12()).setNegativeButton(activity.getResources().getString(0x7f0800fa), new _cls11()).setNeutralButton(activity.getResources().getString(0x7f080063), new _cls10());
        return builder.create();
    }

    public static AlertDialog ForceUpdateAlertDialog(final Activity activity)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setMessage(activity.getResources().getString(0x7f0800a7)).setCancelable(true).setPositiveButton(0x7f08007e, new _cls5());
        return builder.create();
    }

    public static AlertDialog NoNetworkAlertDialog(final Activity activity)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setMessage(0x7f080057).setCancelable(true).setPositiveButton(0x7f080063, new _cls2()).setNegativeButton(0x7f080092, new _cls1());
        return builder.create();
    }

    public static AlertDialog TipFirstDiscoverAlertDialog(Activity activity)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setTitle(activity.getResources().getString(0x7f0800c2));
        builder.setMessage(activity.getResources().getString(0x7f0800c3)).setCancelable(true).setPositiveButton(0x7f08007e, new _cls16());
        return builder.create();
    }

    public static AlertDialog TipFirstPlayAlertDialog(final Activity activity)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setTitle(activity.getResources().getString(0x7f0800c4));
        builder.setMessage(activity.getResources().getString(0x7f0800c5)).setCancelable(true).setPositiveButton(0x7f08007e, new _cls14());
        return builder.create();
    }

    public static AlertDialog TipFirstPlayHDAlertDialog(final Activity activity)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setTitle(activity.getResources().getString(0x7f0800eb));
        builder.setMessage(activity.getResources().getString(0x7f0800ec)).setCancelable(true).setPositiveButton(0x7f08007e, new _cls17());
        return builder.create();
    }

    public static AlertDialog TipFirstPlaylistAlertDialog(Activity activity)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setTitle(activity.getResources().getString(0x7f0800c6));
        builder.setMessage(activity.getResources().getString(0x7f0800c7)).setCancelable(true).setPositiveButton(0x7f08007e, new _cls15());
        return builder.create();
    }

    public static AlertDialog TipFirstReorderAlertDialog(Activity activity)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setTitle(activity.getResources().getString(0x7f080101));
        builder.setMessage(activity.getResources().getString(0x7f080102)).setCancelable(true).setPositiveButton(0x7f08007e, new _cls18());
        return builder.create();
    }

    public static AlertDialog TipFirstSearchAlertDialog(final Activity activity)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setTitle(activity.getResources().getString(0x7f0800c8));
        builder.setMessage(activity.getResources().getString(0x7f0800c9)).setCancelable(true).setPositiveButton(0x7f08007e, new _cls13());
        return builder.create();
    }

    public static AlertDialog WarningAlertDialog(Activity activity, String s, String s1)
    {
        activity = new android.app.AlertDialog.Builder(activity);
        activity.setCancelable(true).setNegativeButton(0x7f08007e, new _cls19());
        if (s1 != null && s1 != "")
        {
            activity.setMessage(s1);
        }
        if (s != null && s1 != "")
        {
            activity.setTitle(s);
        }
        return activity.create();
    }

    private class _cls9
        implements android.content.DialogInterface.OnClickListener
    {

        final Activity val$activity;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
            ((MainPage)activity).handleAnnounce();
            dialoginterface = new HashMap();
            dialoginterface.put("allow", "1");
            FlurryAgent.logEvent("action:allow_publish_permission", dialoginterface);
        }

        _cls9()
        {
            activity = activity1;
            super();
        }
    }


    private class _cls8
        implements android.content.DialogInterface.OnClickListener
    {

        final Activity val$activity;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
            if (((MainPage)activity).fragmentSettings.isAdded())
            {
                ((MainPage)activity).fragmentSettings.checkbox.setChecked(false);
            }
            dialoginterface = new HashMap();
            dialoginterface.put("allow", "0");
            FlurryAgent.logEvent("action:allow_publish_permission", dialoginterface);
        }

        _cls8()
        {
            activity = activity1;
            super();
        }
    }


    private class _cls7
        implements android.content.DialogInterface.OnClickListener
    {

        final Activity val$activity;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            MixerBoxSharedPreferences.putHasRated(activity, true);
            dialoginterface.cancel();
            dialoginterface = MixerBoxSharedPreferences.getPackageName(activity);
            try
            {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(dialoginterface).toString())));
                return;
            }
            catch (ActivityNotFoundException activitynotfoundexception)
            {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://play.google.com/store/apps/details?id=").append(dialoginterface).toString())));
            }
        }

        _cls7()
        {
            activity = activity1;
            super();
        }
    }


    private class _cls6
        implements android.content.DialogInterface.OnClickListener
    {

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
        }

        _cls6()
        {
        }
    }


    private class _cls4
        implements android.content.DialogInterface.OnClickListener
    {

        final Activity val$activity;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
            dialoginterface = MixerBoxSharedPreferences.getPackageName(activity);
            try
            {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(dialoginterface).toString())));
            }
            catch (ActivityNotFoundException activitynotfoundexception)
            {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://play.google.com/store/apps/details?id=").append(dialoginterface).toString())));
            }
            activity.finish();
        }

        _cls4()
        {
            activity = activity1;
            super();
        }
    }


    private class _cls3
        implements android.content.DialogInterface.OnClickListener
    {

        final Activity val$activity;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
            ((MixerBox)activity).cancelUpdate();
        }

        _cls3()
        {
            activity = activity1;
            super();
        }
    }


    private class _cls12
        implements android.content.DialogInterface.OnClickListener
    {

        final Activity val$activity;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
            ((MainPage)activity).dialogDevice = null;
            activity.startActivity(new Intent("android.settings.DEVICE_INFO_SETTINGS"));
        }

        _cls12()
        {
            activity = activity1;
            super();
        }
    }


    private class _cls11
        implements android.content.DialogInterface.OnClickListener
    {

        final Activity val$activity;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
            ((MainPage)activity).dialogDevice = null;
            MixerBoxSharedPreferences.putShouldAskSystemUpdate(activity, false);
        }

        _cls11()
        {
            activity = activity1;
            super();
        }
    }


    private class _cls10
        implements android.content.DialogInterface.OnClickListener
    {

        final Activity val$activity;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
            ((MainPage)activity).dialogDevice = null;
        }

        _cls10()
        {
            activity = activity1;
            super();
        }
    }


    private class _cls5
        implements android.content.DialogInterface.OnClickListener
    {

        final Activity val$activity;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
            dialoginterface = MixerBoxSharedPreferences.getPackageName(activity);
            try
            {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(dialoginterface).toString())));
            }
            catch (ActivityNotFoundException activitynotfoundexception)
            {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://play.google.com/store/apps/details?id=").append(dialoginterface).toString())));
            }
            activity.finish();
        }

        _cls5()
        {
            activity = activity1;
            super();
        }
    }


    private class _cls2
        implements android.content.DialogInterface.OnClickListener
    {

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
        }

        _cls2()
        {
        }
    }


    private class _cls1
        implements android.content.DialogInterface.OnClickListener
    {

        final Activity val$activity;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
            activity.startActivity(new Intent("android.settings.SETTINGS"));
        }

        _cls1()
        {
            activity = activity1;
            super();
        }
    }


    private class _cls16
        implements android.content.DialogInterface.OnClickListener
    {

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
        }

        _cls16()
        {
        }
    }


    private class _cls14
        implements android.content.DialogInterface.OnClickListener
    {

        final Activity val$activity;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
            ((MainPage)activity).showPopupMenu();
        }

        _cls14()
        {
            activity = activity1;
            super();
        }
    }


    private class _cls17
        implements android.content.DialogInterface.OnClickListener
    {

        final Activity val$activity;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
            ((MainPage)activity).showPopupMenu();
        }

        _cls17()
        {
            activity = activity1;
            super();
        }
    }


    private class _cls15
        implements android.content.DialogInterface.OnClickListener
    {

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
        }

        _cls15()
        {
        }
    }


    private class _cls18
        implements android.content.DialogInterface.OnClickListener
    {

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
        }

        _cls18()
        {
        }
    }


    private class _cls13
        implements android.content.DialogInterface.OnClickListener
    {

        final Activity val$activity;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            MixerBoxSharedPreferences.putTipFirstSearch(activity, true);
            dialoginterface.cancel();
        }

        _cls13()
        {
            activity = activity1;
            super();
        }
    }


    private class _cls19
        implements android.content.DialogInterface.OnClickListener
    {

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
        }

        _cls19()
        {
        }
    }

}
