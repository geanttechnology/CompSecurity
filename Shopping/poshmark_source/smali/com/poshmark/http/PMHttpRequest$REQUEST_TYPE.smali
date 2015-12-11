.class public final enum Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;
.super Ljava/lang/Enum;
.source "PMHttpRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/http/PMHttpRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "REQUEST_TYPE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

.field public static final enum HTTP_DELETE:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

.field public static final enum HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

.field public static final enum HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

.field public static final enum HTTP_PUT:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 23
    new-instance v0, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v1, "HTTP_GET"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    new-instance v0, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v1, "HTTP_POST"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    new-instance v0, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v1, "HTTP_PUT"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_PUT:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    new-instance v0, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v1, "HTTP_DELETE"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_DELETE:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    .line 21
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_PUT:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_DELETE:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    aput-object v1, v0, v5

    sput-object v0, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->$VALUES:[Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

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
    .line 21
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 21
    const-class v0, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;
    .locals 1

    .prologue
    .line 21
    sget-object v0, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->$VALUES:[Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    invoke-virtual {v0}, [Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    return-object v0
.end method
