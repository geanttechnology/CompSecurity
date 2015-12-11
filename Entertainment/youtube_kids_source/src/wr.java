// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.EditText;
import com.google.android.apps.youtube.kids.activities.DebugOnlineAdActivity;

public final class wr
    implements android.content.DialogInterface.OnClickListener
{

    private EditText a;
    private boolean b;
    private DebugOnlineAdActivity c;

    public wr(DebugOnlineAdActivity debugonlineadactivity, EditText edittext, boolean flag)
    {
        c = debugonlineadactivity;
        a = edittext;
        b = flag;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        String s = a.getText().toString();
        if (b)
        {
            dialoginterface = DebugOnlineAdActivity.j(c);
        } else
        {
            dialoginterface = DebugOnlineAdActivity.k(c);
        }
        dialoginterface.setText(a.getText());
        if (!TextUtils.isEmpty(s))
        {
            if (b)
            {
                DebugOnlineAdActivity.b(c).a.edit().putString("forceWatchAdUrl", (String)b.a(s)).commit();
                return;
            } else
            {
                DebugOnlineAdActivity.b(c).a.edit().putString("forceBrowseAdUrl", (String)b.a(s)).commit();
                return;
            }
        }
        if (b)
        {
            DebugOnlineAdActivity.b(c).a.edit().remove("forceWatchAdUrl").commit();
            return;
        } else
        {
            DebugOnlineAdActivity.b(c).a.edit().remove("forceBrowseAdUrl").commit();
            return;
        }
    }
}
