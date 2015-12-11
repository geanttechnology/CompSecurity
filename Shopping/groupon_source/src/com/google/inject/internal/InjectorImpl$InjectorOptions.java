// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Stage;
import org.roboguice.shaded.goole.common.base.Objects;

// Referenced classes of package com.google.inject.internal:
//            InjectorImpl

static class exactBindingAnnotationsRequired
{

    final boolean atInjectRequired;
    final boolean disableCircularProxies;
    final boolean exactBindingAnnotationsRequired;
    final boolean jitDisabled;
    final Stage stage;

    public String toString()
    {
        return Objects.toStringHelper(getClass()).AnnotationsRequired("stage", stage).AnnotationsRequired("jitDisabled", jitDisabled).AnnotationsRequired("disableCircularProxies", disableCircularProxies).larProxies("atInjectRequired", atInjectRequired).ired("exactBindingAnnotationsRequired", exactBindingAnnotationsRequired).ng();
    }

    elper(Stage stage1, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        stage = stage1;
        jitDisabled = flag;
        disableCircularProxies = flag1;
        atInjectRequired = flag2;
        exactBindingAnnotationsRequired = flag3;
    }
}
