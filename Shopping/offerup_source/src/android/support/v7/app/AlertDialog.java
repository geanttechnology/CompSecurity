// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;

// Referenced classes of package android.support.v7.app:
//            AppCompatDialog, AlertController

public class AlertDialog extends AppCompatDialog
    implements DialogInterface
{

    private AlertController mAlert;

    AlertDialog(Context context, int i, boolean flag)
    {
        super(context, resolveDialogTheme(context, i));
        mAlert = new AlertController(getContext(), this, getWindow());
    }

    static int resolveDialogTheme(Context context, int i)
    {
        if (i >= 0x1000000)
        {
            return i;
        } else
        {
            TypedValue typedvalue = new TypedValue();
            context.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.alertDialogTheme, typedvalue, true);
            return typedvalue.resourceId;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mAlert.installContent();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (mAlert.onKeyDown(i, keyevent))
        {
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (mAlert.onKeyUp(i, keyevent))
        {
            return true;
        } else
        {
            return super.onKeyUp(i, keyevent);
        }
    }

    public void setTitle(CharSequence charsequence)
    {
        super.setTitle(charsequence);
        mAlert.setTitle(charsequence);
    }

}
