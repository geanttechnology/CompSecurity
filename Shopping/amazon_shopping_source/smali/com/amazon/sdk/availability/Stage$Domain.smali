.class public final enum Lcom/amazon/sdk/availability/Stage$Domain;
.super Ljava/lang/Enum;
.source "Stage.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/sdk/availability/Stage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Domain"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/sdk/availability/Stage$Domain;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/sdk/availability/Stage$Domain;

.field public static final enum MASTER:Lcom/amazon/sdk/availability/Stage$Domain;

.field public static final enum PROD:Lcom/amazon/sdk/availability/Stage$Domain;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 19
    new-instance v0, Lcom/amazon/sdk/availability/Stage$Domain;

    const-string/jumbo v1, "PROD"

    invoke-direct {v0, v1, v2}, Lcom/amazon/sdk/availability/Stage$Domain;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/sdk/availability/Stage$Domain;->PROD:Lcom/amazon/sdk/availability/Stage$Domain;

    .line 22
    new-instance v0, Lcom/amazon/sdk/availability/Stage$Domain;

    const-string/jumbo v1, "MASTER"

    invoke-direct {v0, v1, v3}, Lcom/amazon/sdk/availability/Stage$Domain;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/sdk/availability/Stage$Domain;->MASTER:Lcom/amazon/sdk/availability/Stage$Domain;

    .line 17
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/sdk/availability/Stage$Domain;

    sget-object v1, Lcom/amazon/sdk/availability/Stage$Domain;->PROD:Lcom/amazon/sdk/availability/Stage$Domain;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/sdk/availability/Stage$Domain;->MASTER:Lcom/amazon/sdk/availability/Stage$Domain;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/sdk/availability/Stage$Domain;->$VALUES:[Lcom/amazon/sdk/availability/Stage$Domain;

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
    .line 17
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/sdk/availability/Stage$Domain;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 17
    const-class v0, Lcom/amazon/sdk/availability/Stage$Domain;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/sdk/availability/Stage$Domain;

    return-object v0
.end method

.method public static values()[Lcom/amazon/sdk/availability/Stage$Domain;
    .locals 1

    .prologue
    .line 17
    sget-object v0, Lcom/amazon/sdk/availability/Stage$Domain;->$VALUES:[Lcom/amazon/sdk/availability/Stage$Domain;

    invoke-virtual {v0}, [Lcom/amazon/sdk/availability/Stage$Domain;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/sdk/availability/Stage$Domain;

    return-object v0
.end method
