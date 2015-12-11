// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;

public final class cpx
{

    private final SharedPreferences a;
    private boolean b;

    public cpx(SharedPreferences sharedpreferences)
    {
        boolean flag = true;
        super();
        a = sharedpreferences;
        int i = sharedpreferences.getInt("safety_mode", -1);
        if (i != -1)
        {
            if (i == 0)
            {
                flag = false;
            }
            b = flag;
            return;
        }
        switch (sharedpreferences.getInt("safe_search", -1))
        {
        default:
            a(false);
            return;

        case 0: // '\0'
        case 1: // '\001'
            a(false);
            return;

        case 2: // '\002'
            a(true);
            break;
        }
    }

    private void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor;
        if (b == flag)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        b = flag;
        editor = a.edit();
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        editor.putInt("safety_mode", i).apply();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
