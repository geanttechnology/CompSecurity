.class public final enum Lamazon/communication/connection/KeepAlive;
.super Ljava/lang/Enum;
.source "KeepAlive.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lamazon/communication/connection/KeepAlive;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lamazon/communication/connection/KeepAlive;

.field public static final enum ADAPTIVE:Lamazon/communication/connection/KeepAlive;

.field public static final enum NONE:Lamazon/communication/connection/KeepAlive;

.field public static final enum STATIC:Lamazon/communication/connection/KeepAlive;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 26
    new-instance v0, Lamazon/communication/connection/KeepAlive;

    const-string/jumbo v1, "NONE"

    invoke-direct {v0, v1, v2}, Lamazon/communication/connection/KeepAlive;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lamazon/communication/connection/KeepAlive;->NONE:Lamazon/communication/connection/KeepAlive;

    .line 33
    new-instance v0, Lamazon/communication/connection/KeepAlive;

    const-string/jumbo v1, "STATIC"

    invoke-direct {v0, v1, v3}, Lamazon/communication/connection/KeepAlive;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lamazon/communication/connection/KeepAlive;->STATIC:Lamazon/communication/connection/KeepAlive;

    .line 48
    new-instance v0, Lamazon/communication/connection/KeepAlive;

    const-string/jumbo v1, "ADAPTIVE"

    invoke-direct {v0, v1, v4}, Lamazon/communication/connection/KeepAlive;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lamazon/communication/connection/KeepAlive;->ADAPTIVE:Lamazon/communication/connection/KeepAlive;

    .line 21
    const/4 v0, 0x3

    new-array v0, v0, [Lamazon/communication/connection/KeepAlive;

    sget-object v1, Lamazon/communication/connection/KeepAlive;->NONE:Lamazon/communication/connection/KeepAlive;

    aput-object v1, v0, v2

    sget-object v1, Lamazon/communication/connection/KeepAlive;->STATIC:Lamazon/communication/connection/KeepAlive;

    aput-object v1, v0, v3

    sget-object v1, Lamazon/communication/connection/KeepAlive;->ADAPTIVE:Lamazon/communication/connection/KeepAlive;

    aput-object v1, v0, v4

    sput-object v0, Lamazon/communication/connection/KeepAlive;->$VALUES:[Lamazon/communication/connection/KeepAlive;

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

.method public static valueOf(Ljava/lang/String;)Lamazon/communication/connection/KeepAlive;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 21
    const-class v0, Lamazon/communication/connection/KeepAlive;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lamazon/communication/connection/KeepAlive;

    return-object v0
.end method

.method public static values()[Lamazon/communication/connection/KeepAlive;
    .locals 1

    .prologue
    .line 21
    sget-object v0, Lamazon/communication/connection/KeepAlive;->$VALUES:[Lamazon/communication/connection/KeepAlive;

    invoke-virtual {v0}, [Lamazon/communication/connection/KeepAlive;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lamazon/communication/connection/KeepAlive;

    return-object v0
.end method
