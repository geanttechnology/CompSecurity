// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ci;

import android.content.Context;
import com.photo.effect.Effect;
import com.socialin.android.photo.effects.factory.EffectsFactory;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{

    public String a;
    public boolean b;
    private String c;

    public b(JSONObject jsonobject)
    {
        try
        {
            a = jsonobject.getString("name");
            if (jsonobject.has("effect_info_assetsPath"))
            {
                c = jsonobject.getString("effect_info_assetsPath");
            }
            b = jsonobject.getBoolean("contains_effect");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
        }
    }

    public final Effect a(Context context)
    {
        if (c != null)
        {
            return EffectsFactory.getEffectFromAssets(context, c);
        } else
        {
            return null;
        }
    }
}
