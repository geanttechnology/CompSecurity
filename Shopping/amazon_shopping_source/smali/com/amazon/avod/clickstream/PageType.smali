.class public final enum Lcom/amazon/avod/clickstream/PageType;
.super Ljava/lang/Enum;
.source "PageType.java"

# interfaces
.implements Lcom/amazon/avod/clickstream/ClickstreamParam;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/avod/clickstream/PageType;",
        ">;",
        "Lcom/amazon/avod/clickstream/ClickstreamParam;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/avod/clickstream/PageType;

.field public static final enum BROWSE:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum DETAIL:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum DISPATCH:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum FEEDBACK:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum FSK18:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum GEN5_FTUE_TUTORIAL:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum HELP:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum HOME:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum IMDB:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum ITEM_MENU:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum LIBRARY:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum LOGIN:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum PLAYER:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum PRIME_SIGNUP:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum SEARCH:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum SECOND_SCREEN:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum SETTINGS:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum SETUP:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum SWITCH_ACCOUNT:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum WATCHLIST:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum WEBVIEW:Lcom/amazon/avod/clickstream/PageType;

.field public static final enum XRAY:Lcom/amazon/avod/clickstream/PageType;


# instance fields
.field private final mReportableString:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 21
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "HOME"

    const-string/jumbo v2, "Home"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->HOME:Lcom/amazon/avod/clickstream/PageType;

    .line 22
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "BROWSE"

    const-string/jumbo v2, "Browse"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->BROWSE:Lcom/amazon/avod/clickstream/PageType;

    .line 23
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "DETAIL"

    const-string/jumbo v2, "Detail"

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->DETAIL:Lcom/amazon/avod/clickstream/PageType;

    .line 24
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "LIBRARY"

    const-string/jumbo v2, "Library"

    invoke-direct {v0, v1, v7, v2}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->LIBRARY:Lcom/amazon/avod/clickstream/PageType;

    .line 25
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "WATCHLIST"

    const-string/jumbo v2, "Watchlist"

    invoke-direct {v0, v1, v8, v2}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->WATCHLIST:Lcom/amazon/avod/clickstream/PageType;

    .line 26
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "SEARCH"

    const/4 v2, 0x5

    const-string/jumbo v3, "Search"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->SEARCH:Lcom/amazon/avod/clickstream/PageType;

    .line 29
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "PLAYER"

    const/4 v2, 0x6

    const-string/jumbo v3, "Player"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->PLAYER:Lcom/amazon/avod/clickstream/PageType;

    .line 31
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "SECOND_SCREEN"

    const/4 v2, 0x7

    const-string/jumbo v3, "2ndScreen"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->SECOND_SCREEN:Lcom/amazon/avod/clickstream/PageType;

    .line 34
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "IMDB"

    const/16 v2, 0x8

    const-string/jumbo v3, "Imdb"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->IMDB:Lcom/amazon/avod/clickstream/PageType;

    .line 36
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "XRAY"

    const/16 v2, 0x9

    const-string/jumbo v3, "Xray"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->XRAY:Lcom/amazon/avod/clickstream/PageType;

    .line 38
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "DISPATCH"

    const/16 v2, 0xa

    const-string/jumbo v3, "Dispatch"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->DISPATCH:Lcom/amazon/avod/clickstream/PageType;

    .line 39
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "SETTINGS"

    const/16 v2, 0xb

    const-string/jumbo v3, "Settings"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->SETTINGS:Lcom/amazon/avod/clickstream/PageType;

    .line 40
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "LOGIN"

    const/16 v2, 0xc

    const-string/jumbo v3, "Login"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->LOGIN:Lcom/amazon/avod/clickstream/PageType;

    .line 41
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "WEBVIEW"

    const/16 v2, 0xd

    const-string/jumbo v3, "webview"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->WEBVIEW:Lcom/amazon/avod/clickstream/PageType;

    .line 42
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "HELP"

    const/16 v2, 0xe

    const-string/jumbo v3, "Help"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->HELP:Lcom/amazon/avod/clickstream/PageType;

    .line 43
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "ITEM_MENU"

    const/16 v2, 0xf

    const-string/jumbo v3, "ItemMenu"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->ITEM_MENU:Lcom/amazon/avod/clickstream/PageType;

    .line 44
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "PRIME_SIGNUP"

    const/16 v2, 0x10

    const-string/jumbo v3, "PrimeSignUp"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->PRIME_SIGNUP:Lcom/amazon/avod/clickstream/PageType;

    .line 45
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "FEEDBACK"

    const/16 v2, 0x11

    const-string/jumbo v3, "Feedback"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->FEEDBACK:Lcom/amazon/avod/clickstream/PageType;

    .line 46
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "GEN5_FTUE_TUTORIAL"

    const/16 v2, 0x12

    const-string/jumbo v3, "Gen5Ftue"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->GEN5_FTUE_TUTORIAL:Lcom/amazon/avod/clickstream/PageType;

    .line 47
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "SWITCH_ACCOUNT"

    const/16 v2, 0x13

    const-string/jumbo v3, "SwitchAccount"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->SWITCH_ACCOUNT:Lcom/amazon/avod/clickstream/PageType;

    .line 48
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "FSK18"

    const/16 v2, 0x14

    const-string/jumbo v3, "FSK18"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->FSK18:Lcom/amazon/avod/clickstream/PageType;

    .line 49
    new-instance v0, Lcom/amazon/avod/clickstream/PageType;

    const-string/jumbo v1, "SETUP"

    const/16 v2, 0x15

    const-string/jumbo v3, "SETUP"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/clickstream/PageType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->SETUP:Lcom/amazon/avod/clickstream/PageType;

    .line 14
    const/16 v0, 0x16

    new-array v0, v0, [Lcom/amazon/avod/clickstream/PageType;

    sget-object v1, Lcom/amazon/avod/clickstream/PageType;->HOME:Lcom/amazon/avod/clickstream/PageType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/avod/clickstream/PageType;->BROWSE:Lcom/amazon/avod/clickstream/PageType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/avod/clickstream/PageType;->DETAIL:Lcom/amazon/avod/clickstream/PageType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/avod/clickstream/PageType;->LIBRARY:Lcom/amazon/avod/clickstream/PageType;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/avod/clickstream/PageType;->WATCHLIST:Lcom/amazon/avod/clickstream/PageType;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/avod/clickstream/PageType;->SEARCH:Lcom/amazon/avod/clickstream/PageType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/avod/clickstream/PageType;->PLAYER:Lcom/amazon/avod/clickstream/PageType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/avod/clickstream/PageType;->SECOND_SCREEN:Lcom/amazon/avod/clickstream/PageType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/avod/clickstream/PageType;->IMDB:Lcom/amazon/avod/clickstream/PageType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/avod/clickstream/PageType;->XRAY:Lcom/amazon/avod/clickstream/PageType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/avod/clickstream/PageType;->DISPATCH:Lcom/amazon/avod/clickstream/PageType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/amazon/avod/clickstream/PageType;->SETTINGS:Lcom/amazon/avod/clickstream/PageType;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/amazon/avod/clickstream/PageType;->LOGIN:Lcom/amazon/avod/clickstream/PageType;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/amazon/avod/clickstream/PageType;->WEBVIEW:Lcom/amazon/avod/clickstream/PageType;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/amazon/avod/clickstream/PageType;->HELP:Lcom/amazon/avod/clickstream/PageType;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/amazon/avod/clickstream/PageType;->ITEM_MENU:Lcom/amazon/avod/clickstream/PageType;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/amazon/avod/clickstream/PageType;->PRIME_SIGNUP:Lcom/amazon/avod/clickstream/PageType;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/amazon/avod/clickstream/PageType;->FEEDBACK:Lcom/amazon/avod/clickstream/PageType;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/amazon/avod/clickstream/PageType;->GEN5_FTUE_TUTORIAL:Lcom/amazon/avod/clickstream/PageType;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/amazon/avod/clickstream/PageType;->SWITCH_ACCOUNT:Lcom/amazon/avod/clickstream/PageType;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/amazon/avod/clickstream/PageType;->FSK18:Lcom/amazon/avod/clickstream/PageType;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/amazon/avod/clickstream/PageType;->SETUP:Lcom/amazon/avod/clickstream/PageType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/avod/clickstream/PageType;->$VALUES:[Lcom/amazon/avod/clickstream/PageType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 2
    .param p3, "reportableString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 53
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 54
    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x11

    if-gt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    const-string/jumbo v1, "PageType length limit exceeded."

    invoke-static {v0, v1}, Lcom/google/common/base/Preconditions;->checkArgument(ZLjava/lang/Object;)V

    .line 57
    iput-object p3, p0, Lcom/amazon/avod/clickstream/PageType;->mReportableString:Ljava/lang/String;

    .line 58
    return-void

    .line 54
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/avod/clickstream/PageType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 14
    const-class v0, Lcom/amazon/avod/clickstream/PageType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/avod/clickstream/PageType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/avod/clickstream/PageType;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/amazon/avod/clickstream/PageType;->$VALUES:[Lcom/amazon/avod/clickstream/PageType;

    invoke-virtual {v0}, [Lcom/amazon/avod/clickstream/PageType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/avod/clickstream/PageType;

    return-object v0
.end method


# virtual methods
.method public getReportableString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/avod/clickstream/PageType;->mReportableString:Ljava/lang/String;

    return-object v0
.end method
