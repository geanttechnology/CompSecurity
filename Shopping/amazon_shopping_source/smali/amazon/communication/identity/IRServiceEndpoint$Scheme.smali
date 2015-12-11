.class public final enum Lamazon/communication/identity/IRServiceEndpoint$Scheme;
.super Ljava/lang/Enum;
.source "IRServiceEndpoint.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lamazon/communication/identity/IRServiceEndpoint;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Scheme"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lamazon/communication/identity/IRServiceEndpoint$Scheme;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lamazon/communication/identity/IRServiceEndpoint$Scheme;

.field public static final enum HTTP:Lamazon/communication/identity/IRServiceEndpoint$Scheme;

.field public static final enum HTTPS:Lamazon/communication/identity/IRServiceEndpoint$Scheme;

.field public static final enum WS:Lamazon/communication/identity/IRServiceEndpoint$Scheme;

.field public static final enum WSS:Lamazon/communication/identity/IRServiceEndpoint$Scheme;


# instance fields
.field private final mName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 183
    new-instance v0, Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    const-string/jumbo v1, "WS"

    const-string/jumbo v2, "ws"

    invoke-direct {v0, v1, v3, v2}, Lamazon/communication/identity/IRServiceEndpoint$Scheme;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lamazon/communication/identity/IRServiceEndpoint$Scheme;->WS:Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    .line 184
    new-instance v0, Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    const-string/jumbo v1, "WSS"

    const-string/jumbo v2, "wss"

    invoke-direct {v0, v1, v4, v2}, Lamazon/communication/identity/IRServiceEndpoint$Scheme;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lamazon/communication/identity/IRServiceEndpoint$Scheme;->WSS:Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    .line 185
    new-instance v0, Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    const-string/jumbo v1, "HTTP"

    const-string/jumbo v2, "http"

    invoke-direct {v0, v1, v5, v2}, Lamazon/communication/identity/IRServiceEndpoint$Scheme;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lamazon/communication/identity/IRServiceEndpoint$Scheme;->HTTP:Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    .line 186
    new-instance v0, Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    const-string/jumbo v1, "HTTPS"

    const-string/jumbo v2, "https"

    invoke-direct {v0, v1, v6, v2}, Lamazon/communication/identity/IRServiceEndpoint$Scheme;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lamazon/communication/identity/IRServiceEndpoint$Scheme;->HTTPS:Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    .line 182
    const/4 v0, 0x4

    new-array v0, v0, [Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    sget-object v1, Lamazon/communication/identity/IRServiceEndpoint$Scheme;->WS:Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    aput-object v1, v0, v3

    sget-object v1, Lamazon/communication/identity/IRServiceEndpoint$Scheme;->WSS:Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    aput-object v1, v0, v4

    sget-object v1, Lamazon/communication/identity/IRServiceEndpoint$Scheme;->HTTP:Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    aput-object v1, v0, v5

    sget-object v1, Lamazon/communication/identity/IRServiceEndpoint$Scheme;->HTTPS:Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    aput-object v1, v0, v6

    sput-object v0, Lamazon/communication/identity/IRServiceEndpoint$Scheme;->$VALUES:[Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 190
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 191
    iput-object p3, p0, Lamazon/communication/identity/IRServiceEndpoint$Scheme;->mName:Ljava/lang/String;

    .line 192
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lamazon/communication/identity/IRServiceEndpoint$Scheme;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 182
    const-class v0, Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    return-object v0
.end method

.method public static values()[Lamazon/communication/identity/IRServiceEndpoint$Scheme;
    .locals 1

    .prologue
    .line 182
    sget-object v0, Lamazon/communication/identity/IRServiceEndpoint$Scheme;->$VALUES:[Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    invoke-virtual {v0}, [Lamazon/communication/identity/IRServiceEndpoint$Scheme;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 196
    iget-object v0, p0, Lamazon/communication/identity/IRServiceEndpoint$Scheme;->mName:Ljava/lang/String;

    return-object v0
.end method
