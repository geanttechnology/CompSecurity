// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.piprender;


public final class ESceneMode extends Enum
{

    private static final ESceneMode $VALUES[];
    public static final ESceneMode SCENE_MODE1;
    public static final ESceneMode SCENE_MODE2;
    public static final ESceneMode SCENE_MODE3;
    public static final ESceneMode SCENE_MODE_COUNT;

    private ESceneMode(String s, int i)
    {
        super(s, i);
    }

    public static ESceneMode valueOf(String s)
    {
        return (ESceneMode)Enum.valueOf(com/wantu/piprender/ESceneMode, s);
    }

    public static ESceneMode[] values()
    {
        return (ESceneMode[])$VALUES.clone();
    }

    static 
    {
        SCENE_MODE1 = new ESceneMode("SCENE_MODE1", 0);
        SCENE_MODE2 = new ESceneMode("SCENE_MODE2", 1);
        SCENE_MODE3 = new ESceneMode("SCENE_MODE3", 2);
        SCENE_MODE_COUNT = new ESceneMode("SCENE_MODE_COUNT", 3);
        $VALUES = (new ESceneMode[] {
            SCENE_MODE1, SCENE_MODE2, SCENE_MODE3, SCENE_MODE_COUNT
        });
    }
}
