// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;


// Referenced classes of package com.bumptech.glide:
//            j, Priority

final class ror
{

    static final int a[];
    static final int b[];

    static 
    {
        b = new int[Priority.values().length];
        try
        {
            b[Priority.LOW.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            b[Priority.NORMAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            b[Priority.HIGH.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            b[Priority.IMMEDIATE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        a = new int[android.widget.eView.ScaleType.values().length];
        try
        {
            a[android.widget.eView.ScaleType.CENTER_CROP.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[android.widget.eView.ScaleType.FIT_CENTER.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[android.widget.eView.ScaleType.FIT_START.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[android.widget.eView.ScaleType.FIT_END.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
