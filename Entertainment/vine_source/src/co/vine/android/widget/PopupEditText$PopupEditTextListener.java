// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.support.v4.widget.CursorAdapter;

// Referenced classes of package co.vine.android.widget:
//            PopupEditText

public static interface 
{

    public abstract CursorAdapter getPopupAdapter();

    public abstract void onFiltering(CharSequence charsequence);

    public abstract void onPopupItemSelected(int i, int j, CharSequence charsequence, long l);

    public abstract void onPopupShown();

    public abstract void setPopupAdapter(String s);
}
