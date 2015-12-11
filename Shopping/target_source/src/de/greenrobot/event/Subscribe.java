// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event;

import java.lang.annotation.Annotation;

// Referenced classes of package de.greenrobot.event:
//            ThreadMode

public interface Subscribe
    extends Annotation
{

    public abstract int priority();

    public abstract boolean sticky();

    public abstract ThreadMode threadMode();
}
