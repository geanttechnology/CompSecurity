// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            add

static final class a
    implements Runnable
{

    final android.content.Preferences.Editor a;

    public void run()
    {
        a.commit();
    }

    es.Editor(android.content.Preferences.Editor editor)
    {
        a = editor;
        super();
    }
}
