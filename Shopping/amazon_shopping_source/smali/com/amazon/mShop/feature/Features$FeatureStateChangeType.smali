.class public final enum Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;
.super Ljava/lang/Enum;
.source "Features.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/feature/Features;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "FeatureStateChangeType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

.field public static final enum CACHETIMESTAMP_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

.field public static final enum NO_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

.field public static final enum TREATMENT_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 84
    new-instance v0, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    const-string/jumbo v1, "TREATMENT_CHANGE"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->TREATMENT_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    .line 85
    new-instance v0, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    const-string/jumbo v1, "CACHETIMESTAMP_CHANGE"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->CACHETIMESTAMP_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    .line 86
    new-instance v0, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    const-string/jumbo v1, "NO_CHANGE"

    invoke-direct {v0, v1, v4}, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->NO_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    .line 83
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    sget-object v1, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->TREATMENT_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->CACHETIMESTAMP_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->NO_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->$VALUES:[Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

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
    .line 83
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 83
    const-class v0, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;
    .locals 1

    .prologue
    .line 83
    sget-object v0, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->$VALUES:[Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    invoke-virtual {v0}, [Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    return-object v0
.end method
