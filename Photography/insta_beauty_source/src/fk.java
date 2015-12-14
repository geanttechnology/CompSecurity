// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;

public class fk
    implements TextWatcher
{

    final SearchView a;

    public fk(SearchView searchview)
    {
        a = searchview;
        super();
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        SearchView.access$2100(a, charsequence);
    }
}
