.class public final enum Lamazon/communication/connection/ConnectionPolicy$CompressionOption;
.super Ljava/lang/Enum;
.source "ConnectionPolicy.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lamazon/communication/connection/ConnectionPolicy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "CompressionOption"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lamazon/communication/connection/ConnectionPolicy$CompressionOption;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

.field public static final enum ALLOWED:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

.field public static final enum NOT_ALLOWED:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

.field public static final enum REQUIRED:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 38
    new-instance v0, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    const-string/jumbo v1, "REQUIRED"

    invoke-direct {v0, v1, v2}, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->REQUIRED:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    .line 42
    new-instance v0, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    const-string/jumbo v1, "ALLOWED"

    invoke-direct {v0, v1, v3}, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->ALLOWED:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    .line 46
    new-instance v0, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    const-string/jumbo v1, "NOT_ALLOWED"

    invoke-direct {v0, v1, v4}, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->NOT_ALLOWED:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    .line 34
    const/4 v0, 0x3

    new-array v0, v0, [Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    sget-object v1, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->REQUIRED:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    aput-object v1, v0, v2

    sget-object v1, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->ALLOWED:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    aput-object v1, v0, v3

    sget-object v1, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->NOT_ALLOWED:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    aput-object v1, v0, v4

    sput-object v0, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->$VALUES:[Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

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
    .line 34
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lamazon/communication/connection/ConnectionPolicy$CompressionOption;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 34
    const-class v0, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    return-object v0
.end method

.method public static values()[Lamazon/communication/connection/ConnectionPolicy$CompressionOption;
    .locals 1

    .prologue
    .line 34
    sget-object v0, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->$VALUES:[Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    invoke-virtual {v0}, [Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    return-object v0
.end method
