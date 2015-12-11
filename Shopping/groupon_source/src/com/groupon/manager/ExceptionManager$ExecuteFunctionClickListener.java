// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.DialogInterface;
import com.groupon.util.Function0;

// Referenced classes of package com.groupon.manager:
//            ExceptionManager

protected static class function
    implements android.content.ner
{

    protected final Function0 function;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (function != null)
        {
            function.execute();
        }
    }

    public (Function0 function0)
    {
        function = function0;
    }
}
