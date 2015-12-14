// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.util.v11;

import android.view.ActionMode;

public interface MultiChoiceModeListener
    extends android.view.ActionMode.Callback
{

    public abstract void onItemCheckedStateChanged(ActionMode actionmode, int i, long l, boolean flag);
}
