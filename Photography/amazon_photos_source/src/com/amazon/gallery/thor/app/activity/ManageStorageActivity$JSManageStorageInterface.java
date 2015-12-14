// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;


// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ManageStorageActivity

private class <init>
{

    final ManageStorageActivity this$0;

    public void campaignReady()
    {
        runOnUiThread(new Runnable() {

            final ManageStorageActivity.JSManageStorageInterface this$1;

            public void run()
            {
                onPageReady();
            }

            
            {
                this$1 = ManageStorageActivity.JSManageStorageInterface.this;
                super();
            }
        });
    }

    public void close()
    {
        finish();
    }

    private _cls1.this._cls1()
    {
        this$0 = ManageStorageActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
