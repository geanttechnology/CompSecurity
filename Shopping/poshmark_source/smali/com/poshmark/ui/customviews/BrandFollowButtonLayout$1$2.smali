.class Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1$2;
.super Ljava/lang/Object;
.source "BrandFollowButtonLayout.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/poshmark/http/api/PMApiResponseHandler",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;)V
    .locals 0

    .prologue
    .line 100
    iput-object p1, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1$2;->this$1:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 103
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_1

    .line 104
    iget-object v1, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1$2;->this$1:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->brandName:Ljava/lang/String;

    const-string v2, "/"

    const-string v3, "%2F"

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 105
    .local v0, "escapedBrandName":Ljava/lang/String;
    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiRequest:Lcom/poshmark/http/api/PMApiRequest;

    iget-object v1, v1, Lcom/poshmark/http/api/PMApiRequest;->url:Ljava/lang/String;

    invoke-static {v0}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 106
    iget-object v1, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1$2;->this$1:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    const/4 v2, 0x0

    iput-boolean v2, v1, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->isFollowing:Z

    .line 107
    iget-object v1, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1$2;->this$1:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    # invokes: Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setFollowButton()V
    invoke-static {v1}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->access$300(Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;)V

    .line 108
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1$2;->this$1:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;

    iget-object v2, v2, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    iget-object v2, v2, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->brandName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/poshmark/controllers/GlobalDbController;->unFollowBrand(Ljava/lang/String;)V

    .line 109
    iget-object v1, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1$2;->this$1:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    # invokes: Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->fireBrandStatusChangedNotification()V
    invoke-static {v1}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->access$200(Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;)V

    .line 114
    .end local v0    # "escapedBrandName":Ljava/lang/String;
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1$2;->this$1:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    const/4 v2, 0x1

    # invokes: Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setButtonVisibility(Z)V
    invoke-static {v1, v2}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->access$000(Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;Z)V

    .line 115
    return-void

    .line 112
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1$2;->this$1:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    # invokes: Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setFollowingButton()V
    invoke-static {v1}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->access$100(Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;)V

    goto :goto_0
.end method
