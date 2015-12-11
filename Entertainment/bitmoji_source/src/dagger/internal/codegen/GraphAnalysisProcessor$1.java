// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.SetBinding;

// Referenced classes of package dagger.internal.codegen:
//            GraphAnalysisProcessor

class this._cls0 extends BindingsGroup
{

    final GraphAnalysisProcessor this$0;

    public Binding contributeSetBinding(String s, SetBinding setbinding)
    {
        return super.put(s, setbinding);
    }

    ()
    {
        this$0 = GraphAnalysisProcessor.this;
        super();
    }
}
