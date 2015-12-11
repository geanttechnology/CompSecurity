// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;


// Referenced classes of package com.gotv.crackle:
//            MainActivity

class this._cls0
    implements android.widget.eryTextListener
{

    final MainActivity this$0;

    public boolean onQueryTextChange(String s)
    {
        if (s.length() < 3)
        {
            return false;
        } else
        {
            MainActivity.access$400(MainActivity.this, s);
            return true;
        }
    }

    public boolean onQueryTextSubmit(String s)
    {
        MainActivity.access$400(MainActivity.this, s);
        return true;
    }

    yTextListener()
    {
        this$0 = MainActivity.this;
        super();
    }
}
