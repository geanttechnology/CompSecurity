// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.impl;

import com.a9.vs.mobile.library.impl.jni.ObjectID;
import com.a9.vs.mobile.library.impl.jni.ServerFailure;

// Referenced classes of package com.flow.android.engine.library.impl:
//            FlowEventCallback

static class 
{

    static final int $SwitchMap$com$a9$vs$mobile$library$impl$jni$ObjectID[];
    static final int $SwitchMap$com$a9$vs$mobile$library$impl$jni$ServerFailure[];

    static 
    {
        $SwitchMap$com$a9$vs$mobile$library$impl$jni$ServerFailure = new int[ServerFailure.values().length];
        try
        {
            $SwitchMap$com$a9$vs$mobile$library$impl$jni$ServerFailure[ServerFailure.NO_NETWORK.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$a9$vs$mobile$library$impl$jni$ServerFailure[ServerFailure.SERVER_ERROR.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$a9$vs$mobile$library$impl$jni$ServerFailure[ServerFailure.UNAUTHORIZED_ACCESS.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$a9$vs$mobile$library$impl$jni$ServerFailure[ServerFailure.UNKNOWN_ERROR.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        $SwitchMap$com$a9$vs$mobile$library$impl$jni$ObjectID = new int[ObjectID.values().length];
        try
        {
            $SwitchMap$com$a9$vs$mobile$library$impl$jni$ObjectID[ObjectID.IMGMATCHOBJ.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$a9$vs$mobile$library$impl$jni$ObjectID[ObjectID.BARCODE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$a9$vs$mobile$library$impl$jni$ObjectID[ObjectID.TWOD_BARCODE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$a9$vs$mobile$library$impl$jni$ObjectID[ObjectID.TEXT.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$a9$vs$mobile$library$impl$jni$ObjectID[ObjectID.LOGO.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
