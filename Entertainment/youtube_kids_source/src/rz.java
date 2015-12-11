// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class rz
    implements android.media.AudioManager.OnAudioFocusChangeListener
{

    private rx a;

    rz(rx rx1)
    {
        a = rx1;
        super();
    }

    public final void onAudioFocusChange(int i)
    {
        switch (i)
        {
        case 0: // '\0'
        default:
            return;

        case -2: 
        case -1: 
            a.i();
            a.h = false;
            return;

        case -3: 
            a.a(0.1F);
            a.h = false;
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            a.h = true;
            break;
        }
        a.a(1.0F);
    }
}
