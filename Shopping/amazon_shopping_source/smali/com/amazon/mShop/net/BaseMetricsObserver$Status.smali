.class public final enum Lcom/amazon/mShop/net/BaseMetricsObserver$Status;
.super Ljava/lang/Enum;
.source "BaseMetricsObserver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/BaseMetricsObserver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Status"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/net/BaseMetricsObserver$Status;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

.field public static final enum Canceled:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

.field public static final enum Completed:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

.field public static final enum Failed:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

.field public static final enum Received:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

.field public static final enum Running:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

.field public static final enum Unknown:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 133
    new-instance v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    const-string/jumbo v1, "Unknown"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Unknown:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    .line 138
    new-instance v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    const-string/jumbo v1, "Running"

    invoke-direct {v0, v1, v4}, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Running:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    .line 144
    new-instance v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    const-string/jumbo v1, "Received"

    invoke-direct {v0, v1, v5}, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Received:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    .line 149
    new-instance v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    const-string/jumbo v1, "Completed"

    invoke-direct {v0, v1, v6}, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Completed:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    .line 154
    new-instance v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    const-string/jumbo v1, "Canceled"

    invoke-direct {v0, v1, v7}, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Canceled:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    .line 159
    new-instance v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    const-string/jumbo v1, "Failed"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Failed:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    .line 129
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    sget-object v1, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Unknown:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Running:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Received:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Completed:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Canceled:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Failed:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->$VALUES:[Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

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
    .line 129
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/net/BaseMetricsObserver$Status;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 129
    const-class v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/net/BaseMetricsObserver$Status;
    .locals 1

    .prologue
    .line 129
    sget-object v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->$VALUES:[Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    invoke-virtual {v0}, [Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    return-object v0
.end method
