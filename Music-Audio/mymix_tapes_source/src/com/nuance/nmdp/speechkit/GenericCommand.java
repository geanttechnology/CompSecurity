// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


// Referenced classes of package com.nuance.nmdp.speechkit:
//            GenericResult, SpeechError

public interface GenericCommand
{
    public static interface Listener
    {

        public abstract void onComplete(GenericCommand genericcommand, GenericResult genericresult, SpeechError speecherror);
    }


    public abstract void addParam(String s, com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary);

    public abstract void addParam(String s, com.nuance.nmdp.speechkit.util.pdx.PdxValue.String s1);

    public abstract void cancel();

    public abstract void start();
}
