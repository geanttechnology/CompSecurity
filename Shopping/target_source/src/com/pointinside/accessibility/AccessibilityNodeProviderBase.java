// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.accessibility;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.a.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.d;
import android.support.v4.view.a.j;
import android.support.v4.view.a.m;
import android.support.v4.view.ai;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class AccessibilityNodeProviderBase extends j
{

    public static final int INVALID_ID = 0x80000000;
    private Object mCurrentItem;
    private final android.support.v4.view.a mDelegate = new android.support.v4.view.a() {

        final AccessibilityNodeProviderBase this$0;

        public j getAccessibilityNodeProvider(View view)
        {
            return AccessibilityNodeProviderBase.this;
        }

            
            {
                this$0 = AccessibilityNodeProviderBase.this;
                super();
            }
    };
    private int mFocusedItemId;
    private final AccessibilityManager mManager;
    private final SparseArray mNodeCache = new SparseArray();
    private final android.view.View.OnHoverListener mOnHoverListener = new android.view.View.OnHoverListener() {

        final AccessibilityNodeProviderBase this$0;

        public boolean onHover(View view, MotionEvent motionevent)
        {
            if (!b.a(mManager))
            {
                return false;
            }
            switch (motionevent.getAction())
            {
            case 8: // '\b'
            default:
                return false;

            case 7: // '\007'
            case 9: // '\t'
                view = ((View) (getItemAt(motionevent.getX(), motionevent.getY())));
                setCurrentItem(view);
                return true;

            case 10: // '\n'
                setCurrentItem(null);
                break;
            }
            return true;
        }

            
            {
                this$0 = AccessibilityNodeProviderBase.this;
                super();
            }
    };
    private View mParentView;

    public AccessibilityNodeProviderBase(Context context)
    {
        mCurrentItem = null;
        mFocusedItemId = 0x80000000;
        mManager = (AccessibilityManager)context.getSystemService("accessibility");
    }

    private void clearCache()
    {
        for (int i = 0; i < mNodeCache.size(); i++)
        {
            ((d)mNodeCache.valueAt(i)).t();
        }

        mNodeCache.clear();
    }

    private AccessibilityEvent getEventForItem(Object obj, int i)
    {
        AccessibilityEvent accessibilityevent = AccessibilityEvent.obtain(i);
        m m1 = a.a(accessibilityevent);
        i = getIdForItem(obj);
        accessibilityevent.setEnabled(true);
        populateEventForItem(obj, accessibilityevent);
        accessibilityevent.setClassName(obj.getClass().getName());
        accessibilityevent.setPackageName(mParentView.getContext().getPackageName());
        m1.a(mParentView, i);
        return accessibilityevent;
    }

    private d getNodeForItem(Object obj)
    {
        d d1 = d.b();
        int i = getIdForItem(obj);
        d1.h(true);
        d1.c(true);
        populateNodeForItem(obj, d1);
        d1.a(mParentView.getContext().getPackageName());
        d1.b(obj.getClass().getName());
        d1.d(mParentView);
        d1.a(mParentView, i);
        if (mFocusedItemId == i)
        {
            d1.a(128);
            return d1;
        } else
        {
            d1.a(64);
            return d1;
        }
    }

    private d getNodeForParent()
    {
        d d1 = d.a(mParentView);
        ai.a(mParentView, d1);
        Object obj = new LinkedList();
        getVisibleItems(((List) (obj)));
        int i;
        for (obj = ((LinkedList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); d1.b(mParentView, i))
        {
            i = getIdForItem(((Iterator) (obj)).next());
        }

        return d1;
    }

    private void sendEventForItem(Object obj, int i)
    {
        obj = getEventForItem(obj, i);
        ((ViewGroup)mParentView.getParent()).requestSendAccessibilityEvent(mParentView, ((AccessibilityEvent) (obj)));
    }

    private void setCurrentItem(Object obj)
    {
        if (mCurrentItem != obj)
        {
            if (mCurrentItem != null)
            {
                sendEventForItem(mCurrentItem, 256);
            }
            mCurrentItem = obj;
            if (mCurrentItem != null)
            {
                sendEventForItem(mCurrentItem, 128);
                return;
            }
        }
    }

    public d createAccessibilityNodeInfo(int i)
    {
        if (i == -1)
        {
            return getNodeForParent();
        }
        Object obj = (d)mNodeCache.get(i);
        if (obj != null)
        {
            return d.a(((d) (obj)));
        }
        obj = getItemForId(i);
        if (obj == null)
        {
            return null;
        } else
        {
            obj = getNodeForItem(obj);
            mNodeCache.put(i, d.a(((d) (obj))));
            return ((d) (obj));
        }
    }

    protected abstract int getIdForItem(Object obj);

    protected abstract Object getItemAt(float f, float f1);

    protected abstract Object getItemForId(int i);

    protected abstract void getVisibleItems(List list);

    public void install(View view)
    {
        mParentView = view;
        mParentView.setOnHoverListener(mOnHoverListener);
        ai.a(mParentView, mDelegate);
        ai.c(mParentView, 1);
        invalidateParent();
    }

    public void invalidateParent()
    {
        clearCache();
        ai.a(mParentView, mDelegate);
        mParentView.sendAccessibilityEvent(2048);
    }

    public boolean performAction(int i, int k, Bundle bundle)
    {
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = false;
        if (i != -1) goto _L2; else goto _L1
_L1:
        flag1 = mDelegate.performAccessibilityAction(mParentView, k, bundle);
_L4:
        return flag1;
_L2:
        Object obj = getItemForId(i);
        if (obj == null) goto _L4; else goto _L3
_L3:
        k;
        JVM INSTR lookupswitch 2: default 68
    //                   64: 81
    //                   128: 109;
           goto _L5 _L6 _L7
_L5:
        i = 0;
_L9:
        return performActionForItem(obj, k, bundle) | i;
_L6:
        if (mFocusedItemId == i) goto _L5; else goto _L8
_L8:
        mFocusedItemId = i;
        sendEventForItem(obj, 32768);
        i = ((flag) ? 1 : 0);
          goto _L9
_L7:
        if (mFocusedItemId != i) goto _L5; else goto _L10
_L10:
        mFocusedItemId = 0x80000000;
        sendEventForItem(obj, 0x10000);
        i = ((flag) ? 1 : 0);
          goto _L9
    }

    protected abstract boolean performActionForItem(Object obj, int i, Bundle bundle);

    protected abstract void populateEventForItem(Object obj, AccessibilityEvent accessibilityevent);

    protected abstract void populateNodeForItem(Object obj, d d1);

    public void uninstall()
    {
        if (mParentView == null)
        {
            return;
        } else
        {
            ai.a(mParentView, new android.support.v4.view.a());
            ai.c(mParentView, 0);
            clearCache();
            mParentView.setOnHoverListener(null);
            mParentView = null;
            return;
        }
    }


}
