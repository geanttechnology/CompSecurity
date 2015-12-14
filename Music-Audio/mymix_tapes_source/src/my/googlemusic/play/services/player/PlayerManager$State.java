// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.services.player;


// Referenced classes of package my.googlemusic.play.services.player:
//            PlayerManager

public static final class  extends Enum
{

    private static final COMPLETED $VALUES[];
    public static final COMPLETED COMPLETED;
    public static final COMPLETED IDLE;
    public static final COMPLETED PAUSED;
    public static final COMPLETED PLAYING;
    public static final COMPLETED PREPARED;
    public static final COMPLETED PREPARING;
    public static final COMPLETED RESUMED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(my/googlemusic/play/services/player/PlayerManager$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        IDLE = new <init>("IDLE", 0);
        PREPARING = new <init>("PREPARING", 1);
        PREPARED = new <init>("PREPARED", 2);
        PLAYING = new <init>("PLAYING", 3);
        PAUSED = new <init>("PAUSED", 4);
        RESUMED = new <init>("RESUMED", 5);
        COMPLETED = new <init>("COMPLETED", 6);
        $VALUES = (new .VALUES[] {
            IDLE, PREPARING, PREPARED, PLAYING, PAUSED, RESUMED, COMPLETED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
