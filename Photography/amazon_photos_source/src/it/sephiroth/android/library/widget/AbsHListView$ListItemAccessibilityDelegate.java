// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.widget.ListAdapter;

// Referenced classes of package it.sephiroth.android.library.widget:
//            AbsHListView

class this._cls0 extends AccessibilityDelegateCompat
{

    final AbsHListView this$0;

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
    {
        int i;
        super.onInitializeAccessibilityNodeInfo(view, accessibilitynodeinfocompat);
        i = getPositionForView(view);
        view = (ListAdapter)getAdapter();
        break MISSING_BLOCK_LABEL_26;
        if (i != -1 && view != null && isEnabled() && view.isEnabled(i))
        {
            if (i == getSelectedItemPosition())
            {
                accessibilitynodeinfocompat.setSelected(true);
                accessibilitynodeinfocompat.addAction(8);
            } else
            {
                accessibilitynodeinfocompat.addAction(4);
            }
            if (isClickable())
            {
                accessibilitynodeinfocompat.addAction(16);
                accessibilitynodeinfocompat.setClickable(true);
            }
            if (isLongClickable())
            {
                accessibilitynodeinfocompat.addAction(32);
                accessibilitynodeinfocompat.setLongClickable(true);
                return;
            }
        }
        return;
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle)
    {
        if (super.performAccessibilityAction(view, i, bundle))
        {
            return true;
        }
        int j = getPositionForView(view);
        bundle = (ListAdapter)getAdapter();
        if (j == -1 || bundle == null)
        {
            return false;
        }
        if (!isEnabled() || !bundle.isEnabled(j))
        {
            return false;
        }
        long l = getItemIdAtPosition(j);
        switch (i)
        {
        default:
            return false;

        case 8: // '\b'
            if (getSelectedItemPosition() == j)
            {
                setSelection(-1);
                return true;
            } else
            {
                return false;
            }

        case 4: // '\004'
            if (getSelectedItemPosition() != j)
            {
                setSelection(j);
                return true;
            } else
            {
                return false;
            }

        case 16: // '\020'
            if (isClickable())
            {
                return performItemClick(view, j, l);
            } else
            {
                return false;
            }

        case 32: // ' '
            break;
        }
        if (isLongClickable())
        {
            return performLongPress(view, j, l);
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = AbsHListView.this;
        super();
    }
}
