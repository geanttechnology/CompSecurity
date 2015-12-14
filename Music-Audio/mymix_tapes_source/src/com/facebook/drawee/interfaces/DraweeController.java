// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.interfaces;

import android.graphics.drawable.Animatable;
import android.view.MotionEvent;

// Referenced classes of package com.facebook.drawee.interfaces:
//            DraweeHierarchy

public interface DraweeController
{

    public abstract Animatable getAnimatable();

    public abstract DraweeHierarchy getHierarchy();

    public abstract void onAttach();

    public abstract void onDetach();

    public abstract boolean onTouchEvent(MotionEvent motionevent);

    public abstract void setHierarchy(DraweeHierarchy draweehierarchy);
}
