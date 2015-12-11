.class Lcom/amazon/mShop/android/platform/dex/SecondDexEntry$ExtractAndFillClassLoader;
.super Ljava/lang/Object;
.source "SecondDexEntry.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ExtractAndFillClassLoader"
.end annotation


# instance fields
.field private final mExecutor:Ljava/util/concurrent/ThreadPoolExecutor;


# direct methods
.method public constructor <init>(Ljava/util/concurrent/ThreadPoolExecutor;)V
    .locals 0
    .param p1, "executor"    # Ljava/util/concurrent/ThreadPoolExecutor;

    .prologue
    .line 294
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 295
    iput-object p1, p0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry$ExtractAndFillClassLoader;->mExecutor:Ljava/util/concurrent/ThreadPoolExecutor;

    .line 296
    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 300
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry$ExtractAndFillClassLoader;->mExecutor:Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->extractDexAndLoad(Ljava/util/concurrent/ThreadPoolExecutor;)V

    .line 301
    return-void
.end method
