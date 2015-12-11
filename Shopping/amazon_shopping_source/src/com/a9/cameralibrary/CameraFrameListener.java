// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.cameralibrary;


// Referenced classes of package com.a9.cameralibrary:
//            CameraErrorReason

public interface CameraFrameListener
{

    public abstract void cameraError(CameraErrorReason cameraerrorreason, String s);

    public abstract void didReceiveFrame(byte abyte0[], int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, long l2);
}
