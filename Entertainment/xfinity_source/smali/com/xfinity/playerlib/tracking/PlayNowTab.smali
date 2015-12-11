.class public final enum Lcom/xfinity/playerlib/tracking/PlayNowTab;
.super Ljava/lang/Enum;
.source "PlayNowTab.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xfinity/playerlib/tracking/PlayNowTab;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xfinity/playerlib/tracking/PlayNowTab;

.field public static final enum BOOKMARKS:Lcom/xfinity/playerlib/tracking/PlayNowTab;

.field public static final enum DOWNLOADS:Lcom/xfinity/playerlib/tracking/PlayNowTab;

.field public static final enum FEATURED:Lcom/xfinity/playerlib/tracking/PlayNowTab;

.field public static final enum HISTORY:Lcom/xfinity/playerlib/tracking/PlayNowTab;

.field public static final enum KIDS:Lcom/xfinity/playerlib/tracking/PlayNowTab;

.field public static final enum LIVE:Lcom/xfinity/playerlib/tracking/PlayNowTab;

.field public static final enum MOVIES:Lcom/xfinity/playerlib/tracking/PlayNowTab;

.field public static final enum NETWORKS:Lcom/xfinity/playerlib/tracking/PlayNowTab;

.field public static final enum SETTINGS:Lcom/xfinity/playerlib/tracking/PlayNowTab;

.field public static final enum TV_SERIES:Lcom/xfinity/playerlib/tracking/PlayNowTab;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 5
    new-instance v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;

    const-string v1, "MOVIES"

    invoke-direct {v0, v1, v3}, Lcom/xfinity/playerlib/tracking/PlayNowTab;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;->MOVIES:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    .line 6
    new-instance v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;

    const-string v1, "TV_SERIES"

    invoke-direct {v0, v1, v4}, Lcom/xfinity/playerlib/tracking/PlayNowTab;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;->TV_SERIES:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    .line 7
    new-instance v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;

    const-string v1, "HISTORY"

    invoke-direct {v0, v1, v5}, Lcom/xfinity/playerlib/tracking/PlayNowTab;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;->HISTORY:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    .line 8
    new-instance v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;

    const-string v1, "FEATURED"

    invoke-direct {v0, v1, v6}, Lcom/xfinity/playerlib/tracking/PlayNowTab;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;->FEATURED:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    .line 9
    new-instance v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;

    const-string v1, "NETWORKS"

    invoke-direct {v0, v1, v7}, Lcom/xfinity/playerlib/tracking/PlayNowTab;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;->NETWORKS:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    .line 10
    new-instance v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;

    const-string v1, "SETTINGS"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowTab;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;->SETTINGS:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    .line 11
    new-instance v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;

    const-string v1, "DOWNLOADS"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowTab;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;->DOWNLOADS:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    .line 12
    new-instance v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;

    const-string v1, "BOOKMARKS"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowTab;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;->BOOKMARKS:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    .line 13
    new-instance v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;

    const-string v1, "KIDS"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowTab;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;->KIDS:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    .line 14
    new-instance v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;

    const-string v1, "LIVE"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowTab;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;->LIVE:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    .line 3
    const/16 v0, 0xa

    new-array v0, v0, [Lcom/xfinity/playerlib/tracking/PlayNowTab;

    sget-object v1, Lcom/xfinity/playerlib/tracking/PlayNowTab;->MOVIES:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    aput-object v1, v0, v3

    sget-object v1, Lcom/xfinity/playerlib/tracking/PlayNowTab;->TV_SERIES:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    aput-object v1, v0, v4

    sget-object v1, Lcom/xfinity/playerlib/tracking/PlayNowTab;->HISTORY:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    aput-object v1, v0, v5

    sget-object v1, Lcom/xfinity/playerlib/tracking/PlayNowTab;->FEATURED:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    aput-object v1, v0, v6

    sget-object v1, Lcom/xfinity/playerlib/tracking/PlayNowTab;->NETWORKS:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/xfinity/playerlib/tracking/PlayNowTab;->SETTINGS:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/xfinity/playerlib/tracking/PlayNowTab;->DOWNLOADS:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/xfinity/playerlib/tracking/PlayNowTab;->BOOKMARKS:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/xfinity/playerlib/tracking/PlayNowTab;->KIDS:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/xfinity/playerlib/tracking/PlayNowTab;->LIVE:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    aput-object v2, v0, v1

    sput-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;->$VALUES:[Lcom/xfinity/playerlib/tracking/PlayNowTab;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 3
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 41
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/tracking/PlayNowTab;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 3
    const-class v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;

    return-object v0
.end method

.method public static values()[Lcom/xfinity/playerlib/tracking/PlayNowTab;
    .locals 1

    .prologue
    .line 3
    sget-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTab;->$VALUES:[Lcom/xfinity/playerlib/tracking/PlayNowTab;

    invoke-virtual {v0}, [Lcom/xfinity/playerlib/tracking/PlayNowTab;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xfinity/playerlib/tracking/PlayNowTab;

    return-object v0
.end method


# virtual methods
.method getTabName()Ljava/lang/String;
    .locals 2

    .prologue
    .line 19
    sget-object v0, Lcom/xfinity/playerlib/tracking/PlayNowTab$1;->$SwitchMap$com$xfinity$playerlib$tracking$PlayNowTab:[I

    invoke-virtual {p0}, Lcom/xfinity/playerlib/tracking/PlayNowTab;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 41
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 21
    :pswitch_0
    const-string v0, "Movies"

    .line 39
    :goto_0
    return-object v0

    .line 23
    :pswitch_1
    const-string v0, "TV Series"

    goto :goto_0

    .line 25
    :pswitch_2
    const-string v0, "History"

    goto :goto_0

    .line 27
    :pswitch_3
    const-string v0, "Featured"

    goto :goto_0

    .line 29
    :pswitch_4
    const-string v0, "Networks"

    goto :goto_0

    .line 31
    :pswitch_5
    const-string v0, "Settings"

    goto :goto_0

    .line 33
    :pswitch_6
    const-string v0, "Downloads"

    goto :goto_0

    .line 35
    :pswitch_7
    const-string v0, "Bookmarks"

    goto :goto_0

    .line 37
    :pswitch_8
    const-string v0, "Kids"

    goto :goto_0

    .line 39
    :pswitch_9
    const-string v0, "Live"

    goto :goto_0

    .line 19
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
    .end packed-switch
.end method
