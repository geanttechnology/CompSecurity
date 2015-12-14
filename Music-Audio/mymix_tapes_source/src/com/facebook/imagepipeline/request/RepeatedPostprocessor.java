// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.request;


// Referenced classes of package com.facebook.imagepipeline.request:
//            Postprocessor, RepeatedPostprocessorRunner

public interface RepeatedPostprocessor
    extends Postprocessor
{

    public abstract void setCallback(RepeatedPostprocessorRunner repeatedpostprocessorrunner);
}
