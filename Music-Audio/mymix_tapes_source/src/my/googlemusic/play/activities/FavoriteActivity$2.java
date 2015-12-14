// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.widget.TextView;
import java.util.List;
import my.googlemusic.play.adapters.manager.library.LibraryRecyclerAdapter;
import my.googlemusic.play.internet.Response;

// Referenced classes of package my.googlemusic.play.activities:
//            FavoriteActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final FavoriteActivity this$0;

    public void onFailure(Response response)
    {
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        if (obj instanceof List)
        {
            if (((List)obj).size() != 0)
            {
                FavoriteActivity.access$700(FavoriteActivity.this).setFooterEnabled(true);
                FavoriteActivity.access$800(FavoriteActivity.this).addAll((List)obj);
                FavoriteActivity.access$700(FavoriteActivity.this).setData(FavoriteActivity.access$800(FavoriteActivity.this));
            } else
            {
                FavoriteActivity.access$700(FavoriteActivity.this).setFooterEnabled(false);
            }
            ewHolder.access._mth200(FavoriteActivity.access$900(FavoriteActivity.this)).setText((new StringBuilder()).append(FavoriteActivity.access$800(FavoriteActivity.this).size()).append(" Favorited tracks").toString());
            FavoriteActivity.access$700(FavoriteActivity.this).notifyDataSetChanged();
        }
    }

    ewHolder()
    {
        this$0 = FavoriteActivity.this;
        super();
    }
}
