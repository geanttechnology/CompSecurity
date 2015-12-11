// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.a.d;
import android.view.accessibility.AccessibilityEvent;
import com.pointinside.accessibility.AccessibilityNodeProviderBase;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.pointinside.maps:
//            MapView

private class Base extends AccessibilityNodeProviderBase
{

    final MapView this$0;

    private Base getItemFromCoordinates(float f, float f1)
    {
        int i = (int)f;
        int j = (int)f1;
        for (Iterator iterator = MapView.access$500(MapView.this).iterator(); iterator.hasNext();)
        {
            Base base = (this._cls0)iterator.next();
            if (base.Bounds.contains(i, j))
            {
                return base;
            }
        }

        return null;
    }

    protected int getIdForItem(Bounds bounds)
    {
        return bounds.Id;
    }

    protected volatile int getIdForItem(Object obj)
    {
        return getIdForItem((getIdForItem)obj);
    }

    protected getIdForItem getItemAt(float f, float f1)
    {
        return getItemFromCoordinates(f, f1);
    }

    protected volatile Object getItemAt(float f, float f1)
    {
        return getItemAt(f, f1);
    }

    protected getItemAt getItemForId(int i)
    {
        if (i >= 0 && i < MapView.access$500(MapView.this).size())
        {
            return (this._cls0)MapView.access$500(MapView.this).get(i);
        } else
        {
            return null;
        }
    }

    protected volatile Object getItemForId(int i)
    {
        return getItemForId(i);
    }

    protected void getVisibleItems(List list)
    {
        list.addAll(MapView.access$500(MapView.this));
    }

    protected boolean performActionForItem(this._cls0 _pcls0, int i, Bundle bundle)
    {
        return false;
    }

    protected volatile boolean performActionForItem(Object obj, int i, Bundle bundle)
    {
        return performActionForItem((performActionForItem)obj, i, bundle);
    }

    protected void populateEventForItem(performActionForItem performactionforitem, AccessibilityEvent accessibilityevent)
    {
        accessibilityevent.setContentDescription(performactionforitem.Text);
    }

    protected volatile void populateEventForItem(Object obj, AccessibilityEvent accessibilityevent)
    {
        populateEventForItem((populateEventForItem)obj, accessibilityevent);
    }

    protected void populateNodeForItem(populateEventForItem populateeventforitem, d d1)
    {
        d1.b(populateeventforitem.Bounds);
        d1.c(populateeventforitem.Text);
        d1.a(String.valueOf(populateeventforitem.Id));
        d1.a(true);
    }

    protected volatile void populateNodeForItem(Object obj, d d1)
    {
        populateNodeForItem((populateNodeForItem)obj, d1);
    }

    public Base(Context context)
    {
        this$0 = MapView.this;
        super(context);
    }
}
