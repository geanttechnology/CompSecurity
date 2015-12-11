// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;

import android.content.Context;

// Referenced classes of package bolts:
//            Continuation, AppLinkNavigation, Task, AppLink

final class val.context
    implements Continuation
{

    final Context val$context;

    public vigationResult then(Task task)
    {
        return AppLinkNavigation.navigate(val$context, (AppLink)task.getResult());
    }

    public volatile Object then(Task task)
    {
        return then(task);
    }

    vigationResult()
    {
        val$context = context1;
        super();
    }
}
