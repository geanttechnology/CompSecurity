.class public final enum Lcom/amazon/mShop/net/MetricsSender$SenderType;
.super Ljava/lang/Enum;
.source "MetricsSender.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/MetricsSender;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "SenderType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/net/MetricsSender$SenderType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/net/MetricsSender$SenderType;

.field public static final enum MShopSender:Lcom/amazon/mShop/net/MetricsSender$SenderType;

.field public static final enum RefMarkerSender:Lcom/amazon/mShop/net/MetricsSender$SenderType;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 17
    new-instance v0, Lcom/amazon/mShop/net/MetricsSender$SenderType;

    const-string/jumbo v1, "MShopSender"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/net/MetricsSender$SenderType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/MetricsSender$SenderType;->MShopSender:Lcom/amazon/mShop/net/MetricsSender$SenderType;

    .line 22
    new-instance v0, Lcom/amazon/mShop/net/MetricsSender$SenderType;

    const-string/jumbo v1, "RefMarkerSender"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/net/MetricsSender$SenderType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/MetricsSender$SenderType;->RefMarkerSender:Lcom/amazon/mShop/net/MetricsSender$SenderType;

    .line 13
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/mShop/net/MetricsSender$SenderType;

    sget-object v1, Lcom/amazon/mShop/net/MetricsSender$SenderType;->MShopSender:Lcom/amazon/mShop/net/MetricsSender$SenderType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mShop/net/MetricsSender$SenderType;->RefMarkerSender:Lcom/amazon/mShop/net/MetricsSender$SenderType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/mShop/net/MetricsSender$SenderType;->$VALUES:[Lcom/amazon/mShop/net/MetricsSender$SenderType;

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
    .line 13
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/net/MetricsSender$SenderType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 13
    const-class v0, Lcom/amazon/mShop/net/MetricsSender$SenderType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/net/MetricsSender$SenderType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/net/MetricsSender$SenderType;
    .locals 1

    .prologue
    .line 13
    sget-object v0, Lcom/amazon/mShop/net/MetricsSender$SenderType;->$VALUES:[Lcom/amazon/mShop/net/MetricsSender$SenderType;

    invoke-virtual {v0}, [Lcom/amazon/mShop/net/MetricsSender$SenderType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/net/MetricsSender$SenderType;

    return-object v0
.end method
