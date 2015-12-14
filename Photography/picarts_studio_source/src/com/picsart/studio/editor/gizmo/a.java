// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.gizmo;

import android.graphics.Canvas;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.g;
import com.picsart.studio.editor.item.TransformingItem;

// Referenced classes of package com.picsart.studio.editor.gizmo:
//            Gizmo

public abstract class a extends Gizmo
{

    protected a(TransformingItem transformingitem)
    {
        super(transformingitem);
    }

    public final void a(Canvas canvas, Camera camera)
    {
        g g1 = ((TransformingItem)a).a(camera);
        float f = Math.abs(((TransformingItem)a).i() * g1.c());
        float f1 = Math.abs(((TransformingItem)a).j() * g1.d());
        canvas.save();
        canvas.translate(g1.a(), g1.b());
        canvas.rotate(g1.e());
        a(canvas, camera, f, f1);
    }

    public abstract void a(Canvas canvas, Camera camera, float f, float f1);
}
