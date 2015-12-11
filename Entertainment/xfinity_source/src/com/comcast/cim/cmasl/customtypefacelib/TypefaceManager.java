// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.customtypefacelib;

import android.graphics.Typeface;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.comcast.cim.cmasl.customtypefacelib:
//            TypefaceFamily

public class TypefaceManager
{

    private Map familyMap;

    public TypefaceManager()
    {
        familyMap = new HashMap();
    }

    public void addTypefaceFamily(String s, TypefaceFamily typefacefamily)
    {
        familyMap.put(s, typefacefamily);
    }

    public Typeface getTypeface(String s, int i)
    {
        return ((TypefaceFamily)familyMap.get(s)).getTypeface(i);
    }
}
