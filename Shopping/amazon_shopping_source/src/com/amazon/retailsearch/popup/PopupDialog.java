// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.popup;


// Referenced classes of package com.amazon.retailsearch.popup:
//            DialogSizeChangedListener

public interface PopupDialog
{

    public abstract int getDialogHeight();

    public abstract void setSizeChangeListener(DialogSizeChangedListener dialogsizechangedlistener);
}
