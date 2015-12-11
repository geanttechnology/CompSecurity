// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.view.LayoutInflater;
import android.view.View;
import org.json.JSONObject;

public interface MyItem
{

    public abstract JSONObject getMyJSONObject();

    public abstract View getView(LayoutInflater layoutinflater, View view);

    public abstract int getViewType();
}
