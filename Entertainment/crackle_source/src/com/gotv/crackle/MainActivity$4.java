// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.Intent;

// Referenced classes of package com.gotv.crackle:
//            MainActivity

class this._cls0
    implements android.widget.oseListener
{

    final MainActivity this$0;

    public boolean onClose()
    {
        Intent intent = new Intent(MainActivity.this, com/gotv/crackle/MainActivity);
        startActivity(intent);
        return false;
    }

    eListener()
    {
        this$0 = MainActivity.this;
        super();
    }
}
