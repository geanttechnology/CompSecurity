// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.sun.jna.Callback;

// Referenced classes of package com.pointinside.maps:
//            PIMGLInterface, PIMGLEventData

public static interface 
    extends Callback
{

    public abstract void apply(PIMGLEventData pimgleventdata);
}
