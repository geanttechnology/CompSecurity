// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

// Referenced classes of package com.pointinside.maps:
//            PIMGLInterface

public static interface 
    extends Callback
{

    public abstract void apply(String s, Pointer pointer, Pointer pointer1);
}
