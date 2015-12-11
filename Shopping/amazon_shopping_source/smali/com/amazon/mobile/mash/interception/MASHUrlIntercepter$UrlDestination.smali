.class public final enum Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;
.super Ljava/lang/Enum;
.source "MASHUrlIntercepter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401c
    name = "UrlDestination"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

.field public static final enum appstore:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

.field public static final enum browse:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

.field public static final enum cart:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

.field public static final enum checkout:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

.field public static final enum detail:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

.field public static final enum home:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

.field public static final enum search:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 91
    new-instance v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v1, "home"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->home:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    .line 93
    new-instance v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v1, "search"

    invoke-direct {v0, v1, v4}, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->search:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    .line 95
    new-instance v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v1, "browse"

    invoke-direct {v0, v1, v5}, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->browse:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    .line 97
    new-instance v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v1, "cart"

    invoke-direct {v0, v1, v6}, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->cart:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    .line 99
    new-instance v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v1, "detail"

    invoke-direct {v0, v1, v7}, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->detail:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    .line 101
    new-instance v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v1, "checkout"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->checkout:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    .line 103
    new-instance v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v1, "appstore"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->appstore:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    .line 89
    const/4 v0, 0x7

    new-array v0, v0, [Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    sget-object v1, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->home:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->search:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->browse:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->cart:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->detail:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->checkout:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->appstore:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->$VALUES:[Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

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
    .line 89
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 89
    const-class v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;
    .locals 1

    .prologue
    .line 89
    sget-object v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->$VALUES:[Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    invoke-virtual {v0}, [Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    return-object v0
.end method
