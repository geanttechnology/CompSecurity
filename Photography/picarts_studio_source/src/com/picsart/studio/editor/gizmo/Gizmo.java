// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.gizmo;

import android.graphics.Canvas;
import android.view.MotionEvent;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.f;
import com.picsart.studio.editor.item.Item;

public abstract class Gizmo
{

    protected final Item a;

    protected Gizmo(Item item)
    {
        a = item;
    }

    public abstract f a(MotionEvent motionevent, Camera camera, boolean flag);

    public abstract void a(Canvas canvas, Camera camera);
}
