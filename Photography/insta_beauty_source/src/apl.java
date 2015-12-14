// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.CompoundButton;

class apl
    implements android.widget.CompoundButton.OnCheckedChangeListener
{

    final api a;

    apl(api api1)
    {
        a = api1;
        super();
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        api.c(a).onCheckedChanged(compoundbutton, flag);
    }
}
