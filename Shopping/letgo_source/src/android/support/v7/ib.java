// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageButton;

public class ib
    implements TextWatcher
{

    private final ImageButton a;

    public ib(ImageButton imagebutton)
    {
        a = imagebutton;
    }

    public void afterTextChanged(Editable editable)
    {
        byte byte0;
        boolean flag;
        if (editable == null)
        {
            editable = null;
        } else
        {
            editable = editable.toString();
        }
        if (editable == null)
        {
            flag = true;
        } else
        {
            flag = editable.isEmpty();
        }
        if (flag)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        if (a != null)
        {
            a.setVisibility(byte0);
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
