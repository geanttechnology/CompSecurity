// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;


// Referenced classes of package android.support.v4.app:
//            ch, cw

final class cc
{

    public static void a(android.app.Notification.Builder builder, ch ch1)
    {
        android.app.Notification.Action.Builder builder1 = new android.app.Notification.Action.Builder(ch1.a(), ch1.b(), ch1.c());
        if (ch1.e() != null)
        {
            android.app.RemoteInput aremoteinput[] = cw.a(ch1.e());
            int j = aremoteinput.length;
            for (int i = 0; i < j; i++)
            {
                builder1.addRemoteInput(aremoteinput[i]);
            }

        }
        if (ch1.d() != null)
        {
            builder1.addExtras(ch1.d());
        }
        builder.addAction(builder1.build());
    }
}
