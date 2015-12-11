// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.record;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.mcc.record:
//            BasicRecorder, RecordableContext

public final class  extends Binding
    implements Provider
{

    private Binding context;

    public void attach(Linker linker)
    {
        context = linker.requestBinding("com.amazon.mcc.record.RecordableContext", com/amazon/mcc/record/BasicRecorder, getClass().getClassLoader());
    }

    public BasicRecorder get()
    {
        return new BasicRecorder((RecordableContext)context.get());
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(context);
    }

    public ()
    {
        super("com.amazon.mcc.record.BasicRecorder", "members/com.amazon.mcc.record.BasicRecorder", false, com/amazon/mcc/record/BasicRecorder);
    }
}
