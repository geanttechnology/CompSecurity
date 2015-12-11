// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.view.View;
import com.groupon.models.error.GrouponException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            GrouponDialogFragment

public class DialogManager
{

    private Context context;

    public DialogManager()
    {
    }

    protected String buildErrorMessage(GrouponException grouponexception)
    {
        if (grouponexception == null)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        for (grouponexception = grouponexception.mapErrorFieldToErrorList.entrySet().iterator(); grouponexception.hasNext();)
        {
            Object obj = (java.util.Map.Entry)grouponexception.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = ((Collection)((java.util.Map.Entry) (obj)).getValue()).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                String s1 = (String)((Iterator) (obj)).next();
                stringbuilder.append(String.format("\n\u2022 %s: %s", new Object[] {
                    Strings.capitalize(s), Strings.capitalize(s1)
                }));
            }
        }

        return stringbuilder.toString();
    }

    public GrouponDialogFragment getDialogFragment(Object obj)
    {
        return getDialogFragment(null, obj);
    }

    public GrouponDialogFragment getDialogFragment(Object obj, Object obj1)
    {
        return getDialogFragment(obj, obj1, Integer.valueOf(0x7f080139));
    }

    public GrouponDialogFragment getDialogFragment(Object obj, Object obj1, View view, Object obj2, Object obj3, boolean flag, boolean flag1)
    {
        if (!(context instanceof Activity))
        {
            Ln.d("DialogManager#getDialogFragment: No Activity Context found. Please use an Activity Context if you want to show a DialogFragment.", new Object[0]);
            return null;
        }
        if (((Activity)context).isFinishing())
        {
            return null;
        }
        Object obj4;
        Bundle bundle;
        try
        {
            obj4 = getStringFrom(obj1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        obj1 = obj4;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        obj1 = Html.fromHtml(((String) (obj4)));
        obj1 = new SpannableString(((CharSequence) (obj1)));
        obj4 = new GrouponDialogFragment();
        bundle = new Bundle();
        bundle.putString("dialog_title", getStringFrom(obj));
        bundle.putString("dialog_message", ((SpannableString) (obj1)).toString());
        bundle.putString("dialog_positive_button_text", getStringFrom(obj2));
        bundle.putString("dialog_negative_button_text", getStringFrom(obj3));
        ((GrouponDialogFragment) (obj4)).setArguments(bundle);
        ((GrouponDialogFragment) (obj4)).setCustomView(view);
        ((GrouponDialogFragment) (obj4)).setCancelable(flag);
        return ((GrouponDialogFragment) (obj4));
    }

    public GrouponDialogFragment getDialogFragment(Object obj, Object obj1, Object obj2)
    {
        return getDialogFragment(obj, obj1, obj2, true);
    }

    public GrouponDialogFragment getDialogFragment(Object obj, Object obj1, Object obj2, Object obj3, boolean flag)
    {
        return getDialogFragment(obj, obj1, obj2, obj3, flag, false);
    }

    public GrouponDialogFragment getDialogFragment(Object obj, Object obj1, Object obj2, Object obj3, boolean flag, boolean flag1)
    {
        return getDialogFragment(obj, obj1, null, obj2, obj3, flag, flag1);
    }

    public GrouponDialogFragment getDialogFragment(Object obj, Object obj1, Object obj2, boolean flag)
    {
        return getDialogFragment(obj, obj1, obj2, null, flag);
    }

    public GrouponDialogFragment getDialogFragmentGrouponException(GrouponException grouponexception)
    {
        String s = grouponexception.getMessage();
        String s2 = buildErrorMessage(grouponexception);
        String s1 = s2;
        grouponexception = s;
        if (Strings.isEmpty(s2))
        {
            grouponexception = "";
            s1 = s;
        }
        return getDialogFragment(grouponexception, s1, Integer.valueOf(0x7f080139));
    }

    public GrouponDialogFragment getMessagesDialogFragment(String as[])
    {
        String s = "";
        if (as.length != 1) goto _L2; else goto _L1
_L1:
        String s1 = as[0];
_L4:
        return getDialogFragment(s1);
_L2:
        int j = as.length;
        int i = 0;
        do
        {
            s1 = s;
            if (i >= j)
            {
                continue;
            }
            s1 = as[i];
            s = (new StringBuilder()).append(s).append(String.format("\n\u2022 %s", new Object[] {
                s1
            })).toString();
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected String getStringFrom(Object obj)
    {
        Activity activity = (Activity)context;
        if (obj instanceof Integer)
        {
            return activity.getString(((Integer)obj).intValue());
        } else
        {
            return Strings.toString(obj);
        }
    }

    public void showAlertDialog(GrouponException grouponexception, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        String s2 = buildErrorMessage(grouponexception);
        String s = grouponexception.getMessage();
        String s1 = s2;
        grouponexception = s;
        if (Strings.isEmpty(s2))
        {
            grouponexception = "";
            s1 = s;
        }
        showAlertDialog(grouponexception.trim(), s1.trim(), Integer.valueOf(0x7f080139), onclicklistener);
    }

    public void showAlertDialog(Object obj)
    {
        showAlertDialog(null, obj);
    }

    public void showAlertDialog(Object obj, Object obj1)
    {
        showAlertDialog(obj, obj1, Integer.valueOf(0x7f080139), new android.content.DialogInterface.OnClickListener() {

            final DialogManager this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = DialogManager.this;
                super();
            }
        });
    }

    public void showAlertDialog(Object obj, Object obj1, View view, Object obj2, android.content.DialogInterface.OnClickListener onclicklistener, Object obj3, android.content.DialogInterface.OnClickListener onclicklistener1, 
            boolean flag, boolean flag1)
    {
        if ((context instanceof Activity) && ((Activity)context).isFinishing())
        {
            return;
        }
        String s = getStringFrom(obj);
        obj = getStringFrom(obj1);
        if (flag1)
        {
            obj = Html.fromHtml(((String) (obj)));
        }
        obj1 = getStringFrom(obj2);
        obj2 = getStringFrom(obj3);
        obj3 = new GrouponAlertDialog.Builder(context);
        if (Strings.notEmpty(s))
        {
            ((GrouponAlertDialog.Builder) (obj3)).setTitle(s);
        }
        if (Strings.notEmpty(obj))
        {
            ((GrouponAlertDialog.Builder) (obj3)).setMessage(((CharSequence) (obj)));
        }
        if (view != null)
        {
            ((GrouponAlertDialog.Builder) (obj3)).setView(view);
        }
        if (Strings.notEmpty(obj1))
        {
            ((GrouponAlertDialog.Builder) (obj3)).setPositiveButton(((CharSequence) (obj1)), onclicklistener);
        }
        if (Strings.notEmpty(obj2))
        {
            ((GrouponAlertDialog.Builder) (obj3)).setNegativeButton(((CharSequence) (obj2)), onclicklistener1);
        }
        ((GrouponAlertDialog.Builder) (obj3)).setCancelable(flag);
        try
        {
            ((GrouponAlertDialog.Builder) (obj3)).show();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
    }

    public void showAlertDialog(Object obj, Object obj1, Object obj2, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        showAlertDialog(obj, obj1, obj2, onclicklistener, false);
    }

    public void showAlertDialog(Object obj, Object obj1, Object obj2, android.content.DialogInterface.OnClickListener onclicklistener, Object obj3, android.content.DialogInterface.OnClickListener onclicklistener1, boolean flag)
    {
        showAlertDialog(obj, obj1, obj2, onclicklistener, obj3, onclicklistener1, flag, false);
    }

    public void showAlertDialog(Object obj, Object obj1, Object obj2, android.content.DialogInterface.OnClickListener onclicklistener, Object obj3, android.content.DialogInterface.OnClickListener onclicklistener1, boolean flag, 
            boolean flag1)
    {
        showAlertDialog(obj, obj1, null, obj2, onclicklistener, obj3, onclicklistener1, flag, flag1);
    }

    public void showAlertDialog(Object obj, Object obj1, Object obj2, android.content.DialogInterface.OnClickListener onclicklistener, boolean flag)
    {
        showAlertDialog(obj, obj1, obj2, onclicklistener, null, null, flag);
    }
}
