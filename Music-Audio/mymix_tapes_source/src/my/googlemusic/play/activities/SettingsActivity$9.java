// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.DialogInterface;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

// Referenced classes of package my.googlemusic.play.activities:
//            SettingsActivity

class this._cls0
    implements android.content.lickListener
{

    final SettingsActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
        if (SettingsActivity.access$3000(SettingsActivity.this) != null && SettingsActivity.access$3000(SettingsActivity.this).isConnected())
        {
            Plus.AccountApi.clearDefaultAccount(SettingsActivity.access$3000(SettingsActivity.this));
            SettingsActivity.access$3000(SettingsActivity.this).disconnect();
            SettingsActivity.access$3000(SettingsActivity.this).connect();
            Toast.with(SettingsActivity.this).message("Logout from google plus").show();
        }
        SettingsActivity.access$3100(SettingsActivity.this).logout();
        setResult(10000);
        finish();
    }

    ()
    {
        this$0 = SettingsActivity.this;
        super();
    }
}
