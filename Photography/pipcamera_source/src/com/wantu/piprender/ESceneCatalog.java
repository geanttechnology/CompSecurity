// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.piprender;


public final class ESceneCatalog extends Enum
{

    private static final ESceneCatalog $VALUES[];
    public static final ESceneCatalog SCENE_RECTANGLE_SHAPE;
    public static final ESceneCatalog SCENE_UNREGULAR_SHAPE;

    private ESceneCatalog(String s, int i)
    {
        super(s, i);
    }

    public static ESceneCatalog valueOf(String s)
    {
        return (ESceneCatalog)Enum.valueOf(com/wantu/piprender/ESceneCatalog, s);
    }

    public static ESceneCatalog[] values()
    {
        return (ESceneCatalog[])$VALUES.clone();
    }

    static 
    {
        SCENE_RECTANGLE_SHAPE = new ESceneCatalog("SCENE_RECTANGLE_SHAPE", 0);
        SCENE_UNREGULAR_SHAPE = new ESceneCatalog("SCENE_UNREGULAR_SHAPE", 1);
        $VALUES = (new ESceneCatalog[] {
            SCENE_RECTANGLE_SHAPE, SCENE_UNREGULAR_SHAPE
        });
    }
}
