// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package com.comcast.cim.android.view.common:
//            FilterableProgramCollectionFragment

class _cls1.val.quickReturnView
    implements com.comcast.cim.cmasl.android.util.view.widget.ReturnView
{

    private final View quickReturnView;
    private int quickReturnViewHeight;
    private Rect referenceQuickReturnViewRect;
    final FilterableProgramCollectionFragment this$0;

    public void adjustReferenceRectVerticals(int i)
    {
        quickReturnView.setTranslationY(0.0F);
        Rect rect = referenceQuickReturnViewRect;
        rect.top = rect.top + i;
        rect = referenceQuickReturnViewRect;
        rect.bottom = rect.bottom + i;
    }

    public void onScrollChanged(float f, float f1)
    {
        if (f1 <= 0.001F && f1 >= -1F * 0.001F) goto _L2; else goto _L1
_L1:
        Rect rect;
        rect = new Rect();
        quickReturnView.getGlobalVisibleRect(rect);
        if ((f1 <= 0.0F || rect.bottom <= referenceQuickReturnViewRect.top || rect.top <= referenceQuickReturnViewRect.top - quickReturnViewHeight) && (f1 >= 0.0F || rect.bottom >= referenceQuickReturnViewRect.bottom)) goto _L4; else goto _L3
_L3:
        if (f1 >= 0.0F || (float)rect.bottom - f1 <= (float)referenceQuickReturnViewRect.bottom) goto _L6; else goto _L5
_L5:
        quickReturnView.setTranslationY(0.0F);
_L2:
        return;
_L6:
        f = quickReturnView.getTranslationY();
        quickReturnView.setTranslationY(f - f1);
        return;
_L4:
        if (rect.bottom > referenceQuickReturnViewRect.bottom)
        {
            quickReturnView.setTranslationY(0.0F);
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }




/*
    static int access$102(_cls1 _pcls1, int i)
    {
        _pcls1.quickReturnViewHeight = i;
        return i;
    }

*/

    public _cls1.val.quickReturnView(final View quickReturnView)
    {
        this.this$0 = FilterableProgramCollectionFragment.this;
        super();
        referenceQuickReturnViewRect = new Rect();
        this.quickReturnView = quickReturnView;
        quickReturnView.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final FilterableProgramCollectionFragment.QuickReturnOnScrollChangedListener this$1;
            final View val$quickReturnView;
            final FilterableProgramCollectionFragment val$this$0;

            public void onGlobalLayout()
            {
label0:
                {
                    quickReturnView.getGlobalVisibleRect(referenceQuickReturnViewRect);
                    quickReturnViewHeight = referenceQuickReturnViewRect.bottom - referenceQuickReturnViewRect.top;
                    if (quickReturnViewHeight > 0)
                    {
                        if (android.os.Build.VERSION.SDK_INT < 16)
                        {
                            break label0;
                        }
                        quickReturnView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    return;
                }
                quickReturnView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }

            
            {
                this$1 = FilterableProgramCollectionFragment.QuickReturnOnScrollChangedListener.this;
                this$0 = filterableprogramcollectionfragment;
                quickReturnView = view;
                super();
            }
        });
    }
}
