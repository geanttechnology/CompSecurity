.class Lcom/amazon/android/webkit/android/AndroidWebChromeClient$3;
.super Ljava/lang/Object;
.source "AndroidWebChromeClient.java"

# interfaces
.implements Lcom/amazon/android/webkit/AmazonWebStorage$QuotaUpdater;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->onReachedMaxAppCacheSize(JJLandroid/webkit/WebStorage$QuotaUpdater;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/android/webkit/android/AndroidWebChromeClient;

.field final synthetic val$quotaUpdater:Landroid/webkit/WebStorage$QuotaUpdater;


# direct methods
.method constructor <init>(Lcom/amazon/android/webkit/android/AndroidWebChromeClient;Landroid/webkit/WebStorage$QuotaUpdater;)V
    .locals 0

    .prologue
    .line 117
    iput-object p1, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$3;->this$0:Lcom/amazon/android/webkit/android/AndroidWebChromeClient;

    iput-object p2, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$3;->val$quotaUpdater:Landroid/webkit/WebStorage$QuotaUpdater;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
