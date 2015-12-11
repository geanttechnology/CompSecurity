// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.internal.gu;
import java.util.Map;
import org.json.JSONObject;

public class wu
{

    private final gu a;
    private final Map b;
    private final Context c;
    private String d;
    private long e;
    private long f;
    private String g;
    private String h;

    public wu(gu gu1, Map map)
    {
        a = gu1;
        b = map;
        c = gu1.k();
        c();
    }

    static Context a(wu wu1)
    {
        return wu1.c;
    }

    private String a(String s)
    {
        if (TextUtils.isEmpty((CharSequence)b.get(s)))
        {
            return "";
        } else
        {
            return (String)b.get(s);
        }
    }

    static gu b(wu wu1)
    {
        return wu1.a;
    }

    private void c()
    {
        d = a("description");
        g = a("summary");
        e = abq.d((String)b.get("start"));
        f = abq.d((String)b.get("end"));
        h = a("location");
    }

    public void a()
    {
        if (!(new ue(c)).f())
        {
            acb.e("This feature is not available on this version of the device.");
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(c);
            builder.setTitle(abi.a(com.google.android.gms.R.string.create_calendar_title, "Create calendar event"));
            builder.setMessage(abi.a(com.google.android.gms.R.string.create_calendar_message, "Allow Ad to create a calendar event?"));
            builder.setPositiveButton(abi.a(com.google.android.gms.R.string.accept, "Accept"), new android.content.DialogInterface.OnClickListener() {

                final wu a;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = a.b();
                    wu.a(a).startActivity(dialoginterface);
                }

            
            {
                a = wu.this;
                super();
            }
            });
            builder.setNegativeButton(abi.a(com.google.android.gms.R.string.decline, "Decline"), new android.content.DialogInterface.OnClickListener() {

                final wu a;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    wu.b(a).b("onCalendarEventCanceled", new JSONObject());
                }

            
            {
                a = wu.this;
                super();
            }
            });
            builder.create().show();
            return;
        }
    }

    Intent b()
    {
        Intent intent = (new Intent("android.intent.action.EDIT")).setData(android.provider.CalendarContract.Events.CONTENT_URI);
        intent.putExtra("title", g);
        intent.putExtra("eventLocation", h);
        intent.putExtra("description", d);
        intent.putExtra("beginTime", e);
        intent.putExtra("endTime", f);
        intent.setFlags(0x10000000);
        return intent;
    }
}
