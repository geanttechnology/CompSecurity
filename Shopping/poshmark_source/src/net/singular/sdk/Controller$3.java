// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;


// Referenced classes of package net.singular.sdk:
//            Controller, SessionManager

class this._cls0
    implements Runnable
{

    final Controller this$0;

    public void run()
    {
        try
        {
            Controller.access$400(Controller.this).onPause();
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            Controller.access$100(Controller.this, runtimeexception, "onPause runnable");
        }
    }

    r()
    {
        this$0 = Controller.this;
        super();
    }
}
