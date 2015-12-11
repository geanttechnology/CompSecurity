// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view.util;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.shell.app.ActivityShim;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class DialogManager extends ActivityShim
    implements android.content.DialogInterface.OnCancelListener
{
    public static final class AlertDialogBuilder extends android.support.v7.app.AlertDialog.Builder
    {

        private final Context context;

        public android.support.v7.app.AlertDialog.Builder setSingleChoiceItems(CharSequence acharsequence[], int i, android.content.DialogInterface.OnClickListener onclicklistener)
        {
            return super.setSingleChoiceItems(new ArrayAdapter(context, 0x7f0301f2, 0x1020014, acharsequence), i, onclicklistener);
        }

        public AlertDialogBuilder(Context context1)
        {
            super(context1);
            context = context1;
        }
    }

    public static interface DynamicDialogBuilder
        extends Parcelable
    {

        public abstract Dialog create(DialogManager dialogmanager, Activity activity);
    }

    private static class DynamicTextAlertDialogBuilder
        implements DynamicDialogBuilder
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public DynamicTextAlertDialogBuilder createFromParcel(Parcel parcel)
            {
                return new DynamicTextAlertDialogBuilder(parcel.readString(), parcel.readString(), DialogManager.closeListener);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public DynamicTextAlertDialogBuilder[] newArray(int i)
            {
                return new DynamicTextAlertDialogBuilder[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        private final android.content.DialogInterface.OnCancelListener cancelListener;
        private final android.content.DialogInterface.OnClickListener clickListener;
        private final String message;
        private final String title;

        public Dialog create(DialogManager dialogmanager, Activity activity)
        {
            android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(activity);
            if (message != null && message.contains("</"))
            {
                activity = (WebView)Util.setFilterTouchesWhenObscured(new WebView(activity));
                activity.loadDataWithBaseURL(null, message, "text/html", "utf-8", "about:blank");
                builder.setView(activity);
            } else
            {
                builder.setMessage(message);
            }
            builder.setNegativeButton(0x104000a, clickListener);
            if (cancelListener != null)
            {
                activity = cancelListener;
            } else
            {
                activity = dialogmanager;
            }
            setOnCancelListener(dialogmanager, activity, builder);
            if (!TextUtils.isEmpty(title))
            {
                builder.setTitle(title);
            }
            return builder.create();
        }

        public int describeContents()
        {
            return 0;
        }

        protected void setOnCancelListener(DialogManager dialogmanager, android.content.DialogInterface.OnCancelListener oncancellistener, android.support.v7.app.AlertDialog.Builder builder)
        {
            builder.setOnCancelListener(oncancellistener);
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(title);
            parcel.writeString(message);
        }


        public DynamicTextAlertDialogBuilder(String s, String s1, android.content.DialogInterface.OnClickListener onclicklistener)
        {
            title = s;
            message = s1;
            clickListener = onclicklistener;
            cancelListener = null;
        }

        public DynamicTextAlertDialogBuilder(String s, String s1, android.content.DialogInterface.OnClickListener onclicklistener, android.content.DialogInterface.OnCancelListener oncancellistener)
        {
            title = s;
            message = s1;
            clickListener = onclicklistener;
            cancelListener = oncancellistener;
        }
    }

    private static final class DynamicTextAlertDialogBuilderCloseActivityOnCancel extends DynamicTextAlertDialogBuilder
        implements android.content.DialogInterface.OnCancelListener
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public DynamicTextAlertDialogBuilderCloseActivityOnCancel createFromParcel(Parcel parcel)
            {
                return new DynamicTextAlertDialogBuilderCloseActivityOnCancel(parcel.readString(), parcel.readString());
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public DynamicTextAlertDialogBuilderCloseActivityOnCancel[] newArray(int i)
            {
                return new DynamicTextAlertDialogBuilderCloseActivityOnCancel[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        private WeakReference activity;
        private WeakReference dialogManager;

        public Dialog create(DialogManager dialogmanager, Activity activity1)
        {
            activity = new WeakReference(activity1);
            return super.create(dialogmanager, activity1);
        }

        public void onCancel(DialogInterface dialoginterface)
        {
            if (dialogManager != null)
            {
                DialogManager dialogmanager = (DialogManager)dialogManager.get();
                if (dialogmanager != null)
                {
                    dialogmanager.removeDynamicDialog(dialoginterface);
                }
            }
            dialoginterface.dismiss();
            if (activity != null)
            {
                dialoginterface = (Activity)activity.get();
                if (dialoginterface != null)
                {
                    dialoginterface.finish();
                }
            }
        }

        protected void setOnCancelListener(DialogManager dialogmanager, android.content.DialogInterface.OnCancelListener oncancellistener, android.support.v7.app.AlertDialog.Builder builder)
        {
            dialogManager = new WeakReference(dialogmanager);
            builder.setOnCancelListener(this);
        }


        public DynamicTextAlertDialogBuilderCloseActivityOnCancel(String s, String s1)
        {
            super(s, s1, DialogManager.closeListener);
            activity = null;
            dialogManager = null;
        }
    }


    private static final String EXTRA_DIALOGS = "dynamic_dialog_interfaces";
    public static final android.content.DialogInterface.OnClickListener closeListener = new android.content.DialogInterface.OnClickListener() {

        public void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
        }

    };
    private HashMap dialogs;

    public DialogManager()
    {
        dialogs = null;
    }

    private static final Dialog createAlert(Context context, int i)
    {
        return (new android.support.v7.app.AlertDialog.Builder(context)).setMessage(i).setNegativeButton(0x104000a, closeListener).create();
    }

    private static final Dialog createAlert(Context context, int i, int j)
    {
        return (new android.support.v7.app.AlertDialog.Builder(context)).setMessage(j).setTitle(i).setNegativeButton(0x104000a, closeListener).create();
    }

    private static final Dialog createAlert(Context context, String s)
    {
        return (new android.support.v7.app.AlertDialog.Builder(context)).setMessage(s).setNegativeButton(0x104000a, closeListener).create();
    }

    public static final Dialog createAlertDialog(Context context, int i)
    {
        int j = -1;
        i;
        JVM INSTR tableswitch 2131165489 2131165490: default 24
    //                   2131165489 35
    //                   2131165490 35;
           goto _L1 _L2 _L2
_L1:
        if (j == -1)
        {
            return createAlert(context, i);
        } else
        {
            return createAlert(context, j, i);
        }
_L2:
        j = 0x7f070133;
          goto _L1
    }

    public static final Dialog createAlertDialog(Context context, int i, int j)
    {
        return createAlert(context, i, j);
    }

    public static final Dialog createAlertDialog(Context context, String s)
    {
        return createAlert(context, s);
    }

    public static Dialog createAlertDialog(Context context, String s, String s1, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        return (new android.support.v7.app.AlertDialog.Builder(context)).setMessage(s1).setTitle(s).setNegativeButton(0x104000a, onclicklistener).create();
    }

    private static final Dialog createProgress(Context context, int i, int j, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        return createProgress(context, ((CharSequence) (context.getString(i))), ((CharSequence) (context.getString(j))), oncancellistener);
    }

    private static final Dialog createProgress(Context context, int i, int j, boolean flag)
    {
        return createProgress(context, ((CharSequence) (context.getString(i))), ((CharSequence) (context.getString(j))), flag);
    }

    private static final Dialog createProgress(Context context, int i, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        return createProgress(context, "", ((CharSequence) (context.getString(i))), oncancellistener);
    }

    private static final Dialog createProgress(Context context, int i, boolean flag)
    {
        return createProgress(context, "", ((CharSequence) (context.getString(i))), flag);
    }

    private static final Dialog createProgress(Context context, CharSequence charsequence, CharSequence charsequence1, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        return createProgress(context, charsequence, charsequence1, true, oncancellistener);
    }

    private static final Dialog createProgress(Context context, CharSequence charsequence, CharSequence charsequence1, boolean flag)
    {
        return createProgress(context, charsequence, charsequence1, flag, null);
    }

    private static final Dialog createProgress(Context context, CharSequence charsequence, CharSequence charsequence1, boolean flag, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        context = new ProgressDialog(context);
        context.setTitle(charsequence);
        context.setMessage(charsequence1);
        context.setIndeterminate(true);
        context.setCancelable(flag);
        context.setOnCancelListener(oncancellistener);
        return context;
    }

    public static final Dialog createProgressDialog(Context context, int i)
    {
        return createProgressDialog(context, i, false, null);
    }

    public static final Dialog createProgressDialog(Context context, int i, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        return createProgressDialog(context, i, true, oncancellistener);
    }

    public static final Dialog createProgressDialog(Context context, int i, boolean flag)
    {
        return createProgressDialog(context, i, flag, null);
    }

    private static final Dialog createProgressDialog(Context context, int i, boolean flag, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        if (flag && oncancellistener != null)
        {
            if (-1 == -1)
            {
                return createProgress(context, i, oncancellistener);
            } else
            {
                return createProgress(context, -1, i, oncancellistener);
            }
        }
        if (-1 == -1)
        {
            return createProgress(context, i, flag);
        } else
        {
            return createProgress(context, -1, i, flag);
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        removeDynamicDialog(dialoginterface);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        Object obj = dialogs;
        if (obj != null && !((HashMap) (obj)).isEmpty())
        {
            for (obj = ((HashMap) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); ((DialogInterface)((java.util.Map.Entry)((Iterator) (obj)).next()).getKey()).dismiss()) { }
        }
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        bundle = bundle.getParcelableArrayList("dynamic_dialog_interfaces");
        if (bundle != null)
        {
            for (bundle = bundle.iterator(); bundle.hasNext(); showDynamicDialog((DynamicDialogBuilder)bundle.next())) { }
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        Object obj = dialogs;
        if (obj != null && !((HashMap) (obj)).isEmpty())
        {
            ArrayList arraylist = new ArrayList(((HashMap) (obj)).size());
            for (obj = ((HashMap) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(((java.util.Map.Entry)((Iterator) (obj)).next()).getValue())) { }
            bundle.putParcelableArrayList("dynamic_dialog_interfaces", arraylist);
        }
    }

    public final void removeDynamicDialog(DialogInterface dialoginterface)
    {
        HashMap hashmap = dialogs;
        if (hashmap != null)
        {
            hashmap.remove(dialoginterface);
        }
    }

    public final void showDynamicAlertDialog(String s, String s1, android.content.DialogInterface.OnClickListener onclicklistener, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        showDynamicDialog(new DynamicTextAlertDialogBuilder(s, s1, onclicklistener, oncancellistener));
    }

    public final void showDynamicAlertDialog(String s, String s1, boolean flag)
    {
        if (flag)
        {
            s = new DynamicTextAlertDialogBuilderCloseActivityOnCancel(s, s1);
        } else
        {
            s = new DynamicTextAlertDialogBuilder(s, s1, closeListener);
        }
        showDynamicDialog(s);
    }

    public final void showDynamicDialog(DynamicDialogBuilder dynamicdialogbuilder)
    {
        HashMap hashmap1 = dialogs;
        HashMap hashmap = hashmap1;
        if (hashmap1 == null)
        {
            hashmap = new HashMap();
            dialogs = hashmap;
        }
        if (getActivity().isFinishing())
        {
            return;
        } else
        {
            Dialog dialog = dynamicdialogbuilder.create(this, getActivity());
            dialog.setOwnerActivity(getActivity());
            dialog.show();
            hashmap.put(dialog, dynamicdialogbuilder);
            return;
        }
    }

}
