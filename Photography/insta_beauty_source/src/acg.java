// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.inputmethod.InputMethodManager;
import com.fotoable.fotobeauty.ShareEditActivity;
import java.util.TimerTask;

public class acg extends TimerTask
{

    final ShareEditActivity a;

    public acg(ShareEditActivity shareeditactivity)
    {
        a = shareeditactivity;
        super();
    }

    public void run()
    {
        ShareEditActivity shareeditactivity = a;
        ShareEditActivity shareeditactivity1 = a;
        ((InputMethodManager)shareeditactivity.getSystemService("input_method")).toggleSoftInput(0, 2);
    }
}
