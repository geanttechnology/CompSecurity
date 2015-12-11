// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.ViewGroup;
import android.widget.ImageButton;

// Referenced classes of package com.amazon.device.ads:
//            MraidBrowser, Assets

class buttonHeight extends AsyncTask
{

    private final int buttonHeight;
    private final int buttonWidth;
    private final Intent intent;
    private final ViewGroup layout;
    final MraidBrowser this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        MraidBrowser.access$302(MraidBrowser.this, MraidBrowser.access$400(MraidBrowser.this, Assets.getInstance().getFilePath("amazon_ads_leftarrow.png"), 9, -1, buttonWidth, buttonHeight));
        MraidBrowser.access$300(MraidBrowser.this).setId(10537);
        MraidBrowser.access$502(MraidBrowser.this, MraidBrowser.access$400(MraidBrowser.this, Assets.getInstance().getFilePath("amazon_ads_rightarrow.png"), 1, MraidBrowser.access$300(MraidBrowser.this).getId(), buttonWidth, buttonHeight));
        MraidBrowser.access$500(MraidBrowser.this).setId(10794);
        MraidBrowser.access$602(MraidBrowser.this, MraidBrowser.access$400(MraidBrowser.this, Assets.getInstance().getFilePath("amazon_ads_close.png"), 11, -1, buttonWidth, buttonHeight));
        if (MraidBrowser.access$700(MraidBrowser.this))
        {
            MraidBrowser.access$802(MraidBrowser.this, MraidBrowser.access$400(MraidBrowser.this, Assets.getInstance().getFilePath("amazon_ads_open_external_browser.png"), 1, MraidBrowser.access$500(MraidBrowser.this).getId(), buttonWidth, buttonHeight));
            MraidBrowser.access$800(MraidBrowser.this).setId(10795);
            MraidBrowser.access$902(MraidBrowser.this, MraidBrowser.access$400(MraidBrowser.this, Assets.getInstance().getFilePath("amazon_ads_refresh.png"), 1, MraidBrowser.access$800(MraidBrowser.this).getId(), buttonWidth, buttonHeight));
        } else
        {
            MraidBrowser.access$902(MraidBrowser.this, MraidBrowser.access$400(MraidBrowser.this, Assets.getInstance().getFilePath("amazon_ads_refresh.png"), 1, MraidBrowser.access$500(MraidBrowser.this).getId(), buttonWidth, buttonHeight));
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        layout.addView(MraidBrowser.access$300(MraidBrowser.this));
        layout.addView(MraidBrowser.access$500(MraidBrowser.this));
        layout.addView(MraidBrowser.access$900(MraidBrowser.this));
        layout.addView(MraidBrowser.access$600(MraidBrowser.this));
        if (MraidBrowser.access$700(MraidBrowser.this))
        {
            layout.addView(MraidBrowser.access$800(MraidBrowser.this));
        }
        MraidBrowser.access$1000(MraidBrowser.this, intent);
    }

    public (Intent intent1, ViewGroup viewgroup, int i, int j)
    {
        this$0 = MraidBrowser.this;
        super();
        intent = intent1;
        layout = viewgroup;
        buttonWidth = i;
        buttonHeight = j;
    }
}
