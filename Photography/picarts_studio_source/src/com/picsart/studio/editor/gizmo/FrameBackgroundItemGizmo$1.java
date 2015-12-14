// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.gizmo;


// Referenced classes of package com.picsart.studio.editor.gizmo:
//            FrameBackgroundItemGizmo

final class stureType
{

    static final int a[];

    static 
    {
        a = new int[stureType.values().length];
        try
        {
            a[stureType.DRAG.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[stureType.PINCH.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
