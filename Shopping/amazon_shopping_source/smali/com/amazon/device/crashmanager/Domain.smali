.class public final enum Lcom/amazon/device/crashmanager/Domain;
.super Ljava/lang/Enum;
.source "Domain.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/device/crashmanager/Domain;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/device/crashmanager/Domain;

.field public static final enum BETA:Lcom/amazon/device/crashmanager/Domain;

.field public static final enum PROD:Lcom/amazon/device/crashmanager/Domain;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 4
    new-instance v0, Lcom/amazon/device/crashmanager/Domain;

    const-string/jumbo v1, "PROD"

    invoke-direct {v0, v1, v2}, Lcom/amazon/device/crashmanager/Domain;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/crashmanager/Domain;->PROD:Lcom/amazon/device/crashmanager/Domain;

    .line 5
    new-instance v0, Lcom/amazon/device/crashmanager/Domain;

    const-string/jumbo v1, "BETA"

    invoke-direct {v0, v1, v3}, Lcom/amazon/device/crashmanager/Domain;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/crashmanager/Domain;->BETA:Lcom/amazon/device/crashmanager/Domain;

    .line 3
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/device/crashmanager/Domain;

    sget-object v1, Lcom/amazon/device/crashmanager/Domain;->PROD:Lcom/amazon/device/crashmanager/Domain;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/device/crashmanager/Domain;->BETA:Lcom/amazon/device/crashmanager/Domain;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/device/crashmanager/Domain;->$VALUES:[Lcom/amazon/device/crashmanager/Domain;

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
    .line 3
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/device/crashmanager/Domain;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 3
    const-class v0, Lcom/amazon/device/crashmanager/Domain;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/crashmanager/Domain;

    return-object v0
.end method

.method public static values()[Lcom/amazon/device/crashmanager/Domain;
    .locals 1

    .prologue
    .line 3
    sget-object v0, Lcom/amazon/device/crashmanager/Domain;->$VALUES:[Lcom/amazon/device/crashmanager/Domain;

    invoke-virtual {v0}, [Lcom/amazon/device/crashmanager/Domain;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/device/crashmanager/Domain;

    return-object v0
.end method
