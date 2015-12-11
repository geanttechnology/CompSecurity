// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication;


// Referenced classes of package amazon.communication:
//            Priority

static class 
{

    static final int $SwitchMap$amazon$communication$Priority[];

    static 
    {
        $SwitchMap$amazon$communication$Priority = new int[Priority.values().length];
        try
        {
            $SwitchMap$amazon$communication$Priority[Priority.PRIORITY_HIGH.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$amazon$communication$Priority[Priority.PRIORITY_NORMAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
