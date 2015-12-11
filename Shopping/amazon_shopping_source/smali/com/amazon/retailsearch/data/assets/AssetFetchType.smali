.class public final enum Lcom/amazon/retailsearch/data/assets/AssetFetchType;
.super Ljava/lang/Enum;
.source "AssetFetchType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/retailsearch/data/assets/AssetFetchType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/retailsearch/data/assets/AssetFetchType;

.field public static final enum APP_RESET:Lcom/amazon/retailsearch/data/assets/AssetFetchType;

.field public static final enum POST_SEARCH_PAGE_LOAD:Lcom/amazon/retailsearch/data/assets/AssetFetchType;

.field public static final enum STARTUP_SEQUENCE:Lcom/amazon/retailsearch/data/assets/AssetFetchType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 16
    new-instance v0, Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    const-string/jumbo v1, "STARTUP_SEQUENCE"

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/data/assets/AssetFetchType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/data/assets/AssetFetchType;->STARTUP_SEQUENCE:Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    .line 17
    new-instance v0, Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    const-string/jumbo v1, "POST_SEARCH_PAGE_LOAD"

    invoke-direct {v0, v1, v3}, Lcom/amazon/retailsearch/data/assets/AssetFetchType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/data/assets/AssetFetchType;->POST_SEARCH_PAGE_LOAD:Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    .line 18
    new-instance v0, Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    const-string/jumbo v1, "APP_RESET"

    invoke-direct {v0, v1, v4}, Lcom/amazon/retailsearch/data/assets/AssetFetchType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/data/assets/AssetFetchType;->APP_RESET:Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    .line 14
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    sget-object v1, Lcom/amazon/retailsearch/data/assets/AssetFetchType;->STARTUP_SEQUENCE:Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/retailsearch/data/assets/AssetFetchType;->POST_SEARCH_PAGE_LOAD:Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/retailsearch/data/assets/AssetFetchType;->APP_RESET:Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/retailsearch/data/assets/AssetFetchType;->$VALUES:[Lcom/amazon/retailsearch/data/assets/AssetFetchType;

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
    .line 14
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/data/assets/AssetFetchType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 14
    const-class v0, Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/retailsearch/data/assets/AssetFetchType;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/amazon/retailsearch/data/assets/AssetFetchType;->$VALUES:[Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    invoke-virtual {v0}, [Lcom/amazon/retailsearch/data/assets/AssetFetchType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    return-object v0
.end method


# virtual methods
.method public toLoggingString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    invoke-virtual {p0}, Lcom/amazon/retailsearch/data/assets/AssetFetchType;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
