.class Lcom/poshmark/ui/customviews/PMTextView$2;
.super Ljava/lang/Object;
.source "PMTextView.java"

# interfaces
.implements Lcom/poshmark/utils/TextClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/customviews/PMTextView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/PMTextView;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/PMTextView;)V
    .locals 0

    .prologue
    .line 48
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMTextView$2;->this$0:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Ljava/lang/String;)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 51
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 52
    .local v1, "uri":Landroid/net/Uri;
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMTextView$2;->this$0:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMTextView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 53
    .local v0, "parentActivity":Lcom/poshmark/ui/PMActivity;
    instance-of v2, v0, Lcom/poshmark/ui/MainActivity;

    if-eqz v2, :cond_0

    .line 54
    check-cast v0, Lcom/poshmark/ui/MainActivity;

    .end local v0    # "parentActivity":Lcom/poshmark/ui/PMActivity;
    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/MainActivity;->handleDeepLinkLaunch(Landroid/net/Uri;Z)V

    .line 56
    :cond_0
    return-void
.end method
