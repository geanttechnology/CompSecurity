.class public final enum Lcom/squareup/okhttp/Protocol;
.super Ljava/lang/Enum;
.source "Protocol.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/squareup/okhttp/Protocol;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/squareup/okhttp/Protocol;

.field public static final enum HTTP_11:Lcom/squareup/okhttp/Protocol;

.field public static final enum HTTP_2:Lcom/squareup/okhttp/Protocol;

.field public static final enum SPDY_3:Lcom/squareup/okhttp/Protocol;


# instance fields
.field public final name:Lcom/squareup/okhttp/internal/okio/ByteString;

.field public final spdyVariant:Z


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 33
    new-instance v0, Lcom/squareup/okhttp/Protocol;

    const-string/jumbo v1, "HTTP_2"

    const-string/jumbo v2, "HTTP-draft-09/2.0"

    invoke-direct {v0, v1, v4, v2, v3}, Lcom/squareup/okhttp/Protocol;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    sput-object v0, Lcom/squareup/okhttp/Protocol;->HTTP_2:Lcom/squareup/okhttp/Protocol;

    .line 34
    new-instance v0, Lcom/squareup/okhttp/Protocol;

    const-string/jumbo v1, "SPDY_3"

    const-string/jumbo v2, "spdy/3.1"

    invoke-direct {v0, v1, v3, v2, v3}, Lcom/squareup/okhttp/Protocol;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    sput-object v0, Lcom/squareup/okhttp/Protocol;->SPDY_3:Lcom/squareup/okhttp/Protocol;

    .line 35
    new-instance v0, Lcom/squareup/okhttp/Protocol;

    const-string/jumbo v1, "HTTP_11"

    const-string/jumbo v2, "http/1.1"

    invoke-direct {v0, v1, v5, v2, v4}, Lcom/squareup/okhttp/Protocol;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    sput-object v0, Lcom/squareup/okhttp/Protocol;->HTTP_11:Lcom/squareup/okhttp/Protocol;

    .line 32
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/squareup/okhttp/Protocol;

    sget-object v1, Lcom/squareup/okhttp/Protocol;->HTTP_2:Lcom/squareup/okhttp/Protocol;

    aput-object v1, v0, v4

    sget-object v1, Lcom/squareup/okhttp/Protocol;->SPDY_3:Lcom/squareup/okhttp/Protocol;

    aput-object v1, v0, v3

    sget-object v1, Lcom/squareup/okhttp/Protocol;->HTTP_11:Lcom/squareup/okhttp/Protocol;

    aput-object v1, v0, v5

    sput-object v0, Lcom/squareup/okhttp/Protocol;->$VALUES:[Lcom/squareup/okhttp/Protocol;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 1
    .param p3, "name"    # Ljava/lang/String;
    .param p4, "spdyVariant"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 47
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 48
    invoke-static {p3}, Lcom/squareup/okhttp/internal/okio/ByteString;->encodeUtf8(Ljava/lang/String;)Lcom/squareup/okhttp/internal/okio/ByteString;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/Protocol;->name:Lcom/squareup/okhttp/internal/okio/ByteString;

    .line 49
    iput-boolean p4, p0, Lcom/squareup/okhttp/Protocol;->spdyVariant:Z

    .line 50
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/squareup/okhttp/Protocol;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 32
    const-class v0, Lcom/squareup/okhttp/Protocol;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/squareup/okhttp/Protocol;

    return-object v0
.end method

.method public static values()[Lcom/squareup/okhttp/Protocol;
    .locals 1

    .prologue
    .line 32
    sget-object v0, Lcom/squareup/okhttp/Protocol;->$VALUES:[Lcom/squareup/okhttp/Protocol;

    invoke-virtual {v0}, [Lcom/squareup/okhttp/Protocol;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/squareup/okhttp/Protocol;

    return-object v0
.end method
