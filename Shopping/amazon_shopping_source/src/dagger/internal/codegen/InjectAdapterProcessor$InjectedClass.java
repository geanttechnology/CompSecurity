// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import java.util.List;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

// Referenced classes of package dagger.internal.codegen:
//            InjectAdapterProcessor

static class fields
{

    final ExecutableElement constructor;
    final List fields;
    final List staticFields;
    final TypeElement type;

    (TypeElement typeelement, List list, ExecutableElement executableelement, List list1)
    {
        type = typeelement;
        staticFields = list;
        constructor = executableelement;
        fields = list1;
    }
}
