.class public final enum Lamazon/communication/connection/Priority;
.super Ljava/lang/Enum;
.source "Priority.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lamazon/communication/connection/Priority;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lamazon/communication/connection/Priority;

.field public static final enum PRIORITY_HIGH:Lamazon/communication/connection/Priority;

.field public static final enum PRIORITY_LOW:Lamazon/communication/connection/Priority;

.field public static final enum PRIORITY_NORMAL:Lamazon/communication/connection/Priority;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 23
    new-instance v0, Lamazon/communication/connection/Priority;

    const-string/jumbo v1, "PRIORITY_HIGH"

    invoke-direct {v0, v1, v2}, Lamazon/communication/connection/Priority;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lamazon/communication/connection/Priority;->PRIORITY_HIGH:Lamazon/communication/connection/Priority;

    .line 27
    new-instance v0, Lamazon/communication/connection/Priority;

    const-string/jumbo v1, "PRIORITY_NORMAL"

    invoke-direct {v0, v1, v3}, Lamazon/communication/connection/Priority;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lamazon/communication/connection/Priority;->PRIORITY_NORMAL:Lamazon/communication/connection/Priority;

    .line 31
    new-instance v0, Lamazon/communication/connection/Priority;

    const-string/jumbo v1, "PRIORITY_LOW"

    invoke-direct {v0, v1, v4}, Lamazon/communication/connection/Priority;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lamazon/communication/connection/Priority;->PRIORITY_LOW:Lamazon/communication/connection/Priority;

    .line 19
    const/4 v0, 0x3

    new-array v0, v0, [Lamazon/communication/connection/Priority;

    sget-object v1, Lamazon/communication/connection/Priority;->PRIORITY_HIGH:Lamazon/communication/connection/Priority;

    aput-object v1, v0, v2

    sget-object v1, Lamazon/communication/connection/Priority;->PRIORITY_NORMAL:Lamazon/communication/connection/Priority;

    aput-object v1, v0, v3

    sget-object v1, Lamazon/communication/connection/Priority;->PRIORITY_LOW:Lamazon/communication/connection/Priority;

    aput-object v1, v0, v4

    sput-object v0, Lamazon/communication/connection/Priority;->$VALUES:[Lamazon/communication/connection/Priority;

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
    .line 19
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lamazon/communication/connection/Priority;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 19
    const-class v0, Lamazon/communication/connection/Priority;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lamazon/communication/connection/Priority;

    return-object v0
.end method

.method public static values()[Lamazon/communication/connection/Priority;
    .locals 1

    .prologue
    .line 19
    sget-object v0, Lamazon/communication/connection/Priority;->$VALUES:[Lamazon/communication/connection/Priority;

    invoke-virtual {v0}, [Lamazon/communication/connection/Priority;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lamazon/communication/connection/Priority;

    return-object v0
.end method
