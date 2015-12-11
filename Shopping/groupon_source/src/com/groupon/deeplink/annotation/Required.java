// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.deeplink.annotation;

import java.lang.annotation.Annotation;

// Referenced classes of package com.groupon.deeplink.annotation:
//            DeepLinkField

public interface Required
    extends Annotation
{

    public abstract DeepLinkField[] values();
}
