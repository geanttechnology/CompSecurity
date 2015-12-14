// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.picasso;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

// Referenced classes of package it.sephiroth.android.library.picasso:
//            RequestCreator, Callback

class DeferredRequestCreator
    implements android.view.ViewTreeObserver.OnPreDrawListener
{

    Callback callback;
    final RequestCreator creator;
    final WeakReference target;
    final boolean targetIsHidden;

    DeferredRequestCreator(RequestCreator requestcreator, ImageView imageview)
    {
        this(requestcreator, imageview, false, null);
    }

    DeferredRequestCreator(RequestCreator requestcreator, ImageView imageview, boolean flag, Callback callback1)
    {
        creator = requestcreator;
        target = new WeakReference(imageview);
        callback = callback1;
        targetIsHidden = flag;
        imageview.getViewTreeObserver().addOnPreDrawListener(this);
    }

    void cancel()
    {
        callback = null;
        Object obj = (ImageView)target.get();
        if (obj != null)
        {
            if (((ViewTreeObserver) (obj = ((ImageView) (obj)).getViewTreeObserver())).isAlive())
            {
                ((ViewTreeObserver) (obj)).removeOnPreDrawListener(this);
                return;
            }
        }
    }

    public boolean onPreDraw()
    {
        ImageView imageview = (ImageView)target.get();
        ViewTreeObserver viewtreeobserver;
        if (imageview != null)
        {
            if ((viewtreeobserver = imageview.getViewTreeObserver()).isAlive())
            {
                int i;
                int j;
                if (imageview.getVisibility() == 8 || targetIsHidden)
                {
                    j = imageview.getMeasuredWidth();
                    i = imageview.getMeasuredHeight();
                } else
                {
                    j = imageview.getWidth();
                    i = imageview.getHeight();
                }
                if (j > 0 && i > 0)
                {
                    viewtreeobserver.removeOnPreDrawListener(this);
                    creator.unfit().resize(j, i).into(imageview, callback);
                    return true;
                }
            }
        }
        return true;
    }
}
