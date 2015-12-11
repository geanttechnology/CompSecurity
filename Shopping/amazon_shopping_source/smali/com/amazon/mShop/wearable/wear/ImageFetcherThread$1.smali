.class Lcom/amazon/mShop/wearable/wear/ImageFetcherThread$1;
.super Ljava/lang/Object;
.source "ImageFetcherThread.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;->fetchImage(Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;

.field final synthetic val$imageUrl:Ljava/lang/String;

.field final synthetic val$node:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread$1;->this$0:Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;

    iput-object p2, p0, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread$1;->val$node:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread$1;->val$imageUrl:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread$1;->this$0:Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;

    iget-object v1, p0, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread$1;->val$node:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread$1;->val$imageUrl:Ljava/lang/String;

    # invokes: Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;->syncImage(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;->access$000(Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;Ljava/lang/String;Ljava/lang/String;)V

    .line 46
    return-void
.end method
