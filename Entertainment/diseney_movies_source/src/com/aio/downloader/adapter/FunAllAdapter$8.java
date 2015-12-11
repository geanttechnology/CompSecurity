// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.aio.downloader.model.FunModel;
import com.aio.downloader.utils.publicTools;
import java.util.List;

// Referenced classes of package com.aio.downloader.adapter:
//            FunAllAdapter

class val.position
    implements android.view.ener
{

    final FunAllAdapter this$0;
    private String url_like;
    private final int val$position;

    public void onClick(View view)
    {
        url_like = (new StringBuilder("http://welaf.com/fun/stat.php?type=like&serial=")).append(((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getSerial()).toString();
        (new Thread() {

            final FunAllAdapter._cls8 this$1;

            public void run()
            {
                super.run();
                Log.e("www", (new StringBuilder("url=+")).append(url_like).toString());
                publicTools.getUrl(url_like);
            }

            
            {
                this$1 = FunAllAdapter._cls8.this;
                super();
            }
        }).start();
        if (!((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).isLikenum())
        {
            ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).setLikenum(true);
            ((ImageView)view).setImageResource(0x7f0200bd);
            return;
        } else
        {
            ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).setLikenum(false);
            ((ImageView)view).setImageResource(0x7f0200bc);
            return;
        }
    }


    _cls1.this._cls1()
    {
        this$0 = final_funalladapter;
        val$position = I.this;
        super();
    }
}
