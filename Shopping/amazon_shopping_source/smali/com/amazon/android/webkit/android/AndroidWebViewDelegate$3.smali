.class Lcom/amazon/android/webkit/android/AndroidWebViewDelegate$3;
.super Landroid/webkit/WebBackForwardListClient;
.source "AndroidWebViewDelegate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->setWebBackForwardListClient(Lcom/amazon/android/webkit/AmazonWebBackForwardListClient;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;

.field final synthetic val$client:Lcom/amazon/android/webkit/AmazonWebBackForwardListClient;


# direct methods
.method constructor <init>(Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;Lcom/amazon/android/webkit/AmazonWebBackForwardListClient;)V
    .locals 0

    .prologue
    .line 472
    iput-object p1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate$3;->this$0:Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;

    iput-object p2, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate$3;->val$client:Lcom/amazon/android/webkit/AmazonWebBackForwardListClient;

    invoke-direct {p0}, Landroid/webkit/WebBackForwardListClient;-><init>()V

    return-void
.end method
