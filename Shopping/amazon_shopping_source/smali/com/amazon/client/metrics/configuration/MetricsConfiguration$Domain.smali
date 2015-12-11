.class public final enum Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;
.super Ljava/lang/Enum;
.source "MetricsConfiguration.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/client/metrics/configuration/MetricsConfiguration;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Domain"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

.field public static final enum DEVO:Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

.field public static final enum MASTER:Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

.field public static final enum PROD:Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;


# instance fields
.field private mName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 19
    new-instance v0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

    const-string/jumbo v1, "DEVO"

    const-string/jumbo v2, "devo"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;->DEVO:Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

    .line 20
    new-instance v0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

    const-string/jumbo v1, "MASTER"

    const-string/jumbo v2, "master"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;->MASTER:Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

    .line 21
    new-instance v0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

    const-string/jumbo v1, "PROD"

    const-string/jumbo v2, "prod"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;->PROD:Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

    .line 18
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

    sget-object v1, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;->DEVO:Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;->MASTER:Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;->PROD:Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;->$VALUES:[Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

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
    .line 24
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 25
    iput-object p3, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;->mName:Ljava/lang/String;

    .line 26
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 18
    const-class v0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

    return-object v0
.end method

.method public static values()[Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;
    .locals 1

    .prologue
    .line 18
    sget-object v0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;->$VALUES:[Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

    invoke-virtual {v0}, [Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;->mName:Ljava/lang/String;

    return-object v0
.end method
