// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import javax.lang.model.element.ElementKind;
import javax.lang.model.type.TypeKind;

// Referenced classes of package dagger.internal.codegen:
//            Util

static class tKind
{

    static final int $SwitchMap$javax$lang$model$element$ElementKind[];
    static final int $SwitchMap$javax$lang$model$type$TypeKind[];

    static 
    {
        $SwitchMap$javax$lang$model$type$TypeKind = new int[TypeKind.values().length];
        try
        {
            $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.BYTE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.SHORT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.INT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.LONG.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.FLOAT.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.DOUBLE.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.BOOLEAN.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.CHAR.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.VOID.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        $SwitchMap$javax$lang$model$element$ElementKind = new int[ElementKind.values().length];
        try
        {
            $SwitchMap$javax$lang$model$element$ElementKind[ElementKind.FIELD.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$javax$lang$model$element$ElementKind[ElementKind.CONSTRUCTOR.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$javax$lang$model$element$ElementKind[ElementKind.METHOD.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
