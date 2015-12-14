// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.photoselector;


public final class CurFragment extends Enum
{

    private static final CurFragment $VALUES[];
    public static final CurFragment files;
    public static final CurFragment folder;

    private CurFragment(String s, int i)
    {
        super(s, i);
    }

    public static CurFragment valueOf(String s)
    {
        return (CurFragment)Enum.valueOf(com/pipcamera/activity/photoselector/CurFragment, s);
    }

    public static CurFragment[] values()
    {
        return (CurFragment[])$VALUES.clone();
    }

    static 
    {
        folder = new CurFragment("folder", 0);
        files = new CurFragment("files", 1);
        $VALUES = (new CurFragment[] {
            folder, files
        });
    }
}
