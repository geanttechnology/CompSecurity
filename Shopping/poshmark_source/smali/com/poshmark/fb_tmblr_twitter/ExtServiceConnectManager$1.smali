.class Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager$1;
.super Ljava/lang/Object;
.source "ExtServiceConnectManager.java"

# interfaces
.implements Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->fbLink(Lcom/poshmark/ui/fragments/PMFragment;IILcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

.field final synthetic val$callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;


# direct methods
.method constructor <init>(Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

    iput-object p2, p0, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager$1;->val$callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public error(Lcom/poshmark/http/api/PMApiError;)V
    .locals 1
    .param p1, "error"    # Lcom/poshmark/http/api/PMApiError;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager$1;->val$callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    invoke-interface {v0, p1}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;->error(Lcom/poshmark/http/api/PMApiError;)V

    .line 47
    return-void
.end method

.method public success(ILjava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "accessLevel"    # I
    .param p2, "accessToken"    # Ljava/lang/String;
    .param p3, "formattedDate"    # Ljava/lang/String;

    .prologue
    .line 36
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 37
    .local v0, "result":Landroid/os/Bundle;
    const-string v1, "TOKEN"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 38
    const-string v1, "EXPIRY_DATE"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 40
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager$1;->val$callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    invoke-interface {v1, p1, v0}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;->success(ILandroid/os/Bundle;)V

    .line 41
    return-void
.end method
