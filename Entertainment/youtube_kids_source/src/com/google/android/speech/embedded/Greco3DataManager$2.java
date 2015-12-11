// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import android.content.Context;
import egf;
import java.io.File;

// Referenced classes of package com.google.android.speech.embedded:
//            Greco3DataManager

class this._cls0
    implements egf
{

    final Greco3DataManager this$0;

    public File get()
    {
        return Greco3DataManager.access$100(Greco3DataManager.this).getDir("g3_models", 0);
    }

    public volatile Object get()
    {
        return get();
    }

    ()
    {
        this$0 = Greco3DataManager.this;
        super();
    }
}
