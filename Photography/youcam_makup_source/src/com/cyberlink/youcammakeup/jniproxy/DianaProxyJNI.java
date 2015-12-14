// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;

import com.pf.common.a;
import java.io.PrintStream;

// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            c, d, u, ac, 
//            ah, af, ab, ak, 
//            aa, y

public class DianaProxyJNI
{

    public static final native boolean CDianaProxy_ApplyPipelineEffects(long l, c c, long l1, d d, long l2, 
            d d1, long l3, u u);

    public static final native boolean CDianaProxy_QueryEyeEnlargePoint(long l, c c, int i, int j, float f, long l1, 
            ac ac, long l2, ah ah, long l3, ah ah1);

    public static final native boolean CDianaProxy_QueryFaceThinningPoint(long l, c c, int i, int j, float f, long l1, 
            ac ac, long l2, ac ac1, long l3, af af, 
            long l4, ab ab, long l5, ab ab1, long l6, ak ak, long l7, ak ak1, long l8, 
            aa aa, long l9, ah ah, long l10, ah ah1);

    public static final native boolean CDianaProxy_ReleaseImage(long l, c c, int i);

    public static final native boolean CDianaProxy_SetImage(long l, c c, int i);

    public static final native void UIDianaPipelineSettings_configCacheMode(long l, u u, int i);

    public static final native void UIDianaPipelineSettings_configEyeBagRemoval(long l, u u, int i);

    public static final native void UIDianaPipelineSettings_configEyeEnlargement(long l, u u, int i);

    public static final native void UIDianaPipelineSettings_configFaceThinning(long l, u u, int i);

    public static final native void UIDianaPipelineSettings_configFeaturePoints(long l, u u, long l1, y y);

    public static final native void UIDianaPipelineSettings_configRedEyeRemoval(long l, u u, boolean flag);

    public static final native void UIDianaPipelineSettings_configTeethWhitening(long l, u u, int i, boolean flag);

    public static final native long UIDianaPipelineSettings_queryFeaturePoints(long l, u u);

    public static final native void delete_CDianaProxy(long l);

    public static final native void delete_UIDianaPipelineSettings(long l);

    public static final native long new_CDianaProxy(String s);

    public static final native long new_UIDianaPipelineSettings__SWIG_0();

    public static final native long new_UIDianaPipelineSettings__SWIG_1(long l, u u);

    static 
    {
        try
        {
            a.b();
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            System.err.println((new StringBuilder()).append("JNI error: ").append(unsatisfiedlinkerror).toString());
            System.exit(1);
        }
    }
}
