// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stericson.RootTools;


// Referenced classes of package com.stericson.RootTools:
//            SanityCheckRootTools

class this._cls1 extends this._cls1
{

    final this._cls1 this$1;

    public void onComplete(int i)
    {
        cess._mth0(this._cls1.this, 3, "------\nDone.\n");
    }

    public void onFailure(Exception exception)
    {
        cess._mth0(this._cls1.this, 2, (new StringBuilder("ERROR: ")).append(exception).toString());
        setError(1);
    }

    public void process(String s)
        throws Exception
    {
        cess._mth0(this._cls1.this, 3, (new StringBuilder(String.valueOf(s))).append("\n").toString());
    }

    public void processError(String s)
        throws Exception
    {
        cess._mth0(this._cls1.this, 3, (new StringBuilder(String.valueOf(s))).append("\n").toString());
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
