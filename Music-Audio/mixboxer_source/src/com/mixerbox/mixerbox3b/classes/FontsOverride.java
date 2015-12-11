// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.content.Context;
import android.graphics.Typeface;
import java.lang.reflect.Field;

public final class FontsOverride
{

    public FontsOverride()
    {
    }

    protected static void replaceFont(String s, Typeface typeface)
    {
        try
        {
            s = android/graphics/Typeface.getDeclaredField(s);
            s.setAccessible(true);
            s.set(null, typeface);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public static void setDefaultFont(Context context, String s, String s1)
    {
        replaceFont(s, Typeface.createFromAsset(context.getAssets(), s1));
    }
}
