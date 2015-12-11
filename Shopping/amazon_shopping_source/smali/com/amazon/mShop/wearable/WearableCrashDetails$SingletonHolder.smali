.class Lcom/amazon/mShop/wearable/WearableCrashDetails$SingletonHolder;
.super Ljava/lang/Object;
.source "WearableCrashDetails.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/wearable/WearableCrashDetails;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SingletonHolder"
.end annotation


# static fields
.field private static final INSTANCE:Lcom/amazon/mShop/wearable/WearableCrashDetails;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    new-instance v0, Lcom/amazon/mShop/wearable/WearableCrashDetails;

    invoke-direct {v0}, Lcom/amazon/mShop/wearable/WearableCrashDetails;-><init>()V

    sput-object v0, Lcom/amazon/mShop/wearable/WearableCrashDetails$SingletonHolder;->INSTANCE:Lcom/amazon/mShop/wearable/WearableCrashDetails;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000()Lcom/amazon/mShop/wearable/WearableCrashDetails;
    .locals 1

    .prologue
    .line 18
    sget-object v0, Lcom/amazon/mShop/wearable/WearableCrashDetails$SingletonHolder;->INSTANCE:Lcom/amazon/mShop/wearable/WearableCrashDetails;

    return-object v0
.end method
