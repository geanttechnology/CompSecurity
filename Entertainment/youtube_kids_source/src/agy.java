// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.speech.EngineSelector;
import java.util.List;

final class agy
    implements EngineSelector
{

    agy(agw agw)
    {
    }

    public final List getEngineList()
    {
        java.util.ArrayList arraylist = a.f(2);
        arraylist.add(Integer.valueOf(2));
        arraylist.add(Integer.valueOf(1));
        return arraylist;
    }

    public final int getPrimaryEngine()
    {
        return 2;
    }

    public final int getSecondaryEngine()
    {
        return 1;
    }
}
