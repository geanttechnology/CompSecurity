// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.toast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.security.InvalidParameterException;

public class ToastCreator
{

    static final boolean $assertionsDisabled;
    private Context context;
    private String message;

    protected ToastCreator(Context context1)
    {
        context = context1;
    }

    public ToastCreator message(String s)
    {
        message = s;
        return this;
    }

    public void show()
    {
        if (message == null)
        {
            throw new InvalidParameterException("Message should be called before to show.");
        }
        View view = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f030096, null);
        if (!$assertionsDisabled && view == null)
        {
            throw new AssertionError();
        } else
        {
            ((TextView)view.findViewById(0x7f0d0311)).setText(message);
            Toast toast = new Toast(context);
            toast.setDuration(0);
            toast.setView(view);
            toast.show();
            return;
        }
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/utils/toast/ToastCreator.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
