// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;


// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

protected static class  extends 
    implements com.googlecode.javacpp.or
{

    public void deallocate()
    {
        opencv_core.cvReleaseFileStorage(this);
    }

    ( )
    {
        super();
    }
}
