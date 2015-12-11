// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import javax.lang.model.element.ElementKind;

// Referenced classes of package dagger.internal.codegen:
//            ValidationProcessor

static class 
{

    static final int $SwitchMap$javax$lang$model$element$ElementKind[];

    static 
    {
        $SwitchMap$javax$lang$model$element$ElementKind = new int[ElementKind.values().length];
        try
        {
            $SwitchMap$javax$lang$model$element$ElementKind[ElementKind.FIELD.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$javax$lang$model$element$ElementKind[ElementKind.METHOD.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$javax$lang$model$element$ElementKind[ElementKind.PARAMETER.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$javax$lang$model$element$ElementKind[ElementKind.CLASS.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
