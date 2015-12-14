// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.facebook.common.internal.Objects;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;

// Referenced classes of package com.facebook.drawee.view:
//            DraweeHolder

public class DraweeView extends ImageView
{

    private DraweeHolder mDraweeHolder;

    public DraweeView(Context context)
    {
        super(context);
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
    }

    private void init(Context context)
    {
        mDraweeHolder = DraweeHolder.create(null, context);
    }

    public DraweeController getController()
    {
        return mDraweeHolder.getController();
    }

    public DraweeHierarchy getHierarchy()
    {
        return mDraweeHolder.getHierarchy();
    }

    public Drawable getTopLevelDrawable()
    {
        return mDraweeHolder.getTopLevelDrawable();
    }

    public boolean hasController()
    {
        return mDraweeHolder.getController() != null;
    }

    public boolean hasHierarchy()
    {
        return mDraweeHolder.hasHierarchy();
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        mDraweeHolder.onAttach();
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mDraweeHolder.onDetach();
    }

    public void onFinishTemporaryDetach()
    {
        super.onFinishTemporaryDetach();
        mDraweeHolder.onAttach();
    }

    public void onStartTemporaryDetach()
    {
        super.onStartTemporaryDetach();
        mDraweeHolder.onDetach();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (mDraweeHolder.onTouchEvent(motionevent))
        {
            return true;
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

    public void setController(DraweeController draweecontroller)
    {
        mDraweeHolder.setController(draweecontroller);
        super.setImageDrawable(mDraweeHolder.getTopLevelDrawable());
    }

    public void setHierarchy(DraweeHierarchy draweehierarchy)
    {
        mDraweeHolder.setHierarchy(draweehierarchy);
        super.setImageDrawable(mDraweeHolder.getTopLevelDrawable());
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        mDraweeHolder.setController(null);
        super.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable)
    {
        mDraweeHolder.setController(null);
        super.setImageDrawable(drawable);
    }

    public void setImageResource(int i)
    {
        mDraweeHolder.setController(null);
        super.setImageResource(i);
    }

    public void setImageURI(Uri uri)
    {
        mDraweeHolder.setController(null);
        super.setImageURI(uri);
    }

    public String toString()
    {
        return Objects.toStringHelper(this).add("holder", mDraweeHolder.toString()).toString();
    }
}
