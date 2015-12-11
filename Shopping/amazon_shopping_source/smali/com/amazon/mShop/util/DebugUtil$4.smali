.class final Lcom/amazon/mShop/util/DebugUtil$4;
.super Ljava/lang/Object;
.source "DebugUtil.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/DebugUtil;->handleOnReceivedHTTPAuthenticationRequest(Landroid/app/Activity;Landroid/webkit/WebView;Landroid/webkit/HttpAuthHandler;Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$handler:Landroid/webkit/HttpAuthHandler;


# direct methods
.method constructor <init>(Landroid/webkit/HttpAuthHandler;)V
    .locals 0

    .prologue
    .line 188
    iput-object p1, p0, Lcom/amazon/mShop/util/DebugUtil$4;->val$handler:Landroid/webkit/HttpAuthHandler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 191
    iget-object v0, p0, Lcom/amazon/mShop/util/DebugUtil$4;->val$handler:Landroid/webkit/HttpAuthHandler;

    invoke-virtual {v0}, Landroid/webkit/HttpAuthHandler;->cancel()V

    .line 192
    return-void
.end method
