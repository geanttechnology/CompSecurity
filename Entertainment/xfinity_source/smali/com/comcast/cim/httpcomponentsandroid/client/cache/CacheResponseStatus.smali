.class public final enum Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;
.super Ljava/lang/Enum;
.source "CacheResponseStatus.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

.field public static final enum CACHE_HIT:Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

.field public static final enum CACHE_MISS:Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

.field public static final enum CACHE_MODULE_RESPONSE:Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

.field public static final enum VALIDATED:Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 40
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    const-string v1, "CACHE_MODULE_RESPONSE"

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;->CACHE_MODULE_RESPONSE:Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    .line 45
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    const-string v1, "CACHE_HIT"

    invoke-direct {v0, v1, v3}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;->CACHE_HIT:Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    .line 48
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    const-string v1, "CACHE_MISS"

    invoke-direct {v0, v1, v4}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;->CACHE_MISS:Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    .line 53
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    const-string v1, "VALIDATED"

    invoke-direct {v0, v1, v5}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;->VALIDATED:Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    .line 37
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    sget-object v1, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;->CACHE_MODULE_RESPONSE:Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    aput-object v1, v0, v2

    sget-object v1, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;->CACHE_HIT:Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;->CACHE_MISS:Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    aput-object v1, v0, v4

    sget-object v1, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;->VALIDATED:Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    aput-object v1, v0, v5

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;->$VALUES:[Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

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
    .line 37
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 37
    const-class v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    return-object v0
.end method

.method public static values()[Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;
    .locals 1

    .prologue
    .line 37
    sget-object v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;->$VALUES:[Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    invoke-virtual {v0}, [Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/cim/httpcomponentsandroid/client/cache/CacheResponseStatus;

    return-object v0
.end method
