// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.content.Context;
import android.widget.CheckBox;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.fragments.SettingsFragment;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class ndler extends MixerBoxAsyncHttpResponseHandler
{

    final ndler.onSuccess this$2;

    public void onFailure(Throwable throwable, String s)
    {
        super.onFailure(throwable, s);
        if (s != null)
        {
            MixerBoxUtils.logMsg(s);
            try
            {
                throwable = new JSONObject(s);
                if (!throwable.isNull("error") && throwable.getJSONObject("error").getString("code").equals("200"))
                {
                    MixerBoxSharedPreferences.putPostFB(_fld0, false);
                    if (fragmentSettings.isAdded())
                    {
                        fragmentSettings.checkbox.setChecked(false);
                        return;
                    }
                }
            }
            // Misplaced declaration of an exception variable
            catch (Throwable throwable)
            {
                throwable.printStackTrace();
                return;
            }
        }
    }

    public void onSuccess(String s)
    {
        super.onSuccess(s);
        MixerBoxUtils.logMsg(s);
    }

    ndler(Context context)
    {
        this$2 = this._cls2.this;
        super(context);
    }
}
