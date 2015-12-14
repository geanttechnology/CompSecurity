// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share.ui;

import android.text.Editable;
import android.text.Selection;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

// Referenced classes of package com.sina.weibo.sdk.api.share.ui:
//            EditBlogView

class  extends InputConnectionWrapper
{

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

    (InputConnection inputconnection, boolean flag)
    {
        this$0 = EditBlogView.this;
        super(inputconnection, flag);
    }
}
