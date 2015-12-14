// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share.ui;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EditBlogView extends EditText
{

    private boolean canSelectionChanged;
    private int count;
    private Context ctx;
    private List listeners;
    private OnEnterListener mOnEnterListener;

    public EditBlogView(Context context)
    {
        super(context);
        canSelectionChanged = true;
        init();
    }

    public EditBlogView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        canSelectionChanged = true;
        init();
    }

    public EditBlogView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        canSelectionChanged = true;
        init();
    }

    private void init()
    {
        ctx = getContext();
        listeners = new ArrayList();
    }

    public int correctPosition(int i)
    {
        Editable editable;
        Object aobj[];
        if (i != -1)
        {
            if (i < (editable = getText()).length() && ((aobj = editable.getSpans(i, i, android/text/style/ImageSpan)) != null && aobj.length != 0 && i != editable.getSpanStart(aobj[0])))
            {
                return editable.getSpanEnd(aobj[0]);
            }
        }
        return i;
    }

    public void enableSelectionChanged(boolean flag)
    {
        canSelectionChanged = flag;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorinfo)
    {
        return new InputConnectionWrapper(super.onCreateInputConnection(editorinfo), false) {

            final EditBlogView this$0;

            public boolean commitText(CharSequence charsequence, int i)
            {
                Editable editable = getEditableText();
                new String(editable.toString());
                int i1 = Selection.getSelectionStart(editable);
                int j1 = Selection.getSelectionEnd(editable);
                if (i1 != -1 && j1 != -1)
                {
                    int j = correctPosition(i1);
                    int k = correctPosition(j1);
                    int l;
                    if (j > k)
                    {
                        l = k;
                        k = j;
                    } else
                    {
                        l = j;
                    }
                    if (l != i1 || k != j1)
                    {
                        Selection.setSelection(editable, l, k);
                    }
                    if (l != k)
                    {
                        getText().delete(l, k);
                    }
                }
                return super.commitText(charsequence, i);
            }

            public boolean setComposingText(CharSequence charsequence, int i)
            {
                Editable editable = getEditableText();
                new String(editable.toString());
                int i1 = Selection.getSelectionStart(editable);
                int j1 = Selection.getSelectionEnd(editable);
                if (i1 != -1 && j1 != -1)
                {
                    int j = correctPosition(i1);
                    int k = correctPosition(j1);
                    int l;
                    if (j > k)
                    {
                        l = k;
                        k = j;
                    } else
                    {
                        l = j;
                    }
                    if (l != i1 || k != j1)
                    {
                        Selection.setSelection(editable, l, k);
                    }
                    if (l != k)
                    {
                        getText().delete(l, k);
                    }
                }
                return super.setComposingText(charsequence, i);
            }

            
            {
                this$0 = EditBlogView.this;
                super(inputconnection, flag);
            }
        };
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 66 && mOnEnterListener != null)
        {
            mOnEnterListener.onEnterKey();
        }
        return super.onKeyDown(i, keyevent);
    }

    protected void onSelectionChanged(int i, int j)
    {
        super.onSelectionChanged(i, j);
        if (canSelectionChanged && listeners != null && !listeners.isEmpty())
        {
            Iterator iterator = listeners.iterator();
            while (iterator.hasNext()) 
            {
                ((OnSelectionListener)iterator.next()).onSelectionChanged(i, j);
            }
        }
    }

    public void setOnEnterListener(OnEnterListener onenterlistener)
    {
        mOnEnterListener = onenterlistener;
    }

    public void setOnSelectionListener(OnSelectionListener onselectionlistener)
    {
        listeners.add(onselectionlistener);
    }

    private class OnEnterListener
    {

        public abstract void onEnterKey();
    }


    private class OnSelectionListener
    {

        public abstract void onSelectionChanged(int i, int j);
    }

}
