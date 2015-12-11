// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.for;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import io.presage.actions.AddAdShortcut;
import io.presage.actions.NewAction;
import io.presage.actions.RemoveAdShortcut;
import io.presage.actions.j;
import io.presage.if.a;
import io.presage.if.b;
import io.presage.if.c;
import io.presage.if.e;
import io.presage.model.Parameter;
import java.util.Locale;
import shared_presage.com.google.gson.Gson;
import shared_presage.com.google.gson.GsonBuilder;

// Referenced classes of package io.presage.for:
//            m

public final class l
{

    private Context a;

    public l(Context context)
    {
        a = context;
    }

    public final void execute(String s, String s1)
    {
        j.a();
        s = j.a(s);
        if (s != null)
        {
            ((NewAction)(new GsonBuilder()).registerTypeAdapter(io/presage/model/Parameter, new c()).registerTypeAdapter((new m(this)).getType(), new b()).registerTypeAdapter(io/presage/actions/AddAdShortcut, new a(a)).registerTypeAdapter(io/presage/actions/RemoveAdShortcut, new e(a)).create().fromJson(s1, s.a())).execute();
        }
    }

    public final String getLocale()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Object obj;
        String s;
        obj = a.getResources().getConfiguration().locale;
        s = ((Locale) (obj)).getLanguage();
        if (s.length() != 2) goto _L2; else goto _L1
_L1:
        stringbuilder.append(s);
        obj = ((Locale) (obj)).getCountry();
        if (((String) (obj)).length() == 2)
        {
            stringbuilder.append("_");
            stringbuilder.append(((String) (obj)));
        }
_L4:
        return stringbuilder.toString();
_L2:
        try
        {
            stringbuilder.append("en");
        }
        catch (Exception exception)
        {
            if (stringbuilder.length() == 0)
            {
                stringbuilder.append("en");
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final String getOrientation()
    {
        switch (a.getResources().getConfiguration().orientation)
        {
        default:
            return "unknown";

        case 2: // '\002'
            return "landscape";

        case 1: // '\001'
            return "portrait";
        }
    }

    public final String getVersion()
    {
        return "1.7.3";
    }
}
