// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;


// Referenced classes of package com.picsart.studio.editor.view:
//            SquareFitEditorView

final class SquareFitMode
{

    static final int a[];

    static 
    {
        a = new int[com.picsart.studio.editor.fragment.reFitMode.values().length];
        try
        {
            a[com.picsart.studio.editor.fragment.reFitMode.BLUR.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[com.picsart.studio.editor.fragment.reFitMode.COLOR.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[com.picsart.studio.editor.fragment.reFitMode.PATTERN.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
