// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

// Referenced classes of package android.support.v7.app:
//            AppCompatDialog, AlertController

public class AlertDialog extends AppCompatDialog
    implements DialogInterface
{

    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    private AlertController mAlert;

    protected AlertDialog(Context context)
    {
        this(context, resolveDialogTheme(context, 0), true);
    }

    protected AlertDialog(Context context, int i)
    {
        this(context, i, true);
    }

    AlertDialog(Context context, int i, boolean flag)
    {
        super(context, resolveDialogTheme(context, i));
        mAlert = new AlertController(getContext(), this, getWindow());
    }

    protected AlertDialog(Context context, boolean flag, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        super(context, resolveDialogTheme(context, 0));
        setCancelable(flag);
        setOnCancelListener(oncancellistener);
        mAlert = new AlertController(context, this, getWindow());
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

    public Button getButton(int i)
    {
        return mAlert.getButton(i);
    }

    public ListView getListView()
    {
        return mAlert.getListView();
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

    public void setButton(int i, CharSequence charsequence, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        mAlert.setButton(i, charsequence, onclicklistener, null);
    }

    public void setButton(int i, CharSequence charsequence, Message message)
    {
        mAlert.setButton(i, charsequence, null, message);
    }

    void setButtonPanelLayoutHint(int i)
    {
        mAlert.setButtonPanelLayoutHint(i);
    }

    public void setCustomTitle(View view)
    {
        mAlert.setCustomTitle(view);
    }

    public void setIcon(int i)
    {
        mAlert.setIcon(i);
    }

    public void setIcon(Drawable drawable)
    {
        mAlert.setIcon(drawable);
    }

    public void setIconAttribute(int i)
    {
        TypedValue typedvalue = new TypedValue();
        getContext().getTheme().resolveAttribute(i, typedvalue, true);
        mAlert.setIcon(typedvalue.resourceId);
    }

    public void setMessage(CharSequence charsequence)
    {
        mAlert.setMessage(charsequence);
    }

    public void setTitle(CharSequence charsequence)
    {
        super.setTitle(charsequence);
        mAlert.setTitle(charsequence);
    }

    public void setView(View view)
    {
        mAlert.setView(view);
    }

    public void setView(View view, int i, int j, int k, int l)
    {
        mAlert.setView(view, i, j, k, l);
    }

}
