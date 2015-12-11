.class public final enum Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;
.super Ljava/lang/Enum;
.source "StartupMetricsObserver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/StartupMetricsObserver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "StartupType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

.field public static final enum PUBLIC_URL_FIRST_START:Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

.field public static final enum PUBLIC_URL_START:Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 57
    new-instance v0, Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

    const-string/jumbo v1, "PUBLIC_URL_START"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;->PUBLIC_URL_START:Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

    .line 58
    new-instance v0, Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

    const-string/jumbo v1, "PUBLIC_URL_FIRST_START"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;->PUBLIC_URL_FIRST_START:Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

    .line 56
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

    sget-object v1, Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;->PUBLIC_URL_START:Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;->PUBLIC_URL_FIRST_START:Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;->$VALUES:[Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

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
    .line 56
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 56
    const-class v0, Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;
    .locals 1

    .prologue
    .line 56
    sget-object v0, Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;->$VALUES:[Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

    invoke-virtual {v0}, [Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

    return-object v0
.end method
