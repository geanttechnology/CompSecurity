.class Lcom/poshmark/analytics/Analytics$2;
.super Ljava/lang/Object;
.source "Analytics.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/analytics/Analytics;-><init>()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/analytics/Analytics;


# direct methods
.method constructor <init>(Lcom/poshmark/analytics/Analytics;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lcom/poshmark/analytics/Analytics$2;->this$0:Lcom/poshmark/analytics/Analytics;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleNotification(Landroid/content/Intent;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 74
    iget-object v0, p0, Lcom/poshmark/analytics/Analytics$2;->this$0:Lcom/poshmark/analytics/Analytics;

    # invokes: Lcom/poshmark/analytics/Analytics;->userLoginChanged()V
    invoke-static {v0}, Lcom/poshmark/analytics/Analytics;->access$000(Lcom/poshmark/analytics/Analytics;)V

    .line 75
    return-void
.end method
