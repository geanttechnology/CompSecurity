// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;

public class PatternTextWatcher
    implements TextWatcher
{

    private int deleteCount;
    private int insertCount;
    private int nestingLevel;
    private String original;
    private int start;
    private String template;
    private String validation;

    public PatternTextWatcher(String s, String s1)
    {
        template = s;
        validation = s1;
    }

    public void afterTextChanged(Editable editable)
    {
        if (nestingLevel != 0) goto _L2; else goto _L1
_L1:
        nestingLevel = nestingLevel + 1;
        StringBuilder stringbuilder;
        int i;
        int k;
        int l;
        int i1;
        int j1;
        stringbuilder = new StringBuilder(original);
        stringbuilder.replace(start, start + deleteCount, template.substring(start, start + deleteCount));
        i = start;
        l = start;
        i1 = insertCount;
        j1 = template.length();
        k = start;
          goto _L3
_L5:
        if (i >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (Character.isSpaceChar(template.charAt(i)))
        {
            break; /* Loop/switch isn't completed */
        }
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        char c1;
        char c2;
        c2 = stringbuilder.charAt(i);
        c1 = editable.charAt(k);
        char c = c1;
        if (Character.isWhitespace(c1))
        {
            c = template.charAt(i);
        }
        stringbuilder.setCharAt(i, c);
        if (!validate(stringbuilder)) goto _L7; else goto _L6
_L6:
        int j = i + 1;
_L9:
        i = j;
        if (j >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (Character.isSpaceChar(template.charAt(j)))
        {
            break; /* Loop/switch isn't completed */
        }
        j++;
        if (true) goto _L9; else goto _L8
_L7:
        stringbuilder.setCharAt(i, c2);
          goto _L8
_L10:
        editable.replace(0, editable.length(), stringbuilder);
        Selection.setSelection(editable, i);
        nestingLevel = nestingLevel - 1;
_L2:
        return;
        editable;
        nestingLevel = nestingLevel - 1;
        throw editable;
_L3:
        if (i >= j1 || k >= l + i1) goto _L10; else goto _L5
_L8:
        k++;
          goto _L3
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (nestingLevel == 0)
        {
            original = charsequence.toString();
            start = i;
            deleteCount = j;
            insertCount = k;
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    protected boolean validate(CharSequence charsequence)
    {
        return validation == null || charsequence.toString().matches(validation);
    }
}
