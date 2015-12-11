.class final enum Lcom/amazon/avod/sdk/internal/ItemIntentColumn;
.super Ljava/lang/Enum;
.source "ItemIntentColumn.java"

# interfaces
.implements Lcom/amazon/avod/sdk/internal/IntentColumn;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/avod/sdk/internal/ItemIntentColumn;",
        ">;",
        "Lcom/amazon/avod/sdk/internal/IntentColumn;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

.field public static final enum ADD_TO_WATCHLIST:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

.field public static final enum DESTROY_REACTIVE_WHISPERCACHE:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

.field public static final enum PLAY_VIDEO:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

.field public static final enum PREPARE_PLAYER:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

.field public static final enum PURCHASE:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

.field public static final enum REACTIVE_WHISPERCACHE:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

.field public static final enum REMOVE_FROM_WATCHLIST:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

.field public static final enum SHOW_DETAIL_PAGE:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

.field public static final enum TEARDOWN_PLAYER:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

.field public static final enum WHISPER_CACHE_CONTENT:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;


# instance fields
.field private final mColumnName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 12
    new-instance v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    const-string/jumbo v1, "SHOW_DETAIL_PAGE"

    const-string/jumbo v2, "showDetailPage"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->SHOW_DETAIL_PAGE:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    .line 13
    new-instance v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    const-string/jumbo v1, "PLAY_VIDEO"

    const-string/jumbo v2, "playVideo"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->PLAY_VIDEO:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    .line 14
    new-instance v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    const-string/jumbo v1, "PURCHASE"

    const-string/jumbo v2, "purchase"

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->PURCHASE:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    .line 15
    new-instance v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    const-string/jumbo v1, "ADD_TO_WATCHLIST"

    const-string/jumbo v2, "addToWatchlist"

    invoke-direct {v0, v1, v7, v2}, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->ADD_TO_WATCHLIST:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    .line 16
    new-instance v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    const-string/jumbo v1, "REMOVE_FROM_WATCHLIST"

    const-string/jumbo v2, "removeFromWatchlist"

    invoke-direct {v0, v1, v8, v2}, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->REMOVE_FROM_WATCHLIST:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    .line 17
    new-instance v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    const-string/jumbo v1, "REACTIVE_WHISPERCACHE"

    const/4 v2, 0x5

    const-string/jumbo v3, "reactiveWhispercache"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->REACTIVE_WHISPERCACHE:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    .line 18
    new-instance v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    const-string/jumbo v1, "DESTROY_REACTIVE_WHISPERCACHE"

    const/4 v2, 0x6

    const-string/jumbo v3, "destroyReactiveWhispercache"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->DESTROY_REACTIVE_WHISPERCACHE:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    .line 19
    new-instance v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    const-string/jumbo v1, "WHISPER_CACHE_CONTENT"

    const/4 v2, 0x7

    const-string/jumbo v3, "whisperCacheContent"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->WHISPER_CACHE_CONTENT:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    .line 20
    new-instance v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    const-string/jumbo v1, "PREPARE_PLAYER"

    const/16 v2, 0x8

    const-string/jumbo v3, "preparePlayer"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->PREPARE_PLAYER:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    .line 21
    new-instance v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    const-string/jumbo v1, "TEARDOWN_PLAYER"

    const/16 v2, 0x9

    const-string/jumbo v3, "teardownPlayer"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->TEARDOWN_PLAYER:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    .line 11
    const/16 v0, 0xa

    new-array v0, v0, [Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    sget-object v1, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->SHOW_DETAIL_PAGE:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->PLAY_VIDEO:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->PURCHASE:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->ADD_TO_WATCHLIST:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->REMOVE_FROM_WATCHLIST:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->REACTIVE_WHISPERCACHE:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->DESTROY_REACTIVE_WHISPERCACHE:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->WHISPER_CACHE_CONTENT:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->PREPARE_PLAYER:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->TEARDOWN_PLAYER:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->$VALUES:[Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "columnName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 26
    iput-object p3, p0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->mColumnName:Ljava/lang/String;

    .line 27
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/avod/sdk/internal/ItemIntentColumn;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    return-object v0
.end method

.method public static values()[Lcom/amazon/avod/sdk/internal/ItemIntentColumn;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->$VALUES:[Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    invoke-virtual {v0}, [Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    return-object v0
.end method


# virtual methods
.method public getColumnName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->mColumnName:Ljava/lang/String;

    return-object v0
.end method
