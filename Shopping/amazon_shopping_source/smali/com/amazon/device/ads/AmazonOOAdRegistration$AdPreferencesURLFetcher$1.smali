.class Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher$1;
.super Ljava/lang/Object;
.source "AmazonOOAdRegistration.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;->onFetched(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;

.field final synthetic val$adPreferencesURL:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 429
    iput-object p1, p0, Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher$1;->this$0:Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;

    iput-object p2, p0, Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher$1;->val$adPreferencesURL:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 433
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher$1;->this$0:Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;

    # getter for: Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;->listener:Lcom/amazon/device/ads/AmazonOOAdPreferencesURLListener;
    invoke-static {v0}, Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;->access$000(Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;)Lcom/amazon/device/ads/AmazonOOAdPreferencesURLListener;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher$1;->val$adPreferencesURL:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/amazon/device/ads/AmazonOOAdPreferencesURLListener;->onAdPreferencesURLFetched(Ljava/lang/String;)V

    .line 434
    return-void
.end method
