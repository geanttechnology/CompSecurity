.class Lcom/amazon/mShop/android/platform/dex/SecondDexEntry$SingletonHolder;
.super Ljava/lang/Object;
.source "SecondDexEntry.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SingletonHolder"
.end annotation


# static fields
.field public static final INSTANCE:Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 46
    new-instance v0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;-><init>(Lcom/amazon/mShop/android/platform/dex/SecondDexEntry$1;)V

    sput-object v0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry$SingletonHolder;->INSTANCE:Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
