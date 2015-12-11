// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;


// Referenced classes of package com.amazon.avod.sdk.internal:
//            IntentColumn

final class ItemIntentColumn extends Enum
    implements IntentColumn
{

    private static final ItemIntentColumn $VALUES[];
    public static final ItemIntentColumn ADD_TO_WATCHLIST;
    public static final ItemIntentColumn DESTROY_REACTIVE_WHISPERCACHE;
    public static final ItemIntentColumn PLAY_VIDEO;
    public static final ItemIntentColumn PREPARE_PLAYER;
    public static final ItemIntentColumn PURCHASE;
    public static final ItemIntentColumn REACTIVE_WHISPERCACHE;
    public static final ItemIntentColumn REMOVE_FROM_WATCHLIST;
    public static final ItemIntentColumn SHOW_DETAIL_PAGE;
    public static final ItemIntentColumn TEARDOWN_PLAYER;
    public static final ItemIntentColumn WHISPER_CACHE_CONTENT;
    private final String mColumnName;

    private ItemIntentColumn(String s, int i, String s1)
    {
        super(s, i);
        mColumnName = s1;
    }

    public static ItemIntentColumn valueOf(String s)
    {
        return (ItemIntentColumn)Enum.valueOf(com/amazon/avod/sdk/internal/ItemIntentColumn, s);
    }

    public static ItemIntentColumn[] values()
    {
        return (ItemIntentColumn[])$VALUES.clone();
    }

    public String getColumnName()
    {
        return mColumnName;
    }

    static 
    {
        SHOW_DETAIL_PAGE = new ItemIntentColumn("SHOW_DETAIL_PAGE", 0, "showDetailPage");
        PLAY_VIDEO = new ItemIntentColumn("PLAY_VIDEO", 1, "playVideo");
        PURCHASE = new ItemIntentColumn("PURCHASE", 2, "purchase");
        ADD_TO_WATCHLIST = new ItemIntentColumn("ADD_TO_WATCHLIST", 3, "addToWatchlist");
        REMOVE_FROM_WATCHLIST = new ItemIntentColumn("REMOVE_FROM_WATCHLIST", 4, "removeFromWatchlist");
        REACTIVE_WHISPERCACHE = new ItemIntentColumn("REACTIVE_WHISPERCACHE", 5, "reactiveWhispercache");
        DESTROY_REACTIVE_WHISPERCACHE = new ItemIntentColumn("DESTROY_REACTIVE_WHISPERCACHE", 6, "destroyReactiveWhispercache");
        WHISPER_CACHE_CONTENT = new ItemIntentColumn("WHISPER_CACHE_CONTENT", 7, "whisperCacheContent");
        PREPARE_PLAYER = new ItemIntentColumn("PREPARE_PLAYER", 8, "preparePlayer");
        TEARDOWN_PLAYER = new ItemIntentColumn("TEARDOWN_PLAYER", 9, "teardownPlayer");
        $VALUES = (new ItemIntentColumn[] {
            SHOW_DETAIL_PAGE, PLAY_VIDEO, PURCHASE, ADD_TO_WATCHLIST, REMOVE_FROM_WATCHLIST, REACTIVE_WHISPERCACHE, DESTROY_REACTIVE_WHISPERCACHE, WHISPER_CACHE_CONTENT, PREPARE_PLAYER, TEARDOWN_PLAYER
        });
    }
}
