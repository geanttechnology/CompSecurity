// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.display.input;

import com.amazon.retailsearch.android.api.display.input.listeners.ISSListener;
import com.amazon.retailsearch.android.api.display.input.listeners.KeyPreImeListener;
import com.amazon.retailsearch.android.api.display.input.listeners.QuerySubmitListener;

public interface SearchEntryListeners
{

    public abstract void addListener(android.view.View.OnFocusChangeListener onfocuschangelistener);

    public abstract void addListener(QuerySubmitListener querysubmitlistener);

    public abstract void removeListener(android.view.View.OnFocusChangeListener onfocuschangelistener);

    public abstract void removeListener(android.view.View.OnLongClickListener onlongclicklistener);

    public abstract void removeListener(ISSListener isslistener);

    public abstract void removeListener(KeyPreImeListener keypreimelistener);

    public abstract void removeListener(QuerySubmitListener querysubmitlistener);

    public abstract void setListener(android.view.View.OnLongClickListener onlongclicklistener);

    public abstract void setListener(ISSListener isslistener);

    public abstract void setListener(KeyPreImeListener keypreimelistener);
}
