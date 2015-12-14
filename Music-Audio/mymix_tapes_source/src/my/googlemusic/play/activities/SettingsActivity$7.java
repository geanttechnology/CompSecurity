// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.net.Uri;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;
import my.googlemusic.play.utils.transformations.CropSquareTransformation;

// Referenced classes of package my.googlemusic.play.activities:
//            SettingsActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final SettingsActivity this$0;

    public void onFailure(Response response)
    {
        if (response.getStatus() == 7)
        {
            Toast.with(SettingsActivity.this).message(response.getContent()).show();
        }
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        Picasso.with(SettingsActivity.this).load((Uri)obj).placeholder(0x7f0201db).fit().centerCrop().transform(new CropSquareTransformation()).skipMemoryCache().into(ewHolder.access._mth1700(SettingsActivity.access$2800(SettingsActivity.this)));
        setResult(12000);
    }

    ewHolder()
    {
        this$0 = SettingsActivity.this;
        super();
    }
}
