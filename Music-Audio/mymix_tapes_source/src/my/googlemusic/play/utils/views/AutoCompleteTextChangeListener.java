// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.views;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import java.util.ArrayList;
import java.util.List;

public class AutoCompleteTextChangeListener
    implements TextWatcher
{
    public static interface OnTextChangeListener
    {

        public abstract void onTextChanged(List list);
    }


    private Context context;
    private OnTextChangeListener listener;
    private List suggestions;

    public AutoCompleteTextChangeListener(Context context1, List list, OnTextChangeListener ontextchangelistener)
    {
        context = context1;
        listener = ontextchangelistener;
        suggestions = list;
    }

    private String getConstraint(String s)
    {
        if (!s.contains("@"))
        {
            return s;
        } else
        {
            return s.substring(s.lastIndexOf("@"));
        }
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        (new Thread(new _cls1(charsequence, new ArrayList()))).start();
    }




    /* member class not found */
    class _cls1 {}

}
