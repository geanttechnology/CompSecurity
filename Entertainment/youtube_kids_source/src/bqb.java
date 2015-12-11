// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.util.Base64;

public final class bqb
{

    public bri a;

    public bqb()
    {
    }

    public final void a(SharedPreferences sharedpreferences)
    {
        sharedpreferences = sharedpreferences.getString("com.google.android.libraries.youtube.innertube.pref.inner_tube_config", null);
        if (sharedpreferences == null)
        {
            a = new bri();
            return;
        }
        try
        {
            sharedpreferences = Base64.decode(sharedpreferences, 0);
            din din1 = new din();
            eun.a(din1, sharedpreferences);
            a = new bri(din1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SharedPreferences sharedpreferences)
        {
            a = new bri();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SharedPreferences sharedpreferences)
        {
            a = new bri();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SharedPreferences sharedpreferences)
        {
            a = new bri();
        }
    }
}
