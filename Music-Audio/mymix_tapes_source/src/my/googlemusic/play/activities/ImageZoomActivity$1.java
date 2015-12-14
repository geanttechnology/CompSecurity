// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.appbar.AppBar;

// Referenced classes of package my.googlemusic.play.activities:
//            ImageZoomActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final ImageZoomActivity this$0;

    public void onFailure(Response response)
    {
        ImageZoomActivity.access$300(ImageZoomActivity.this, false);
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        obj = (User)((List)obj).get(0);
        String s = ImageZoomActivity.access$100(ImageZoomActivity.this).getLinkUserImage(((User) (obj)).getId());
        Picasso.with(ImageZoomActivity.this).load(s).placeholder(0x7f0201dc).into(ImageZoomActivity.access$200(ImageZoomActivity.this).image);
        ImageZoomActivity.access$200(ImageZoomActivity.this).appBar = AppBar.with(findViewById(0x7f0d0074), ImageZoomActivity.this).back().title(((User) (obj)).getUsername());
        ImageZoomActivity.access$300(ImageZoomActivity.this, false);
    }

    ewHolder()
    {
        this$0 = ImageZoomActivity.this;
        super();
    }
}
