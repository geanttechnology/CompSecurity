.class Lcom/amazon/mShop/voice/MShopVoicePackageProxy$SingletonHolder;
.super Ljava/lang/Object;
.source "MShopVoicePackageProxy.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/voice/MShopVoicePackageProxy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SingletonHolder"
.end annotation


# static fields
.field private static final INSTANCE:Lcom/amazon/mShop/voice/MShopVoicePackageProxy;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 55
    new-instance v0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;

    invoke-direct {v0}, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;-><init>()V

    sput-object v0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy$SingletonHolder;->INSTANCE:Lcom/amazon/mShop/voice/MShopVoicePackageProxy;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000()Lcom/amazon/mShop/voice/MShopVoicePackageProxy;
    .locals 1

    .prologue
    .line 54
    sget-object v0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy$SingletonHolder;->INSTANCE:Lcom/amazon/mShop/voice/MShopVoicePackageProxy;

    return-object v0
.end method
