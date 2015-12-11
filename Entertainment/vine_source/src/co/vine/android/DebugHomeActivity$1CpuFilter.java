// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

// Referenced classes of package co.vine.android:
//            DebugHomeActivity

class this._cls0
    implements FileFilter
{

    final DebugHomeActivity this$0;

    public boolean accept(File file)
    {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }

    ()
    {
        this$0 = DebugHomeActivity.this;
        super();
    }
}
