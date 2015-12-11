// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;


// Referenced classes of package com.millennialmedia.internal:
//            MMActivity

class this._cls0
    implements android.view.UiVisibilityChangeListener
{

    final MMActivity this$0;

    public void onSystemUiVisibilityChange(int i)
    {
        if ((i & 4) == 0)
        {
            MMActivity.access$600(MMActivity.this);
        }
    }

    geListener()
    {
        this$0 = MMActivity.this;
        super();
    }
}
