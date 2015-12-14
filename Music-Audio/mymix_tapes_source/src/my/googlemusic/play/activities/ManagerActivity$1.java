// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.utils.dialog.DialogUpdate;

// Referenced classes of package my.googlemusic.play.activities:
//            ManagerActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final ManagerActivity this$0;

    public void onFailure(Response response)
    {
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        int i;
        try
        {
            i = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        }
        catch (android.content.pm.eNotFoundException enotfoundexception)
        {
            i = 0x3b9ac9ff;
            enotfoundexception.printStackTrace();
        }
        if (obj.toString().equals(""))
        {
            obj = "0";
        } else
        {
            obj = obj.toString();
        }
        if (Integer.parseInt(((String) (obj))) > i)
        {
            (new DialogUpdate()).show(getSupportFragmentManager(), null);
        }
    }

    eption()
    {
        this$0 = ManagerActivity.this;
        super();
    }
}
