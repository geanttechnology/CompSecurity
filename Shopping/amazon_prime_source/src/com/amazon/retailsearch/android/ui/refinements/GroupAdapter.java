// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementGroupType

public interface GroupAdapter
{

    public abstract boolean containsChild(String s);

    public abstract Object getChild(int i);

    public abstract int getChildPosition(String s);

    public abstract String getChildUrl(int i);

    public abstract View getChildView(int i, boolean flag, View view, ViewGroup viewgroup);

    public abstract int getChildrenCount();

    public abstract Object getData();

    public abstract String getId();

    public abstract RefinementGroupType getType();

    public abstract String getUrl();

    public abstract View getView(boolean flag, View view, ViewGroup viewgroup);

    public abstract boolean isChildEnabled(int i);

    public abstract boolean isChildSelected(String s);

    public abstract boolean isEnabled();
}
