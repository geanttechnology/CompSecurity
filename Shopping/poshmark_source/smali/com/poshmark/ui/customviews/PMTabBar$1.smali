.class Lcom/poshmark/ui/customviews/PMTabBar$1;
.super Ljava/lang/Object;
.source "PMTabBar.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/customviews/PMTabBar;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/PMTabBar;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/PMTabBar;)V
    .locals 0

    .prologue
    .line 37
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMTabBar$1;->this$0:Lcom/poshmark/ui/customviews/PMTabBar;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v4, 0x0

    .line 41
    move-object v1, p1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTabButton;

    .line 42
    .local v1, "tab":Lcom/poshmark/ui/customviews/PMTabButton;
    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMTabButton;->getClickEventString()Ljava/lang/String;

    move-result-object v0

    .line 43
    .local v0, "clickEventString":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 44
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    const-string v3, "app"

    invoke-virtual {v2, v4, v3, v0, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 46
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMTabBar$1;->this$0:Lcom/poshmark/ui/customviews/PMTabBar;

    invoke-virtual {v2, v1}, Lcom/poshmark/ui/customviews/PMTabBar;->setActiveTab(Lcom/poshmark/ui/customviews/PMTabButton;)V

    .line 47
    return-void
.end method
